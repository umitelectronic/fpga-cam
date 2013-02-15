grammar SystemC;


 // credit to http://www.win.tue.nl/~mousavi/sysc08/
 
options
{
	output = template;
	ASTLabelType = CommonTree;
	backtrack =true;
	memorize = true;
	k = 2;
}
tokens 
{
	MODULE;
	CONSTRUCTOR;
	FUNC_BODY;
	LOOP_BODY;
	CASE_BODY;
	IF_BODY	;
	ELSE_BODY;
	INPORT;
	OUTPORT;
	SIGNAL;
	FUNCTION;
	FIELD;
	LOCAL_VAR;
	TYPE;
	ARRAY;
	CONDITIONAL;
	SWITCH;
	CASE;
	DEFAULT;
	WHILE;
	FOR;
	RETURN;
	SENSITIVE;
	SENSITIVE_POS;
	SENSITIVE_NEG;
	ASSIGNMENT;
	BINARY_OPERATOR;
	UNARY_OPERATOR;
	MEMBER_ACCESS;
	FUNC_CALL;
	ARGUMENTS;
	MAIN;
	ARRAY_ACCESS;
}
@header
{ 
	import java.util.ArrayList;
	import java.util.Hashtable;
}
@lexer::header{ package ir.ac.ut.ece;}

@members
{
	public enum VarType { SC_IN, SC_OUT, SC_SIGNAL, SC_EVENT, USER_DEFINED, PRIMITIVE, ARRAY}
	ArrayList<String> eventNames = new ArrayList<String>();
	ArrayList<String> getEventNames() {return eventNames;}
	ArrayList<String> moduleNames = new ArrayList<String>();
	ArrayList<String> getModuleNames() {return moduleNames;}
	ArrayList<VariableBean> variables = new ArrayList<VariableBean>();
	ArrayList<VariableBean> getVariables() {return variables;}
	ArrayList<PortBean> ports = new ArrayList<PortBean>();
	ArrayList<PortBean> getPorts() {return ports;}
	String getCurModuleName() {return moduleNames.get( moduleNames.size() - 1);}
	String curProcName;
	ArrayList<SensitivePort> sensitivePortNames = new ArrayList<SensitivePort>();
	ArrayList<ProcessBean> procs = new ArrayList<ProcessBean>();
	ArrayList<ProcessBean> getProcs() {return procs;}
	ArrayList<SignalBean> signals = new ArrayList<SignalBean>();
	ArrayList<SignalBean> getSignals() {return signals;}
}

systemc_program
	:	module_declaration *
		main_declaration
	;

module_declaration
	:	'SC_MODULE''(' ID ')' 
		{ moduleNames.add( $ID.text);}
		module_body		
	->	^(MODULE ID module_body)
	|	';'!
	;

module_body
	:	'{' member_declaration* '}'
	->	member_declaration*
	;

member_declaration
	:	func_declaration
	|	field_declaration
	|	'SC_CTOR' '(' ID ')' func_body	
	->	^(CONSTRUCTOR ID func_body)
	;

func_declaration
	:	(type | 'void') ID 
	{ 
		curProcName = getCurModuleName() + "_" + $ID.text;
	}
		func_decl_rest
	->	^(FUNCTION type? ID func_decl_rest)
	;

func_decl_rest
	:	formal_parameters
	(	func_body
	->	^(FUNC_BODY func_body)
	|	';'
	)
	;
	
variableDeclarator[VarType vt, String typeText, int width, boolean unsigned, Scope scope]
	:	(ID 
		{
			switch( vt)
			{
				case SC_SIGNAL:
					signals.add( new SignalBean( $ID.text, $typeText, $width, $unsigned));
					break;
				case SC_EVENT:
					eventNames.add( $ID.text);
					break;
				case PRIMITIVE:
					if( scope == Scope.MODULE) 
					 variables.add( new VariableBean( Scope.MODULE, getCurModuleName(), $ID.getText(), $typeText, $width, $unsigned));
					else 
					 variables.add( new VariableBean( Scope.FUNCTION, curProcName, $ID.getText(), $typeText, $width, $unsigned));
					break;
				case SC_IN:
					ports.add( new PortBean( $ID.text, $typeText, getCurModuleName(), Direction.IN, $width, $unsigned));
					break;
				case SC_OUT:
					ports.add( new PortBean( $ID.text, $typeText, getCurModuleName(), Direction.OUT, $width, $unsigned));
					break;
			}
		}
	->	^(TYPE[$typeText] ID))
        (	
        	(('[' Integer_literal ']') // we support only constant-width arrays!!
		{
			variables.remove( variables.size() - 1);
			if( scope == Scope.MODULE)
			 variables.add( new VariableBean( Scope.MODULE, getCurModuleName(), $ID.getText(), $typeText, $width, $unsigned, Integer.parseInt( $Integer_literal.text)));
			else
			 variables.add( new VariableBean( Scope.FUNCTION, curProcName, $ID.getText(), $typeText, $width, $unsigned, Integer.parseInt( $Integer_literal.text)));
        	}
    	->	^(ARRAY[$typeText] Integer_literal ID))
    	|	(arguments
    	->
        	^(TYPE[$typeText] ID arguments))
        )?
        ;      
	
	
field_declaration
	:	type variableDeclarator[$type.vt,$type.typeText,$type.width,$type.unsigned,Scope.MODULE] 
		(',' variableDeclarator[$type.vt,$type.typeText,$type.width,$type.unsigned,Scope.MODULE])*';'
	->	^(FIELD variableDeclarator+)		
	;


type returns [VarType vt, String typeText, int width, boolean unsigned]
	:	'sc_in' '<' typ = type '>'
		{
			$vt = VarType.SC_IN;
			$typeText = $typ.text;
			$width = $typ.width;
			$unsigned = $typ.unsigned;			
		}
	->	^(INPORT type)
	|	'sc_out' '<' typ = type '>'
		{
			$vt = VarType.SC_OUT;
			$typeText = $typ.text;
			$width = $typ.width;
			$unsigned = $typ.unsigned;					
		}
	->	^(OUTPORT type)
	|	'sc_signal' '<' typ = type '>'
		{
			$vt = VarType.SC_SIGNAL;
			$typeText = $typ.text;
			$width = $typ.width;
			$unsigned = $typ.unsigned;		
		}
	->	^(SIGNAL type)
	|	'sc_clock'
		{
			$vt = VarType.SC_SIGNAL;
			$typeText = "bool";		
		}
	|	'sc_event'
		{
			$vt = VarType.SC_EVENT;
		}
	|	ID
		{
			$vt = VarType.USER_DEFINED;
			$typeText = $ID.text;
		}
	|	pt = primitive_type 
		{
			$vt = VarType.PRIMITIVE;
			$typeText = $pt.text;
			$width = $pt.width;
			$unsigned = $pt.unsigned;
		}	
	;

primitive_type returns [int width, boolean unsigned]
	:	'bool'
	|	'byte'
	|	'int'
		{ $unsigned = false;}
	|	'sc_bv' '<' Integer_literal '>'
		{ 
			$width = Integer.parseInt( $Integer_literal.text);
			$unsigned = false;
		}
	->	'int'
	|	'sc_int' ('<' Integer_literal '>')
		{
			$width = Integer.parseInt( $Integer_literal.text);
			$unsigned = false;			
		}
	->	'int'
	|	'sc_uint' ('<' Integer_literal '>')
		{ 
			$width = Integer.parseInt( $Integer_literal.text);
			$unsigned = true;
		}
	->	'int'
	;	

formal_parameters
	:	'(' (formal_parameter_decl* | 'void') ')'
	->	(formal_parameter_decl)*
	;

formal_parameter_decl
	:	type ID
	;

func_body
	:	block
	;

block
	:	'{' block_statement* '}'	 
	->	(block_statement)*
	;

block_statement
	:	local_var_declaration
	|	statement
	;

local_var_declaration
	:	type vd = variableDeclarator[$type.vt,$type.typeText,$type.width,$type.unsigned,Scope.FUNCTION] 
		(',' variableDeclarator[$type.vt,$type.typeText,$type.width,$type.unsigned,Scope.FUNCTION])*';'
	->	^(LOCAL_VAR variableDeclarator+)
	;

statement
	:	block
	|	'if' par_expression st1 = statement (options {k=1;}:'else' st2 = statement)?
	->	^(CONDITIONAL par_expression ^(IF_BODY $st1) ^(ELSE_BODY $st2)?)
	|	'switch' par_expression '{' switchBlockStatementGroups '}'
	->	^(SWITCH par_expression switchBlockStatementGroups)
	|	'while' par_expression statement
	->	^(WHILE par_expression ^(LOOP_BODY statement))
	|	'for' '(' ID '=' start = Integer_literal ';' ID '<' top = Integer_literal';' ID '++' ')' statement
		// we have considered only a pascal-like for
		// they can modeled directly by the mCRL2 sum operator
	->	^(FOR ID $start $top ^(LOOP_BODY statement))
	|	'return' expression? ';'
	->	^(RETURN expression?)
	|	'break' ';'
	->
	|	'sensitive' 
		{ sensitivePortNames.clear();}
		('<<' ID
		{ sensitivePortNames.add( new SensitivePort( SENSITIVITY_TYPE.BOTH, $ID.text));}
		)+ ';'
		{ procs.get( procs.size() - 1).addSensitiveList( sensitivePortNames);}
	->	^(SENSITIVE ID+)
	|	'sensitive_pos'
		{ sensitivePortNames.clear();}
		('<<' ID
		{ sensitivePortNames.add( new SensitivePort( SENSITIVITY_TYPE.POSEDGE, $ID.text));}
		)+ ';'
		{ procs.get( procs.size() - 1).addSensitiveList( sensitivePortNames);}
	->	^(SENSITIVE_POS ID+)
	|	'sensitive_neg'
		{ sensitivePortNames.clear();}
		('<<' ID
		{ sensitivePortNames.add( new SensitivePort( SENSITIVITY_TYPE.NEGEDGE, $ID.text));}
		)+ ';'
		{ procs.get( procs.size() - 1).addSensitiveList( sensitivePortNames);}
	->	^(SENSITIVE_POS ID+)	
	|	';' ->
	|	expression ';' -> expression
	;

switchBlockStatementGroups
	:	(switchBlockStatementGroup)*
	;
	
switchBlockStatementGroup
	:	switchLabel block_statement*
	->	switchLabel ^(CASE_BODY block_statement*)
	;
	
switchLabel
	:	'case' expression ':'
	->	^(CASE expression)
	|	'default' ':'
	->	^(DEFAULT)
	;

// ~~~~~~~~~~~~~~~~~~~~~~  EXPRESSION  ~~~~~~~~~~~~~~~~~~~~~~

par_expression
	:	'(' expression ')'
	->	expression
	;

expression
	:	(conditionalOrExpression -> conditionalOrExpression)
		(('=' expression) ->
		^(ASSIGNMENT conditionalOrExpression expression))?
	;

expressionList
	:	expression (',' expression)*
	->	expression +
	;

conditionalOrExpression
	:	(op1 = conditionalAndExpression -> conditionalAndExpression)
		(('||' op2 = conditionalAndExpression) ->
		^(BINARY_OPERATOR["||"] $op1 $op2))*
	;

conditionalAndExpression
	:	(op1 = inclusiveOrExpression -> inclusiveOrExpression)
		(('&&' op2 = inclusiveOrExpression) ->
		^(BINARY_OPERATOR["&&"] $op1 $op2))*
	;

inclusiveOrExpression
	:	(op1 = exclusiveOrExpression -> exclusiveOrExpression)
		(('|' op2 = exclusiveOrExpression) ->
		^(BINARY_OPERATOR["|"] $op1 $op2))*
	;

exclusiveOrExpression
	:	(op1 = andExpression -> andExpression)
		(( '^' op2 = andExpression) ->
		^(BINARY_OPERATOR["^"] $op1 $op2))*
	;

andExpression
	:	(op1 = equalityExpression -> equalityExpression)
		(( '&' op2 = equalityExpression) ->
		^(BINARY_OPERATOR["&"] $op1 $op2))*
	;

equalityExpression
	:	(op1 = relationalExpression -> relationalExpression)
		(
			(('==' op2 = relationalExpression) -> ^(BINARY_OPERATOR["=="] $op1 $op2))*
		|
			(('!=' op2 = relationalExpression) -> ^(BINARY_OPERATOR["!="] $op1 $op2))*		
		)
	;

relationalExpression
	:	(op1 = shiftExpression -> shiftExpression)
		((opt = relationalOp op2 = shiftExpression) ->
		^(BINARY_OPERATOR[$opt.text] $op1 $op2))*
	;

relationalOp
	:	('<' '=' | '>' '=' | '<' | '>')
	;
	
shiftExpression
	:	(op1 = additiveExpression -> additiveExpression)
		((opt = shiftOp op2 = additiveExpression) ->
		^(BINARY_OPERATOR[$opt.text] $op1 $op2))*
	;
	
shiftOp
	:	('<<' | '>>')
	;

additiveExpression
	:	(op1 = multiplicativeExpression -> multiplicativeExpression)
		(
			(('+' op2 = multiplicativeExpression) -> ^(BINARY_OPERATOR["+"] $op1 $op2))*		
		|
			(('-' op2 = multiplicativeExpression) -> ^(BINARY_OPERATOR["-"] $op1 $op2))*		
		)
	;

multiplicativeExpression
	:	(op1 = unaryExpression -> unaryExpression)
		(
			(('*' op2 = unaryExpression) -> ^(BINARY_OPERATOR["*"] $op1 $op2))*
		|
			(('/' op2 = unaryExpression) -> ^(BINARY_OPERATOR["/"] $op1 $op2))*
		|
			(('%' op2 = unaryExpression) -> ^(BINARY_OPERATOR["\%"] $op1 $op2))*
		)
	;

unaryExpression
	:	'+' unaryExpression	->	^(UNARY_OPERATOR["+"] unaryExpression)
	|	'-' unaryExpression	->	^(UNARY_OPERATOR["-"] unaryExpression)
	|	'!' unaryExpression	->	^(UNARY_OPERATOR["!"] unaryExpression)
	|	primary			->	primary
	;
   
primary
	:	par_expression
	|	literal
	|	'SC_THREAD' arguments
		{ procs.add( new ProcessBean( PROC_TYPE.SC_THREAD, getCurModuleName() + "_" + $arguments.argumentText, getCurModuleName()));}
	|	'SC_METHOD' arguments
		{ procs.add( new ProcessBean( PROC_TYPE.SC_METHOD, getCurModuleName() + "_" + $arguments.argumentText, getCurModuleName()));}		
	|	(ID1 = ID -> ID)
		('.' ID2 = ID arguments? -> ^(MEMBER_ACCESS $ID1 $ID2 arguments?))*
	(
		(arguments -> ^(FUNC_CALL $ID1 arguments))
	|	('[' expression ']' -> ^(ARRAY_ACCESS $ID1 expression))
	)?
	;


// argumentText is used in extracting the process names
arguments returns [String argumentText]
	:	'(' (expressionList{ $argumentText = $expressionList.text; })? ')'
	->	^(ARGUMENTS expressionList)?
	;

literal
	:	Integer_literal
	|	Boolean_literal
	|	StringLiteral
	;


main_declaration
	:	'int' 'sc_main' '(' 'int' 'argc' ',' 'char' '*' 'argv[]' ')'
		func_body
	->
		^(MAIN func_body)
	;

// ~~~~~~~~~~~~~~~~~~~~~~  LEXER  ~~~~~~~~~~~~~~~~~~~~~~


Integer_literal
	:	DIGIT+
	|	'0x' (DIGIT | LETTER)+
	{
		{this.setText( String.valueOf( Integer.parseInt( this.getText().replaceFirst( "0x", ""), 16)));}
	}
	;
	
Boolean_literal
	:	'true'
	|	'false'
	;

StringLiteral
    :  '"' ( ~('\\'|'"') )* '"'
    ;

fragment
LETTER
	:	'a'..'z' | 'A'..'Z'
	;

fragment
DIGIT	:	'0'..'9'
	;
	
ID	:	LETTER (LETTER | DIGIT | '_')*
		{this.setText("sm_" + this.getText());}
	;

WS  :  (' '|'\r'|'\t'|'\u000C'|'\n') {$channel=HIDDEN;}
    ;

COMMENT
    :   '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;}
    ;

LINE_COMMENT
    : '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;}
    ;

// ignore #line info for now
LINE_COMMAND 
    : '#' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;}
    ;
