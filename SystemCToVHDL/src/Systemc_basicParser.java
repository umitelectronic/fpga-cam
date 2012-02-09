// $ANTLR 3.4 /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g 2012-02-06 17:28:10

import org.antlr.stringtemplate.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.debug.*;
import java.io.IOException;
import org.antlr.stringtemplate.*;
import org.antlr.stringtemplate.language.*;
import java.util.HashMap;
@SuppressWarnings({"all", "warnings", "unchecked"})
public class Systemc_basicParser extends DebugParser {
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



public static final String[] ruleNames = new String[] {
    "invalidRule", "actor", "synpred1_Systemc_basic", "signal_dec", "assignement_value", 
    "v_size_modifier", "comp_op", "module_decl", "cond", "if_content", "sc_method", 
    "v_type", "flux", "var_comp", "otemplate", "define", "actor_inst", "case_construct", 
    "elsif_construct", "case_elt", "method", "port_decl", "test", "cfile", 
    "block", "name", "func_call", "link", "v_assignement", "func_decl", 
    "variable_decl", "actor_body", "array_of_value", "test_express", "var_name", 
    "sc_clock", "assignement", "func_body", "pre_processor", "logic_op", 
    "cconstruct", "port_type", "actor_method_decl", "sc_signal", "expression", 
    "actor_method", "v_signed_modifier", "sc_out", "sc_assignement", "sc_type", 
    "func_arg", "enclosed_expr", "signal_type", "value", "fixed_size_array", 
    "var_value", "sensitive", "connection", "declarations", "actor_body_elt", 
    "module_body", "sc_in", "includes", "enum_decl", "sc_inout", "endif", 
    "if_construct"
};

public static final boolean[] decisionCanBacktrack = new boolean[] {
    false, // invalid decision
    false, false, false, false, false, false, false, false, false, false, 
        false, false, false, false, false, false, false, false, false, false, 
        false, false, false, false, false, false, false, false, false, false, 
        false, false, false, false, false, false, false, false, false, false, 
        false, false, false, false, false, false, false, false, false, false, 
        false, false, false, false, false, true, false, false, false, false, 
        false, false, false, false, false, false, false, false, false, false, 
        false, false, false, false
};

 
    public int ruleLevel = 0;
    public int getRuleLevel() { return ruleLevel; }
    public void incRuleLevel() { ruleLevel++; }
    public void decRuleLevel() { ruleLevel--; }
    public Systemc_basicParser(TokenStream input) {
        this(input, DebugEventSocketProxy.DEFAULT_DEBUGGER_PORT, new RecognizerSharedState());
    }
    public Systemc_basicParser(TokenStream input, int port, RecognizerSharedState state) {
        super(input, state);
        DebugEventSocketProxy proxy =
            new DebugEventSocketProxy(this, port, null);

        setDebugListener(proxy);
        try {
            proxy.handshake();
        }
        catch (IOException ioe) {
            reportError(ioe);
        }
    }

public Systemc_basicParser(TokenStream input, DebugEventListener dbg) {
    super(input, dbg, new RecognizerSharedState());
}

protected boolean evalPredicate(boolean result, String predicate) {
    dbg.semanticPredicate(result, predicate);
    return result;
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
        HashMap type_obj;
    }
    protected Stack cfile_stack = new Stack();


    public static class cfile_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "cfile"
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:19:1: cfile : ( pre_processor )* ( declarations[$cfile::vars] )* module_decl SEMICOLON ( declarations[$cfile::vars] )* ( pre_processor )* -> file(entity=$module_decl.st);
    public final Systemc_basicParser.cfile_return cfile() throws RecognitionException {
        cfile_stack.push(new cfile_scope());
        Systemc_basicParser.cfile_return retval = new Systemc_basicParser.cfile_return();
        retval.start = input.LT(1);


        Systemc_basicParser.module_decl_return module_decl1 =null;



          ((cfile_scope)cfile_stack.peek()).functions = new HashMap();
          ((cfile_scope)cfile_stack.peek()).vars = new HashMap();
           ((cfile_scope)cfile_stack.peek()).type_obj = new HashMap();

        try { dbg.enterRule(getGrammarFileName(), "cfile");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(19, 0);

        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:31:2: ( ( pre_processor )* ( declarations[$cfile::vars] )* module_decl SEMICOLON ( declarations[$cfile::vars] )* ( pre_processor )* -> file(entity=$module_decl.st))
            dbg.enterAlt(1);

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:32:3: ( pre_processor )* ( declarations[$cfile::vars] )* module_decl SEMICOLON ( declarations[$cfile::vars] )* ( pre_processor )*
            {
            dbg.location(32,3);
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:32:3: ( pre_processor )*
            try { dbg.enterSubRule(1);

            loop1:
            do {
                int alt1=2;
                try { dbg.enterDecision(1, decisionCanBacktrack[1]);

                int LA1_0 = input.LA(1);

                if ( (LA1_0==19||(LA1_0 >= 21 && LA1_0 <= 23)) ) {
                    alt1=1;
                }


                } finally {dbg.exitDecision(1);}

                switch (alt1) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:32:3: pre_processor
            	    {
            	    dbg.location(32,3);
            	    pushFollow(FOLLOW_pre_processor_in_cfile48);
            	    pre_processor();

            	    state._fsp--;
            	    if (state.failed) return retval;

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);
            } finally {dbg.exitSubRule(1);}

            dbg.location(33,3);
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:33:3: ( declarations[$cfile::vars] )*
            try { dbg.enterSubRule(2);

            loop2:
            do {
                int alt2=2;
                try { dbg.enterDecision(2, decisionCanBacktrack[2]);

                int LA2_0 = input.LA(1);

                if ( (LA2_0==ID||LA2_0==34||LA2_0==41||LA2_0==44||(LA2_0 >= 48 && LA2_0 <= 49)||(LA2_0 >= 51 && LA2_0 <= 52)||(LA2_0 >= 55 && LA2_0 <= 68)||(LA2_0 >= 70 && LA2_0 <= 71)||(LA2_0 >= 73 && LA2_0 <= 74)) ) {
                    alt2=1;
                }


                } finally {dbg.exitDecision(2);}

                switch (alt2) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:33:3: declarations[$cfile::vars]
            	    {
            	    dbg.location(33,3);
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
            } finally {dbg.exitSubRule(2);}

            dbg.location(34,3);
            pushFollow(FOLLOW_module_decl_in_cfile60);
            module_decl1=module_decl();

            state._fsp--;
            if (state.failed) return retval;
            dbg.location(34,15);
            match(input,SEMICOLON,FOLLOW_SEMICOLON_in_cfile62); if (state.failed) return retval;
            dbg.location(35,3);
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:35:3: ( declarations[$cfile::vars] )*
            try { dbg.enterSubRule(3);

            loop3:
            do {
                int alt3=2;
                try { dbg.enterDecision(3, decisionCanBacktrack[3]);

                int LA3_0 = input.LA(1);

                if ( (LA3_0==ID||LA3_0==34||LA3_0==41||LA3_0==44||(LA3_0 >= 48 && LA3_0 <= 49)||(LA3_0 >= 51 && LA3_0 <= 52)||(LA3_0 >= 55 && LA3_0 <= 68)||(LA3_0 >= 70 && LA3_0 <= 71)||(LA3_0 >= 73 && LA3_0 <= 74)) ) {
                    alt3=1;
                }


                } finally {dbg.exitDecision(3);}

                switch (alt3) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:35:3: declarations[$cfile::vars]
            	    {
            	    dbg.location(35,3);
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
            } finally {dbg.exitSubRule(3);}

            dbg.location(36,3);
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:36:3: ( pre_processor )*
            try { dbg.enterSubRule(4);

            loop4:
            do {
                int alt4=2;
                try { dbg.enterDecision(4, decisionCanBacktrack[4]);

                int LA4_0 = input.LA(1);

                if ( (LA4_0==19||(LA4_0 >= 21 && LA4_0 <= 23)) ) {
                    alt4=1;
                }


                } finally {dbg.exitDecision(4);}

                switch (alt4) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:36:3: pre_processor
            	    {
            	    dbg.location(36,3);
            	    pushFollow(FOLLOW_pre_processor_in_cfile72);
            	    pre_processor();

            	    state._fsp--;
            	    if (state.failed) return retval;

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);
            } finally {dbg.exitSubRule(4);}


            // TEMPLATE REWRITE
            if ( state.backtracking==0 ) {
              // 37:2: -> file(entity=$module_decl.st)
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
        dbg.location(38, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "cfile");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
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
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:40:1: pre_processor : ( includes | define | '#endif' ) ;
    public final Systemc_basicParser.pre_processor_return pre_processor() throws RecognitionException {
        Systemc_basicParser.pre_processor_return retval = new Systemc_basicParser.pre_processor_return();
        retval.start = input.LT(1);


        try { dbg.enterRule(getGrammarFileName(), "pre_processor");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(40, 0);

        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:40:15: ( ( includes | define | '#endif' ) )
            dbg.enterAlt(1);

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:40:17: ( includes | define | '#endif' )
            {
            dbg.location(40,17);
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:40:17: ( includes | define | '#endif' )
            int alt5=3;
            try { dbg.enterSubRule(5);
            try { dbg.enterDecision(5, decisionCanBacktrack[5]);

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

                dbg.recognitionException(nvae);
                throw nvae;

            }

            } finally {dbg.exitDecision(5);}

            switch (alt5) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:40:18: includes
                    {
                    dbg.location(40,18);
                    pushFollow(FOLLOW_includes_in_pre_processor96);
                    includes();

                    state._fsp--;
                    if (state.failed) return retval;

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:41:4: define
                    {
                    dbg.location(41,4);
                    pushFollow(FOLLOW_define_in_pre_processor102);
                    define();

                    state._fsp--;
                    if (state.failed) return retval;

                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:42:4: '#endif'
                    {
                    dbg.location(42,4);
                    match(input,21,FOLLOW_21_in_pre_processor107); if (state.failed) return retval;

                    }
                    break;

            }
            } finally {dbg.exitSubRule(5);}


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
        dbg.location(43, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "pre_processor");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
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
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:45:1: includes : '#include' STRING_LITERAL ;
    public final Systemc_basicParser.includes_return includes() throws RecognitionException {
        Systemc_basicParser.includes_return retval = new Systemc_basicParser.includes_return();
        retval.start = input.LT(1);


        try { dbg.enterRule(getGrammarFileName(), "includes");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(45, 0);

        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:45:10: ( '#include' STRING_LITERAL )
            dbg.enterAlt(1);

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:45:12: '#include' STRING_LITERAL
            {
            dbg.location(45,12);
            match(input,23,FOLLOW_23_in_includes118); if (state.failed) return retval;
            dbg.location(45,23);
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
        dbg.location(46, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "includes");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
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
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:48:1: define : ( '#define ' | '#ifndef ' ) ID ( INT | ID | HEX )? ;
    public final Systemc_basicParser.define_return define() throws RecognitionException {
        Systemc_basicParser.define_return retval = new Systemc_basicParser.define_return();
        retval.start = input.LT(1);


        try { dbg.enterRule(getGrammarFileName(), "define");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(48, 0);

        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:48:8: ( ( '#define ' | '#ifndef ' ) ID ( INT | ID | HEX )? )
            dbg.enterAlt(1);

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:48:10: ( '#define ' | '#ifndef ' ) ID ( INT | ID | HEX )?
            {
            dbg.location(48,10);
            if ( input.LA(1)==19||input.LA(1)==22 ) {
                input.consume();
                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                dbg.recognitionException(mse);
                throw mse;
            }

            dbg.location(48,34);
            match(input,ID,FOLLOW_ID_in_define136); if (state.failed) return retval;
            dbg.location(48,37);
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:48:37: ( INT | ID | HEX )?
            int alt6=2;
            try { dbg.enterSubRule(6);
            try { dbg.enterDecision(6, decisionCanBacktrack[6]);

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
            else if ( (LA6_0==HEX||LA6_0==INT) ) {
                alt6=1;
            }
            } finally {dbg.exitDecision(6);}

            switch (alt6) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:
                    {
                    dbg.location(48,37);
                    if ( (input.LA(1) >= HEX && input.LA(1) <= INT) ) {
                        input.consume();
                        state.errorRecovery=false;
                        state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        dbg.recognitionException(mse);
                        throw mse;
                    }


                    }
                    break;

            }
            } finally {dbg.exitSubRule(6);}


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
        dbg.location(49, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "define");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
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
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:50:1: endif : '#endif ' ;
    public final Systemc_basicParser.endif_return endif() throws RecognitionException {
        Systemc_basicParser.endif_return retval = new Systemc_basicParser.endif_return();
        retval.start = input.LT(1);


        try { dbg.enterRule(getGrammarFileName(), "endif");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(50, 0);

        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:50:7: ( '#endif ' )
            dbg.enterAlt(1);

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:50:9: '#endif '
            {
            dbg.location(50,9);
            match(input,20,FOLLOW_20_in_endif156); if (state.failed) return retval;

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
        dbg.location(51, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "endif");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
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
        HashMap type_obj;
        HashMap mod_type;
    }
    protected Stack module_decl_stack = new Stack();


    public static class module_decl_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "module_decl"
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:53:1: module_decl : 'SC_MODULE' '(' ID ')' '{' module_body '}' -> entity(name=$ID.textports=$module_decl::portssignals=$module_decl::signalsenums=$module_decl::enumsvariables=$module_decl::obj_typeprocess=$module_decl::processesstructure= $module_decl::connectionsinstances=$module_decl::mod_typefunctions=$cfile::functions);
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

        try { dbg.enterRule(getGrammarFileName(), "module_decl");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(53, 0);

        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:73:5: ( 'SC_MODULE' '(' ID ')' '{' module_body '}' -> entity(name=$ID.textports=$module_decl::portssignals=$module_decl::signalsenums=$module_decl::enumsvariables=$module_decl::obj_typeprocess=$module_decl::processesstructure= $module_decl::connectionsinstances=$module_decl::mod_typefunctions=$cfile::functions))
            dbg.enterAlt(1);

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:73:9: 'SC_MODULE' '(' ID ')' '{' module_body '}'
            {
            dbg.location(73,9);
            match(input,36,FOLLOW_36_in_module_decl181); if (state.failed) return retval;
            dbg.location(73,21);
            match(input,25,FOLLOW_25_in_module_decl183); if (state.failed) return retval;
            dbg.location(73,25);
            ID2=(Token)match(input,ID,FOLLOW_ID_in_module_decl185); if (state.failed) return retval;
            dbg.location(73,28);
            match(input,26,FOLLOW_26_in_module_decl187); if (state.failed) return retval;
            dbg.location(73,32);
            match(input,75,FOLLOW_75_in_module_decl189); if (state.failed) return retval;
            dbg.location(74,9);
            pushFollow(FOLLOW_module_body_in_module_decl199);
            module_body();

            state._fsp--;
            if (state.failed) return retval;
            dbg.location(75,9);
            match(input,77,FOLLOW_77_in_module_decl209); if (state.failed) return retval;

            // TEMPLATE REWRITE
            if ( state.backtracking==0 ) {
              // 76:9: -> entity(name=$ID.textports=$module_decl::portssignals=$module_decl::signalsenums=$module_decl::enumsvariables=$module_decl::obj_typeprocess=$module_decl::processesstructure= $module_decl::connectionsinstances=$module_decl::mod_typefunctions=$cfile::functions)
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
        dbg.location(85, 4);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "module_decl");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
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
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:88:1: module_body : ( declarations[$module_decl::obj_type] )+ ;
    public final Systemc_basicParser.module_body_return module_body() throws RecognitionException {
        Systemc_basicParser.module_body_return retval = new Systemc_basicParser.module_body_return();
        retval.start = input.LT(1);


        try { dbg.enterRule(getGrammarFileName(), "module_body");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(88, 0);

        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:89:2: ( ( declarations[$module_decl::obj_type] )+ )
            dbg.enterAlt(1);

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:89:4: ( declarations[$module_decl::obj_type] )+
            {
            dbg.location(89,4);
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:89:4: ( declarations[$module_decl::obj_type] )+
            int cnt7=0;
            try { dbg.enterSubRule(7);

            loop7:
            do {
                int alt7=2;
                try { dbg.enterDecision(7, decisionCanBacktrack[7]);

                int LA7_0 = input.LA(1);

                if ( (LA7_0==ID||LA7_0==34||LA7_0==41||LA7_0==44||(LA7_0 >= 48 && LA7_0 <= 49)||(LA7_0 >= 51 && LA7_0 <= 52)||(LA7_0 >= 55 && LA7_0 <= 68)||(LA7_0 >= 70 && LA7_0 <= 71)||(LA7_0 >= 73 && LA7_0 <= 74)) ) {
                    alt7=1;
                }


                } finally {dbg.exitDecision(7);}

                switch (alt7) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:89:4: declarations[$module_decl::obj_type]
            	    {
            	    dbg.location(89,4);
            	    pushFollow(FOLLOW_declarations_in_module_body370);
            	    declarations(((module_decl_scope)module_decl_stack.peek()).obj_type);

            	    state._fsp--;
            	    if (state.failed) return retval;

            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        dbg.recognitionException(eee);

                        throw eee;
                }
                cnt7++;
            } while (true);
            } finally {dbg.exitSubRule(7);}


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
        dbg.location(90, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "module_body");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
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
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:92:1: declarations[HashMap vars] : ( port_decl SEMICOLON | signal_dec SEMICOLON | enum_decl SEMICOLON | variable_decl[$vars] SEMICOLON | func_decl ( SEMICOLON )? | actor ) ;
    public final Systemc_basicParser.declarations_return declarations(HashMap vars) throws RecognitionException {
        Systemc_basicParser.declarations_return retval = new Systemc_basicParser.declarations_return();
        retval.start = input.LT(1);


        Systemc_basicParser.port_decl_return port_decl3 =null;

        Systemc_basicParser.signal_dec_return signal_dec4 =null;

        Systemc_basicParser.enum_decl_return enum_decl5 =null;


        try { dbg.enterRule(getGrammarFileName(), "declarations");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(92, 0);

        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:93:2: ( ( port_decl SEMICOLON | signal_dec SEMICOLON | enum_decl SEMICOLON | variable_decl[$vars] SEMICOLON | func_decl ( SEMICOLON )? | actor ) )
            dbg.enterAlt(1);

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:94:2: ( port_decl SEMICOLON | signal_dec SEMICOLON | enum_decl SEMICOLON | variable_decl[$vars] SEMICOLON | func_decl ( SEMICOLON )? | actor )
            {
            dbg.location(94,2);
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:94:2: ( port_decl SEMICOLON | signal_dec SEMICOLON | enum_decl SEMICOLON | variable_decl[$vars] SEMICOLON | func_decl ( SEMICOLON )? | actor )
            int alt9=6;
            try { dbg.enterSubRule(9);
            try { dbg.enterDecision(9, decisionCanBacktrack[9]);

            try {
                isCyclicDecision = true;
                alt9 = dfa9.predict(input);
            }
            catch (NoViableAltException nvae) {
                dbg.recognitionException(nvae);
                throw nvae;
            }
            } finally {dbg.exitDecision(9);}

            switch (alt9) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:94:3: port_decl SEMICOLON
                    {
                    dbg.location(94,3);
                    pushFollow(FOLLOW_port_decl_in_declarations388);
                    port_decl3=port_decl();

                    state._fsp--;
                    if (state.failed) return retval;
                    dbg.location(94,13);
                    match(input,SEMICOLON,FOLLOW_SEMICOLON_in_declarations390); if (state.failed) return retval;
                    dbg.location(94,24);
                    if ( state.backtracking==0 ) {  ((module_decl_scope)module_decl_stack.peek()).ports.add((port_decl3!=null?port_decl3.st:null));}

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:95:4: signal_dec SEMICOLON
                    {
                    dbg.location(95,4);
                    pushFollow(FOLLOW_signal_dec_in_declarations398);
                    signal_dec4=signal_dec();

                    state._fsp--;
                    if (state.failed) return retval;
                    dbg.location(95,15);
                    match(input,SEMICOLON,FOLLOW_SEMICOLON_in_declarations400); if (state.failed) return retval;
                    dbg.location(95,25);
                    if ( state.backtracking==0 ) {  ((module_decl_scope)module_decl_stack.peek()).signals.add((signal_dec4!=null?signal_dec4.st:null));}

                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:96:4: enum_decl SEMICOLON
                    {
                    dbg.location(96,4);
                    pushFollow(FOLLOW_enum_decl_in_declarations407);
                    enum_decl5=enum_decl();

                    state._fsp--;
                    if (state.failed) return retval;
                    dbg.location(96,14);
                    match(input,SEMICOLON,FOLLOW_SEMICOLON_in_declarations409); if (state.failed) return retval;
                    dbg.location(96,24);
                    if ( state.backtracking==0 ) {  ((module_decl_scope)module_decl_stack.peek()).enums.add((enum_decl5!=null?enum_decl5.st:null));}

                    }
                    break;
                case 4 :
                    dbg.enterAlt(4);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:97:4: variable_decl[$vars] SEMICOLON
                    {
                    dbg.location(97,4);
                    pushFollow(FOLLOW_variable_decl_in_declarations416);
                    variable_decl(vars);

                    state._fsp--;
                    if (state.failed) return retval;
                    dbg.location(97,25);
                    match(input,SEMICOLON,FOLLOW_SEMICOLON_in_declarations419); if (state.failed) return retval;

                    }
                    break;
                case 5 :
                    dbg.enterAlt(5);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:98:4: func_decl ( SEMICOLON )?
                    {
                    dbg.location(98,4);
                    pushFollow(FOLLOW_func_decl_in_declarations424);
                    func_decl();

                    state._fsp--;
                    if (state.failed) return retval;
                    dbg.location(98,14);
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:98:14: ( SEMICOLON )?
                    int alt8=2;
                    try { dbg.enterSubRule(8);
                    try { dbg.enterDecision(8, decisionCanBacktrack[8]);

                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==SEMICOLON) ) {
                        alt8=1;
                    }
                    } finally {dbg.exitDecision(8);}

                    switch (alt8) {
                        case 1 :
                            dbg.enterAlt(1);

                            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:98:14: SEMICOLON
                            {
                            dbg.location(98,14);
                            match(input,SEMICOLON,FOLLOW_SEMICOLON_in_declarations426); if (state.failed) return retval;

                            }
                            break;

                    }
                    } finally {dbg.exitSubRule(8);}


                    }
                    break;
                case 6 :
                    dbg.enterAlt(6);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:99:4: actor
                    {
                    dbg.location(99,4);
                    pushFollow(FOLLOW_actor_in_declarations432);
                    actor();

                    state._fsp--;
                    if (state.failed) return retval;

                    }
                    break;

            }
            } finally {dbg.exitSubRule(9);}


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
        dbg.location(100, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "declarations");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
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
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:103:1: func_decl : ( ( v_type (class_name= ID '::' )? ) func= ID ( '(' ( ( v_type ID ( ',' v_type ID )* )? ) ')' ) ) ( func_body )? ;
    public final Systemc_basicParser.func_decl_return func_decl() throws RecognitionException {
        Systemc_basicParser.func_decl_return retval = new Systemc_basicParser.func_decl_return();
        retval.start = input.LT(1);


        Token class_name=null;
        Token func=null;
        Systemc_basicParser.func_body_return func_body6 =null;


        try { dbg.enterRule(getGrammarFileName(), "func_decl");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(103, 0);

        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:103:11: ( ( ( v_type (class_name= ID '::' )? ) func= ID ( '(' ( ( v_type ID ( ',' v_type ID )* )? ) ')' ) ) ( func_body )? )
            dbg.enterAlt(1);

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:104:2: ( ( v_type (class_name= ID '::' )? ) func= ID ( '(' ( ( v_type ID ( ',' v_type ID )* )? ) ')' ) ) ( func_body )?
            {
            dbg.location(104,2);
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:104:2: ( ( v_type (class_name= ID '::' )? ) func= ID ( '(' ( ( v_type ID ( ',' v_type ID )* )? ) ')' ) )
            dbg.enterAlt(1);

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:104:3: ( v_type (class_name= ID '::' )? ) func= ID ( '(' ( ( v_type ID ( ',' v_type ID )* )? ) ')' )
            {
            dbg.location(104,3);
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:104:3: ( v_type (class_name= ID '::' )? )
            dbg.enterAlt(1);

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:104:4: v_type (class_name= ID '::' )?
            {
            dbg.location(104,4);
            pushFollow(FOLLOW_v_type_in_func_decl448);
            v_type();

            state._fsp--;
            if (state.failed) return retval;
            dbg.location(104,11);
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:104:11: (class_name= ID '::' )?
            int alt10=2;
            try { dbg.enterSubRule(10);
            try { dbg.enterDecision(10, decisionCanBacktrack[10]);

            int LA10_0 = input.LA(1);

            if ( (LA10_0==ID) ) {
                int LA10_1 = input.LA(2);

                if ( (LA10_1==32) ) {
                    alt10=1;
                }
            }
            } finally {dbg.exitDecision(10);}

            switch (alt10) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:104:12: class_name= ID '::'
                    {
                    dbg.location(104,22);
                    class_name=(Token)match(input,ID,FOLLOW_ID_in_func_decl453); if (state.failed) return retval;
                    dbg.location(104,25);
                    match(input,32,FOLLOW_32_in_func_decl454); if (state.failed) return retval;

                    }
                    break;

            }
            } finally {dbg.exitSubRule(10);}


            }

            dbg.location(104,36);
            func=(Token)match(input,ID,FOLLOW_ID_in_func_decl460); if (state.failed) return retval;
            dbg.location(104,39);
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:104:39: ( '(' ( ( v_type ID ( ',' v_type ID )* )? ) ')' )
            dbg.enterAlt(1);

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:104:40: '(' ( ( v_type ID ( ',' v_type ID )* )? ) ')'
            {
            dbg.location(104,40);
            match(input,25,FOLLOW_25_in_func_decl462); if (state.failed) return retval;
            dbg.location(104,43);
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:104:43: ( ( v_type ID ( ',' v_type ID )* )? )
            dbg.enterAlt(1);

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:104:44: ( v_type ID ( ',' v_type ID )* )?
            {
            dbg.location(104,44);
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:104:44: ( v_type ID ( ',' v_type ID )* )?
            int alt12=2;
            try { dbg.enterSubRule(12);
            try { dbg.enterDecision(12, decisionCanBacktrack[12]);

            int LA12_0 = input.LA(1);

            if ( (LA12_0==ID||LA12_0==41||LA12_0==44||LA12_0==49||(LA12_0 >= 51 && LA12_0 <= 52)||(LA12_0 >= 62 && LA12_0 <= 63)||LA12_0==68||(LA12_0 >= 70 && LA12_0 <= 71)||(LA12_0 >= 73 && LA12_0 <= 74)) ) {
                alt12=1;
            }
            } finally {dbg.exitDecision(12);}

            switch (alt12) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:104:45: v_type ID ( ',' v_type ID )*
                    {
                    dbg.location(104,45);
                    pushFollow(FOLLOW_v_type_in_func_decl465);
                    v_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    dbg.location(104,52);
                    match(input,ID,FOLLOW_ID_in_func_decl467); if (state.failed) return retval;
                    dbg.location(104,55);
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:104:55: ( ',' v_type ID )*
                    try { dbg.enterSubRule(11);

                    loop11:
                    do {
                        int alt11=2;
                        try { dbg.enterDecision(11, decisionCanBacktrack[11]);

                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==28) ) {
                            alt11=1;
                        }


                        } finally {dbg.exitDecision(11);}

                        switch (alt11) {
                    	case 1 :
                    	    dbg.enterAlt(1);

                    	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:104:56: ',' v_type ID
                    	    {
                    	    dbg.location(104,56);
                    	    match(input,28,FOLLOW_28_in_func_decl470); if (state.failed) return retval;
                    	    dbg.location(104,59);
                    	    pushFollow(FOLLOW_v_type_in_func_decl471);
                    	    v_type();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    dbg.location(104,66);
                    	    match(input,ID,FOLLOW_ID_in_func_decl473); if (state.failed) return retval;

                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);
                    } finally {dbg.exitSubRule(11);}


                    }
                    break;

            }
            } finally {dbg.exitSubRule(12);}


            }

            dbg.location(104,73);
            match(input,26,FOLLOW_26_in_func_decl479); if (state.failed) return retval;

            }


            }

            dbg.location(104,79);
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:104:79: ( func_body )?
            int alt13=2;
            try { dbg.enterSubRule(13);
            try { dbg.enterDecision(13, decisionCanBacktrack[13]);

            int LA13_0 = input.LA(1);

            if ( (LA13_0==75) ) {
                alt13=1;
            }
            } finally {dbg.exitDecision(13);}

            switch (alt13) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:104:80: func_body
                    {
                    dbg.location(104,80);
                    pushFollow(FOLLOW_func_body_in_func_decl484);
                    func_body6=func_body();

                    state._fsp--;
                    if (state.failed) return retval;

                    }
                    break;

            }
            } finally {dbg.exitSubRule(13);}

            dbg.location(104,93);
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
        dbg.location(105, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "func_decl");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
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
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:107:1: enum_decl : 'enum' ID '{' name ( ',' name )* '}' -> enum(name=$ID.textmembers=$slist::names);
    public final Systemc_basicParser.enum_decl_return enum_decl() throws RecognitionException {
        slist_stack.push(new slist_scope());

        Systemc_basicParser.enum_decl_return retval = new Systemc_basicParser.enum_decl_return();
        retval.start = input.LT(1);


        Token ID7=null;


          ((slist_scope)slist_stack.peek()).names = new ArrayList();

        try { dbg.enterRule(getGrammarFileName(), "enum_decl");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(107, 0);

        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:112:2: ( 'enum' ID '{' name ( ',' name )* '}' -> enum(name=$ID.textmembers=$slist::names))
            dbg.enterAlt(1);

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:114:2: 'enum' ID '{' name ( ',' name )* '}'
            {
            dbg.location(114,2);
            match(input,48,FOLLOW_48_in_enum_decl512); if (state.failed) return retval;
            dbg.location(114,9);
            ID7=(Token)match(input,ID,FOLLOW_ID_in_enum_decl514); if (state.failed) return retval;
            dbg.location(114,12);
            match(input,75,FOLLOW_75_in_enum_decl516); if (state.failed) return retval;
            dbg.location(114,16);
            pushFollow(FOLLOW_name_in_enum_decl518);
            name();

            state._fsp--;
            if (state.failed) return retval;
            dbg.location(114,21);
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:114:21: ( ',' name )*
            try { dbg.enterSubRule(14);

            loop14:
            do {
                int alt14=2;
                try { dbg.enterDecision(14, decisionCanBacktrack[14]);

                int LA14_0 = input.LA(1);

                if ( (LA14_0==28) ) {
                    alt14=1;
                }


                } finally {dbg.exitDecision(14);}

                switch (alt14) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:114:22: ',' name
            	    {
            	    dbg.location(114,22);
            	    match(input,28,FOLLOW_28_in_enum_decl521); if (state.failed) return retval;
            	    dbg.location(114,26);
            	    pushFollow(FOLLOW_name_in_enum_decl523);
            	    name();

            	    state._fsp--;
            	    if (state.failed) return retval;

            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);
            } finally {dbg.exitSubRule(14);}

            dbg.location(114,33);
            match(input,77,FOLLOW_77_in_enum_decl527); if (state.failed) return retval;

            // TEMPLATE REWRITE
            if ( state.backtracking==0 ) {
              // 114:37: -> enum(name=$ID.textmembers=$slist::names)
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
        dbg.location(115, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "enum_decl");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
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
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:117:1: variable_decl[HashMap vars] : v_type ( '*' | '[]' )* n= ID ( ',' elt= ID )* ( fixed_size_array )* ( assignement )? ;
    public final Systemc_basicParser.variable_decl_return variable_decl(HashMap vars) throws RecognitionException {
        Systemc_basicParser.variable_decl_return retval = new Systemc_basicParser.variable_decl_return();
        retval.start = input.LT(1);


        Token n=null;
        Token elt=null;
        Systemc_basicParser.v_type_return v_type8 =null;


        try { dbg.enterRule(getGrammarFileName(), "variable_decl");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(117, 0);

        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:117:29: ( v_type ( '*' | '[]' )* n= ID ( ',' elt= ID )* ( fixed_size_array )* ( assignement )? )
            dbg.enterAlt(1);

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:118:2: v_type ( '*' | '[]' )* n= ID ( ',' elt= ID )* ( fixed_size_array )* ( assignement )?
            {
            dbg.location(118,2);
            pushFollow(FOLLOW_v_type_in_variable_decl555);
            v_type8=v_type();

            state._fsp--;
            if (state.failed) return retval;
            dbg.location(118,9);
            if ( state.backtracking==0 ) { vars.put((v_type8!=null?input.toString(v_type8.start,v_type8.stop):null), new ArrayList());}
            dbg.location(119,3);
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:119:3: ( '*' | '[]' )*
            try { dbg.enterSubRule(15);

            loop15:
            do {
                int alt15=2;
                try { dbg.enterDecision(15, decisionCanBacktrack[15]);

                int LA15_0 = input.LA(1);

                if ( (LA15_0==27||LA15_0==38) ) {
                    alt15=1;
                }


                } finally {dbg.exitDecision(15);}

                switch (alt15) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:
            	    {
            	    dbg.location(119,3);
            	    if ( input.LA(1)==27||input.LA(1)==38 ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        dbg.recognitionException(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);
            } finally {dbg.exitSubRule(15);}

            dbg.location(120,4);
            n=(Token)match(input,ID,FOLLOW_ID_in_variable_decl573); if (state.failed) return retval;
            dbg.location(120,8);
            if ( state.backtracking==0 ) { ((List) vars.get((v_type8!=null?input.toString(v_type8.start,v_type8.stop):null))).add((n!=null?n.getText():null));  
            	 ((cfile_scope)cfile_stack.peek()).type_obj.put((n!=null?n.getText():null), (v_type8!=null?input.toString(v_type8.start,v_type8.stop):null));}
            dbg.location(122,3);
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:122:3: ( ',' elt= ID )*
            try { dbg.enterSubRule(16);

            loop16:
            do {
                int alt16=2;
                try { dbg.enterDecision(16, decisionCanBacktrack[16]);

                int LA16_0 = input.LA(1);

                if ( (LA16_0==28) ) {
                    alt16=1;
                }


                } finally {dbg.exitDecision(16);}

                switch (alt16) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:122:4: ',' elt= ID
            	    {
            	    dbg.location(122,4);
            	    match(input,28,FOLLOW_28_in_variable_decl582); if (state.failed) return retval;
            	    dbg.location(122,11);
            	    elt=(Token)match(input,ID,FOLLOW_ID_in_variable_decl586); if (state.failed) return retval;
            	    dbg.location(122,15);
            	    if ( state.backtracking==0 ) { ((List) vars.get((v_type8!=null?input.toString(v_type8.start,v_type8.stop):null))).add((elt!=null?elt.getText():null));
            	    	((cfile_scope)cfile_stack.peek()).type_obj.put((elt!=null?elt.getText():null), (v_type8!=null?input.toString(v_type8.start,v_type8.stop):null)); }

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);
            } finally {dbg.exitSubRule(16);}

            dbg.location(123,53);
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:123:53: ( fixed_size_array )*
            try { dbg.enterSubRule(17);

            loop17:
            do {
                int alt17=2;
                try { dbg.enterDecision(17, decisionCanBacktrack[17]);

                int LA17_0 = input.LA(1);

                if ( (LA17_0==37) ) {
                    alt17=1;
                }


                } finally {dbg.exitDecision(17);}

                switch (alt17) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:123:53: fixed_size_array
            	    {
            	    dbg.location(123,53);
            	    pushFollow(FOLLOW_fixed_size_array_in_variable_decl592);
            	    fixed_size_array();

            	    state._fsp--;
            	    if (state.failed) return retval;

            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);
            } finally {dbg.exitSubRule(17);}

            dbg.location(123,71);
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:123:71: ( assignement )?
            int alt18=2;
            try { dbg.enterSubRule(18);
            try { dbg.enterDecision(18, decisionCanBacktrack[18]);

            int LA18_0 = input.LA(1);

            if ( (LA18_0==EQUAL) ) {
                alt18=1;
            }
            } finally {dbg.exitDecision(18);}

            switch (alt18) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:123:71: assignement
                    {
                    dbg.location(123,71);
                    pushFollow(FOLLOW_assignement_in_variable_decl595);
                    assignement();

                    state._fsp--;
                    if (state.failed) return retval;

                    }
                    break;

            }
            } finally {dbg.exitSubRule(18);}


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
        dbg.location(124, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "variable_decl");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
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
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:126:1: fixed_size_array : ( '[' INT ']' ) ;
    public final Systemc_basicParser.fixed_size_array_return fixed_size_array() throws RecognitionException {
        Systemc_basicParser.fixed_size_array_return retval = new Systemc_basicParser.fixed_size_array_return();
        retval.start = input.LT(1);


        try { dbg.enterRule(getGrammarFileName(), "fixed_size_array");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(126, 0);

        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:126:18: ( ( '[' INT ']' ) )
            dbg.enterAlt(1);

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:126:20: ( '[' INT ']' )
            {
            dbg.location(126,20);
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:126:20: ( '[' INT ']' )
            dbg.enterAlt(1);

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:126:21: '[' INT ']'
            {
            dbg.location(126,21);
            match(input,37,FOLLOW_37_in_fixed_size_array610); if (state.failed) return retval;
            dbg.location(126,24);
            match(input,INT,FOLLOW_INT_in_fixed_size_array611); if (state.failed) return retval;
            dbg.location(126,27);
            match(input,39,FOLLOW_39_in_fixed_size_array612); if (state.failed) return retval;

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
        dbg.location(127, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "fixed_size_array");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
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
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:129:1: assignement : '=' ( INT | array_of_value | FLOAT | STRING_LITERAL ) ;
    public final Systemc_basicParser.assignement_return assignement() throws RecognitionException {
        Systemc_basicParser.assignement_return retval = new Systemc_basicParser.assignement_return();
        retval.start = input.LT(1);


        try { dbg.enterRule(getGrammarFileName(), "assignement");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(129, 0);

        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:129:13: ( '=' ( INT | array_of_value | FLOAT | STRING_LITERAL ) )
            dbg.enterAlt(1);

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:130:2: '=' ( INT | array_of_value | FLOAT | STRING_LITERAL )
            {
            dbg.location(130,2);
            match(input,EQUAL,FOLLOW_EQUAL_in_assignement625); if (state.failed) return retval;
            dbg.location(130,6);
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:130:6: ( INT | array_of_value | FLOAT | STRING_LITERAL )
            int alt19=4;
            try { dbg.enterSubRule(19);
            try { dbg.enterDecision(19, decisionCanBacktrack[19]);

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

                dbg.recognitionException(nvae);
                throw nvae;

            }

            } finally {dbg.exitDecision(19);}

            switch (alt19) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:130:7: INT
                    {
                    dbg.location(130,7);
                    match(input,INT,FOLLOW_INT_in_assignement628); if (state.failed) return retval;

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:130:12: array_of_value
                    {
                    dbg.location(130,12);
                    pushFollow(FOLLOW_array_of_value_in_assignement631);
                    array_of_value();

                    state._fsp--;
                    if (state.failed) return retval;

                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:130:29: FLOAT
                    {
                    dbg.location(130,29);
                    match(input,FLOAT,FOLLOW_FLOAT_in_assignement635); if (state.failed) return retval;

                    }
                    break;
                case 4 :
                    dbg.enterAlt(4);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:130:38: STRING_LITERAL
                    {
                    dbg.location(130,38);
                    match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_assignement640); if (state.failed) return retval;

                    }
                    break;

            }
            } finally {dbg.exitSubRule(19);}


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
        dbg.location(131, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "assignement");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
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
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:133:1: array_of_value : '{' ( INT | array_of_value | FLOAT ) ( ',' ( INT | array_of_value | FLOAT ) )* '}' ;
    public final Systemc_basicParser.array_of_value_return array_of_value() throws RecognitionException {
        Systemc_basicParser.array_of_value_return retval = new Systemc_basicParser.array_of_value_return();
        retval.start = input.LT(1);


        try { dbg.enterRule(getGrammarFileName(), "array_of_value");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(133, 0);

        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:133:16: ( '{' ( INT | array_of_value | FLOAT ) ( ',' ( INT | array_of_value | FLOAT ) )* '}' )
            dbg.enterAlt(1);

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:133:18: '{' ( INT | array_of_value | FLOAT ) ( ',' ( INT | array_of_value | FLOAT ) )* '}'
            {
            dbg.location(133,18);
            match(input,75,FOLLOW_75_in_array_of_value652); if (state.failed) return retval;
            dbg.location(133,21);
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:133:21: ( INT | array_of_value | FLOAT )
            int alt20=3;
            try { dbg.enterSubRule(20);
            try { dbg.enterDecision(20, decisionCanBacktrack[20]);

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

                dbg.recognitionException(nvae);
                throw nvae;

            }

            } finally {dbg.exitDecision(20);}

            switch (alt20) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:133:22: INT
                    {
                    dbg.location(133,22);
                    match(input,INT,FOLLOW_INT_in_array_of_value654); if (state.failed) return retval;

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:133:27: array_of_value
                    {
                    dbg.location(133,27);
                    pushFollow(FOLLOW_array_of_value_in_array_of_value657);
                    array_of_value();

                    state._fsp--;
                    if (state.failed) return retval;

                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:133:44: FLOAT
                    {
                    dbg.location(133,44);
                    match(input,FLOAT,FOLLOW_FLOAT_in_array_of_value661); if (state.failed) return retval;

                    }
                    break;

            }
            } finally {dbg.exitSubRule(20);}

            dbg.location(133,51);
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:133:51: ( ',' ( INT | array_of_value | FLOAT ) )*
            try { dbg.enterSubRule(22);

            loop22:
            do {
                int alt22=2;
                try { dbg.enterDecision(22, decisionCanBacktrack[22]);

                int LA22_0 = input.LA(1);

                if ( (LA22_0==28) ) {
                    alt22=1;
                }


                } finally {dbg.exitDecision(22);}

                switch (alt22) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:133:52: ',' ( INT | array_of_value | FLOAT )
            	    {
            	    dbg.location(133,52);
            	    match(input,28,FOLLOW_28_in_array_of_value665); if (state.failed) return retval;
            	    dbg.location(133,56);
            	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:133:56: ( INT | array_of_value | FLOAT )
            	    int alt21=3;
            	    try { dbg.enterSubRule(21);
            	    try { dbg.enterDecision(21, decisionCanBacktrack[21]);

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

            	        dbg.recognitionException(nvae);
            	        throw nvae;

            	    }

            	    } finally {dbg.exitDecision(21);}

            	    switch (alt21) {
            	        case 1 :
            	            dbg.enterAlt(1);

            	            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:133:57: INT
            	            {
            	            dbg.location(133,57);
            	            match(input,INT,FOLLOW_INT_in_array_of_value668); if (state.failed) return retval;

            	            }
            	            break;
            	        case 2 :
            	            dbg.enterAlt(2);

            	            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:133:62: array_of_value
            	            {
            	            dbg.location(133,62);
            	            pushFollow(FOLLOW_array_of_value_in_array_of_value671);
            	            array_of_value();

            	            state._fsp--;
            	            if (state.failed) return retval;

            	            }
            	            break;
            	        case 3 :
            	            dbg.enterAlt(3);

            	            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:133:79: FLOAT
            	            {
            	            dbg.location(133,79);
            	            match(input,FLOAT,FOLLOW_FLOAT_in_array_of_value675); if (state.failed) return retval;

            	            }
            	            break;

            	    }
            	    } finally {dbg.exitSubRule(21);}


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);
            } finally {dbg.exitSubRule(22);}

            dbg.location(133,87);
            match(input,77,FOLLOW_77_in_array_of_value679); if (state.failed) return retval;

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
        dbg.location(134, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "array_of_value");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
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
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:137:1: v_type : ( ( ( v_signed_modifier )? ( v_size_modifier )? 'int' ) | ( ( v_signed_modifier )? 'char' ) | 'float' | 'void' | ( 'struct' ID ) | sc_type | ID ( otemplate )? ) ;
    public final Systemc_basicParser.v_type_return v_type() throws RecognitionException {
        Systemc_basicParser.v_type_return retval = new Systemc_basicParser.v_type_return();
        retval.start = input.LT(1);


        try { dbg.enterRule(getGrammarFileName(), "v_type");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(137, 0);

        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:137:8: ( ( ( ( v_signed_modifier )? ( v_size_modifier )? 'int' ) | ( ( v_signed_modifier )? 'char' ) | 'float' | 'void' | ( 'struct' ID ) | sc_type | ID ( otemplate )? ) )
            dbg.enterAlt(1);

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:137:10: ( ( ( v_signed_modifier )? ( v_size_modifier )? 'int' ) | ( ( v_signed_modifier )? 'char' ) | 'float' | 'void' | ( 'struct' ID ) | sc_type | ID ( otemplate )? )
            {
            dbg.location(137,10);
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:137:10: ( ( ( v_signed_modifier )? ( v_size_modifier )? 'int' ) | ( ( v_signed_modifier )? 'char' ) | 'float' | 'void' | ( 'struct' ID ) | sc_type | ID ( otemplate )? )
            int alt27=7;
            try { dbg.enterSubRule(27);
            try { dbg.enterDecision(27, decisionCanBacktrack[27]);

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

                    dbg.recognitionException(nvae);
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

                dbg.recognitionException(nvae);
                throw nvae;

            }

            } finally {dbg.exitDecision(27);}

            switch (alt27) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:137:11: ( ( v_signed_modifier )? ( v_size_modifier )? 'int' )
                    {
                    dbg.location(137,11);
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:137:11: ( ( v_signed_modifier )? ( v_size_modifier )? 'int' )
                    dbg.enterAlt(1);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:137:12: ( v_signed_modifier )? ( v_size_modifier )? 'int'
                    {
                    dbg.location(137,12);
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:137:12: ( v_signed_modifier )?
                    int alt23=2;
                    try { dbg.enterSubRule(23);
                    try { dbg.enterDecision(23, decisionCanBacktrack[23]);

                    int LA23_0 = input.LA(1);

                    if ( (LA23_0==73) ) {
                        alt23=1;
                    }
                    } finally {dbg.exitDecision(23);}

                    switch (alt23) {
                        case 1 :
                            dbg.enterAlt(1);

                            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:137:12: v_signed_modifier
                            {
                            dbg.location(137,12);
                            pushFollow(FOLLOW_v_signed_modifier_in_v_type692);
                            v_signed_modifier();

                            state._fsp--;
                            if (state.failed) return retval;

                            }
                            break;

                    }
                    } finally {dbg.exitSubRule(23);}

                    dbg.location(137,31);
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:137:31: ( v_size_modifier )?
                    int alt24=2;
                    try { dbg.enterSubRule(24);
                    try { dbg.enterDecision(24, decisionCanBacktrack[24]);

                    int LA24_0 = input.LA(1);

                    if ( (LA24_0==52||LA24_0==70) ) {
                        alt24=1;
                    }
                    } finally {dbg.exitDecision(24);}

                    switch (alt24) {
                        case 1 :
                            dbg.enterAlt(1);

                            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:137:31: v_size_modifier
                            {
                            dbg.location(137,31);
                            pushFollow(FOLLOW_v_size_modifier_in_v_type695);
                            v_size_modifier();

                            state._fsp--;
                            if (state.failed) return retval;

                            }
                            break;

                    }
                    } finally {dbg.exitSubRule(24);}

                    dbg.location(137,49);
                    match(input,51,FOLLOW_51_in_v_type699); if (state.failed) return retval;

                    }


                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:137:56: ( ( v_signed_modifier )? 'char' )
                    {
                    dbg.location(137,56);
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:137:56: ( ( v_signed_modifier )? 'char' )
                    dbg.enterAlt(1);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:137:57: ( v_signed_modifier )? 'char'
                    {
                    dbg.location(137,57);
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:137:57: ( v_signed_modifier )?
                    int alt25=2;
                    try { dbg.enterSubRule(25);
                    try { dbg.enterDecision(25, decisionCanBacktrack[25]);

                    int LA25_0 = input.LA(1);

                    if ( (LA25_0==73) ) {
                        alt25=1;
                    }
                    } finally {dbg.exitDecision(25);}

                    switch (alt25) {
                        case 1 :
                            dbg.enterAlt(1);

                            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:137:58: v_signed_modifier
                            {
                            dbg.location(137,58);
                            pushFollow(FOLLOW_v_signed_modifier_in_v_type704);
                            v_signed_modifier();

                            state._fsp--;
                            if (state.failed) return retval;

                            }
                            break;

                    }
                    } finally {dbg.exitSubRule(25);}

                    dbg.location(137,78);
                    match(input,44,FOLLOW_44_in_v_type708); if (state.failed) return retval;

                    }


                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:137:86: 'float'
                    {
                    dbg.location(137,86);
                    match(input,49,FOLLOW_49_in_v_type711); if (state.failed) return retval;

                    }
                    break;
                case 4 :
                    dbg.enterAlt(4);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:137:94: 'void'
                    {
                    dbg.location(137,94);
                    match(input,74,FOLLOW_74_in_v_type713); if (state.failed) return retval;

                    }
                    break;
                case 5 :
                    dbg.enterAlt(5);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:137:101: ( 'struct' ID )
                    {
                    dbg.location(137,101);
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:137:101: ( 'struct' ID )
                    dbg.enterAlt(1);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:137:102: 'struct' ID
                    {
                    dbg.location(137,102);
                    match(input,71,FOLLOW_71_in_v_type716); if (state.failed) return retval;
                    dbg.location(137,111);
                    match(input,ID,FOLLOW_ID_in_v_type718); if (state.failed) return retval;

                    }


                    }
                    break;
                case 6 :
                    dbg.enterAlt(6);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:137:116: sc_type
                    {
                    dbg.location(137,116);
                    pushFollow(FOLLOW_sc_type_in_v_type722);
                    sc_type();

                    state._fsp--;
                    if (state.failed) return retval;

                    }
                    break;
                case 7 :
                    dbg.enterAlt(7);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:137:125: ID ( otemplate )?
                    {
                    dbg.location(137,125);
                    match(input,ID,FOLLOW_ID_in_v_type725); if (state.failed) return retval;
                    dbg.location(137,128);
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:137:128: ( otemplate )?
                    int alt26=2;
                    try { dbg.enterSubRule(26);
                    try { dbg.enterDecision(26, decisionCanBacktrack[26]);

                    int LA26_0 = input.LA(1);

                    if ( (LA26_0==LT) ) {
                        alt26=1;
                    }
                    } finally {dbg.exitDecision(26);}

                    switch (alt26) {
                        case 1 :
                            dbg.enterAlt(1);

                            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:137:128: otemplate
                            {
                            dbg.location(137,128);
                            pushFollow(FOLLOW_otemplate_in_v_type727);
                            otemplate();

                            state._fsp--;
                            if (state.failed) return retval;

                            }
                            break;

                    }
                    } finally {dbg.exitSubRule(26);}


                    }
                    break;

            }
            } finally {dbg.exitSubRule(27);}


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
        dbg.location(138, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "v_type");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
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
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:139:1: v_size_modifier : ( 'short' | 'long' )+ ;
    public final Systemc_basicParser.v_size_modifier_return v_size_modifier() throws RecognitionException {
        Systemc_basicParser.v_size_modifier_return retval = new Systemc_basicParser.v_size_modifier_return();
        retval.start = input.LT(1);


        try { dbg.enterRule(getGrammarFileName(), "v_size_modifier");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(139, 0);

        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:139:17: ( ( 'short' | 'long' )+ )
            dbg.enterAlt(1);

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:139:18: ( 'short' | 'long' )+
            {
            dbg.location(139,18);
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:139:18: ( 'short' | 'long' )+
            int cnt28=0;
            try { dbg.enterSubRule(28);

            loop28:
            do {
                int alt28=2;
                try { dbg.enterDecision(28, decisionCanBacktrack[28]);

                int LA28_0 = input.LA(1);

                if ( (LA28_0==52||LA28_0==70) ) {
                    alt28=1;
                }


                } finally {dbg.exitDecision(28);}

                switch (alt28) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:
            	    {
            	    dbg.location(139,18);
            	    if ( input.LA(1)==52||input.LA(1)==70 ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        dbg.recognitionException(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt28 >= 1 ) break loop28;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(28, input);
                        dbg.recognitionException(eee);

                        throw eee;
                }
                cnt28++;
            } while (true);
            } finally {dbg.exitSubRule(28);}


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
        dbg.location(140, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "v_size_modifier");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
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
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:141:1: v_signed_modifier : 'unsigned' ;
    public final Systemc_basicParser.v_signed_modifier_return v_signed_modifier() throws RecognitionException {
        Systemc_basicParser.v_signed_modifier_return retval = new Systemc_basicParser.v_signed_modifier_return();
        retval.start = input.LT(1);


        try { dbg.enterRule(getGrammarFileName(), "v_signed_modifier");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(141, 0);

        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:141:19: ( 'unsigned' )
            dbg.enterAlt(1);

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:141:21: 'unsigned'
            {
            dbg.location(141,21);
            match(input,73,FOLLOW_73_in_v_signed_modifier754); if (state.failed) return retval;

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
        dbg.location(142, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "v_signed_modifier");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
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
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:143:1: otemplate : '<' ( ID | INT ) ( ',' ( ID | INT ) )* '>' ;
    public final Systemc_basicParser.otemplate_return otemplate() throws RecognitionException {
        Systemc_basicParser.otemplate_return retval = new Systemc_basicParser.otemplate_return();
        retval.start = input.LT(1);


        try { dbg.enterRule(getGrammarFileName(), "otemplate");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(143, 0);

        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:143:11: ( '<' ( ID | INT ) ( ',' ( ID | INT ) )* '>' )
            dbg.enterAlt(1);

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:143:13: '<' ( ID | INT ) ( ',' ( ID | INT ) )* '>'
            {
            dbg.location(143,13);
            match(input,LT,FOLLOW_LT_in_otemplate763); if (state.failed) return retval;
            dbg.location(143,17);
            if ( (input.LA(1) >= ID && input.LA(1) <= INT) ) {
                input.consume();
                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                dbg.recognitionException(mse);
                throw mse;
            }

            dbg.location(143,26);
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:143:26: ( ',' ( ID | INT ) )*
            try { dbg.enterSubRule(29);

            loop29:
            do {
                int alt29=2;
                try { dbg.enterDecision(29, decisionCanBacktrack[29]);

                int LA29_0 = input.LA(1);

                if ( (LA29_0==28) ) {
                    alt29=1;
                }


                } finally {dbg.exitDecision(29);}

                switch (alt29) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:143:27: ',' ( ID | INT )
            	    {
            	    dbg.location(143,27);
            	    match(input,28,FOLLOW_28_in_otemplate772); if (state.failed) return retval;
            	    dbg.location(143,31);
            	    if ( (input.LA(1) >= ID && input.LA(1) <= INT) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        dbg.recognitionException(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);
            } finally {dbg.exitSubRule(29);}

            dbg.location(143,41);
            match(input,GT,FOLLOW_GT_in_otemplate781); if (state.failed) return retval;

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
        dbg.location(144, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "otemplate");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
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
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:146:1: actor : 'SC_CTOR' '(' ID ')' ( ':' actor_inst ( ',' actor_inst )* )? '{' ( actor_body ) '}' ;
    public final Systemc_basicParser.actor_return actor() throws RecognitionException {
        Systemc_basicParser.actor_return retval = new Systemc_basicParser.actor_return();
        retval.start = input.LT(1);


        try { dbg.enterRule(getGrammarFileName(), "actor");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(146, 0);

        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:146:7: ( 'SC_CTOR' '(' ID ')' ( ':' actor_inst ( ',' actor_inst )* )? '{' ( actor_body ) '}' )
            dbg.enterAlt(1);

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:146:8: 'SC_CTOR' '(' ID ')' ( ':' actor_inst ( ',' actor_inst )* )? '{' ( actor_body ) '}'
            {
            dbg.location(146,8);
            match(input,34,FOLLOW_34_in_actor791); if (state.failed) return retval;
            dbg.location(146,17);
            match(input,25,FOLLOW_25_in_actor792); if (state.failed) return retval;
            dbg.location(146,20);
            match(input,ID,FOLLOW_ID_in_actor793); if (state.failed) return retval;
            dbg.location(146,22);
            match(input,26,FOLLOW_26_in_actor794); if (state.failed) return retval;
            dbg.location(146,27);
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:146:27: ( ':' actor_inst ( ',' actor_inst )* )?
            int alt31=2;
            try { dbg.enterSubRule(31);
            try { dbg.enterDecision(31, decisionCanBacktrack[31]);

            int LA31_0 = input.LA(1);

            if ( (LA31_0==31) ) {
                alt31=1;
            }
            } finally {dbg.exitDecision(31);}

            switch (alt31) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:146:28: ':' actor_inst ( ',' actor_inst )*
                    {
                    dbg.location(146,28);
                    match(input,31,FOLLOW_31_in_actor798); if (state.failed) return retval;
                    dbg.location(146,32);
                    pushFollow(FOLLOW_actor_inst_in_actor800);
                    actor_inst();

                    state._fsp--;
                    if (state.failed) return retval;
                    dbg.location(146,42);
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:146:42: ( ',' actor_inst )*
                    try { dbg.enterSubRule(30);

                    loop30:
                    do {
                        int alt30=2;
                        try { dbg.enterDecision(30, decisionCanBacktrack[30]);

                        int LA30_0 = input.LA(1);

                        if ( (LA30_0==28) ) {
                            alt30=1;
                        }


                        } finally {dbg.exitDecision(30);}

                        switch (alt30) {
                    	case 1 :
                    	    dbg.enterAlt(1);

                    	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:146:43: ',' actor_inst
                    	    {
                    	    dbg.location(146,43);
                    	    match(input,28,FOLLOW_28_in_actor802); if (state.failed) return retval;
                    	    dbg.location(146,46);
                    	    pushFollow(FOLLOW_actor_inst_in_actor803);
                    	    actor_inst();

                    	    state._fsp--;
                    	    if (state.failed) return retval;

                    	    }
                    	    break;

                    	default :
                    	    break loop30;
                        }
                    } while (true);
                    } finally {dbg.exitSubRule(30);}


                    }
                    break;

            }
            } finally {dbg.exitSubRule(31);}

            dbg.location(146,60);
            match(input,75,FOLLOW_75_in_actor808); if (state.failed) return retval;
            dbg.location(146,64);
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:146:64: ( actor_body )
            dbg.enterAlt(1);

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:146:65: actor_body
            {
            dbg.location(146,65);
            pushFollow(FOLLOW_actor_body_in_actor811);
            actor_body();

            state._fsp--;
            if (state.failed) return retval;

            }

            dbg.location(146,77);
            match(input,77,FOLLOW_77_in_actor814); if (state.failed) return retval;

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
        dbg.location(148, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "actor");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
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
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:150:1: actor_inst : ID '(' STRING_LITERAL ')' ;
    public final Systemc_basicParser.actor_inst_return actor_inst() throws RecognitionException {
        Systemc_basicParser.actor_inst_return retval = new Systemc_basicParser.actor_inst_return();
        retval.start = input.LT(1);


        Token ID9=null;

        try { dbg.enterRule(getGrammarFileName(), "actor_inst");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(150, 0);

        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:151:2: ( ID '(' STRING_LITERAL ')' )
            dbg.enterAlt(1);

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:151:3: ID '(' STRING_LITERAL ')'
            {
            dbg.location(151,3);
            ID9=(Token)match(input,ID,FOLLOW_ID_in_actor_inst825); if (state.failed) return retval;
            dbg.location(151,5);
            match(input,25,FOLLOW_25_in_actor_inst826); if (state.failed) return retval;
            dbg.location(151,8);
            match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_actor_inst827); if (state.failed) return retval;
            dbg.location(151,22);
            match(input,26,FOLLOW_26_in_actor_inst828); if (state.failed) return retval;
            dbg.location(151,27);
            if ( state.backtracking==0 ) {	
            			((module_decl_scope)module_decl_stack.peek()).mod_type.put((ID9!=null?ID9.getText():null), ((cfile_scope)cfile_stack.peek()).type_obj.get((ID9!=null?ID9.getText():null)));
            			  ((module_decl_scope)module_decl_stack.peek()).obj_type.remove(((cfile_scope)cfile_stack.peek()).type_obj.get((ID9!=null?ID9.getText():null)));
            			 ((cfile_scope)cfile_stack.peek()).type_obj.remove((ID9!=null?ID9.getText():null));
            			
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
        dbg.location(157, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "actor_inst");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
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
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:159:1: connection : component= ID '.' link ;
    public final Systemc_basicParser.connection_return connection() throws RecognitionException {
        Systemc_basicParser.connection_return retval = new Systemc_basicParser.connection_return();
        retval.start = input.LT(1);


        Token component=null;
        Systemc_basicParser.link_return link10 =null;


        try { dbg.enterRule(getGrammarFileName(), "connection");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(159, 0);

        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:159:12: (component= ID '.' link )
            dbg.enterAlt(1);

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:159:14: component= ID '.' link
            {
            dbg.location(159,23);
            component=(Token)match(input,ID,FOLLOW_ID_in_connection843); if (state.failed) return retval;
            dbg.location(159,26);
            match(input,29,FOLLOW_29_in_connection844); if (state.failed) return retval;
            dbg.location(159,29);
            pushFollow(FOLLOW_link_in_connection845);
            link10=link();

            state._fsp--;
            if (state.failed) return retval;
            dbg.location(159,34);
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
        dbg.location(164, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "connection");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
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
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:166:1: link : port= ID '(' signal= ID ')' -> link(source=$port.textdest=$signal.text);
    public final Systemc_basicParser.link_return link() throws RecognitionException {
        Systemc_basicParser.link_return retval = new Systemc_basicParser.link_return();
        retval.start = input.LT(1);


        Token port=null;
        Token signal=null;

        try { dbg.enterRule(getGrammarFileName(), "link");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(166, 0);

        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:166:6: (port= ID '(' signal= ID ')' -> link(source=$port.textdest=$signal.text))
            dbg.enterAlt(1);

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:166:7: port= ID '(' signal= ID ')'
            {
            dbg.location(166,11);
            port=(Token)match(input,ID,FOLLOW_ID_in_link858); if (state.failed) return retval;
            dbg.location(166,14);
            match(input,25,FOLLOW_25_in_link859); if (state.failed) return retval;
            dbg.location(166,23);
            signal=(Token)match(input,ID,FOLLOW_ID_in_link862); if (state.failed) return retval;
            dbg.location(166,26);
            match(input,26,FOLLOW_26_in_link863); if (state.failed) return retval;

            // TEMPLATE REWRITE
            if ( state.backtracking==0 ) {
              // 166:30: -> link(source=$port.textdest=$signal.text)
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
        dbg.location(167, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "link");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
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
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:169:1: sensitive : 'sensitive' '<<' ID ( '.' method )* ;
    public final Systemc_basicParser.sensitive_return sensitive() throws RecognitionException {
        Systemc_basicParser.sensitive_return retval = new Systemc_basicParser.sensitive_return();
        retval.start = input.LT(1);


        Token ID11=null;

        try { dbg.enterRule(getGrammarFileName(), "sensitive");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(169, 0);

        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:170:2: ( 'sensitive' '<<' ID ( '.' method )* )
            dbg.enterAlt(1);

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:170:4: 'sensitive' '<<' ID ( '.' method )*
            {
            dbg.location(170,4);
            match(input,69,FOLLOW_69_in_sensitive893); if (state.failed) return retval;
            dbg.location(170,16);
            match(input,33,FOLLOW_33_in_sensitive895); if (state.failed) return retval;
            dbg.location(170,21);
            ID11=(Token)match(input,ID,FOLLOW_ID_in_sensitive897); if (state.failed) return retval;
            dbg.location(170,24);
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:170:24: ( '.' method )*
            try { dbg.enterSubRule(32);

            loop32:
            do {
                int alt32=2;
                try { dbg.enterDecision(32, decisionCanBacktrack[32]);

                int LA32_0 = input.LA(1);

                if ( (LA32_0==29) ) {
                    alt32=1;
                }


                } finally {dbg.exitDecision(32);}

                switch (alt32) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:170:25: '.' method
            	    {
            	    dbg.location(170,25);
            	    match(input,29,FOLLOW_29_in_sensitive900); if (state.failed) return retval;
            	    dbg.location(170,28);
            	    pushFollow(FOLLOW_method_in_sensitive901);
            	    method();

            	    state._fsp--;
            	    if (state.failed) return retval;

            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);
            } finally {dbg.exitSubRule(32);}

            dbg.location(170,37);
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
        dbg.location(171, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "sensitive");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
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
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:173:1: method : ID '(' ( func_arg ( ',' arg= func_arg )* )? ')' -> method(name=$ID.textargs=$slist::stack);
    public final Systemc_basicParser.method_return method() throws RecognitionException {
        slist_stack.push(new slist_scope());

        Systemc_basicParser.method_return retval = new Systemc_basicParser.method_return();
        retval.start = input.LT(1);


        Token ID12=null;
        Systemc_basicParser.func_arg_return arg =null;



          ((slist_scope)slist_stack.peek()).stack = new ArrayList();

        try { dbg.enterRule(getGrammarFileName(), "method");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(173, 0);

        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:178:2: ( ID '(' ( func_arg ( ',' arg= func_arg )* )? ')' -> method(name=$ID.textargs=$slist::stack))
            dbg.enterAlt(1);

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:179:2: ID '(' ( func_arg ( ',' arg= func_arg )* )? ')'
            {
            dbg.location(179,2);
            ID12=(Token)match(input,ID,FOLLOW_ID_in_method927); if (state.failed) return retval;
            dbg.location(179,4);
            match(input,25,FOLLOW_25_in_method928); if (state.failed) return retval;
            dbg.location(179,7);
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:179:7: ( func_arg ( ',' arg= func_arg )* )?
            int alt34=2;
            try { dbg.enterSubRule(34);
            try { dbg.enterDecision(34, decisionCanBacktrack[34]);

            int LA34_0 = input.LA(1);

            if ( (LA34_0==BIN||(LA34_0 >= HEX && LA34_0 <= INT)||LA34_0==NOT||LA34_0==STRING_LITERAL||LA34_0==25||LA34_0==45||(LA34_0 >= 53 && LA34_0 <= 54)) ) {
                alt34=1;
            }
            } finally {dbg.exitDecision(34);}

            switch (alt34) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:179:8: func_arg ( ',' arg= func_arg )*
                    {
                    dbg.location(179,8);
                    pushFollow(FOLLOW_func_arg_in_method930);
                    func_arg();

                    state._fsp--;
                    if (state.failed) return retval;
                    dbg.location(179,16);
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:179:16: ( ',' arg= func_arg )*
                    try { dbg.enterSubRule(33);

                    loop33:
                    do {
                        int alt33=2;
                        try { dbg.enterDecision(33, decisionCanBacktrack[33]);

                        int LA33_0 = input.LA(1);

                        if ( (LA33_0==28) ) {
                            alt33=1;
                        }


                        } finally {dbg.exitDecision(33);}

                        switch (alt33) {
                    	case 1 :
                    	    dbg.enterAlt(1);

                    	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:179:17: ',' arg= func_arg
                    	    {
                    	    dbg.location(179,17);
                    	    match(input,28,FOLLOW_28_in_method932); if (state.failed) return retval;
                    	    dbg.location(179,23);
                    	    pushFollow(FOLLOW_func_arg_in_method935);
                    	    arg=func_arg();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    dbg.location(179,33);
                    	    if ( state.backtracking==0 ) {((slist_scope)slist_stack.peek()).stack.add((arg!=null?arg.st:null));}

                    	    }
                    	    break;

                    	default :
                    	    break loop33;
                        }
                    } while (true);
                    } finally {dbg.exitSubRule(33);}


                    }
                    break;

            }
            } finally {dbg.exitSubRule(34);}

            dbg.location(179,66);
            match(input,26,FOLLOW_26_in_method942); if (state.failed) return retval;

            // TEMPLATE REWRITE
            if ( state.backtracking==0 ) {
              // 179:70: -> method(name=$ID.textargs=$slist::stack)
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
        dbg.location(180, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "method");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
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
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:182:1: func_arg : ( value ) ;
    public final Systemc_basicParser.func_arg_return func_arg() throws RecognitionException {
        Systemc_basicParser.func_arg_return retval = new Systemc_basicParser.func_arg_return();
        retval.start = input.LT(1);


        Systemc_basicParser.value_return value13 =null;


        try { dbg.enterRule(getGrammarFileName(), "func_arg");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(182, 0);

        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:182:10: ( ( value ) )
            dbg.enterAlt(1);

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:182:11: ( value )
            {
            dbg.location(182,11);
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:182:11: ( value )
            dbg.enterAlt(1);

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:182:12: value
            {
            dbg.location(182,12);
            pushFollow(FOLLOW_value_in_func_arg968);
            value13=value();

            state._fsp--;
            if (state.failed) return retval;
            dbg.location(182,18);
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
        dbg.location(183, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "func_arg");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
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
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:184:1: actor_method returns [String name] : actor_method_decl SEMICOLON ( sensitive SEMICOLON )+ -> process(sensitive=$slist::namesname=$actor_method_decl.name);
    public final Systemc_basicParser.actor_method_return actor_method() throws RecognitionException {
        slist_stack.push(new slist_scope());

        Systemc_basicParser.actor_method_return retval = new Systemc_basicParser.actor_method_return();
        retval.start = input.LT(1);


        Systemc_basicParser.actor_method_decl_return actor_method_decl14 =null;



          ((slist_scope)slist_stack.peek()).names = new ArrayList();
          retval.name = new String();

        try { dbg.enterRule(getGrammarFileName(), "actor_method");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(184, 0);

        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:190:2: ( actor_method_decl SEMICOLON ( sensitive SEMICOLON )+ -> process(sensitive=$slist::namesname=$actor_method_decl.name))
            dbg.enterAlt(1);

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:191:2: actor_method_decl SEMICOLON ( sensitive SEMICOLON )+
            {
            dbg.location(191,2);
            pushFollow(FOLLOW_actor_method_decl_in_actor_method997);
            actor_method_decl14=actor_method_decl();

            state._fsp--;
            if (state.failed) return retval;
            dbg.location(191,20);
            match(input,SEMICOLON,FOLLOW_SEMICOLON_in_actor_method999); if (state.failed) return retval;
            dbg.location(191,29);
            if ( state.backtracking==0 ) {retval.name = (actor_method_decl14!=null?actor_method_decl14.name:null) ;}
            dbg.location(192,2);
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:192:2: ( sensitive SEMICOLON )+
            int cnt35=0;
            try { dbg.enterSubRule(35);

            loop35:
            do {
                int alt35=2;
                try { dbg.enterDecision(35, decisionCanBacktrack[35]);

                int LA35_0 = input.LA(1);

                if ( (LA35_0==69) ) {
                    alt35=1;
                }


                } finally {dbg.exitDecision(35);}

                switch (alt35) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:192:3: sensitive SEMICOLON
            	    {
            	    dbg.location(192,3);
            	    pushFollow(FOLLOW_sensitive_in_actor_method1004);
            	    sensitive();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    dbg.location(192,13);
            	    match(input,SEMICOLON,FOLLOW_SEMICOLON_in_actor_method1006); if (state.failed) return retval;

            	    }
            	    break;

            	default :
            	    if ( cnt35 >= 1 ) break loop35;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(35, input);
                        dbg.recognitionException(eee);

                        throw eee;
                }
                cnt35++;
            } while (true);
            } finally {dbg.exitSubRule(35);}


            // TEMPLATE REWRITE
            if ( state.backtracking==0 ) {
              // 192:25: -> process(sensitive=$slist::namesname=$actor_method_decl.name)
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
        dbg.location(193, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "actor_method");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
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
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:195:1: actor_method_decl returns [String name] : 'SC_METHOD(' n= ID ')' ;
    public final Systemc_basicParser.actor_method_decl_return actor_method_decl() throws RecognitionException {
        Systemc_basicParser.actor_method_decl_return retval = new Systemc_basicParser.actor_method_decl_return();
        retval.start = input.LT(1);


        Token n=null;

        try { dbg.enterRule(getGrammarFileName(), "actor_method_decl");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(195, 0);

        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:196:2: ( 'SC_METHOD(' n= ID ')' )
            dbg.enterAlt(1);

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:197:2: 'SC_METHOD(' n= ID ')'
            {
            dbg.location(197,2);
            match(input,35,FOLLOW_35_in_actor_method_decl1041); if (state.failed) return retval;
            dbg.location(197,16);
            n=(Token)match(input,ID,FOLLOW_ID_in_actor_method_decl1046); if (state.failed) return retval;
            dbg.location(197,20);
            match(input,26,FOLLOW_26_in_actor_method_decl1047); if (state.failed) return retval;
            dbg.location(197,24);
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
        dbg.location(198, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "actor_method_decl");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
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
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:200:1: actor_body : ( actor_body_elt )+ ;
    public final Systemc_basicParser.actor_body_return actor_body() throws RecognitionException {
        Systemc_basicParser.actor_body_return retval = new Systemc_basicParser.actor_body_return();
        retval.start = input.LT(1);


        try { dbg.enterRule(getGrammarFileName(), "actor_body");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(200, 0);

        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:200:12: ( ( actor_body_elt )+ )
            dbg.enterAlt(1);

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:200:14: ( actor_body_elt )+
            {
            dbg.location(200,14);
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:200:14: ( actor_body_elt )+
            int cnt36=0;
            try { dbg.enterSubRule(36);

            loop36:
            do {
                int alt36=2;
                try { dbg.enterDecision(36, decisionCanBacktrack[36]);

                int LA36_0 = input.LA(1);

                if ( (LA36_0==ID||LA36_0==35) ) {
                    alt36=1;
                }


                } finally {dbg.exitDecision(36);}

                switch (alt36) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:200:15: actor_body_elt
            	    {
            	    dbg.location(200,15);
            	    pushFollow(FOLLOW_actor_body_elt_in_actor_body1060);
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
                        dbg.recognitionException(eee);

                        throw eee;
                }
                cnt36++;
            } while (true);
            } finally {dbg.exitSubRule(36);}


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
        dbg.location(201, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "actor_body");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
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
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:204:1: actor_body_elt : (meth= actor_method | ( func_call SEMICOLON ) | ( connection SEMICOLON ) ) ;
    public final Systemc_basicParser.actor_body_elt_return actor_body_elt() throws RecognitionException {
        Systemc_basicParser.actor_body_elt_return retval = new Systemc_basicParser.actor_body_elt_return();
        retval.start = input.LT(1);


        Systemc_basicParser.actor_method_return meth =null;


        try { dbg.enterRule(getGrammarFileName(), "actor_body_elt");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(204, 0);

        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:205:2: ( (meth= actor_method | ( func_call SEMICOLON ) | ( connection SEMICOLON ) ) )
            dbg.enterAlt(1);

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:206:2: (meth= actor_method | ( func_call SEMICOLON ) | ( connection SEMICOLON ) )
            {
            dbg.location(206,2);
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:206:2: (meth= actor_method | ( func_call SEMICOLON ) | ( connection SEMICOLON ) )
            int alt37=3;
            try { dbg.enterSubRule(37);
            try { dbg.enterDecision(37, decisionCanBacktrack[37]);

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

                    dbg.recognitionException(nvae);
                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;

            }
            } finally {dbg.exitDecision(37);}

            switch (alt37) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:206:3: meth= actor_method
                    {
                    dbg.location(206,7);
                    pushFollow(FOLLOW_actor_method_in_actor_body_elt1079);
                    meth=actor_method();

                    state._fsp--;
                    if (state.failed) return retval;
                    dbg.location(206,21);
                    if ( state.backtracking==0 ) {((module_decl_scope)module_decl_stack.peek()).processes.put((meth!=null?meth.name:null), (meth!=null?meth.st:null));}

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:207:4: ( func_call SEMICOLON )
                    {
                    dbg.location(207,4);
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:207:4: ( func_call SEMICOLON )
                    dbg.enterAlt(1);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:207:5: func_call SEMICOLON
                    {
                    dbg.location(207,5);
                    pushFollow(FOLLOW_func_call_in_actor_body_elt1087);
                    func_call();

                    state._fsp--;
                    if (state.failed) return retval;
                    dbg.location(207,15);
                    match(input,SEMICOLON,FOLLOW_SEMICOLON_in_actor_body_elt1089); if (state.failed) return retval;

                    }


                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:208:3: ( connection SEMICOLON )
                    {
                    dbg.location(208,3);
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:208:3: ( connection SEMICOLON )
                    dbg.enterAlt(1);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:208:4: connection SEMICOLON
                    {
                    dbg.location(208,4);
                    pushFollow(FOLLOW_connection_in_actor_body_elt1095);
                    connection();

                    state._fsp--;
                    if (state.failed) return retval;
                    dbg.location(208,15);
                    match(input,SEMICOLON,FOLLOW_SEMICOLON_in_actor_body_elt1097); if (state.failed) return retval;

                    }


                    }
                    break;

            }
            } finally {dbg.exitSubRule(37);}


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
        dbg.location(209, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "actor_body_elt");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
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
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:211:1: signal_dec : ( ( sc_signal ) name ( ',' name )* ( fixed_size_array )* ) -> signal(name=$slist::namestype=$sc_signal.st);
    public final Systemc_basicParser.signal_dec_return signal_dec() throws RecognitionException {
        slist_stack.push(new slist_scope());

        Systemc_basicParser.signal_dec_return retval = new Systemc_basicParser.signal_dec_return();
        retval.start = input.LT(1);


        Systemc_basicParser.sc_signal_return sc_signal15 =null;



          ((slist_scope)slist_stack.peek()).names = new ArrayList();

        try { dbg.enterRule(getGrammarFileName(), "signal_dec");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(211, 0);

        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:215:2: ( ( ( sc_signal ) name ( ',' name )* ( fixed_size_array )* ) -> signal(name=$slist::namestype=$sc_signal.st))
            dbg.enterAlt(1);

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:216:2: ( ( sc_signal ) name ( ',' name )* ( fixed_size_array )* )
            {
            dbg.location(216,2);
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:216:2: ( ( sc_signal ) name ( ',' name )* ( fixed_size_array )* )
            dbg.enterAlt(1);

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:216:3: ( sc_signal ) name ( ',' name )* ( fixed_size_array )*
            {
            dbg.location(216,3);
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:216:3: ( sc_signal )
            dbg.enterAlt(1);

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:216:4: sc_signal
            {
            dbg.location(216,4);
            pushFollow(FOLLOW_sc_signal_in_signal_dec1122);
            sc_signal15=sc_signal();

            state._fsp--;
            if (state.failed) return retval;

            }

            dbg.location(216,15);
            pushFollow(FOLLOW_name_in_signal_dec1125);
            name();

            state._fsp--;
            if (state.failed) return retval;
            dbg.location(216,20);
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:216:20: ( ',' name )*
            try { dbg.enterSubRule(38);

            loop38:
            do {
                int alt38=2;
                try { dbg.enterDecision(38, decisionCanBacktrack[38]);

                int LA38_0 = input.LA(1);

                if ( (LA38_0==28) ) {
                    alt38=1;
                }


                } finally {dbg.exitDecision(38);}

                switch (alt38) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:216:21: ',' name
            	    {
            	    dbg.location(216,21);
            	    match(input,28,FOLLOW_28_in_signal_dec1128); if (state.failed) return retval;
            	    dbg.location(216,24);
            	    pushFollow(FOLLOW_name_in_signal_dec1129);
            	    name();

            	    state._fsp--;
            	    if (state.failed) return retval;

            	    }
            	    break;

            	default :
            	    break loop38;
                }
            } while (true);
            } finally {dbg.exitSubRule(38);}

            dbg.location(216,32);
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:216:32: ( fixed_size_array )*
            try { dbg.enterSubRule(39);

            loop39:
            do {
                int alt39=2;
                try { dbg.enterDecision(39, decisionCanBacktrack[39]);

                int LA39_0 = input.LA(1);

                if ( (LA39_0==37) ) {
                    alt39=1;
                }


                } finally {dbg.exitDecision(39);}

                switch (alt39) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:216:32: fixed_size_array
            	    {
            	    dbg.location(216,32);
            	    pushFollow(FOLLOW_fixed_size_array_in_signal_dec1134);
            	    fixed_size_array();

            	    state._fsp--;
            	    if (state.failed) return retval;

            	    }
            	    break;

            	default :
            	    break loop39;
                }
            } while (true);
            } finally {dbg.exitSubRule(39);}


            }


            // TEMPLATE REWRITE
            if ( state.backtracking==0 ) {
              // 216:52: -> signal(name=$slist::namestype=$sc_signal.st)
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
        dbg.location(217, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "signal_dec");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
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
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:221:1: sc_signal : ( 'sc_signal' ( '_rv' )? '<' signal_type '>' ) -> dummy(val=$signal_type.st);
    public final Systemc_basicParser.sc_signal_return sc_signal() throws RecognitionException {
        Systemc_basicParser.sc_signal_return retval = new Systemc_basicParser.sc_signal_return();
        retval.start = input.LT(1);


        Systemc_basicParser.signal_type_return signal_type16 =null;


        try { dbg.enterRule(getGrammarFileName(), "sc_signal");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(221, 0);

        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:221:11: ( ( 'sc_signal' ( '_rv' )? '<' signal_type '>' ) -> dummy(val=$signal_type.st))
            dbg.enterAlt(1);

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:222:2: ( 'sc_signal' ( '_rv' )? '<' signal_type '>' )
            {
            dbg.location(222,2);
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:222:2: ( 'sc_signal' ( '_rv' )? '<' signal_type '>' )
            dbg.enterAlt(1);

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:222:3: 'sc_signal' ( '_rv' )? '<' signal_type '>'
            {
            dbg.location(222,3);
            match(input,67,FOLLOW_67_in_sc_signal1168); if (state.failed) return retval;
            dbg.location(222,14);
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:222:14: ( '_rv' )?
            int alt40=2;
            try { dbg.enterSubRule(40);
            try { dbg.enterDecision(40, decisionCanBacktrack[40]);

            int LA40_0 = input.LA(1);

            if ( (LA40_0==40) ) {
                alt40=1;
            }
            } finally {dbg.exitDecision(40);}

            switch (alt40) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:222:15: '_rv'
                    {
                    dbg.location(222,15);
                    match(input,40,FOLLOW_40_in_sc_signal1170); if (state.failed) return retval;

                    }
                    break;

            }
            } finally {dbg.exitSubRule(40);}

            dbg.location(222,22);
            match(input,LT,FOLLOW_LT_in_sc_signal1173); if (state.failed) return retval;
            dbg.location(222,27);
            pushFollow(FOLLOW_signal_type_in_sc_signal1176);
            signal_type16=signal_type();

            state._fsp--;
            if (state.failed) return retval;
            dbg.location(222,40);
            match(input,GT,FOLLOW_GT_in_sc_signal1179); if (state.failed) return retval;

            }


            // TEMPLATE REWRITE
            if ( state.backtracking==0 ) {
              // 222:46: -> dummy(val=$signal_type.st)
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
        dbg.location(223, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "sc_signal");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
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
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:225:1: signal_type : ( sc_type -> { $sc_type.st}| ID -> dummy(val=$ID.text));
    public final Systemc_basicParser.signal_type_return signal_type() throws RecognitionException {
        Systemc_basicParser.signal_type_return retval = new Systemc_basicParser.signal_type_return();
        retval.start = input.LT(1);


        Token ID18=null;
        Systemc_basicParser.sc_type_return sc_type17 =null;


        try { dbg.enterRule(getGrammarFileName(), "signal_type");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(225, 0);

        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:225:13: ( sc_type -> { $sc_type.st}| ID -> dummy(val=$ID.text))
            int alt41=2;
            try { dbg.enterDecision(41, decisionCanBacktrack[41]);

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

                dbg.recognitionException(nvae);
                throw nvae;

            }
            } finally {dbg.exitDecision(41);}

            switch (alt41) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:226:3: sc_type
                    {
                    dbg.location(226,3);
                    pushFollow(FOLLOW_sc_type_in_signal_type1201);
                    sc_type17=sc_type();

                    state._fsp--;
                    if (state.failed) return retval;

                    // TEMPLATE REWRITE
                    if ( state.backtracking==0 ) {
                      // 226:11: -> { $sc_type.st}
                      {
                          retval.st =  (sc_type17!=null?sc_type17.st:null);
                      }


                    }

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:227:5: ID
                    {
                    dbg.location(227,5);
                    ID18=(Token)match(input,ID,FOLLOW_ID_in_signal_type1210); if (state.failed) return retval;

                    // TEMPLATE REWRITE
                    if ( state.backtracking==0 ) {
                      // 227:8: -> dummy(val=$ID.text)
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
        dbg.location(228, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "signal_type");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
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
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:230:1: func_call : ( ID ) '(' ( func_arg ( ',' func_arg )* )? ')' -> func_call(name=$ID.textargs=$slist::stack);
    public final Systemc_basicParser.func_call_return func_call() throws RecognitionException {
        slist_stack.push(new slist_scope());

        Systemc_basicParser.func_call_return retval = new Systemc_basicParser.func_call_return();
        retval.start = input.LT(1);


        Token ID19=null;


          ((slist_scope)slist_stack.peek()).stack = new ArrayList();

        try { dbg.enterRule(getGrammarFileName(), "func_call");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(230, 0);

        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:235:2: ( ( ID ) '(' ( func_arg ( ',' func_arg )* )? ')' -> func_call(name=$ID.textargs=$slist::stack))
            dbg.enterAlt(1);

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:236:2: ( ID ) '(' ( func_arg ( ',' func_arg )* )? ')'
            {
            dbg.location(236,2);
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:236:2: ( ID )
            dbg.enterAlt(1);

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:236:3: ID
            {
            dbg.location(236,3);
            ID19=(Token)match(input,ID,FOLLOW_ID_in_func_call1243); if (state.failed) return retval;

            }

            dbg.location(236,7);
            match(input,25,FOLLOW_25_in_func_call1246); if (state.failed) return retval;
            dbg.location(236,10);
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:236:10: ( func_arg ( ',' func_arg )* )?
            int alt43=2;
            try { dbg.enterSubRule(43);
            try { dbg.enterDecision(43, decisionCanBacktrack[43]);

            int LA43_0 = input.LA(1);

            if ( (LA43_0==BIN||(LA43_0 >= HEX && LA43_0 <= INT)||LA43_0==NOT||LA43_0==STRING_LITERAL||LA43_0==25||LA43_0==45||(LA43_0 >= 53 && LA43_0 <= 54)) ) {
                alt43=1;
            }
            } finally {dbg.exitDecision(43);}

            switch (alt43) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:236:11: func_arg ( ',' func_arg )*
                    {
                    dbg.location(236,11);
                    pushFollow(FOLLOW_func_arg_in_func_call1248);
                    func_arg();

                    state._fsp--;
                    if (state.failed) return retval;
                    dbg.location(236,20);
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:236:20: ( ',' func_arg )*
                    try { dbg.enterSubRule(42);

                    loop42:
                    do {
                        int alt42=2;
                        try { dbg.enterDecision(42, decisionCanBacktrack[42]);

                        int LA42_0 = input.LA(1);

                        if ( (LA42_0==28) ) {
                            alt42=1;
                        }


                        } finally {dbg.exitDecision(42);}

                        switch (alt42) {
                    	case 1 :
                    	    dbg.enterAlt(1);

                    	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:236:21: ',' func_arg
                    	    {
                    	    dbg.location(236,21);
                    	    match(input,28,FOLLOW_28_in_func_call1251); if (state.failed) return retval;
                    	    dbg.location(236,25);
                    	    pushFollow(FOLLOW_func_arg_in_func_call1253);
                    	    func_arg();

                    	    state._fsp--;
                    	    if (state.failed) return retval;

                    	    }
                    	    break;

                    	default :
                    	    break loop42;
                        }
                    } while (true);
                    } finally {dbg.exitSubRule(42);}


                    }
                    break;

            }
            } finally {dbg.exitSubRule(43);}

            dbg.location(236,37);
            match(input,26,FOLLOW_26_in_func_call1258); if (state.failed) return retval;

            // TEMPLATE REWRITE
            if ( state.backtracking==0 ) {
              // 236:41: -> func_call(name=$ID.textargs=$slist::stack)
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
        dbg.location(237, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "func_call");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
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
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:239:1: port_decl : port_type name ( ',' name )* -> port(name=$slist::namestype=$port_type.st);
    public final Systemc_basicParser.port_decl_return port_decl() throws RecognitionException {
        slist_stack.push(new slist_scope());

        Systemc_basicParser.port_decl_return retval = new Systemc_basicParser.port_decl_return();
        retval.start = input.LT(1);


        Systemc_basicParser.port_type_return port_type20 =null;



          ((slist_scope)slist_stack.peek()).names = new ArrayList();

        try { dbg.enterRule(getGrammarFileName(), "port_decl");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(239, 0);

        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:243:2: ( port_type name ( ',' name )* -> port(name=$slist::namestype=$port_type.st))
            dbg.enterAlt(1);

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:244:2: port_type name ( ',' name )*
            {
            dbg.location(244,2);
            pushFollow(FOLLOW_port_type_in_port_decl1297);
            port_type20=port_type();

            state._fsp--;
            if (state.failed) return retval;
            dbg.location(244,12);
            pushFollow(FOLLOW_name_in_port_decl1299);
            name();

            state._fsp--;
            if (state.failed) return retval;
            dbg.location(244,17);
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:244:17: ( ',' name )*
            try { dbg.enterSubRule(44);

            loop44:
            do {
                int alt44=2;
                try { dbg.enterDecision(44, decisionCanBacktrack[44]);

                int LA44_0 = input.LA(1);

                if ( (LA44_0==28) ) {
                    alt44=1;
                }


                } finally {dbg.exitDecision(44);}

                switch (alt44) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:244:18: ',' name
            	    {
            	    dbg.location(244,18);
            	    match(input,28,FOLLOW_28_in_port_decl1302); if (state.failed) return retval;
            	    dbg.location(244,22);
            	    pushFollow(FOLLOW_name_in_port_decl1304);
            	    name();

            	    state._fsp--;
            	    if (state.failed) return retval;

            	    }
            	    break;

            	default :
            	    break loop44;
                }
            } while (true);
            } finally {dbg.exitSubRule(44);}


            // TEMPLATE REWRITE
            if ( state.backtracking==0 ) {
              // 244:30: -> port(name=$slist::namestype=$port_type.st)
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
        dbg.location(245, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "port_decl");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
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
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:248:1: name : ID ;
    public final Systemc_basicParser.name_return name() throws RecognitionException {
        Systemc_basicParser.name_return retval = new Systemc_basicParser.name_return();
        retval.start = input.LT(1);


        Token ID21=null;

        try { dbg.enterRule(getGrammarFileName(), "name");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(248, 0);

        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:249:2: ( ID )
            dbg.enterAlt(1);

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:250:2: ID
            {
            dbg.location(250,2);
            ID21=(Token)match(input,ID,FOLLOW_ID_in_name1336); if (state.failed) return retval;
            dbg.location(250,5);
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
        dbg.location(251, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "name");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
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
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:253:1: port_type : ( sc_clock -> clock_type(| sc_in -> input_type(type=$sc_in.st)| sc_out -> output_type(type=$sc_out.st)| sc_inout -> inout_type(type=$sc_inout.st));
    public final Systemc_basicParser.port_type_return port_type() throws RecognitionException {
        Systemc_basicParser.port_type_return retval = new Systemc_basicParser.port_type_return();
        retval.start = input.LT(1);


        Systemc_basicParser.sc_in_return sc_in22 =null;

        Systemc_basicParser.sc_out_return sc_out23 =null;

        Systemc_basicParser.sc_inout_return sc_inout24 =null;


        try { dbg.enterRule(getGrammarFileName(), "port_type");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(253, 0);

        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:253:11: ( sc_clock -> clock_type(| sc_in -> input_type(type=$sc_in.st)| sc_out -> output_type(type=$sc_out.st)| sc_inout -> inout_type(type=$sc_inout.st))
            int alt45=4;
            try { dbg.enterDecision(45, decisionCanBacktrack[45]);

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

                dbg.recognitionException(nvae);
                throw nvae;

            }

            } finally {dbg.exitDecision(45);}

            switch (alt45) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:254:3: sc_clock
                    {
                    dbg.location(254,3);
                    pushFollow(FOLLOW_sc_clock_in_port_type1350);
                    sc_clock();

                    state._fsp--;
                    if (state.failed) return retval;

                    // TEMPLATE REWRITE
                    if ( state.backtracking==0 ) {
                      // 254:12: -> clock_type(
                      {
                          retval.st = templateLib.getInstanceOf("clock_type");
                      }


                    }

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:255:3: sc_in
                    {
                    dbg.location(255,3);
                    pushFollow(FOLLOW_sc_in_in_port_type1360);
                    sc_in22=sc_in();

                    state._fsp--;
                    if (state.failed) return retval;

                    // TEMPLATE REWRITE
                    if ( state.backtracking==0 ) {
                      // 255:9: -> input_type(type=$sc_in.st)
                      {
                          retval.st = templateLib.getInstanceOf("input_type",new STAttrMap().put("type", (sc_in22!=null?sc_in22.st:null)));
                      }


                    }

                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:256:3: sc_out
                    {
                    dbg.location(256,3);
                    pushFollow(FOLLOW_sc_out_in_port_type1373);
                    sc_out23=sc_out();

                    state._fsp--;
                    if (state.failed) return retval;

                    // TEMPLATE REWRITE
                    if ( state.backtracking==0 ) {
                      // 256:10: -> output_type(type=$sc_out.st)
                      {
                          retval.st = templateLib.getInstanceOf("output_type",new STAttrMap().put("type", (sc_out23!=null?sc_out23.st:null)));
                      }


                    }

                    }
                    break;
                case 4 :
                    dbg.enterAlt(4);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:257:3: sc_inout
                    {
                    dbg.location(257,3);
                    pushFollow(FOLLOW_sc_inout_in_port_type1386);
                    sc_inout24=sc_inout();

                    state._fsp--;
                    if (state.failed) return retval;

                    // TEMPLATE REWRITE
                    if ( state.backtracking==0 ) {
                      // 257:12: -> inout_type(type=$sc_inout.st)
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
        dbg.location(258, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "port_type");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
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
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:261:1: sc_inout : ( 'sc_inout' ( LT ( sc_type ) GT ) -> dummy(val=$sc_type.st)| 'sc_inout_resolved' -> logic(| 'sc_inout_rv' ( LT ( INT ) GT ) -> logic_vector(size=$INT.text));
    public final Systemc_basicParser.sc_inout_return sc_inout() throws RecognitionException {
        Systemc_basicParser.sc_inout_return retval = new Systemc_basicParser.sc_inout_return();
        retval.start = input.LT(1);


        Token INT26=null;
        Systemc_basicParser.sc_type_return sc_type25 =null;


        try { dbg.enterRule(getGrammarFileName(), "sc_inout");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(261, 0);

        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:261:10: ( 'sc_inout' ( LT ( sc_type ) GT ) -> dummy(val=$sc_type.st)| 'sc_inout_resolved' -> logic(| 'sc_inout_rv' ( LT ( INT ) GT ) -> logic_vector(size=$INT.text))
            int alt46=3;
            try { dbg.enterDecision(46, decisionCanBacktrack[46]);

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

                dbg.recognitionException(nvae);
                throw nvae;

            }

            } finally {dbg.exitDecision(46);}

            switch (alt46) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:262:2: 'sc_inout' ( LT ( sc_type ) GT )
                    {
                    dbg.location(262,2);
                    match(input,59,FOLLOW_59_in_sc_inout1407); if (state.failed) return retval;
                    dbg.location(262,12);
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:262:12: ( LT ( sc_type ) GT )
                    dbg.enterAlt(1);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:262:13: LT ( sc_type ) GT
                    {
                    dbg.location(262,13);
                    match(input,LT,FOLLOW_LT_in_sc_inout1409); if (state.failed) return retval;
                    dbg.location(262,16);
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:262:16: ( sc_type )
                    dbg.enterAlt(1);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:262:17: sc_type
                    {
                    dbg.location(262,17);
                    pushFollow(FOLLOW_sc_type_in_sc_inout1412);
                    sc_type25=sc_type();

                    state._fsp--;
                    if (state.failed) return retval;

                    }

                    dbg.location(262,26);
                    match(input,GT,FOLLOW_GT_in_sc_inout1415); if (state.failed) return retval;

                    }


                    // TEMPLATE REWRITE
                    if ( state.backtracking==0 ) {
                      // 262:31: -> dummy(val=$sc_type.st)
                      {
                          retval.st = templateLib.getInstanceOf("dummy",new STAttrMap().put("val", (sc_type25!=null?sc_type25.st:null)));
                      }


                    }

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:263:4: 'sc_inout_resolved'
                    {
                    dbg.location(263,4);
                    match(input,60,FOLLOW_60_in_sc_inout1430); if (state.failed) return retval;

                    // TEMPLATE REWRITE
                    if ( state.backtracking==0 ) {
                      // 263:26: -> logic(
                      {
                          retval.st = templateLib.getInstanceOf("logic");
                      }


                    }

                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:264:4: 'sc_inout_rv' ( LT ( INT ) GT )
                    {
                    dbg.location(264,4);
                    match(input,61,FOLLOW_61_in_sc_inout1443); if (state.failed) return retval;
                    dbg.location(264,17);
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:264:17: ( LT ( INT ) GT )
                    dbg.enterAlt(1);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:264:18: LT ( INT ) GT
                    {
                    dbg.location(264,18);
                    match(input,LT,FOLLOW_LT_in_sc_inout1445); if (state.failed) return retval;
                    dbg.location(264,21);
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:264:21: ( INT )
                    dbg.enterAlt(1);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:264:22: INT
                    {
                    dbg.location(264,22);
                    INT26=(Token)match(input,INT,FOLLOW_INT_in_sc_inout1448); if (state.failed) return retval;

                    }

                    dbg.location(264,27);
                    match(input,GT,FOLLOW_GT_in_sc_inout1451); if (state.failed) return retval;

                    }


                    // TEMPLATE REWRITE
                    if ( state.backtracking==0 ) {
                      // 264:32: -> logic_vector(size=$INT.text)
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
        dbg.location(265, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "sc_inout");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
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
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:268:1: sc_out : ( 'sc_out' ( LT ( sc_type ) GT ) -> dummy(val=$sc_type.st)| 'sc_out_resolved' -> logic(| 'sc_out_rv' ( LT ( INT ) GT ) -> logic_vector(size=$INT.text));
    public final Systemc_basicParser.sc_out_return sc_out() throws RecognitionException {
        Systemc_basicParser.sc_out_return retval = new Systemc_basicParser.sc_out_return();
        retval.start = input.LT(1);


        Token INT28=null;
        Systemc_basicParser.sc_type_return sc_type27 =null;


        try { dbg.enterRule(getGrammarFileName(), "sc_out");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(268, 0);

        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:268:8: ( 'sc_out' ( LT ( sc_type ) GT ) -> dummy(val=$sc_type.st)| 'sc_out_resolved' -> logic(| 'sc_out_rv' ( LT ( INT ) GT ) -> logic_vector(size=$INT.text))
            int alt47=3;
            try { dbg.enterDecision(47, decisionCanBacktrack[47]);

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

                dbg.recognitionException(nvae);
                throw nvae;

            }

            } finally {dbg.exitDecision(47);}

            switch (alt47) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:269:2: 'sc_out' ( LT ( sc_type ) GT )
                    {
                    dbg.location(269,2);
                    match(input,64,FOLLOW_64_in_sc_out1476); if (state.failed) return retval;
                    dbg.location(269,11);
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:269:11: ( LT ( sc_type ) GT )
                    dbg.enterAlt(1);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:269:12: LT ( sc_type ) GT
                    {
                    dbg.location(269,12);
                    match(input,LT,FOLLOW_LT_in_sc_out1479); if (state.failed) return retval;
                    dbg.location(269,15);
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:269:15: ( sc_type )
                    dbg.enterAlt(1);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:269:16: sc_type
                    {
                    dbg.location(269,16);
                    pushFollow(FOLLOW_sc_type_in_sc_out1482);
                    sc_type27=sc_type();

                    state._fsp--;
                    if (state.failed) return retval;

                    }

                    dbg.location(269,26);
                    match(input,GT,FOLLOW_GT_in_sc_out1486); if (state.failed) return retval;

                    }


                    // TEMPLATE REWRITE
                    if ( state.backtracking==0 ) {
                      // 269:30: -> dummy(val=$sc_type.st)
                      {
                          retval.st = templateLib.getInstanceOf("dummy",new STAttrMap().put("val", (sc_type27!=null?sc_type27.st:null)));
                      }


                    }

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:270:4: 'sc_out_resolved'
                    {
                    dbg.location(270,4);
                    match(input,65,FOLLOW_65_in_sc_out1500); if (state.failed) return retval;

                    // TEMPLATE REWRITE
                    if ( state.backtracking==0 ) {
                      // 270:23: -> logic(
                      {
                          retval.st = templateLib.getInstanceOf("logic");
                      }


                    }

                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:271:4: 'sc_out_rv' ( LT ( INT ) GT )
                    {
                    dbg.location(271,4);
                    match(input,66,FOLLOW_66_in_sc_out1513); if (state.failed) return retval;
                    dbg.location(271,15);
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:271:15: ( LT ( INT ) GT )
                    dbg.enterAlt(1);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:271:16: LT ( INT ) GT
                    {
                    dbg.location(271,16);
                    match(input,LT,FOLLOW_LT_in_sc_out1515); if (state.failed) return retval;
                    dbg.location(271,20);
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:271:20: ( INT )
                    dbg.enterAlt(1);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:271:21: INT
                    {
                    dbg.location(271,21);
                    INT28=(Token)match(input,INT,FOLLOW_INT_in_sc_out1519); if (state.failed) return retval;

                    }

                    dbg.location(271,26);
                    match(input,GT,FOLLOW_GT_in_sc_out1522); if (state.failed) return retval;

                    }


                    // TEMPLATE REWRITE
                    if ( state.backtracking==0 ) {
                      // 271:31: -> logic_vector(size=$INT.text)
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
        dbg.location(272, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "sc_out");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
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
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:274:1: sc_in : ( 'sc_in' ( LT ( sc_type ) GT ) -> dummy(val=$sc_type.st)| 'sc_in_resolved' -> logic(| 'sc_in_rv' ( LT ( INT ) GT ) -> logic_vector(size=$INT.text));
    public final Systemc_basicParser.sc_in_return sc_in() throws RecognitionException {
        Systemc_basicParser.sc_in_return retval = new Systemc_basicParser.sc_in_return();
        retval.start = input.LT(1);


        Token INT30=null;
        Systemc_basicParser.sc_type_return sc_type29 =null;


        try { dbg.enterRule(getGrammarFileName(), "sc_in");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(274, 0);

        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:274:7: ( 'sc_in' ( LT ( sc_type ) GT ) -> dummy(val=$sc_type.st)| 'sc_in_resolved' -> logic(| 'sc_in_rv' ( LT ( INT ) GT ) -> logic_vector(size=$INT.text))
            int alt48=3;
            try { dbg.enterDecision(48, decisionCanBacktrack[48]);

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

                dbg.recognitionException(nvae);
                throw nvae;

            }

            } finally {dbg.exitDecision(48);}

            switch (alt48) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:275:2: 'sc_in' ( LT ( sc_type ) GT )
                    {
                    dbg.location(275,2);
                    match(input,55,FOLLOW_55_in_sc_in1544); if (state.failed) return retval;
                    dbg.location(275,9);
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:275:9: ( LT ( sc_type ) GT )
                    dbg.enterAlt(1);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:275:10: LT ( sc_type ) GT
                    {
                    dbg.location(275,10);
                    match(input,LT,FOLLOW_LT_in_sc_in1546); if (state.failed) return retval;
                    dbg.location(275,13);
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:275:13: ( sc_type )
                    dbg.enterAlt(1);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:275:14: sc_type
                    {
                    dbg.location(275,14);
                    pushFollow(FOLLOW_sc_type_in_sc_in1549);
                    sc_type29=sc_type();

                    state._fsp--;
                    if (state.failed) return retval;

                    }

                    dbg.location(275,24);
                    match(input,GT,FOLLOW_GT_in_sc_in1553); if (state.failed) return retval;

                    }


                    // TEMPLATE REWRITE
                    if ( state.backtracking==0 ) {
                      // 275:28: -> dummy(val=$sc_type.st)
                      {
                          retval.st = templateLib.getInstanceOf("dummy",new STAttrMap().put("val", (sc_type29!=null?sc_type29.st:null)));
                      }


                    }

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:276:4: 'sc_in_resolved'
                    {
                    dbg.location(276,4);
                    match(input,57,FOLLOW_57_in_sc_in1567); if (state.failed) return retval;

                    // TEMPLATE REWRITE
                    if ( state.backtracking==0 ) {
                      // 276:22: -> logic(
                      {
                          retval.st = templateLib.getInstanceOf("logic");
                      }


                    }

                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:277:4: 'sc_in_rv' ( LT ( INT ) GT )
                    {
                    dbg.location(277,4);
                    match(input,58,FOLLOW_58_in_sc_in1580); if (state.failed) return retval;
                    dbg.location(277,14);
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:277:14: ( LT ( INT ) GT )
                    dbg.enterAlt(1);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:277:15: LT ( INT ) GT
                    {
                    dbg.location(277,15);
                    match(input,LT,FOLLOW_LT_in_sc_in1582); if (state.failed) return retval;
                    dbg.location(277,18);
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:277:18: ( INT )
                    dbg.enterAlt(1);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:277:20: INT
                    {
                    dbg.location(277,20);
                    INT30=(Token)match(input,INT,FOLLOW_INT_in_sc_in1586); if (state.failed) return retval;

                    }

                    dbg.location(277,25);
                    match(input,GT,FOLLOW_GT_in_sc_in1589); if (state.failed) return retval;

                    }


                    // TEMPLATE REWRITE
                    if ( state.backtracking==0 ) {
                      // 277:30: -> logic_vector(size=$INT.text)
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
        dbg.location(278, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "sc_in");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
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
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:280:1: sc_clock : 'sc_in_clk' ;
    public final Systemc_basicParser.sc_clock_return sc_clock() throws RecognitionException {
        Systemc_basicParser.sc_clock_return retval = new Systemc_basicParser.sc_clock_return();
        retval.start = input.LT(1);


        try { dbg.enterRule(getGrammarFileName(), "sc_clock");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(280, 0);

        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:280:10: ( 'sc_in_clk' )
            dbg.enterAlt(1);

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:281:2: 'sc_in_clk'
            {
            dbg.location(281,2);
            match(input,56,FOLLOW_56_in_sc_clock1611); if (state.failed) return retval;

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
        dbg.location(282, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "sc_clock");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
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
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:285:1: func_body : block -> func_body(declarations=$block.varsoperations=$block.elts);
    public final Systemc_basicParser.func_body_return func_body() throws RecognitionException {
        Systemc_basicParser.func_body_return retval = new Systemc_basicParser.func_body_return();
        retval.start = input.LT(1);


        Systemc_basicParser.block_return block31 =null;


        try { dbg.enterRule(getGrammarFileName(), "func_body");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(285, 0);

        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:286:2: ( block -> func_body(declarations=$block.varsoperations=$block.elts))
            dbg.enterAlt(1);

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:287:2: block
            {
            dbg.location(287,2);
            pushFollow(FOLLOW_block_in_func_body1624);
            block31=block();

            state._fsp--;
            if (state.failed) return retval;

            // TEMPLATE REWRITE
            if ( state.backtracking==0 ) {
              // 287:8: -> func_body(declarations=$block.varsoperations=$block.elts)
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
        dbg.location(288, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "func_body");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
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
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:290:1: block returns [List elts, HashMap vars] : '{' ( variable_decl[$vars] SEMICOLON | sc_assignement SEMICOLON | v_assignement SEMICOLON | cconstruct | func_call SEMICOLON | flux SEMICOLON )* '}' ;
    public final Systemc_basicParser.block_return block() throws RecognitionException {
        Systemc_basicParser.block_return retval = new Systemc_basicParser.block_return();
        retval.start = input.LT(1);


        Systemc_basicParser.sc_assignement_return sc_assignement32 =null;

        Systemc_basicParser.v_assignement_return v_assignement33 =null;

        Systemc_basicParser.cconstruct_return cconstruct34 =null;



          retval.elts = new ArrayList();
          retval.vars = new HashMap();

        try { dbg.enterRule(getGrammarFileName(), "block");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(290, 0);

        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:295:2: ( '{' ( variable_decl[$vars] SEMICOLON | sc_assignement SEMICOLON | v_assignement SEMICOLON | cconstruct | func_call SEMICOLON | flux SEMICOLON )* '}' )
            dbg.enterAlt(1);

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:297:2: '{' ( variable_decl[$vars] SEMICOLON | sc_assignement SEMICOLON | v_assignement SEMICOLON | cconstruct | func_call SEMICOLON | flux SEMICOLON )* '}'
            {
            dbg.location(297,2);
            match(input,75,FOLLOW_75_in_block1664); if (state.failed) return retval;
            dbg.location(298,2);
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:298:2: ( variable_decl[$vars] SEMICOLON | sc_assignement SEMICOLON | v_assignement SEMICOLON | cconstruct | func_call SEMICOLON | flux SEMICOLON )*
            try { dbg.enterSubRule(49);

            loop49:
            do {
                int alt49=7;
                try { dbg.enterDecision(49, decisionCanBacktrack[49]);

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

                } finally {dbg.exitDecision(49);}

                switch (alt49) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:298:3: variable_decl[$vars] SEMICOLON
            	    {
            	    dbg.location(298,3);
            	    pushFollow(FOLLOW_variable_decl_in_block1668);
            	    variable_decl(retval.vars);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    dbg.location(298,24);
            	    match(input,SEMICOLON,FOLLOW_SEMICOLON_in_block1671); if (state.failed) return retval;

            	    }
            	    break;
            	case 2 :
            	    dbg.enterAlt(2);

            	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:299:3: sc_assignement SEMICOLON
            	    {
            	    dbg.location(299,3);
            	    pushFollow(FOLLOW_sc_assignement_in_block1675);
            	    sc_assignement32=sc_assignement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    dbg.location(299,18);
            	    match(input,SEMICOLON,FOLLOW_SEMICOLON_in_block1677); if (state.failed) return retval;
            	    dbg.location(299,27);
            	    if ( state.backtracking==0 ) { retval.elts.add((sc_assignement32!=null?sc_assignement32.st:null));}

            	    }
            	    break;
            	case 3 :
            	    dbg.enterAlt(3);

            	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:300:3: v_assignement SEMICOLON
            	    {
            	    dbg.location(300,3);
            	    pushFollow(FOLLOW_v_assignement_in_block1682);
            	    v_assignement33=v_assignement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    dbg.location(300,17);
            	    match(input,SEMICOLON,FOLLOW_SEMICOLON_in_block1684); if (state.failed) return retval;
            	    dbg.location(300,26);
            	    if ( state.backtracking==0 ) { retval.elts.add((v_assignement33!=null?v_assignement33.st:null));}

            	    }
            	    break;
            	case 4 :
            	    dbg.enterAlt(4);

            	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:301:3: cconstruct
            	    {
            	    dbg.location(301,3);
            	    pushFollow(FOLLOW_cconstruct_in_block1689);
            	    cconstruct34=cconstruct();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    dbg.location(301,15);
            	    if ( state.backtracking==0 ) { retval.elts.add((cconstruct34!=null?cconstruct34.st:null));}

            	    }
            	    break;
            	case 5 :
            	    dbg.enterAlt(5);

            	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:302:3: func_call SEMICOLON
            	    {
            	    dbg.location(302,3);
            	    pushFollow(FOLLOW_func_call_in_block1696);
            	    func_call();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    dbg.location(302,13);
            	    match(input,SEMICOLON,FOLLOW_SEMICOLON_in_block1698); if (state.failed) return retval;

            	    }
            	    break;
            	case 6 :
            	    dbg.enterAlt(6);

            	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:303:4: flux SEMICOLON
            	    {
            	    dbg.location(303,4);
            	    pushFollow(FOLLOW_flux_in_block1703);
            	    flux();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    dbg.location(303,9);
            	    match(input,SEMICOLON,FOLLOW_SEMICOLON_in_block1705); if (state.failed) return retval;

            	    }
            	    break;

            	default :
            	    break loop49;
                }
            } while (true);
            } finally {dbg.exitSubRule(49);}

            dbg.location(304,2);
            match(input,77,FOLLOW_77_in_block1710); if (state.failed) return retval;

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
        dbg.location(305, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "block");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
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
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:307:1: cconstruct : ( case_construct -> dummy(val=$case_construct.st)| if_construct -> dummy(val=$if_construct.st));
    public final Systemc_basicParser.cconstruct_return cconstruct() throws RecognitionException {
        Systemc_basicParser.cconstruct_return retval = new Systemc_basicParser.cconstruct_return();
        retval.start = input.LT(1);


        Systemc_basicParser.case_construct_return case_construct35 =null;

        Systemc_basicParser.if_construct_return if_construct36 =null;


        try { dbg.enterRule(getGrammarFileName(), "cconstruct");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(307, 0);

        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:308:2: ( case_construct -> dummy(val=$case_construct.st)| if_construct -> dummy(val=$if_construct.st))
            int alt50=2;
            try { dbg.enterDecision(50, decisionCanBacktrack[50]);

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

                dbg.recognitionException(nvae);
                throw nvae;

            }
            } finally {dbg.exitDecision(50);}

            switch (alt50) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:309:2: case_construct
                    {
                    dbg.location(309,2);
                    pushFollow(FOLLOW_case_construct_in_cconstruct1723);
                    case_construct35=case_construct();

                    state._fsp--;
                    if (state.failed) return retval;

                    // TEMPLATE REWRITE
                    if ( state.backtracking==0 ) {
                      // 309:17: -> dummy(val=$case_construct.st)
                      {
                          retval.st = templateLib.getInstanceOf("dummy",new STAttrMap().put("val", (case_construct35!=null?case_construct35.st:null)));
                      }


                    }

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:310:3: if_construct
                    {
                    dbg.location(310,3);
                    pushFollow(FOLLOW_if_construct_in_cconstruct1737);
                    if_construct36=if_construct();

                    state._fsp--;
                    if (state.failed) return retval;

                    // TEMPLATE REWRITE
                    if ( state.backtracking==0 ) {
                      // 310:16: -> dummy(val=$if_construct.st)
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
        dbg.location(311, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "cconstruct");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
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
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:313:1: if_construct : 'if' '(' cond ')' ( if_content ) ( elsif_construct )* -> if_construct(condition=$cond.stelts=$if_content.contentalternatives= $slist::stack);
    public final Systemc_basicParser.if_construct_return if_construct() throws RecognitionException {
        slist_stack.push(new slist_scope());

        Systemc_basicParser.if_construct_return retval = new Systemc_basicParser.if_construct_return();
        retval.start = input.LT(1);


        Systemc_basicParser.elsif_construct_return elsif_construct37 =null;

        Systemc_basicParser.cond_return cond38 =null;

        Systemc_basicParser.if_content_return if_content39 =null;



          ((slist_scope)slist_stack.peek()).stack = new ArrayList();

        try { dbg.enterRule(getGrammarFileName(), "if_construct");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(313, 0);

        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:318:2: ( 'if' '(' cond ')' ( if_content ) ( elsif_construct )* -> if_construct(condition=$cond.stelts=$if_content.contentalternatives= $slist::stack))
            dbg.enterAlt(1);

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:319:2: 'if' '(' cond ')' ( if_content ) ( elsif_construct )*
            {
            dbg.location(319,2);
            match(input,50,FOLLOW_50_in_if_construct1769); if (state.failed) return retval;
            dbg.location(319,6);
            match(input,25,FOLLOW_25_in_if_construct1770); if (state.failed) return retval;
            dbg.location(319,9);
            pushFollow(FOLLOW_cond_in_if_construct1771);
            cond38=cond();

            state._fsp--;
            if (state.failed) return retval;
            dbg.location(319,14);
            match(input,26,FOLLOW_26_in_if_construct1773); if (state.failed) return retval;
            dbg.location(319,17);
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:319:17: ( if_content )
            dbg.enterAlt(1);

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:319:19: if_content
            {
            dbg.location(319,19);
            pushFollow(FOLLOW_if_content_in_if_construct1776);
            if_content39=if_content();

            state._fsp--;
            if (state.failed) return retval;

            }

            dbg.location(320,2);
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:320:2: ( elsif_construct )*
            try { dbg.enterSubRule(51);

            loop51:
            do {
                int alt51=2;
                try { dbg.enterDecision(51, decisionCanBacktrack[51]);

                int LA51_0 = input.LA(1);

                if ( (LA51_0==47) ) {
                    alt51=1;
                }


                } finally {dbg.exitDecision(51);}

                switch (alt51) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:320:3: elsif_construct
            	    {
            	    dbg.location(320,3);
            	    pushFollow(FOLLOW_elsif_construct_in_if_construct1781);
            	    elsif_construct37=elsif_construct();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    dbg.location(320,19);
            	    if ( state.backtracking==0 ) { ((slist_scope)slist_stack.peek()).stack.add((elsif_construct37!=null?elsif_construct37.st:null));}

            	    }
            	    break;

            	default :
            	    break loop51;
                }
            } while (true);
            } finally {dbg.exitSubRule(51);}


            // TEMPLATE REWRITE
            if ( state.backtracking==0 ) {
              // 320:65: -> if_construct(condition=$cond.stelts=$if_content.contentalternatives= $slist::stack)
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
        dbg.location(321, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "if_construct");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
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
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:323:1: elsif_construct : 'else' ( 'if' '(' cond ')' (ifc= if_content ) -> elsif_construct(condition=$cond.stelts=$ifc.content)|elsec= if_content -> else_construct(elts=$elsec.content)) ;
    public final Systemc_basicParser.elsif_construct_return elsif_construct() throws RecognitionException {
        Systemc_basicParser.elsif_construct_return retval = new Systemc_basicParser.elsif_construct_return();
        retval.start = input.LT(1);


        Systemc_basicParser.if_content_return ifc =null;

        Systemc_basicParser.if_content_return elsec =null;

        Systemc_basicParser.cond_return cond40 =null;


        try { dbg.enterRule(getGrammarFileName(), "elsif_construct");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(323, 0);

        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:324:2: ( 'else' ( 'if' '(' cond ')' (ifc= if_content ) -> elsif_construct(condition=$cond.stelts=$ifc.content)|elsec= if_content -> else_construct(elts=$elsec.content)) )
            dbg.enterAlt(1);

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:325:2: 'else' ( 'if' '(' cond ')' (ifc= if_content ) -> elsif_construct(condition=$cond.stelts=$ifc.content)|elsec= if_content -> else_construct(elts=$elsec.content))
            {
            dbg.location(325,2);
            match(input,47,FOLLOW_47_in_elsif_construct1824); if (state.failed) return retval;
            dbg.location(326,2);
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:326:2: ( 'if' '(' cond ')' (ifc= if_content ) -> elsif_construct(condition=$cond.stelts=$ifc.content)|elsec= if_content -> else_construct(elts=$elsec.content))
            int alt52=2;
            try { dbg.enterSubRule(52);
            try { dbg.enterDecision(52, decisionCanBacktrack[52]);

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

                dbg.recognitionException(nvae);
                throw nvae;

            }
            } finally {dbg.exitDecision(52);}

            switch (alt52) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:326:3: 'if' '(' cond ')' (ifc= if_content )
                    {
                    dbg.location(326,3);
                    match(input,50,FOLLOW_50_in_elsif_construct1829); if (state.failed) return retval;
                    dbg.location(326,7);
                    match(input,25,FOLLOW_25_in_elsif_construct1830); if (state.failed) return retval;
                    dbg.location(326,10);
                    pushFollow(FOLLOW_cond_in_elsif_construct1831);
                    cond40=cond();

                    state._fsp--;
                    if (state.failed) return retval;
                    dbg.location(326,15);
                    match(input,26,FOLLOW_26_in_elsif_construct1833); if (state.failed) return retval;
                    dbg.location(326,19);
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:326:19: (ifc= if_content )
                    dbg.enterAlt(1);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:326:20: ifc= if_content
                    {
                    dbg.location(326,24);
                    pushFollow(FOLLOW_if_content_in_elsif_construct1840);
                    ifc=if_content();

                    state._fsp--;
                    if (state.failed) return retval;

                    }


                    // TEMPLATE REWRITE
                    if ( state.backtracking==0 ) {
                      // 326:38: -> elsif_construct(condition=$cond.stelts=$ifc.content)
                      {
                          retval.st = templateLib.getInstanceOf("elsif_construct",new STAttrMap().put("condition", (cond40!=null?cond40.st:null)).put("elts", (ifc!=null?ifc.content:null)));
                      }


                    }

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:327:3: elsec= if_content
                    {
                    dbg.location(327,9);
                    pushFollow(FOLLOW_if_content_in_elsif_construct1866);
                    elsec=if_content();

                    state._fsp--;
                    if (state.failed) return retval;

                    // TEMPLATE REWRITE
                    if ( state.backtracking==0 ) {
                      // 327:22: -> else_construct(elts=$elsec.content)
                      {
                          retval.st = templateLib.getInstanceOf("else_construct",new STAttrMap().put("elts", (elsec!=null?elsec.content:null)));
                      }


                    }

                    }
                    break;

            }
            } finally {dbg.exitSubRule(52);}


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
        dbg.location(330, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "elsif_construct");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
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
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:332:1: if_content returns [List content] : ( ( v_assignement ) SEMICOLON | block );
    public final Systemc_basicParser.if_content_return if_content() throws RecognitionException {
        Systemc_basicParser.if_content_return retval = new Systemc_basicParser.if_content_return();
        retval.start = input.LT(1);


        Systemc_basicParser.v_assignement_return v_assignement41 =null;

        Systemc_basicParser.block_return block42 =null;



          retval.content = new ArrayList();

        try { dbg.enterRule(getGrammarFileName(), "if_content");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(332, 0);

        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:336:2: ( ( v_assignement ) SEMICOLON | block )
            int alt53=2;
            try { dbg.enterDecision(53, decisionCanBacktrack[53]);

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

                dbg.recognitionException(nvae);
                throw nvae;

            }
            } finally {dbg.exitDecision(53);}

            switch (alt53) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:337:2: ( v_assignement ) SEMICOLON
                    {
                    dbg.location(337,2);
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:337:2: ( v_assignement )
                    dbg.enterAlt(1);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:337:3: v_assignement
                    {
                    dbg.location(337,3);
                    pushFollow(FOLLOW_v_assignement_in_if_content1902);
                    v_assignement41=v_assignement();

                    state._fsp--;
                    if (state.failed) return retval;

                    }

                    dbg.location(337,18);
                    match(input,SEMICOLON,FOLLOW_SEMICOLON_in_if_content1905); if (state.failed) return retval;
                    dbg.location(337,28);
                    if ( state.backtracking==0 ) {retval.content.add((v_assignement41!=null?v_assignement41.st:null));}

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:338:4: block
                    {
                    dbg.location(338,4);
                    pushFollow(FOLLOW_block_in_if_content1912);
                    block42=block();

                    state._fsp--;
                    if (state.failed) return retval;
                    dbg.location(338,11);
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
        dbg.location(339, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "if_content");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
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
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:341:1: cond : test_express -> dummy(val=$test_express.st);
    public final Systemc_basicParser.cond_return cond() throws RecognitionException {
        cond_stack.push(new cond_scope());
        Systemc_basicParser.cond_return retval = new Systemc_basicParser.cond_return();
        retval.start = input.LT(1);


        Systemc_basicParser.test_express_return test_express43 =null;



          ((cond_scope)cond_stack.peek()).vals = new ArrayList();
          ((cond_scope)cond_stack.peek()).ops = new ArrayList();

        try { dbg.enterRule(getGrammarFileName(), "cond");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(341, 0);

        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:350:2: ( test_express -> dummy(val=$test_express.st))
            dbg.enterAlt(1);

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:352:3: test_express
            {
            dbg.location(352,3);
            pushFollow(FOLLOW_test_express_in_cond1942);
            test_express43=test_express();

            state._fsp--;
            if (state.failed) return retval;

            // TEMPLATE REWRITE
            if ( state.backtracking==0 ) {
              // 352:17: -> dummy(val=$test_express.st)
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
        dbg.location(353, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "cond");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
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
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:375:1: test_express options {backtrack=true; } : expression ( logic_op tx= test_express )? -> conditions(vals=$test_express::valsops=$test_express::ops);
    public final Systemc_basicParser.test_express_return test_express() throws RecognitionException {
        test_express_stack.push(new test_express_scope());
        Systemc_basicParser.test_express_return retval = new Systemc_basicParser.test_express_return();
        retval.start = input.LT(1);


        Systemc_basicParser.test_express_return tx =null;

        Systemc_basicParser.expression_return expression44 =null;

        Systemc_basicParser.logic_op_return logic_op45 =null;



          ((test_express_scope)test_express_stack.peek()).vals = new ArrayList();
          ((test_express_scope)test_express_stack.peek()).ops = new ArrayList();

        try { dbg.enterRule(getGrammarFileName(), "test_express");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(375, 0);

        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:386:2: ( expression ( logic_op tx= test_express )? -> conditions(vals=$test_express::valsops=$test_express::ops))
            dbg.enterAlt(1);

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:387:2: expression ( logic_op tx= test_express )?
            {
            dbg.location(387,2);
            pushFollow(FOLLOW_expression_in_test_express1991);
            expression44=expression();

            state._fsp--;
            if (state.failed) return retval;
            dbg.location(387,13);
            if ( state.backtracking==0 ) {((test_express_scope)test_express_stack.peek()).vals.add((expression44!=null?expression44.st:null)) ;}
            dbg.location(388,2);
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:388:2: ( logic_op tx= test_express )?
            int alt54=2;
            try { dbg.enterSubRule(54);
            try { dbg.enterDecision(54, decisionCanBacktrack[54]);

            int LA54_0 = input.LA(1);

            if ( (LA54_0==24||LA54_0==76) ) {
                alt54=1;
            }
            } finally {dbg.exitDecision(54);}

            switch (alt54) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:388:3: logic_op tx= test_express
                    {
                    dbg.location(388,3);
                    pushFollow(FOLLOW_logic_op_in_test_express1997);
                    logic_op45=logic_op();

                    state._fsp--;
                    if (state.failed) return retval;
                    dbg.location(388,12);
                    if ( state.backtracking==0 ) {((test_express_scope)test_express_stack.peek()).ops.add((logic_op45!=null?logic_op45.st:null)) ;}
                    dbg.location(388,56);
                    pushFollow(FOLLOW_test_express_in_test_express2005);
                    tx=test_express();

                    state._fsp--;
                    if (state.failed) return retval;
                    dbg.location(388,71);
                    if ( state.backtracking==0 ) {((test_express_scope)test_express_stack.peek()).vals.add((tx!=null?tx.st:null)) ;}

                    }
                    break;

            }
            } finally {dbg.exitSubRule(54);}


            // TEMPLATE REWRITE
            if ( state.backtracking==0 ) {
              // 388:109: -> conditions(vals=$test_express::valsops=$test_express::ops)
              {
                  retval.st = templateLib.getInstanceOf("conditions",new STAttrMap().put("vals", ((test_express_scope)test_express_stack.peek()).vals).put("ops", ((test_express_scope)test_express_stack.peek()).ops));
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
            test_express_stack.pop();
        }
        dbg.location(389, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "test_express");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
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
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:391:1: enclosed_expr : '(' expr= test_express ')' -> enclosed(val=$expr.st);
    public final Systemc_basicParser.enclosed_expr_return enclosed_expr() throws RecognitionException {
        Systemc_basicParser.enclosed_expr_return retval = new Systemc_basicParser.enclosed_expr_return();
        retval.start = input.LT(1);


        Systemc_basicParser.test_express_return expr =null;


        try { dbg.enterRule(getGrammarFileName(), "enclosed_expr");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(391, 0);

        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:391:15: ( '(' expr= test_express ')' -> enclosed(val=$expr.st))
            dbg.enterAlt(1);

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:392:2: '(' expr= test_express ')'
            {
            dbg.location(392,2);
            match(input,25,FOLLOW_25_in_enclosed_expr2039); if (state.failed) return retval;
            dbg.location(392,12);
            pushFollow(FOLLOW_test_express_in_enclosed_expr2046);
            expr=test_express();

            state._fsp--;
            if (state.failed) return retval;
            dbg.location(392,29);
            match(input,26,FOLLOW_26_in_enclosed_expr2050); if (state.failed) return retval;

            // TEMPLATE REWRITE
            if ( state.backtracking==0 ) {
              // 392:33: -> enclosed(val=$expr.st)
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
        dbg.location(393, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "enclosed_expr");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "enclosed_expr"


    public static class expression_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "expression"
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:395:1: expression options {backtrack=true; } : ( ( ( NOT )? enclosed_expr ) -> dummy(val=$enclosed_expr.st)| ( test ) -> dummy(val=$test.st));
    public final Systemc_basicParser.expression_return expression() throws RecognitionException {
        Systemc_basicParser.expression_return retval = new Systemc_basicParser.expression_return();
        retval.start = input.LT(1);


        Systemc_basicParser.enclosed_expr_return enclosed_expr46 =null;

        Systemc_basicParser.test_return test47 =null;


        try { dbg.enterRule(getGrammarFileName(), "expression");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(395, 0);

        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:397:4: ( ( ( NOT )? enclosed_expr ) -> dummy(val=$enclosed_expr.st)| ( test ) -> dummy(val=$test.st))
            int alt56=2;
            try { dbg.enterDecision(56, decisionCanBacktrack[56]);

            switch ( input.LA(1) ) {
            case NOT:
                {
                int LA56_1 = input.LA(2);

                if ( (synpred1_Systemc_basic()) ) {
                    alt56=1;
                }
                else if ( (true) ) {
                    alt56=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 56, 1, input);

                    dbg.recognitionException(nvae);
                    throw nvae;

                }
                }
                break;
            case 25:
                {
                int LA56_2 = input.LA(2);

                if ( (synpred1_Systemc_basic()) ) {
                    alt56=1;
                }
                else if ( (true) ) {
                    alt56=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 56, 2, input);

                    dbg.recognitionException(nvae);
                    throw nvae;

                }
                }
                break;
            case BIN:
            case HEX:
            case ID:
            case INT:
            case STRING_LITERAL:
            case 45:
            case 53:
            case 54:
                {
                alt56=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;

            }

            } finally {dbg.exitDecision(56);}

            switch (alt56) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:398:4: ( ( NOT )? enclosed_expr )
                    {
                    dbg.location(398,4);
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:398:4: ( ( NOT )? enclosed_expr )
                    dbg.enterAlt(1);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:398:5: ( NOT )? enclosed_expr
                    {
                    dbg.location(398,5);
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:398:5: ( NOT )?
                    int alt55=2;
                    try { dbg.enterSubRule(55);
                    try { dbg.enterDecision(55, decisionCanBacktrack[55]);

                    int LA55_0 = input.LA(1);

                    if ( (LA55_0==NOT) ) {
                        alt55=1;
                    }
                    } finally {dbg.exitDecision(55);}

                    switch (alt55) {
                        case 1 :
                            dbg.enterAlt(1);

                            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:398:6: NOT
                            {
                            dbg.location(398,6);
                            match(input,NOT,FOLLOW_NOT_in_expression2087); if (state.failed) return retval;

                            }
                            break;

                    }
                    } finally {dbg.exitSubRule(55);}

                    dbg.location(398,12);
                    pushFollow(FOLLOW_enclosed_expr_in_expression2091);
                    enclosed_expr46=enclosed_expr();

                    state._fsp--;
                    if (state.failed) return retval;

                    }


                    // TEMPLATE REWRITE
                    if ( state.backtracking==0 ) {
                      // 398:27: -> dummy(val=$enclosed_expr.st)
                      {
                          retval.st = templateLib.getInstanceOf("dummy",new STAttrMap().put("val", (enclosed_expr46!=null?enclosed_expr46.st:null)));
                      }


                    }

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:399:5: ( test )
                    {
                    dbg.location(399,5);
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:399:5: ( test )
                    dbg.enterAlt(1);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:399:6: test
                    {
                    dbg.location(399,6);
                    pushFollow(FOLLOW_test_in_expression2110);
                    test47=test();

                    state._fsp--;
                    if (state.failed) return retval;

                    }


                    // TEMPLATE REWRITE
                    if ( state.backtracking==0 ) {
                      // 399:12: -> dummy(val=$test.st)
                      {
                          retval.st = templateLib.getInstanceOf("dummy",new STAttrMap().put("val", (test47!=null?test47.st:null)));
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
        dbg.location(400, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "expression");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "expression"


    public static class test_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "test"
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:403:1: test : l= value (op= comp_op r= value )? -> test(l=$l.str=$r.stoperator=$op.text);
    public final Systemc_basicParser.test_return test() throws RecognitionException {
        Systemc_basicParser.test_return retval = new Systemc_basicParser.test_return();
        retval.start = input.LT(1);


        Systemc_basicParser.value_return l =null;

        Systemc_basicParser.comp_op_return op =null;

        Systemc_basicParser.value_return r =null;


        try { dbg.enterRule(getGrammarFileName(), "test");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(403, 0);

        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:403:6: (l= value (op= comp_op r= value )? -> test(l=$l.str=$r.stoperator=$op.text))
            dbg.enterAlt(1);

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:404:3: l= value (op= comp_op r= value )?
            {
            dbg.location(404,5);
            pushFollow(FOLLOW_value_in_test2140);
            l=value();

            state._fsp--;
            if (state.failed) return retval;
            dbg.location(404,12);
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:404:12: (op= comp_op r= value )?
            int alt57=2;
            try { dbg.enterSubRule(57);
            try { dbg.enterDecision(57, decisionCanBacktrack[57]);

            int LA57_0 = input.LA(1);

            if ( (LA57_0==EQUAL||LA57_0==GT||(LA57_0 >= LT && LA57_0 <= NOT)) ) {
                alt57=1;
            }
            } finally {dbg.exitDecision(57);}

            switch (alt57) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:404:14: op= comp_op r= value
                    {
                    dbg.location(404,17);
                    pushFollow(FOLLOW_comp_op_in_test2146);
                    op=comp_op();

                    state._fsp--;
                    if (state.failed) return retval;
                    dbg.location(404,28);
                    pushFollow(FOLLOW_value_in_test2152);
                    r=value();

                    state._fsp--;
                    if (state.failed) return retval;

                    }
                    break;

            }
            } finally {dbg.exitSubRule(57);}


            // TEMPLATE REWRITE
            if ( state.backtracking==0 ) {
              // 404:39: -> test(l=$l.str=$r.stoperator=$op.text)
              {
                  retval.st = templateLib.getInstanceOf("test",new STAttrMap().put("l", (l!=null?l.st:null)).put("r", (r!=null?r.st:null)).put("operator", (op!=null?input.toString(op.start,op.stop):null)));
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
        dbg.location(405, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "test");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
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
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:407:1: comp_op : ( LT | GT | NOT | '=' ) ( '=' )? ;
    public final Systemc_basicParser.comp_op_return comp_op() throws RecognitionException {
        Systemc_basicParser.comp_op_return retval = new Systemc_basicParser.comp_op_return();
        retval.start = input.LT(1);


        try { dbg.enterRule(getGrammarFileName(), "comp_op");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(407, 0);

        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:407:9: ( ( LT | GT | NOT | '=' ) ( '=' )? )
            dbg.enterAlt(1);

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:408:2: ( LT | GT | NOT | '=' ) ( '=' )?
            {
            dbg.location(408,2);
            if ( input.LA(1)==EQUAL||input.LA(1)==GT||(input.LA(1) >= LT && input.LA(1) <= NOT) ) {
                input.consume();
                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                dbg.recognitionException(mse);
                throw mse;
            }

            dbg.location(408,23);
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:408:23: ( '=' )?
            int alt58=2;
            try { dbg.enterSubRule(58);
            try { dbg.enterDecision(58, decisionCanBacktrack[58]);

            int LA58_0 = input.LA(1);

            if ( (LA58_0==EQUAL) ) {
                alt58=1;
            }
            } finally {dbg.exitDecision(58);}

            switch (alt58) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:408:24: '='
                    {
                    dbg.location(408,24);
                    match(input,EQUAL,FOLLOW_EQUAL_in_comp_op2209); if (state.failed) return retval;

                    }
                    break;

            }
            } finally {dbg.exitSubRule(58);}


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
        dbg.location(409, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "comp_op");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
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
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:410:1: logic_op : ( '&&' -> vhdl_and(| '||' -> vhdl_or();
    public final Systemc_basicParser.logic_op_return logic_op() throws RecognitionException {
        Systemc_basicParser.logic_op_return retval = new Systemc_basicParser.logic_op_return();
        retval.start = input.LT(1);


        try { dbg.enterRule(getGrammarFileName(), "logic_op");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(410, 0);

        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:410:10: ( '&&' -> vhdl_and(| '||' -> vhdl_or()
            int alt59=2;
            try { dbg.enterDecision(59, decisionCanBacktrack[59]);

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

                dbg.recognitionException(nvae);
                throw nvae;

            }
            } finally {dbg.exitDecision(59);}

            switch (alt59) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:411:2: '&&'
                    {
                    dbg.location(411,2);
                    match(input,24,FOLLOW_24_in_logic_op2221); if (state.failed) return retval;

                    // TEMPLATE REWRITE
                    if ( state.backtracking==0 ) {
                      // 411:8: -> vhdl_and(
                      {
                          retval.st = templateLib.getInstanceOf("vhdl_and");
                      }


                    }

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:412:4: '||'
                    {
                    dbg.location(412,4);
                    match(input,76,FOLLOW_76_in_logic_op2233); if (state.failed) return retval;

                    // TEMPLATE REWRITE
                    if ( state.backtracking==0 ) {
                      // 412:10: -> vhdl_or(
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
        dbg.location(413, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "logic_op");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
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
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:414:1: case_construct : 'switch' '(' value ')' '{' ( case_elt )* '}' -> switch(cases=$case_construct::casesvar=$value.st);
    public final Systemc_basicParser.case_construct_return case_construct() throws RecognitionException {
        case_construct_stack.push(new case_construct_scope());
        Systemc_basicParser.case_construct_return retval = new Systemc_basicParser.case_construct_return();
        retval.start = input.LT(1);


        Systemc_basicParser.case_elt_return case_elt48 =null;

        Systemc_basicParser.value_return value49 =null;



          ((case_construct_scope)case_construct_stack.peek()).cases = new ArrayList();

        try { dbg.enterRule(getGrammarFileName(), "case_construct");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(414, 0);

        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:421:2: ( 'switch' '(' value ')' '{' ( case_elt )* '}' -> switch(cases=$case_construct::casesvar=$value.st))
            dbg.enterAlt(1);

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:422:2: 'switch' '(' value ')' '{' ( case_elt )* '}'
            {
            dbg.location(422,2);
            match(input,72,FOLLOW_72_in_case_construct2260); if (state.failed) return retval;
            dbg.location(422,10);
            match(input,25,FOLLOW_25_in_case_construct2261); if (state.failed) return retval;
            dbg.location(422,13);
            pushFollow(FOLLOW_value_in_case_construct2262);
            value49=value();

            state._fsp--;
            if (state.failed) return retval;
            dbg.location(422,18);
            match(input,26,FOLLOW_26_in_case_construct2263); if (state.failed) return retval;
            dbg.location(422,21);
            match(input,75,FOLLOW_75_in_case_construct2264); if (state.failed) return retval;
            dbg.location(423,2);
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:423:2: ( case_elt )*
            try { dbg.enterSubRule(60);

            loop60:
            do {
                int alt60=2;
                try { dbg.enterDecision(60, decisionCanBacktrack[60]);

                int LA60_0 = input.LA(1);

                if ( (LA60_0==43||LA60_0==46) ) {
                    alt60=1;
                }


                } finally {dbg.exitDecision(60);}

                switch (alt60) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:423:3: case_elt
            	    {
            	    dbg.location(423,3);
            	    pushFollow(FOLLOW_case_elt_in_case_construct2268);
            	    case_elt48=case_elt();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    dbg.location(423,13);
            	    if ( state.backtracking==0 ) {   ((case_construct_scope)case_construct_stack.peek()).cases.add((case_elt48!=null?case_elt48.st:null));}

            	    }
            	    break;

            	default :
            	    break loop60;
                }
            } while (true);
            } finally {dbg.exitSubRule(60);}

            dbg.location(424,2);
            match(input,77,FOLLOW_77_in_case_construct2276); if (state.failed) return retval;

            // TEMPLATE REWRITE
            if ( state.backtracking==0 ) {
              // 424:6: -> switch(cases=$case_construct::casesvar=$value.st)
              {
                  retval.st = templateLib.getInstanceOf("switch",new STAttrMap().put("cases", ((case_construct_scope)case_construct_stack.peek()).cases).put("var", (value49!=null?value49.st:null)));
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
        dbg.location(425, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "case_construct");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
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
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:427:1: case_elt : ( 'case' ( ID ) | 'default' ) ':' ( v_assignement SEMICOLON | sc_assignement SEMICOLON | if_construct | func_call SEMICOLON | block SEMICOLON | flux SEMICOLON )* ( 'break' SEMICOLON )? -> case(val=$ID.textcont=$case_elt::cont);
    public final Systemc_basicParser.case_elt_return case_elt() throws RecognitionException {
        case_elt_stack.push(new case_elt_scope());
        Systemc_basicParser.case_elt_return retval = new Systemc_basicParser.case_elt_return();
        retval.start = input.LT(1);


        Token ID55=null;
        Systemc_basicParser.v_assignement_return v_assignement50 =null;

        Systemc_basicParser.sc_assignement_return sc_assignement51 =null;

        Systemc_basicParser.if_construct_return if_construct52 =null;

        Systemc_basicParser.func_call_return func_call53 =null;

        Systemc_basicParser.block_return block54 =null;



          ((case_elt_scope)case_elt_stack.peek()).cont = new ArrayList();

        try { dbg.enterRule(getGrammarFileName(), "case_elt");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(427, 0);

        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:434:2: ( ( 'case' ( ID ) | 'default' ) ':' ( v_assignement SEMICOLON | sc_assignement SEMICOLON | if_construct | func_call SEMICOLON | block SEMICOLON | flux SEMICOLON )* ( 'break' SEMICOLON )? -> case(val=$ID.textcont=$case_elt::cont))
            dbg.enterAlt(1);

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:435:2: ( 'case' ( ID ) | 'default' ) ':' ( v_assignement SEMICOLON | sc_assignement SEMICOLON | if_construct | func_call SEMICOLON | block SEMICOLON | flux SEMICOLON )* ( 'break' SEMICOLON )?
            {
            dbg.location(435,2);
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:435:2: ( 'case' ( ID ) | 'default' )
            int alt61=2;
            try { dbg.enterSubRule(61);
            try { dbg.enterDecision(61, decisionCanBacktrack[61]);

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

                dbg.recognitionException(nvae);
                throw nvae;

            }
            } finally {dbg.exitDecision(61);}

            switch (alt61) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:435:3: 'case' ( ID )
                    {
                    dbg.location(435,3);
                    match(input,43,FOLLOW_43_in_case_elt2316); if (state.failed) return retval;
                    dbg.location(435,10);
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:435:10: ( ID )
                    dbg.enterAlt(1);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:435:11: ID
                    {
                    dbg.location(435,11);
                    ID55=(Token)match(input,ID,FOLLOW_ID_in_case_elt2319); if (state.failed) return retval;

                    }


                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:435:17: 'default'
                    {
                    dbg.location(435,17);
                    match(input,46,FOLLOW_46_in_case_elt2324); if (state.failed) return retval;

                    }
                    break;

            }
            } finally {dbg.exitSubRule(61);}

            dbg.location(435,28);
            match(input,31,FOLLOW_31_in_case_elt2327); if (state.failed) return retval;
            dbg.location(436,2);
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:436:2: ( v_assignement SEMICOLON | sc_assignement SEMICOLON | if_construct | func_call SEMICOLON | block SEMICOLON | flux SEMICOLON )*
            try { dbg.enterSubRule(62);

            loop62:
            do {
                int alt62=7;
                try { dbg.enterDecision(62, decisionCanBacktrack[62]);

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

                } finally {dbg.exitDecision(62);}

                switch (alt62) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:436:3: v_assignement SEMICOLON
            	    {
            	    dbg.location(436,3);
            	    pushFollow(FOLLOW_v_assignement_in_case_elt2332);
            	    v_assignement50=v_assignement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    dbg.location(436,17);
            	    match(input,SEMICOLON,FOLLOW_SEMICOLON_in_case_elt2334); if (state.failed) return retval;
            	    dbg.location(436,26);
            	    if ( state.backtracking==0 ) {  ((case_elt_scope)case_elt_stack.peek()).cont.add((v_assignement50!=null?v_assignement50.st:null));}

            	    }
            	    break;
            	case 2 :
            	    dbg.enterAlt(2);

            	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:437:3: sc_assignement SEMICOLON
            	    {
            	    dbg.location(437,3);
            	    pushFollow(FOLLOW_sc_assignement_in_case_elt2339);
            	    sc_assignement51=sc_assignement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    dbg.location(437,18);
            	    match(input,SEMICOLON,FOLLOW_SEMICOLON_in_case_elt2341); if (state.failed) return retval;
            	    dbg.location(437,27);
            	    if ( state.backtracking==0 ) {  ((case_elt_scope)case_elt_stack.peek()).cont.add((sc_assignement51!=null?sc_assignement51.st:null));}

            	    }
            	    break;
            	case 3 :
            	    dbg.enterAlt(3);

            	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:438:3: if_construct
            	    {
            	    dbg.location(438,3);
            	    pushFollow(FOLLOW_if_construct_in_case_elt2346);
            	    if_construct52=if_construct();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    dbg.location(438,16);
            	    if ( state.backtracking==0 ) { ((case_elt_scope)case_elt_stack.peek()).cont.add((if_construct52!=null?if_construct52.st:null));}

            	    }
            	    break;
            	case 4 :
            	    dbg.enterAlt(4);

            	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:439:3: func_call SEMICOLON
            	    {
            	    dbg.location(439,3);
            	    pushFollow(FOLLOW_func_call_in_case_elt2352);
            	    func_call53=func_call();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    dbg.location(439,13);
            	    match(input,SEMICOLON,FOLLOW_SEMICOLON_in_case_elt2354); if (state.failed) return retval;
            	    dbg.location(439,22);
            	    if ( state.backtracking==0 ) {  ((case_elt_scope)case_elt_stack.peek()).cont.add((func_call53!=null?func_call53.st:null));}

            	    }
            	    break;
            	case 5 :
            	    dbg.enterAlt(5);

            	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:440:3: block SEMICOLON
            	    {
            	    dbg.location(440,3);
            	    pushFollow(FOLLOW_block_in_case_elt2359);
            	    block54=block();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    dbg.location(440,9);
            	    match(input,SEMICOLON,FOLLOW_SEMICOLON_in_case_elt2361); if (state.failed) return retval;
            	    dbg.location(440,18);
            	    if ( state.backtracking==0 ) {  ((case_elt_scope)case_elt_stack.peek()).cont.addAll((block54!=null?block54.elts:null));}

            	    }
            	    break;
            	case 6 :
            	    dbg.enterAlt(6);

            	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:441:3: flux SEMICOLON
            	    {
            	    dbg.location(441,3);
            	    pushFollow(FOLLOW_flux_in_case_elt2366);
            	    flux();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    dbg.location(441,8);
            	    match(input,SEMICOLON,FOLLOW_SEMICOLON_in_case_elt2368); if (state.failed) return retval;

            	    }
            	    break;

            	default :
            	    break loop62;
                }
            } while (true);
            } finally {dbg.exitSubRule(62);}

            dbg.location(443,2);
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:443:2: ( 'break' SEMICOLON )?
            int alt63=2;
            try { dbg.enterSubRule(63);
            try { dbg.enterDecision(63, decisionCanBacktrack[63]);

            int LA63_0 = input.LA(1);

            if ( (LA63_0==42) ) {
                alt63=1;
            }
            } finally {dbg.exitDecision(63);}

            switch (alt63) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:443:3: 'break' SEMICOLON
                    {
                    dbg.location(443,3);
                    match(input,42,FOLLOW_42_in_case_elt2376); if (state.failed) return retval;
                    dbg.location(443,11);
                    match(input,SEMICOLON,FOLLOW_SEMICOLON_in_case_elt2378); if (state.failed) return retval;

                    }
                    break;

            }
            } finally {dbg.exitSubRule(63);}


            // TEMPLATE REWRITE
            if ( state.backtracking==0 ) {
              // 443:23: -> case(val=$ID.textcont=$case_elt::cont)
              {
                  retval.st = templateLib.getInstanceOf("case",new STAttrMap().put("val", (ID55!=null?ID55.getText():null)).put("cont", ((case_elt_scope)case_elt_stack.peek()).cont));
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
        dbg.location(444, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "case_elt");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
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
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:446:1: flux : ( ID '::' )? ID '<<' value ( '<<' value )* ;
    public final Systemc_basicParser.flux_return flux() throws RecognitionException {
        Systemc_basicParser.flux_return retval = new Systemc_basicParser.flux_return();
        retval.start = input.LT(1);


        try { dbg.enterRule(getGrammarFileName(), "flux");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(446, 0);

        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:446:6: ( ( ID '::' )? ID '<<' value ( '<<' value )* )
            dbg.enterAlt(1);

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:446:7: ( ID '::' )? ID '<<' value ( '<<' value )*
            {
            dbg.location(446,7);
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:446:7: ( ID '::' )?
            int alt64=2;
            try { dbg.enterSubRule(64);
            try { dbg.enterDecision(64, decisionCanBacktrack[64]);

            int LA64_0 = input.LA(1);

            if ( (LA64_0==ID) ) {
                int LA64_1 = input.LA(2);

                if ( (LA64_1==32) ) {
                    alt64=1;
                }
            }
            } finally {dbg.exitDecision(64);}

            switch (alt64) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:446:8: ID '::'
                    {
                    dbg.location(446,8);
                    match(input,ID,FOLLOW_ID_in_flux2408); if (state.failed) return retval;
                    dbg.location(446,10);
                    match(input,32,FOLLOW_32_in_flux2409); if (state.failed) return retval;

                    }
                    break;

            }
            } finally {dbg.exitSubRule(64);}

            dbg.location(446,16);
            match(input,ID,FOLLOW_ID_in_flux2412); if (state.failed) return retval;
            dbg.location(446,19);
            match(input,33,FOLLOW_33_in_flux2414); if (state.failed) return retval;
            dbg.location(446,24);
            pushFollow(FOLLOW_value_in_flux2416);
            value();

            state._fsp--;
            if (state.failed) return retval;
            dbg.location(446,30);
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:446:30: ( '<<' value )*
            try { dbg.enterSubRule(65);

            loop65:
            do {
                int alt65=2;
                try { dbg.enterDecision(65, decisionCanBacktrack[65]);

                int LA65_0 = input.LA(1);

                if ( (LA65_0==33) ) {
                    alt65=1;
                }


                } finally {dbg.exitDecision(65);}

                switch (alt65) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:446:31: '<<' value
            	    {
            	    dbg.location(446,31);
            	    match(input,33,FOLLOW_33_in_flux2419); if (state.failed) return retval;
            	    dbg.location(446,37);
            	    pushFollow(FOLLOW_value_in_flux2422);
            	    value();

            	    state._fsp--;
            	    if (state.failed) return retval;

            	    }
            	    break;

            	default :
            	    break loop65;
                }
            } while (true);
            } finally {dbg.exitSubRule(65);}


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
        dbg.location(447, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "flux");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
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
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:450:1: v_assignement : ID EQUAL assignement_value -> var_assign(var=$ID.textval=$assignement_value.st);
    public final Systemc_basicParser.v_assignement_return v_assignement() throws RecognitionException {
        Systemc_basicParser.v_assignement_return retval = new Systemc_basicParser.v_assignement_return();
        retval.start = input.LT(1);


        Token ID56=null;
        Systemc_basicParser.assignement_value_return assignement_value57 =null;


        try { dbg.enterRule(getGrammarFileName(), "v_assignement");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(450, 0);

        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:451:2: ( ID EQUAL assignement_value -> var_assign(var=$ID.textval=$assignement_value.st))
            dbg.enterAlt(1);

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:452:2: ID EQUAL assignement_value
            {
            dbg.location(452,2);
            ID56=(Token)match(input,ID,FOLLOW_ID_in_v_assignement2440); if (state.failed) return retval;
            dbg.location(452,5);
            match(input,EQUAL,FOLLOW_EQUAL_in_v_assignement2442); if (state.failed) return retval;
            dbg.location(452,11);
            pushFollow(FOLLOW_assignement_value_in_v_assignement2444);
            assignement_value57=assignement_value();

            state._fsp--;
            if (state.failed) return retval;

            // TEMPLATE REWRITE
            if ( state.backtracking==0 ) {
              // 452:30: -> var_assign(var=$ID.textval=$assignement_value.st)
              {
                  retval.st = templateLib.getInstanceOf("var_assign",new STAttrMap().put("var", (ID56!=null?ID56.getText():null)).put("val", (assignement_value57!=null?assignement_value57.st:null)));
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
        dbg.location(453, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "v_assignement");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
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
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:455:1: sc_assignement : ID '.write(' assignement_value ')' -> signal_assignement(dest=$ID.textsource=$assignement_value.st);
    public final Systemc_basicParser.sc_assignement_return sc_assignement() throws RecognitionException {
        Systemc_basicParser.sc_assignement_return retval = new Systemc_basicParser.sc_assignement_return();
        retval.start = input.LT(1);


        Token ID58=null;
        Systemc_basicParser.assignement_value_return assignement_value59 =null;


        try { dbg.enterRule(getGrammarFileName(), "sc_assignement");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(455, 0);

        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:456:2: ( ID '.write(' assignement_value ')' -> signal_assignement(dest=$ID.textsource=$assignement_value.st))
            dbg.enterAlt(1);

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:457:2: ID '.write(' assignement_value ')'
            {
            dbg.location(457,2);
            ID58=(Token)match(input,ID,FOLLOW_ID_in_sc_assignement2475); if (state.failed) return retval;
            dbg.location(457,4);
            match(input,30,FOLLOW_30_in_sc_assignement2476); if (state.failed) return retval;
            dbg.location(457,13);
            pushFollow(FOLLOW_assignement_value_in_sc_assignement2477);
            assignement_value59=assignement_value();

            state._fsp--;
            if (state.failed) return retval;
            dbg.location(457,30);
            match(input,26,FOLLOW_26_in_sc_assignement2478); if (state.failed) return retval;

            // TEMPLATE REWRITE
            if ( state.backtracking==0 ) {
              // 457:34: -> signal_assignement(dest=$ID.textsource=$assignement_value.st)
              {
                  retval.st = templateLib.getInstanceOf("signal_assignement",new STAttrMap().put("dest", (ID58!=null?ID58.getText():null)).put("source", (assignement_value59!=null?assignement_value59.st:null)));
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
        dbg.location(458, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "sc_assignement");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
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
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:460:1: assignement_value : value -> dummy(val=$value.st);
    public final Systemc_basicParser.assignement_value_return assignement_value() throws RecognitionException {
        Systemc_basicParser.assignement_value_return retval = new Systemc_basicParser.assignement_value_return();
        retval.start = input.LT(1);


        Systemc_basicParser.value_return value60 =null;


        try { dbg.enterRule(getGrammarFileName(), "assignement_value");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(460, 0);

        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:461:2: ( value -> dummy(val=$value.st))
            dbg.enterAlt(1);

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:462:4: value
            {
            dbg.location(462,4);
            pushFollow(FOLLOW_value_in_assignement_value2510);
            value60=value();

            state._fsp--;
            if (state.failed) return retval;

            // TEMPLATE REWRITE
            if ( state.backtracking==0 ) {
              // 462:11: -> dummy(val=$value.st)
              {
                  retval.st = templateLib.getInstanceOf("dummy",new STAttrMap().put("val", (value60!=null?value60.st:null)));
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
        dbg.location(463, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "assignement_value");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
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
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:465:1: value : ( HEX -> dummy(val= $HEX.text)| BIN -> dummy(val= $BIN.text)| INT -> dummy(val= $INT.text)| STRING_LITERAL -> dummy(val= $STRING_LITERAL.text)|h= var_value ( OP t= value )? -> expression(head=$h.stop=$OP.texttail=$t.st)| func_call -> dummy(val=$func_call.st)| sc_method -> dummy(val=$sc_method.st));
    public final Systemc_basicParser.value_return value() throws RecognitionException {
        Systemc_basicParser.value_return retval = new Systemc_basicParser.value_return();
        retval.start = input.LT(1);


        Token HEX61=null;
        Token BIN62=null;
        Token INT63=null;
        Token STRING_LITERAL64=null;
        Token OP65=null;
        Systemc_basicParser.var_value_return h =null;

        Systemc_basicParser.value_return t =null;

        Systemc_basicParser.func_call_return func_call66 =null;

        Systemc_basicParser.sc_method_return sc_method67 =null;


        try { dbg.enterRule(getGrammarFileName(), "value");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(465, 0);

        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:465:7: ( HEX -> dummy(val= $HEX.text)| BIN -> dummy(val= $BIN.text)| INT -> dummy(val= $INT.text)| STRING_LITERAL -> dummy(val= $STRING_LITERAL.text)|h= var_value ( OP t= value )? -> expression(head=$h.stop=$OP.texttail=$t.st)| func_call -> dummy(val=$func_call.st)| sc_method -> dummy(val=$sc_method.st))
            int alt67=7;
            try { dbg.enterDecision(67, decisionCanBacktrack[67]);

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
            case NOT:
                {
                alt67=5;
                }
                break;
            case ID:
                {
                int LA67_6 = input.LA(2);

                if ( (LA67_6==25) ) {
                    alt67=6;
                }
                else if ( (LA67_6==EQUAL||LA67_6==GT||(LA67_6 >= LT && LA67_6 <= SEMICOLON)||LA67_6==24||LA67_6==26||(LA67_6 >= 28 && LA67_6 <= 29)||LA67_6==33||LA67_6==37||LA67_6==39||LA67_6==76) ) {
                    alt67=5;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 67, 6, input);

                    dbg.recognitionException(nvae);
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

                dbg.recognitionException(nvae);
                throw nvae;

            }

            } finally {dbg.exitDecision(67);}

            switch (alt67) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:466:3: HEX
                    {
                    dbg.location(466,3);
                    HEX61=(Token)match(input,HEX,FOLLOW_HEX_in_value2534); if (state.failed) return retval;

                    // TEMPLATE REWRITE
                    if ( state.backtracking==0 ) {
                      // 466:8: -> dummy(val= $HEX.text)
                      {
                          retval.st = templateLib.getInstanceOf("dummy",new STAttrMap().put("val",  (HEX61!=null?HEX61.getText():null)));
                      }


                    }

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:467:4: BIN
                    {
                    dbg.location(467,4);
                    BIN62=(Token)match(input,BIN,FOLLOW_BIN_in_value2551); if (state.failed) return retval;

                    // TEMPLATE REWRITE
                    if ( state.backtracking==0 ) {
                      // 467:9: -> dummy(val= $BIN.text)
                      {
                          retval.st = templateLib.getInstanceOf("dummy",new STAttrMap().put("val",  (BIN62!=null?BIN62.getText():null)));
                      }


                    }

                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:468:4: INT
                    {
                    dbg.location(468,4);
                    INT63=(Token)match(input,INT,FOLLOW_INT_in_value2568); if (state.failed) return retval;

                    // TEMPLATE REWRITE
                    if ( state.backtracking==0 ) {
                      // 468:9: -> dummy(val= $INT.text)
                      {
                          retval.st = templateLib.getInstanceOf("dummy",new STAttrMap().put("val",  (INT63!=null?INT63.getText():null)));
                      }


                    }

                    }
                    break;
                case 4 :
                    dbg.enterAlt(4);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:469:4: STRING_LITERAL
                    {
                    dbg.location(469,4);
                    STRING_LITERAL64=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_value2585); if (state.failed) return retval;

                    // TEMPLATE REWRITE
                    if ( state.backtracking==0 ) {
                      // 469:21: -> dummy(val= $STRING_LITERAL.text)
                      {
                          retval.st = templateLib.getInstanceOf("dummy",new STAttrMap().put("val",  (STRING_LITERAL64!=null?STRING_LITERAL64.getText():null)));
                      }


                    }

                    }
                    break;
                case 5 :
                    dbg.enterAlt(5);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:470:4: h= var_value ( OP t= value )?
                    {
                    dbg.location(470,5);
                    pushFollow(FOLLOW_var_value_in_value2607);
                    h=var_value();

                    state._fsp--;
                    if (state.failed) return retval;
                    dbg.location(470,17);
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:470:17: ( OP t= value )?
                    int alt66=2;
                    try { dbg.enterSubRule(66);
                    try { dbg.enterDecision(66, decisionCanBacktrack[66]);

                    int LA66_0 = input.LA(1);

                    if ( (LA66_0==OP) ) {
                        alt66=1;
                    }
                    } finally {dbg.exitDecision(66);}

                    switch (alt66) {
                        case 1 :
                            dbg.enterAlt(1);

                            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:470:18: OP t= value
                            {
                            dbg.location(470,18);
                            OP65=(Token)match(input,OP,FOLLOW_OP_in_value2611); if (state.failed) return retval;
                            dbg.location(470,22);
                            pushFollow(FOLLOW_value_in_value2615);
                            t=value();

                            state._fsp--;
                            if (state.failed) return retval;

                            }
                            break;

                    }
                    } finally {dbg.exitSubRule(66);}


                    // TEMPLATE REWRITE
                    if ( state.backtracking==0 ) {
                      // 470:30: -> expression(head=$h.stop=$OP.texttail=$t.st)
                      {
                          retval.st = templateLib.getInstanceOf("expression",new STAttrMap().put("head", (h!=null?h.st:null)).put("op", (OP65!=null?OP65.getText():null)).put("tail", (t!=null?t.st:null)));
                      }


                    }

                    }
                    break;
                case 6 :
                    dbg.enterAlt(6);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:471:4: func_call
                    {
                    dbg.location(471,4);
                    pushFollow(FOLLOW_func_call_in_value2645);
                    func_call66=func_call();

                    state._fsp--;
                    if (state.failed) return retval;

                    // TEMPLATE REWRITE
                    if ( state.backtracking==0 ) {
                      // 471:14: -> dummy(val=$func_call.st)
                      {
                          retval.st = templateLib.getInstanceOf("dummy",new STAttrMap().put("val", (func_call66!=null?func_call66.st:null)));
                      }


                    }

                    }
                    break;
                case 7 :
                    dbg.enterAlt(7);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:472:4: sc_method
                    {
                    dbg.location(472,4);
                    pushFollow(FOLLOW_sc_method_in_value2661);
                    sc_method67=sc_method();

                    state._fsp--;
                    if (state.failed) return retval;

                    // TEMPLATE REWRITE
                    if ( state.backtracking==0 ) {
                      // 472:14: -> dummy(val=$sc_method.st)
                      {
                          retval.st = templateLib.getInstanceOf("dummy",new STAttrMap().put("val", (sc_method67!=null?sc_method67.st:null)));
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
        dbg.location(473, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "value");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
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
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:475:1: var_value : ( NOT )? ( var_name ) ( var_comp )* -> var_value(not=$NOT.textvar=$var_name.stmethods=$var_comp.st);
    public final Systemc_basicParser.var_value_return var_value() throws RecognitionException {
        Systemc_basicParser.var_value_return retval = new Systemc_basicParser.var_value_return();
        retval.start = input.LT(1);


        Token NOT68=null;
        Systemc_basicParser.var_name_return var_name69 =null;

        Systemc_basicParser.var_comp_return var_comp70 =null;


        try { dbg.enterRule(getGrammarFileName(), "var_value");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(475, 0);

        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:475:11: ( ( NOT )? ( var_name ) ( var_comp )* -> var_value(not=$NOT.textvar=$var_name.stmethods=$var_comp.st))
            dbg.enterAlt(1);

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:477:2: ( NOT )? ( var_name ) ( var_comp )*
            {
            dbg.location(477,2);
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:477:2: ( NOT )?
            int alt68=2;
            try { dbg.enterSubRule(68);
            try { dbg.enterDecision(68, decisionCanBacktrack[68]);

            int LA68_0 = input.LA(1);

            if ( (LA68_0==NOT) ) {
                alt68=1;
            }
            } finally {dbg.exitDecision(68);}

            switch (alt68) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:477:3: NOT
                    {
                    dbg.location(477,3);
                    NOT68=(Token)match(input,NOT,FOLLOW_NOT_in_var_value2686); if (state.failed) return retval;

                    }
                    break;

            }
            } finally {dbg.exitSubRule(68);}

            dbg.location(477,10);
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:477:10: ( var_name )
            dbg.enterAlt(1);

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:477:11: var_name
            {
            dbg.location(477,11);
            pushFollow(FOLLOW_var_name_in_var_value2692);
            var_name69=var_name();

            state._fsp--;
            if (state.failed) return retval;

            }

            dbg.location(477,21);
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:477:21: ( var_comp )*
            try { dbg.enterSubRule(69);

            loop69:
            do {
                int alt69=2;
                try { dbg.enterDecision(69, decisionCanBacktrack[69]);

                int LA69_0 = input.LA(1);

                if ( (LA69_0==29||LA69_0==37) ) {
                    alt69=1;
                }


                } finally {dbg.exitDecision(69);}

                switch (alt69) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:477:21: var_comp
            	    {
            	    dbg.location(477,21);
            	    pushFollow(FOLLOW_var_comp_in_var_value2695);
            	    var_comp70=var_comp();

            	    state._fsp--;
            	    if (state.failed) return retval;

            	    }
            	    break;

            	default :
            	    break loop69;
                }
            } while (true);
            } finally {dbg.exitSubRule(69);}


            // TEMPLATE REWRITE
            if ( state.backtracking==0 ) {
              // 477:32: -> var_value(not=$NOT.textvar=$var_name.stmethods=$var_comp.st)
              {
                  retval.st = templateLib.getInstanceOf("var_value",new STAttrMap().put("not", (NOT68!=null?NOT68.getText():null)).put("var", (var_name69!=null?var_name69.st:null)).put("methods", (var_comp70!=null?var_comp70.st:null)));
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
        dbg.location(478, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "var_value");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
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
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:480:1: var_comp : ( ( '.' ( ( sc_method ) -> dummy(val=$sc_method.st)| ( method ) ) -> dummy(val=$method.st)) | ( '[' value ']' ) -> array_value(index=$value.st));
    public final Systemc_basicParser.var_comp_return var_comp() throws RecognitionException {
        Systemc_basicParser.var_comp_return retval = new Systemc_basicParser.var_comp_return();
        retval.start = input.LT(1);


        Systemc_basicParser.sc_method_return sc_method71 =null;

        Systemc_basicParser.method_return method72 =null;

        Systemc_basicParser.value_return value73 =null;


        try { dbg.enterRule(getGrammarFileName(), "var_comp");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(480, 0);

        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:480:10: ( ( '.' ( ( sc_method ) -> dummy(val=$sc_method.st)| ( method ) ) -> dummy(val=$method.st)) | ( '[' value ']' ) -> array_value(index=$value.st))
            int alt71=2;
            try { dbg.enterDecision(71, decisionCanBacktrack[71]);

            int LA71_0 = input.LA(1);

            if ( (LA71_0==29) ) {
                alt71=1;
            }
            else if ( (LA71_0==37) ) {
                alt71=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 71, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;

            }
            } finally {dbg.exitDecision(71);}

            switch (alt71) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:481:2: ( '.' ( ( sc_method ) -> dummy(val=$sc_method.st)| ( method ) ) -> dummy(val=$method.st))
                    {
                    dbg.location(481,2);
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:481:2: ( '.' ( ( sc_method ) -> dummy(val=$sc_method.st)| ( method ) ) -> dummy(val=$method.st))
                    dbg.enterAlt(1);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:481:3: '.' ( ( sc_method ) -> dummy(val=$sc_method.st)| ( method ) )
                    {
                    dbg.location(481,3);
                    match(input,29,FOLLOW_29_in_var_comp2735); if (state.failed) return retval;
                    dbg.location(482,2);
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:482:2: ( ( sc_method ) -> dummy(val=$sc_method.st)| ( method ) )
                    int alt70=2;
                    try { dbg.enterSubRule(70);
                    try { dbg.enterDecision(70, decisionCanBacktrack[70]);

                    int LA70_0 = input.LA(1);

                    if ( (LA70_0==25||LA70_0==45||(LA70_0 >= 53 && LA70_0 <= 54)) ) {
                        alt70=1;
                    }
                    else if ( (LA70_0==ID) ) {
                        alt70=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 70, 0, input);

                        dbg.recognitionException(nvae);
                        throw nvae;

                    }
                    } finally {dbg.exitDecision(70);}

                    switch (alt70) {
                        case 1 :
                            dbg.enterAlt(1);

                            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:482:3: ( sc_method )
                            {
                            dbg.location(482,3);
                            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:482:3: ( sc_method )
                            dbg.enterAlt(1);

                            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:482:4: sc_method
                            {
                            dbg.location(482,4);
                            pushFollow(FOLLOW_sc_method_in_var_comp2740);
                            sc_method71=sc_method();

                            state._fsp--;
                            if (state.failed) return retval;

                            }


                            // TEMPLATE REWRITE
                            if ( state.backtracking==0 ) {
                              // 482:15: -> dummy(val=$sc_method.st)
                              {
                                  retval.st = templateLib.getInstanceOf("dummy",new STAttrMap().put("val", (sc_method71!=null?sc_method71.st:null)));
                              }


                            }

                            }
                            break;
                        case 2 :
                            dbg.enterAlt(2);

                            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:483:4: ( method )
                            {
                            dbg.location(483,4);
                            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:483:4: ( method )
                            dbg.enterAlt(1);

                            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:483:6: method
                            {
                            dbg.location(483,6);
                            pushFollow(FOLLOW_method_in_var_comp2759);
                            method72=method();

                            state._fsp--;
                            if (state.failed) return retval;

                            }


                            }
                            break;

                    }
                    } finally {dbg.exitSubRule(70);}


                    // TEMPLATE REWRITE
                    if ( state.backtracking==0 ) {
                      // 483:15: -> dummy(val=$method.st)
                      {
                          retval.st = templateLib.getInstanceOf("dummy",new STAttrMap().put("val", (method72!=null?method72.st:null)));
                      }


                    }

                    }


                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:485:4: ( '[' value ']' )
                    {
                    dbg.location(485,4);
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:485:4: ( '[' value ']' )
                    dbg.enterAlt(1);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:485:5: '[' value ']'
                    {
                    dbg.location(485,5);
                    match(input,37,FOLLOW_37_in_var_comp2781); if (state.failed) return retval;
                    dbg.location(485,8);
                    pushFollow(FOLLOW_value_in_var_comp2782);
                    value73=value();

                    state._fsp--;
                    if (state.failed) return retval;
                    dbg.location(485,13);
                    match(input,39,FOLLOW_39_in_var_comp2783); if (state.failed) return retval;

                    }


                    // TEMPLATE REWRITE
                    if ( state.backtracking==0 ) {
                      // 485:18: -> array_value(index=$value.st)
                      {
                          retval.st = templateLib.getInstanceOf("array_value",new STAttrMap().put("index", (value73!=null?value73.st:null)));
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
        dbg.location(486, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "var_comp");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
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
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:488:1: var_name : ID -> dummy(val=$ID.text);
    public final Systemc_basicParser.var_name_return var_name() throws RecognitionException {
        Systemc_basicParser.var_name_return retval = new Systemc_basicParser.var_name_return();
        retval.start = input.LT(1);


        Token ID74=null;

        try { dbg.enterRule(getGrammarFileName(), "var_name");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(488, 0);

        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:489:2: ( ID -> dummy(val=$ID.text))
            dbg.enterAlt(1);

            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:490:2: ID
            {
            dbg.location(490,2);
            ID74=(Token)match(input,ID,FOLLOW_ID_in_var_name2809); if (state.failed) return retval;

            // TEMPLATE REWRITE
            if ( state.backtracking==0 ) {
              // 490:5: -> dummy(val=$ID.text)
              {
                  retval.st = templateLib.getInstanceOf("dummy",new STAttrMap().put("val", (ID74!=null?ID74.getText():null)));
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
        dbg.location(491, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "var_name");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
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
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:495:1: sc_type : ( 'sc_lv' ( LT INT GT ) -> logic_vector(size=$INT.text)| 'sc_uint' ( LT INT GT ) -> logic_vector(size=$INT.text)| 'sc_logic' -> logic(| 'bool' -> bool();
    public final Systemc_basicParser.sc_type_return sc_type() throws RecognitionException {
        Systemc_basicParser.sc_type_return retval = new Systemc_basicParser.sc_type_return();
        retval.start = input.LT(1);


        Token INT75=null;
        Token INT76=null;

        try { dbg.enterRule(getGrammarFileName(), "sc_type");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(495, 0);

        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:495:9: ( 'sc_lv' ( LT INT GT ) -> logic_vector(size=$INT.text)| 'sc_uint' ( LT INT GT ) -> logic_vector(size=$INT.text)| 'sc_logic' -> logic(| 'bool' -> bool()
            int alt72=4;
            try { dbg.enterDecision(72, decisionCanBacktrack[72]);

            switch ( input.LA(1) ) {
            case 63:
                {
                alt72=1;
                }
                break;
            case 68:
                {
                alt72=2;
                }
                break;
            case 62:
                {
                alt72=3;
                }
                break;
            case 41:
                {
                alt72=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 72, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;

            }

            } finally {dbg.exitDecision(72);}

            switch (alt72) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:496:2: 'sc_lv' ( LT INT GT )
                    {
                    dbg.location(496,2);
                    match(input,63,FOLLOW_63_in_sc_type2833); if (state.failed) return retval;
                    dbg.location(496,9);
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:496:9: ( LT INT GT )
                    dbg.enterAlt(1);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:496:10: LT INT GT
                    {
                    dbg.location(496,10);
                    match(input,LT,FOLLOW_LT_in_sc_type2835); if (state.failed) return retval;
                    dbg.location(496,13);
                    INT75=(Token)match(input,INT,FOLLOW_INT_in_sc_type2837); if (state.failed) return retval;
                    dbg.location(496,17);
                    match(input,GT,FOLLOW_GT_in_sc_type2839); if (state.failed) return retval;

                    }


                    // TEMPLATE REWRITE
                    if ( state.backtracking==0 ) {
                      // 496:21: -> logic_vector(size=$INT.text)
                      {
                          retval.st = templateLib.getInstanceOf("logic_vector",new STAttrMap().put("size", (INT75!=null?INT75.getText():null)));
                      }


                    }

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:497:4: 'sc_uint' ( LT INT GT )
                    {
                    dbg.location(497,4);
                    match(input,68,FOLLOW_68_in_sc_type2854); if (state.failed) return retval;
                    dbg.location(497,14);
                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:497:14: ( LT INT GT )
                    dbg.enterAlt(1);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:497:15: LT INT GT
                    {
                    dbg.location(497,15);
                    match(input,LT,FOLLOW_LT_in_sc_type2857); if (state.failed) return retval;
                    dbg.location(497,18);
                    INT76=(Token)match(input,INT,FOLLOW_INT_in_sc_type2859); if (state.failed) return retval;
                    dbg.location(497,22);
                    match(input,GT,FOLLOW_GT_in_sc_type2861); if (state.failed) return retval;

                    }


                    // TEMPLATE REWRITE
                    if ( state.backtracking==0 ) {
                      // 497:26: -> logic_vector(size=$INT.text)
                      {
                          retval.st = templateLib.getInstanceOf("logic_vector",new STAttrMap().put("size", (INT76!=null?INT76.getText():null)));
                      }


                    }

                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:498:4: 'sc_logic'
                    {
                    dbg.location(498,4);
                    match(input,62,FOLLOW_62_in_sc_type2876); if (state.failed) return retval;

                    // TEMPLATE REWRITE
                    if ( state.backtracking==0 ) {
                      // 498:15: -> logic(
                      {
                          retval.st = templateLib.getInstanceOf("logic");
                      }


                    }

                    }
                    break;
                case 4 :
                    dbg.enterAlt(4);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:499:4: 'bool'
                    {
                    dbg.location(499,4);
                    match(input,41,FOLLOW_41_in_sc_type2887); if (state.failed) return retval;

                    // TEMPLATE REWRITE
                    if ( state.backtracking==0 ) {
                      // 499:11: -> bool(
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
        dbg.location(500, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "sc_type");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
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
    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:503:1: sc_method : ( 'range(' from= INT ',' to= INT ')' -> range(from=$from.textto=$to.text)| 'concat(' left= value ',' right= value ')' -> concat(left=$left.stright=$right.st)| 'read()' | '(' left= value ',' right= value ')' -> concat(left=$left.stright=$right.st));
    public final Systemc_basicParser.sc_method_return sc_method() throws RecognitionException {
        Systemc_basicParser.sc_method_return retval = new Systemc_basicParser.sc_method_return();
        retval.start = input.LT(1);


        Token from=null;
        Token to=null;
        Systemc_basicParser.value_return left =null;

        Systemc_basicParser.value_return right =null;


        try { dbg.enterRule(getGrammarFileName(), "sc_method");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(503, 0);

        try {
            // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:504:2: ( 'range(' from= INT ',' to= INT ')' -> range(from=$from.textto=$to.text)| 'concat(' left= value ',' right= value ')' -> concat(left=$left.stright=$right.st)| 'read()' | '(' left= value ',' right= value ')' -> concat(left=$left.stright=$right.st))
            int alt73=4;
            try { dbg.enterDecision(73, decisionCanBacktrack[73]);

            switch ( input.LA(1) ) {
            case 53:
                {
                alt73=1;
                }
                break;
            case 45:
                {
                alt73=2;
                }
                break;
            case 54:
                {
                alt73=3;
                }
                break;
            case 25:
                {
                alt73=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 73, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;

            }

            } finally {dbg.exitDecision(73);}

            switch (alt73) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:505:2: 'range(' from= INT ',' to= INT ')'
                    {
                    dbg.location(505,2);
                    match(input,53,FOLLOW_53_in_sc_method2906); if (state.failed) return retval;
                    dbg.location(505,15);
                    from=(Token)match(input,INT,FOLLOW_INT_in_sc_method2911); if (state.failed) return retval;
                    dbg.location(505,21);
                    match(input,28,FOLLOW_28_in_sc_method2913); if (state.failed) return retval;
                    dbg.location(505,28);
                    to=(Token)match(input,INT,FOLLOW_INT_in_sc_method2919); if (state.failed) return retval;
                    dbg.location(505,33);
                    match(input,26,FOLLOW_26_in_sc_method2920); if (state.failed) return retval;

                    // TEMPLATE REWRITE
                    if ( state.backtracking==0 ) {
                      // 505:37: -> range(from=$from.textto=$to.text)
                      {
                          retval.st = templateLib.getInstanceOf("range",new STAttrMap().put("from", (from!=null?from.getText():null)).put("to", (to!=null?to.getText():null)));
                      }


                    }

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:506:3: 'concat(' left= value ',' right= value ')'
                    {
                    dbg.location(506,3);
                    match(input,45,FOLLOW_45_in_sc_method2942); if (state.failed) return retval;
                    dbg.location(506,19);
                    pushFollow(FOLLOW_value_in_sc_method2949);
                    left=value();

                    state._fsp--;
                    if (state.failed) return retval;
                    dbg.location(506,28);
                    match(input,28,FOLLOW_28_in_sc_method2952); if (state.failed) return retval;
                    dbg.location(506,37);
                    pushFollow(FOLLOW_value_in_sc_method2957);
                    right=value();

                    state._fsp--;
                    if (state.failed) return retval;
                    dbg.location(506,45);
                    match(input,26,FOLLOW_26_in_sc_method2959); if (state.failed) return retval;

                    // TEMPLATE REWRITE
                    if ( state.backtracking==0 ) {
                      // 506:48: -> concat(left=$left.stright=$right.st)
                      {
                          retval.st = templateLib.getInstanceOf("concat",new STAttrMap().put("left", (left!=null?left.st:null)).put("right", (right!=null?right.st:null)));
                      }


                    }

                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:507:4: 'read()'
                    {
                    dbg.location(507,4);
                    match(input,54,FOLLOW_54_in_sc_method2981); if (state.failed) return retval;

                    }
                    break;
                case 4 :
                    dbg.enterAlt(4);

                    // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:508:3: '(' left= value ',' right= value ')'
                    {
                    dbg.location(508,3);
                    match(input,25,FOLLOW_25_in_sc_method2985); if (state.failed) return retval;
                    dbg.location(508,13);
                    pushFollow(FOLLOW_value_in_sc_method2992);
                    left=value();

                    state._fsp--;
                    if (state.failed) return retval;
                    dbg.location(508,21);
                    match(input,28,FOLLOW_28_in_sc_method2994); if (state.failed) return retval;
                    dbg.location(508,30);
                    pushFollow(FOLLOW_value_in_sc_method2999);
                    right=value();

                    state._fsp--;
                    if (state.failed) return retval;
                    dbg.location(508,37);
                    match(input,26,FOLLOW_26_in_sc_method3000); if (state.failed) return retval;

                    // TEMPLATE REWRITE
                    if ( state.backtracking==0 ) {
                      // 508:40: -> concat(left=$left.stright=$right.st)
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
        dbg.location(509, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "sc_method");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "sc_method"

    // $ANTLR start synpred1_Systemc_basic
    public final void synpred1_Systemc_basic_fragment() throws RecognitionException {
        // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:398:4: ( ( ( NOT )? enclosed_expr ) )
        dbg.enterAlt(1);

        // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:398:4: ( ( NOT )? enclosed_expr )
        {
        dbg.location(398,4);
        // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:398:4: ( ( NOT )? enclosed_expr )
        dbg.enterAlt(1);

        // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:398:5: ( NOT )? enclosed_expr
        {
        dbg.location(398,5);
        // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:398:5: ( NOT )?
        int alt74=2;
        try { dbg.enterSubRule(74);
        try { dbg.enterDecision(74, decisionCanBacktrack[74]);

        int LA74_0 = input.LA(1);

        if ( (LA74_0==NOT) ) {
            alt74=1;
        }
        } finally {dbg.exitDecision(74);}

        switch (alt74) {
            case 1 :
                dbg.enterAlt(1);

                // /home/jpiat/workspace/SystemCToVHDL/grammar/Systemc_basic.g:398:6: NOT
                {
                dbg.location(398,6);
                match(input,NOT,FOLLOW_NOT_in_synpred1_Systemc_basic2087); if (state.failed) return ;

                }
                break;

        }
        } finally {dbg.exitSubRule(74);}

        dbg.location(398,12);
        pushFollow(FOLLOW_enclosed_expr_in_synpred1_Systemc_basic2091);
        enclosed_expr();

        state._fsp--;
        if (state.failed) return ;

        }


        }

    }
    // $ANTLR end synpred1_Systemc_basic

    // Delegated rules

    public final boolean synpred1_Systemc_basic() {
        state.backtracking++;
        dbg.beginBacktrack(state.backtracking);
        int start = input.mark();
        try {
            synpred1_Systemc_basic_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        dbg.endBacktrack(state.backtracking, success);
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
            return "94:2: ( port_decl SEMICOLON | signal_dec SEMICOLON | enum_decl SEMICOLON | variable_decl[$vars] SEMICOLON | func_decl ( SEMICOLON )? | actor )";
        }
        public void error(NoViableAltException nvae) {
            dbg.recognitionException(nvae);
        }
    }
 

    public static final BitSet FOLLOW_pre_processor_in_cfile48 = new BitSet(new long[]{0xFF9B121400E80400L,0x00000000000006DFL});
    public static final BitSet FOLLOW_declarations_in_cfile53 = new BitSet(new long[]{0xFF9B121400000400L,0x00000000000006DFL});
    public static final BitSet FOLLOW_module_decl_in_cfile60 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_SEMICOLON_in_cfile62 = new BitSet(new long[]{0xFF9B120400E80402L,0x00000000000006DFL});
    public static final BitSet FOLLOW_declarations_in_cfile66 = new BitSet(new long[]{0xFF9B120400E80402L,0x00000000000006DFL});
    public static final BitSet FOLLOW_pre_processor_in_cfile72 = new BitSet(new long[]{0x0000000000E80002L});
    public static final BitSet FOLLOW_includes_in_pre_processor96 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_define_in_pre_processor102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_pre_processor107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_includes118 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_includes120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_define130 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_ID_in_define136 = new BitSet(new long[]{0x0000000000000E02L});
    public static final BitSet FOLLOW_20_in_endif156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_module_decl181 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_module_decl183 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_ID_in_module_decl185 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_module_decl187 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_75_in_module_decl189 = new BitSet(new long[]{0xFF9B120400000400L,0x00000000000006DFL});
    public static final BitSet FOLLOW_module_body_in_module_decl199 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_77_in_module_decl209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declarations_in_module_body370 = new BitSet(new long[]{0xFF9B120400000402L,0x00000000000006DFL});
    public static final BitSet FOLLOW_port_decl_in_declarations388 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_SEMICOLON_in_declarations390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_signal_dec_in_declarations398 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_SEMICOLON_in_declarations400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_enum_decl_in_declarations407 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_SEMICOLON_in_declarations409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_decl_in_declarations416 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_SEMICOLON_in_declarations419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_func_decl_in_declarations424 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_SEMICOLON_in_declarations426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_actor_in_declarations432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_v_type_in_func_decl448 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_ID_in_func_decl453 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_func_decl454 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_ID_in_func_decl460 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_func_decl462 = new BitSet(new long[]{0xC01A120004000400L,0x00000000000006D0L});
    public static final BitSet FOLLOW_v_type_in_func_decl465 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_ID_in_func_decl467 = new BitSet(new long[]{0x0000000014000000L});
    public static final BitSet FOLLOW_28_in_func_decl470 = new BitSet(new long[]{0xC01A120000000400L,0x00000000000006D0L});
    public static final BitSet FOLLOW_v_type_in_func_decl471 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_ID_in_func_decl473 = new BitSet(new long[]{0x0000000014000000L});
    public static final BitSet FOLLOW_26_in_func_decl479 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000800L});
    public static final BitSet FOLLOW_func_body_in_func_decl484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_enum_decl512 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_ID_in_enum_decl514 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_75_in_enum_decl516 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_name_in_enum_decl518 = new BitSet(new long[]{0x0000000010000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_28_in_enum_decl521 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_name_in_enum_decl523 = new BitSet(new long[]{0x0000000010000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_77_in_enum_decl527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_v_type_in_variable_decl555 = new BitSet(new long[]{0x0000004008000400L});
    public static final BitSet FOLLOW_ID_in_variable_decl573 = new BitSet(new long[]{0x0000002010000042L});
    public static final BitSet FOLLOW_28_in_variable_decl582 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_ID_in_variable_decl586 = new BitSet(new long[]{0x0000002010000042L});
    public static final BitSet FOLLOW_fixed_size_array_in_variable_decl592 = new BitSet(new long[]{0x0000002000000042L});
    public static final BitSet FOLLOW_assignement_in_variable_decl595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_fixed_size_array610 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_INT_in_fixed_size_array611 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_fixed_size_array612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EQUAL_in_assignement625 = new BitSet(new long[]{0x0000000000020880L,0x0000000000000800L});
    public static final BitSet FOLLOW_INT_in_assignement628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_array_of_value_in_assignement631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_assignement635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_assignement640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_array_of_value652 = new BitSet(new long[]{0x0000000000000880L,0x0000000000000800L});
    public static final BitSet FOLLOW_INT_in_array_of_value654 = new BitSet(new long[]{0x0000000010000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_array_of_value_in_array_of_value657 = new BitSet(new long[]{0x0000000010000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_FLOAT_in_array_of_value661 = new BitSet(new long[]{0x0000000010000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_28_in_array_of_value665 = new BitSet(new long[]{0x0000000000000880L,0x0000000000000800L});
    public static final BitSet FOLLOW_INT_in_array_of_value668 = new BitSet(new long[]{0x0000000010000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_array_of_value_in_array_of_value671 = new BitSet(new long[]{0x0000000010000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_FLOAT_in_array_of_value675 = new BitSet(new long[]{0x0000000010000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_77_in_array_of_value679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_v_signed_modifier_in_v_type692 = new BitSet(new long[]{0x0018000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_v_size_modifier_in_v_type695 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_v_type699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_v_signed_modifier_in_v_type704 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_v_type708 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_v_type711 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_v_type713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_v_type716 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_ID_in_v_type718 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sc_type_in_v_type722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_v_type725 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_otemplate_in_v_type727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_v_signed_modifier754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LT_in_otemplate763 = new BitSet(new long[]{0x0000000000000C00L});
    public static final BitSet FOLLOW_set_in_otemplate765 = new BitSet(new long[]{0x0000000010000100L});
    public static final BitSet FOLLOW_28_in_otemplate772 = new BitSet(new long[]{0x0000000000000C00L});
    public static final BitSet FOLLOW_set_in_otemplate774 = new BitSet(new long[]{0x0000000010000100L});
    public static final BitSet FOLLOW_GT_in_otemplate781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_actor791 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_actor792 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_ID_in_actor793 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_actor794 = new BitSet(new long[]{0x0000000080000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_31_in_actor798 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_actor_inst_in_actor800 = new BitSet(new long[]{0x0000000010000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_28_in_actor802 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_actor_inst_in_actor803 = new BitSet(new long[]{0x0000000010000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_75_in_actor808 = new BitSet(new long[]{0x0000000800000400L});
    public static final BitSet FOLLOW_actor_body_in_actor811 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_77_in_actor814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_actor_inst825 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_actor_inst826 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_actor_inst827 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_actor_inst828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_connection843 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_connection844 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_link_in_connection845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_link858 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_link859 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_ID_in_link862 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_link863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_sensitive893 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_sensitive895 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_ID_in_sensitive897 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_sensitive900 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_method_in_sensitive901 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_ID_in_method927 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_method928 = new BitSet(new long[]{0x0060200006022E10L});
    public static final BitSet FOLLOW_func_arg_in_method930 = new BitSet(new long[]{0x0000000014000000L});
    public static final BitSet FOLLOW_28_in_method932 = new BitSet(new long[]{0x0060200002022E10L});
    public static final BitSet FOLLOW_func_arg_in_method935 = new BitSet(new long[]{0x0000000014000000L});
    public static final BitSet FOLLOW_26_in_method942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_value_in_func_arg968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_actor_method_decl_in_actor_method997 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_SEMICOLON_in_actor_method999 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_sensitive_in_actor_method1004 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_SEMICOLON_in_actor_method1006 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000020L});
    public static final BitSet FOLLOW_35_in_actor_method_decl1041 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_ID_in_actor_method_decl1046 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_actor_method_decl1047 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_actor_body_elt_in_actor_body1060 = new BitSet(new long[]{0x0000000800000402L});
    public static final BitSet FOLLOW_actor_method_in_actor_body_elt1079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_func_call_in_actor_body_elt1087 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_SEMICOLON_in_actor_body_elt1089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_connection_in_actor_body_elt1095 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_SEMICOLON_in_actor_body_elt1097 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sc_signal_in_signal_dec1122 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_name_in_signal_dec1125 = new BitSet(new long[]{0x0000002010000002L});
    public static final BitSet FOLLOW_28_in_signal_dec1128 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_name_in_signal_dec1129 = new BitSet(new long[]{0x0000002010000002L});
    public static final BitSet FOLLOW_fixed_size_array_in_signal_dec1134 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_67_in_sc_signal1168 = new BitSet(new long[]{0x0000010000001000L});
    public static final BitSet FOLLOW_40_in_sc_signal1170 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LT_in_sc_signal1173 = new BitSet(new long[]{0xC000020000000400L,0x0000000000000010L});
    public static final BitSet FOLLOW_signal_type_in_sc_signal1176 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_GT_in_sc_signal1179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sc_type_in_signal_type1201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_signal_type1210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_func_call1243 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_func_call1246 = new BitSet(new long[]{0x0060200006022E10L});
    public static final BitSet FOLLOW_func_arg_in_func_call1248 = new BitSet(new long[]{0x0000000014000000L});
    public static final BitSet FOLLOW_28_in_func_call1251 = new BitSet(new long[]{0x0060200002022E10L});
    public static final BitSet FOLLOW_func_arg_in_func_call1253 = new BitSet(new long[]{0x0000000014000000L});
    public static final BitSet FOLLOW_26_in_func_call1258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_port_type_in_port_decl1297 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_name_in_port_decl1299 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_port_decl1302 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_name_in_port_decl1304 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_ID_in_name1336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sc_clock_in_port_type1350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sc_in_in_port_type1360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sc_out_in_port_type1373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sc_inout_in_port_type1386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_sc_inout1407 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LT_in_sc_inout1409 = new BitSet(new long[]{0xC000020000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_sc_type_in_sc_inout1412 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_GT_in_sc_inout1415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_sc_inout1430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_sc_inout1443 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LT_in_sc_inout1445 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_INT_in_sc_inout1448 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_GT_in_sc_inout1451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_sc_out1476 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LT_in_sc_out1479 = new BitSet(new long[]{0xC000020000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_sc_type_in_sc_out1482 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_GT_in_sc_out1486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_sc_out1500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_sc_out1513 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LT_in_sc_out1515 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_INT_in_sc_out1519 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_GT_in_sc_out1522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_sc_in1544 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LT_in_sc_in1546 = new BitSet(new long[]{0xC000020000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_sc_type_in_sc_in1549 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_GT_in_sc_in1553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_sc_in1567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_sc_in1580 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LT_in_sc_in1582 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_INT_in_sc_in1586 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_GT_in_sc_in1589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_sc_clock1611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_block_in_func_body1624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_block1664 = new BitSet(new long[]{0xC01E120000000400L,0x00000000000027D0L});
    public static final BitSet FOLLOW_variable_decl_in_block1668 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_SEMICOLON_in_block1671 = new BitSet(new long[]{0xC01E120000000400L,0x00000000000027D0L});
    public static final BitSet FOLLOW_sc_assignement_in_block1675 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_SEMICOLON_in_block1677 = new BitSet(new long[]{0xC01E120000000400L,0x00000000000027D0L});
    public static final BitSet FOLLOW_v_assignement_in_block1682 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_SEMICOLON_in_block1684 = new BitSet(new long[]{0xC01E120000000400L,0x00000000000027D0L});
    public static final BitSet FOLLOW_cconstruct_in_block1689 = new BitSet(new long[]{0xC01E120000000400L,0x00000000000027D0L});
    public static final BitSet FOLLOW_func_call_in_block1696 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_SEMICOLON_in_block1698 = new BitSet(new long[]{0xC01E120000000400L,0x00000000000027D0L});
    public static final BitSet FOLLOW_flux_in_block1703 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_SEMICOLON_in_block1705 = new BitSet(new long[]{0xC01E120000000400L,0x00000000000027D0L});
    public static final BitSet FOLLOW_77_in_block1710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_case_construct_in_cconstruct1723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_if_construct_in_cconstruct1737 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_if_construct1769 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_if_construct1770 = new BitSet(new long[]{0x0060200002022E10L});
    public static final BitSet FOLLOW_cond_in_if_construct1771 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_if_construct1773 = new BitSet(new long[]{0x0000000000000400L,0x0000000000000800L});
    public static final BitSet FOLLOW_if_content_in_if_construct1776 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_elsif_construct_in_if_construct1781 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_47_in_elsif_construct1824 = new BitSet(new long[]{0x0004000000000400L,0x0000000000000800L});
    public static final BitSet FOLLOW_50_in_elsif_construct1829 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_elsif_construct1830 = new BitSet(new long[]{0x0060200002022E10L});
    public static final BitSet FOLLOW_cond_in_elsif_construct1831 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_elsif_construct1833 = new BitSet(new long[]{0x0000000000000400L,0x0000000000000800L});
    public static final BitSet FOLLOW_if_content_in_elsif_construct1840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_if_content_in_elsif_construct1866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_v_assignement_in_if_content1902 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_SEMICOLON_in_if_content1905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_block_in_if_content1912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_test_express_in_cond1942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_test_express1991 = new BitSet(new long[]{0x0000000001000002L,0x0000000000001000L});
    public static final BitSet FOLLOW_logic_op_in_test_express1997 = new BitSet(new long[]{0x0060200002022E10L});
    public static final BitSet FOLLOW_test_express_in_test_express2005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_enclosed_expr2039 = new BitSet(new long[]{0x0060200002022E10L});
    public static final BitSet FOLLOW_test_express_in_enclosed_expr2046 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_enclosed_expr2050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_expression2087 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_enclosed_expr_in_expression2091 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_test_in_expression2110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_value_in_test2140 = new BitSet(new long[]{0x0000000000003142L});
    public static final BitSet FOLLOW_comp_op_in_test2146 = new BitSet(new long[]{0x0060200002022E10L});
    public static final BitSet FOLLOW_value_in_test2152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_comp_op2193 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_EQUAL_in_comp_op2209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_logic_op2221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_logic_op2233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_case_construct2260 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_case_construct2261 = new BitSet(new long[]{0x0060200002022E10L});
    public static final BitSet FOLLOW_value_in_case_construct2262 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_case_construct2263 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_75_in_case_construct2264 = new BitSet(new long[]{0x0000480000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_case_elt_in_case_construct2268 = new BitSet(new long[]{0x0000480000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_77_in_case_construct2276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_case_elt2316 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_ID_in_case_elt2319 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_46_in_case_elt2324 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_case_elt2327 = new BitSet(new long[]{0x0004040000000402L,0x0000000000000800L});
    public static final BitSet FOLLOW_v_assignement_in_case_elt2332 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_SEMICOLON_in_case_elt2334 = new BitSet(new long[]{0x0004040000000402L,0x0000000000000800L});
    public static final BitSet FOLLOW_sc_assignement_in_case_elt2339 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_SEMICOLON_in_case_elt2341 = new BitSet(new long[]{0x0004040000000402L,0x0000000000000800L});
    public static final BitSet FOLLOW_if_construct_in_case_elt2346 = new BitSet(new long[]{0x0004040000000402L,0x0000000000000800L});
    public static final BitSet FOLLOW_func_call_in_case_elt2352 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_SEMICOLON_in_case_elt2354 = new BitSet(new long[]{0x0004040000000402L,0x0000000000000800L});
    public static final BitSet FOLLOW_block_in_case_elt2359 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_SEMICOLON_in_case_elt2361 = new BitSet(new long[]{0x0004040000000402L,0x0000000000000800L});
    public static final BitSet FOLLOW_flux_in_case_elt2366 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_SEMICOLON_in_case_elt2368 = new BitSet(new long[]{0x0004040000000402L,0x0000000000000800L});
    public static final BitSet FOLLOW_42_in_case_elt2376 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_SEMICOLON_in_case_elt2378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_flux2408 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_flux2409 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_ID_in_flux2412 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_flux2414 = new BitSet(new long[]{0x0060200002022E10L});
    public static final BitSet FOLLOW_value_in_flux2416 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_flux2419 = new BitSet(new long[]{0x0060200002022E10L});
    public static final BitSet FOLLOW_value_in_flux2422 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_ID_in_v_assignement2440 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EQUAL_in_v_assignement2442 = new BitSet(new long[]{0x0060200002022E10L});
    public static final BitSet FOLLOW_assignement_value_in_v_assignement2444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_sc_assignement2475 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_sc_assignement2476 = new BitSet(new long[]{0x0060200002022E10L});
    public static final BitSet FOLLOW_assignement_value_in_sc_assignement2477 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_sc_assignement2478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_value_in_assignement_value2510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HEX_in_value2534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BIN_in_value2551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_value2568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_value2585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_var_value_in_value2607 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_OP_in_value2611 = new BitSet(new long[]{0x0060200002022E10L});
    public static final BitSet FOLLOW_value_in_value2615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_func_call_in_value2645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sc_method_in_value2661 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_var_value2686 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_var_name_in_var_value2692 = new BitSet(new long[]{0x0000002020000002L});
    public static final BitSet FOLLOW_var_comp_in_var_value2695 = new BitSet(new long[]{0x0000002020000002L});
    public static final BitSet FOLLOW_29_in_var_comp2735 = new BitSet(new long[]{0x0060200002000400L});
    public static final BitSet FOLLOW_sc_method_in_var_comp2740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_method_in_var_comp2759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_var_comp2781 = new BitSet(new long[]{0x0060200002022E10L});
    public static final BitSet FOLLOW_value_in_var_comp2782 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_var_comp2783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_var_name2809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_sc_type2833 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LT_in_sc_type2835 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_INT_in_sc_type2837 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_GT_in_sc_type2839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_sc_type2854 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LT_in_sc_type2857 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_INT_in_sc_type2859 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_GT_in_sc_type2861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_sc_type2876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_sc_type2887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_sc_method2906 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_INT_in_sc_method2911 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_sc_method2913 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_INT_in_sc_method2919 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_sc_method2920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_sc_method2942 = new BitSet(new long[]{0x0060200002022E10L});
    public static final BitSet FOLLOW_value_in_sc_method2949 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_sc_method2952 = new BitSet(new long[]{0x0060200002022E10L});
    public static final BitSet FOLLOW_value_in_sc_method2957 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_sc_method2959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_sc_method2981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_sc_method2985 = new BitSet(new long[]{0x0060200002022E10L});
    public static final BitSet FOLLOW_value_in_sc_method2992 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_sc_method2994 = new BitSet(new long[]{0x0060200002022E10L});
    public static final BitSet FOLLOW_value_in_sc_method2999 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_sc_method3000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_synpred1_Systemc_basic2087 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_enclosed_expr_in_synpred1_Systemc_basic2091 = new BitSet(new long[]{0x0000000000000002L});

}