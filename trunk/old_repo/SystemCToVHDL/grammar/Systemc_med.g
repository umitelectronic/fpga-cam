grammar Systemc_med;

options {
output=template;
}

scope slist {
    List names; 
    List stack;
}



@header {
import org.antlr.stringtemplate.*;
}


cfile
scope {
      HashMap functions;
      HashMap vars;
}
@init {
  $cfile::functions = new HashMap();
  $cfile::vars = new HashMap();
}
	:
	 pre_processor+
	 declarations[$cfile::vars] *
	 module_decl SEMICOLON
	 declarations[$cfile::vars]*
	 pre_processor+
	-> file(entity = {$module_decl.st})
	;

pre_processor	: includes 
	| define
	| '#endif'
	;

includes	: '#include' STRING_LITERAL
	;

define	: ('#define '|'#ifndef ') ID (INT*ID)?
	;
endif	: '#endif '
	;

module_decl
scope {
  List ports;
  List signals;
  HashMap processes;
  List enums;
  HashMap connections;
  HashMap obj_type;
  HashMap mod_type;
}
@init {
  $module_decl::ports = new ArrayList();
  $module_decl::processes = new HashMap();
  $module_decl::signals = new ArrayList();
  $module_decl::enums = new ArrayList();
  $module_decl::connections = new HashMap();
  $module_decl::obj_type = new HashMap();
  $module_decl::mod_type = new HashMap();
}
    :   'SC_MODULE' '(' ID ')' '{'
        module_body
        '}'
        -> entity(name = {$ID.text}, 
        ports= {$module_decl::ports},
        signals =  {$module_decl::signals}, 
        enums = {$module_decl::enums}, 
        variables = {$module_decl::obj_type}, 
        process =  {$module_decl::processes}, 
        structure = { $module_decl::connections},
        instances = {$module_decl::mod_type},
        functions ={$cfile::functions} )
    ;


module_body 
	: declarations[$module_decl::mod_type]+
	;
	
declarations	[HashMap vars]
	:
	(port_decl SEMICOLON  {  $module_decl::ports.add($port_decl.st);}
	| signal_dec SEMICOLON {  $module_decl::signals.add($signal_dec.st);}
	| enum_decl SEMICOLON {  $module_decl::enums.add($enum_decl.st);}
	| variable_decl[$vars] SEMICOLON
	| func_decl SEMICOLON?
	| actor)
	;
	

func_decl	:
	((v_type (class_name=ID'::')?)func=ID('('((v_type ID (','v_type ID)*)?)')') )(func_body)?  { $cfile::functions.put($func.text, $func_body.st);}
	;

enum_decl
scope slist;
@init {
  $slist::names = new ArrayList();
}
	:

	'enum' ID '{' name (',' name)* '}' -> enum(name = {$ID.text}, members={$slist::names})
	;

variable_decl [HashMap vars]:
	v_type { $vars.put($v_type.text, new ArrayList());} ('*'|'[]')* n=ID { ((List) $vars.get($v_type.text)).add($n.text);}  (',' elt=ID { ((List) $vars.get($v_type.text)).add($elt.text);})* fixed_size_array* assignement? 
	;	
	
fixed_size_array	: ('['INT']')
		;

assignement	:
	'=' (INT |array_of_value | FLOAT |  STRING_LITERAL)
	;
	
array_of_value	: '{'(INT |array_of_value | FLOAT) (',' (INT |array_of_value | FLOAT))*'}'
	;


v_type	: ((v_signed_modifier? v_size_modifier?  'int')|((v_signed_modifier)? 'char')|'float'|'void'|('struct' ID)| sc_type |ID otemplate?)
	;
v_size_modifier	:( 'short' | 'long')+
	;
v_signed_modifier	: 'unsigned'
	;
otemplate	:	'<' (ID|INT) (',' (ID|INT))*'>'	
	;

actor	:'SC_CTOR''('ID')'  (':' actor_inst(','actor_inst)*)?'{' (actor_body) '}'

	;

actor_inst
	:ID'('STRING_LITERAL')'  {	$module_decl::mod_type.put($ID.text, $module_decl::obj_type.get($ID.text));
			 $module_decl::obj_type.remove($ID.text);
			}
	;

connection	: component=ID'.'link	{if($module_decl::connections.get($component.text) == null){
				$module_decl::connections.put($component.text,  new ArrayList()) ;
			}
 			((ArrayList) $module_decl::connections.get($component.text)).add($link.st);
 			}
	;

link	:port=ID'('signal=ID')' -> link(source = {$port.text} , dest ={$signal.text} )
	;

sensitive
	: 'sensitive' '<<' ID ('.'method)* {$slist::names.add($ID.text);}
	;

method	
scope slist;
@init {
  $slist::stack = new ArrayList();
}
:
	ID'('(func_arg(','arg=func_arg {$slist::stack.add($arg.st);})*)?')' -> method(name={$ID.text}, args = {$slist::stack})
	;

func_arg	:(value {$slist::stack.add($value.st);})
	;
actor_method	returns [String  name]
scope slist;
@init {
  $slist::names = new ArrayList();
  $name = new String();
}
: 	
	actor_method_decl SEMICOLON{$name = $actor_method_decl.name ;}
	(sensitive SEMICOLON)+ -> process(sensitive = {$slist::names}, name={$actor_method_decl.name}) 
	;

actor_method_decl returns [String  name]
	:
	'SC_METHOD('n = ID')' {$name = $n.text ;}
	;

actor_body	: (actor_body_elt)+
	;
	

actor_body_elt
	:
	(meth=actor_method {$module_decl::processes.put($meth.name, $actor_method.st);}
	| (func_call SEMICOLON)
	|(connection SEMICOLON)) 
	;

signal_dec
scope slist;
@init {
  $slist::names = new ArrayList();
}:
	((sc_signal) name (','name )* fixed_size_array*)  -> signal(name = {$slist::names}, type={$sc_signal.st})
	;


	
sc_signal	:
	('sc_signal'('_rv')?'<'  signal_type  '>')  ->dummy(val={$signal_type.st})
	;

signal_type	:
	 sc_type ->{ $sc_type.st}
	 | ID -> dummy(val={$ID.text})
	;
	
func_call	
scope slist;
@init {
  $slist::stack = new ArrayList();
}
:
	(ID) '('(func_arg (',' func_arg)*)?')' -> func_call(name = {$ID.text}, args = {$slist::stack} )
	;

port_decl
scope slist;
@init {
  $slist::names = new ArrayList();
}:
	port_type name (',' name )* -> port(name={$slist::names}, type = {$port_type.st})
	;


name
	:
	ID {$slist::names.add($ID.text);}
	;

port_type	:
	 sc_clock -> clock_type()
	|sc_in -> input_type(type={$sc_in.st})
	|sc_out -> output_type(type={$sc_out.st})
	|sc_inout ->inout_type(type={$sc_inout.st})
	;
	

sc_inout	:
	'sc_inout'(LT (sc_type) GT)  ->dummy(val={$sc_type.st})
	| 'sc_inout_resolved'   -> logic()
	| 'sc_inout_rv'(LT (INT) GT)  -> logic_vector(size={$INT.text})
	;
	
	
sc_out	:
	'sc_out' (LT (sc_type)  GT) ->dummy(val={$sc_type.st})
	| 'sc_out_resolved'  ->  logic()
	| 'sc_out_rv'(LT  (INT) GT)  -> logic_vector(size={$INT.text})
	;

sc_in	:
	'sc_in'(LT (sc_type)  GT) ->dummy(val={$sc_type.st})
	| 'sc_in_resolved'  ->  logic()
	| 'sc_in_rv'(LT ( INT) GT)  -> logic_vector(size={$INT.text})
	;

sc_clock	:
	'sc_in_clk'
	;


func_body
	:
	block -> func_body(declarations =  {$block.vars}, operations = {$block.elts})
	;

block	returns [List  elts, HashMap vars]
@init {
  $elts = new ArrayList();
  $vars = new HashMap();
}
:

	'{'
	(variable_decl[$vars] SEMICOLON
	|sc_assignement SEMICOLON{ $elts.add($sc_assignement.st);}
	|v_assignement SEMICOLON{ $elts.add($v_assignement.st);}
	|cconstruct  { $elts.add($cconstruct.st);}
	|func_call SEMICOLON
	| flux SEMICOLON)*
	'}'	
	;

cconstruct
	:
	case_construct ->dummy(val = {$case_construct.st})
	|if_construct ->dummy(val = {$if_construct.st})
	;

if_construct
scope slist;
@init {
  $slist::stack = new ArrayList();
}
	:
	'if'cond ( if_content)
	(elsif_construct { $slist::stack.add($elsif_construct.st);})*  -> if_construct(condition = {$cond.st}, elts = {$if_content.content}, alternatives = { $slist::stack})
	;
	
elsif_construct
	:
	'else' 
	('if'cond (ifc = if_content) ->elsif_construct(condition = {$cond.st}, elts = {$ifc.content})
	|elsec = if_content ->else_construct(elts = {$elsec.content})
	)
	
	;

if_content	returns [List content]
@init {
  $content = new ArrayList();
}
:
	(v_assignement) SEMICOLON {$content.add($v_assignement.st);}
	| block  {$content.addAll($block.elts);} 
	;

cond	
scope {
List vals ;
List ops ;
}
@init {
  $cond::vals = new ArrayList();
  $cond::ops = new ArrayList();
}
	:
	'('t1 = test {$cond::vals.add($t1.st);} ( logic_op  {$cond::ops.add($logic_op.st);}  t2 = test {$cond::vals.add($t2.st);})*')' -> conditions(vals = {$cond::vals}, ops = {$cond::ops})
	;

test	:
	not =( NOT)?  l = value( op =comp_op r = value)?  -> test(neg = {$not.text},  l = {$l.st}, r = {$r.st}, operand = {$op.text})
	;

	
comp_op	:
	(LT | GT | NOT | '=')('=')?
	;
logic_op	:
	'&&'  -> vhdl_and()
	| '||'  -> vhdl_or()
	;
case_construct
scope {
List cases ;
}
@init {
  $case_construct::cases = new ArrayList();
}
	:
	'switch''('value')''{'
	(case_elt  {   $case_construct::cases.add($case_elt.st);})*
	'}' -> switch(cases = {$case_construct::cases}, var = {$value.st})
	;

case_elt
scope {
List cont ;
}
@init {
  $case_elt::cont = new ArrayList();
}
	:
	('case' (ID) | 'default') ':' 
	(v_assignement SEMICOLON{  $case_elt::cont.add($v_assignement.st);}
	|sc_assignement SEMICOLON{  $case_elt::cont.add($sc_assignement.st);}
	|if_construct { $case_elt::cont.add($if_construct.st);}
	|func_call SEMICOLON{  $case_elt::cont.add($func_call.st);}
	|block SEMICOLON{  $case_elt::cont.addAll($block.elts);}
	|flux SEMICOLON
	)*
	('break' SEMICOLON)? -> case(val = {$ID.text}, cont = {$case_elt::cont})
	;

flux	:(ID'::')?ID '<<' value ('<<'  value)*
 	;
 	

v_assignement
	:
	ID EQUAL assignement_value  -> var_assign(var = {$ID.text}, val ={$assignement_value.st} )
	;

sc_assignement
	:
	ID'.write('assignement_value')' -> signal_assignement(dest = {$ID.text}, source = {$assignement_value.st})
	;

assignement_value
	:
	  value  ( OP ass = assignement_value )?  ->  expression(head ={$value.st}, op ={$OP.text}, tail = {$ass.st})
	;

value	:
	 HEX  ->  dummy(val ={ $HEX.text})
	 |BIN  ->  dummy(val ={ $BIN.text})
	 |INT  ->  dummy(val ={ $INT.text})
	 |STRING_LITERAL   ->  dummy(val ={ $STRING_LITERAL.text})  //vector
	 |var_value ->  dummy(val = {$var_value.st})
	 |func_call ->  dummy(val= {$func_call.st})
	 |sc_method ->  dummy(val= {$sc_method.st})
	;
	
var_value	:

	(var_name) var_comp*  -> var_value(var = {$var_name.st},  methods = {$var_comp.st})
	;

var_comp	:
	('.'
	((sc_method) -> dummy(val = {$sc_method.st})
	| ( method)) -> dummy(val = {$method.st})
	)
	| ('['value']') -> array_value( index = {$value.st})
	;	

var_name
	:
	ID -> dummy(val = {$ID.text})
	;



sc_type	:
	'sc_lv'(LT INT GT) -> logic_vector(size={$INT.text})
	| 'sc_uint' (LT INT GT) -> logic_vector(size={$INT.text})
	| 'sc_logic' -> logic()
	| 'bool' -> logic()
	;
//LEXER

sc_method	:
	'range('from = INT ',' to = INT')' -> range(from = {$from.text}, to = {$to.text})
	|'concat('  left = value  ',' right= value ')'-> concat(left = {$left.st}, right = {$right.st})
	| 'read()'
	|'('  left = value  ',' right= value')'-> concat(left = {$left.st}, right = {$right.st})
	;

ID  :   ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*
    ;

INT	:	('0'..'9')+
	;
FLOAT	:	INT+('.')INT+
	;

WS  :   (' ' | '\t' | '\r' | '\n')+ {$channel=HIDDEN;}
    ;

STRING_LITERAL	:   '"' ( ~('\\'|'"') )* '"'
    ;

COMMENT
	:	'/*' (options {greedy=false;} : .)* '*/' {$channel=HIDDEN;}
		
	;
	
SINGLE_LINE_COMMENT
	:	
		'//' (~('\n' | '\r'))* { $channel=HIDDEN;}                     
	;

HEX	:
	'0x'(('0'..'9')|'a'..'f'| 'A..F')+
	;
	   
BIN	:
	'0b'('0'|'1')+
	; 
OP	:
	('+' | '-' | '*' | '/ '| '%')
	;
	
GT	:'>'
	;
	
LT	:'<'
	;	

EQUAL	:'='
	;
SEMICOLON	:';'
	;
NOT	:'!'
	;