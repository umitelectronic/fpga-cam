grammar Systemc_basic;

options {
output=template;
}

scope slist {
    List names; 
    List stack;
}

@lexer::header{
import java.io.File ;
}

@lexer::members {
    class SaveStruct {
      SaveStruct(CharStream input){
        this.input = input;
        this.marker = input.mark();
      }
      public CharStream input;
      public int marker;
     }
 
     Stack<SaveStruct> includes = new Stack<SaveStruct>();
 
    // We should override this method for handling EOF of included file
     public Token nextToken(){
       Token token = super.nextToken();
 
       if(token.getType() == Token.EOF && !includes.empty()){
        // We've got EOF and have non empty stack.
         SaveStruct ss = includes.pop();
         setCharStream(ss.input);
         input.rewind(ss.marker);
         //this should be used instead of super [like below] to handle exits from nested includes
         //it matters, when the 'include' token is the last in previous stream (using super, lexer 'crashes' returning EOF token)
         token = this.nextToken();
       }
 
      // Skip first token after switching on another input.
      // You need to use this rather than super as there may be nested include files
       if(((CommonToken)token).getStartIndex() < 0)
         token = this.nextToken();
 
       return token;
     }
 }

@header {
import org.antlr.stringtemplate.*;

}


cfile
scope {
      HashMap functions;
      HashMap vars;
      HashMap type_obj;
      List constants ;
      List typeDecl ;
       
}
@init {
  $cfile::functions = new HashMap();
  $cfile::vars = new HashMap();
   $cfile::type_obj = new HashMap();
   $cfile::constants = new ArrayList();
   $cfile::typeDecl = new ArrayList();
}
	:
	 pre_processor*
	 declarations[$cfile::vars, null, null,$cfile::typeDecl] *
	 module_decl SEMICOLON
	 (pre_processor
	|declarations[$cfile::vars, null, null,$cfile::typeDecl])*
	-> file(entity = {$module_decl.st})
	;

pre_processor	: '#'(INCLUDE 
	| define { $cfile::constants.add($define.st);}
	|IFNDEF
	| 'endif')
	;
define	:	
	 'define' (WS)? (id = ID)  (WS)? (
	 STRING_LITERAL 
	 | HEX -> hex_constant( name = {$id.text}, val = {$HEX.text.substring(2)}, size = {$HEX.text.substring(2).length()*4})
	 | INT -> int_constant( name = {$id.text}, val = {$INT.text})
	 )?
	;

module_decl
scope {
  List ports;
  List signals;
  HashMap processes;
  HashMap connections;
  HashMap obj_type;
   HashMap type_obj;
  HashMap mod_type;
}
@init {
  $module_decl::ports = new ArrayList();
  $module_decl::processes = new HashMap();
  $module_decl::signals = new ArrayList();
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
        type_decl = {$cfile::typeDecl}, 
        variables = {$module_decl::obj_type}, 
        process =  {$module_decl::processes}, 
        structure = { $module_decl::connections},
        instances = {$module_decl::mod_type},
        functions ={$cfile::functions},
        constants = {$cfile::constants}
        )
    ;


module_body 
	: declarations[$module_decl::obj_type,  $module_decl::ports, $module_decl::signals, $cfile::typeDecl]+
	;
	
declarations	[HashMap vars, List ports, List signals, List typeDecl]
	:
	(port_decl SEMICOLON  {  $ports.add($port_decl.st);}
	| signal_dec SEMICOLON {  $signals.add($signal_dec.st);}
	| enum_decl SEMICOLON {  $typeDecl.add($enum_decl.st);}
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
	v_type { $vars.put($v_type.text, new ArrayList());}
	 ('*'|'[]')* 
	 n=ID { ((List) $vars.get($v_type.text)).add($n.text);  
	 $cfile::type_obj.put($n.text, $v_type.text);}  
	 (',' elt=ID { ((List) $vars.get($v_type.text)).add($elt.text);
	$cfile::type_obj.put($elt.text, $v_type.text); })* fixed_size_array* assignement? 
	;	
	
fixed_size_array returns [int size]
:
 ('['INT']'{$size = Integer.valueOf($INT.text);})
		;

assignement	:
	'=' value
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

actor	:'SC_CTOR''('ID')'  (':' actor_inst[$module_decl::mod_type, $module_decl::obj_type](','actor_inst[$module_decl::mod_type, $module_decl::obj_type])*)?'{' (actor_body) '}'

	;

actor_inst [HashMap mod_type, HashMap obj_type]
	:(type = ID)? actorName=ID'('STRING_LITERAL')'  {
			if($type == null){
			  $mod_type.put($actorName.text, $cfile::type_obj.get($actorName.text));
			  $obj_type.remove($cfile::type_obj.get($actorName.text));
			  $cfile::type_obj.remove($actorName.text);
			}else{
			  $mod_type.put($actorName.text, $type.text);
			}
			}
	;

connection	[HashMap  connections]: component=ID'.'link	{if($connections.get($component.text) == null){
				$connections.put($component.text,  new ArrayList()) ;
			}
 			((ArrayList) $connections.get($component.text)).add($link.st);
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
	|(connection[$module_decl::connections] SEMICOLON)) 
	;

signal_dec returns [Object type]
scope slist;
@init {
  $slist::names = new ArrayList();
  $type = new String();
}:
	((sc_signal) {$type = $sc_signal.st ;} name (','name )* 
	(fixed_size_array {
	String typeName = "array_"+$fixed_size_array.size;
	STAttrMap attrMap = new STAttrMap();
	attrMap.put("name", typeName );
	attrMap.put("size", $fixed_size_array.size );
	attrMap.put("type", $type);
	$cfile::typeDecl.add(templateLib.getInstanceOf("array_type_decl",attrMap));
	$type = typeName;
	})
	*) 
	{SignalAssignementConversion.getInstance().registerType($slist::names, $sc_signal.st.toString());}  -> signal(name = {$slist::names}, type={$type})
	;


	
sc_signal	:
	('sc_signal'('_rv')?ctemplate )  ->dummy(val={$ctemplate.st})
	;
	
ctemplate 
	:	LT(signal_type)GT ->dummy(val={$signal_type.st})
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
	(ID)'('(func_arg (',' func_arg)*)?')' -> func_call(name = {$ID.text}, args = {$slist::stack} )
	;

port_decl
scope slist;
@init {
  $slist::names = new ArrayList();
}:
	port_type name (',' name )*{SignalAssignementConversion.getInstance().registerType($slist::names, $port_type.st.toString());} -> port(name={$slist::names}, type = {$port_type.st})
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
	'sc_inout'(ctemplate)  ->dummy(val={$ctemplate.st})
	| 'sc_inout_resolved'   -> logic()
	| 'sc_inout_rv'(ctemplate)  -> logic_vector(size={$ctemplate.text})
	;
	
	
sc_out	:
	'sc_out' (ctemplate) ->dummy(val={$ctemplate.st})
	| 'sc_out_resolved'  ->  logic()
	| 'sc_out_rv'(ctemplate)  -> logic_vector(size={$ctemplate.text})
	;

sc_in	:
	'sc_in'(ctemplate) ->dummy(val={$ctemplate.st})
	| 'sc_in_resolved'  ->  logic()
	| 'sc_in_rv'(ctemplate)  -> logic_vector(size={$ctemplate.text})
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
	|while_construct 
	;

while_construct
	:
	'while''('cond ')'( if_content)
	;


if_construct
scope slist;
@init {
  $slist::stack = new ArrayList();
}
	:
	'if''('cond ')'( if_content)
	(elsif_construct { $slist::stack.add($elsif_construct.st);})*  -> if_construct(condition = {$cond.st}, elts = {$if_content.content}, alternatives = { $slist::stack})
	;
	
elsif_construct
	:
	'else' 
	('if''('cond ')' (ifc = if_content) ->elsif_construct(condition = {$cond.st}, elts = {$ifc.content})
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
	 //t1 = test {$cond::vals.add($t1.st);} ( logic_op  {$cond::ops.add($logic_op.st);}  t2 = test {$cond::vals.add($t2.st);})*-> conditions(vals = {$cond::vals}, ops = {$cond::ops})
	 test_express  -> dummy(val = {$test_express.st})
	;

/*
test_express
options{backtrack = true;}
scope {
List vals ;
List ops ;
}
@init {
  $test_express::vals = new ArrayList();
  $test_express::ops = new ArrayList();
}
: 

	
	( test  {$test_express::vals.add($test.st);})  (expr_right[$test_express::vals, $test_express::ops])* ->  conditions(vals = {$test_express::vals}, ops = {$test_express::ops})
	| enclosed_expr  -> dummy(val = {$enclosed_expr.st})
	;
*/
	
	
test_express

options{backtrack = true;}
scope {
List vals ;
List ops ;
}
@init {
  $test_express::vals = new ArrayList();
  $test_express::ops = new ArrayList();
}
: 
	expression {$test_express::vals.add($expression.st) ;}
	(logic_op {$test_express::ops.add($logic_op.st) ;} tx = test_express {$test_express::vals.add($tx.st) ;})? ->  conditions(vals = {$test_express::vals}, ops = {$test_express::ops})
	;

enclosed_expr	:
	'('  expr = test_express   ')' -> enclosed(val = {$expr.st})
	;	

expression	
options{backtrack = true;}
:
 	 ((NOT)? enclosed_expr) -> dummy(val = {$enclosed_expr.st})
 	| (test) -> dummy(val = {$test.st})
	;


test	: 
	 l = value( op =comp_op r = value)?  -> test( l = {$l.st}, r = {$r.st}, operator = {$op.text})
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
scope {
StringTemplate var ;
}
	:
	ID{$sc_assignement::var = templateLib.getInstanceOf("dummy",new STAttrMap().put("val", $ID.text));}(array_index[$sc_assignement::var]{$sc_assignement::var=$array_index.st;})?'.write('assignement_value')' -> signal_assignement(dest = {$sc_assignement::var}, source = {SignalAssignementConversion.getInstance().getAssignementValue($ID.text, $assignement_value.st.toString())})
	;

assignement_value
	:
	  h=value  (OP t=value)? ->   expression (head ={$h.st}, op ={$OP.text}, tail = {$t.st})
	;

value	
:
	 HEX  ->  hex(val ={ $HEX.text.substring(2)})
	 |BIN  ->  bin(val ={ $BIN.text.substring(2)})
	 |INT  ->  dummy(val ={ $INT.text})
	 |STRING_LITERAL   ->  dummy(val ={ $STRING_LITERAL.text})  //vector
	 |scconstructor -> dummy(val= {$scconstructor.st})
	 |func_call ->  dummy(val= {$func_call.st})
	 |h=var_value   -> dummy (val ={$h.st})
	 |sc_method[null] ->  dummy(val= {$sc_method.st})
	;

scconstructor
	:	
	sc_type'('value')' -> dummy(val = {$value.st})
	;
	
/*	
var_value	
scope {
List methods ;
String varName ;
}
@init {
  $var_value::methods = new ArrayList();
}
:
	(NOT)?  (var_name {$var_value::varName = $var_name.st.toString();}) (var_comp[$var_name.st] {$var_value::methods.add($var_comp.st);})*  -> var_value(not = {$NOT.text}, var = {$var_name.st},  methods = {$var_value::methods})
	;

var_comp[String varName]	:
	(('.'
	((fmethod = sc_method[$varName) -> dummy(val = {$sc_method.st})
	| ( method) -> dummy(val = {$method.st})
	) 
	)
	| ('['value']') -> array_value( index = {$value.st})) 
	;	
*/

var_value	
scope {
StringTemplate val ;
}
:
	(NOT)?  (var_name {$var_value::val = $var_name.st;}) (var_comp[$var_value::val] {$var_value::val = $var_comp.st;})?  -> var_value(not = {$NOT.text}, var = {$var_value::val})
	;


var_comp  [StringTemplate attTemplate]:
	(('.'
	(( sc_method[$attTemplate] {$attTemplate = $sc_method.st ; })
	| (method {$attTemplate = $method.st ; })
	) 
	)
	| (array_index [$attTemplate]{$attTemplate = $array_index.st ;}) 
	) (vcomp = var_comp[$attTemplate] {$attTemplate = $vcomp.st ;})? -> dummy(val = {$attTemplate})
	;	

array_index [StringTemplate attTemplate]
	:
	'['value']'  -> array_value( var = {$attTemplate}, index = {$value.st})
	;
	
var_name
	:
	ID -> dummy(val = {$ID.text.trim()})
	;



sc_type	:
	'sc_lv'(LT INT GT) -> logic_vector(size={$INT.text})
	| 'sc_uint' (LT INT GT) -> logic_vector(size={$INT.text})
	| 'sc_logic' -> logic()
	| 'bool' -> bool()
	;
/*
main	
scope {
  List signals;
  HashMap processes;
  HashMap connections;
  HashMap obj_type;
   HashMap type_obj;
  HashMap mod_type;
}
@init {
  $main::ports = new ArrayList();
  $main::processes = new HashMap();
  $main::signals = new ArrayList();
  $main::connections = new HashMap();
  $main::obj_type = new HashMap();
  $main::mod_type = new HashMap();
}
:	
	'int sc_main(int argc, char* argv[]) {'
	 (
	 declarations[$main::obj_type, null, $main::signals, , $cfile::typeDecl]
	 |actor_inst[ mod_type, obj_type]
	 |connection[$main::connections]
	 )*
	'}' ->  entity(name = {this.getSourceName()}, connections = {$main::connections})
	;
*/

/*
sc_method[String signalName]
:
	'range('from = INT ',' to = INT')' -> range(from = {$from.text}, to = {$to.text})
	|'concat('  left = value  ',' right= value ')'-> concat(left = {$left.st}, right = {$right.st})
	| 'read()' -> dummy()
	| 'posedge()' -> posedge(signal = {$signalName})
	| 'negedge()' -> negedge(signal = {$signalName})
	|'('  left = value ',' right= value')'-> concat(left = {$left.st}, right = {$right.st})
	;

*/



sc_method[StringTemplate signalSt]
:
	'range('from = INT ',' to = INT')' -> range(sc = {$signalSt}, from = {$from.text}, to = {$to.text})
	|'concat('  left = value  ',' right= value ')'-> concat(left = {$left.st}, right = {$right.st})
	| 'read()' -> dummy(val = {$signalSt})
	| 'posedge()' -> posedge(signal = {$signalSt})
	| 'negedge()' -> negedge(signal = {$signalSt})
	| 'to_int()' -> integer_conv(signal = {$signalSt})
	| 'to_uint()' ->uinteger_conv(signal = {$signalSt})
	|'('  left = value ',' right= value')'-> concat(left = {$left.st}, right = {$right.st})
	;
	
//LEXER

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
	'0x'(('0'..'9')|('a'..'f')|( 'A'..'F'))+
	;
	   
BIN	:
	'0b'('0'|'1')+
	; 
OP	:
	('+' | '-' | '*' | '/ '| '%' | '<<' | '>>')
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
	

INCLUDE
     : 'include' (WS)? f=STRING_LITERAL {
       String name = f.getText();
       name = name.substring(1,name.length()-1);
        File parentFile = new File(this.getSourceName());
        String parentName = parentFile.getName();
        parentName = parentName.substring(0, parentName.lastIndexOf('.'));
         File includeFile ;
       try {
           includeFile = new File(parentFile.getParent()+File.separator+name);
          if(includeFile.exists()){
            String includeName = includeFile.getName();
           includeName = includeName.substring(0, includeName.lastIndexOf('.'));
           if(includeName.equals(parentName)){
           	 SaveStruct ss = new SaveStruct(input);
        	 includes.push(ss);
       	 // switch on new input stream
         	setCharStream(new ANTLRFileStream(includeFile.getAbsolutePath()));
        	 reset();
        	 }
          }else{
        	 
          	System.out.println("File "+name+" does not exist from "+includeFile.getAbsolutePath());
          }
        // save current lexer's state
       
 
       } catch(Exception fnf) { throw new Error("Cannot open file " + name); }
     }
     ;

	
IFNDEF	:	
	 'ifndef' (WS)? (ID)
	;
	
	