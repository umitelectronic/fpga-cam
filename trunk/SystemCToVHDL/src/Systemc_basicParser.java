// $ANTLR 3.4 /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g 2012-02-03 17:57:03

import org.antlr.stringtemplate.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.stringtemplate.*;
import org.antlr.stringtemplate.language.*;
import java.util.HashMap;
@SuppressWarnings({"all", "warnings", "unchecked"})
public class Systemc_basicParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "BIN", "COMMENT", "EQUAL", "FLOAT", "GT", "HEX", "ID", "INT", "LT", "NOT", "OP", "SEMICOLON", "SINGLE_LINE_COMMENT", "STRING_LITERAL", "WS", "'#define '", "'#endif '", "'#endif'", "'#ifndef '", "'#include'", "'&&'", "'('", "')'", "'*'", "','", "'.'", "'.write('", "':'", "'::'", "'<<'", "'SC_CTOR'", "'SC_METHOD('", "'SC_MODULE'", "'['", "'[]'", "']'", "'_rv'", "'bool'", "'break'", "'case'", "'char'", "'concat('", "'default'", "'else'", "'enum'", "'float'", "'if'", "'int'", "'long'", "'range('", "'read()'", "'sc_in'", "'sc_in_clk'", "'sc_in_resolved'", "'sc_in_rv'", "'sc_inout'", "'sc_inout_resolved'", "'sc_inout_rv'", "'sc_logic'", "'sc_lv'", "'sc_out'", "'sc_out_resolved'", "'sc_out_rv'", "'sc_signal'", "'sc_uint'", "'sensitive'", "'short'", "'struct'", "'switch'", "'unsigned'", "'void'", "'{'", "'||'", "'}'"
    };

    public static final int EOF=-1;
    public static final int T__19=19;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__50=50;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__59=59;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int T__73=73;
    public static final int T__74=74;
    public static final int T__75=75;
    public static final int T__76=76;
    public static final int T__77=77;
    public static final int BIN=4;
    public static final int COMMENT=5;
    public static final int EQUAL=6;
    public static final int FLOAT=7;
    public static final int GT=8;
    public static final int HEX=9;
    public static final int ID=10;
    public static final int INT=11;
    public static final int LT=12;
    public static final int NOT=13;
    public static final int OP=14;
    public static final int SEMICOLON=15;
    public static final int SINGLE_LINE_COMMENT=16;
    public static final int STRING_LITERAL=17;
    public static final int WS=18;

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators

    protected static class slist_scope {
        List names;
        List stack;
    }
    protected Stack slist_stack = new Stack();



    public Systemc_basicParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public Systemc_basicParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

protected StringTemplateGroup templateLib =
  new StringTemplateGroup("Systemc_basicParserTemplates", AngleBracketTemplateLexer.class);

public void setTemplateLib(StringTemplateGroup templateLib) {
  this.templateLib = templateLib;
}
public StringTemplateGroup getTemplateLib() {
  return templateLib;
}
/** allows convenient multi-value initialization:
 *  "new STAttrMap().put(...).put(...)"
 */
public static class STAttrMap extends HashMap {
  public STAttrMap put(String attrName, Object value) {
    super.put(attrName, value);
    return this;
  }
  public STAttrMap put(String attrName, int value) {
    super.put(attrName, new Integer(value));
    return this;
  }
}
    public String[] getTokenNames() { return Systemc_basicParser.tokenNames; }
    public String getGrammarFileName() { return "/home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g"; }


    protected static class cfile_scope {
        HashMap functions;
        HashMap vars;
    }
    protected Stack cfile_stack = new Stack();


    public static class cfile_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "cfile"
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:19:1: cfile : ( pre_processor )+ ( declarations[$cfile::vars] )* module_decl SEMICOLON ( declarations[$cfile::vars] )* ( pre_processor )+ -> file(entity=$module_decl.st);
    public final Systemc_basicParser.cfile_return cfile() throws RecognitionException {
        cfile_stack.push(new cfile_scope());
        Systemc_basicParser.cfile_return retval = new Systemc_basicParser.cfile_return();
        retval.start = input.LT(1);


        Systemc_basicParser.module_decl_return module_decl1 =null;



          ((cfile_scope)cfile_stack.peek()).functions = new HashMap();
          ((cfile_scope)cfile_stack.peek()).vars = new HashMap();

        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:28:2: ( ( pre_processor )+ ( declarations[$cfile::vars] )* module_decl SEMICOLON ( declarations[$cfile::vars] )* ( pre_processor )+ -> file(entity=$module_decl.st))
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:29:3: ( pre_processor )+ ( declarations[$cfile::vars] )* module_decl SEMICOLON ( declarations[$cfile::vars] )* ( pre_processor )+
            {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:29:3: ( pre_processor )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==19||(LA1_0 >= 21 && LA1_0 <= 23)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:29:3: pre_processor
            	    {
            	    pushFollow(FOLLOW_pre_processor_in_cfile48);
            	    pre_processor();

            	    state._fsp--;
            	    if (state.failed) return retval;

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:30:3: ( declarations[$cfile::vars] )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==ID||LA2_0==34||LA2_0==41||LA2_0==44||(LA2_0 >= 48 && LA2_0 <= 49)||(LA2_0 >= 51 && LA2_0 <= 52)||(LA2_0 >= 55 && LA2_0 <= 68)||(LA2_0 >= 70 && LA2_0 <= 71)||(LA2_0 >= 73 && LA2_0 <= 74)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:30:3: declarations[$cfile::vars]
            	    {
            	    pushFollow(FOLLOW_declarations_in_cfile53);
            	    declarations(((cfile_scope)cfile_stack.peek()).vars);

            	    state._fsp--;
            	    if (state.failed) return retval;

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            pushFollow(FOLLOW_module_decl_in_cfile60);
            module_decl1=module_decl();

            state._fsp--;
            if (state.failed) return retval;

            match(input,SEMICOLON,FOLLOW_SEMICOLON_in_cfile62); if (state.failed) return retval;

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:32:3: ( declarations[$cfile::vars] )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==ID||LA3_0==34||LA3_0==41||LA3_0==44||(LA3_0 >= 48 && LA3_0 <= 49)||(LA3_0 >= 51 && LA3_0 <= 52)||(LA3_0 >= 55 && LA3_0 <= 68)||(LA3_0 >= 70 && LA3_0 <= 71)||(LA3_0 >= 73 && LA3_0 <= 74)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:32:3: declarations[$cfile::vars]
            	    {
            	    pushFollow(FOLLOW_declarations_in_cfile66);
            	    declarations(((cfile_scope)cfile_stack.peek()).vars);

            	    state._fsp--;
            	    if (state.failed) return retval;

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:33:3: ( pre_processor )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==19||(LA4_0 >= 21 && LA4_0 <= 23)) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:33:3: pre_processor
            	    {
            	    pushFollow(FOLLOW_pre_processor_in_cfile72);
            	    pre_processor();

            	    state._fsp--;
            	    if (state.failed) return retval;

            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


            // TEMPLATE REWRITE
            if ( state.backtracking==0 ) {
              // 34:2: -> file(entity=$module_decl.st)
              {
                  retval.st = templateLib.getInstanceOf("file",new STAttrMap().put("entity", (module_decl1!=null?module_decl1.st:null)));
              }


            }

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            cfile_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "cfile"


    public static class pre_processor_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "pre_processor"
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:37:1: pre_processor : ( includes | define | '#endif' ) ;
    public final Systemc_basicParser.pre_processor_return pre_processor() throws RecognitionException {
        Systemc_basicParser.pre_processor_return retval = new Systemc_basicParser.pre_processor_return();
        retval.start = input.LT(1);


        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:37:15: ( ( includes | define | '#endif' ) )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:37:17: ( includes | define | '#endif' )
            {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:37:17: ( includes | define | '#endif' )
            int alt5=3;
            switch ( input.LA(1) ) {
            case 23:
                {
                alt5=1;
                }
                break;
            case 19:
            case 22:
                {
                alt5=2;
                }
                break;
            case 21:
                {
                alt5=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;

            }

            switch (alt5) {
                case 1 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:37:18: includes
                    {
                    pushFollow(FOLLOW_includes_in_pre_processor96);
                    includes();

                    state._fsp--;
                    if (state.failed) return retval;

                    }
                    break;
                case 2 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:38:4: define
                    {
                    pushFollow(FOLLOW_define_in_pre_processor102);
                    define();

                    state._fsp--;
                    if (state.failed) return retval;

                    }
                    break;
                case 3 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:39:4: '#endif'
                    {
                    match(input,21,FOLLOW_21_in_pre_processor107); if (state.failed) return retval;

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "pre_processor"


    public static class includes_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "includes"
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:42:1: includes : '#include' STRING_LITERAL ;
    public final Systemc_basicParser.includes_return includes() throws RecognitionException {
        Systemc_basicParser.includes_return retval = new Systemc_basicParser.includes_return();
        retval.start = input.LT(1);


        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:42:10: ( '#include' STRING_LITERAL )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:42:12: '#include' STRING_LITERAL
            {
            match(input,23,FOLLOW_23_in_includes118); if (state.failed) return retval;

            match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_includes120); if (state.failed) return retval;

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "includes"


    public static class define_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "define"
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:45:1: define : ( '#define ' | '#ifndef ' ) ID ( INT | ID )? ;
    public final Systemc_basicParser.define_return define() throws RecognitionException {
        Systemc_basicParser.define_return retval = new Systemc_basicParser.define_return();
        retval.start = input.LT(1);


        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:45:8: ( ( '#define ' | '#ifndef ' ) ID ( INT | ID )? )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:45:10: ( '#define ' | '#ifndef ' ) ID ( INT | ID )?
            {
            if ( input.LA(1)==19||input.LA(1)==22 ) {
                input.consume();
                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            match(input,ID,FOLLOW_ID_in_define136); if (state.failed) return retval;

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:45:37: ( INT | ID )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==ID) ) {
                int LA6_1 = input.LA(2);

                if ( (LA6_1==EOF||LA6_1==19||(LA6_1 >= 21 && LA6_1 <= 23)||LA6_1==34||LA6_1==36||LA6_1==41||LA6_1==44||(LA6_1 >= 48 && LA6_1 <= 49)||(LA6_1 >= 51 && LA6_1 <= 52)||(LA6_1 >= 55 && LA6_1 <= 68)||(LA6_1 >= 70 && LA6_1 <= 71)||(LA6_1 >= 73 && LA6_1 <= 74)) ) {
                    alt6=1;
                }
                else if ( (LA6_1==ID) ) {
                    int LA6_4 = input.LA(3);

                    if ( (LA6_4==ID||LA6_4==LT||LA6_4==27||LA6_4==38) ) {
                        alt6=1;
                    }
                }
            }
            else if ( (LA6_0==INT) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:
                    {
                    if ( (input.LA(1) >= ID && input.LA(1) <= INT) ) {
                        input.consume();
                        state.errorRecovery=false;
                        state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }


                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "define"


    public static class endif_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "endif"
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:47:1: endif : '#endif ' ;
    public final Systemc_basicParser.endif_return endif() throws RecognitionException {
        Systemc_basicParser.endif_return retval = new Systemc_basicParser.endif_return();
        retval.start = input.LT(1);


        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:47:7: ( '#endif ' )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:47:9: '#endif '
            {
            match(input,20,FOLLOW_20_in_endif152); if (state.failed) return retval;

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "endif"


    protected static class module_decl_scope {
        List ports;
        List signals;
        HashMap processes;
        List enums;
        HashMap connections;
        HashMap obj_type;
        HashMap mod_type;
    }
    protected Stack module_decl_stack = new Stack();


    public static class module_decl_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "module_decl"
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:50:1: module_decl : 'SC_MODULE' '(' ID ')' '{' module_body '}' -> entity(name=$ID.textports=$module_decl::portssignals=$module_decl::signalsenums=$module_decl::enumsvariables=$module_decl::obj_typeprocess=$module_decl::processesstructure= $module_decl::connectionsinstances=$module_decl::mod_typefunctions=$cfile::functions);
    public final Systemc_basicParser.module_decl_return module_decl() throws RecognitionException {
        module_decl_stack.push(new module_decl_scope());
        Systemc_basicParser.module_decl_return retval = new Systemc_basicParser.module_decl_return();
        retval.start = input.LT(1);


        Token ID2=null;


          ((module_decl_scope)module_decl_stack.peek()).ports = new ArrayList();
          ((module_decl_scope)module_decl_stack.peek()).processes = new HashMap();
          ((module_decl_scope)module_decl_stack.peek()).signals = new ArrayList();
          ((module_decl_scope)module_decl_stack.peek()).enums = new ArrayList();
          ((module_decl_scope)module_decl_stack.peek()).connections = new HashMap();
          ((module_decl_scope)module_decl_stack.peek()).obj_type = new HashMap();
          ((module_decl_scope)module_decl_stack.peek()).mod_type = new HashMap();

        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:69:5: ( 'SC_MODULE' '(' ID ')' '{' module_body '}' -> entity(name=$ID.textports=$module_decl::portssignals=$module_decl::signalsenums=$module_decl::enumsvariables=$module_decl::obj_typeprocess=$module_decl::processesstructure= $module_decl::connectionsinstances=$module_decl::mod_typefunctions=$cfile::functions))
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:69:9: 'SC_MODULE' '(' ID ')' '{' module_body '}'
            {
            match(input,36,FOLLOW_36_in_module_decl177); if (state.failed) return retval;

            match(input,25,FOLLOW_25_in_module_decl179); if (state.failed) return retval;

            ID2=(Token)match(input,ID,FOLLOW_ID_in_module_decl181); if (state.failed) return retval;

            match(input,26,FOLLOW_26_in_module_decl183); if (state.failed) return retval;

            match(input,75,FOLLOW_75_in_module_decl185); if (state.failed) return retval;

            pushFollow(FOLLOW_module_body_in_module_decl195);
            module_body();

            state._fsp--;
            if (state.failed) return retval;

            match(input,77,FOLLOW_77_in_module_decl205); if (state.failed) return retval;

            // TEMPLATE REWRITE
            if ( state.backtracking==0 ) {
              // 72:9: -> entity(name=$ID.textports=$module_decl::portssignals=$module_decl::signalsenums=$module_decl::enumsvariables=$module_decl::obj_typeprocess=$module_decl::processesstructure= $module_decl::connectionsinstances=$module_decl::mod_typefunctions=$cfile::functions)
              {
                  retval.st = templateLib.getInstanceOf("entity",new STAttrMap().put("name", (ID2!=null?ID2.getText():null)).put("ports", ((module_decl_scope)module_decl_stack.peek()).ports).put("signals", ((module_decl_scope)module_decl_stack.peek()).signals).put("enums", ((module_decl_scope)module_decl_stack.peek()).enums).put("variables", ((module_decl_scope)module_decl_stack.peek()).obj_type).put("process", ((module_decl_scope)module_decl_stack.peek()).processes).put("structure",  ((module_decl_scope)module_decl_stack.peek()).connections).put("instances", ((module_decl_scope)module_decl_stack.peek()).mod_type).put("functions", ((cfile_scope)cfile_stack.peek()).functions));
              }


            }

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            module_decl_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "module_decl"


    public static class module_body_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "module_body"
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:84:1: module_body : ( declarations[$module_decl::mod_type] )+ ;
    public final Systemc_basicParser.module_body_return module_body() throws RecognitionException {
        Systemc_basicParser.module_body_return retval = new Systemc_basicParser.module_body_return();
        retval.start = input.LT(1);


        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:85:2: ( ( declarations[$module_decl::mod_type] )+ )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:85:4: ( declarations[$module_decl::mod_type] )+
            {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:85:4: ( declarations[$module_decl::mod_type] )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==ID||LA7_0==34||LA7_0==41||LA7_0==44||(LA7_0 >= 48 && LA7_0 <= 49)||(LA7_0 >= 51 && LA7_0 <= 52)||(LA7_0 >= 55 && LA7_0 <= 68)||(LA7_0 >= 70 && LA7_0 <= 71)||(LA7_0 >= 73 && LA7_0 <= 74)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:85:4: declarations[$module_decl::mod_type]
            	    {
            	    pushFollow(FOLLOW_declarations_in_module_body366);
            	    declarations(((module_decl_scope)module_decl_stack.peek()).mod_type);

            	    state._fsp--;
            	    if (state.failed) return retval;

            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);


            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "module_body"


    public static class declarations_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "declarations"
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:88:1: declarations[HashMap vars] : ( port_decl SEMICOLON | signal_dec SEMICOLON | enum_decl SEMICOLON | variable_decl[$vars] SEMICOLON | func_decl ( SEMICOLON )? | actor ) ;
    public final Systemc_basicParser.declarations_return declarations(HashMap vars) throws RecognitionException {
        Systemc_basicParser.declarations_return retval = new Systemc_basicParser.declarations_return();
        retval.start = input.LT(1);


        Systemc_basicParser.port_decl_return port_decl3 =null;

        Systemc_basicParser.signal_dec_return signal_dec4 =null;

        Systemc_basicParser.enum_decl_return enum_decl5 =null;


        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:89:2: ( ( port_decl SEMICOLON | signal_dec SEMICOLON | enum_decl SEMICOLON | variable_decl[$vars] SEMICOLON | func_decl ( SEMICOLON )? | actor ) )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:90:2: ( port_decl SEMICOLON | signal_dec SEMICOLON | enum_decl SEMICOLON | variable_decl[$vars] SEMICOLON | func_decl ( SEMICOLON )? | actor )
            {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:90:2: ( port_decl SEMICOLON | signal_dec SEMICOLON | enum_decl SEMICOLON | variable_decl[$vars] SEMICOLON | func_decl ( SEMICOLON )? | actor )
            int alt9=6;
            alt9 = dfa9.predict(input);
            switch (alt9) {
                case 1 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:90:3: port_decl SEMICOLON
                    {
                    pushFollow(FOLLOW_port_decl_in_declarations384);
                    port_decl3=port_decl();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input,SEMICOLON,FOLLOW_SEMICOLON_in_declarations386); if (state.failed) return retval;

                    if ( state.backtracking==0 ) {  ((module_decl_scope)module_decl_stack.peek()).ports.add((port_decl3!=null?port_decl3.st:null));}

                    }
                    break;
                case 2 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:91:4: signal_dec SEMICOLON
                    {
                    pushFollow(FOLLOW_signal_dec_in_declarations394);
                    signal_dec4=signal_dec();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input,SEMICOLON,FOLLOW_SEMICOLON_in_declarations396); if (state.failed) return retval;

                    if ( state.backtracking==0 ) {  ((module_decl_scope)module_decl_stack.peek()).signals.add((signal_dec4!=null?signal_dec4.st:null));}

                    }
                    break;
                case 3 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:92:4: enum_decl SEMICOLON
                    {
                    pushFollow(FOLLOW_enum_decl_in_declarations403);
                    enum_decl5=enum_decl();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input,SEMICOLON,FOLLOW_SEMICOLON_in_declarations405); if (state.failed) return retval;

                    if ( state.backtracking==0 ) {  ((module_decl_scope)module_decl_stack.peek()).enums.add((enum_decl5!=null?enum_decl5.st:null));}

                    }
                    break;
                case 4 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:93:4: variable_decl[$vars] SEMICOLON
                    {
                    pushFollow(FOLLOW_variable_decl_in_declarations412);
                    variable_decl(vars);

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input,SEMICOLON,FOLLOW_SEMICOLON_in_declarations415); if (state.failed) return retval;

                    }
                    break;
                case 5 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:94:4: func_decl ( SEMICOLON )?
                    {
                    pushFollow(FOLLOW_func_decl_in_declarations420);
                    func_decl();

                    state._fsp--;
                    if (state.failed) return retval;

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:94:14: ( SEMICOLON )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==SEMICOLON) ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:94:14: SEMICOLON
                            {
                            match(input,SEMICOLON,FOLLOW_SEMICOLON_in_declarations422); if (state.failed) return retval;

                            }
                            break;

                    }


                    }
                    break;
                case 6 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:95:4: actor
                    {
                    pushFollow(FOLLOW_actor_in_declarations428);
                    actor();

                    state._fsp--;
                    if (state.failed) return retval;

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "declarations"


    public static class func_decl_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "func_decl"
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:99:1: func_decl : ( ( v_type (class_name= ID '::' )? ) func= ID ( '(' ( ( v_type ID ( ',' v_type ID )* )? ) ')' ) ) ( func_body )? ;
    public final Systemc_basicParser.func_decl_return func_decl() throws RecognitionException {
        Systemc_basicParser.func_decl_return retval = new Systemc_basicParser.func_decl_return();
        retval.start = input.LT(1);


        Token class_name=null;
        Token func=null;
        Systemc_basicParser.func_body_return func_body6 =null;


        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:99:11: ( ( ( v_type (class_name= ID '::' )? ) func= ID ( '(' ( ( v_type ID ( ',' v_type ID )* )? ) ')' ) ) ( func_body )? )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:100:2: ( ( v_type (class_name= ID '::' )? ) func= ID ( '(' ( ( v_type ID ( ',' v_type ID )* )? ) ')' ) ) ( func_body )?
            {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:100:2: ( ( v_type (class_name= ID '::' )? ) func= ID ( '(' ( ( v_type ID ( ',' v_type ID )* )? ) ')' ) )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:100:3: ( v_type (class_name= ID '::' )? ) func= ID ( '(' ( ( v_type ID ( ',' v_type ID )* )? ) ')' )
            {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:100:3: ( v_type (class_name= ID '::' )? )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:100:4: v_type (class_name= ID '::' )?
            {
            pushFollow(FOLLOW_v_type_in_func_decl444);
            v_type();

            state._fsp--;
            if (state.failed) return retval;

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:100:11: (class_name= ID '::' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==ID) ) {
                int LA10_1 = input.LA(2);

                if ( (LA10_1==32) ) {
                    alt10=1;
                }
            }
            switch (alt10) {
                case 1 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:100:12: class_name= ID '::'
                    {
                    class_name=(Token)match(input,ID,FOLLOW_ID_in_func_decl449); if (state.failed) return retval;

                    match(input,32,FOLLOW_32_in_func_decl450); if (state.failed) return retval;

                    }
                    break;

            }


            }


            func=(Token)match(input,ID,FOLLOW_ID_in_func_decl456); if (state.failed) return retval;

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:100:39: ( '(' ( ( v_type ID ( ',' v_type ID )* )? ) ')' )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:100:40: '(' ( ( v_type ID ( ',' v_type ID )* )? ) ')'
            {
            match(input,25,FOLLOW_25_in_func_decl458); if (state.failed) return retval;

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:100:43: ( ( v_type ID ( ',' v_type ID )* )? )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:100:44: ( v_type ID ( ',' v_type ID )* )?
            {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:100:44: ( v_type ID ( ',' v_type ID )* )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==ID||LA12_0==41||LA12_0==44||LA12_0==49||(LA12_0 >= 51 && LA12_0 <= 52)||(LA12_0 >= 62 && LA12_0 <= 63)||LA12_0==68||(LA12_0 >= 70 && LA12_0 <= 71)||(LA12_0 >= 73 && LA12_0 <= 74)) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:100:45: v_type ID ( ',' v_type ID )*
                    {
                    pushFollow(FOLLOW_v_type_in_func_decl461);
                    v_type();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input,ID,FOLLOW_ID_in_func_decl463); if (state.failed) return retval;

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:100:55: ( ',' v_type ID )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==28) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:100:56: ',' v_type ID
                    	    {
                    	    match(input,28,FOLLOW_28_in_func_decl466); if (state.failed) return retval;

                    	    pushFollow(FOLLOW_v_type_in_func_decl467);
                    	    v_type();

                    	    state._fsp--;
                    	    if (state.failed) return retval;

                    	    match(input,ID,FOLLOW_ID_in_func_decl469); if (state.failed) return retval;

                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);


                    }
                    break;

            }


            }


            match(input,26,FOLLOW_26_in_func_decl475); if (state.failed) return retval;

            }


            }


            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:100:79: ( func_body )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==75) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:100:80: func_body
                    {
                    pushFollow(FOLLOW_func_body_in_func_decl480);
                    func_body6=func_body();

                    state._fsp--;
                    if (state.failed) return retval;

                    }
                    break;

            }


            if ( state.backtracking==0 ) { ((cfile_scope)cfile_stack.peek()).functions.put((func!=null?func.getText():null), (func_body6!=null?func_body6.st:null));}

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "func_decl"


    public static class enum_decl_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "enum_decl"
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:103:1: enum_decl : 'enum' ID '{' name ( ',' name )* '}' -> enum(name=$ID.textmembers=$slist::names);
    public final Systemc_basicParser.enum_decl_return enum_decl() throws RecognitionException {
        slist_stack.push(new slist_scope());

        Systemc_basicParser.enum_decl_return retval = new Systemc_basicParser.enum_decl_return();
        retval.start = input.LT(1);


        Token ID7=null;


          ((slist_scope)slist_stack.peek()).names = new ArrayList();

        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:108:2: ( 'enum' ID '{' name ( ',' name )* '}' -> enum(name=$ID.textmembers=$slist::names))
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:110:2: 'enum' ID '{' name ( ',' name )* '}'
            {
            match(input,48,FOLLOW_48_in_enum_decl508); if (state.failed) return retval;

            ID7=(Token)match(input,ID,FOLLOW_ID_in_enum_decl510); if (state.failed) return retval;

            match(input,75,FOLLOW_75_in_enum_decl512); if (state.failed) return retval;

            pushFollow(FOLLOW_name_in_enum_decl514);
            name();

            state._fsp--;
            if (state.failed) return retval;

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:110:21: ( ',' name )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==28) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:110:22: ',' name
            	    {
            	    match(input,28,FOLLOW_28_in_enum_decl517); if (state.failed) return retval;

            	    pushFollow(FOLLOW_name_in_enum_decl519);
            	    name();

            	    state._fsp--;
            	    if (state.failed) return retval;

            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);


            match(input,77,FOLLOW_77_in_enum_decl523); if (state.failed) return retval;

            // TEMPLATE REWRITE
            if ( state.backtracking==0 ) {
              // 110:37: -> enum(name=$ID.textmembers=$slist::names)
              {
                  retval.st = templateLib.getInstanceOf("enum",new STAttrMap().put("name", (ID7!=null?ID7.getText():null)).put("members", ((slist_scope)slist_stack.peek()).names));
              }


            }

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            slist_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "enum_decl"


    public static class variable_decl_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "variable_decl"
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:113:1: variable_decl[HashMap vars] : v_type ( '*' | '[]' )* n= ID ( ',' elt= ID )* ( fixed_size_array )* ( assignement )? ;
    public final Systemc_basicParser.variable_decl_return variable_decl(HashMap vars) throws RecognitionException {
        Systemc_basicParser.variable_decl_return retval = new Systemc_basicParser.variable_decl_return();
        retval.start = input.LT(1);


        Token n=null;
        Token elt=null;
        Systemc_basicParser.v_type_return v_type8 =null;


        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:113:29: ( v_type ( '*' | '[]' )* n= ID ( ',' elt= ID )* ( fixed_size_array )* ( assignement )? )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:114:2: v_type ( '*' | '[]' )* n= ID ( ',' elt= ID )* ( fixed_size_array )* ( assignement )?
            {
            pushFollow(FOLLOW_v_type_in_variable_decl551);
            v_type8=v_type();

            state._fsp--;
            if (state.failed) return retval;

            if ( state.backtracking==0 ) { vars.put((v_type8!=null?input.toString(v_type8.start,v_type8.stop):null), new ArrayList());}

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:114:54: ( '*' | '[]' )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==27||LA15_0==38) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:
            	    {
            	    if ( input.LA(1)==27||input.LA(1)==38 ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);


            n=(Token)match(input,ID,FOLLOW_ID_in_variable_decl564); if (state.failed) return retval;

            if ( state.backtracking==0 ) { ((List) vars.get((v_type8!=null?input.toString(v_type8.start,v_type8.stop):null))).add((n!=null?n.getText():null));}

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:114:122: ( ',' elt= ID )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==28) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:114:123: ',' elt= ID
            	    {
            	    match(input,28,FOLLOW_28_in_variable_decl570); if (state.failed) return retval;

            	    elt=(Token)match(input,ID,FOLLOW_ID_in_variable_decl574); if (state.failed) return retval;

            	    if ( state.backtracking==0 ) { ((List) vars.get((v_type8!=null?input.toString(v_type8.start,v_type8.stop):null))).add((elt!=null?elt.getText():null));}

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);


            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:114:188: ( fixed_size_array )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==37) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:114:188: fixed_size_array
            	    {
            	    pushFollow(FOLLOW_fixed_size_array_in_variable_decl580);
            	    fixed_size_array();

            	    state._fsp--;
            	    if (state.failed) return retval;

            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);


            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:114:206: ( assignement )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==EQUAL) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:114:206: assignement
                    {
                    pushFollow(FOLLOW_assignement_in_variable_decl583);
                    assignement();

                    state._fsp--;
                    if (state.failed) return retval;

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "variable_decl"


    public static class fixed_size_array_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "fixed_size_array"
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:117:1: fixed_size_array : ( '[' INT ']' ) ;
    public final Systemc_basicParser.fixed_size_array_return fixed_size_array() throws RecognitionException {
        Systemc_basicParser.fixed_size_array_return retval = new Systemc_basicParser.fixed_size_array_return();
        retval.start = input.LT(1);


        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:117:18: ( ( '[' INT ']' ) )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:117:20: ( '[' INT ']' )
            {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:117:20: ( '[' INT ']' )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:117:21: '[' INT ']'
            {
            match(input,37,FOLLOW_37_in_fixed_size_array598); if (state.failed) return retval;

            match(input,INT,FOLLOW_INT_in_fixed_size_array599); if (state.failed) return retval;

            match(input,39,FOLLOW_39_in_fixed_size_array600); if (state.failed) return retval;

            }


            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "fixed_size_array"


    public static class assignement_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "assignement"
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:120:1: assignement : '=' ( INT | array_of_value | FLOAT | STRING_LITERAL ) ;
    public final Systemc_basicParser.assignement_return assignement() throws RecognitionException {
        Systemc_basicParser.assignement_return retval = new Systemc_basicParser.assignement_return();
        retval.start = input.LT(1);


        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:120:13: ( '=' ( INT | array_of_value | FLOAT | STRING_LITERAL ) )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:121:2: '=' ( INT | array_of_value | FLOAT | STRING_LITERAL )
            {
            match(input,EQUAL,FOLLOW_EQUAL_in_assignement613); if (state.failed) return retval;

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:121:6: ( INT | array_of_value | FLOAT | STRING_LITERAL )
            int alt19=4;
            switch ( input.LA(1) ) {
            case INT:
                {
                alt19=1;
                }
                break;
            case 75:
                {
                alt19=2;
                }
                break;
            case FLOAT:
                {
                alt19=3;
                }
                break;
            case STRING_LITERAL:
                {
                alt19=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;

            }

            switch (alt19) {
                case 1 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:121:7: INT
                    {
                    match(input,INT,FOLLOW_INT_in_assignement616); if (state.failed) return retval;

                    }
                    break;
                case 2 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:121:12: array_of_value
                    {
                    pushFollow(FOLLOW_array_of_value_in_assignement619);
                    array_of_value();

                    state._fsp--;
                    if (state.failed) return retval;

                    }
                    break;
                case 3 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:121:29: FLOAT
                    {
                    match(input,FLOAT,FOLLOW_FLOAT_in_assignement623); if (state.failed) return retval;

                    }
                    break;
                case 4 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:121:38: STRING_LITERAL
                    {
                    match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_assignement628); if (state.failed) return retval;

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "assignement"


    public static class array_of_value_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "array_of_value"
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:124:1: array_of_value : '{' ( INT | array_of_value | FLOAT ) ( ',' ( INT | array_of_value | FLOAT ) )* '}' ;
    public final Systemc_basicParser.array_of_value_return array_of_value() throws RecognitionException {
        Systemc_basicParser.array_of_value_return retval = new Systemc_basicParser.array_of_value_return();
        retval.start = input.LT(1);


        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:124:16: ( '{' ( INT | array_of_value | FLOAT ) ( ',' ( INT | array_of_value | FLOAT ) )* '}' )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:124:18: '{' ( INT | array_of_value | FLOAT ) ( ',' ( INT | array_of_value | FLOAT ) )* '}'
            {
            match(input,75,FOLLOW_75_in_array_of_value640); if (state.failed) return retval;

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:124:21: ( INT | array_of_value | FLOAT )
            int alt20=3;
            switch ( input.LA(1) ) {
            case INT:
                {
                alt20=1;
                }
                break;
            case 75:
                {
                alt20=2;
                }
                break;
            case FLOAT:
                {
                alt20=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;

            }

            switch (alt20) {
                case 1 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:124:22: INT
                    {
                    match(input,INT,FOLLOW_INT_in_array_of_value642); if (state.failed) return retval;

                    }
                    break;
                case 2 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:124:27: array_of_value
                    {
                    pushFollow(FOLLOW_array_of_value_in_array_of_value645);
                    array_of_value();

                    state._fsp--;
                    if (state.failed) return retval;

                    }
                    break;
                case 3 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:124:44: FLOAT
                    {
                    match(input,FLOAT,FOLLOW_FLOAT_in_array_of_value649); if (state.failed) return retval;

                    }
                    break;

            }


            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:124:51: ( ',' ( INT | array_of_value | FLOAT ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==28) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:124:52: ',' ( INT | array_of_value | FLOAT )
            	    {
            	    match(input,28,FOLLOW_28_in_array_of_value653); if (state.failed) return retval;

            	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:124:56: ( INT | array_of_value | FLOAT )
            	    int alt21=3;
            	    switch ( input.LA(1) ) {
            	    case INT:
            	        {
            	        alt21=1;
            	        }
            	        break;
            	    case 75:
            	        {
            	        alt21=2;
            	        }
            	        break;
            	    case FLOAT:
            	        {
            	        alt21=3;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 21, 0, input);

            	        throw nvae;

            	    }

            	    switch (alt21) {
            	        case 1 :
            	            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:124:57: INT
            	            {
            	            match(input,INT,FOLLOW_INT_in_array_of_value656); if (state.failed) return retval;

            	            }
            	            break;
            	        case 2 :
            	            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:124:62: array_of_value
            	            {
            	            pushFollow(FOLLOW_array_of_value_in_array_of_value659);
            	            array_of_value();

            	            state._fsp--;
            	            if (state.failed) return retval;

            	            }
            	            break;
            	        case 3 :
            	            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:124:79: FLOAT
            	            {
            	            match(input,FLOAT,FOLLOW_FLOAT_in_array_of_value663); if (state.failed) return retval;

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);


            match(input,77,FOLLOW_77_in_array_of_value667); if (state.failed) return retval;

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "array_of_value"


    public static class v_type_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "v_type"
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:128:1: v_type : ( ( ( v_signed_modifier )? ( v_size_modifier )? 'int' ) | ( ( v_signed_modifier )? 'char' ) | 'float' | 'void' | ( 'struct' ID ) | sc_type | ID ( otemplate )? ) ;
    public final Systemc_basicParser.v_type_return v_type() throws RecognitionException {
        Systemc_basicParser.v_type_return retval = new Systemc_basicParser.v_type_return();
        retval.start = input.LT(1);


        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:128:8: ( ( ( ( v_signed_modifier )? ( v_size_modifier )? 'int' ) | ( ( v_signed_modifier )? 'char' ) | 'float' | 'void' | ( 'struct' ID ) | sc_type | ID ( otemplate )? ) )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:128:10: ( ( ( v_signed_modifier )? ( v_size_modifier )? 'int' ) | ( ( v_signed_modifier )? 'char' ) | 'float' | 'void' | ( 'struct' ID ) | sc_type | ID ( otemplate )? )
            {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:128:10: ( ( ( v_signed_modifier )? ( v_size_modifier )? 'int' ) | ( ( v_signed_modifier )? 'char' ) | 'float' | 'void' | ( 'struct' ID ) | sc_type | ID ( otemplate )? )
            int alt27=7;
            switch ( input.LA(1) ) {
            case 73:
                {
                int LA27_1 = input.LA(2);

                if ( ((LA27_1 >= 51 && LA27_1 <= 52)||LA27_1==70) ) {
                    alt27=1;
                }
                else if ( (LA27_1==44) ) {
                    alt27=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 27, 1, input);

                    throw nvae;

                }
                }
                break;
            case 51:
            case 52:
            case 70:
                {
                alt27=1;
                }
                break;
            case 44:
                {
                alt27=2;
                }
                break;
            case 49:
                {
                alt27=3;
                }
                break;
            case 74:
                {
                alt27=4;
                }
                break;
            case 71:
                {
                alt27=5;
                }
                break;
            case 41:
            case 62:
            case 63:
            case 68:
                {
                alt27=6;
                }
                break;
            case ID:
                {
                alt27=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;

            }

            switch (alt27) {
                case 1 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:128:11: ( ( v_signed_modifier )? ( v_size_modifier )? 'int' )
                    {
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:128:11: ( ( v_signed_modifier )? ( v_size_modifier )? 'int' )
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:128:12: ( v_signed_modifier )? ( v_size_modifier )? 'int'
                    {
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:128:12: ( v_signed_modifier )?
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0==73) ) {
                        alt23=1;
                    }
                    switch (alt23) {
                        case 1 :
                            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:128:12: v_signed_modifier
                            {
                            pushFollow(FOLLOW_v_signed_modifier_in_v_type680);
                            v_signed_modifier();

                            state._fsp--;
                            if (state.failed) return retval;

                            }
                            break;

                    }


                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:128:31: ( v_size_modifier )?
                    int alt24=2;
                    int LA24_0 = input.LA(1);

                    if ( (LA24_0==52||LA24_0==70) ) {
                        alt24=1;
                    }
                    switch (alt24) {
                        case 1 :
                            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:128:31: v_size_modifier
                            {
                            pushFollow(FOLLOW_v_size_modifier_in_v_type683);
                            v_size_modifier();

                            state._fsp--;
                            if (state.failed) return retval;

                            }
                            break;

                    }


                    match(input,51,FOLLOW_51_in_v_type687); if (state.failed) return retval;

                    }


                    }
                    break;
                case 2 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:128:56: ( ( v_signed_modifier )? 'char' )
                    {
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:128:56: ( ( v_signed_modifier )? 'char' )
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:128:57: ( v_signed_modifier )? 'char'
                    {
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:128:57: ( v_signed_modifier )?
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( (LA25_0==73) ) {
                        alt25=1;
                    }
                    switch (alt25) {
                        case 1 :
                            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:128:58: v_signed_modifier
                            {
                            pushFollow(FOLLOW_v_signed_modifier_in_v_type692);
                            v_signed_modifier();

                            state._fsp--;
                            if (state.failed) return retval;

                            }
                            break;

                    }


                    match(input,44,FOLLOW_44_in_v_type696); if (state.failed) return retval;

                    }


                    }
                    break;
                case 3 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:128:86: 'float'
                    {
                    match(input,49,FOLLOW_49_in_v_type699); if (state.failed) return retval;

                    }
                    break;
                case 4 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:128:94: 'void'
                    {
                    match(input,74,FOLLOW_74_in_v_type701); if (state.failed) return retval;

                    }
                    break;
                case 5 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:128:101: ( 'struct' ID )
                    {
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:128:101: ( 'struct' ID )
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:128:102: 'struct' ID
                    {
                    match(input,71,FOLLOW_71_in_v_type704); if (state.failed) return retval;

                    match(input,ID,FOLLOW_ID_in_v_type706); if (state.failed) return retval;

                    }


                    }
                    break;
                case 6 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:128:116: sc_type
                    {
                    pushFollow(FOLLOW_sc_type_in_v_type710);
                    sc_type();

                    state._fsp--;
                    if (state.failed) return retval;

                    }
                    break;
                case 7 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:128:125: ID ( otemplate )?
                    {
                    match(input,ID,FOLLOW_ID_in_v_type713); if (state.failed) return retval;

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:128:128: ( otemplate )?
                    int alt26=2;
                    int LA26_0 = input.LA(1);

                    if ( (LA26_0==LT) ) {
                        alt26=1;
                    }
                    switch (alt26) {
                        case 1 :
                            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:128:128: otemplate
                            {
                            pushFollow(FOLLOW_otemplate_in_v_type715);
                            otemplate();

                            state._fsp--;
                            if (state.failed) return retval;

                            }
                            break;

                    }


                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "v_type"


    public static class v_size_modifier_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "v_size_modifier"
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:130:1: v_size_modifier : ( 'short' | 'long' )+ ;
    public final Systemc_basicParser.v_size_modifier_return v_size_modifier() throws RecognitionException {
        Systemc_basicParser.v_size_modifier_return retval = new Systemc_basicParser.v_size_modifier_return();
        retval.start = input.LT(1);


        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:130:17: ( ( 'short' | 'long' )+ )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:130:18: ( 'short' | 'long' )+
            {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:130:18: ( 'short' | 'long' )+
            int cnt28=0;
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==52||LA28_0==70) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:
            	    {
            	    if ( input.LA(1)==52||input.LA(1)==70 ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt28 >= 1 ) break loop28;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(28, input);
                        throw eee;
                }
                cnt28++;
            } while (true);


            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "v_size_modifier"


    public static class v_signed_modifier_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "v_signed_modifier"
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:132:1: v_signed_modifier : 'unsigned' ;
    public final Systemc_basicParser.v_signed_modifier_return v_signed_modifier() throws RecognitionException {
        Systemc_basicParser.v_signed_modifier_return retval = new Systemc_basicParser.v_signed_modifier_return();
        retval.start = input.LT(1);


        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:132:19: ( 'unsigned' )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:132:21: 'unsigned'
            {
            match(input,73,FOLLOW_73_in_v_signed_modifier742); if (state.failed) return retval;

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "v_signed_modifier"


    public static class otemplate_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "otemplate"
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:134:1: otemplate : '<' ( ID | INT ) ( ',' ( ID | INT ) )* '>' ;
    public final Systemc_basicParser.otemplate_return otemplate() throws RecognitionException {
        Systemc_basicParser.otemplate_return retval = new Systemc_basicParser.otemplate_return();
        retval.start = input.LT(1);


        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:134:11: ( '<' ( ID | INT ) ( ',' ( ID | INT ) )* '>' )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:134:13: '<' ( ID | INT ) ( ',' ( ID | INT ) )* '>'
            {
            match(input,LT,FOLLOW_LT_in_otemplate751); if (state.failed) return retval;

            if ( (input.LA(1) >= ID && input.LA(1) <= INT) ) {
                input.consume();
                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:134:26: ( ',' ( ID | INT ) )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==28) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:134:27: ',' ( ID | INT )
            	    {
            	    match(input,28,FOLLOW_28_in_otemplate760); if (state.failed) return retval;

            	    if ( (input.LA(1) >= ID && input.LA(1) <= INT) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);


            match(input,GT,FOLLOW_GT_in_otemplate769); if (state.failed) return retval;

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "otemplate"


    public static class actor_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "actor"
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:137:1: actor : 'SC_CTOR' '(' ID ')' ( ':' actor_inst ( ',' actor_inst )* )? '{' ( actor_body ) '}' ;
    public final Systemc_basicParser.actor_return actor() throws RecognitionException {
        Systemc_basicParser.actor_return retval = new Systemc_basicParser.actor_return();
        retval.start = input.LT(1);


        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:137:7: ( 'SC_CTOR' '(' ID ')' ( ':' actor_inst ( ',' actor_inst )* )? '{' ( actor_body ) '}' )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:137:8: 'SC_CTOR' '(' ID ')' ( ':' actor_inst ( ',' actor_inst )* )? '{' ( actor_body ) '}'
            {
            match(input,34,FOLLOW_34_in_actor779); if (state.failed) return retval;

            match(input,25,FOLLOW_25_in_actor780); if (state.failed) return retval;

            match(input,ID,FOLLOW_ID_in_actor781); if (state.failed) return retval;

            match(input,26,FOLLOW_26_in_actor782); if (state.failed) return retval;

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:137:27: ( ':' actor_inst ( ',' actor_inst )* )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==31) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:137:28: ':' actor_inst ( ',' actor_inst )*
                    {
                    match(input,31,FOLLOW_31_in_actor786); if (state.failed) return retval;

                    pushFollow(FOLLOW_actor_inst_in_actor788);
                    actor_inst();

                    state._fsp--;
                    if (state.failed) return retval;

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:137:42: ( ',' actor_inst )*
                    loop30:
                    do {
                        int alt30=2;
                        int LA30_0 = input.LA(1);

                        if ( (LA30_0==28) ) {
                            alt30=1;
                        }


                        switch (alt30) {
                    	case 1 :
                    	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:137:43: ',' actor_inst
                    	    {
                    	    match(input,28,FOLLOW_28_in_actor790); if (state.failed) return retval;

                    	    pushFollow(FOLLOW_actor_inst_in_actor791);
                    	    actor_inst();

                    	    state._fsp--;
                    	    if (state.failed) return retval;

                    	    }
                    	    break;

                    	default :
                    	    break loop30;
                        }
                    } while (true);


                    }
                    break;

            }


            match(input,75,FOLLOW_75_in_actor796); if (state.failed) return retval;

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:137:64: ( actor_body )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:137:65: actor_body
            {
            pushFollow(FOLLOW_actor_body_in_actor799);
            actor_body();

            state._fsp--;
            if (state.failed) return retval;

            }


            match(input,77,FOLLOW_77_in_actor802); if (state.failed) return retval;

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "actor"


    public static class actor_inst_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "actor_inst"
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:141:1: actor_inst : ID '(' STRING_LITERAL ')' ;
    public final Systemc_basicParser.actor_inst_return actor_inst() throws RecognitionException {
        Systemc_basicParser.actor_inst_return retval = new Systemc_basicParser.actor_inst_return();
        retval.start = input.LT(1);


        Token ID9=null;

        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:142:2: ( ID '(' STRING_LITERAL ')' )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:142:3: ID '(' STRING_LITERAL ')'
            {
            ID9=(Token)match(input,ID,FOLLOW_ID_in_actor_inst813); if (state.failed) return retval;

            match(input,25,FOLLOW_25_in_actor_inst814); if (state.failed) return retval;

            match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_actor_inst815); if (state.failed) return retval;

            match(input,26,FOLLOW_26_in_actor_inst816); if (state.failed) return retval;

            if ( state.backtracking==0 ) {	((module_decl_scope)module_decl_stack.peek()).mod_type.put((ID9!=null?ID9.getText():null), ((module_decl_scope)module_decl_stack.peek()).obj_type.get((ID9!=null?ID9.getText():null)));
            			 ((module_decl_scope)module_decl_stack.peek()).obj_type.remove((ID9!=null?ID9.getText():null));
            			}

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "actor_inst"


    public static class connection_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "connection"
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:147:1: connection : component= ID '.' link ;
    public final Systemc_basicParser.connection_return connection() throws RecognitionException {
        Systemc_basicParser.connection_return retval = new Systemc_basicParser.connection_return();
        retval.start = input.LT(1);


        Token component=null;
        Systemc_basicParser.link_return link10 =null;


        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:147:12: (component= ID '.' link )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:147:14: component= ID '.' link
            {
            component=(Token)match(input,ID,FOLLOW_ID_in_connection831); if (state.failed) return retval;

            match(input,29,FOLLOW_29_in_connection832); if (state.failed) return retval;

            pushFollow(FOLLOW_link_in_connection833);
            link10=link();

            state._fsp--;
            if (state.failed) return retval;

            if ( state.backtracking==0 ) {if(((module_decl_scope)module_decl_stack.peek()).connections.get((component!=null?component.getText():null)) == null){
            				((module_decl_scope)module_decl_stack.peek()).connections.put((component!=null?component.getText():null),  new ArrayList()) ;
            			}
             			((ArrayList) ((module_decl_scope)module_decl_stack.peek()).connections.get((component!=null?component.getText():null))).add((link10!=null?link10.st:null));
             			}

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "connection"


    public static class link_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "link"
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:154:1: link : port= ID '(' signal= ID ')' -> link(source=$port.textdest=$signal.text);
    public final Systemc_basicParser.link_return link() throws RecognitionException {
        Systemc_basicParser.link_return retval = new Systemc_basicParser.link_return();
        retval.start = input.LT(1);


        Token port=null;
        Token signal=null;

        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:154:6: (port= ID '(' signal= ID ')' -> link(source=$port.textdest=$signal.text))
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:154:7: port= ID '(' signal= ID ')'
            {
            port=(Token)match(input,ID,FOLLOW_ID_in_link846); if (state.failed) return retval;

            match(input,25,FOLLOW_25_in_link847); if (state.failed) return retval;

            signal=(Token)match(input,ID,FOLLOW_ID_in_link850); if (state.failed) return retval;

            match(input,26,FOLLOW_26_in_link851); if (state.failed) return retval;

            // TEMPLATE REWRITE
            if ( state.backtracking==0 ) {
              // 154:30: -> link(source=$port.textdest=$signal.text)
              {
                  retval.st = templateLib.getInstanceOf("link",new STAttrMap().put("source", (port!=null?port.getText():null)).put("dest", (signal!=null?signal.getText():null)));
              }


            }

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "link"


    public static class sensitive_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "sensitive"
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:157:1: sensitive : 'sensitive' '<<' ID ( '.' method )* ;
    public final Systemc_basicParser.sensitive_return sensitive() throws RecognitionException {
        Systemc_basicParser.sensitive_return retval = new Systemc_basicParser.sensitive_return();
        retval.start = input.LT(1);


        Token ID11=null;

        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:158:2: ( 'sensitive' '<<' ID ( '.' method )* )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:158:4: 'sensitive' '<<' ID ( '.' method )*
            {
            match(input,69,FOLLOW_69_in_sensitive881); if (state.failed) return retval;

            match(input,33,FOLLOW_33_in_sensitive883); if (state.failed) return retval;

            ID11=(Token)match(input,ID,FOLLOW_ID_in_sensitive885); if (state.failed) return retval;

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:158:24: ( '.' method )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==29) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:158:25: '.' method
            	    {
            	    match(input,29,FOLLOW_29_in_sensitive888); if (state.failed) return retval;

            	    pushFollow(FOLLOW_method_in_sensitive889);
            	    method();

            	    state._fsp--;
            	    if (state.failed) return retval;

            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);


            if ( state.backtracking==0 ) {((slist_scope)slist_stack.peek()).names.add((ID11!=null?ID11.getText():null));}

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "sensitive"


    public static class method_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "method"
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:161:1: method : ID '(' ( func_arg ( ',' arg= func_arg )* )? ')' -> method(name=$ID.textargs=$slist::stack);
    public final Systemc_basicParser.method_return method() throws RecognitionException {
        slist_stack.push(new slist_scope());

        Systemc_basicParser.method_return retval = new Systemc_basicParser.method_return();
        retval.start = input.LT(1);


        Token ID12=null;
        Systemc_basicParser.func_arg_return arg =null;



          ((slist_scope)slist_stack.peek()).stack = new ArrayList();

        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:166:2: ( ID '(' ( func_arg ( ',' arg= func_arg )* )? ')' -> method(name=$ID.textargs=$slist::stack))
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:167:2: ID '(' ( func_arg ( ',' arg= func_arg )* )? ')'
            {
            ID12=(Token)match(input,ID,FOLLOW_ID_in_method915); if (state.failed) return retval;

            match(input,25,FOLLOW_25_in_method916); if (state.failed) return retval;

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:167:7: ( func_arg ( ',' arg= func_arg )* )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==BIN||(LA34_0 >= HEX && LA34_0 <= INT)||LA34_0==STRING_LITERAL||LA34_0==25||LA34_0==45||(LA34_0 >= 53 && LA34_0 <= 54)) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:167:8: func_arg ( ',' arg= func_arg )*
                    {
                    pushFollow(FOLLOW_func_arg_in_method918);
                    func_arg();

                    state._fsp--;
                    if (state.failed) return retval;

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:167:16: ( ',' arg= func_arg )*
                    loop33:
                    do {
                        int alt33=2;
                        int LA33_0 = input.LA(1);

                        if ( (LA33_0==28) ) {
                            alt33=1;
                        }


                        switch (alt33) {
                    	case 1 :
                    	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:167:17: ',' arg= func_arg
                    	    {
                    	    match(input,28,FOLLOW_28_in_method920); if (state.failed) return retval;

                    	    pushFollow(FOLLOW_func_arg_in_method923);
                    	    arg=func_arg();

                    	    state._fsp--;
                    	    if (state.failed) return retval;

                    	    if ( state.backtracking==0 ) {((slist_scope)slist_stack.peek()).stack.add((arg!=null?arg.st:null));}

                    	    }
                    	    break;

                    	default :
                    	    break loop33;
                        }
                    } while (true);


                    }
                    break;

            }


            match(input,26,FOLLOW_26_in_method930); if (state.failed) return retval;

            // TEMPLATE REWRITE
            if ( state.backtracking==0 ) {
              // 167:70: -> method(name=$ID.textargs=$slist::stack)
              {
                  retval.st = templateLib.getInstanceOf("method",new STAttrMap().put("name", (ID12!=null?ID12.getText():null)).put("args", ((slist_scope)slist_stack.peek()).stack));
              }


            }

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            slist_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "method"


    public static class func_arg_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "func_arg"
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:170:1: func_arg : ( value ) ;
    public final Systemc_basicParser.func_arg_return func_arg() throws RecognitionException {
        Systemc_basicParser.func_arg_return retval = new Systemc_basicParser.func_arg_return();
        retval.start = input.LT(1);


        Systemc_basicParser.value_return value13 =null;


        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:170:10: ( ( value ) )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:170:11: ( value )
            {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:170:11: ( value )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:170:12: value
            {
            pushFollow(FOLLOW_value_in_func_arg956);
            value13=value();

            state._fsp--;
            if (state.failed) return retval;

            if ( state.backtracking==0 ) {((slist_scope)slist_stack.peek()).stack.add((value13!=null?value13.st:null));}

            }


            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "func_arg"


    public static class actor_method_return extends ParserRuleReturnScope {
        public String  name;
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "actor_method"
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:172:1: actor_method returns [String name] : actor_method_decl SEMICOLON ( sensitive SEMICOLON )+ -> process(sensitive=$slist::namesname=$actor_method_decl.name);
    public final Systemc_basicParser.actor_method_return actor_method() throws RecognitionException {
        slist_stack.push(new slist_scope());

        Systemc_basicParser.actor_method_return retval = new Systemc_basicParser.actor_method_return();
        retval.start = input.LT(1);


        Systemc_basicParser.actor_method_decl_return actor_method_decl14 =null;



          ((slist_scope)slist_stack.peek()).names = new ArrayList();
          retval.name = new String();

        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:178:2: ( actor_method_decl SEMICOLON ( sensitive SEMICOLON )+ -> process(sensitive=$slist::namesname=$actor_method_decl.name))
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:179:2: actor_method_decl SEMICOLON ( sensitive SEMICOLON )+
            {
            pushFollow(FOLLOW_actor_method_decl_in_actor_method985);
            actor_method_decl14=actor_method_decl();

            state._fsp--;
            if (state.failed) return retval;

            match(input,SEMICOLON,FOLLOW_SEMICOLON_in_actor_method987); if (state.failed) return retval;

            if ( state.backtracking==0 ) {retval.name = (actor_method_decl14!=null?actor_method_decl14.name:null) ;}

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:180:2: ( sensitive SEMICOLON )+
            int cnt35=0;
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==69) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:180:3: sensitive SEMICOLON
            	    {
            	    pushFollow(FOLLOW_sensitive_in_actor_method992);
            	    sensitive();

            	    state._fsp--;
            	    if (state.failed) return retval;

            	    match(input,SEMICOLON,FOLLOW_SEMICOLON_in_actor_method994); if (state.failed) return retval;

            	    }
            	    break;

            	default :
            	    if ( cnt35 >= 1 ) break loop35;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(35, input);
                        throw eee;
                }
                cnt35++;
            } while (true);


            // TEMPLATE REWRITE
            if ( state.backtracking==0 ) {
              // 180:25: -> process(sensitive=$slist::namesname=$actor_method_decl.name)
              {
                  retval.st = templateLib.getInstanceOf("process",new STAttrMap().put("sensitive", ((slist_scope)slist_stack.peek()).names).put("name", (actor_method_decl14!=null?actor_method_decl14.name:null)));
              }


            }

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            slist_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "actor_method"


    public static class actor_method_decl_return extends ParserRuleReturnScope {
        public String  name;
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "actor_method_decl"
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:183:1: actor_method_decl returns [String name] : 'SC_METHOD(' n= ID ')' ;
    public final Systemc_basicParser.actor_method_decl_return actor_method_decl() throws RecognitionException {
        Systemc_basicParser.actor_method_decl_return retval = new Systemc_basicParser.actor_method_decl_return();
        retval.start = input.LT(1);


        Token n=null;

        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:184:2: ( 'SC_METHOD(' n= ID ')' )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:185:2: 'SC_METHOD(' n= ID ')'
            {
            match(input,35,FOLLOW_35_in_actor_method_decl1029); if (state.failed) return retval;

            n=(Token)match(input,ID,FOLLOW_ID_in_actor_method_decl1034); if (state.failed) return retval;

            match(input,26,FOLLOW_26_in_actor_method_decl1035); if (state.failed) return retval;

            if ( state.backtracking==0 ) {retval.name = (n!=null?n.getText():null) ;}

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "actor_method_decl"


    public static class actor_body_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "actor_body"
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:188:1: actor_body : ( actor_body_elt )+ ;
    public final Systemc_basicParser.actor_body_return actor_body() throws RecognitionException {
        Systemc_basicParser.actor_body_return retval = new Systemc_basicParser.actor_body_return();
        retval.start = input.LT(1);


        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:188:12: ( ( actor_body_elt )+ )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:188:14: ( actor_body_elt )+
            {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:188:14: ( actor_body_elt )+
            int cnt36=0;
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==ID||LA36_0==35) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:188:15: actor_body_elt
            	    {
            	    pushFollow(FOLLOW_actor_body_elt_in_actor_body1048);
            	    actor_body_elt();

            	    state._fsp--;
            	    if (state.failed) return retval;

            	    }
            	    break;

            	default :
            	    if ( cnt36 >= 1 ) break loop36;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(36, input);
                        throw eee;
                }
                cnt36++;
            } while (true);


            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "actor_body"


    public static class actor_body_elt_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "actor_body_elt"
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:192:1: actor_body_elt : (meth= actor_method | ( func_call SEMICOLON ) | ( connection SEMICOLON ) ) ;
    public final Systemc_basicParser.actor_body_elt_return actor_body_elt() throws RecognitionException {
        Systemc_basicParser.actor_body_elt_return retval = new Systemc_basicParser.actor_body_elt_return();
        retval.start = input.LT(1);


        Systemc_basicParser.actor_method_return meth =null;


        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:193:2: ( (meth= actor_method | ( func_call SEMICOLON ) | ( connection SEMICOLON ) ) )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:194:2: (meth= actor_method | ( func_call SEMICOLON ) | ( connection SEMICOLON ) )
            {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:194:2: (meth= actor_method | ( func_call SEMICOLON ) | ( connection SEMICOLON ) )
            int alt37=3;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==35) ) {
                alt37=1;
            }
            else if ( (LA37_0==ID) ) {
                int LA37_2 = input.LA(2);

                if ( (LA37_2==25) ) {
                    alt37=2;
                }
                else if ( (LA37_2==29) ) {
                    alt37=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 37, 2, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;

            }
            switch (alt37) {
                case 1 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:194:3: meth= actor_method
                    {
                    pushFollow(FOLLOW_actor_method_in_actor_body_elt1067);
                    meth=actor_method();

                    state._fsp--;
                    if (state.failed) return retval;

                    if ( state.backtracking==0 ) {((module_decl_scope)module_decl_stack.peek()).processes.put((meth!=null?meth.name:null), (meth!=null?meth.st:null));}

                    }
                    break;
                case 2 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:195:4: ( func_call SEMICOLON )
                    {
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:195:4: ( func_call SEMICOLON )
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:195:5: func_call SEMICOLON
                    {
                    pushFollow(FOLLOW_func_call_in_actor_body_elt1075);
                    func_call();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input,SEMICOLON,FOLLOW_SEMICOLON_in_actor_body_elt1077); if (state.failed) return retval;

                    }


                    }
                    break;
                case 3 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:196:3: ( connection SEMICOLON )
                    {
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:196:3: ( connection SEMICOLON )
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:196:4: connection SEMICOLON
                    {
                    pushFollow(FOLLOW_connection_in_actor_body_elt1083);
                    connection();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input,SEMICOLON,FOLLOW_SEMICOLON_in_actor_body_elt1085); if (state.failed) return retval;

                    }


                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "actor_body_elt"


    public static class signal_dec_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "signal_dec"
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:199:1: signal_dec : ( ( sc_signal ) name ( ',' name )* ( fixed_size_array )* ) -> signal(name=$slist::namestype=$sc_signal.st);
    public final Systemc_basicParser.signal_dec_return signal_dec() throws RecognitionException {
        slist_stack.push(new slist_scope());

        Systemc_basicParser.signal_dec_return retval = new Systemc_basicParser.signal_dec_return();
        retval.start = input.LT(1);


        Systemc_basicParser.sc_signal_return sc_signal15 =null;



          ((slist_scope)slist_stack.peek()).names = new ArrayList();

        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:203:2: ( ( ( sc_signal ) name ( ',' name )* ( fixed_size_array )* ) -> signal(name=$slist::namestype=$sc_signal.st))
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:204:2: ( ( sc_signal ) name ( ',' name )* ( fixed_size_array )* )
            {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:204:2: ( ( sc_signal ) name ( ',' name )* ( fixed_size_array )* )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:204:3: ( sc_signal ) name ( ',' name )* ( fixed_size_array )*
            {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:204:3: ( sc_signal )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:204:4: sc_signal
            {
            pushFollow(FOLLOW_sc_signal_in_signal_dec1110);
            sc_signal15=sc_signal();

            state._fsp--;
            if (state.failed) return retval;

            }


            pushFollow(FOLLOW_name_in_signal_dec1113);
            name();

            state._fsp--;
            if (state.failed) return retval;

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:204:20: ( ',' name )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==28) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:204:21: ',' name
            	    {
            	    match(input,28,FOLLOW_28_in_signal_dec1116); if (state.failed) return retval;

            	    pushFollow(FOLLOW_name_in_signal_dec1117);
            	    name();

            	    state._fsp--;
            	    if (state.failed) return retval;

            	    }
            	    break;

            	default :
            	    break loop38;
                }
            } while (true);


            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:204:32: ( fixed_size_array )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==37) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:204:32: fixed_size_array
            	    {
            	    pushFollow(FOLLOW_fixed_size_array_in_signal_dec1122);
            	    fixed_size_array();

            	    state._fsp--;
            	    if (state.failed) return retval;

            	    }
            	    break;

            	default :
            	    break loop39;
                }
            } while (true);


            }


            // TEMPLATE REWRITE
            if ( state.backtracking==0 ) {
              // 204:52: -> signal(name=$slist::namestype=$sc_signal.st)
              {
                  retval.st = templateLib.getInstanceOf("signal",new STAttrMap().put("name", ((slist_scope)slist_stack.peek()).names).put("type", (sc_signal15!=null?sc_signal15.st:null)));
              }


            }

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            slist_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "signal_dec"


    public static class sc_signal_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "sc_signal"
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:209:1: sc_signal : ( 'sc_signal' ( '_rv' )? '<' signal_type '>' ) -> dummy(val=$signal_type.st);
    public final Systemc_basicParser.sc_signal_return sc_signal() throws RecognitionException {
        Systemc_basicParser.sc_signal_return retval = new Systemc_basicParser.sc_signal_return();
        retval.start = input.LT(1);


        Systemc_basicParser.signal_type_return signal_type16 =null;


        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:209:11: ( ( 'sc_signal' ( '_rv' )? '<' signal_type '>' ) -> dummy(val=$signal_type.st))
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:210:2: ( 'sc_signal' ( '_rv' )? '<' signal_type '>' )
            {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:210:2: ( 'sc_signal' ( '_rv' )? '<' signal_type '>' )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:210:3: 'sc_signal' ( '_rv' )? '<' signal_type '>'
            {
            match(input,67,FOLLOW_67_in_sc_signal1156); if (state.failed) return retval;

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:210:14: ( '_rv' )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==40) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:210:15: '_rv'
                    {
                    match(input,40,FOLLOW_40_in_sc_signal1158); if (state.failed) return retval;

                    }
                    break;

            }


            match(input,LT,FOLLOW_LT_in_sc_signal1161); if (state.failed) return retval;

            pushFollow(FOLLOW_signal_type_in_sc_signal1164);
            signal_type16=signal_type();

            state._fsp--;
            if (state.failed) return retval;

            match(input,GT,FOLLOW_GT_in_sc_signal1167); if (state.failed) return retval;

            }


            // TEMPLATE REWRITE
            if ( state.backtracking==0 ) {
              // 210:46: -> dummy(val=$signal_type.st)
              {
                  retval.st = templateLib.getInstanceOf("dummy",new STAttrMap().put("val", (signal_type16!=null?signal_type16.st:null)));
              }


            }

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "sc_signal"


    public static class signal_type_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "signal_type"
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:213:1: signal_type : ( sc_type -> { $sc_type.st}| ID -> dummy(val=$ID.text));
    public final Systemc_basicParser.signal_type_return signal_type() throws RecognitionException {
        Systemc_basicParser.signal_type_return retval = new Systemc_basicParser.signal_type_return();
        retval.start = input.LT(1);


        Token ID18=null;
        Systemc_basicParser.sc_type_return sc_type17 =null;


        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:213:13: ( sc_type -> { $sc_type.st}| ID -> dummy(val=$ID.text))
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==41||(LA41_0 >= 62 && LA41_0 <= 63)||LA41_0==68) ) {
                alt41=1;
            }
            else if ( (LA41_0==ID) ) {
                alt41=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;

            }
            switch (alt41) {
                case 1 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:214:3: sc_type
                    {
                    pushFollow(FOLLOW_sc_type_in_signal_type1189);
                    sc_type17=sc_type();

                    state._fsp--;
                    if (state.failed) return retval;

                    // TEMPLATE REWRITE
                    if ( state.backtracking==0 ) {
                      // 214:11: -> { $sc_type.st}
                      {
                          retval.st =  (sc_type17!=null?sc_type17.st:null);
                      }


                    }

                    }
                    break;
                case 2 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:215:5: ID
                    {
                    ID18=(Token)match(input,ID,FOLLOW_ID_in_signal_type1198); if (state.failed) return retval;

                    // TEMPLATE REWRITE
                    if ( state.backtracking==0 ) {
                      // 215:8: -> dummy(val=$ID.text)
                      {
                          retval.st = templateLib.getInstanceOf("dummy",new STAttrMap().put("val", (ID18!=null?ID18.getText():null)));
                      }


                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "signal_type"


    public static class func_call_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "func_call"
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:218:1: func_call : ( ID ) '(' ( func_arg ( ',' func_arg )* )? ')' -> func_call(name=$ID.textargs=$slist::stack);
    public final Systemc_basicParser.func_call_return func_call() throws RecognitionException {
        slist_stack.push(new slist_scope());

        Systemc_basicParser.func_call_return retval = new Systemc_basicParser.func_call_return();
        retval.start = input.LT(1);


        Token ID19=null;


          ((slist_scope)slist_stack.peek()).stack = new ArrayList();

        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:223:2: ( ( ID ) '(' ( func_arg ( ',' func_arg )* )? ')' -> func_call(name=$ID.textargs=$slist::stack))
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:224:2: ( ID ) '(' ( func_arg ( ',' func_arg )* )? ')'
            {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:224:2: ( ID )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:224:3: ID
            {
            ID19=(Token)match(input,ID,FOLLOW_ID_in_func_call1231); if (state.failed) return retval;

            }


            match(input,25,FOLLOW_25_in_func_call1234); if (state.failed) return retval;

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:224:10: ( func_arg ( ',' func_arg )* )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==BIN||(LA43_0 >= HEX && LA43_0 <= INT)||LA43_0==STRING_LITERAL||LA43_0==25||LA43_0==45||(LA43_0 >= 53 && LA43_0 <= 54)) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:224:11: func_arg ( ',' func_arg )*
                    {
                    pushFollow(FOLLOW_func_arg_in_func_call1236);
                    func_arg();

                    state._fsp--;
                    if (state.failed) return retval;

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:224:20: ( ',' func_arg )*
                    loop42:
                    do {
                        int alt42=2;
                        int LA42_0 = input.LA(1);

                        if ( (LA42_0==28) ) {
                            alt42=1;
                        }


                        switch (alt42) {
                    	case 1 :
                    	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:224:21: ',' func_arg
                    	    {
                    	    match(input,28,FOLLOW_28_in_func_call1239); if (state.failed) return retval;

                    	    pushFollow(FOLLOW_func_arg_in_func_call1241);
                    	    func_arg();

                    	    state._fsp--;
                    	    if (state.failed) return retval;

                    	    }
                    	    break;

                    	default :
                    	    break loop42;
                        }
                    } while (true);


                    }
                    break;

            }


            match(input,26,FOLLOW_26_in_func_call1246); if (state.failed) return retval;

            // TEMPLATE REWRITE
            if ( state.backtracking==0 ) {
              // 224:41: -> func_call(name=$ID.textargs=$slist::stack)
              {
                  retval.st = templateLib.getInstanceOf("func_call",new STAttrMap().put("name", (ID19!=null?ID19.getText():null)).put("args", ((slist_scope)slist_stack.peek()).stack));
              }


            }

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            slist_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "func_call"


    public static class port_decl_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "port_decl"
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:227:1: port_decl : port_type name ( ',' name )* -> port(name=$slist::namestype=$port_type.st);
    public final Systemc_basicParser.port_decl_return port_decl() throws RecognitionException {
        slist_stack.push(new slist_scope());

        Systemc_basicParser.port_decl_return retval = new Systemc_basicParser.port_decl_return();
        retval.start = input.LT(1);


        Systemc_basicParser.port_type_return port_type20 =null;



          ((slist_scope)slist_stack.peek()).names = new ArrayList();

        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:231:2: ( port_type name ( ',' name )* -> port(name=$slist::namestype=$port_type.st))
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:232:2: port_type name ( ',' name )*
            {
            pushFollow(FOLLOW_port_type_in_port_decl1285);
            port_type20=port_type();

            state._fsp--;
            if (state.failed) return retval;

            pushFollow(FOLLOW_name_in_port_decl1287);
            name();

            state._fsp--;
            if (state.failed) return retval;

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:232:17: ( ',' name )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==28) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:232:18: ',' name
            	    {
            	    match(input,28,FOLLOW_28_in_port_decl1290); if (state.failed) return retval;

            	    pushFollow(FOLLOW_name_in_port_decl1292);
            	    name();

            	    state._fsp--;
            	    if (state.failed) return retval;

            	    }
            	    break;

            	default :
            	    break loop44;
                }
            } while (true);


            // TEMPLATE REWRITE
            if ( state.backtracking==0 ) {
              // 232:30: -> port(name=$slist::namestype=$port_type.st)
              {
                  retval.st = templateLib.getInstanceOf("port",new STAttrMap().put("name", ((slist_scope)slist_stack.peek()).names).put("type", (port_type20!=null?port_type20.st:null)));
              }


            }

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            slist_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "port_decl"


    public static class name_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "name"
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:236:1: name : ID ;
    public final Systemc_basicParser.name_return name() throws RecognitionException {
        Systemc_basicParser.name_return retval = new Systemc_basicParser.name_return();
        retval.start = input.LT(1);


        Token ID21=null;

        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:237:2: ( ID )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:238:2: ID
            {
            ID21=(Token)match(input,ID,FOLLOW_ID_in_name1324); if (state.failed) return retval;

            if ( state.backtracking==0 ) {((slist_scope)slist_stack.peek()).names.add((ID21!=null?ID21.getText():null));}

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "name"


    public static class port_type_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "port_type"
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:241:1: port_type : ( sc_clock -> clock_type(| sc_in -> input_type(type=$sc_in.st)| sc_out -> output_type(type=$sc_out.st)| sc_inout -> inout_type(type=$sc_inout.st));
    public final Systemc_basicParser.port_type_return port_type() throws RecognitionException {
        Systemc_basicParser.port_type_return retval = new Systemc_basicParser.port_type_return();
        retval.start = input.LT(1);


        Systemc_basicParser.sc_in_return sc_in22 =null;

        Systemc_basicParser.sc_out_return sc_out23 =null;

        Systemc_basicParser.sc_inout_return sc_inout24 =null;


        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:241:11: ( sc_clock -> clock_type(| sc_in -> input_type(type=$sc_in.st)| sc_out -> output_type(type=$sc_out.st)| sc_inout -> inout_type(type=$sc_inout.st))
            int alt45=4;
            switch ( input.LA(1) ) {
            case 56:
                {
                alt45=1;
                }
                break;
            case 55:
            case 57:
            case 58:
                {
                alt45=2;
                }
                break;
            case 64:
            case 65:
            case 66:
                {
                alt45=3;
                }
                break;
            case 59:
            case 60:
            case 61:
                {
                alt45=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;

            }

            switch (alt45) {
                case 1 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:242:3: sc_clock
                    {
                    pushFollow(FOLLOW_sc_clock_in_port_type1338);
                    sc_clock();

                    state._fsp--;
                    if (state.failed) return retval;

                    // TEMPLATE REWRITE
                    if ( state.backtracking==0 ) {
                      // 242:12: -> clock_type(
                      {
                          retval.st = templateLib.getInstanceOf("clock_type");
                      }


                    }

                    }
                    break;
                case 2 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:243:3: sc_in
                    {
                    pushFollow(FOLLOW_sc_in_in_port_type1348);
                    sc_in22=sc_in();

                    state._fsp--;
                    if (state.failed) return retval;

                    // TEMPLATE REWRITE
                    if ( state.backtracking==0 ) {
                      // 243:9: -> input_type(type=$sc_in.st)
                      {
                          retval.st = templateLib.getInstanceOf("input_type",new STAttrMap().put("type", (sc_in22!=null?sc_in22.st:null)));
                      }


                    }

                    }
                    break;
                case 3 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:244:3: sc_out
                    {
                    pushFollow(FOLLOW_sc_out_in_port_type1361);
                    sc_out23=sc_out();

                    state._fsp--;
                    if (state.failed) return retval;

                    // TEMPLATE REWRITE
                    if ( state.backtracking==0 ) {
                      // 244:10: -> output_type(type=$sc_out.st)
                      {
                          retval.st = templateLib.getInstanceOf("output_type",new STAttrMap().put("type", (sc_out23!=null?sc_out23.st:null)));
                      }


                    }

                    }
                    break;
                case 4 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:245:3: sc_inout
                    {
                    pushFollow(FOLLOW_sc_inout_in_port_type1374);
                    sc_inout24=sc_inout();

                    state._fsp--;
                    if (state.failed) return retval;

                    // TEMPLATE REWRITE
                    if ( state.backtracking==0 ) {
                      // 245:12: -> inout_type(type=$sc_inout.st)
                      {
                          retval.st = templateLib.getInstanceOf("inout_type",new STAttrMap().put("type", (sc_inout24!=null?sc_inout24.st:null)));
                      }


                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "port_type"


    public static class sc_inout_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "sc_inout"
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:249:1: sc_inout : ( 'sc_inout' ( LT ( sc_type ) GT ) -> dummy(val=$sc_type.st)| 'sc_inout_resolved' -> logic(| 'sc_inout_rv' ( LT ( INT ) GT ) -> logic_vector(size=$INT.text));
    public final Systemc_basicParser.sc_inout_return sc_inout() throws RecognitionException {
        Systemc_basicParser.sc_inout_return retval = new Systemc_basicParser.sc_inout_return();
        retval.start = input.LT(1);


        Token INT26=null;
        Systemc_basicParser.sc_type_return sc_type25 =null;


        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:249:10: ( 'sc_inout' ( LT ( sc_type ) GT ) -> dummy(val=$sc_type.st)| 'sc_inout_resolved' -> logic(| 'sc_inout_rv' ( LT ( INT ) GT ) -> logic_vector(size=$INT.text))
            int alt46=3;
            switch ( input.LA(1) ) {
            case 59:
                {
                alt46=1;
                }
                break;
            case 60:
                {
                alt46=2;
                }
                break;
            case 61:
                {
                alt46=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;

            }

            switch (alt46) {
                case 1 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:250:2: 'sc_inout' ( LT ( sc_type ) GT )
                    {
                    match(input,59,FOLLOW_59_in_sc_inout1395); if (state.failed) return retval;

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:250:12: ( LT ( sc_type ) GT )
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:250:13: LT ( sc_type ) GT
                    {
                    match(input,LT,FOLLOW_LT_in_sc_inout1397); if (state.failed) return retval;

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:250:16: ( sc_type )
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:250:17: sc_type
                    {
                    pushFollow(FOLLOW_sc_type_in_sc_inout1400);
                    sc_type25=sc_type();

                    state._fsp--;
                    if (state.failed) return retval;

                    }


                    match(input,GT,FOLLOW_GT_in_sc_inout1403); if (state.failed) return retval;

                    }


                    // TEMPLATE REWRITE
                    if ( state.backtracking==0 ) {
                      // 250:31: -> dummy(val=$sc_type.st)
                      {
                          retval.st = templateLib.getInstanceOf("dummy",new STAttrMap().put("val", (sc_type25!=null?sc_type25.st:null)));
                      }


                    }

                    }
                    break;
                case 2 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:251:4: 'sc_inout_resolved'
                    {
                    match(input,60,FOLLOW_60_in_sc_inout1418); if (state.failed) return retval;

                    // TEMPLATE REWRITE
                    if ( state.backtracking==0 ) {
                      // 251:26: -> logic(
                      {
                          retval.st = templateLib.getInstanceOf("logic");
                      }


                    }

                    }
                    break;
                case 3 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:252:4: 'sc_inout_rv' ( LT ( INT ) GT )
                    {
                    match(input,61,FOLLOW_61_in_sc_inout1431); if (state.failed) return retval;

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:252:17: ( LT ( INT ) GT )
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:252:18: LT ( INT ) GT
                    {
                    match(input,LT,FOLLOW_LT_in_sc_inout1433); if (state.failed) return retval;

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:252:21: ( INT )
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:252:22: INT
                    {
                    INT26=(Token)match(input,INT,FOLLOW_INT_in_sc_inout1436); if (state.failed) return retval;

                    }


                    match(input,GT,FOLLOW_GT_in_sc_inout1439); if (state.failed) return retval;

                    }


                    // TEMPLATE REWRITE
                    if ( state.backtracking==0 ) {
                      // 252:32: -> logic_vector(size=$INT.text)
                      {
                          retval.st = templateLib.getInstanceOf("logic_vector",new STAttrMap().put("size", (INT26!=null?INT26.getText():null)));
                      }


                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "sc_inout"


    public static class sc_out_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "sc_out"
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:256:1: sc_out : ( 'sc_out' ( LT ( sc_type ) GT ) -> dummy(val=$sc_type.st)| 'sc_out_resolved' -> logic(| 'sc_out_rv' ( LT ( INT ) GT ) -> logic_vector(size=$INT.text));
    public final Systemc_basicParser.sc_out_return sc_out() throws RecognitionException {
        Systemc_basicParser.sc_out_return retval = new Systemc_basicParser.sc_out_return();
        retval.start = input.LT(1);


        Token INT28=null;
        Systemc_basicParser.sc_type_return sc_type27 =null;


        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:256:8: ( 'sc_out' ( LT ( sc_type ) GT ) -> dummy(val=$sc_type.st)| 'sc_out_resolved' -> logic(| 'sc_out_rv' ( LT ( INT ) GT ) -> logic_vector(size=$INT.text))
            int alt47=3;
            switch ( input.LA(1) ) {
            case 64:
                {
                alt47=1;
                }
                break;
            case 65:
                {
                alt47=2;
                }
                break;
            case 66:
                {
                alt47=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;

            }

            switch (alt47) {
                case 1 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:257:2: 'sc_out' ( LT ( sc_type ) GT )
                    {
                    match(input,64,FOLLOW_64_in_sc_out1464); if (state.failed) return retval;

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:257:11: ( LT ( sc_type ) GT )
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:257:12: LT ( sc_type ) GT
                    {
                    match(input,LT,FOLLOW_LT_in_sc_out1467); if (state.failed) return retval;

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:257:15: ( sc_type )
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:257:16: sc_type
                    {
                    pushFollow(FOLLOW_sc_type_in_sc_out1470);
                    sc_type27=sc_type();

                    state._fsp--;
                    if (state.failed) return retval;

                    }


                    match(input,GT,FOLLOW_GT_in_sc_out1474); if (state.failed) return retval;

                    }


                    // TEMPLATE REWRITE
                    if ( state.backtracking==0 ) {
                      // 257:30: -> dummy(val=$sc_type.st)
                      {
                          retval.st = templateLib.getInstanceOf("dummy",new STAttrMap().put("val", (sc_type27!=null?sc_type27.st:null)));
                      }


                    }

                    }
                    break;
                case 2 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:258:4: 'sc_out_resolved'
                    {
                    match(input,65,FOLLOW_65_in_sc_out1488); if (state.failed) return retval;

                    // TEMPLATE REWRITE
                    if ( state.backtracking==0 ) {
                      // 258:23: -> logic(
                      {
                          retval.st = templateLib.getInstanceOf("logic");
                      }


                    }

                    }
                    break;
                case 3 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:259:4: 'sc_out_rv' ( LT ( INT ) GT )
                    {
                    match(input,66,FOLLOW_66_in_sc_out1501); if (state.failed) return retval;

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:259:15: ( LT ( INT ) GT )
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:259:16: LT ( INT ) GT
                    {
                    match(input,LT,FOLLOW_LT_in_sc_out1503); if (state.failed) return retval;

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:259:20: ( INT )
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:259:21: INT
                    {
                    INT28=(Token)match(input,INT,FOLLOW_INT_in_sc_out1507); if (state.failed) return retval;

                    }


                    match(input,GT,FOLLOW_GT_in_sc_out1510); if (state.failed) return retval;

                    }


                    // TEMPLATE REWRITE
                    if ( state.backtracking==0 ) {
                      // 259:31: -> logic_vector(size=$INT.text)
                      {
                          retval.st = templateLib.getInstanceOf("logic_vector",new STAttrMap().put("size", (INT28!=null?INT28.getText():null)));
                      }


                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "sc_out"


    public static class sc_in_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "sc_in"
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:262:1: sc_in : ( 'sc_in' ( LT ( sc_type ) GT ) -> dummy(val=$sc_type.st)| 'sc_in_resolved' -> logic(| 'sc_in_rv' ( LT ( INT ) GT ) -> logic_vector(size=$INT.text));
    public final Systemc_basicParser.sc_in_return sc_in() throws RecognitionException {
        Systemc_basicParser.sc_in_return retval = new Systemc_basicParser.sc_in_return();
        retval.start = input.LT(1);


        Token INT30=null;
        Systemc_basicParser.sc_type_return sc_type29 =null;


        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:262:7: ( 'sc_in' ( LT ( sc_type ) GT ) -> dummy(val=$sc_type.st)| 'sc_in_resolved' -> logic(| 'sc_in_rv' ( LT ( INT ) GT ) -> logic_vector(size=$INT.text))
            int alt48=3;
            switch ( input.LA(1) ) {
            case 55:
                {
                alt48=1;
                }
                break;
            case 57:
                {
                alt48=2;
                }
                break;
            case 58:
                {
                alt48=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;

            }

            switch (alt48) {
                case 1 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:263:2: 'sc_in' ( LT ( sc_type ) GT )
                    {
                    match(input,55,FOLLOW_55_in_sc_in1532); if (state.failed) return retval;

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:263:9: ( LT ( sc_type ) GT )
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:263:10: LT ( sc_type ) GT
                    {
                    match(input,LT,FOLLOW_LT_in_sc_in1534); if (state.failed) return retval;

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:263:13: ( sc_type )
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:263:14: sc_type
                    {
                    pushFollow(FOLLOW_sc_type_in_sc_in1537);
                    sc_type29=sc_type();

                    state._fsp--;
                    if (state.failed) return retval;

                    }


                    match(input,GT,FOLLOW_GT_in_sc_in1541); if (state.failed) return retval;

                    }


                    // TEMPLATE REWRITE
                    if ( state.backtracking==0 ) {
                      // 263:28: -> dummy(val=$sc_type.st)
                      {
                          retval.st = templateLib.getInstanceOf("dummy",new STAttrMap().put("val", (sc_type29!=null?sc_type29.st:null)));
                      }


                    }

                    }
                    break;
                case 2 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:264:4: 'sc_in_resolved'
                    {
                    match(input,57,FOLLOW_57_in_sc_in1555); if (state.failed) return retval;

                    // TEMPLATE REWRITE
                    if ( state.backtracking==0 ) {
                      // 264:22: -> logic(
                      {
                          retval.st = templateLib.getInstanceOf("logic");
                      }


                    }

                    }
                    break;
                case 3 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:265:4: 'sc_in_rv' ( LT ( INT ) GT )
                    {
                    match(input,58,FOLLOW_58_in_sc_in1568); if (state.failed) return retval;

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:265:14: ( LT ( INT ) GT )
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:265:15: LT ( INT ) GT
                    {
                    match(input,LT,FOLLOW_LT_in_sc_in1570); if (state.failed) return retval;

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:265:18: ( INT )
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:265:20: INT
                    {
                    INT30=(Token)match(input,INT,FOLLOW_INT_in_sc_in1574); if (state.failed) return retval;

                    }


                    match(input,GT,FOLLOW_GT_in_sc_in1577); if (state.failed) return retval;

                    }


                    // TEMPLATE REWRITE
                    if ( state.backtracking==0 ) {
                      // 265:30: -> logic_vector(size=$INT.text)
                      {
                          retval.st = templateLib.getInstanceOf("logic_vector",new STAttrMap().put("size", (INT30!=null?INT30.getText():null)));
                      }


                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "sc_in"


    public static class sc_clock_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "sc_clock"
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:268:1: sc_clock : 'sc_in_clk' ;
    public final Systemc_basicParser.sc_clock_return sc_clock() throws RecognitionException {
        Systemc_basicParser.sc_clock_return retval = new Systemc_basicParser.sc_clock_return();
        retval.start = input.LT(1);


        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:268:10: ( 'sc_in_clk' )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:269:2: 'sc_in_clk'
            {
            match(input,56,FOLLOW_56_in_sc_clock1599); if (state.failed) return retval;

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "sc_clock"


    public static class func_body_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "func_body"
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:273:1: func_body : block -> func_body(declarations=$block.varsoperations=$block.elts);
    public final Systemc_basicParser.func_body_return func_body() throws RecognitionException {
        Systemc_basicParser.func_body_return retval = new Systemc_basicParser.func_body_return();
        retval.start = input.LT(1);


        Systemc_basicParser.block_return block31 =null;


        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:274:2: ( block -> func_body(declarations=$block.varsoperations=$block.elts))
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:275:2: block
            {
            pushFollow(FOLLOW_block_in_func_body1612);
            block31=block();

            state._fsp--;
            if (state.failed) return retval;

            // TEMPLATE REWRITE
            if ( state.backtracking==0 ) {
              // 275:8: -> func_body(declarations=$block.varsoperations=$block.elts)
              {
                  retval.st = templateLib.getInstanceOf("func_body",new STAttrMap().put("declarations", (block31!=null?block31.vars:null)).put("operations", (block31!=null?block31.elts:null)));
              }


            }

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "func_body"


    public static class block_return extends ParserRuleReturnScope {
        public List  elts;
        public HashMap vars;
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "block"
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:278:1: block returns [List elts, HashMap vars] : '{' ( variable_decl[$vars] SEMICOLON | sc_assignement SEMICOLON | v_assignement SEMICOLON | cconstruct | func_call SEMICOLON | flux SEMICOLON )* '}' ;
    public final Systemc_basicParser.block_return block() throws RecognitionException {
        Systemc_basicParser.block_return retval = new Systemc_basicParser.block_return();
        retval.start = input.LT(1);


        Systemc_basicParser.sc_assignement_return sc_assignement32 =null;

        Systemc_basicParser.v_assignement_return v_assignement33 =null;

        Systemc_basicParser.cconstruct_return cconstruct34 =null;



          retval.elts = new ArrayList();
          retval.vars = new HashMap();

        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:283:2: ( '{' ( variable_decl[$vars] SEMICOLON | sc_assignement SEMICOLON | v_assignement SEMICOLON | cconstruct | func_call SEMICOLON | flux SEMICOLON )* '}' )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:285:2: '{' ( variable_decl[$vars] SEMICOLON | sc_assignement SEMICOLON | v_assignement SEMICOLON | cconstruct | func_call SEMICOLON | flux SEMICOLON )* '}'
            {
            match(input,75,FOLLOW_75_in_block1652); if (state.failed) return retval;

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:286:2: ( variable_decl[$vars] SEMICOLON | sc_assignement SEMICOLON | v_assignement SEMICOLON | cconstruct | func_call SEMICOLON | flux SEMICOLON )*
            loop49:
            do {
                int alt49=7;
                switch ( input.LA(1) ) {
                case 41:
                case 44:
                case 49:
                case 51:
                case 52:
                case 62:
                case 63:
                case 68:
                case 70:
                case 71:
                case 73:
                case 74:
                    {
                    alt49=1;
                    }
                    break;
                case ID:
                    {
                    switch ( input.LA(2) ) {
                    case 30:
                        {
                        alt49=2;
                        }
                        break;
                    case EQUAL:
                        {
                        alt49=3;
                        }
                        break;
                    case 25:
                        {
                        alt49=5;
                        }
                        break;
                    case 32:
                    case 33:
                        {
                        alt49=6;
                        }
                        break;
                    case ID:
                    case LT:
                    case 27:
                    case 38:
                        {
                        alt49=1;
                        }
                        break;

                    }

                    }
                    break;
                case 50:
                case 72:
                    {
                    alt49=4;
                    }
                    break;

                }

                switch (alt49) {
            	case 1 :
            	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:286:3: variable_decl[$vars] SEMICOLON
            	    {
            	    pushFollow(FOLLOW_variable_decl_in_block1656);
            	    variable_decl(retval.vars);

            	    state._fsp--;
            	    if (state.failed) return retval;

            	    match(input,SEMICOLON,FOLLOW_SEMICOLON_in_block1659); if (state.failed) return retval;

            	    }
            	    break;
            	case 2 :
            	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:287:3: sc_assignement SEMICOLON
            	    {
            	    pushFollow(FOLLOW_sc_assignement_in_block1663);
            	    sc_assignement32=sc_assignement();

            	    state._fsp--;
            	    if (state.failed) return retval;

            	    match(input,SEMICOLON,FOLLOW_SEMICOLON_in_block1665); if (state.failed) return retval;

            	    if ( state.backtracking==0 ) { retval.elts.add((sc_assignement32!=null?sc_assignement32.st:null));}

            	    }
            	    break;
            	case 3 :
            	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:288:3: v_assignement SEMICOLON
            	    {
            	    pushFollow(FOLLOW_v_assignement_in_block1670);
            	    v_assignement33=v_assignement();

            	    state._fsp--;
            	    if (state.failed) return retval;

            	    match(input,SEMICOLON,FOLLOW_SEMICOLON_in_block1672); if (state.failed) return retval;

            	    if ( state.backtracking==0 ) { retval.elts.add((v_assignement33!=null?v_assignement33.st:null));}

            	    }
            	    break;
            	case 4 :
            	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:289:3: cconstruct
            	    {
            	    pushFollow(FOLLOW_cconstruct_in_block1677);
            	    cconstruct34=cconstruct();

            	    state._fsp--;
            	    if (state.failed) return retval;

            	    if ( state.backtracking==0 ) { retval.elts.add((cconstruct34!=null?cconstruct34.st:null));}

            	    }
            	    break;
            	case 5 :
            	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:290:3: func_call SEMICOLON
            	    {
            	    pushFollow(FOLLOW_func_call_in_block1684);
            	    func_call();

            	    state._fsp--;
            	    if (state.failed) return retval;

            	    match(input,SEMICOLON,FOLLOW_SEMICOLON_in_block1686); if (state.failed) return retval;

            	    }
            	    break;
            	case 6 :
            	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:291:4: flux SEMICOLON
            	    {
            	    pushFollow(FOLLOW_flux_in_block1691);
            	    flux();

            	    state._fsp--;
            	    if (state.failed) return retval;

            	    match(input,SEMICOLON,FOLLOW_SEMICOLON_in_block1693); if (state.failed) return retval;

            	    }
            	    break;

            	default :
            	    break loop49;
                }
            } while (true);


            match(input,77,FOLLOW_77_in_block1698); if (state.failed) return retval;

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "block"


    public static class cconstruct_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "cconstruct"
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:295:1: cconstruct : ( case_construct -> dummy(val=$case_construct.st)| if_construct -> dummy(val=$if_construct.st));
    public final Systemc_basicParser.cconstruct_return cconstruct() throws RecognitionException {
        Systemc_basicParser.cconstruct_return retval = new Systemc_basicParser.cconstruct_return();
        retval.start = input.LT(1);


        Systemc_basicParser.case_construct_return case_construct35 =null;

        Systemc_basicParser.if_construct_return if_construct36 =null;


        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:296:2: ( case_construct -> dummy(val=$case_construct.st)| if_construct -> dummy(val=$if_construct.st))
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==72) ) {
                alt50=1;
            }
            else if ( (LA50_0==50) ) {
                alt50=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;

            }
            switch (alt50) {
                case 1 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:297:2: case_construct
                    {
                    pushFollow(FOLLOW_case_construct_in_cconstruct1711);
                    case_construct35=case_construct();

                    state._fsp--;
                    if (state.failed) return retval;

                    // TEMPLATE REWRITE
                    if ( state.backtracking==0 ) {
                      // 297:17: -> dummy(val=$case_construct.st)
                      {
                          retval.st = templateLib.getInstanceOf("dummy",new STAttrMap().put("val", (case_construct35!=null?case_construct35.st:null)));
                      }


                    }

                    }
                    break;
                case 2 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:298:3: if_construct
                    {
                    pushFollow(FOLLOW_if_construct_in_cconstruct1725);
                    if_construct36=if_construct();

                    state._fsp--;
                    if (state.failed) return retval;

                    // TEMPLATE REWRITE
                    if ( state.backtracking==0 ) {
                      // 298:16: -> dummy(val=$if_construct.st)
                      {
                          retval.st = templateLib.getInstanceOf("dummy",new STAttrMap().put("val", (if_construct36!=null?if_construct36.st:null)));
                      }


                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "cconstruct"


    public static class if_construct_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "if_construct"
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:301:1: if_construct : 'if' '(' cond ')' ( if_content ) ( elsif_construct )* -> if_construct(condition=$cond.stelts=$if_content.contentalternatives= $slist::stack);
    public final Systemc_basicParser.if_construct_return if_construct() throws RecognitionException {
        slist_stack.push(new slist_scope());

        Systemc_basicParser.if_construct_return retval = new Systemc_basicParser.if_construct_return();
        retval.start = input.LT(1);


        Systemc_basicParser.elsif_construct_return elsif_construct37 =null;

        Systemc_basicParser.cond_return cond38 =null;

        Systemc_basicParser.if_content_return if_content39 =null;



          ((slist_scope)slist_stack.peek()).stack = new ArrayList();

        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:306:2: ( 'if' '(' cond ')' ( if_content ) ( elsif_construct )* -> if_construct(condition=$cond.stelts=$if_content.contentalternatives= $slist::stack))
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:307:2: 'if' '(' cond ')' ( if_content ) ( elsif_construct )*
            {
            match(input,50,FOLLOW_50_in_if_construct1757); if (state.failed) return retval;

            match(input,25,FOLLOW_25_in_if_construct1758); if (state.failed) return retval;

            pushFollow(FOLLOW_cond_in_if_construct1759);
            cond38=cond();

            state._fsp--;
            if (state.failed) return retval;

            match(input,26,FOLLOW_26_in_if_construct1761); if (state.failed) return retval;

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:307:17: ( if_content )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:307:19: if_content
            {
            pushFollow(FOLLOW_if_content_in_if_construct1764);
            if_content39=if_content();

            state._fsp--;
            if (state.failed) return retval;

            }


            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:308:2: ( elsif_construct )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==47) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:308:3: elsif_construct
            	    {
            	    pushFollow(FOLLOW_elsif_construct_in_if_construct1769);
            	    elsif_construct37=elsif_construct();

            	    state._fsp--;
            	    if (state.failed) return retval;

            	    if ( state.backtracking==0 ) { ((slist_scope)slist_stack.peek()).stack.add((elsif_construct37!=null?elsif_construct37.st:null));}

            	    }
            	    break;

            	default :
            	    break loop51;
                }
            } while (true);


            // TEMPLATE REWRITE
            if ( state.backtracking==0 ) {
              // 308:65: -> if_construct(condition=$cond.stelts=$if_content.contentalternatives= $slist::stack)
              {
                  retval.st = templateLib.getInstanceOf("if_construct",new STAttrMap().put("condition", (cond38!=null?cond38.st:null)).put("elts", (if_content39!=null?if_content39.content:null)).put("alternatives",  ((slist_scope)slist_stack.peek()).stack));
              }


            }

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            slist_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "if_construct"


    public static class elsif_construct_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "elsif_construct"
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:311:1: elsif_construct : 'else' ( 'if' '(' cond ')' (ifc= if_content ) -> elsif_construct(condition=$cond.stelts=$ifc.content)|elsec= if_content -> else_construct(elts=$elsec.content)) ;
    public final Systemc_basicParser.elsif_construct_return elsif_construct() throws RecognitionException {
        Systemc_basicParser.elsif_construct_return retval = new Systemc_basicParser.elsif_construct_return();
        retval.start = input.LT(1);


        Systemc_basicParser.if_content_return ifc =null;

        Systemc_basicParser.if_content_return elsec =null;

        Systemc_basicParser.cond_return cond40 =null;


        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:312:2: ( 'else' ( 'if' '(' cond ')' (ifc= if_content ) -> elsif_construct(condition=$cond.stelts=$ifc.content)|elsec= if_content -> else_construct(elts=$elsec.content)) )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:313:2: 'else' ( 'if' '(' cond ')' (ifc= if_content ) -> elsif_construct(condition=$cond.stelts=$ifc.content)|elsec= if_content -> else_construct(elts=$elsec.content))
            {
            match(input,47,FOLLOW_47_in_elsif_construct1812); if (state.failed) return retval;

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:314:2: ( 'if' '(' cond ')' (ifc= if_content ) -> elsif_construct(condition=$cond.stelts=$ifc.content)|elsec= if_content -> else_construct(elts=$elsec.content))
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==50) ) {
                alt52=1;
            }
            else if ( (LA52_0==ID||LA52_0==75) ) {
                alt52=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;

            }
            switch (alt52) {
                case 1 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:314:3: 'if' '(' cond ')' (ifc= if_content )
                    {
                    match(input,50,FOLLOW_50_in_elsif_construct1817); if (state.failed) return retval;

                    match(input,25,FOLLOW_25_in_elsif_construct1818); if (state.failed) return retval;

                    pushFollow(FOLLOW_cond_in_elsif_construct1819);
                    cond40=cond();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input,26,FOLLOW_26_in_elsif_construct1821); if (state.failed) return retval;

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:314:19: (ifc= if_content )
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:314:20: ifc= if_content
                    {
                    pushFollow(FOLLOW_if_content_in_elsif_construct1828);
                    ifc=if_content();

                    state._fsp--;
                    if (state.failed) return retval;

                    }


                    // TEMPLATE REWRITE
                    if ( state.backtracking==0 ) {
                      // 314:38: -> elsif_construct(condition=$cond.stelts=$ifc.content)
                      {
                          retval.st = templateLib.getInstanceOf("elsif_construct",new STAttrMap().put("condition", (cond40!=null?cond40.st:null)).put("elts", (ifc!=null?ifc.content:null)));
                      }


                    }

                    }
                    break;
                case 2 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:315:3: elsec= if_content
                    {
                    pushFollow(FOLLOW_if_content_in_elsif_construct1854);
                    elsec=if_content();

                    state._fsp--;
                    if (state.failed) return retval;

                    // TEMPLATE REWRITE
                    if ( state.backtracking==0 ) {
                      // 315:22: -> else_construct(elts=$elsec.content)
                      {
                          retval.st = templateLib.getInstanceOf("else_construct",new STAttrMap().put("elts", (elsec!=null?elsec.content:null)));
                      }


                    }

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "elsif_construct"


    public static class if_content_return extends ParserRuleReturnScope {
        public List content;
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "if_content"
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:320:1: if_content returns [List content] : ( ( v_assignement ) SEMICOLON | block );
    public final Systemc_basicParser.if_content_return if_content() throws RecognitionException {
        Systemc_basicParser.if_content_return retval = new Systemc_basicParser.if_content_return();
        retval.start = input.LT(1);


        Systemc_basicParser.v_assignement_return v_assignement41 =null;

        Systemc_basicParser.block_return block42 =null;



          retval.content = new ArrayList();

        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:324:2: ( ( v_assignement ) SEMICOLON | block )
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==ID) ) {
                alt53=1;
            }
            else if ( (LA53_0==75) ) {
                alt53=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;

            }
            switch (alt53) {
                case 1 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:325:2: ( v_assignement ) SEMICOLON
                    {
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:325:2: ( v_assignement )
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:325:3: v_assignement
                    {
                    pushFollow(FOLLOW_v_assignement_in_if_content1890);
                    v_assignement41=v_assignement();

                    state._fsp--;
                    if (state.failed) return retval;

                    }


                    match(input,SEMICOLON,FOLLOW_SEMICOLON_in_if_content1893); if (state.failed) return retval;

                    if ( state.backtracking==0 ) {retval.content.add((v_assignement41!=null?v_assignement41.st:null));}

                    }
                    break;
                case 2 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:326:4: block
                    {
                    pushFollow(FOLLOW_block_in_if_content1900);
                    block42=block();

                    state._fsp--;
                    if (state.failed) return retval;

                    if ( state.backtracking==0 ) {retval.content.addAll((block42!=null?block42.elts:null));}

                    }
                    break;

            }
            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "if_content"


    protected static class cond_scope {
        List vals;
        List ops;
    }
    protected Stack cond_stack = new Stack();


    public static class cond_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "cond"
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:329:1: cond : test_express -> dummy(val=$test_express.st);
    public final Systemc_basicParser.cond_return cond() throws RecognitionException {
        cond_stack.push(new cond_scope());
        Systemc_basicParser.cond_return retval = new Systemc_basicParser.cond_return();
        retval.start = input.LT(1);


        Systemc_basicParser.test_express_return test_express43 =null;



          ((cond_scope)cond_stack.peek()).vals = new ArrayList();
          ((cond_scope)cond_stack.peek()).ops = new ArrayList();

        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:338:2: ( test_express -> dummy(val=$test_express.st))
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:340:3: test_express
            {
            pushFollow(FOLLOW_test_express_in_cond1930);
            test_express43=test_express();

            state._fsp--;
            if (state.failed) return retval;

            // TEMPLATE REWRITE
            if ( state.backtracking==0 ) {
              // 340:17: -> dummy(val=$test_express.st)
              {
                  retval.st = templateLib.getInstanceOf("dummy",new STAttrMap().put("val", (test_express43!=null?test_express43.st:null)));
              }


            }

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            cond_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "cond"


    protected static class test_express_scope {
        List vals;
        List ops;
    }
    protected Stack test_express_stack = new Stack();


    public static class test_express_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "test_express"
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:343:1: test_express options {backtrack=true; } : ( ( test ) ( expr_right[$test_express::vals, $test_express::ops] )* -> conditions(vals=$test_express::valsops=$test_express::ops)| enclosed_expr -> dummy(val=$enclosed_expr.st));
    public final Systemc_basicParser.test_express_return test_express() throws RecognitionException {
        test_express_stack.push(new test_express_scope());
        Systemc_basicParser.test_express_return retval = new Systemc_basicParser.test_express_return();
        retval.start = input.LT(1);


        Systemc_basicParser.test_return test44 =null;

        Systemc_basicParser.enclosed_expr_return enclosed_expr45 =null;



          ((test_express_scope)test_express_stack.peek()).vals = new ArrayList();
          ((test_express_scope)test_express_stack.peek()).ops = new ArrayList();

        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:353:2: ( ( test ) ( expr_right[$test_express::vals, $test_express::ops] )* -> conditions(vals=$test_express::valsops=$test_express::ops)| enclosed_expr -> dummy(val=$enclosed_expr.st))
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==BIN||(LA55_0 >= HEX && LA55_0 <= INT)||LA55_0==NOT||LA55_0==STRING_LITERAL||LA55_0==45||(LA55_0 >= 53 && LA55_0 <= 54)) ) {
                alt55=1;
            }
            else if ( (LA55_0==25) ) {
                int LA55_10 = input.LA(2);

                if ( (synpred1_Systemc_basic()) ) {
                    alt55=1;
                }
                else if ( (true) ) {
                    alt55=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 55, 10, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 55, 0, input);

                throw nvae;

            }
            switch (alt55) {
                case 1 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:356:2: ( test ) ( expr_right[$test_express::vals, $test_express::ops] )*
                    {
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:356:2: ( test )
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:356:4: test
                    {
                    pushFollow(FOLLOW_test_in_test_express1977);
                    test44=test();

                    state._fsp--;
                    if (state.failed) return retval;

                    if ( state.backtracking==0 ) {((test_express_scope)test_express_stack.peek()).vals.add((test44!=null?test44.st:null));}

                    }


                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:356:49: ( expr_right[$test_express::vals, $test_express::ops] )*
                    loop54:
                    do {
                        int alt54=2;
                        int LA54_0 = input.LA(1);

                        if ( (LA54_0==24) ) {
                            alt54=1;
                        }
                        else if ( (LA54_0==76) ) {
                            alt54=1;
                        }


                        switch (alt54) {
                    	case 1 :
                    	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:356:50: expr_right[$test_express::vals, $test_express::ops]
                    	    {
                    	    pushFollow(FOLLOW_expr_right_in_test_express1985);
                    	    expr_right(((test_express_scope)test_express_stack.peek()).vals, ((test_express_scope)test_express_stack.peek()).ops);

                    	    state._fsp--;
                    	    if (state.failed) return retval;

                    	    }
                    	    break;

                    	default :
                    	    break loop54;
                        }
                    } while (true);


                    // TEMPLATE REWRITE
                    if ( state.backtracking==0 ) {
                      // 356:104: -> conditions(vals=$test_express::valsops=$test_express::ops)
                      {
                          retval.st = templateLib.getInstanceOf("conditions",new STAttrMap().put("vals", ((test_express_scope)test_express_stack.peek()).vals).put("ops", ((test_express_scope)test_express_stack.peek()).ops));
                      }


                    }

                    }
                    break;
                case 2 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:357:4: enclosed_expr
                    {
                    pushFollow(FOLLOW_enclosed_expr_in_test_express2012);
                    enclosed_expr45=enclosed_expr();

                    state._fsp--;
                    if (state.failed) return retval;

                    // TEMPLATE REWRITE
                    if ( state.backtracking==0 ) {
                      // 357:19: -> dummy(val=$enclosed_expr.st)
                      {
                          retval.st = templateLib.getInstanceOf("dummy",new STAttrMap().put("val", (enclosed_expr45!=null?enclosed_expr45.st:null)));
                      }


                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            test_express_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "test_express"


    public static class enclosed_expr_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "enclosed_expr"
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:360:1: enclosed_expr : '(' expr= test_express ')' -> enclosed(val=$expr.st);
    public final Systemc_basicParser.enclosed_expr_return enclosed_expr() throws RecognitionException {
        Systemc_basicParser.enclosed_expr_return retval = new Systemc_basicParser.enclosed_expr_return();
        retval.start = input.LT(1);


        Systemc_basicParser.test_express_return expr =null;


        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:360:15: ( '(' expr= test_express ')' -> enclosed(val=$expr.st))
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:361:2: '(' expr= test_express ')'
            {
            match(input,25,FOLLOW_25_in_enclosed_expr2036); if (state.failed) return retval;

            pushFollow(FOLLOW_test_express_in_enclosed_expr2043);
            expr=test_express();

            state._fsp--;
            if (state.failed) return retval;

            match(input,26,FOLLOW_26_in_enclosed_expr2047); if (state.failed) return retval;

            // TEMPLATE REWRITE
            if ( state.backtracking==0 ) {
              // 361:33: -> enclosed(val=$expr.st)
              {
                  retval.st = templateLib.getInstanceOf("enclosed",new STAttrMap().put("val", (expr!=null?expr.st:null)));
              }


            }

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "enclosed_expr"


    public static class expr_right_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "expr_right"
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:364:1: expr_right[List vals, List ops] : ( logic_op t2= test_express ) ;
    public final Systemc_basicParser.expr_right_return expr_right(List vals, List ops) throws RecognitionException {
        Systemc_basicParser.expr_right_return retval = new Systemc_basicParser.expr_right_return();
        retval.start = input.LT(1);


        Systemc_basicParser.test_express_return t2 =null;

        Systemc_basicParser.logic_op_return logic_op46 =null;


        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:364:33: ( ( logic_op t2= test_express ) )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:365:3: ( logic_op t2= test_express )
            {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:365:3: ( logic_op t2= test_express )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:365:4: logic_op t2= test_express
            {
            pushFollow(FOLLOW_logic_op_in_expr_right2074);
            logic_op46=logic_op();

            state._fsp--;
            if (state.failed) return retval;

            if ( state.backtracking==0 ) {ops.add((logic_op46!=null?logic_op46.st:null));}

            pushFollow(FOLLOW_test_express_in_expr_right2083);
            t2=test_express();

            state._fsp--;
            if (state.failed) return retval;

            if ( state.backtracking==0 ) {vals.add((t2!=null?t2.st:null));}

            }


            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "expr_right"


    public static class test_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "test"
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:368:1: test : (not= ( NOT ) )? l= value (op= comp_op r= value )? -> test(neg=$not.textl=$l.str=$r.stoperand=$op.text);
    public final Systemc_basicParser.test_return test() throws RecognitionException {
        Systemc_basicParser.test_return retval = new Systemc_basicParser.test_return();
        retval.start = input.LT(1);


        Token not=null;
        Systemc_basicParser.value_return l =null;

        Systemc_basicParser.comp_op_return op =null;

        Systemc_basicParser.value_return r =null;


        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:368:6: ( (not= ( NOT ) )? l= value (op= comp_op r= value )? -> test(neg=$not.textl=$l.str=$r.stoperand=$op.text))
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:369:2: (not= ( NOT ) )? l= value (op= comp_op r= value )?
            {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:369:6: (not= ( NOT ) )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==NOT) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:369:6: not= ( NOT )
                    {
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:369:7: ( NOT )
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:369:9: NOT
                    {
                    match(input,NOT,FOLLOW_NOT_in_test2102); if (state.failed) return retval;

                    }


                    }
                    break;

            }


            pushFollow(FOLLOW_value_in_test2113);
            l=value();

            state._fsp--;
            if (state.failed) return retval;

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:370:12: (op= comp_op r= value )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==EQUAL||LA57_0==GT||(LA57_0 >= LT && LA57_0 <= NOT)) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:370:14: op= comp_op r= value
                    {
                    pushFollow(FOLLOW_comp_op_in_test2119);
                    op=comp_op();

                    state._fsp--;
                    if (state.failed) return retval;

                    pushFollow(FOLLOW_value_in_test2125);
                    r=value();

                    state._fsp--;
                    if (state.failed) return retval;

                    }
                    break;

            }


            // TEMPLATE REWRITE
            if ( state.backtracking==0 ) {
              // 370:39: -> test(neg=$not.textl=$l.str=$r.stoperand=$op.text)
              {
                  retval.st = templateLib.getInstanceOf("test",new STAttrMap().put("neg", (not!=null?not.getText():null)).put("l", (l!=null?l.st:null)).put("r", (r!=null?r.st:null)).put("operand", (op!=null?input.toString(op.start,op.stop):null)));
              }


            }

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "test"


    public static class comp_op_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "comp_op"
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:373:1: comp_op : ( LT | GT | NOT | '=' ) ( '=' )? ;
    public final Systemc_basicParser.comp_op_return comp_op() throws RecognitionException {
        Systemc_basicParser.comp_op_return retval = new Systemc_basicParser.comp_op_return();
        retval.start = input.LT(1);


        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:373:9: ( ( LT | GT | NOT | '=' ) ( '=' )? )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:374:2: ( LT | GT | NOT | '=' ) ( '=' )?
            {
            if ( input.LA(1)==EQUAL||input.LA(1)==GT||(input.LA(1) >= LT && input.LA(1) <= NOT) ) {
                input.consume();
                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:374:23: ( '=' )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==EQUAL) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:374:24: '='
                    {
                    match(input,EQUAL,FOLLOW_EQUAL_in_comp_op2189); if (state.failed) return retval;

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "comp_op"


    public static class logic_op_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "logic_op"
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:376:1: logic_op : ( '&&' -> vhdl_and(| '||' -> vhdl_or();
    public final Systemc_basicParser.logic_op_return logic_op() throws RecognitionException {
        Systemc_basicParser.logic_op_return retval = new Systemc_basicParser.logic_op_return();
        retval.start = input.LT(1);


        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:376:10: ( '&&' -> vhdl_and(| '||' -> vhdl_or()
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==24) ) {
                alt59=1;
            }
            else if ( (LA59_0==76) ) {
                alt59=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;

            }
            switch (alt59) {
                case 1 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:377:2: '&&'
                    {
                    match(input,24,FOLLOW_24_in_logic_op2201); if (state.failed) return retval;

                    // TEMPLATE REWRITE
                    if ( state.backtracking==0 ) {
                      // 377:8: -> vhdl_and(
                      {
                          retval.st = templateLib.getInstanceOf("vhdl_and");
                      }


                    }

                    }
                    break;
                case 2 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:378:4: '||'
                    {
                    match(input,76,FOLLOW_76_in_logic_op2213); if (state.failed) return retval;

                    // TEMPLATE REWRITE
                    if ( state.backtracking==0 ) {
                      // 378:10: -> vhdl_or(
                      {
                          retval.st = templateLib.getInstanceOf("vhdl_or");
                      }


                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "logic_op"


    protected static class case_construct_scope {
        List cases;
    }
    protected Stack case_construct_stack = new Stack();


    public static class case_construct_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "case_construct"
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:380:1: case_construct : 'switch' '(' value ')' '{' ( case_elt )* '}' -> switch(cases=$case_construct::casesvar=$value.st);
    public final Systemc_basicParser.case_construct_return case_construct() throws RecognitionException {
        case_construct_stack.push(new case_construct_scope());
        Systemc_basicParser.case_construct_return retval = new Systemc_basicParser.case_construct_return();
        retval.start = input.LT(1);


        Systemc_basicParser.case_elt_return case_elt47 =null;

        Systemc_basicParser.value_return value48 =null;



          ((case_construct_scope)case_construct_stack.peek()).cases = new ArrayList();

        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:387:2: ( 'switch' '(' value ')' '{' ( case_elt )* '}' -> switch(cases=$case_construct::casesvar=$value.st))
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:388:2: 'switch' '(' value ')' '{' ( case_elt )* '}'
            {
            match(input,72,FOLLOW_72_in_case_construct2240); if (state.failed) return retval;

            match(input,25,FOLLOW_25_in_case_construct2241); if (state.failed) return retval;

            pushFollow(FOLLOW_value_in_case_construct2242);
            value48=value();

            state._fsp--;
            if (state.failed) return retval;

            match(input,26,FOLLOW_26_in_case_construct2243); if (state.failed) return retval;

            match(input,75,FOLLOW_75_in_case_construct2244); if (state.failed) return retval;

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:389:2: ( case_elt )*
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==43||LA60_0==46) ) {
                    alt60=1;
                }


                switch (alt60) {
            	case 1 :
            	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:389:3: case_elt
            	    {
            	    pushFollow(FOLLOW_case_elt_in_case_construct2248);
            	    case_elt47=case_elt();

            	    state._fsp--;
            	    if (state.failed) return retval;

            	    if ( state.backtracking==0 ) {   ((case_construct_scope)case_construct_stack.peek()).cases.add((case_elt47!=null?case_elt47.st:null));}

            	    }
            	    break;

            	default :
            	    break loop60;
                }
            } while (true);


            match(input,77,FOLLOW_77_in_case_construct2256); if (state.failed) return retval;

            // TEMPLATE REWRITE
            if ( state.backtracking==0 ) {
              // 390:6: -> switch(cases=$case_construct::casesvar=$value.st)
              {
                  retval.st = templateLib.getInstanceOf("switch",new STAttrMap().put("cases", ((case_construct_scope)case_construct_stack.peek()).cases).put("var", (value48!=null?value48.st:null)));
              }


            }

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            case_construct_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "case_construct"


    protected static class case_elt_scope {
        List cont;
    }
    protected Stack case_elt_stack = new Stack();


    public static class case_elt_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "case_elt"
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:393:1: case_elt : ( 'case' ( ID ) | 'default' ) ':' ( v_assignement SEMICOLON | sc_assignement SEMICOLON | if_construct | func_call SEMICOLON | block SEMICOLON | flux SEMICOLON )* ( 'break' SEMICOLON )? -> case(val=$ID.textcont=$case_elt::cont);
    public final Systemc_basicParser.case_elt_return case_elt() throws RecognitionException {
        case_elt_stack.push(new case_elt_scope());
        Systemc_basicParser.case_elt_return retval = new Systemc_basicParser.case_elt_return();
        retval.start = input.LT(1);


        Token ID54=null;
        Systemc_basicParser.v_assignement_return v_assignement49 =null;

        Systemc_basicParser.sc_assignement_return sc_assignement50 =null;

        Systemc_basicParser.if_construct_return if_construct51 =null;

        Systemc_basicParser.func_call_return func_call52 =null;

        Systemc_basicParser.block_return block53 =null;



          ((case_elt_scope)case_elt_stack.peek()).cont = new ArrayList();

        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:400:2: ( ( 'case' ( ID ) | 'default' ) ':' ( v_assignement SEMICOLON | sc_assignement SEMICOLON | if_construct | func_call SEMICOLON | block SEMICOLON | flux SEMICOLON )* ( 'break' SEMICOLON )? -> case(val=$ID.textcont=$case_elt::cont))
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:401:2: ( 'case' ( ID ) | 'default' ) ':' ( v_assignement SEMICOLON | sc_assignement SEMICOLON | if_construct | func_call SEMICOLON | block SEMICOLON | flux SEMICOLON )* ( 'break' SEMICOLON )?
            {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:401:2: ( 'case' ( ID ) | 'default' )
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==43) ) {
                alt61=1;
            }
            else if ( (LA61_0==46) ) {
                alt61=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 61, 0, input);

                throw nvae;

            }
            switch (alt61) {
                case 1 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:401:3: 'case' ( ID )
                    {
                    match(input,43,FOLLOW_43_in_case_elt2296); if (state.failed) return retval;

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:401:10: ( ID )
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:401:11: ID
                    {
                    ID54=(Token)match(input,ID,FOLLOW_ID_in_case_elt2299); if (state.failed) return retval;

                    }


                    }
                    break;
                case 2 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:401:17: 'default'
                    {
                    match(input,46,FOLLOW_46_in_case_elt2304); if (state.failed) return retval;

                    }
                    break;

            }


            match(input,31,FOLLOW_31_in_case_elt2307); if (state.failed) return retval;

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:402:2: ( v_assignement SEMICOLON | sc_assignement SEMICOLON | if_construct | func_call SEMICOLON | block SEMICOLON | flux SEMICOLON )*
            loop62:
            do {
                int alt62=7;
                switch ( input.LA(1) ) {
                case ID:
                    {
                    switch ( input.LA(2) ) {
                    case EQUAL:
                        {
                        alt62=1;
                        }
                        break;
                    case 30:
                        {
                        alt62=2;
                        }
                        break;
                    case 25:
                        {
                        alt62=4;
                        }
                        break;
                    case 32:
                    case 33:
                        {
                        alt62=6;
                        }
                        break;

                    }

                    }
                    break;
                case 50:
                    {
                    alt62=3;
                    }
                    break;
                case 75:
                    {
                    alt62=5;
                    }
                    break;

                }

                switch (alt62) {
            	case 1 :
            	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:402:3: v_assignement SEMICOLON
            	    {
            	    pushFollow(FOLLOW_v_assignement_in_case_elt2312);
            	    v_assignement49=v_assignement();

            	    state._fsp--;
            	    if (state.failed) return retval;

            	    match(input,SEMICOLON,FOLLOW_SEMICOLON_in_case_elt2314); if (state.failed) return retval;

            	    if ( state.backtracking==0 ) {  ((case_elt_scope)case_elt_stack.peek()).cont.add((v_assignement49!=null?v_assignement49.st:null));}

            	    }
            	    break;
            	case 2 :
            	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:403:3: sc_assignement SEMICOLON
            	    {
            	    pushFollow(FOLLOW_sc_assignement_in_case_elt2319);
            	    sc_assignement50=sc_assignement();

            	    state._fsp--;
            	    if (state.failed) return retval;

            	    match(input,SEMICOLON,FOLLOW_SEMICOLON_in_case_elt2321); if (state.failed) return retval;

            	    if ( state.backtracking==0 ) {  ((case_elt_scope)case_elt_stack.peek()).cont.add((sc_assignement50!=null?sc_assignement50.st:null));}

            	    }
            	    break;
            	case 3 :
            	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:404:3: if_construct
            	    {
            	    pushFollow(FOLLOW_if_construct_in_case_elt2326);
            	    if_construct51=if_construct();

            	    state._fsp--;
            	    if (state.failed) return retval;

            	    if ( state.backtracking==0 ) { ((case_elt_scope)case_elt_stack.peek()).cont.add((if_construct51!=null?if_construct51.st:null));}

            	    }
            	    break;
            	case 4 :
            	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:405:3: func_call SEMICOLON
            	    {
            	    pushFollow(FOLLOW_func_call_in_case_elt2332);
            	    func_call52=func_call();

            	    state._fsp--;
            	    if (state.failed) return retval;

            	    match(input,SEMICOLON,FOLLOW_SEMICOLON_in_case_elt2334); if (state.failed) return retval;

            	    if ( state.backtracking==0 ) {  ((case_elt_scope)case_elt_stack.peek()).cont.add((func_call52!=null?func_call52.st:null));}

            	    }
            	    break;
            	case 5 :
            	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:406:3: block SEMICOLON
            	    {
            	    pushFollow(FOLLOW_block_in_case_elt2339);
            	    block53=block();

            	    state._fsp--;
            	    if (state.failed) return retval;

            	    match(input,SEMICOLON,FOLLOW_SEMICOLON_in_case_elt2341); if (state.failed) return retval;

            	    if ( state.backtracking==0 ) {  ((case_elt_scope)case_elt_stack.peek()).cont.addAll((block53!=null?block53.elts:null));}

            	    }
            	    break;
            	case 6 :
            	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:407:3: flux SEMICOLON
            	    {
            	    pushFollow(FOLLOW_flux_in_case_elt2346);
            	    flux();

            	    state._fsp--;
            	    if (state.failed) return retval;

            	    match(input,SEMICOLON,FOLLOW_SEMICOLON_in_case_elt2348); if (state.failed) return retval;

            	    }
            	    break;

            	default :
            	    break loop62;
                }
            } while (true);


            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:409:2: ( 'break' SEMICOLON )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==42) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:409:3: 'break' SEMICOLON
                    {
                    match(input,42,FOLLOW_42_in_case_elt2356); if (state.failed) return retval;

                    match(input,SEMICOLON,FOLLOW_SEMICOLON_in_case_elt2358); if (state.failed) return retval;

                    }
                    break;

            }


            // TEMPLATE REWRITE
            if ( state.backtracking==0 ) {
              // 409:23: -> case(val=$ID.textcont=$case_elt::cont)
              {
                  retval.st = templateLib.getInstanceOf("case",new STAttrMap().put("val", (ID54!=null?ID54.getText():null)).put("cont", ((case_elt_scope)case_elt_stack.peek()).cont));
              }


            }

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            case_elt_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "case_elt"


    public static class flux_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "flux"
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:412:1: flux : ( ID '::' )? ID '<<' value ( '<<' value )* ;
    public final Systemc_basicParser.flux_return flux() throws RecognitionException {
        Systemc_basicParser.flux_return retval = new Systemc_basicParser.flux_return();
        retval.start = input.LT(1);


        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:412:6: ( ( ID '::' )? ID '<<' value ( '<<' value )* )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:412:7: ( ID '::' )? ID '<<' value ( '<<' value )*
            {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:412:7: ( ID '::' )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==ID) ) {
                int LA64_1 = input.LA(2);

                if ( (LA64_1==32) ) {
                    alt64=1;
                }
            }
            switch (alt64) {
                case 1 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:412:8: ID '::'
                    {
                    match(input,ID,FOLLOW_ID_in_flux2388); if (state.failed) return retval;

                    match(input,32,FOLLOW_32_in_flux2389); if (state.failed) return retval;

                    }
                    break;

            }


            match(input,ID,FOLLOW_ID_in_flux2392); if (state.failed) return retval;

            match(input,33,FOLLOW_33_in_flux2394); if (state.failed) return retval;

            pushFollow(FOLLOW_value_in_flux2396);
            value();

            state._fsp--;
            if (state.failed) return retval;

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:412:30: ( '<<' value )*
            loop65:
            do {
                int alt65=2;
                int LA65_0 = input.LA(1);

                if ( (LA65_0==33) ) {
                    alt65=1;
                }


                switch (alt65) {
            	case 1 :
            	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:412:31: '<<' value
            	    {
            	    match(input,33,FOLLOW_33_in_flux2399); if (state.failed) return retval;

            	    pushFollow(FOLLOW_value_in_flux2402);
            	    value();

            	    state._fsp--;
            	    if (state.failed) return retval;

            	    }
            	    break;

            	default :
            	    break loop65;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "flux"


    public static class v_assignement_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "v_assignement"
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:416:1: v_assignement : ID EQUAL assignement_value -> var_assign(var=$ID.textval=$assignement_value.st);
    public final Systemc_basicParser.v_assignement_return v_assignement() throws RecognitionException {
        Systemc_basicParser.v_assignement_return retval = new Systemc_basicParser.v_assignement_return();
        retval.start = input.LT(1);


        Token ID55=null;
        Systemc_basicParser.assignement_value_return assignement_value56 =null;


        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:417:2: ( ID EQUAL assignement_value -> var_assign(var=$ID.textval=$assignement_value.st))
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:418:2: ID EQUAL assignement_value
            {
            ID55=(Token)match(input,ID,FOLLOW_ID_in_v_assignement2420); if (state.failed) return retval;

            match(input,EQUAL,FOLLOW_EQUAL_in_v_assignement2422); if (state.failed) return retval;

            pushFollow(FOLLOW_assignement_value_in_v_assignement2424);
            assignement_value56=assignement_value();

            state._fsp--;
            if (state.failed) return retval;

            // TEMPLATE REWRITE
            if ( state.backtracking==0 ) {
              // 418:30: -> var_assign(var=$ID.textval=$assignement_value.st)
              {
                  retval.st = templateLib.getInstanceOf("var_assign",new STAttrMap().put("var", (ID55!=null?ID55.getText():null)).put("val", (assignement_value56!=null?assignement_value56.st:null)));
              }


            }

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "v_assignement"


    public static class sc_assignement_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "sc_assignement"
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:421:1: sc_assignement : ID '.write(' assignement_value ')' -> signal_assignement(dest=$ID.textsource=$assignement_value.st);
    public final Systemc_basicParser.sc_assignement_return sc_assignement() throws RecognitionException {
        Systemc_basicParser.sc_assignement_return retval = new Systemc_basicParser.sc_assignement_return();
        retval.start = input.LT(1);


        Token ID57=null;
        Systemc_basicParser.assignement_value_return assignement_value58 =null;


        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:422:2: ( ID '.write(' assignement_value ')' -> signal_assignement(dest=$ID.textsource=$assignement_value.st))
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:423:2: ID '.write(' assignement_value ')'
            {
            ID57=(Token)match(input,ID,FOLLOW_ID_in_sc_assignement2455); if (state.failed) return retval;

            match(input,30,FOLLOW_30_in_sc_assignement2456); if (state.failed) return retval;

            pushFollow(FOLLOW_assignement_value_in_sc_assignement2457);
            assignement_value58=assignement_value();

            state._fsp--;
            if (state.failed) return retval;

            match(input,26,FOLLOW_26_in_sc_assignement2458); if (state.failed) return retval;

            // TEMPLATE REWRITE
            if ( state.backtracking==0 ) {
              // 423:34: -> signal_assignement(dest=$ID.textsource=$assignement_value.st)
              {
                  retval.st = templateLib.getInstanceOf("signal_assignement",new STAttrMap().put("dest", (ID57!=null?ID57.getText():null)).put("source", (assignement_value58!=null?assignement_value58.st:null)));
              }


            }

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "sc_assignement"


    public static class assignement_value_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "assignement_value"
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:426:1: assignement_value : value -> dummy(val=$value.st);
    public final Systemc_basicParser.assignement_value_return assignement_value() throws RecognitionException {
        Systemc_basicParser.assignement_value_return retval = new Systemc_basicParser.assignement_value_return();
        retval.start = input.LT(1);


        Systemc_basicParser.value_return value59 =null;


        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:427:2: ( value -> dummy(val=$value.st))
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:428:4: value
            {
            pushFollow(FOLLOW_value_in_assignement_value2490);
            value59=value();

            state._fsp--;
            if (state.failed) return retval;

            // TEMPLATE REWRITE
            if ( state.backtracking==0 ) {
              // 428:11: -> dummy(val=$value.st)
              {
                  retval.st = templateLib.getInstanceOf("dummy",new STAttrMap().put("val", (value59!=null?value59.st:null)));
              }


            }

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "assignement_value"


    public static class value_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "value"
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:431:1: value : ( HEX -> dummy(val= $HEX.text)| BIN -> dummy(val= $BIN.text)| INT -> dummy(val= $INT.text)| STRING_LITERAL -> dummy(val= $STRING_LITERAL.text)|h= var_value ( OP t= value )? -> expression(head=$h.stop=$OP.texttail=$t.st)| func_call -> dummy(val=$func_call.st)| sc_method -> dummy(val=$sc_method.st));
    public final Systemc_basicParser.value_return value() throws RecognitionException {
        Systemc_basicParser.value_return retval = new Systemc_basicParser.value_return();
        retval.start = input.LT(1);


        Token HEX60=null;
        Token BIN61=null;
        Token INT62=null;
        Token STRING_LITERAL63=null;
        Token OP64=null;
        Systemc_basicParser.var_value_return h =null;

        Systemc_basicParser.value_return t =null;

        Systemc_basicParser.func_call_return func_call65 =null;

        Systemc_basicParser.sc_method_return sc_method66 =null;


        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:431:7: ( HEX -> dummy(val= $HEX.text)| BIN -> dummy(val= $BIN.text)| INT -> dummy(val= $INT.text)| STRING_LITERAL -> dummy(val= $STRING_LITERAL.text)|h= var_value ( OP t= value )? -> expression(head=$h.stop=$OP.texttail=$t.st)| func_call -> dummy(val=$func_call.st)| sc_method -> dummy(val=$sc_method.st))
            int alt67=7;
            switch ( input.LA(1) ) {
            case HEX:
                {
                alt67=1;
                }
                break;
            case BIN:
                {
                alt67=2;
                }
                break;
            case INT:
                {
                alt67=3;
                }
                break;
            case STRING_LITERAL:
                {
                alt67=4;
                }
                break;
            case ID:
                {
                int LA67_5 = input.LA(2);

                if ( (LA67_5==25) ) {
                    alt67=6;
                }
                else if ( (LA67_5==EOF||LA67_5==EQUAL||LA67_5==GT||(LA67_5 >= LT && LA67_5 <= SEMICOLON)||LA67_5==24||LA67_5==26||(LA67_5 >= 28 && LA67_5 <= 29)||LA67_5==33||LA67_5==37||LA67_5==39||LA67_5==76) ) {
                    alt67=5;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 67, 5, input);

                    throw nvae;

                }
                }
                break;
            case 25:
            case 45:
            case 53:
            case 54:
                {
                alt67=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 67, 0, input);

                throw nvae;

            }

            switch (alt67) {
                case 1 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:432:3: HEX
                    {
                    HEX60=(Token)match(input,HEX,FOLLOW_HEX_in_value2514); if (state.failed) return retval;

                    // TEMPLATE REWRITE
                    if ( state.backtracking==0 ) {
                      // 432:8: -> dummy(val= $HEX.text)
                      {
                          retval.st = templateLib.getInstanceOf("dummy",new STAttrMap().put("val",  (HEX60!=null?HEX60.getText():null)));
                      }


                    }

                    }
                    break;
                case 2 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:433:4: BIN
                    {
                    BIN61=(Token)match(input,BIN,FOLLOW_BIN_in_value2531); if (state.failed) return retval;

                    // TEMPLATE REWRITE
                    if ( state.backtracking==0 ) {
                      // 433:9: -> dummy(val= $BIN.text)
                      {
                          retval.st = templateLib.getInstanceOf("dummy",new STAttrMap().put("val",  (BIN61!=null?BIN61.getText():null)));
                      }


                    }

                    }
                    break;
                case 3 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:434:4: INT
                    {
                    INT62=(Token)match(input,INT,FOLLOW_INT_in_value2548); if (state.failed) return retval;

                    // TEMPLATE REWRITE
                    if ( state.backtracking==0 ) {
                      // 434:9: -> dummy(val= $INT.text)
                      {
                          retval.st = templateLib.getInstanceOf("dummy",new STAttrMap().put("val",  (INT62!=null?INT62.getText():null)));
                      }


                    }

                    }
                    break;
                case 4 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:435:4: STRING_LITERAL
                    {
                    STRING_LITERAL63=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_value2565); if (state.failed) return retval;

                    // TEMPLATE REWRITE
                    if ( state.backtracking==0 ) {
                      // 435:21: -> dummy(val= $STRING_LITERAL.text)
                      {
                          retval.st = templateLib.getInstanceOf("dummy",new STAttrMap().put("val",  (STRING_LITERAL63!=null?STRING_LITERAL63.getText():null)));
                      }


                    }

                    }
                    break;
                case 5 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:436:4: h= var_value ( OP t= value )?
                    {
                    pushFollow(FOLLOW_var_value_in_value2587);
                    h=var_value();

                    state._fsp--;
                    if (state.failed) return retval;

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:436:17: ( OP t= value )?
                    int alt66=2;
                    int LA66_0 = input.LA(1);

                    if ( (LA66_0==OP) ) {
                        alt66=1;
                    }
                    switch (alt66) {
                        case 1 :
                            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:436:18: OP t= value
                            {
                            OP64=(Token)match(input,OP,FOLLOW_OP_in_value2591); if (state.failed) return retval;

                            pushFollow(FOLLOW_value_in_value2595);
                            t=value();

                            state._fsp--;
                            if (state.failed) return retval;

                            }
                            break;

                    }


                    // TEMPLATE REWRITE
                    if ( state.backtracking==0 ) {
                      // 436:30: -> expression(head=$h.stop=$OP.texttail=$t.st)
                      {
                          retval.st = templateLib.getInstanceOf("expression",new STAttrMap().put("head", (h!=null?h.st:null)).put("op", (OP64!=null?OP64.getText():null)).put("tail", (t!=null?t.st:null)));
                      }


                    }

                    }
                    break;
                case 6 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:437:4: func_call
                    {
                    pushFollow(FOLLOW_func_call_in_value2625);
                    func_call65=func_call();

                    state._fsp--;
                    if (state.failed) return retval;

                    // TEMPLATE REWRITE
                    if ( state.backtracking==0 ) {
                      // 437:14: -> dummy(val=$func_call.st)
                      {
                          retval.st = templateLib.getInstanceOf("dummy",new STAttrMap().put("val", (func_call65!=null?func_call65.st:null)));
                      }


                    }

                    }
                    break;
                case 7 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:438:4: sc_method
                    {
                    pushFollow(FOLLOW_sc_method_in_value2641);
                    sc_method66=sc_method();

                    state._fsp--;
                    if (state.failed) return retval;

                    // TEMPLATE REWRITE
                    if ( state.backtracking==0 ) {
                      // 438:14: -> dummy(val=$sc_method.st)
                      {
                          retval.st = templateLib.getInstanceOf("dummy",new STAttrMap().put("val", (sc_method66!=null?sc_method66.st:null)));
                      }


                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "value"


    public static class var_value_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "var_value"
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:441:1: var_value : ( var_name ) ( var_comp )* -> var_value(var=$var_name.stmethods=$var_comp.st);
    public final Systemc_basicParser.var_value_return var_value() throws RecognitionException {
        Systemc_basicParser.var_value_return retval = new Systemc_basicParser.var_value_return();
        retval.start = input.LT(1);


        Systemc_basicParser.var_name_return var_name67 =null;

        Systemc_basicParser.var_comp_return var_comp68 =null;


        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:441:11: ( ( var_name ) ( var_comp )* -> var_value(var=$var_name.stmethods=$var_comp.st))
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:443:2: ( var_name ) ( var_comp )*
            {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:443:2: ( var_name )
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:443:3: var_name
            {
            pushFollow(FOLLOW_var_name_in_var_value2666);
            var_name67=var_name();

            state._fsp--;
            if (state.failed) return retval;

            }


            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:443:13: ( var_comp )*
            loop68:
            do {
                int alt68=2;
                int LA68_0 = input.LA(1);

                if ( (LA68_0==29||LA68_0==37) ) {
                    alt68=1;
                }


                switch (alt68) {
            	case 1 :
            	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:443:13: var_comp
            	    {
            	    pushFollow(FOLLOW_var_comp_in_var_value2669);
            	    var_comp68=var_comp();

            	    state._fsp--;
            	    if (state.failed) return retval;

            	    }
            	    break;

            	default :
            	    break loop68;
                }
            } while (true);


            // TEMPLATE REWRITE
            if ( state.backtracking==0 ) {
              // 443:24: -> var_value(var=$var_name.stmethods=$var_comp.st)
              {
                  retval.st = templateLib.getInstanceOf("var_value",new STAttrMap().put("var", (var_name67!=null?var_name67.st:null)).put("methods", (var_comp68!=null?var_comp68.st:null)));
              }


            }

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "var_value"


    public static class var_comp_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "var_comp"
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:446:1: var_comp : ( ( '.' ( ( sc_method ) -> dummy(val=$sc_method.st)| ( method ) ) -> dummy(val=$method.st)) | ( '[' value ']' ) -> array_value(index=$value.st));
    public final Systemc_basicParser.var_comp_return var_comp() throws RecognitionException {
        Systemc_basicParser.var_comp_return retval = new Systemc_basicParser.var_comp_return();
        retval.start = input.LT(1);


        Systemc_basicParser.sc_method_return sc_method69 =null;

        Systemc_basicParser.method_return method70 =null;

        Systemc_basicParser.value_return value71 =null;


        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:446:10: ( ( '.' ( ( sc_method ) -> dummy(val=$sc_method.st)| ( method ) ) -> dummy(val=$method.st)) | ( '[' value ']' ) -> array_value(index=$value.st))
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==29) ) {
                alt70=1;
            }
            else if ( (LA70_0==37) ) {
                alt70=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 70, 0, input);

                throw nvae;

            }
            switch (alt70) {
                case 1 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:447:2: ( '.' ( ( sc_method ) -> dummy(val=$sc_method.st)| ( method ) ) -> dummy(val=$method.st))
                    {
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:447:2: ( '.' ( ( sc_method ) -> dummy(val=$sc_method.st)| ( method ) ) -> dummy(val=$method.st))
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:447:3: '.' ( ( sc_method ) -> dummy(val=$sc_method.st)| ( method ) )
                    {
                    match(input,29,FOLLOW_29_in_var_comp2702); if (state.failed) return retval;

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:448:2: ( ( sc_method ) -> dummy(val=$sc_method.st)| ( method ) )
                    int alt69=2;
                    int LA69_0 = input.LA(1);

                    if ( (LA69_0==25||LA69_0==45||(LA69_0 >= 53 && LA69_0 <= 54)) ) {
                        alt69=1;
                    }
                    else if ( (LA69_0==ID) ) {
                        alt69=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 69, 0, input);

                        throw nvae;

                    }
                    switch (alt69) {
                        case 1 :
                            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:448:3: ( sc_method )
                            {
                            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:448:3: ( sc_method )
                            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:448:4: sc_method
                            {
                            pushFollow(FOLLOW_sc_method_in_var_comp2707);
                            sc_method69=sc_method();

                            state._fsp--;
                            if (state.failed) return retval;

                            }


                            // TEMPLATE REWRITE
                            if ( state.backtracking==0 ) {
                              // 448:15: -> dummy(val=$sc_method.st)
                              {
                                  retval.st = templateLib.getInstanceOf("dummy",new STAttrMap().put("val", (sc_method69!=null?sc_method69.st:null)));
                              }


                            }

                            }
                            break;
                        case 2 :
                            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:449:4: ( method )
                            {
                            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:449:4: ( method )
                            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:449:6: method
                            {
                            pushFollow(FOLLOW_method_in_var_comp2726);
                            method70=method();

                            state._fsp--;
                            if (state.failed) return retval;

                            }


                            }
                            break;

                    }


                    // TEMPLATE REWRITE
                    if ( state.backtracking==0 ) {
                      // 449:15: -> dummy(val=$method.st)
                      {
                          retval.st = templateLib.getInstanceOf("dummy",new STAttrMap().put("val", (method70!=null?method70.st:null)));
                      }


                    }

                    }


                    }
                    break;
                case 2 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:451:4: ( '[' value ']' )
                    {
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:451:4: ( '[' value ']' )
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:451:5: '[' value ']'
                    {
                    match(input,37,FOLLOW_37_in_var_comp2748); if (state.failed) return retval;

                    pushFollow(FOLLOW_value_in_var_comp2749);
                    value71=value();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input,39,FOLLOW_39_in_var_comp2750); if (state.failed) return retval;

                    }


                    // TEMPLATE REWRITE
                    if ( state.backtracking==0 ) {
                      // 451:18: -> array_value(index=$value.st)
                      {
                          retval.st = templateLib.getInstanceOf("array_value",new STAttrMap().put("index", (value71!=null?value71.st:null)));
                      }


                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "var_comp"


    public static class var_name_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "var_name"
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:454:1: var_name : ID -> dummy(val=$ID.text);
    public final Systemc_basicParser.var_name_return var_name() throws RecognitionException {
        Systemc_basicParser.var_name_return retval = new Systemc_basicParser.var_name_return();
        retval.start = input.LT(1);


        Token ID72=null;

        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:455:2: ( ID -> dummy(val=$ID.text))
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:456:2: ID
            {
            ID72=(Token)match(input,ID,FOLLOW_ID_in_var_name2776); if (state.failed) return retval;

            // TEMPLATE REWRITE
            if ( state.backtracking==0 ) {
              // 456:5: -> dummy(val=$ID.text)
              {
                  retval.st = templateLib.getInstanceOf("dummy",new STAttrMap().put("val", (ID72!=null?ID72.getText():null)));
              }


            }

            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "var_name"


    public static class sc_type_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "sc_type"
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:461:1: sc_type : ( 'sc_lv' ( LT INT GT ) -> logic_vector(size=$INT.text)| 'sc_uint' ( LT INT GT ) -> logic_vector(size=$INT.text)| 'sc_logic' -> logic(| 'bool' -> bool();
    public final Systemc_basicParser.sc_type_return sc_type() throws RecognitionException {
        Systemc_basicParser.sc_type_return retval = new Systemc_basicParser.sc_type_return();
        retval.start = input.LT(1);


        Token INT73=null;
        Token INT74=null;

        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:461:9: ( 'sc_lv' ( LT INT GT ) -> logic_vector(size=$INT.text)| 'sc_uint' ( LT INT GT ) -> logic_vector(size=$INT.text)| 'sc_logic' -> logic(| 'bool' -> bool()
            int alt71=4;
            switch ( input.LA(1) ) {
            case 63:
                {
                alt71=1;
                }
                break;
            case 68:
                {
                alt71=2;
                }
                break;
            case 62:
                {
                alt71=3;
                }
                break;
            case 41:
                {
                alt71=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 71, 0, input);

                throw nvae;

            }

            switch (alt71) {
                case 1 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:462:2: 'sc_lv' ( LT INT GT )
                    {
                    match(input,63,FOLLOW_63_in_sc_type2800); if (state.failed) return retval;

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:462:9: ( LT INT GT )
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:462:10: LT INT GT
                    {
                    match(input,LT,FOLLOW_LT_in_sc_type2802); if (state.failed) return retval;

                    INT73=(Token)match(input,INT,FOLLOW_INT_in_sc_type2804); if (state.failed) return retval;

                    match(input,GT,FOLLOW_GT_in_sc_type2806); if (state.failed) return retval;

                    }


                    // TEMPLATE REWRITE
                    if ( state.backtracking==0 ) {
                      // 462:21: -> logic_vector(size=$INT.text)
                      {
                          retval.st = templateLib.getInstanceOf("logic_vector",new STAttrMap().put("size", (INT73!=null?INT73.getText():null)));
                      }


                    }

                    }
                    break;
                case 2 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:463:4: 'sc_uint' ( LT INT GT )
                    {
                    match(input,68,FOLLOW_68_in_sc_type2821); if (state.failed) return retval;

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:463:14: ( LT INT GT )
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:463:15: LT INT GT
                    {
                    match(input,LT,FOLLOW_LT_in_sc_type2824); if (state.failed) return retval;

                    INT74=(Token)match(input,INT,FOLLOW_INT_in_sc_type2826); if (state.failed) return retval;

                    match(input,GT,FOLLOW_GT_in_sc_type2828); if (state.failed) return retval;

                    }


                    // TEMPLATE REWRITE
                    if ( state.backtracking==0 ) {
                      // 463:26: -> logic_vector(size=$INT.text)
                      {
                          retval.st = templateLib.getInstanceOf("logic_vector",new STAttrMap().put("size", (INT74!=null?INT74.getText():null)));
                      }


                    }

                    }
                    break;
                case 3 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:464:4: 'sc_logic'
                    {
                    match(input,62,FOLLOW_62_in_sc_type2843); if (state.failed) return retval;

                    // TEMPLATE REWRITE
                    if ( state.backtracking==0 ) {
                      // 464:15: -> logic(
                      {
                          retval.st = templateLib.getInstanceOf("logic");
                      }


                    }

                    }
                    break;
                case 4 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:465:4: 'bool'
                    {
                    match(input,41,FOLLOW_41_in_sc_type2854); if (state.failed) return retval;

                    // TEMPLATE REWRITE
                    if ( state.backtracking==0 ) {
                      // 465:11: -> bool(
                      {
                          retval.st = templateLib.getInstanceOf("bool");
                      }


                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "sc_type"


    public static class sc_method_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "sc_method"
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:469:1: sc_method : ( 'range(' from= INT ',' to= INT ')' -> range(from=$from.textto=$to.text)| 'concat(' left= value ',' right= value ')' -> concat(left=$left.stright=$right.st)| 'read()' | '(' left= value ',' right= value ')' -> concat(left=$left.stright=$right.st));
    public final Systemc_basicParser.sc_method_return sc_method() throws RecognitionException {
        Systemc_basicParser.sc_method_return retval = new Systemc_basicParser.sc_method_return();
        retval.start = input.LT(1);


        Token from=null;
        Token to=null;
        Systemc_basicParser.value_return left =null;

        Systemc_basicParser.value_return right =null;


        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:470:2: ( 'range(' from= INT ',' to= INT ')' -> range(from=$from.textto=$to.text)| 'concat(' left= value ',' right= value ')' -> concat(left=$left.stright=$right.st)| 'read()' | '(' left= value ',' right= value ')' -> concat(left=$left.stright=$right.st))
            int alt72=4;
            switch ( input.LA(1) ) {
            case 53:
                {
                alt72=1;
                }
                break;
            case 45:
                {
                alt72=2;
                }
                break;
            case 54:
                {
                alt72=3;
                }
                break;
            case 25:
                {
                alt72=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 72, 0, input);

                throw nvae;

            }

            switch (alt72) {
                case 1 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:471:2: 'range(' from= INT ',' to= INT ')'
                    {
                    match(input,53,FOLLOW_53_in_sc_method2873); if (state.failed) return retval;

                    from=(Token)match(input,INT,FOLLOW_INT_in_sc_method2878); if (state.failed) return retval;

                    match(input,28,FOLLOW_28_in_sc_method2880); if (state.failed) return retval;

                    to=(Token)match(input,INT,FOLLOW_INT_in_sc_method2886); if (state.failed) return retval;

                    match(input,26,FOLLOW_26_in_sc_method2887); if (state.failed) return retval;

                    // TEMPLATE REWRITE
                    if ( state.backtracking==0 ) {
                      // 471:37: -> range(from=$from.textto=$to.text)
                      {
                          retval.st = templateLib.getInstanceOf("range",new STAttrMap().put("from", (from!=null?from.getText():null)).put("to", (to!=null?to.getText():null)));
                      }


                    }

                    }
                    break;
                case 2 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:472:3: 'concat(' left= value ',' right= value ')'
                    {
                    match(input,45,FOLLOW_45_in_sc_method2909); if (state.failed) return retval;

                    pushFollow(FOLLOW_value_in_sc_method2916);
                    left=value();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input,28,FOLLOW_28_in_sc_method2919); if (state.failed) return retval;

                    pushFollow(FOLLOW_value_in_sc_method2924);
                    right=value();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input,26,FOLLOW_26_in_sc_method2926); if (state.failed) return retval;

                    // TEMPLATE REWRITE
                    if ( state.backtracking==0 ) {
                      // 472:48: -> concat(left=$left.stright=$right.st)
                      {
                          retval.st = templateLib.getInstanceOf("concat",new STAttrMap().put("left", (left!=null?left.st:null)).put("right", (right!=null?right.st:null)));
                      }


                    }

                    }
                    break;
                case 3 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:473:4: 'read()'
                    {
                    match(input,54,FOLLOW_54_in_sc_method2948); if (state.failed) return retval;

                    }
                    break;
                case 4 :
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:474:3: '(' left= value ',' right= value ')'
                    {
                    match(input,25,FOLLOW_25_in_sc_method2952); if (state.failed) return retval;

                    pushFollow(FOLLOW_value_in_sc_method2959);
                    left=value();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input,28,FOLLOW_28_in_sc_method2962); if (state.failed) return retval;

                    pushFollow(FOLLOW_value_in_sc_method2967);
                    right=value();

                    state._fsp--;
                    if (state.failed) return retval;

                    match(input,26,FOLLOW_26_in_sc_method2968); if (state.failed) return retval;

                    // TEMPLATE REWRITE
                    if ( state.backtracking==0 ) {
                      // 474:41: -> concat(left=$left.stright=$right.st)
                      {
                          retval.st = templateLib.getInstanceOf("concat",new STAttrMap().put("left", (left!=null?left.st:null)).put("right", (right!=null?right.st:null)));
                      }


                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "sc_method"

    // $ANTLR start synpred1_Systemc_basic
    public final void synpred1_Systemc_basic_fragment() throws RecognitionException {
        // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:356:2: ( ( test ) ( expr_right[$test_express::vals, $test_express::ops] )* )
        // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:356:2: ( test ) ( expr_right[$test_express::vals, $test_express::ops] )*
        {
        // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:356:2: ( test )
        // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:356:4: test
        {
        pushFollow(FOLLOW_test_in_synpred1_Systemc_basic1977);
        test();

        state._fsp--;
        if (state.failed) return ;

        }


        // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:356:49: ( expr_right[$test_express::vals, $test_express::ops] )*
        loop73:
        do {
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==24||LA73_0==76) ) {
                alt73=1;
            }


            switch (alt73) {
        	case 1 :
        	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:356:50: expr_right[$test_express::vals, $test_express::ops]
        	    {
        	    pushFollow(FOLLOW_expr_right_in_synpred1_Systemc_basic1985);
        	    expr_right(((test_express_scope)test_express_stack.peek()).vals, ((test_express_scope)test_express_stack.peek()).ops);

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop73;
            }
        } while (true);


        }

    }
    // $ANTLR end synpred1_Systemc_basic

    // Delegated rules

    public final boolean synpred1_Systemc_basic() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_Systemc_basic_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA9 dfa9 = new DFA9(this);
    static final String DFA9_eotS =
        "\40\uffff";
    static final String DFA9_eofS =
        "\40\uffff";
    static final String DFA9_minS =
        "\1\12\3\uffff\1\54\1\63\5\12\2\14\3\12\2\uffff\1\6\1\12\2\13\1\12"+
        "\1\uffff\3\10\4\12\1\10";
    static final String DFA9_maxS =
        "\1\112\3\uffff\2\106\4\46\1\12\2\14\3\46\2\uffff\1\45\1\46\3\13"+
        "\1\uffff\2\10\1\34\2\46\1\13\1\46\1\34";
    static final String DFA9_acceptS =
        "\1\uffff\1\1\1\2\1\3\14\uffff\1\6\1\4\5\uffff\1\5\10\uffff";
    static final String DFA9_specialS =
        "\40\uffff}>";
    static final String[] DFA9_transitionS = {
            "\1\17\27\uffff\1\20\6\uffff\1\16\2\uffff\1\7\3\uffff\1\3\1\10"+
            "\1\uffff\1\6\1\5\2\uffff\7\1\1\15\1\13\3\1\1\2\1\14\1\uffff"+
            "\1\5\1\12\1\uffff\1\4\1\11",
            "",
            "",
            "",
            "\1\7\6\uffff\1\6\1\5\21\uffff\1\5",
            "\1\6\1\5\21\uffff\1\5",
            "\1\22\20\uffff\1\21\12\uffff\1\21",
            "\1\22\20\uffff\1\21\12\uffff\1\21",
            "\1\22\20\uffff\1\21\12\uffff\1\21",
            "\1\22\20\uffff\1\21\12\uffff\1\21",
            "\1\23",
            "\1\24",
            "\1\25",
            "\1\22\20\uffff\1\21\12\uffff\1\21",
            "\1\22\20\uffff\1\21\12\uffff\1\21",
            "\1\22\1\uffff\1\26\16\uffff\1\21\12\uffff\1\21",
            "",
            "",
            "\1\21\10\uffff\1\21\11\uffff\1\27\2\uffff\1\21\3\uffff\1\27"+
            "\4\uffff\1\21",
            "\1\22\20\uffff\1\21\12\uffff\1\21",
            "\1\30",
            "\1\31",
            "\2\32",
            "",
            "\1\33",
            "\1\34",
            "\1\36\23\uffff\1\35",
            "\1\22\20\uffff\1\21\12\uffff\1\21",
            "\1\22\20\uffff\1\21\12\uffff\1\21",
            "\2\37",
            "\1\22\20\uffff\1\21\12\uffff\1\21",
            "\1\36\23\uffff\1\35"
    };

    static final short[] DFA9_eot = DFA.unpackEncodedString(DFA9_eotS);
    static final short[] DFA9_eof = DFA.unpackEncodedString(DFA9_eofS);
    static final char[] DFA9_min = DFA.unpackEncodedStringToUnsignedChars(DFA9_minS);
    static final char[] DFA9_max = DFA.unpackEncodedStringToUnsignedChars(DFA9_maxS);
    static final short[] DFA9_accept = DFA.unpackEncodedString(DFA9_acceptS);
    static final short[] DFA9_special = DFA.unpackEncodedString(DFA9_specialS);
    static final short[][] DFA9_transition;

    static {
        int numStates = DFA9_transitionS.length;
        DFA9_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA9_transition[i] = DFA.unpackEncodedString(DFA9_transitionS[i]);
        }
    }

    class DFA9 extends DFA {

        public DFA9(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 9;
            this.eot = DFA9_eot;
            this.eof = DFA9_eof;
            this.min = DFA9_min;
            this.max = DFA9_max;
            this.accept = DFA9_accept;
            this.special = DFA9_special;
            this.transition = DFA9_transition;
        }
        public String getDescription() {
            return "90:2: ( port_decl SEMICOLON | signal_dec SEMICOLON | enum_decl SEMICOLON | variable_decl[$vars] SEMICOLON | func_decl ( SEMICOLON )? | actor )";
        }
    }
 

    public static final BitSet FOLLOW_pre_processor_in_cfile48 = new BitSet(new long[]{0xFF9B121400E80400L,0x00000000000006DFL});
    public static final BitSet FOLLOW_declarations_in_cfile53 = new BitSet(new long[]{0xFF9B121400000400L,0x00000000000006DFL});
    public static final BitSet FOLLOW_module_decl_in_cfile60 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_SEMICOLON_in_cfile62 = new BitSet(new long[]{0xFF9B120400E80400L,0x00000000000006DFL});
    public static final BitSet FOLLOW_declarations_in_cfile66 = new BitSet(new long[]{0xFF9B120400E80400L,0x00000000000006DFL});
    public static final BitSet FOLLOW_pre_processor_in_cfile72 = new BitSet(new long[]{0x0000000000E80002L});
    public static final BitSet FOLLOW_includes_in_pre_processor96 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_define_in_pre_processor102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_pre_processor107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_includes118 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_includes120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_define130 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_ID_in_define136 = new BitSet(new long[]{0x0000000000000C02L});
    public static final BitSet FOLLOW_20_in_endif152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_module_decl177 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_module_decl179 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_ID_in_module_decl181 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_module_decl183 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_75_in_module_decl185 = new BitSet(new long[]{0xFF9B120400000400L,0x00000000000006DFL});
    public static final BitSet FOLLOW_module_body_in_module_decl195 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_77_in_module_decl205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declarations_in_module_body366 = new BitSet(new long[]{0xFF9B120400000402L,0x00000000000006DFL});
    public static final BitSet FOLLOW_port_decl_in_declarations384 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_SEMICOLON_in_declarations386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_signal_dec_in_declarations394 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_SEMICOLON_in_declarations396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_enum_decl_in_declarations403 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_SEMICOLON_in_declarations405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_decl_in_declarations412 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_SEMICOLON_in_declarations415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_func_decl_in_declarations420 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_SEMICOLON_in_declarations422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_actor_in_declarations428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_v_type_in_func_decl444 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_ID_in_func_decl449 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_func_decl450 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_ID_in_func_decl456 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_func_decl458 = new BitSet(new long[]{0xC01A120004000400L,0x00000000000006D0L});
    public static final BitSet FOLLOW_v_type_in_func_decl461 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_ID_in_func_decl463 = new BitSet(new long[]{0x0000000014000000L});
    public static final BitSet FOLLOW_28_in_func_decl466 = new BitSet(new long[]{0xC01A120000000400L,0x00000000000006D0L});
    public static final BitSet FOLLOW_v_type_in_func_decl467 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_ID_in_func_decl469 = new BitSet(new long[]{0x0000000014000000L});
    public static final BitSet FOLLOW_26_in_func_decl475 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000800L});
    public static final BitSet FOLLOW_func_body_in_func_decl480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_enum_decl508 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_ID_in_enum_decl510 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_75_in_enum_decl512 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_name_in_enum_decl514 = new BitSet(new long[]{0x0000000010000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_28_in_enum_decl517 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_name_in_enum_decl519 = new BitSet(new long[]{0x0000000010000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_77_in_enum_decl523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_v_type_in_variable_decl551 = new BitSet(new long[]{0x0000004008000400L});
    public static final BitSet FOLLOW_ID_in_variable_decl564 = new BitSet(new long[]{0x0000002010000042L});
    public static final BitSet FOLLOW_28_in_variable_decl570 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_ID_in_variable_decl574 = new BitSet(new long[]{0x0000002010000042L});
    public static final BitSet FOLLOW_fixed_size_array_in_variable_decl580 = new BitSet(new long[]{0x0000002000000042L});
    public static final BitSet FOLLOW_assignement_in_variable_decl583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_fixed_size_array598 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_INT_in_fixed_size_array599 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_fixed_size_array600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EQUAL_in_assignement613 = new BitSet(new long[]{0x0000000000020880L,0x0000000000000800L});
    public static final BitSet FOLLOW_INT_in_assignement616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_array_of_value_in_assignement619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_assignement623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_assignement628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_array_of_value640 = new BitSet(new long[]{0x0000000000000880L,0x0000000000000800L});
    public static final BitSet FOLLOW_INT_in_array_of_value642 = new BitSet(new long[]{0x0000000010000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_array_of_value_in_array_of_value645 = new BitSet(new long[]{0x0000000010000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_FLOAT_in_array_of_value649 = new BitSet(new long[]{0x0000000010000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_28_in_array_of_value653 = new BitSet(new long[]{0x0000000000000880L,0x0000000000000800L});
    public static final BitSet FOLLOW_INT_in_array_of_value656 = new BitSet(new long[]{0x0000000010000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_array_of_value_in_array_of_value659 = new BitSet(new long[]{0x0000000010000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_FLOAT_in_array_of_value663 = new BitSet(new long[]{0x0000000010000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_77_in_array_of_value667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_v_signed_modifier_in_v_type680 = new BitSet(new long[]{0x0018000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_v_size_modifier_in_v_type683 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_v_type687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_v_signed_modifier_in_v_type692 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_v_type696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_v_type699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_v_type701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_v_type704 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_ID_in_v_type706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sc_type_in_v_type710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_v_type713 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_otemplate_in_v_type715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_v_signed_modifier742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LT_in_otemplate751 = new BitSet(new long[]{0x0000000000000C00L});
    public static final BitSet FOLLOW_set_in_otemplate753 = new BitSet(new long[]{0x0000000010000100L});
    public static final BitSet FOLLOW_28_in_otemplate760 = new BitSet(new long[]{0x0000000000000C00L});
    public static final BitSet FOLLOW_set_in_otemplate762 = new BitSet(new long[]{0x0000000010000100L});
    public static final BitSet FOLLOW_GT_in_otemplate769 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_actor779 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_actor780 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_ID_in_actor781 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_actor782 = new BitSet(new long[]{0x0000000080000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_31_in_actor786 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_actor_inst_in_actor788 = new BitSet(new long[]{0x0000000010000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_28_in_actor790 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_actor_inst_in_actor791 = new BitSet(new long[]{0x0000000010000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_75_in_actor796 = new BitSet(new long[]{0x0000000800000400L});
    public static final BitSet FOLLOW_actor_body_in_actor799 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_77_in_actor802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_actor_inst813 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_actor_inst814 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_actor_inst815 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_actor_inst816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_connection831 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_connection832 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_link_in_connection833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_link846 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_link847 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_ID_in_link850 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_link851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_sensitive881 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_sensitive883 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_ID_in_sensitive885 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_sensitive888 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_method_in_sensitive889 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_ID_in_method915 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_method916 = new BitSet(new long[]{0x0060200006020E10L});
    public static final BitSet FOLLOW_func_arg_in_method918 = new BitSet(new long[]{0x0000000014000000L});
    public static final BitSet FOLLOW_28_in_method920 = new BitSet(new long[]{0x0060200002020E10L});
    public static final BitSet FOLLOW_func_arg_in_method923 = new BitSet(new long[]{0x0000000014000000L});
    public static final BitSet FOLLOW_26_in_method930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_value_in_func_arg956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_actor_method_decl_in_actor_method985 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_SEMICOLON_in_actor_method987 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_sensitive_in_actor_method992 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_SEMICOLON_in_actor_method994 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000020L});
    public static final BitSet FOLLOW_35_in_actor_method_decl1029 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_ID_in_actor_method_decl1034 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_actor_method_decl1035 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_actor_body_elt_in_actor_body1048 = new BitSet(new long[]{0x0000000800000402L});
    public static final BitSet FOLLOW_actor_method_in_actor_body_elt1067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_func_call_in_actor_body_elt1075 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_SEMICOLON_in_actor_body_elt1077 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_connection_in_actor_body_elt1083 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_SEMICOLON_in_actor_body_elt1085 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sc_signal_in_signal_dec1110 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_name_in_signal_dec1113 = new BitSet(new long[]{0x0000002010000002L});
    public static final BitSet FOLLOW_28_in_signal_dec1116 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_name_in_signal_dec1117 = new BitSet(new long[]{0x0000002010000002L});
    public static final BitSet FOLLOW_fixed_size_array_in_signal_dec1122 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_67_in_sc_signal1156 = new BitSet(new long[]{0x0000010000001000L});
    public static final BitSet FOLLOW_40_in_sc_signal1158 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LT_in_sc_signal1161 = new BitSet(new long[]{0xC000020000000400L,0x0000000000000010L});
    public static final BitSet FOLLOW_signal_type_in_sc_signal1164 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_GT_in_sc_signal1167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sc_type_in_signal_type1189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_signal_type1198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_func_call1231 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_func_call1234 = new BitSet(new long[]{0x0060200006020E10L});
    public static final BitSet FOLLOW_func_arg_in_func_call1236 = new BitSet(new long[]{0x0000000014000000L});
    public static final BitSet FOLLOW_28_in_func_call1239 = new BitSet(new long[]{0x0060200002020E10L});
    public static final BitSet FOLLOW_func_arg_in_func_call1241 = new BitSet(new long[]{0x0000000014000000L});
    public static final BitSet FOLLOW_26_in_func_call1246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_port_type_in_port_decl1285 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_name_in_port_decl1287 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_port_decl1290 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_name_in_port_decl1292 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_ID_in_name1324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sc_clock_in_port_type1338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sc_in_in_port_type1348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sc_out_in_port_type1361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sc_inout_in_port_type1374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_sc_inout1395 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LT_in_sc_inout1397 = new BitSet(new long[]{0xC000020000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_sc_type_in_sc_inout1400 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_GT_in_sc_inout1403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_sc_inout1418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_sc_inout1431 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LT_in_sc_inout1433 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_INT_in_sc_inout1436 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_GT_in_sc_inout1439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_sc_out1464 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LT_in_sc_out1467 = new BitSet(new long[]{0xC000020000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_sc_type_in_sc_out1470 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_GT_in_sc_out1474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_sc_out1488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_sc_out1501 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LT_in_sc_out1503 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_INT_in_sc_out1507 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_GT_in_sc_out1510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_sc_in1532 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LT_in_sc_in1534 = new BitSet(new long[]{0xC000020000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_sc_type_in_sc_in1537 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_GT_in_sc_in1541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_sc_in1555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_sc_in1568 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LT_in_sc_in1570 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_INT_in_sc_in1574 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_GT_in_sc_in1577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_sc_clock1599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_block_in_func_body1612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_block1652 = new BitSet(new long[]{0xC01E120000000400L,0x00000000000027D0L});
    public static final BitSet FOLLOW_variable_decl_in_block1656 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_SEMICOLON_in_block1659 = new BitSet(new long[]{0xC01E120000000400L,0x00000000000027D0L});
    public static final BitSet FOLLOW_sc_assignement_in_block1663 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_SEMICOLON_in_block1665 = new BitSet(new long[]{0xC01E120000000400L,0x00000000000027D0L});
    public static final BitSet FOLLOW_v_assignement_in_block1670 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_SEMICOLON_in_block1672 = new BitSet(new long[]{0xC01E120000000400L,0x00000000000027D0L});
    public static final BitSet FOLLOW_cconstruct_in_block1677 = new BitSet(new long[]{0xC01E120000000400L,0x00000000000027D0L});
    public static final BitSet FOLLOW_func_call_in_block1684 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_SEMICOLON_in_block1686 = new BitSet(new long[]{0xC01E120000000400L,0x00000000000027D0L});
    public static final BitSet FOLLOW_flux_in_block1691 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_SEMICOLON_in_block1693 = new BitSet(new long[]{0xC01E120000000400L,0x00000000000027D0L});
    public static final BitSet FOLLOW_77_in_block1698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_case_construct_in_cconstruct1711 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_if_construct_in_cconstruct1725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_if_construct1757 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_if_construct1758 = new BitSet(new long[]{0x0060200002022E10L});
    public static final BitSet FOLLOW_cond_in_if_construct1759 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_if_construct1761 = new BitSet(new long[]{0x0000000000000400L,0x0000000000000800L});
    public static final BitSet FOLLOW_if_content_in_if_construct1764 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_elsif_construct_in_if_construct1769 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_47_in_elsif_construct1812 = new BitSet(new long[]{0x0004000000000400L,0x0000000000000800L});
    public static final BitSet FOLLOW_50_in_elsif_construct1817 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_elsif_construct1818 = new BitSet(new long[]{0x0060200002022E10L});
    public static final BitSet FOLLOW_cond_in_elsif_construct1819 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_elsif_construct1821 = new BitSet(new long[]{0x0000000000000400L,0x0000000000000800L});
    public static final BitSet FOLLOW_if_content_in_elsif_construct1828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_if_content_in_elsif_construct1854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_v_assignement_in_if_content1890 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_SEMICOLON_in_if_content1893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_block_in_if_content1900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_test_express_in_cond1930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_test_in_test_express1977 = new BitSet(new long[]{0x0000000001000002L,0x0000000000001000L});
    public static final BitSet FOLLOW_expr_right_in_test_express1985 = new BitSet(new long[]{0x0000000001000002L,0x0000000000001000L});
    public static final BitSet FOLLOW_enclosed_expr_in_test_express2012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_enclosed_expr2036 = new BitSet(new long[]{0x0060200002022E10L});
    public static final BitSet FOLLOW_test_express_in_enclosed_expr2043 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_enclosed_expr2047 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logic_op_in_expr_right2074 = new BitSet(new long[]{0x0060200002022E10L});
    public static final BitSet FOLLOW_test_express_in_expr_right2083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_test2102 = new BitSet(new long[]{0x0060200002020E10L});
    public static final BitSet FOLLOW_value_in_test2113 = new BitSet(new long[]{0x0000000000003142L});
    public static final BitSet FOLLOW_comp_op_in_test2119 = new BitSet(new long[]{0x0060200002020E10L});
    public static final BitSet FOLLOW_value_in_test2125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_comp_op2173 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_EQUAL_in_comp_op2189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_logic_op2201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_logic_op2213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_case_construct2240 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_case_construct2241 = new BitSet(new long[]{0x0060200002020E10L});
    public static final BitSet FOLLOW_value_in_case_construct2242 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_case_construct2243 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_75_in_case_construct2244 = new BitSet(new long[]{0x0000480000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_case_elt_in_case_construct2248 = new BitSet(new long[]{0x0000480000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_77_in_case_construct2256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_case_elt2296 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_ID_in_case_elt2299 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_46_in_case_elt2304 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_case_elt2307 = new BitSet(new long[]{0x0004040000000402L,0x0000000000000800L});
    public static final BitSet FOLLOW_v_assignement_in_case_elt2312 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_SEMICOLON_in_case_elt2314 = new BitSet(new long[]{0x0004040000000402L,0x0000000000000800L});
    public static final BitSet FOLLOW_sc_assignement_in_case_elt2319 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_SEMICOLON_in_case_elt2321 = new BitSet(new long[]{0x0004040000000402L,0x0000000000000800L});
    public static final BitSet FOLLOW_if_construct_in_case_elt2326 = new BitSet(new long[]{0x0004040000000402L,0x0000000000000800L});
    public static final BitSet FOLLOW_func_call_in_case_elt2332 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_SEMICOLON_in_case_elt2334 = new BitSet(new long[]{0x0004040000000402L,0x0000000000000800L});
    public static final BitSet FOLLOW_block_in_case_elt2339 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_SEMICOLON_in_case_elt2341 = new BitSet(new long[]{0x0004040000000402L,0x0000000000000800L});
    public static final BitSet FOLLOW_flux_in_case_elt2346 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_SEMICOLON_in_case_elt2348 = new BitSet(new long[]{0x0004040000000402L,0x0000000000000800L});
    public static final BitSet FOLLOW_42_in_case_elt2356 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_SEMICOLON_in_case_elt2358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_flux2388 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_flux2389 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_ID_in_flux2392 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_flux2394 = new BitSet(new long[]{0x0060200002020E10L});
    public static final BitSet FOLLOW_value_in_flux2396 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_flux2399 = new BitSet(new long[]{0x0060200002020E10L});
    public static final BitSet FOLLOW_value_in_flux2402 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_ID_in_v_assignement2420 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EQUAL_in_v_assignement2422 = new BitSet(new long[]{0x0060200002020E10L});
    public static final BitSet FOLLOW_assignement_value_in_v_assignement2424 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_sc_assignement2455 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_sc_assignement2456 = new BitSet(new long[]{0x0060200002020E10L});
    public static final BitSet FOLLOW_assignement_value_in_sc_assignement2457 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_sc_assignement2458 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_value_in_assignement_value2490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HEX_in_value2514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BIN_in_value2531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_value2548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_value2565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_var_value_in_value2587 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_OP_in_value2591 = new BitSet(new long[]{0x0060200002020E10L});
    public static final BitSet FOLLOW_value_in_value2595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_func_call_in_value2625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sc_method_in_value2641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_var_name_in_var_value2666 = new BitSet(new long[]{0x0000002020000002L});
    public static final BitSet FOLLOW_var_comp_in_var_value2669 = new BitSet(new long[]{0x0000002020000002L});
    public static final BitSet FOLLOW_29_in_var_comp2702 = new BitSet(new long[]{0x0060200002000400L});
    public static final BitSet FOLLOW_sc_method_in_var_comp2707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_method_in_var_comp2726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_var_comp2748 = new BitSet(new long[]{0x0060200002020E10L});
    public static final BitSet FOLLOW_value_in_var_comp2749 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_var_comp2750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_var_name2776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_sc_type2800 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LT_in_sc_type2802 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_INT_in_sc_type2804 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_GT_in_sc_type2806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_sc_type2821 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LT_in_sc_type2824 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_INT_in_sc_type2826 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_GT_in_sc_type2828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_sc_type2843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_sc_type2854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_sc_method2873 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_INT_in_sc_method2878 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_sc_method2880 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_INT_in_sc_method2886 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_sc_method2887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_sc_method2909 = new BitSet(new long[]{0x0060200002020E10L});
    public static final BitSet FOLLOW_value_in_sc_method2916 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_sc_method2919 = new BitSet(new long[]{0x0060200002020E10L});
    public static final BitSet FOLLOW_value_in_sc_method2924 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_sc_method2926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_sc_method2948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_sc_method2952 = new BitSet(new long[]{0x0060200002020E10L});
    public static final BitSet FOLLOW_value_in_sc_method2959 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_sc_method2962 = new BitSet(new long[]{0x0060200002020E10L});
    public static final BitSet FOLLOW_value_in_sc_method2967 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_sc_method2968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_test_in_synpred1_Systemc_basic1977 = new BitSet(new long[]{0x0000000001000002L,0x0000000000001000L});
    public static final BitSet FOLLOW_expr_right_in_synpred1_Systemc_basic1985 = new BitSet(new long[]{0x0000000001000002L,0x0000000000001000L});

}