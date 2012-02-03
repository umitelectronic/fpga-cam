// $ANTLR 3.4 /home/jpiat/Downloads/examples-v3/java/cminus/CMinus.g 2012-01-26 15:53:21

import org.antlr.stringtemplate.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.debug.*;
import java.io.IOException;
import org.antlr.stringtemplate.*;
import org.antlr.stringtemplate.language.*;
import java.util.HashMap;
@SuppressWarnings({"all", "warnings", "unchecked"})
public class CMinusParser extends DebugParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ID", "INT", "WS", "'('", "')'", "'+'", "','", "';'", "'<'", "'='", "'=='", "'char'", "'for'", "'int'", "'{'", "'}'"
    };

    public static final int EOF=-1;
    public static final int T__7=7;
    public static final int T__8=8;
    public static final int T__9=9;
    public static final int T__10=10;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__19=19;
    public static final int ID=4;
    public static final int INT=5;
    public static final int WS=6;

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators

    protected static class slist_scope {
        List locals;
        List stats;
    }
    protected Stack slist_stack = new Stack();



public static final String[] ruleNames = new String[] {
    "invalidRule", "declarator", "condExpr", "assignStat", "declaration", 
    "atom", "formalParameter", "stat", "expr", "type", "forStat", "function", 
    "variable", "block", "program", "aexpr"
};

public static final boolean[] decisionCanBacktrack = new boolean[] {
    false, // invalid decision
    false, false, false, false, false, false, false, false, false, false, 
        false, false
};

 
    public int ruleLevel = 0;
    public int getRuleLevel() { return ruleLevel; }
    public void incRuleLevel() { ruleLevel++; }
    public void decRuleLevel() { ruleLevel--; }
    public CMinusParser(TokenStream input) {
        this(input, DebugEventSocketProxy.DEFAULT_DEBUGGER_PORT, new RecognizerSharedState());
    }
    public CMinusParser(TokenStream input, int port, RecognizerSharedState state) {
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

public CMinusParser(TokenStream input, DebugEventListener dbg) {
    super(input, dbg, new RecognizerSharedState());
}

protected boolean evalPredicate(boolean result, String predicate) {
    dbg.semanticPredicate(result, predicate);
    return result;
}

protected StringTemplateGroup templateLib =
  new StringTemplateGroup("CMinusParserTemplates", AngleBracketTemplateLexer.class);

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
    public String[] getTokenNames() { return CMinusParser.tokenNames; }
    public String getGrammarFileName() { return "/home/jpiat/Downloads/examples-v3/java/cminus/CMinus.g"; }


    protected static class program_scope {
        List globals;
        List functions;
    }
    protected Stack program_stack = new Stack();


    public static class program_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "program"
    // /home/jpiat/Downloads/examples-v3/java/cminus/CMinus.g:20:1: program : ( declaration )+ -> program(globals=$program::globalsfunctions=$program::functions);
    public final CMinusParser.program_return program() throws RecognitionException {
        program_stack.push(new program_scope());
        CMinusParser.program_return retval = new CMinusParser.program_return();
        retval.start = input.LT(1);



          ((program_scope)program_stack.peek()).globals = new ArrayList();
          ((program_scope)program_stack.peek()).functions = new ArrayList();

        try { dbg.enterRule(getGrammarFileName(), "program");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(20, 0);

        try {
            // /home/jpiat/Downloads/examples-v3/java/cminus/CMinus.g:29:5: ( ( declaration )+ -> program(globals=$program::globalsfunctions=$program::functions))
            dbg.enterAlt(1);

            // /home/jpiat/Downloads/examples-v3/java/cminus/CMinus.g:29:9: ( declaration )+
            {
            dbg.location(29,9);
            // /home/jpiat/Downloads/examples-v3/java/cminus/CMinus.g:29:9: ( declaration )+
            int cnt1=0;
            try { dbg.enterSubRule(1);

            loop1:
            do {
                int alt1=2;
                try { dbg.enterDecision(1, decisionCanBacktrack[1]);

                int LA1_0 = input.LA(1);

                if ( (LA1_0==ID||LA1_0==15||LA1_0==17) ) {
                    alt1=1;
                }


                } finally {dbg.exitDecision(1);}

                switch (alt1) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/jpiat/Downloads/examples-v3/java/cminus/CMinus.g:29:9: declaration
            	    {
            	    dbg.location(29,9);
            	    pushFollow(FOLLOW_declaration_in_program48);
            	    declaration();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        dbg.recognitionException(eee);

                        throw eee;
                }
                cnt1++;
            } while (true);
            } finally {dbg.exitSubRule(1);}


            // TEMPLATE REWRITE
            // 30:9: -> program(globals=$program::globalsfunctions=$program::functions)
            {
                retval.st = templateLib.getInstanceOf("program",new STAttrMap().put("globals", ((program_scope)program_stack.peek()).globals).put("functions", ((program_scope)program_stack.peek()).functions));
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
            program_stack.pop();
        }
        dbg.location(31, 4);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "program");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "program"


    public static class declaration_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "declaration"
    // /home/jpiat/Downloads/examples-v3/java/cminus/CMinus.g:33:1: declaration : ( variable |f= function );
    public final CMinusParser.declaration_return declaration() throws RecognitionException {
        CMinusParser.declaration_return retval = new CMinusParser.declaration_return();
        retval.start = input.LT(1);


        CMinusParser.function_return f =null;

        CMinusParser.variable_return variable1 =null;


        try { dbg.enterRule(getGrammarFileName(), "declaration");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(33, 0);

        try {
            // /home/jpiat/Downloads/examples-v3/java/cminus/CMinus.g:34:5: ( variable |f= function )
            int alt2=2;
            try { dbg.enterDecision(2, decisionCanBacktrack[2]);

            switch ( input.LA(1) ) {
            case 17:
                {
                int LA2_1 = input.LA(2);

                if ( (LA2_1==ID) ) {
                    int LA2_4 = input.LA(3);

                    if ( (LA2_4==11) ) {
                        alt2=1;
                    }
                    else if ( (LA2_4==7) ) {
                        alt2=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 2, 4, input);

                        dbg.recognitionException(nvae);
                        throw nvae;

                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 1, input);

                    dbg.recognitionException(nvae);
                    throw nvae;

                }
                }
                break;
            case 15:
                {
                int LA2_2 = input.LA(2);

                if ( (LA2_2==ID) ) {
                    int LA2_4 = input.LA(3);

                    if ( (LA2_4==11) ) {
                        alt2=1;
                    }
                    else if ( (LA2_4==7) ) {
                        alt2=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 2, 4, input);

                        dbg.recognitionException(nvae);
                        throw nvae;

                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 2, input);

                    dbg.recognitionException(nvae);
                    throw nvae;

                }
                }
                break;
            case ID:
                {
                int LA2_3 = input.LA(2);

                if ( (LA2_3==ID) ) {
                    int LA2_4 = input.LA(3);

                    if ( (LA2_4==11) ) {
                        alt2=1;
                    }
                    else if ( (LA2_4==7) ) {
                        alt2=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 2, 4, input);

                        dbg.recognitionException(nvae);
                        throw nvae;

                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 3, input);

                    dbg.recognitionException(nvae);
                    throw nvae;

                }
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;

            }

            } finally {dbg.exitDecision(2);}

            switch (alt2) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/jpiat/Downloads/examples-v3/java/cminus/CMinus.g:34:9: variable
                    {
                    dbg.location(34,9);
                    pushFollow(FOLLOW_variable_in_declaration89);
                    variable1=variable();

                    state._fsp--;

                    dbg.location(34,20);
                    ((program_scope)program_stack.peek()).globals.add((variable1!=null?variable1.st:null));

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /home/jpiat/Downloads/examples-v3/java/cminus/CMinus.g:35:9: f= function
                    {
                    dbg.location(35,10);
                    pushFollow(FOLLOW_function_in_declaration105);
                    f=function();

                    state._fsp--;

                    dbg.location(35,20);
                    ((program_scope)program_stack.peek()).functions.add((f!=null?f.st:null));

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
        dbg.location(36, 4);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "declaration");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "declaration"


    public static class variable_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "variable"
    // /home/jpiat/Downloads/examples-v3/java/cminus/CMinus.g:41:1: variable : type declarator ';' -> {$function.size()>0 && $function::name==null}? globalVariable(type=$type.stname=$declarator.st) -> variable(type=$type.stname=$declarator.st);
    public final CMinusParser.variable_return variable() throws RecognitionException {
        CMinusParser.variable_return retval = new CMinusParser.variable_return();
        retval.start = input.LT(1);


        CMinusParser.type_return type2 =null;

        CMinusParser.declarator_return declarator3 =null;


        try { dbg.enterRule(getGrammarFileName(), "variable");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(41, 0);

        try {
            // /home/jpiat/Downloads/examples-v3/java/cminus/CMinus.g:42:5: ( type declarator ';' -> {$function.size()>0 && $function::name==null}? globalVariable(type=$type.stname=$declarator.st) -> variable(type=$type.stname=$declarator.st))
            dbg.enterAlt(1);

            // /home/jpiat/Downloads/examples-v3/java/cminus/CMinus.g:42:9: type declarator ';'
            {
            dbg.location(42,9);
            pushFollow(FOLLOW_type_in_variable129);
            type2=type();

            state._fsp--;

            dbg.location(42,14);
            pushFollow(FOLLOW_declarator_in_variable131);
            declarator3=declarator();

            state._fsp--;

            dbg.location(42,25);
            match(input,11,FOLLOW_11_in_variable133); 

            // TEMPLATE REWRITE
            // 43:9: -> {$function.size()>0 && $function::name==null}? globalVariable(type=$type.stname=$declarator.st)
            if (function_stack.size()>0 && ((function_scope)function_stack.peek()).name==null) {
                retval.st = templateLib.getInstanceOf("globalVariable",new STAttrMap().put("type", (type2!=null?type2.st:null)).put("name", (declarator3!=null?declarator3.st:null)));
            }

            else // 45:9: -> variable(type=$type.stname=$declarator.st)
            {
                retval.st = templateLib.getInstanceOf("variable",new STAttrMap().put("type", (type2!=null?type2.st:null)).put("name", (declarator3!=null?declarator3.st:null)));
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
        dbg.location(46, 4);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "variable");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "variable"


    public static class declarator_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "declarator"
    // /home/jpiat/Downloads/examples-v3/java/cminus/CMinus.g:48:1: declarator : ID -> {new StringTemplate($ID.text)};
    public final CMinusParser.declarator_return declarator() throws RecognitionException {
        CMinusParser.declarator_return retval = new CMinusParser.declarator_return();
        retval.start = input.LT(1);


        Token ID4=null;

        try { dbg.enterRule(getGrammarFileName(), "declarator");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(48, 0);

        try {
            // /home/jpiat/Downloads/examples-v3/java/cminus/CMinus.g:49:5: ( ID -> {new StringTemplate($ID.text)})
            dbg.enterAlt(1);

            // /home/jpiat/Downloads/examples-v3/java/cminus/CMinus.g:49:9: ID
            {
            dbg.location(49,9);
            ID4=(Token)match(input,ID,FOLLOW_ID_in_declarator207); 

            // TEMPLATE REWRITE
            // 49:12: -> {new StringTemplate($ID.text)}
            {
                retval.st = new StringTemplate((ID4!=null?ID4.getText():null));
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
        dbg.location(50, 4);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "declarator");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "declarator"


    protected static class function_scope {
        String name;
    }
    protected Stack function_stack = new Stack();


    public static class function_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "function"
    // /home/jpiat/Downloads/examples-v3/java/cminus/CMinus.g:52:1: function : type ID '(' (p+= formalParameter ( ',' p+= formalParameter )* )? ')' block -> function(type=$type.stname=$function::namelocals=$slist::localsstats=$slist::statsargs=$p);
    public final CMinusParser.function_return function() throws RecognitionException {
        slist_stack.push(new slist_scope());
        function_stack.push(new function_scope());
        CMinusParser.function_return retval = new CMinusParser.function_return();
        retval.start = input.LT(1);


        Token ID5=null;
        List list_p=null;
        CMinusParser.type_return type6 =null;

        RuleReturnScope p = null;

          ((slist_scope)slist_stack.peek()).locals = new ArrayList();
          ((slist_scope)slist_stack.peek()).stats = new ArrayList();

        try { dbg.enterRule(getGrammarFileName(), "function");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(52, 0);

        try {
            // /home/jpiat/Downloads/examples-v3/java/cminus/CMinus.g:61:5: ( type ID '(' (p+= formalParameter ( ',' p+= formalParameter )* )? ')' block -> function(type=$type.stname=$function::namelocals=$slist::localsstats=$slist::statsargs=$p))
            dbg.enterAlt(1);

            // /home/jpiat/Downloads/examples-v3/java/cminus/CMinus.g:61:9: type ID '(' (p+= formalParameter ( ',' p+= formalParameter )* )? ')' block
            {
            dbg.location(61,9);
            pushFollow(FOLLOW_type_in_function244);
            type6=type();

            state._fsp--;

            dbg.location(61,14);
            ID5=(Token)match(input,ID,FOLLOW_ID_in_function246); 
            dbg.location(61,17);
            ((function_scope)function_stack.peek()).name =(ID5!=null?ID5.getText():null);
            dbg.location(62,9);
            match(input,7,FOLLOW_7_in_function258); 
            dbg.location(62,13);
            // /home/jpiat/Downloads/examples-v3/java/cminus/CMinus.g:62:13: (p+= formalParameter ( ',' p+= formalParameter )* )?
            int alt4=2;
            try { dbg.enterSubRule(4);
            try { dbg.enterDecision(4, decisionCanBacktrack[4]);

            int LA4_0 = input.LA(1);

            if ( (LA4_0==ID||LA4_0==15||LA4_0==17) ) {
                alt4=1;
            }
            } finally {dbg.exitDecision(4);}

            switch (alt4) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/jpiat/Downloads/examples-v3/java/cminus/CMinus.g:62:15: p+= formalParameter ( ',' p+= formalParameter )*
                    {
                    dbg.location(62,16);
                    pushFollow(FOLLOW_formalParameter_in_function264);
                    p=formalParameter();

                    state._fsp--;

                    if (list_p==null) list_p=new ArrayList();
                    list_p.add(p.getTemplate());

                    dbg.location(62,34);
                    // /home/jpiat/Downloads/examples-v3/java/cminus/CMinus.g:62:34: ( ',' p+= formalParameter )*
                    try { dbg.enterSubRule(3);

                    loop3:
                    do {
                        int alt3=2;
                        try { dbg.enterDecision(3, decisionCanBacktrack[3]);

                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==10) ) {
                            alt3=1;
                        }


                        } finally {dbg.exitDecision(3);}

                        switch (alt3) {
                    	case 1 :
                    	    dbg.enterAlt(1);

                    	    // /home/jpiat/Downloads/examples-v3/java/cminus/CMinus.g:62:36: ',' p+= formalParameter
                    	    {
                    	    dbg.location(62,36);
                    	    match(input,10,FOLLOW_10_in_function268); 
                    	    dbg.location(62,41);
                    	    pushFollow(FOLLOW_formalParameter_in_function272);
                    	    p=formalParameter();

                    	    state._fsp--;

                    	    if (list_p==null) list_p=new ArrayList();
                    	    list_p.add(p.getTemplate());


                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);
                    } finally {dbg.exitSubRule(3);}


                    }
                    break;

            }
            } finally {dbg.exitSubRule(4);}

            dbg.location(62,65);
            match(input,8,FOLLOW_8_in_function280); 
            dbg.location(63,9);
            pushFollow(FOLLOW_block_in_function290);
            block();

            state._fsp--;


            // TEMPLATE REWRITE
            // 64:9: -> function(type=$type.stname=$function::namelocals=$slist::localsstats=$slist::statsargs=$p)
            {
                retval.st = templateLib.getInstanceOf("function",new STAttrMap().put("type", (type6!=null?type6.st:null)).put("name", ((function_scope)function_stack.peek()).name).put("locals", ((slist_scope)slist_stack.peek()).locals).put("stats", ((slist_scope)slist_stack.peek()).stats).put("args", list_p));
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
            function_stack.pop();
        }
        dbg.location(68, 4);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "function");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "function"


    public static class formalParameter_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "formalParameter"
    // /home/jpiat/Downloads/examples-v3/java/cminus/CMinus.g:70:1: formalParameter : type declarator -> parameter(type=$type.stname=$declarator.st);
    public final CMinusParser.formalParameter_return formalParameter() throws RecognitionException {
        CMinusParser.formalParameter_return retval = new CMinusParser.formalParameter_return();
        retval.start = input.LT(1);


        CMinusParser.type_return type7 =null;

        CMinusParser.declarator_return declarator8 =null;


        try { dbg.enterRule(getGrammarFileName(), "formalParameter");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(70, 0);

        try {
            // /home/jpiat/Downloads/examples-v3/java/cminus/CMinus.g:71:5: ( type declarator -> parameter(type=$type.stname=$declarator.st))
            dbg.enterAlt(1);

            // /home/jpiat/Downloads/examples-v3/java/cminus/CMinus.g:71:9: type declarator
            {
            dbg.location(71,9);
            pushFollow(FOLLOW_type_in_formalParameter406);
            type7=type();

            state._fsp--;

            dbg.location(71,14);
            pushFollow(FOLLOW_declarator_in_formalParameter408);
            declarator8=declarator();

            state._fsp--;


            // TEMPLATE REWRITE
            // 72:9: -> parameter(type=$type.stname=$declarator.st)
            {
                retval.st = templateLib.getInstanceOf("parameter",new STAttrMap().put("type", (type7!=null?type7.st:null)).put("name", (declarator8!=null?declarator8.st:null)));
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
        dbg.location(73, 4);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "formalParameter");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "formalParameter"


    public static class type_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "type"
    // /home/jpiat/Downloads/examples-v3/java/cminus/CMinus.g:75:1: type : ( 'int' -> type_int(| 'char' -> type_char(| ID -> type_user_object(name=$ID.text));
    public final CMinusParser.type_return type() throws RecognitionException {
        CMinusParser.type_return retval = new CMinusParser.type_return();
        retval.start = input.LT(1);


        Token ID9=null;

        try { dbg.enterRule(getGrammarFileName(), "type");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(75, 0);

        try {
            // /home/jpiat/Downloads/examples-v3/java/cminus/CMinus.g:76:5: ( 'int' -> type_int(| 'char' -> type_char(| ID -> type_user_object(name=$ID.text))
            int alt5=3;
            try { dbg.enterDecision(5, decisionCanBacktrack[5]);

            switch ( input.LA(1) ) {
            case 17:
                {
                alt5=1;
                }
                break;
            case 15:
                {
                alt5=2;
                }
                break;
            case ID:
                {
                alt5=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;

            }

            } finally {dbg.exitDecision(5);}

            switch (alt5) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/jpiat/Downloads/examples-v3/java/cminus/CMinus.g:76:9: 'int'
                    {
                    dbg.location(76,9);
                    match(input,17,FOLLOW_17_in_type449); 

                    // TEMPLATE REWRITE
                    // 76:16: -> type_int(
                    {
                        retval.st = templateLib.getInstanceOf("type_int");
                    }



                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /home/jpiat/Downloads/examples-v3/java/cminus/CMinus.g:77:9: 'char'
                    {
                    dbg.location(77,9);
                    match(input,15,FOLLOW_15_in_type466); 

                    // TEMPLATE REWRITE
                    // 77:16: -> type_char(
                    {
                        retval.st = templateLib.getInstanceOf("type_char");
                    }



                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // /home/jpiat/Downloads/examples-v3/java/cminus/CMinus.g:78:9: ID
                    {
                    dbg.location(78,9);
                    ID9=(Token)match(input,ID,FOLLOW_ID_in_type482); 

                    // TEMPLATE REWRITE
                    // 78:16: -> type_user_object(name=$ID.text)
                    {
                        retval.st = templateLib.getInstanceOf("type_user_object",new STAttrMap().put("name", (ID9!=null?ID9.getText():null)));
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
        dbg.location(79, 4);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "type");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "type"


    public static class block_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "block"
    // /home/jpiat/Downloads/examples-v3/java/cminus/CMinus.g:81:1: block : '{' ( variable )* ( stat )* '}' ;
    public final CMinusParser.block_return block() throws RecognitionException {
        CMinusParser.block_return retval = new CMinusParser.block_return();
        retval.start = input.LT(1);


        CMinusParser.variable_return variable10 =null;

        CMinusParser.stat_return stat11 =null;


        try { dbg.enterRule(getGrammarFileName(), "block");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(81, 0);

        try {
            // /home/jpiat/Downloads/examples-v3/java/cminus/CMinus.g:82:5: ( '{' ( variable )* ( stat )* '}' )
            dbg.enterAlt(1);

            // /home/jpiat/Downloads/examples-v3/java/cminus/CMinus.g:82:8: '{' ( variable )* ( stat )* '}'
            {
            dbg.location(82,8);
            match(input,18,FOLLOW_18_in_block513); 
            dbg.location(83,8);
            // /home/jpiat/Downloads/examples-v3/java/cminus/CMinus.g:83:8: ( variable )*
            try { dbg.enterSubRule(6);

            loop6:
            do {
                int alt6=2;
                try { dbg.enterDecision(6, decisionCanBacktrack[6]);

                int LA6_0 = input.LA(1);

                if ( (LA6_0==ID) ) {
                    int LA6_2 = input.LA(2);

                    if ( (LA6_2==ID) ) {
                        alt6=1;
                    }


                }
                else if ( (LA6_0==15||LA6_0==17) ) {
                    alt6=1;
                }


                } finally {dbg.exitDecision(6);}

                switch (alt6) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/jpiat/Downloads/examples-v3/java/cminus/CMinus.g:83:10: variable
            	    {
            	    dbg.location(83,10);
            	    pushFollow(FOLLOW_variable_in_block524);
            	    variable10=variable();

            	    state._fsp--;

            	    dbg.location(83,19);
            	    ((slist_scope)slist_stack.peek()).locals.add((variable10!=null?variable10.st:null));

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);
            } finally {dbg.exitSubRule(6);}

            dbg.location(84,8);
            // /home/jpiat/Downloads/examples-v3/java/cminus/CMinus.g:84:8: ( stat )*
            try { dbg.enterSubRule(7);

            loop7:
            do {
                int alt7=2;
                try { dbg.enterDecision(7, decisionCanBacktrack[7]);

                int LA7_0 = input.LA(1);

                if ( ((LA7_0 >= ID && LA7_0 <= INT)||LA7_0==7||LA7_0==11||LA7_0==16||LA7_0==18) ) {
                    alt7=1;
                }


                } finally {dbg.exitDecision(7);}

                switch (alt7) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/jpiat/Downloads/examples-v3/java/cminus/CMinus.g:84:10: stat
            	    {
            	    dbg.location(84,10);
            	    pushFollow(FOLLOW_stat_in_block540);
            	    stat11=stat();

            	    state._fsp--;

            	    dbg.location(84,15);
            	    ((slist_scope)slist_stack.peek()).stats.add((stat11!=null?stat11.st:null));

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);
            } finally {dbg.exitSubRule(7);}

            dbg.location(85,8);
            match(input,19,FOLLOW_19_in_block553); 

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
        dbg.location(86, 4);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "block");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "block"


    public static class stat_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "stat"
    // /home/jpiat/Downloads/examples-v3/java/cminus/CMinus.g:88:1: stat : ( forStat -> {$forStat.st}| expr ';' -> statement(expr=$expr.st)| block -> statementList(locals=$slist::localsstats=$slist::stats)| assignStat ';' -> {$assignStat.st}| ';' -> {new StringTemplate(\";\")});
    public final CMinusParser.stat_return stat() throws RecognitionException {
        slist_stack.push(new slist_scope());

        CMinusParser.stat_return retval = new CMinusParser.stat_return();
        retval.start = input.LT(1);


        CMinusParser.forStat_return forStat12 =null;

        CMinusParser.expr_return expr13 =null;

        CMinusParser.assignStat_return assignStat14 =null;



          ((slist_scope)slist_stack.peek()).locals = new ArrayList();
          ((slist_scope)slist_stack.peek()).stats = new ArrayList();

        try { dbg.enterRule(getGrammarFileName(), "stat");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(88, 0);

        try {
            // /home/jpiat/Downloads/examples-v3/java/cminus/CMinus.g:94:5: ( forStat -> {$forStat.st}| expr ';' -> statement(expr=$expr.st)| block -> statementList(locals=$slist::localsstats=$slist::stats)| assignStat ';' -> {$assignStat.st}| ';' -> {new StringTemplate(\";\")})
            int alt8=5;
            try { dbg.enterDecision(8, decisionCanBacktrack[8]);

            switch ( input.LA(1) ) {
            case 16:
                {
                alt8=1;
                }
                break;
            case ID:
                {
                int LA8_2 = input.LA(2);

                if ( (LA8_2==13) ) {
                    alt8=4;
                }
                else if ( (LA8_2==9||(LA8_2 >= 11 && LA8_2 <= 12)||LA8_2==14) ) {
                    alt8=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 2, input);

                    dbg.recognitionException(nvae);
                    throw nvae;

                }
                }
                break;
            case INT:
            case 7:
                {
                alt8=2;
                }
                break;
            case 18:
                {
                alt8=3;
                }
                break;
            case 11:
                {
                alt8=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;

            }

            } finally {dbg.exitDecision(8);}

            switch (alt8) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/jpiat/Downloads/examples-v3/java/cminus/CMinus.g:94:7: forStat
                    {
                    dbg.location(94,7);
                    pushFollow(FOLLOW_forStat_in_stat580);
                    forStat12=forStat();

                    state._fsp--;


                    // TEMPLATE REWRITE
                    // 94:15: -> {$forStat.st}
                    {
                        retval.st = (forStat12!=null?forStat12.st:null);
                    }



                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /home/jpiat/Downloads/examples-v3/java/cminus/CMinus.g:95:7: expr ';'
                    {
                    dbg.location(95,7);
                    pushFollow(FOLLOW_expr_in_stat592);
                    expr13=expr();

                    state._fsp--;

                    dbg.location(95,12);
                    match(input,11,FOLLOW_11_in_stat594); 

                    // TEMPLATE REWRITE
                    // 95:16: -> statement(expr=$expr.st)
                    {
                        retval.st = templateLib.getInstanceOf("statement",new STAttrMap().put("expr", (expr13!=null?expr13.st:null)));
                    }



                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // /home/jpiat/Downloads/examples-v3/java/cminus/CMinus.g:96:7: block
                    {
                    dbg.location(96,7);
                    pushFollow(FOLLOW_block_in_stat611);
                    block();

                    state._fsp--;


                    // TEMPLATE REWRITE
                    // 96:13: -> statementList(locals=$slist::localsstats=$slist::stats)
                    {
                        retval.st = templateLib.getInstanceOf("statementList",new STAttrMap().put("locals", ((slist_scope)slist_stack.peek()).locals).put("stats", ((slist_scope)slist_stack.peek()).stats));
                    }



                    }
                    break;
                case 4 :
                    dbg.enterAlt(4);

                    // /home/jpiat/Downloads/examples-v3/java/cminus/CMinus.g:97:7: assignStat ';'
                    {
                    dbg.location(97,7);
                    pushFollow(FOLLOW_assignStat_in_stat633);
                    assignStat14=assignStat();

                    state._fsp--;

                    dbg.location(97,18);
                    match(input,11,FOLLOW_11_in_stat635); 

                    // TEMPLATE REWRITE
                    // 97:22: -> {$assignStat.st}
                    {
                        retval.st = (assignStat14!=null?assignStat14.st:null);
                    }



                    }
                    break;
                case 5 :
                    dbg.enterAlt(5);

                    // /home/jpiat/Downloads/examples-v3/java/cminus/CMinus.g:98:7: ';'
                    {
                    dbg.location(98,7);
                    match(input,11,FOLLOW_11_in_stat647); 

                    // TEMPLATE REWRITE
                    // 98:11: -> {new StringTemplate(\";\")}
                    {
                        retval.st = new StringTemplate(";");
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
            slist_stack.pop();

        }
        dbg.location(99, 4);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "stat");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "stat"


    public static class forStat_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "forStat"
    // /home/jpiat/Downloads/examples-v3/java/cminus/CMinus.g:101:1: forStat : 'for' '(' e1= assignStat ';' e2= expr ';' e3= assignStat ')' block -> forLoop(e1=$e1.ste2=$e2.ste3=$e3.stlocals=$slist::localsstats=$slist::stats);
    public final CMinusParser.forStat_return forStat() throws RecognitionException {
        slist_stack.push(new slist_scope());

        CMinusParser.forStat_return retval = new CMinusParser.forStat_return();
        retval.start = input.LT(1);


        CMinusParser.assignStat_return e1 =null;

        CMinusParser.expr_return e2 =null;

        CMinusParser.assignStat_return e3 =null;



          ((slist_scope)slist_stack.peek()).locals = new ArrayList();
          ((slist_scope)slist_stack.peek()).stats = new ArrayList();

        try { dbg.enterRule(getGrammarFileName(), "forStat");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(101, 0);

        try {
            // /home/jpiat/Downloads/examples-v3/java/cminus/CMinus.g:107:5: ( 'for' '(' e1= assignStat ';' e2= expr ';' e3= assignStat ')' block -> forLoop(e1=$e1.ste2=$e2.ste3=$e3.stlocals=$slist::localsstats=$slist::stats))
            dbg.enterAlt(1);

            // /home/jpiat/Downloads/examples-v3/java/cminus/CMinus.g:107:9: 'for' '(' e1= assignStat ';' e2= expr ';' e3= assignStat ')' block
            {
            dbg.location(107,9);
            match(input,16,FOLLOW_16_in_forStat680); 
            dbg.location(107,15);
            match(input,7,FOLLOW_7_in_forStat682); 
            dbg.location(107,21);
            pushFollow(FOLLOW_assignStat_in_forStat686);
            e1=assignStat();

            state._fsp--;

            dbg.location(107,33);
            match(input,11,FOLLOW_11_in_forStat688); 
            dbg.location(107,39);
            pushFollow(FOLLOW_expr_in_forStat692);
            e2=expr();

            state._fsp--;

            dbg.location(107,45);
            match(input,11,FOLLOW_11_in_forStat694); 
            dbg.location(107,51);
            pushFollow(FOLLOW_assignStat_in_forStat698);
            e3=assignStat();

            state._fsp--;

            dbg.location(107,63);
            match(input,8,FOLLOW_8_in_forStat700); 
            dbg.location(107,67);
            pushFollow(FOLLOW_block_in_forStat702);
            block();

            state._fsp--;


            // TEMPLATE REWRITE
            // 108:9: -> forLoop(e1=$e1.ste2=$e2.ste3=$e3.stlocals=$slist::localsstats=$slist::stats)
            {
                retval.st = templateLib.getInstanceOf("forLoop",new STAttrMap().put("e1", (e1!=null?e1.st:null)).put("e2", (e2!=null?e2.st:null)).put("e3", (e3!=null?e3.st:null)).put("locals", ((slist_scope)slist_stack.peek()).locals).put("stats", ((slist_scope)slist_stack.peek()).stats));
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
        dbg.location(110, 4);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "forStat");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "forStat"


    public static class assignStat_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "assignStat"
    // /home/jpiat/Downloads/examples-v3/java/cminus/CMinus.g:112:1: assignStat : ID '=' expr -> assign(lhs=$ID.textrhs=$expr.st);
    public final CMinusParser.assignStat_return assignStat() throws RecognitionException {
        CMinusParser.assignStat_return retval = new CMinusParser.assignStat_return();
        retval.start = input.LT(1);


        Token ID15=null;
        CMinusParser.expr_return expr16 =null;


        try { dbg.enterRule(getGrammarFileName(), "assignStat");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(112, 0);

        try {
            // /home/jpiat/Downloads/examples-v3/java/cminus/CMinus.g:113:5: ( ID '=' expr -> assign(lhs=$ID.textrhs=$expr.st))
            dbg.enterAlt(1);

            // /home/jpiat/Downloads/examples-v3/java/cminus/CMinus.g:113:9: ID '=' expr
            {
            dbg.location(113,9);
            ID15=(Token)match(input,ID,FOLLOW_ID_in_assignStat775); 
            dbg.location(113,12);
            match(input,13,FOLLOW_13_in_assignStat777); 
            dbg.location(113,16);
            pushFollow(FOLLOW_expr_in_assignStat779);
            expr16=expr();

            state._fsp--;


            // TEMPLATE REWRITE
            // 113:21: -> assign(lhs=$ID.textrhs=$expr.st)
            {
                retval.st = templateLib.getInstanceOf("assign",new STAttrMap().put("lhs", (ID15!=null?ID15.getText():null)).put("rhs", (expr16!=null?expr16.st:null)));
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
        dbg.location(114, 4);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "assignStat");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "assignStat"


    public static class expr_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "expr"
    // /home/jpiat/Downloads/examples-v3/java/cminus/CMinus.g:116:1: expr : condExpr -> {$condExpr.st};
    public final CMinusParser.expr_return expr() throws RecognitionException {
        CMinusParser.expr_return retval = new CMinusParser.expr_return();
        retval.start = input.LT(1);


        CMinusParser.condExpr_return condExpr17 =null;


        try { dbg.enterRule(getGrammarFileName(), "expr");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(116, 0);

        try {
            // /home/jpiat/Downloads/examples-v3/java/cminus/CMinus.g:116:5: ( condExpr -> {$condExpr.st})
            dbg.enterAlt(1);

            // /home/jpiat/Downloads/examples-v3/java/cminus/CMinus.g:116:9: condExpr
            {
            dbg.location(116,9);
            pushFollow(FOLLOW_condExpr_in_expr807);
            condExpr17=condExpr();

            state._fsp--;


            // TEMPLATE REWRITE
            // 116:18: -> {$condExpr.st}
            {
                retval.st = (condExpr17!=null?condExpr17.st:null);
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
        dbg.location(117, 4);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "expr");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "expr"


    public static class condExpr_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "condExpr"
    // /home/jpiat/Downloads/examples-v3/java/cminus/CMinus.g:119:1: condExpr : a= aexpr ( ( '==' b= aexpr -> equals(left=$a.stright=$b.st)| '<' b= aexpr -> lessThan(left=$a.stright=$b.st)) | -> {$a.st}) ;
    public final CMinusParser.condExpr_return condExpr() throws RecognitionException {
        CMinusParser.condExpr_return retval = new CMinusParser.condExpr_return();
        retval.start = input.LT(1);


        CMinusParser.aexpr_return a =null;

        CMinusParser.aexpr_return b =null;


        try { dbg.enterRule(getGrammarFileName(), "condExpr");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(119, 0);

        try {
            // /home/jpiat/Downloads/examples-v3/java/cminus/CMinus.g:120:5: (a= aexpr ( ( '==' b= aexpr -> equals(left=$a.stright=$b.st)| '<' b= aexpr -> lessThan(left=$a.stright=$b.st)) | -> {$a.st}) )
            dbg.enterAlt(1);

            // /home/jpiat/Downloads/examples-v3/java/cminus/CMinus.g:120:9: a= aexpr ( ( '==' b= aexpr -> equals(left=$a.stright=$b.st)| '<' b= aexpr -> lessThan(left=$a.stright=$b.st)) | -> {$a.st})
            {
            dbg.location(120,10);
            pushFollow(FOLLOW_aexpr_in_condExpr832);
            a=aexpr();

            state._fsp--;

            dbg.location(121,9);
            // /home/jpiat/Downloads/examples-v3/java/cminus/CMinus.g:121:9: ( ( '==' b= aexpr -> equals(left=$a.stright=$b.st)| '<' b= aexpr -> lessThan(left=$a.stright=$b.st)) | -> {$a.st})
            int alt10=2;
            try { dbg.enterSubRule(10);
            try { dbg.enterDecision(10, decisionCanBacktrack[10]);

            int LA10_0 = input.LA(1);

            if ( (LA10_0==12||LA10_0==14) ) {
                alt10=1;
            }
            else if ( (LA10_0==8||LA10_0==11) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;

            }
            } finally {dbg.exitDecision(10);}

            switch (alt10) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/jpiat/Downloads/examples-v3/java/cminus/CMinus.g:121:13: ( '==' b= aexpr -> equals(left=$a.stright=$b.st)| '<' b= aexpr -> lessThan(left=$a.stright=$b.st))
                    {
                    dbg.location(121,13);
                    // /home/jpiat/Downloads/examples-v3/java/cminus/CMinus.g:121:13: ( '==' b= aexpr -> equals(left=$a.stright=$b.st)| '<' b= aexpr -> lessThan(left=$a.stright=$b.st))
                    int alt9=2;
                    try { dbg.enterSubRule(9);
                    try { dbg.enterDecision(9, decisionCanBacktrack[9]);

                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==14) ) {
                        alt9=1;
                    }
                    else if ( (LA9_0==12) ) {
                        alt9=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 9, 0, input);

                        dbg.recognitionException(nvae);
                        throw nvae;

                    }
                    } finally {dbg.exitDecision(9);}

                    switch (alt9) {
                        case 1 :
                            dbg.enterAlt(1);

                            // /home/jpiat/Downloads/examples-v3/java/cminus/CMinus.g:121:16: '==' b= aexpr
                            {
                            dbg.location(121,16);
                            match(input,14,FOLLOW_14_in_condExpr849); 
                            dbg.location(121,22);
                            pushFollow(FOLLOW_aexpr_in_condExpr853);
                            b=aexpr();

                            state._fsp--;


                            // TEMPLATE REWRITE
                            // 121:29: -> equals(left=$a.stright=$b.st)
                            {
                                retval.st = templateLib.getInstanceOf("equals",new STAttrMap().put("left", (a!=null?a.st:null)).put("right", (b!=null?b.st:null)));
                            }



                            }
                            break;
                        case 2 :
                            dbg.enterAlt(2);

                            // /home/jpiat/Downloads/examples-v3/java/cminus/CMinus.g:122:16: '<' b= aexpr
                            {
                            dbg.location(122,16);
                            match(input,12,FOLLOW_12_in_condExpr883); 
                            dbg.location(122,21);
                            pushFollow(FOLLOW_aexpr_in_condExpr887);
                            b=aexpr();

                            state._fsp--;


                            // TEMPLATE REWRITE
                            // 122:30: -> lessThan(left=$a.stright=$b.st)
                            {
                                retval.st = templateLib.getInstanceOf("lessThan",new STAttrMap().put("left", (a!=null?a.st:null)).put("right", (b!=null?b.st:null)));
                            }



                            }
                            break;

                    }
                    } finally {dbg.exitSubRule(9);}


                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /home/jpiat/Downloads/examples-v3/java/cminus/CMinus.g:124:13: 
                    {
                    // TEMPLATE REWRITE
                    // 124:13: -> {$a.st}
                    {
                        retval.st = (a!=null?a.st:null);
                    }



                    }
                    break;

            }
            } finally {dbg.exitSubRule(10);}


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
        dbg.location(126, 4);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "condExpr");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "condExpr"


    public static class aexpr_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "aexpr"
    // /home/jpiat/Downloads/examples-v3/java/cminus/CMinus.g:128:1: aexpr : (a= atom -> {$a.st}) ( '+' b= atom -> add(left=$aexpr.stright=$b.st))* ;
    public final CMinusParser.aexpr_return aexpr() throws RecognitionException {
        CMinusParser.aexpr_return retval = new CMinusParser.aexpr_return();
        retval.start = input.LT(1);


        CMinusParser.atom_return a =null;

        CMinusParser.atom_return b =null;


        try { dbg.enterRule(getGrammarFileName(), "aexpr");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(128, 0);

        try {
            // /home/jpiat/Downloads/examples-v3/java/cminus/CMinus.g:129:5: ( (a= atom -> {$a.st}) ( '+' b= atom -> add(left=$aexpr.stright=$b.st))* )
            dbg.enterAlt(1);

            // /home/jpiat/Downloads/examples-v3/java/cminus/CMinus.g:129:9: (a= atom -> {$a.st}) ( '+' b= atom -> add(left=$aexpr.stright=$b.st))*
            {
            dbg.location(129,9);
            // /home/jpiat/Downloads/examples-v3/java/cminus/CMinus.g:129:9: (a= atom -> {$a.st})
            dbg.enterAlt(1);

            // /home/jpiat/Downloads/examples-v3/java/cminus/CMinus.g:129:10: a= atom
            {
            dbg.location(129,11);
            pushFollow(FOLLOW_atom_in_aexpr965);
            a=atom();

            state._fsp--;


            // TEMPLATE REWRITE
            // 129:17: -> {$a.st}
            {
                retval.st = (a!=null?a.st:null);
            }



            }

            dbg.location(130,9);
            // /home/jpiat/Downloads/examples-v3/java/cminus/CMinus.g:130:9: ( '+' b= atom -> add(left=$aexpr.stright=$b.st))*
            try { dbg.enterSubRule(11);

            loop11:
            do {
                int alt11=2;
                try { dbg.enterDecision(11, decisionCanBacktrack[11]);

                int LA11_0 = input.LA(1);

                if ( (LA11_0==9) ) {
                    alt11=1;
                }


                } finally {dbg.exitDecision(11);}

                switch (alt11) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/jpiat/Downloads/examples-v3/java/cminus/CMinus.g:130:11: '+' b= atom
            	    {
            	    dbg.location(130,11);
            	    match(input,9,FOLLOW_9_in_aexpr982); 
            	    dbg.location(130,16);
            	    pushFollow(FOLLOW_atom_in_aexpr986);
            	    b=atom();

            	    state._fsp--;


            	    // TEMPLATE REWRITE
            	    // 130:22: -> add(left=$aexpr.stright=$b.st)
            	    {
            	        retval.st = templateLib.getInstanceOf("add",new STAttrMap().put("left", retval.st).put("right", (b!=null?b.st:null)));
            	    }



            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);
            } finally {dbg.exitSubRule(11);}


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
        dbg.location(131, 4);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "aexpr");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "aexpr"


    public static class atom_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "atom"
    // /home/jpiat/Downloads/examples-v3/java/cminus/CMinus.g:133:1: atom : ( ID -> refVar(id=$ID.text)| INT -> iconst(value=$INT.text)| '(' expr ')' -> {$expr.st});
    public final CMinusParser.atom_return atom() throws RecognitionException {
        CMinusParser.atom_return retval = new CMinusParser.atom_return();
        retval.start = input.LT(1);


        Token ID18=null;
        Token INT19=null;
        CMinusParser.expr_return expr20 =null;


        try { dbg.enterRule(getGrammarFileName(), "atom");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(133, 0);

        try {
            // /home/jpiat/Downloads/examples-v3/java/cminus/CMinus.g:134:5: ( ID -> refVar(id=$ID.text)| INT -> iconst(value=$INT.text)| '(' expr ')' -> {$expr.st})
            int alt12=3;
            try { dbg.enterDecision(12, decisionCanBacktrack[12]);

            switch ( input.LA(1) ) {
            case ID:
                {
                alt12=1;
                }
                break;
            case INT:
                {
                alt12=2;
                }
                break;
            case 7:
                {
                alt12=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;

            }

            } finally {dbg.exitDecision(12);}

            switch (alt12) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/jpiat/Downloads/examples-v3/java/cminus/CMinus.g:134:7: ID
                    {
                    dbg.location(134,7);
                    ID18=(Token)match(input,ID,FOLLOW_ID_in_atom1020); 

                    // TEMPLATE REWRITE
                    // 134:10: -> refVar(id=$ID.text)
                    {
                        retval.st = templateLib.getInstanceOf("refVar",new STAttrMap().put("id", (ID18!=null?ID18.getText():null)));
                    }



                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /home/jpiat/Downloads/examples-v3/java/cminus/CMinus.g:135:7: INT
                    {
                    dbg.location(135,7);
                    INT19=(Token)match(input,INT,FOLLOW_INT_in_atom1037); 

                    // TEMPLATE REWRITE
                    // 135:11: -> iconst(value=$INT.text)
                    {
                        retval.st = templateLib.getInstanceOf("iconst",new STAttrMap().put("value", (INT19!=null?INT19.getText():null)));
                    }



                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // /home/jpiat/Downloads/examples-v3/java/cminus/CMinus.g:136:7: '(' expr ')'
                    {
                    dbg.location(136,7);
                    match(input,7,FOLLOW_7_in_atom1054); 
                    dbg.location(136,11);
                    pushFollow(FOLLOW_expr_in_atom1056);
                    expr20=expr();

                    state._fsp--;

                    dbg.location(136,16);
                    match(input,8,FOLLOW_8_in_atom1058); 

                    // TEMPLATE REWRITE
                    // 136:20: -> {$expr.st}
                    {
                        retval.st = (expr20!=null?expr20.st:null);
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
        dbg.location(137, 4);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "atom");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "atom"

    // Delegated rules


 

    public static final BitSet FOLLOW_declaration_in_program48 = new BitSet(new long[]{0x0000000000028012L});
    public static final BitSet FOLLOW_variable_in_declaration89 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_in_declaration105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_variable129 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_declarator_in_variable131 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_variable133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_declarator207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_function244 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_function246 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_7_in_function258 = new BitSet(new long[]{0x0000000000028110L});
    public static final BitSet FOLLOW_formalParameter_in_function264 = new BitSet(new long[]{0x0000000000000500L});
    public static final BitSet FOLLOW_10_in_function268 = new BitSet(new long[]{0x0000000000028010L});
    public static final BitSet FOLLOW_formalParameter_in_function272 = new BitSet(new long[]{0x0000000000000500L});
    public static final BitSet FOLLOW_8_in_function280 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_block_in_function290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_formalParameter406 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_declarator_in_formalParameter408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_type449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_type466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_type482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_block513 = new BitSet(new long[]{0x00000000000F88B0L});
    public static final BitSet FOLLOW_variable_in_block524 = new BitSet(new long[]{0x00000000000F88B0L});
    public static final BitSet FOLLOW_stat_in_block540 = new BitSet(new long[]{0x00000000000D08B0L});
    public static final BitSet FOLLOW_19_in_block553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_forStat_in_stat580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_stat592 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_stat594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_block_in_stat611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignStat_in_stat633 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_stat635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_stat647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_forStat680 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_7_in_forStat682 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_assignStat_in_forStat686 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_forStat688 = new BitSet(new long[]{0x00000000000000B0L});
    public static final BitSet FOLLOW_expr_in_forStat692 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_forStat694 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_assignStat_in_forStat698 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_8_in_forStat700 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_block_in_forStat702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_assignStat775 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_assignStat777 = new BitSet(new long[]{0x00000000000000B0L});
    public static final BitSet FOLLOW_expr_in_assignStat779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_condExpr_in_expr807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_aexpr_in_condExpr832 = new BitSet(new long[]{0x0000000000005002L});
    public static final BitSet FOLLOW_14_in_condExpr849 = new BitSet(new long[]{0x00000000000000B0L});
    public static final BitSet FOLLOW_aexpr_in_condExpr853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_condExpr883 = new BitSet(new long[]{0x00000000000000B0L});
    public static final BitSet FOLLOW_aexpr_in_condExpr887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_aexpr965 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_9_in_aexpr982 = new BitSet(new long[]{0x00000000000000B0L});
    public static final BitSet FOLLOW_atom_in_aexpr986 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_ID_in_atom1020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_atom1037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_7_in_atom1054 = new BitSet(new long[]{0x00000000000000B0L});
    public static final BitSet FOLLOW_expr_in_atom1056 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_8_in_atom1058 = new BitSet(new long[]{0x0000000000000002L});

}