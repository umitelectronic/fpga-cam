// $ANTLR 3.5 /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g 2013-02-19 11:49:09

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
@SuppressWarnings("all")
public class Systemc_basicParser extends DebugParser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "BIN", "COMMENT", "EQUAL", "FLOAT", 
		"GT", "HEX", "ID", "IFNDEF", "INCLUDE", "INT", "LT", "NOT", "OP", "SEMICOLON", 
		"SINGLE_LINE_COMMENT", "STRING_LITERAL", "WS", "'#'", "'&&'", "'('", "')'", 
		"'*'", "','", "'.'", "'.write('", "':'", "'::'", "'<<'", "'SC_CTOR'", 
		"'SC_METHOD('", "'SC_MODULE'", "'['", "'[]'", "']'", "'_rv'", "'bool'", 
		"'break'", "'case'", "'char'", "'concat('", "'default'", "'define'", "'else'", 
		"'endif'", "'enum'", "'float'", "'if'", "'int'", "'long'", "'negedge()'", 
		"'posedge()'", "'range('", "'read()'", "'sc_in'", "'sc_in_clk'", "'sc_in_resolved'", 
		"'sc_in_rv'", "'sc_inout'", "'sc_inout_resolved'", "'sc_inout_rv'", "'sc_logic'", 
		"'sc_lv'", "'sc_out'", "'sc_out_resolved'", "'sc_out_rv'", "'sc_signal'", 
		"'sc_uint'", "'sensitive'", "'short'", "'struct'", "'switch'", "'to_int()'", 
		"'to_uint()'", "'unsigned'", "'void'", "'while'", "'{'", "'||'", "'}'"
	};
	public static final int EOF=-1;
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
	public static final int T__78=78;
	public static final int T__79=79;
	public static final int T__80=80;
	public static final int T__81=81;
	public static final int T__82=82;
	public static final int BIN=4;
	public static final int COMMENT=5;
	public static final int EQUAL=6;
	public static final int FLOAT=7;
	public static final int GT=8;
	public static final int HEX=9;
	public static final int ID=10;
	public static final int IFNDEF=11;
	public static final int INCLUDE=12;
	public static final int INT=13;
	public static final int LT=14;
	public static final int NOT=15;
	public static final int OP=16;
	public static final int SEMICOLON=17;
	public static final int SINGLE_LINE_COMMENT=18;
	public static final int STRING_LITERAL=19;
	public static final int WS=20;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators

	protected static class slist_scope {
		List names;
		List stack;
	}
	protected Stack<slist_scope> slist_stack = new Stack<slist_scope>();


	public static final String[] ruleNames = new String[] {
		"invalidRule", "actor_method", "cconstruct", "actor_body", "otemplate", 
		"sc_signal", "logic_op", "port_type", "v_size_modifier", "assignement", 
		"cond", "name", "v_assignement", "array_of_value", "sc_inout", "if_construct", 
		"array_index", "assignement_value", "test", "sc_out", "block", "comp_op", 
		"v_signed_modifier", "var_value", "func_decl", "actor_body_elt", "flux", 
		"signal_dec", "sc_method", "func_call", "v_type", "cfile", "case_elt", 
		"var_name", "expression", "sc_clock", "test_express", "sensitive", "while_construct", 
		"declarations", "actor_method_decl", "enum_decl", "if_content", "variable_decl", 
		"sc_assignement", "link", "case_construct", "module_decl", "func_body", 
		"method", "fixed_size_array", "enclosed_expr", "func_arg", "signal_type", 
		"connection", "ctemplate", "actor", "module_body", "pre_processor", "sc_type", 
		"value", "var_comp", "sc_in", "define", "elsif_construct", "synpred1_Systemc_basic", 
		"scconstructor", "port_decl", "actor_inst"
	};

	public static final boolean[] decisionCanBacktrack = new boolean[] {
		false, // invalid decision
		false, false, false, false, false, false, false, false, false, false, 
		    false, false, false, false, false, false, false, false, false, false, 
		    false, false, false, false, false, false, false, false, false, false, 
		    false, false, false, false, false, false, false, false, false, false, 
		    false, false, false, false, false, false, false, false, false, false, 
		    false, false, false, false, false, false, true, false, false, false, 
		    false, false, false, false, false, false, false, false, false, false, 
		    false, false, false, false, false, false, false
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
	@SuppressWarnings("serial")
	public static class STAttrMap extends HashMap<String, Object> {
		public STAttrMap put(String attrName, Object value) {
			super.put(attrName, value);
			return this;
		}
	}
	@Override public String[] getTokenNames() { return Systemc_basicParser.tokenNames; }
	@Override public String getGrammarFileName() { return "/home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g"; }


	protected static class cfile_scope {
		HashMap functions;
		HashMap vars;
		HashMap type_obj;
		List constants;
		List typeDecl;
	}
	protected Stack<cfile_scope> cfile_stack = new Stack<cfile_scope>();

	public static class cfile_return extends ParserRuleReturnScope {
		public StringTemplate st;
		public Object getTemplate() { return st; }
		public String toString() { return st==null?null:st.toString(); }
	};


	// $ANTLR start "cfile"
	// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:57:1: cfile : ( pre_processor )* ( declarations[$cfile::vars, null, null,$cfile::typeDecl] )* module_decl SEMICOLON ( pre_processor | declarations[$cfile::vars, null, null,$cfile::typeDecl] )* -> file(entity=$module_decl.st);
	public final Systemc_basicParser.cfile_return cfile() throws  {
		cfile_stack.push(new cfile_scope());
		Systemc_basicParser.cfile_return retval = new Systemc_basicParser.cfile_return();
		retval.start = input.LT(1);

		ParserRuleReturnScope module_decl1 =null;


		  cfile_stack.peek().functions = new HashMap();
		  cfile_stack.peek().vars = new HashMap();
		   cfile_stack.peek().type_obj = new HashMap();
		   cfile_stack.peek().constants = new ArrayList();
		   cfile_stack.peek().typeDecl = new ArrayList();

		try { dbg.enterRule(getGrammarFileName(), "cfile");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(57, 0);

		try {
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:73:2: ( ( pre_processor )* ( declarations[$cfile::vars, null, null,$cfile::typeDecl] )* module_decl SEMICOLON ( pre_processor | declarations[$cfile::vars, null, null,$cfile::typeDecl] )* -> file(entity=$module_decl.st))
			dbg.enterAlt(1);

			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:74:3: ( pre_processor )* ( declarations[$cfile::vars, null, null,$cfile::typeDecl] )* module_decl SEMICOLON ( pre_processor | declarations[$cfile::vars, null, null,$cfile::typeDecl] )*
			{
			dbg.location(74,3);
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:74:3: ( pre_processor )*
			try { dbg.enterSubRule(1);

			loop1:
			while (true) {
				int alt1=2;
				try { dbg.enterDecision(1, decisionCanBacktrack[1]);

				int LA1_0 = input.LA(1);
				if ( (LA1_0==21) ) {
					alt1=1;
				}

				} finally {dbg.exitDecision(1);}

				switch (alt1) {
				case 1 :
					dbg.enterAlt(1);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:74:3: pre_processor
					{
					dbg.location(74,3);
					pushFollow(FOLLOW_pre_processor_in_cfile63);
					pre_processor();
					state._fsp--;
					if (state.failed) return retval;
					}
					break;

				default :
					break loop1;
				}
			}
			} finally {dbg.exitSubRule(1);}
			dbg.location(75,3);
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:75:3: ( declarations[$cfile::vars, null, null,$cfile::typeDecl] )*
			try { dbg.enterSubRule(2);

			loop2:
			while (true) {
				int alt2=2;
				try { dbg.enterDecision(2, decisionCanBacktrack[2]);

				int LA2_0 = input.LA(1);
				if ( (LA2_0==ID||LA2_0==32||LA2_0==39||LA2_0==42||(LA2_0 >= 48 && LA2_0 <= 49)||(LA2_0 >= 51 && LA2_0 <= 52)||(LA2_0 >= 57 && LA2_0 <= 70)||(LA2_0 >= 72 && LA2_0 <= 73)||(LA2_0 >= 77 && LA2_0 <= 78)) ) {
					alt2=1;
				}

				} finally {dbg.exitDecision(2);}

				switch (alt2) {
				case 1 :
					dbg.enterAlt(1);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:75:3: declarations[$cfile::vars, null, null,$cfile::typeDecl]
					{
					dbg.location(75,3);
					pushFollow(FOLLOW_declarations_in_cfile68);
					declarations(cfile_stack.peek().vars, null, null, cfile_stack.peek().typeDecl);
					state._fsp--;
					if (state.failed) return retval;
					}
					break;

				default :
					break loop2;
				}
			}
			} finally {dbg.exitSubRule(2);}
			dbg.location(76,3);
			pushFollow(FOLLOW_module_decl_in_cfile75);
			module_decl1=module_decl();
			state._fsp--;
			if (state.failed) return retval;dbg.location(76,15);
			match(input,SEMICOLON,FOLLOW_SEMICOLON_in_cfile77); if (state.failed) return retval;dbg.location(77,3);
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:77:3: ( pre_processor | declarations[$cfile::vars, null, null,$cfile::typeDecl] )*
			try { dbg.enterSubRule(3);

			loop3:
			while (true) {
				int alt3=3;
				try { dbg.enterDecision(3, decisionCanBacktrack[3]);

				int LA3_0 = input.LA(1);
				if ( (LA3_0==21) ) {
					alt3=1;
				}
				else if ( (LA3_0==ID||LA3_0==32||LA3_0==39||LA3_0==42||(LA3_0 >= 48 && LA3_0 <= 49)||(LA3_0 >= 51 && LA3_0 <= 52)||(LA3_0 >= 57 && LA3_0 <= 70)||(LA3_0 >= 72 && LA3_0 <= 73)||(LA3_0 >= 77 && LA3_0 <= 78)) ) {
					alt3=2;
				}

				} finally {dbg.exitDecision(3);}

				switch (alt3) {
				case 1 :
					dbg.enterAlt(1);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:77:4: pre_processor
					{
					dbg.location(77,4);
					pushFollow(FOLLOW_pre_processor_in_cfile82);
					pre_processor();
					state._fsp--;
					if (state.failed) return retval;
					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:78:3: declarations[$cfile::vars, null, null,$cfile::typeDecl]
					{
					dbg.location(78,3);
					pushFollow(FOLLOW_declarations_in_cfile86);
					declarations(cfile_stack.peek().vars, null, null, cfile_stack.peek().typeDecl);
					state._fsp--;
					if (state.failed) return retval;
					}
					break;

				default :
					break loop3;
				}
			}
			} finally {dbg.exitSubRule(3);}

			// TEMPLATE REWRITE
			if ( state.backtracking==0 ) {
			  // 79:2: -> file(entity=$module_decl.st)
			  {
			  	retval.st = templateLib.getInstanceOf("file",new STAttrMap().put("entity", (module_decl1!=null?((StringTemplate)module_decl1.getTemplate()):null)));
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
		dbg.location(80, 1);

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
	// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:82:1: pre_processor : '#' ( INCLUDE | define | IFNDEF | 'endif' ) ;
	public final Systemc_basicParser.pre_processor_return pre_processor() throws  {
		Systemc_basicParser.pre_processor_return retval = new Systemc_basicParser.pre_processor_return();
		retval.start = input.LT(1);

		ParserRuleReturnScope define2 =null;

		try { dbg.enterRule(getGrammarFileName(), "pre_processor");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(82, 0);

		try {
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:82:15: ( '#' ( INCLUDE | define | IFNDEF | 'endif' ) )
			dbg.enterAlt(1);

			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:82:17: '#' ( INCLUDE | define | IFNDEF | 'endif' )
			{
			dbg.location(82,17);
			match(input,21,FOLLOW_21_in_pre_processor111); if (state.failed) return retval;dbg.location(82,20);
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:82:20: ( INCLUDE | define | IFNDEF | 'endif' )
			int alt4=4;
			try { dbg.enterSubRule(4);
			try { dbg.enterDecision(4, decisionCanBacktrack[4]);

			switch ( input.LA(1) ) {
			case INCLUDE:
				{
				alt4=1;
				}
				break;
			case 45:
				{
				alt4=2;
				}
				break;
			case IFNDEF:
				{
				alt4=3;
				}
				break;
			case 47:
				{
				alt4=4;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}
			} finally {dbg.exitDecision(4);}

			switch (alt4) {
				case 1 :
					dbg.enterAlt(1);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:82:21: INCLUDE
					{
					dbg.location(82,21);
					match(input,INCLUDE,FOLLOW_INCLUDE_in_pre_processor113); if (state.failed) return retval;
					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:83:4: define
					{
					dbg.location(83,4);
					pushFollow(FOLLOW_define_in_pre_processor119);
					define2=define();
					state._fsp--;
					if (state.failed) return retval;dbg.location(83,11);
					if ( state.backtracking==0 ) { cfile_stack.peek().constants.add((define2!=null?((StringTemplate)define2.getTemplate()):null));}
					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:84:3: IFNDEF
					{
					dbg.location(84,3);
					match(input,IFNDEF,FOLLOW_IFNDEF_in_pre_processor125); if (state.failed) return retval;
					}
					break;
				case 4 :
					dbg.enterAlt(4);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:85:4: 'endif'
					{
					dbg.location(85,4);
					match(input,47,FOLLOW_47_in_pre_processor130); if (state.failed) return retval;
					}
					break;

			}
			} finally {dbg.exitSubRule(4);}

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
		dbg.location(86, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "pre_processor");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "pre_processor"


	public static class define_return extends ParserRuleReturnScope {
		public StringTemplate st;
		public Object getTemplate() { return st; }
		public String toString() { return st==null?null:st.toString(); }
	};


	// $ANTLR start "define"
	// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:87:1: define : 'define' ( WS )? (id= ID ) ( WS )? ( STRING_LITERAL | HEX -> hex_constant(name=$id.textval=$HEX.text.substring(2)size=$HEX.text.substring(2).length()*4)| INT -> int_constant(name=$id.textval=$INT.text))? ;
	public final Systemc_basicParser.define_return define() throws  {
		Systemc_basicParser.define_return retval = new Systemc_basicParser.define_return();
		retval.start = input.LT(1);

		Token id=null;
		Token HEX3=null;
		Token INT4=null;

		try { dbg.enterRule(getGrammarFileName(), "define");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(87, 0);

		try {
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:87:8: ( 'define' ( WS )? (id= ID ) ( WS )? ( STRING_LITERAL | HEX -> hex_constant(name=$id.textval=$HEX.text.substring(2)size=$HEX.text.substring(2).length()*4)| INT -> int_constant(name=$id.textval=$INT.text))? )
			dbg.enterAlt(1);

			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:88:3: 'define' ( WS )? (id= ID ) ( WS )? ( STRING_LITERAL | HEX -> hex_constant(name=$id.textval=$HEX.text.substring(2)size=$HEX.text.substring(2).length()*4)| INT -> int_constant(name=$id.textval=$INT.text))?
			{
			dbg.location(88,3);
			match(input,45,FOLLOW_45_in_define143); if (state.failed) return retval;dbg.location(88,12);
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:88:12: ( WS )?
			int alt5=2;
			try { dbg.enterSubRule(5);
			try { dbg.enterDecision(5, decisionCanBacktrack[5]);

			int LA5_0 = input.LA(1);
			if ( (LA5_0==WS) ) {
				alt5=1;
			}
			} finally {dbg.exitDecision(5);}

			switch (alt5) {
				case 1 :
					dbg.enterAlt(1);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:88:13: WS
					{
					dbg.location(88,13);
					match(input,WS,FOLLOW_WS_in_define146); if (state.failed) return retval;
					}
					break;

			}
			} finally {dbg.exitSubRule(5);}
			dbg.location(88,18);
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:88:18: (id= ID )
			dbg.enterAlt(1);

			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:88:19: id= ID
			{
			dbg.location(88,22);
			id=(Token)match(input,ID,FOLLOW_ID_in_define155); if (state.failed) return retval;
			}
			dbg.location(88,29);
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:88:29: ( WS )?
			int alt6=2;
			try { dbg.enterSubRule(6);
			try { dbg.enterDecision(6, decisionCanBacktrack[6]);

			int LA6_0 = input.LA(1);
			if ( (LA6_0==WS) ) {
				alt6=1;
			}
			} finally {dbg.exitDecision(6);}

			switch (alt6) {
				case 1 :
					dbg.enterAlt(1);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:88:30: WS
					{
					dbg.location(88,30);
					match(input,WS,FOLLOW_WS_in_define160); if (state.failed) return retval;
					}
					break;

			}
			} finally {dbg.exitSubRule(6);}
			dbg.location(88,35);
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:88:35: ( STRING_LITERAL | HEX -> hex_constant(name=$id.textval=$HEX.text.substring(2)size=$HEX.text.substring(2).length()*4)| INT -> int_constant(name=$id.textval=$INT.text))?
			int alt7=4;
			try { dbg.enterSubRule(7);
			try { dbg.enterDecision(7, decisionCanBacktrack[7]);

			switch ( input.LA(1) ) {
				case STRING_LITERAL:
					{
					alt7=1;
					}
					break;
				case HEX:
					{
					alt7=2;
					}
					break;
				case INT:
					{
					alt7=3;
					}
					break;
			}
			} finally {dbg.exitDecision(7);}

			switch (alt7) {
				case 1 :
					dbg.enterAlt(1);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:89:3: STRING_LITERAL
					{
					dbg.location(89,3);
					match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_define168); if (state.failed) return retval;
					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:90:5: HEX
					{
					dbg.location(90,5);
					HEX3=(Token)match(input,HEX,FOLLOW_HEX_in_define175); if (state.failed) return retval;
					// TEMPLATE REWRITE
					if ( state.backtracking==0 ) {
					  // 90:9: -> hex_constant(name=$id.textval=$HEX.text.substring(2)size=$HEX.text.substring(2).length()*4)
					  {
					  	retval.st = templateLib.getInstanceOf("hex_constant",new STAttrMap().put("name", (id!=null?id.getText():null)).put("val", (HEX3!=null?HEX3.getText():null).substring(2)).put("size", (HEX3!=null?HEX3.getText():null).substring(2).length()*4));
					  }


					}

					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:91:5: INT
					{
					dbg.location(91,5);
					INT4=(Token)match(input,INT,FOLLOW_INT_in_define207); if (state.failed) return retval;
					// TEMPLATE REWRITE
					if ( state.backtracking==0 ) {
					  // 91:9: -> int_constant(name=$id.textval=$INT.text)
					  {
					  	retval.st = templateLib.getInstanceOf("int_constant",new STAttrMap().put("name", (id!=null?id.getText():null)).put("val", (INT4!=null?INT4.getText():null)));
					  }


					}

					}
					break;

			}
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
		dbg.location(93, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "define");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "define"


	protected static class module_decl_scope {
		List ports;
		List signals;
		HashMap processes;
		HashMap connections;
		HashMap obj_type;
		HashMap type_obj;
		HashMap mod_type;
	}
	protected Stack<module_decl_scope> module_decl_stack = new Stack<module_decl_scope>();

	public static class module_decl_return extends ParserRuleReturnScope {
		public StringTemplate st;
		public Object getTemplate() { return st; }
		public String toString() { return st==null?null:st.toString(); }
	};


	// $ANTLR start "module_decl"
	// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:95:1: module_decl : 'SC_MODULE' '(' ID ')' '{' module_body '}' -> entity(name=$ID.textports=$module_decl::portssignals=$module_decl::signalstype_decl=$cfile::typeDeclvariables=$module_decl::obj_typeprocess=$module_decl::processesstructure= $module_decl::connectionsinstances=$module_decl::mod_typefunctions=$cfile::functionsconstants=$cfile::constants);
	public final Systemc_basicParser.module_decl_return module_decl() throws  {
		module_decl_stack.push(new module_decl_scope());
		Systemc_basicParser.module_decl_return retval = new Systemc_basicParser.module_decl_return();
		retval.start = input.LT(1);

		Token ID5=null;


		  module_decl_stack.peek().ports = new ArrayList();
		  module_decl_stack.peek().processes = new HashMap();
		  module_decl_stack.peek().signals = new ArrayList();
		  module_decl_stack.peek().connections = new HashMap();
		  module_decl_stack.peek().obj_type = new HashMap();
		  module_decl_stack.peek().mod_type = new HashMap();

		try { dbg.enterRule(getGrammarFileName(), "module_decl");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(95, 0);

		try {
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:113:5: ( 'SC_MODULE' '(' ID ')' '{' module_body '}' -> entity(name=$ID.textports=$module_decl::portssignals=$module_decl::signalstype_decl=$cfile::typeDeclvariables=$module_decl::obj_typeprocess=$module_decl::processesstructure= $module_decl::connectionsinstances=$module_decl::mod_typefunctions=$cfile::functionsconstants=$cfile::constants))
			dbg.enterAlt(1);

			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:113:9: 'SC_MODULE' '(' ID ')' '{' module_body '}'
			{
			dbg.location(113,9);
			match(input,34,FOLLOW_34_in_module_decl256); if (state.failed) return retval;dbg.location(113,21);
			match(input,23,FOLLOW_23_in_module_decl258); if (state.failed) return retval;dbg.location(113,25);
			ID5=(Token)match(input,ID,FOLLOW_ID_in_module_decl260); if (state.failed) return retval;dbg.location(113,28);
			match(input,24,FOLLOW_24_in_module_decl262); if (state.failed) return retval;dbg.location(113,32);
			match(input,80,FOLLOW_80_in_module_decl264); if (state.failed) return retval;dbg.location(114,9);
			pushFollow(FOLLOW_module_body_in_module_decl274);
			module_body();
			state._fsp--;
			if (state.failed) return retval;dbg.location(115,9);
			match(input,82,FOLLOW_82_in_module_decl284); if (state.failed) return retval;
			// TEMPLATE REWRITE
			if ( state.backtracking==0 ) {
			  // 116:9: -> entity(name=$ID.textports=$module_decl::portssignals=$module_decl::signalstype_decl=$cfile::typeDeclvariables=$module_decl::obj_typeprocess=$module_decl::processesstructure= $module_decl::connectionsinstances=$module_decl::mod_typefunctions=$cfile::functionsconstants=$cfile::constants)
			  {
			  	retval.st = templateLib.getInstanceOf("entity",new STAttrMap().put("name", (ID5!=null?ID5.getText():null)).put("ports", module_decl_stack.peek().ports).put("signals", module_decl_stack.peek().signals).put("type_decl", cfile_stack.peek().typeDecl).put("variables", module_decl_stack.peek().obj_type).put("process", module_decl_stack.peek().processes).put("structure",  module_decl_stack.peek().connections).put("instances", module_decl_stack.peek().mod_type).put("functions", cfile_stack.peek().functions).put("constants", cfile_stack.peek().constants));
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
		dbg.location(127, 4);

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
	// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:130:1: module_body : ( declarations[$module_decl::obj_type, $module_decl::ports, $module_decl::signals, $cfile::typeDecl] )+ ;
	public final Systemc_basicParser.module_body_return module_body() throws  {
		Systemc_basicParser.module_body_return retval = new Systemc_basicParser.module_body_return();
		retval.start = input.LT(1);

		try { dbg.enterRule(getGrammarFileName(), "module_body");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(130, 0);

		try {
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:131:2: ( ( declarations[$module_decl::obj_type, $module_decl::ports, $module_decl::signals, $cfile::typeDecl] )+ )
			dbg.enterAlt(1);

			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:131:4: ( declarations[$module_decl::obj_type, $module_decl::ports, $module_decl::signals, $cfile::typeDecl] )+
			{
			dbg.location(131,4);
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:131:4: ( declarations[$module_decl::obj_type, $module_decl::ports, $module_decl::signals, $cfile::typeDecl] )+
			int cnt8=0;
			try { dbg.enterSubRule(8);

			loop8:
			while (true) {
				int alt8=2;
				try { dbg.enterDecision(8, decisionCanBacktrack[8]);

				int LA8_0 = input.LA(1);
				if ( (LA8_0==ID||LA8_0==32||LA8_0==39||LA8_0==42||(LA8_0 >= 48 && LA8_0 <= 49)||(LA8_0 >= 51 && LA8_0 <= 52)||(LA8_0 >= 57 && LA8_0 <= 70)||(LA8_0 >= 72 && LA8_0 <= 73)||(LA8_0 >= 77 && LA8_0 <= 78)) ) {
					alt8=1;
				}

				} finally {dbg.exitDecision(8);}

				switch (alt8) {
				case 1 :
					dbg.enterAlt(1);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:131:4: declarations[$module_decl::obj_type, $module_decl::ports, $module_decl::signals, $cfile::typeDecl]
					{
					dbg.location(131,4);
					pushFollow(FOLLOW_declarations_in_module_body468);
					declarations(module_decl_stack.peek().obj_type, module_decl_stack.peek().ports, module_decl_stack.peek().signals, cfile_stack.peek().typeDecl);
					state._fsp--;
					if (state.failed) return retval;
					}
					break;

				default :
					if ( cnt8 >= 1 ) break loop8;
					if (state.backtracking>0) {state.failed=true; return retval;}
					EarlyExitException eee = new EarlyExitException(8, input);
					dbg.recognitionException(eee);

					throw eee;
				}
				cnt8++;
			}
			} finally {dbg.exitSubRule(8);}

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
		dbg.location(132, 1);

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
	// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:134:1: declarations[HashMap vars, List ports, List signals, List typeDecl] : ( port_decl SEMICOLON | signal_dec SEMICOLON | enum_decl SEMICOLON | variable_decl[$vars] SEMICOLON | func_decl ( SEMICOLON )? | actor ) ;
	public final Systemc_basicParser.declarations_return declarations(HashMap vars, List ports, List signals, List typeDecl) throws  {
		Systemc_basicParser.declarations_return retval = new Systemc_basicParser.declarations_return();
		retval.start = input.LT(1);

		ParserRuleReturnScope port_decl6 =null;
		ParserRuleReturnScope signal_dec7 =null;
		ParserRuleReturnScope enum_decl8 =null;

		try { dbg.enterRule(getGrammarFileName(), "declarations");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(134, 0);

		try {
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:135:2: ( ( port_decl SEMICOLON | signal_dec SEMICOLON | enum_decl SEMICOLON | variable_decl[$vars] SEMICOLON | func_decl ( SEMICOLON )? | actor ) )
			dbg.enterAlt(1);

			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:136:2: ( port_decl SEMICOLON | signal_dec SEMICOLON | enum_decl SEMICOLON | variable_decl[$vars] SEMICOLON | func_decl ( SEMICOLON )? | actor )
			{
			dbg.location(136,2);
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:136:2: ( port_decl SEMICOLON | signal_dec SEMICOLON | enum_decl SEMICOLON | variable_decl[$vars] SEMICOLON | func_decl ( SEMICOLON )? | actor )
			int alt10=6;
			try { dbg.enterSubRule(10);
			try { dbg.enterDecision(10, decisionCanBacktrack[10]);

			try {
				isCyclicDecision = true;
				alt10 = dfa10.predict(input);
			}
			catch (NoViableAltException nvae) {
				dbg.recognitionException(nvae);
				throw nvae;
			}
			} finally {dbg.exitDecision(10);}

			switch (alt10) {
				case 1 :
					dbg.enterAlt(1);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:136:3: port_decl SEMICOLON
					{
					dbg.location(136,3);
					pushFollow(FOLLOW_port_decl_in_declarations486);
					port_decl6=port_decl();
					state._fsp--;
					if (state.failed) return retval;dbg.location(136,13);
					match(input,SEMICOLON,FOLLOW_SEMICOLON_in_declarations488); if (state.failed) return retval;dbg.location(136,24);
					if ( state.backtracking==0 ) {  ports.add((port_decl6!=null?((StringTemplate)port_decl6.getTemplate()):null));}
					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:137:4: signal_dec SEMICOLON
					{
					dbg.location(137,4);
					pushFollow(FOLLOW_signal_dec_in_declarations496);
					signal_dec7=signal_dec();
					state._fsp--;
					if (state.failed) return retval;dbg.location(137,15);
					match(input,SEMICOLON,FOLLOW_SEMICOLON_in_declarations498); if (state.failed) return retval;dbg.location(137,25);
					if ( state.backtracking==0 ) {  signals.add((signal_dec7!=null?((StringTemplate)signal_dec7.getTemplate()):null));}
					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:138:4: enum_decl SEMICOLON
					{
					dbg.location(138,4);
					pushFollow(FOLLOW_enum_decl_in_declarations505);
					enum_decl8=enum_decl();
					state._fsp--;
					if (state.failed) return retval;dbg.location(138,14);
					match(input,SEMICOLON,FOLLOW_SEMICOLON_in_declarations507); if (state.failed) return retval;dbg.location(138,24);
					if ( state.backtracking==0 ) {  typeDecl.add((enum_decl8!=null?((StringTemplate)enum_decl8.getTemplate()):null));}
					}
					break;
				case 4 :
					dbg.enterAlt(4);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:139:4: variable_decl[$vars] SEMICOLON
					{
					dbg.location(139,4);
					pushFollow(FOLLOW_variable_decl_in_declarations514);
					variable_decl(vars);
					state._fsp--;
					if (state.failed) return retval;dbg.location(139,25);
					match(input,SEMICOLON,FOLLOW_SEMICOLON_in_declarations517); if (state.failed) return retval;
					}
					break;
				case 5 :
					dbg.enterAlt(5);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:140:4: func_decl ( SEMICOLON )?
					{
					dbg.location(140,4);
					pushFollow(FOLLOW_func_decl_in_declarations522);
					func_decl();
					state._fsp--;
					if (state.failed) return retval;dbg.location(140,14);
					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:140:14: ( SEMICOLON )?
					int alt9=2;
					try { dbg.enterSubRule(9);
					try { dbg.enterDecision(9, decisionCanBacktrack[9]);

					int LA9_0 = input.LA(1);
					if ( (LA9_0==SEMICOLON) ) {
						alt9=1;
					}
					} finally {dbg.exitDecision(9);}

					switch (alt9) {
						case 1 :
							dbg.enterAlt(1);

							// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:140:14: SEMICOLON
							{
							dbg.location(140,14);
							match(input,SEMICOLON,FOLLOW_SEMICOLON_in_declarations524); if (state.failed) return retval;
							}
							break;

					}
					} finally {dbg.exitSubRule(9);}

					}
					break;
				case 6 :
					dbg.enterAlt(6);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:141:4: actor
					{
					dbg.location(141,4);
					pushFollow(FOLLOW_actor_in_declarations530);
					actor();
					state._fsp--;
					if (state.failed) return retval;
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
		dbg.location(142, 1);

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
	// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:145:1: func_decl : ( ( v_type (class_name= ID '::' )? ) func= ID ( '(' ( ( v_type ID ( ',' v_type ID )* )? ) ')' ) ) ( func_body )? ;
	public final Systemc_basicParser.func_decl_return func_decl() throws  {
		Systemc_basicParser.func_decl_return retval = new Systemc_basicParser.func_decl_return();
		retval.start = input.LT(1);

		Token class_name=null;
		Token func=null;
		ParserRuleReturnScope func_body9 =null;

		try { dbg.enterRule(getGrammarFileName(), "func_decl");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(145, 0);

		try {
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:145:11: ( ( ( v_type (class_name= ID '::' )? ) func= ID ( '(' ( ( v_type ID ( ',' v_type ID )* )? ) ')' ) ) ( func_body )? )
			dbg.enterAlt(1);

			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:146:2: ( ( v_type (class_name= ID '::' )? ) func= ID ( '(' ( ( v_type ID ( ',' v_type ID )* )? ) ')' ) ) ( func_body )?
			{
			dbg.location(146,2);
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:146:2: ( ( v_type (class_name= ID '::' )? ) func= ID ( '(' ( ( v_type ID ( ',' v_type ID )* )? ) ')' ) )
			dbg.enterAlt(1);

			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:146:3: ( v_type (class_name= ID '::' )? ) func= ID ( '(' ( ( v_type ID ( ',' v_type ID )* )? ) ')' )
			{
			dbg.location(146,3);
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:146:3: ( v_type (class_name= ID '::' )? )
			dbg.enterAlt(1);

			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:146:4: v_type (class_name= ID '::' )?
			{
			dbg.location(146,4);
			pushFollow(FOLLOW_v_type_in_func_decl546);
			v_type();
			state._fsp--;
			if (state.failed) return retval;dbg.location(146,11);
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:146:11: (class_name= ID '::' )?
			int alt11=2;
			try { dbg.enterSubRule(11);
			try { dbg.enterDecision(11, decisionCanBacktrack[11]);

			int LA11_0 = input.LA(1);
			if ( (LA11_0==ID) ) {
				int LA11_1 = input.LA(2);
				if ( (LA11_1==30) ) {
					alt11=1;
				}
			}
			} finally {dbg.exitDecision(11);}

			switch (alt11) {
				case 1 :
					dbg.enterAlt(1);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:146:12: class_name= ID '::'
					{
					dbg.location(146,22);
					class_name=(Token)match(input,ID,FOLLOW_ID_in_func_decl551); if (state.failed) return retval;dbg.location(146,25);
					match(input,30,FOLLOW_30_in_func_decl552); if (state.failed) return retval;
					}
					break;

			}
			} finally {dbg.exitSubRule(11);}

			}
			dbg.location(146,36);
			func=(Token)match(input,ID,FOLLOW_ID_in_func_decl558); if (state.failed) return retval;dbg.location(146,39);
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:146:39: ( '(' ( ( v_type ID ( ',' v_type ID )* )? ) ')' )
			dbg.enterAlt(1);

			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:146:40: '(' ( ( v_type ID ( ',' v_type ID )* )? ) ')'
			{
			dbg.location(146,40);
			match(input,23,FOLLOW_23_in_func_decl560); if (state.failed) return retval;dbg.location(146,43);
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:146:43: ( ( v_type ID ( ',' v_type ID )* )? )
			dbg.enterAlt(1);

			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:146:44: ( v_type ID ( ',' v_type ID )* )?
			{
			dbg.location(146,44);
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:146:44: ( v_type ID ( ',' v_type ID )* )?
			int alt13=2;
			try { dbg.enterSubRule(13);
			try { dbg.enterDecision(13, decisionCanBacktrack[13]);

			int LA13_0 = input.LA(1);
			if ( (LA13_0==ID||LA13_0==39||LA13_0==42||LA13_0==49||(LA13_0 >= 51 && LA13_0 <= 52)||(LA13_0 >= 64 && LA13_0 <= 65)||LA13_0==70||(LA13_0 >= 72 && LA13_0 <= 73)||(LA13_0 >= 77 && LA13_0 <= 78)) ) {
				alt13=1;
			}
			} finally {dbg.exitDecision(13);}

			switch (alt13) {
				case 1 :
					dbg.enterAlt(1);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:146:45: v_type ID ( ',' v_type ID )*
					{
					dbg.location(146,45);
					pushFollow(FOLLOW_v_type_in_func_decl563);
					v_type();
					state._fsp--;
					if (state.failed) return retval;dbg.location(146,52);
					match(input,ID,FOLLOW_ID_in_func_decl565); if (state.failed) return retval;dbg.location(146,55);
					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:146:55: ( ',' v_type ID )*
					try { dbg.enterSubRule(12);

					loop12:
					while (true) {
						int alt12=2;
						try { dbg.enterDecision(12, decisionCanBacktrack[12]);

						int LA12_0 = input.LA(1);
						if ( (LA12_0==26) ) {
							alt12=1;
						}

						} finally {dbg.exitDecision(12);}

						switch (alt12) {
						case 1 :
							dbg.enterAlt(1);

							// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:146:56: ',' v_type ID
							{
							dbg.location(146,56);
							match(input,26,FOLLOW_26_in_func_decl568); if (state.failed) return retval;dbg.location(146,59);
							pushFollow(FOLLOW_v_type_in_func_decl569);
							v_type();
							state._fsp--;
							if (state.failed) return retval;dbg.location(146,66);
							match(input,ID,FOLLOW_ID_in_func_decl571); if (state.failed) return retval;
							}
							break;

						default :
							break loop12;
						}
					}
					} finally {dbg.exitSubRule(12);}

					}
					break;

			}
			} finally {dbg.exitSubRule(13);}

			}
			dbg.location(146,73);
			match(input,24,FOLLOW_24_in_func_decl577); if (state.failed) return retval;
			}

			}
			dbg.location(146,79);
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:146:79: ( func_body )?
			int alt14=2;
			try { dbg.enterSubRule(14);
			try { dbg.enterDecision(14, decisionCanBacktrack[14]);

			int LA14_0 = input.LA(1);
			if ( (LA14_0==80) ) {
				alt14=1;
			}
			} finally {dbg.exitDecision(14);}

			switch (alt14) {
				case 1 :
					dbg.enterAlt(1);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:146:80: func_body
					{
					dbg.location(146,80);
					pushFollow(FOLLOW_func_body_in_func_decl582);
					func_body9=func_body();
					state._fsp--;
					if (state.failed) return retval;
					}
					break;

			}
			} finally {dbg.exitSubRule(14);}
			dbg.location(146,93);
			if ( state.backtracking==0 ) { cfile_stack.peek().functions.put((func!=null?func.getText():null), (func_body9!=null?((StringTemplate)func_body9.getTemplate()):null));}
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
		dbg.location(147, 1);

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
	// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:149:1: enum_decl : 'enum' ID '{' name ( ',' name )* '}' -> enum(name=$ID.textmembers=$slist::names);
	public final Systemc_basicParser.enum_decl_return enum_decl() throws  {
		slist_stack.push(new slist_scope());

		Systemc_basicParser.enum_decl_return retval = new Systemc_basicParser.enum_decl_return();
		retval.start = input.LT(1);

		Token ID10=null;


		  slist_stack.peek().names = new ArrayList();

		try { dbg.enterRule(getGrammarFileName(), "enum_decl");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(149, 0);

		try {
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:154:2: ( 'enum' ID '{' name ( ',' name )* '}' -> enum(name=$ID.textmembers=$slist::names))
			dbg.enterAlt(1);

			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:156:2: 'enum' ID '{' name ( ',' name )* '}'
			{
			dbg.location(156,2);
			match(input,48,FOLLOW_48_in_enum_decl610); if (state.failed) return retval;dbg.location(156,9);
			ID10=(Token)match(input,ID,FOLLOW_ID_in_enum_decl612); if (state.failed) return retval;dbg.location(156,12);
			match(input,80,FOLLOW_80_in_enum_decl614); if (state.failed) return retval;dbg.location(156,16);
			pushFollow(FOLLOW_name_in_enum_decl616);
			name();
			state._fsp--;
			if (state.failed) return retval;dbg.location(156,21);
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:156:21: ( ',' name )*
			try { dbg.enterSubRule(15);

			loop15:
			while (true) {
				int alt15=2;
				try { dbg.enterDecision(15, decisionCanBacktrack[15]);

				int LA15_0 = input.LA(1);
				if ( (LA15_0==26) ) {
					alt15=1;
				}

				} finally {dbg.exitDecision(15);}

				switch (alt15) {
				case 1 :
					dbg.enterAlt(1);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:156:22: ',' name
					{
					dbg.location(156,22);
					match(input,26,FOLLOW_26_in_enum_decl619); if (state.failed) return retval;dbg.location(156,26);
					pushFollow(FOLLOW_name_in_enum_decl621);
					name();
					state._fsp--;
					if (state.failed) return retval;
					}
					break;

				default :
					break loop15;
				}
			}
			} finally {dbg.exitSubRule(15);}
			dbg.location(156,33);
			match(input,82,FOLLOW_82_in_enum_decl625); if (state.failed) return retval;
			// TEMPLATE REWRITE
			if ( state.backtracking==0 ) {
			  // 156:37: -> enum(name=$ID.textmembers=$slist::names)
			  {
			  	retval.st = templateLib.getInstanceOf("enum",new STAttrMap().put("name", (ID10!=null?ID10.getText():null)).put("members", slist_stack.peek().names));
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
		dbg.location(157, 1);

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
	// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:159:1: variable_decl[HashMap vars] : v_type ( '*' | '[]' )* n= ID ( ',' elt= ID )* ( fixed_size_array )* ( assignement )? ;
	public final Systemc_basicParser.variable_decl_return variable_decl(HashMap vars) throws  {
		Systemc_basicParser.variable_decl_return retval = new Systemc_basicParser.variable_decl_return();
		retval.start = input.LT(1);

		Token n=null;
		Token elt=null;
		ParserRuleReturnScope v_type11 =null;

		try { dbg.enterRule(getGrammarFileName(), "variable_decl");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(159, 0);

		try {
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:159:29: ( v_type ( '*' | '[]' )* n= ID ( ',' elt= ID )* ( fixed_size_array )* ( assignement )? )
			dbg.enterAlt(1);

			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:160:2: v_type ( '*' | '[]' )* n= ID ( ',' elt= ID )* ( fixed_size_array )* ( assignement )?
			{
			dbg.location(160,2);
			pushFollow(FOLLOW_v_type_in_variable_decl653);
			v_type11=v_type();
			state._fsp--;
			if (state.failed) return retval;dbg.location(160,9);
			if ( state.backtracking==0 ) { vars.put((v_type11!=null?input.toString(v_type11.start,v_type11.stop):null), new ArrayList());}dbg.location(161,3);
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:161:3: ( '*' | '[]' )*
			try { dbg.enterSubRule(16);

			loop16:
			while (true) {
				int alt16=2;
				try { dbg.enterDecision(16, decisionCanBacktrack[16]);

				int LA16_0 = input.LA(1);
				if ( (LA16_0==25||LA16_0==36) ) {
					alt16=1;
				}

				} finally {dbg.exitDecision(16);}

				switch (alt16) {
				case 1 :
					dbg.enterAlt(1);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:
					{
					dbg.location(161,3);
					if ( input.LA(1)==25||input.LA(1)==36 ) {
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
					break loop16;
				}
			}
			} finally {dbg.exitSubRule(16);}
			dbg.location(162,4);
			n=(Token)match(input,ID,FOLLOW_ID_in_variable_decl671); if (state.failed) return retval;dbg.location(162,8);
			if ( state.backtracking==0 ) { ((List) vars.get((v_type11!=null?input.toString(v_type11.start,v_type11.stop):null))).add((n!=null?n.getText():null));  
				 cfile_stack.peek().type_obj.put((n!=null?n.getText():null), (v_type11!=null?input.toString(v_type11.start,v_type11.stop):null));}dbg.location(164,3);
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:164:3: ( ',' elt= ID )*
			try { dbg.enterSubRule(17);

			loop17:
			while (true) {
				int alt17=2;
				try { dbg.enterDecision(17, decisionCanBacktrack[17]);

				int LA17_0 = input.LA(1);
				if ( (LA17_0==26) ) {
					alt17=1;
				}

				} finally {dbg.exitDecision(17);}

				switch (alt17) {
				case 1 :
					dbg.enterAlt(1);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:164:4: ',' elt= ID
					{
					dbg.location(164,4);
					match(input,26,FOLLOW_26_in_variable_decl680); if (state.failed) return retval;dbg.location(164,11);
					elt=(Token)match(input,ID,FOLLOW_ID_in_variable_decl684); if (state.failed) return retval;dbg.location(164,15);
					if ( state.backtracking==0 ) { ((List) vars.get((v_type11!=null?input.toString(v_type11.start,v_type11.stop):null))).add((elt!=null?elt.getText():null));
						cfile_stack.peek().type_obj.put((elt!=null?elt.getText():null), (v_type11!=null?input.toString(v_type11.start,v_type11.stop):null)); }
					}
					break;

				default :
					break loop17;
				}
			}
			} finally {dbg.exitSubRule(17);}
			dbg.location(165,53);
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:165:53: ( fixed_size_array )*
			try { dbg.enterSubRule(18);

			loop18:
			while (true) {
				int alt18=2;
				try { dbg.enterDecision(18, decisionCanBacktrack[18]);

				int LA18_0 = input.LA(1);
				if ( (LA18_0==35) ) {
					alt18=1;
				}

				} finally {dbg.exitDecision(18);}

				switch (alt18) {
				case 1 :
					dbg.enterAlt(1);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:165:53: fixed_size_array
					{
					dbg.location(165,53);
					pushFollow(FOLLOW_fixed_size_array_in_variable_decl690);
					fixed_size_array();
					state._fsp--;
					if (state.failed) return retval;
					}
					break;

				default :
					break loop18;
				}
			}
			} finally {dbg.exitSubRule(18);}
			dbg.location(165,71);
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:165:71: ( assignement )?
			int alt19=2;
			try { dbg.enterSubRule(19);
			try { dbg.enterDecision(19, decisionCanBacktrack[19]);

			int LA19_0 = input.LA(1);
			if ( (LA19_0==EQUAL) ) {
				alt19=1;
			}
			} finally {dbg.exitDecision(19);}

			switch (alt19) {
				case 1 :
					dbg.enterAlt(1);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:165:71: assignement
					{
					dbg.location(165,71);
					pushFollow(FOLLOW_assignement_in_variable_decl693);
					assignement();
					state._fsp--;
					if (state.failed) return retval;
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
		dbg.location(166, 1);

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
		public int size;
		public StringTemplate st;
		public Object getTemplate() { return st; }
		public String toString() { return st==null?null:st.toString(); }
	};


	// $ANTLR start "fixed_size_array"
	// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:168:1: fixed_size_array returns [int size] : ( '[' INT ']' ) ;
	public final Systemc_basicParser.fixed_size_array_return fixed_size_array() throws  {
		Systemc_basicParser.fixed_size_array_return retval = new Systemc_basicParser.fixed_size_array_return();
		retval.start = input.LT(1);

		Token INT12=null;

		try { dbg.enterRule(getGrammarFileName(), "fixed_size_array");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(168, 0);

		try {
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:169:2: ( ( '[' INT ']' ) )
			dbg.enterAlt(1);

			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:170:2: ( '[' INT ']' )
			{
			dbg.location(170,2);
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:170:2: ( '[' INT ']' )
			dbg.enterAlt(1);

			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:170:3: '[' INT ']'
			{
			dbg.location(170,3);
			match(input,35,FOLLOW_35_in_fixed_size_array713); if (state.failed) return retval;dbg.location(170,6);
			INT12=(Token)match(input,INT,FOLLOW_INT_in_fixed_size_array714); if (state.failed) return retval;dbg.location(170,9);
			match(input,37,FOLLOW_37_in_fixed_size_array715); if (state.failed) return retval;dbg.location(170,12);
			if ( state.backtracking==0 ) {retval.size = Integer.valueOf((INT12!=null?INT12.getText():null));}
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
		dbg.location(171, 2);

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
	// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:173:1: assignement : '=' value ;
	public final Systemc_basicParser.assignement_return assignement() throws  {
		Systemc_basicParser.assignement_return retval = new Systemc_basicParser.assignement_return();
		retval.start = input.LT(1);

		try { dbg.enterRule(getGrammarFileName(), "assignement");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(173, 0);

		try {
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:173:13: ( '=' value )
			dbg.enterAlt(1);

			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:174:2: '=' value
			{
			dbg.location(174,2);
			match(input,EQUAL,FOLLOW_EQUAL_in_assignement729); if (state.failed) return retval;dbg.location(174,6);
			pushFollow(FOLLOW_value_in_assignement731);
			value();
			state._fsp--;
			if (state.failed) return retval;
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
		dbg.location(175, 1);

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
	// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:177:1: array_of_value : '{' ( INT | array_of_value | FLOAT ) ( ',' ( INT | array_of_value | FLOAT ) )* '}' ;
	public final Systemc_basicParser.array_of_value_return array_of_value() throws  {
		Systemc_basicParser.array_of_value_return retval = new Systemc_basicParser.array_of_value_return();
		retval.start = input.LT(1);

		try { dbg.enterRule(getGrammarFileName(), "array_of_value");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(177, 0);

		try {
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:177:16: ( '{' ( INT | array_of_value | FLOAT ) ( ',' ( INT | array_of_value | FLOAT ) )* '}' )
			dbg.enterAlt(1);

			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:177:18: '{' ( INT | array_of_value | FLOAT ) ( ',' ( INT | array_of_value | FLOAT ) )* '}'
			{
			dbg.location(177,18);
			match(input,80,FOLLOW_80_in_array_of_value742); if (state.failed) return retval;dbg.location(177,21);
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:177:21: ( INT | array_of_value | FLOAT )
			int alt20=3;
			try { dbg.enterSubRule(20);
			try { dbg.enterDecision(20, decisionCanBacktrack[20]);

			switch ( input.LA(1) ) {
			case INT:
				{
				alt20=1;
				}
				break;
			case 80:
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

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:177:22: INT
					{
					dbg.location(177,22);
					match(input,INT,FOLLOW_INT_in_array_of_value744); if (state.failed) return retval;
					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:177:27: array_of_value
					{
					dbg.location(177,27);
					pushFollow(FOLLOW_array_of_value_in_array_of_value747);
					array_of_value();
					state._fsp--;
					if (state.failed) return retval;
					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:177:44: FLOAT
					{
					dbg.location(177,44);
					match(input,FLOAT,FOLLOW_FLOAT_in_array_of_value751); if (state.failed) return retval;
					}
					break;

			}
			} finally {dbg.exitSubRule(20);}
			dbg.location(177,51);
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:177:51: ( ',' ( INT | array_of_value | FLOAT ) )*
			try { dbg.enterSubRule(22);

			loop22:
			while (true) {
				int alt22=2;
				try { dbg.enterDecision(22, decisionCanBacktrack[22]);

				int LA22_0 = input.LA(1);
				if ( (LA22_0==26) ) {
					alt22=1;
				}

				} finally {dbg.exitDecision(22);}

				switch (alt22) {
				case 1 :
					dbg.enterAlt(1);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:177:52: ',' ( INT | array_of_value | FLOAT )
					{
					dbg.location(177,52);
					match(input,26,FOLLOW_26_in_array_of_value755); if (state.failed) return retval;dbg.location(177,56);
					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:177:56: ( INT | array_of_value | FLOAT )
					int alt21=3;
					try { dbg.enterSubRule(21);
					try { dbg.enterDecision(21, decisionCanBacktrack[21]);

					switch ( input.LA(1) ) {
					case INT:
						{
						alt21=1;
						}
						break;
					case 80:
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

							// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:177:57: INT
							{
							dbg.location(177,57);
							match(input,INT,FOLLOW_INT_in_array_of_value758); if (state.failed) return retval;
							}
							break;
						case 2 :
							dbg.enterAlt(2);

							// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:177:62: array_of_value
							{
							dbg.location(177,62);
							pushFollow(FOLLOW_array_of_value_in_array_of_value761);
							array_of_value();
							state._fsp--;
							if (state.failed) return retval;
							}
							break;
						case 3 :
							dbg.enterAlt(3);

							// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:177:79: FLOAT
							{
							dbg.location(177,79);
							match(input,FLOAT,FOLLOW_FLOAT_in_array_of_value765); if (state.failed) return retval;
							}
							break;

					}
					} finally {dbg.exitSubRule(21);}

					}
					break;

				default :
					break loop22;
				}
			}
			} finally {dbg.exitSubRule(22);}
			dbg.location(177,87);
			match(input,82,FOLLOW_82_in_array_of_value769); if (state.failed) return retval;
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
		dbg.location(178, 1);

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
	// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:181:1: v_type : ( ( ( v_signed_modifier )? ( v_size_modifier )? 'int' ) | ( ( v_signed_modifier )? 'char' ) | 'float' | 'void' | ( 'struct' ID ) | sc_type | ID ( otemplate )? ) ;
	public final Systemc_basicParser.v_type_return v_type() throws  {
		Systemc_basicParser.v_type_return retval = new Systemc_basicParser.v_type_return();
		retval.start = input.LT(1);

		try { dbg.enterRule(getGrammarFileName(), "v_type");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(181, 0);

		try {
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:181:8: ( ( ( ( v_signed_modifier )? ( v_size_modifier )? 'int' ) | ( ( v_signed_modifier )? 'char' ) | 'float' | 'void' | ( 'struct' ID ) | sc_type | ID ( otemplate )? ) )
			dbg.enterAlt(1);

			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:181:10: ( ( ( v_signed_modifier )? ( v_size_modifier )? 'int' ) | ( ( v_signed_modifier )? 'char' ) | 'float' | 'void' | ( 'struct' ID ) | sc_type | ID ( otemplate )? )
			{
			dbg.location(181,10);
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:181:10: ( ( ( v_signed_modifier )? ( v_size_modifier )? 'int' ) | ( ( v_signed_modifier )? 'char' ) | 'float' | 'void' | ( 'struct' ID ) | sc_type | ID ( otemplate )? )
			int alt27=7;
			try { dbg.enterSubRule(27);
			try { dbg.enterDecision(27, decisionCanBacktrack[27]);

			switch ( input.LA(1) ) {
			case 77:
				{
				int LA27_1 = input.LA(2);
				if ( ((LA27_1 >= 51 && LA27_1 <= 52)||LA27_1==72) ) {
					alt27=1;
				}
				else if ( (LA27_1==42) ) {
					alt27=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 27, 1, input);
						dbg.recognitionException(nvae);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case 51:
			case 52:
			case 72:
				{
				alt27=1;
				}
				break;
			case 42:
				{
				alt27=2;
				}
				break;
			case 49:
				{
				alt27=3;
				}
				break;
			case 78:
				{
				alt27=4;
				}
				break;
			case 73:
				{
				alt27=5;
				}
				break;
			case 39:
			case 64:
			case 65:
			case 70:
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

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:181:11: ( ( v_signed_modifier )? ( v_size_modifier )? 'int' )
					{
					dbg.location(181,11);
					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:181:11: ( ( v_signed_modifier )? ( v_size_modifier )? 'int' )
					dbg.enterAlt(1);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:181:12: ( v_signed_modifier )? ( v_size_modifier )? 'int'
					{
					dbg.location(181,12);
					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:181:12: ( v_signed_modifier )?
					int alt23=2;
					try { dbg.enterSubRule(23);
					try { dbg.enterDecision(23, decisionCanBacktrack[23]);

					int LA23_0 = input.LA(1);
					if ( (LA23_0==77) ) {
						alt23=1;
					}
					} finally {dbg.exitDecision(23);}

					switch (alt23) {
						case 1 :
							dbg.enterAlt(1);

							// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:181:12: v_signed_modifier
							{
							dbg.location(181,12);
							pushFollow(FOLLOW_v_signed_modifier_in_v_type782);
							v_signed_modifier();
							state._fsp--;
							if (state.failed) return retval;
							}
							break;

					}
					} finally {dbg.exitSubRule(23);}
					dbg.location(181,31);
					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:181:31: ( v_size_modifier )?
					int alt24=2;
					try { dbg.enterSubRule(24);
					try { dbg.enterDecision(24, decisionCanBacktrack[24]);

					int LA24_0 = input.LA(1);
					if ( (LA24_0==52||LA24_0==72) ) {
						alt24=1;
					}
					} finally {dbg.exitDecision(24);}

					switch (alt24) {
						case 1 :
							dbg.enterAlt(1);

							// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:181:31: v_size_modifier
							{
							dbg.location(181,31);
							pushFollow(FOLLOW_v_size_modifier_in_v_type785);
							v_size_modifier();
							state._fsp--;
							if (state.failed) return retval;
							}
							break;

					}
					} finally {dbg.exitSubRule(24);}
					dbg.location(181,49);
					match(input,51,FOLLOW_51_in_v_type789); if (state.failed) return retval;
					}

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:181:56: ( ( v_signed_modifier )? 'char' )
					{
					dbg.location(181,56);
					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:181:56: ( ( v_signed_modifier )? 'char' )
					dbg.enterAlt(1);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:181:57: ( v_signed_modifier )? 'char'
					{
					dbg.location(181,57);
					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:181:57: ( v_signed_modifier )?
					int alt25=2;
					try { dbg.enterSubRule(25);
					try { dbg.enterDecision(25, decisionCanBacktrack[25]);

					int LA25_0 = input.LA(1);
					if ( (LA25_0==77) ) {
						alt25=1;
					}
					} finally {dbg.exitDecision(25);}

					switch (alt25) {
						case 1 :
							dbg.enterAlt(1);

							// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:181:58: v_signed_modifier
							{
							dbg.location(181,58);
							pushFollow(FOLLOW_v_signed_modifier_in_v_type794);
							v_signed_modifier();
							state._fsp--;
							if (state.failed) return retval;
							}
							break;

					}
					} finally {dbg.exitSubRule(25);}
					dbg.location(181,78);
					match(input,42,FOLLOW_42_in_v_type798); if (state.failed) return retval;
					}

					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:181:86: 'float'
					{
					dbg.location(181,86);
					match(input,49,FOLLOW_49_in_v_type801); if (state.failed) return retval;
					}
					break;
				case 4 :
					dbg.enterAlt(4);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:181:94: 'void'
					{
					dbg.location(181,94);
					match(input,78,FOLLOW_78_in_v_type803); if (state.failed) return retval;
					}
					break;
				case 5 :
					dbg.enterAlt(5);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:181:101: ( 'struct' ID )
					{
					dbg.location(181,101);
					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:181:101: ( 'struct' ID )
					dbg.enterAlt(1);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:181:102: 'struct' ID
					{
					dbg.location(181,102);
					match(input,73,FOLLOW_73_in_v_type806); if (state.failed) return retval;dbg.location(181,111);
					match(input,ID,FOLLOW_ID_in_v_type808); if (state.failed) return retval;
					}

					}
					break;
				case 6 :
					dbg.enterAlt(6);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:181:116: sc_type
					{
					dbg.location(181,116);
					pushFollow(FOLLOW_sc_type_in_v_type812);
					sc_type();
					state._fsp--;
					if (state.failed) return retval;
					}
					break;
				case 7 :
					dbg.enterAlt(7);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:181:125: ID ( otemplate )?
					{
					dbg.location(181,125);
					match(input,ID,FOLLOW_ID_in_v_type815); if (state.failed) return retval;dbg.location(181,128);
					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:181:128: ( otemplate )?
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

							// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:181:128: otemplate
							{
							dbg.location(181,128);
							pushFollow(FOLLOW_otemplate_in_v_type817);
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
		dbg.location(182, 1);

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
	// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:183:1: v_size_modifier : ( 'short' | 'long' )+ ;
	public final Systemc_basicParser.v_size_modifier_return v_size_modifier() throws  {
		Systemc_basicParser.v_size_modifier_return retval = new Systemc_basicParser.v_size_modifier_return();
		retval.start = input.LT(1);

		try { dbg.enterRule(getGrammarFileName(), "v_size_modifier");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(183, 0);

		try {
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:183:17: ( ( 'short' | 'long' )+ )
			dbg.enterAlt(1);

			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:183:18: ( 'short' | 'long' )+
			{
			dbg.location(183,18);
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:183:18: ( 'short' | 'long' )+
			int cnt28=0;
			try { dbg.enterSubRule(28);

			loop28:
			while (true) {
				int alt28=2;
				try { dbg.enterDecision(28, decisionCanBacktrack[28]);

				int LA28_0 = input.LA(1);
				if ( (LA28_0==52||LA28_0==72) ) {
					alt28=1;
				}

				} finally {dbg.exitDecision(28);}

				switch (alt28) {
				case 1 :
					dbg.enterAlt(1);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:
					{
					dbg.location(183,18);
					if ( input.LA(1)==52||input.LA(1)==72 ) {
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
					EarlyExitException eee = new EarlyExitException(28, input);
					dbg.recognitionException(eee);

					throw eee;
				}
				cnt28++;
			}
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
		dbg.location(184, 1);

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
	// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:185:1: v_signed_modifier : 'unsigned' ;
	public final Systemc_basicParser.v_signed_modifier_return v_signed_modifier() throws  {
		Systemc_basicParser.v_signed_modifier_return retval = new Systemc_basicParser.v_signed_modifier_return();
		retval.start = input.LT(1);

		try { dbg.enterRule(getGrammarFileName(), "v_signed_modifier");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(185, 0);

		try {
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:185:19: ( 'unsigned' )
			dbg.enterAlt(1);

			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:185:21: 'unsigned'
			{
			dbg.location(185,21);
			match(input,77,FOLLOW_77_in_v_signed_modifier844); if (state.failed) return retval;
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
		dbg.location(186, 1);

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
	// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:187:1: otemplate : '<' ( ID | INT ) ( ',' ( ID | INT ) )* '>' ;
	public final Systemc_basicParser.otemplate_return otemplate() throws  {
		Systemc_basicParser.otemplate_return retval = new Systemc_basicParser.otemplate_return();
		retval.start = input.LT(1);

		try { dbg.enterRule(getGrammarFileName(), "otemplate");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(187, 0);

		try {
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:187:11: ( '<' ( ID | INT ) ( ',' ( ID | INT ) )* '>' )
			dbg.enterAlt(1);

			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:187:13: '<' ( ID | INT ) ( ',' ( ID | INT ) )* '>'
			{
			dbg.location(187,13);
			match(input,LT,FOLLOW_LT_in_otemplate853); if (state.failed) return retval;dbg.location(187,17);
			if ( input.LA(1)==ID||input.LA(1)==INT ) {
				input.consume();
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				dbg.recognitionException(mse);
				throw mse;
			}dbg.location(187,26);
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:187:26: ( ',' ( ID | INT ) )*
			try { dbg.enterSubRule(29);

			loop29:
			while (true) {
				int alt29=2;
				try { dbg.enterDecision(29, decisionCanBacktrack[29]);

				int LA29_0 = input.LA(1);
				if ( (LA29_0==26) ) {
					alt29=1;
				}

				} finally {dbg.exitDecision(29);}

				switch (alt29) {
				case 1 :
					dbg.enterAlt(1);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:187:27: ',' ( ID | INT )
					{
					dbg.location(187,27);
					match(input,26,FOLLOW_26_in_otemplate862); if (state.failed) return retval;dbg.location(187,31);
					if ( input.LA(1)==ID||input.LA(1)==INT ) {
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
			}
			} finally {dbg.exitSubRule(29);}
			dbg.location(187,41);
			match(input,GT,FOLLOW_GT_in_otemplate871); if (state.failed) return retval;
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
		dbg.location(188, 1);

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
	// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:190:1: actor : 'SC_CTOR' '(' ID ')' ( ':' actor_inst[$module_decl::mod_type, $module_decl::obj_type] ( ',' actor_inst[$module_decl::mod_type, $module_decl::obj_type] )* )? '{' ( actor_body ) '}' ;
	public final Systemc_basicParser.actor_return actor() throws  {
		Systemc_basicParser.actor_return retval = new Systemc_basicParser.actor_return();
		retval.start = input.LT(1);

		try { dbg.enterRule(getGrammarFileName(), "actor");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(190, 0);

		try {
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:190:7: ( 'SC_CTOR' '(' ID ')' ( ':' actor_inst[$module_decl::mod_type, $module_decl::obj_type] ( ',' actor_inst[$module_decl::mod_type, $module_decl::obj_type] )* )? '{' ( actor_body ) '}' )
			dbg.enterAlt(1);

			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:190:8: 'SC_CTOR' '(' ID ')' ( ':' actor_inst[$module_decl::mod_type, $module_decl::obj_type] ( ',' actor_inst[$module_decl::mod_type, $module_decl::obj_type] )* )? '{' ( actor_body ) '}'
			{
			dbg.location(190,8);
			match(input,32,FOLLOW_32_in_actor881); if (state.failed) return retval;dbg.location(190,17);
			match(input,23,FOLLOW_23_in_actor882); if (state.failed) return retval;dbg.location(190,20);
			match(input,ID,FOLLOW_ID_in_actor883); if (state.failed) return retval;dbg.location(190,22);
			match(input,24,FOLLOW_24_in_actor884); if (state.failed) return retval;dbg.location(190,27);
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:190:27: ( ':' actor_inst[$module_decl::mod_type, $module_decl::obj_type] ( ',' actor_inst[$module_decl::mod_type, $module_decl::obj_type] )* )?
			int alt31=2;
			try { dbg.enterSubRule(31);
			try { dbg.enterDecision(31, decisionCanBacktrack[31]);

			int LA31_0 = input.LA(1);
			if ( (LA31_0==29) ) {
				alt31=1;
			}
			} finally {dbg.exitDecision(31);}

			switch (alt31) {
				case 1 :
					dbg.enterAlt(1);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:190:28: ':' actor_inst[$module_decl::mod_type, $module_decl::obj_type] ( ',' actor_inst[$module_decl::mod_type, $module_decl::obj_type] )*
					{
					dbg.location(190,28);
					match(input,29,FOLLOW_29_in_actor888); if (state.failed) return retval;dbg.location(190,32);
					pushFollow(FOLLOW_actor_inst_in_actor890);
					actor_inst(module_decl_stack.peek().mod_type, module_decl_stack.peek().obj_type);
					state._fsp--;
					if (state.failed) return retval;dbg.location(190,90);
					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:190:90: ( ',' actor_inst[$module_decl::mod_type, $module_decl::obj_type] )*
					try { dbg.enterSubRule(30);

					loop30:
					while (true) {
						int alt30=2;
						try { dbg.enterDecision(30, decisionCanBacktrack[30]);

						int LA30_0 = input.LA(1);
						if ( (LA30_0==26) ) {
							alt30=1;
						}

						} finally {dbg.exitDecision(30);}

						switch (alt30) {
						case 1 :
							dbg.enterAlt(1);

							// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:190:91: ',' actor_inst[$module_decl::mod_type, $module_decl::obj_type]
							{
							dbg.location(190,91);
							match(input,26,FOLLOW_26_in_actor893); if (state.failed) return retval;dbg.location(190,94);
							pushFollow(FOLLOW_actor_inst_in_actor894);
							actor_inst(module_decl_stack.peek().mod_type, module_decl_stack.peek().obj_type);
							state._fsp--;
							if (state.failed) return retval;
							}
							break;

						default :
							break loop30;
						}
					}
					} finally {dbg.exitSubRule(30);}

					}
					break;

			}
			} finally {dbg.exitSubRule(31);}
			dbg.location(190,156);
			match(input,80,FOLLOW_80_in_actor900); if (state.failed) return retval;dbg.location(190,160);
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:190:160: ( actor_body )
			dbg.enterAlt(1);

			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:190:161: actor_body
			{
			dbg.location(190,161);
			pushFollow(FOLLOW_actor_body_in_actor903);
			actor_body();
			state._fsp--;
			if (state.failed) return retval;
			}
			dbg.location(190,173);
			match(input,82,FOLLOW_82_in_actor906); if (state.failed) return retval;
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
		dbg.location(192, 1);

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
	// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:194:1: actor_inst[HashMap mod_type, HashMap obj_type] : (type= ID )? actorName= ID '(' STRING_LITERAL ')' ;
	public final Systemc_basicParser.actor_inst_return actor_inst(HashMap mod_type, HashMap obj_type) throws  {
		Systemc_basicParser.actor_inst_return retval = new Systemc_basicParser.actor_inst_return();
		retval.start = input.LT(1);

		Token type=null;
		Token actorName=null;

		try { dbg.enterRule(getGrammarFileName(), "actor_inst");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(194, 0);

		try {
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:195:2: ( (type= ID )? actorName= ID '(' STRING_LITERAL ')' )
			dbg.enterAlt(1);

			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:195:3: (type= ID )? actorName= ID '(' STRING_LITERAL ')'
			{
			dbg.location(195,3);
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:195:3: (type= ID )?
			int alt32=2;
			try { dbg.enterSubRule(32);
			try { dbg.enterDecision(32, decisionCanBacktrack[32]);

			int LA32_0 = input.LA(1);
			if ( (LA32_0==ID) ) {
				int LA32_1 = input.LA(2);
				if ( (LA32_1==ID) ) {
					alt32=1;
				}
			}
			} finally {dbg.exitDecision(32);}

			switch (alt32) {
				case 1 :
					dbg.enterAlt(1);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:195:4: type= ID
					{
					dbg.location(195,9);
					type=(Token)match(input,ID,FOLLOW_ID_in_actor_inst924); if (state.failed) return retval;
					}
					break;

			}
			} finally {dbg.exitSubRule(32);}
			dbg.location(195,25);
			actorName=(Token)match(input,ID,FOLLOW_ID_in_actor_inst930); if (state.failed) return retval;dbg.location(195,28);
			match(input,23,FOLLOW_23_in_actor_inst931); if (state.failed) return retval;dbg.location(195,31);
			match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_actor_inst932); if (state.failed) return retval;dbg.location(195,45);
			match(input,24,FOLLOW_24_in_actor_inst933); if (state.failed) return retval;dbg.location(195,50);
			if ( state.backtracking==0 ) {
						if(type == null){
						  mod_type.put((actorName!=null?actorName.getText():null), cfile_stack.peek().type_obj.get((actorName!=null?actorName.getText():null)));
						  obj_type.remove(cfile_stack.peek().type_obj.get((actorName!=null?actorName.getText():null)));
						  cfile_stack.peek().type_obj.remove((actorName!=null?actorName.getText():null));
						}else{
						  mod_type.put((actorName!=null?actorName.getText():null), (type!=null?type.getText():null));
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
		dbg.location(204, 1);

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
	// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:206:1: connection[HashMap connections] : component= ID '.' link ;
	public final Systemc_basicParser.connection_return connection(HashMap  connections) throws  {
		Systemc_basicParser.connection_return retval = new Systemc_basicParser.connection_return();
		retval.start = input.LT(1);

		Token component=null;
		ParserRuleReturnScope link13 =null;

		try { dbg.enterRule(getGrammarFileName(), "connection");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(206, 0);

		try {
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:206:34: (component= ID '.' link )
			dbg.enterAlt(1);

			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:206:36: component= ID '.' link
			{
			dbg.location(206,45);
			component=(Token)match(input,ID,FOLLOW_ID_in_connection949); if (state.failed) return retval;dbg.location(206,48);
			match(input,27,FOLLOW_27_in_connection950); if (state.failed) return retval;dbg.location(206,51);
			pushFollow(FOLLOW_link_in_connection951);
			link13=link();
			state._fsp--;
			if (state.failed) return retval;dbg.location(206,56);
			if ( state.backtracking==0 ) {if(connections.get((component!=null?component.getText():null)) == null){
							connections.put((component!=null?component.getText():null),  new ArrayList()) ;
						}
			 			((ArrayList) connections.get((component!=null?component.getText():null))).add((link13!=null?((StringTemplate)link13.getTemplate()):null));
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
		dbg.location(211, 1);

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
	// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:213:1: link : port= ID '(' signal= ID ')' -> link(source=$port.textdest=$signal.text);
	public final Systemc_basicParser.link_return link() throws  {
		Systemc_basicParser.link_return retval = new Systemc_basicParser.link_return();
		retval.start = input.LT(1);

		Token port=null;
		Token signal=null;

		try { dbg.enterRule(getGrammarFileName(), "link");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(213, 0);

		try {
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:213:6: (port= ID '(' signal= ID ')' -> link(source=$port.textdest=$signal.text))
			dbg.enterAlt(1);

			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:213:7: port= ID '(' signal= ID ')'
			{
			dbg.location(213,11);
			port=(Token)match(input,ID,FOLLOW_ID_in_link964); if (state.failed) return retval;dbg.location(213,14);
			match(input,23,FOLLOW_23_in_link965); if (state.failed) return retval;dbg.location(213,23);
			signal=(Token)match(input,ID,FOLLOW_ID_in_link968); if (state.failed) return retval;dbg.location(213,26);
			match(input,24,FOLLOW_24_in_link969); if (state.failed) return retval;
			// TEMPLATE REWRITE
			if ( state.backtracking==0 ) {
			  // 213:30: -> link(source=$port.textdest=$signal.text)
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
		dbg.location(214, 1);

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
	// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:216:1: sensitive : 'sensitive' '<<' ID ( '.' method )* ;
	public final Systemc_basicParser.sensitive_return sensitive() throws  {
		Systemc_basicParser.sensitive_return retval = new Systemc_basicParser.sensitive_return();
		retval.start = input.LT(1);

		Token ID14=null;

		try { dbg.enterRule(getGrammarFileName(), "sensitive");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(216, 0);

		try {
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:217:2: ( 'sensitive' '<<' ID ( '.' method )* )
			dbg.enterAlt(1);

			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:217:4: 'sensitive' '<<' ID ( '.' method )*
			{
			dbg.location(217,4);
			match(input,71,FOLLOW_71_in_sensitive999); if (state.failed) return retval;dbg.location(217,16);
			match(input,31,FOLLOW_31_in_sensitive1001); if (state.failed) return retval;dbg.location(217,21);
			ID14=(Token)match(input,ID,FOLLOW_ID_in_sensitive1003); if (state.failed) return retval;dbg.location(217,24);
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:217:24: ( '.' method )*
			try { dbg.enterSubRule(33);

			loop33:
			while (true) {
				int alt33=2;
				try { dbg.enterDecision(33, decisionCanBacktrack[33]);

				int LA33_0 = input.LA(1);
				if ( (LA33_0==27) ) {
					alt33=1;
				}

				} finally {dbg.exitDecision(33);}

				switch (alt33) {
				case 1 :
					dbg.enterAlt(1);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:217:25: '.' method
					{
					dbg.location(217,25);
					match(input,27,FOLLOW_27_in_sensitive1006); if (state.failed) return retval;dbg.location(217,28);
					pushFollow(FOLLOW_method_in_sensitive1007);
					method();
					state._fsp--;
					if (state.failed) return retval;
					}
					break;

				default :
					break loop33;
				}
			}
			} finally {dbg.exitSubRule(33);}
			dbg.location(217,37);
			if ( state.backtracking==0 ) {slist_stack.peek().names.add((ID14!=null?ID14.getText():null));}
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
		dbg.location(218, 1);

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
	// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:220:1: method : ID '(' ( func_arg ( ',' arg= func_arg )* )? ')' -> method(name=$ID.textargs=$slist::stack);
	public final Systemc_basicParser.method_return method() throws  {
		slist_stack.push(new slist_scope());

		Systemc_basicParser.method_return retval = new Systemc_basicParser.method_return();
		retval.start = input.LT(1);

		Token ID15=null;
		ParserRuleReturnScope arg =null;


		  slist_stack.peek().stack = new ArrayList();

		try { dbg.enterRule(getGrammarFileName(), "method");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(220, 0);

		try {
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:225:2: ( ID '(' ( func_arg ( ',' arg= func_arg )* )? ')' -> method(name=$ID.textargs=$slist::stack))
			dbg.enterAlt(1);

			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:226:2: ID '(' ( func_arg ( ',' arg= func_arg )* )? ')'
			{
			dbg.location(226,2);
			ID15=(Token)match(input,ID,FOLLOW_ID_in_method1033); if (state.failed) return retval;dbg.location(226,4);
			match(input,23,FOLLOW_23_in_method1034); if (state.failed) return retval;dbg.location(226,7);
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:226:7: ( func_arg ( ',' arg= func_arg )* )?
			int alt35=2;
			try { dbg.enterSubRule(35);
			try { dbg.enterDecision(35, decisionCanBacktrack[35]);

			int LA35_0 = input.LA(1);
			if ( (LA35_0==BIN||(LA35_0 >= HEX && LA35_0 <= ID)||LA35_0==INT||LA35_0==NOT||LA35_0==STRING_LITERAL||LA35_0==23||LA35_0==39||LA35_0==43||(LA35_0 >= 53 && LA35_0 <= 56)||(LA35_0 >= 64 && LA35_0 <= 65)||LA35_0==70||(LA35_0 >= 75 && LA35_0 <= 76)) ) {
				alt35=1;
			}
			} finally {dbg.exitDecision(35);}

			switch (alt35) {
				case 1 :
					dbg.enterAlt(1);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:226:8: func_arg ( ',' arg= func_arg )*
					{
					dbg.location(226,8);
					pushFollow(FOLLOW_func_arg_in_method1036);
					func_arg();
					state._fsp--;
					if (state.failed) return retval;dbg.location(226,16);
					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:226:16: ( ',' arg= func_arg )*
					try { dbg.enterSubRule(34);

					loop34:
					while (true) {
						int alt34=2;
						try { dbg.enterDecision(34, decisionCanBacktrack[34]);

						int LA34_0 = input.LA(1);
						if ( (LA34_0==26) ) {
							alt34=1;
						}

						} finally {dbg.exitDecision(34);}

						switch (alt34) {
						case 1 :
							dbg.enterAlt(1);

							// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:226:17: ',' arg= func_arg
							{
							dbg.location(226,17);
							match(input,26,FOLLOW_26_in_method1038); if (state.failed) return retval;dbg.location(226,23);
							pushFollow(FOLLOW_func_arg_in_method1041);
							arg=func_arg();
							state._fsp--;
							if (state.failed) return retval;dbg.location(226,33);
							if ( state.backtracking==0 ) {slist_stack.peek().stack.add((arg!=null?((StringTemplate)arg.getTemplate()):null));}
							}
							break;

						default :
							break loop34;
						}
					}
					} finally {dbg.exitSubRule(34);}

					}
					break;

			}
			} finally {dbg.exitSubRule(35);}
			dbg.location(226,66);
			match(input,24,FOLLOW_24_in_method1048); if (state.failed) return retval;
			// TEMPLATE REWRITE
			if ( state.backtracking==0 ) {
			  // 226:70: -> method(name=$ID.textargs=$slist::stack)
			  {
			  	retval.st = templateLib.getInstanceOf("method",new STAttrMap().put("name", (ID15!=null?ID15.getText():null)).put("args", slist_stack.peek().stack));
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
		dbg.location(227, 1);

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
	// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:229:1: func_arg : ( value ) ;
	public final Systemc_basicParser.func_arg_return func_arg() throws  {
		Systemc_basicParser.func_arg_return retval = new Systemc_basicParser.func_arg_return();
		retval.start = input.LT(1);

		ParserRuleReturnScope value16 =null;

		try { dbg.enterRule(getGrammarFileName(), "func_arg");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(229, 0);

		try {
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:229:10: ( ( value ) )
			dbg.enterAlt(1);

			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:229:11: ( value )
			{
			dbg.location(229,11);
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:229:11: ( value )
			dbg.enterAlt(1);

			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:229:12: value
			{
			dbg.location(229,12);
			pushFollow(FOLLOW_value_in_func_arg1074);
			value16=value();
			state._fsp--;
			if (state.failed) return retval;dbg.location(229,18);
			if ( state.backtracking==0 ) {slist_stack.peek().stack.add((value16!=null?((StringTemplate)value16.getTemplate()):null));}
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
		dbg.location(230, 1);

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
	// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:231:1: actor_method returns [String name] : actor_method_decl SEMICOLON ( sensitive SEMICOLON )+ -> process(sensitive=$slist::namesname=$actor_method_decl.name);
	public final Systemc_basicParser.actor_method_return actor_method() throws  {
		slist_stack.push(new slist_scope());

		Systemc_basicParser.actor_method_return retval = new Systemc_basicParser.actor_method_return();
		retval.start = input.LT(1);

		ParserRuleReturnScope actor_method_decl17 =null;


		  slist_stack.peek().names = new ArrayList();
		  retval.name = new String();

		try { dbg.enterRule(getGrammarFileName(), "actor_method");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(231, 0);

		try {
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:237:2: ( actor_method_decl SEMICOLON ( sensitive SEMICOLON )+ -> process(sensitive=$slist::namesname=$actor_method_decl.name))
			dbg.enterAlt(1);

			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:238:2: actor_method_decl SEMICOLON ( sensitive SEMICOLON )+
			{
			dbg.location(238,2);
			pushFollow(FOLLOW_actor_method_decl_in_actor_method1103);
			actor_method_decl17=actor_method_decl();
			state._fsp--;
			if (state.failed) return retval;dbg.location(238,20);
			match(input,SEMICOLON,FOLLOW_SEMICOLON_in_actor_method1105); if (state.failed) return retval;dbg.location(238,29);
			if ( state.backtracking==0 ) {retval.name = (actor_method_decl17!=null?((Systemc_basicParser.actor_method_decl_return)actor_method_decl17).name:null) ;}dbg.location(239,2);
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:239:2: ( sensitive SEMICOLON )+
			int cnt36=0;
			try { dbg.enterSubRule(36);

			loop36:
			while (true) {
				int alt36=2;
				try { dbg.enterDecision(36, decisionCanBacktrack[36]);

				int LA36_0 = input.LA(1);
				if ( (LA36_0==71) ) {
					alt36=1;
				}

				} finally {dbg.exitDecision(36);}

				switch (alt36) {
				case 1 :
					dbg.enterAlt(1);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:239:3: sensitive SEMICOLON
					{
					dbg.location(239,3);
					pushFollow(FOLLOW_sensitive_in_actor_method1110);
					sensitive();
					state._fsp--;
					if (state.failed) return retval;dbg.location(239,13);
					match(input,SEMICOLON,FOLLOW_SEMICOLON_in_actor_method1112); if (state.failed) return retval;
					}
					break;

				default :
					if ( cnt36 >= 1 ) break loop36;
					if (state.backtracking>0) {state.failed=true; return retval;}
					EarlyExitException eee = new EarlyExitException(36, input);
					dbg.recognitionException(eee);

					throw eee;
				}
				cnt36++;
			}
			} finally {dbg.exitSubRule(36);}

			// TEMPLATE REWRITE
			if ( state.backtracking==0 ) {
			  // 239:25: -> process(sensitive=$slist::namesname=$actor_method_decl.name)
			  {
			  	retval.st = templateLib.getInstanceOf("process",new STAttrMap().put("sensitive", slist_stack.peek().names).put("name", (actor_method_decl17!=null?((Systemc_basicParser.actor_method_decl_return)actor_method_decl17).name:null)));
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
		dbg.location(240, 1);

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
	// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:242:1: actor_method_decl returns [String name] : 'SC_METHOD(' n= ID ')' ;
	public final Systemc_basicParser.actor_method_decl_return actor_method_decl() throws  {
		Systemc_basicParser.actor_method_decl_return retval = new Systemc_basicParser.actor_method_decl_return();
		retval.start = input.LT(1);

		Token n=null;

		try { dbg.enterRule(getGrammarFileName(), "actor_method_decl");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(242, 0);

		try {
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:243:2: ( 'SC_METHOD(' n= ID ')' )
			dbg.enterAlt(1);

			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:244:2: 'SC_METHOD(' n= ID ')'
			{
			dbg.location(244,2);
			match(input,33,FOLLOW_33_in_actor_method_decl1147); if (state.failed) return retval;dbg.location(244,16);
			n=(Token)match(input,ID,FOLLOW_ID_in_actor_method_decl1152); if (state.failed) return retval;dbg.location(244,20);
			match(input,24,FOLLOW_24_in_actor_method_decl1153); if (state.failed) return retval;dbg.location(244,24);
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
		dbg.location(245, 1);

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
	// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:247:1: actor_body : ( actor_body_elt )+ ;
	public final Systemc_basicParser.actor_body_return actor_body() throws  {
		Systemc_basicParser.actor_body_return retval = new Systemc_basicParser.actor_body_return();
		retval.start = input.LT(1);

		try { dbg.enterRule(getGrammarFileName(), "actor_body");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(247, 0);

		try {
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:247:12: ( ( actor_body_elt )+ )
			dbg.enterAlt(1);

			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:247:14: ( actor_body_elt )+
			{
			dbg.location(247,14);
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:247:14: ( actor_body_elt )+
			int cnt37=0;
			try { dbg.enterSubRule(37);

			loop37:
			while (true) {
				int alt37=2;
				try { dbg.enterDecision(37, decisionCanBacktrack[37]);

				int LA37_0 = input.LA(1);
				if ( (LA37_0==ID||LA37_0==33) ) {
					alt37=1;
				}

				} finally {dbg.exitDecision(37);}

				switch (alt37) {
				case 1 :
					dbg.enterAlt(1);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:247:15: actor_body_elt
					{
					dbg.location(247,15);
					pushFollow(FOLLOW_actor_body_elt_in_actor_body1166);
					actor_body_elt();
					state._fsp--;
					if (state.failed) return retval;
					}
					break;

				default :
					if ( cnt37 >= 1 ) break loop37;
					if (state.backtracking>0) {state.failed=true; return retval;}
					EarlyExitException eee = new EarlyExitException(37, input);
					dbg.recognitionException(eee);

					throw eee;
				}
				cnt37++;
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
		dbg.location(248, 1);

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
	// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:251:1: actor_body_elt : (meth= actor_method | ( func_call SEMICOLON ) | ( connection[$module_decl::connections] SEMICOLON ) ) ;
	public final Systemc_basicParser.actor_body_elt_return actor_body_elt() throws  {
		Systemc_basicParser.actor_body_elt_return retval = new Systemc_basicParser.actor_body_elt_return();
		retval.start = input.LT(1);

		ParserRuleReturnScope meth =null;

		try { dbg.enterRule(getGrammarFileName(), "actor_body_elt");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(251, 0);

		try {
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:252:2: ( (meth= actor_method | ( func_call SEMICOLON ) | ( connection[$module_decl::connections] SEMICOLON ) ) )
			dbg.enterAlt(1);

			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:253:2: (meth= actor_method | ( func_call SEMICOLON ) | ( connection[$module_decl::connections] SEMICOLON ) )
			{
			dbg.location(253,2);
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:253:2: (meth= actor_method | ( func_call SEMICOLON ) | ( connection[$module_decl::connections] SEMICOLON ) )
			int alt38=3;
			try { dbg.enterSubRule(38);
			try { dbg.enterDecision(38, decisionCanBacktrack[38]);

			int LA38_0 = input.LA(1);
			if ( (LA38_0==33) ) {
				alt38=1;
			}
			else if ( (LA38_0==ID) ) {
				int LA38_2 = input.LA(2);
				if ( (LA38_2==23) ) {
					alt38=2;
				}
				else if ( (LA38_2==27) ) {
					alt38=3;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 38, 2, input);
						dbg.recognitionException(nvae);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 38, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(38);}

			switch (alt38) {
				case 1 :
					dbg.enterAlt(1);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:253:3: meth= actor_method
					{
					dbg.location(253,7);
					pushFollow(FOLLOW_actor_method_in_actor_body_elt1185);
					meth=actor_method();
					state._fsp--;
					if (state.failed) return retval;dbg.location(253,21);
					if ( state.backtracking==0 ) {module_decl_stack.peek().processes.put((meth!=null?((Systemc_basicParser.actor_method_return)meth).name:null), (meth!=null?((StringTemplate)meth.getTemplate()):null));}
					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:254:4: ( func_call SEMICOLON )
					{
					dbg.location(254,4);
					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:254:4: ( func_call SEMICOLON )
					dbg.enterAlt(1);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:254:5: func_call SEMICOLON
					{
					dbg.location(254,5);
					pushFollow(FOLLOW_func_call_in_actor_body_elt1193);
					func_call();
					state._fsp--;
					if (state.failed) return retval;dbg.location(254,15);
					match(input,SEMICOLON,FOLLOW_SEMICOLON_in_actor_body_elt1195); if (state.failed) return retval;
					}

					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:255:3: ( connection[$module_decl::connections] SEMICOLON )
					{
					dbg.location(255,3);
					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:255:3: ( connection[$module_decl::connections] SEMICOLON )
					dbg.enterAlt(1);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:255:4: connection[$module_decl::connections] SEMICOLON
					{
					dbg.location(255,4);
					pushFollow(FOLLOW_connection_in_actor_body_elt1201);
					connection(module_decl_stack.peek().connections);
					state._fsp--;
					if (state.failed) return retval;dbg.location(255,42);
					match(input,SEMICOLON,FOLLOW_SEMICOLON_in_actor_body_elt1204); if (state.failed) return retval;
					}

					}
					break;

			}
			} finally {dbg.exitSubRule(38);}

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
		dbg.location(256, 1);

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
		public Object type;
		public StringTemplate st;
		public Object getTemplate() { return st; }
		public String toString() { return st==null?null:st.toString(); }
	};


	// $ANTLR start "signal_dec"
	// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:258:1: signal_dec returns [Object type] : ( ( sc_signal ) name ( ',' name )* ( fixed_size_array )* ) -> signal(name=$slist::namestype=$type);
	public final Systemc_basicParser.signal_dec_return signal_dec() throws  {
		slist_stack.push(new slist_scope());

		Systemc_basicParser.signal_dec_return retval = new Systemc_basicParser.signal_dec_return();
		retval.start = input.LT(1);

		ParserRuleReturnScope sc_signal18 =null;
		ParserRuleReturnScope fixed_size_array19 =null;


		  slist_stack.peek().names = new ArrayList();
		  retval.type = new String();

		try { dbg.enterRule(getGrammarFileName(), "signal_dec");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(258, 0);

		try {
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:263:2: ( ( ( sc_signal ) name ( ',' name )* ( fixed_size_array )* ) -> signal(name=$slist::namestype=$type))
			dbg.enterAlt(1);

			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:264:2: ( ( sc_signal ) name ( ',' name )* ( fixed_size_array )* )
			{
			dbg.location(264,2);
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:264:2: ( ( sc_signal ) name ( ',' name )* ( fixed_size_array )* )
			dbg.enterAlt(1);

			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:264:3: ( sc_signal ) name ( ',' name )* ( fixed_size_array )*
			{
			dbg.location(264,3);
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:264:3: ( sc_signal )
			dbg.enterAlt(1);

			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:264:4: sc_signal
			{
			dbg.location(264,4);
			pushFollow(FOLLOW_sc_signal_in_signal_dec1233);
			sc_signal18=sc_signal();
			state._fsp--;
			if (state.failed) return retval;
			}
			dbg.location(264,15);
			if ( state.backtracking==0 ) {retval.type = (sc_signal18!=null?((StringTemplate)sc_signal18.getTemplate()):null) ;}dbg.location(264,41);
			pushFollow(FOLLOW_name_in_signal_dec1238);
			name();
			state._fsp--;
			if (state.failed) return retval;dbg.location(264,46);
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:264:46: ( ',' name )*
			try { dbg.enterSubRule(39);

			loop39:
			while (true) {
				int alt39=2;
				try { dbg.enterDecision(39, decisionCanBacktrack[39]);

				int LA39_0 = input.LA(1);
				if ( (LA39_0==26) ) {
					alt39=1;
				}

				} finally {dbg.exitDecision(39);}

				switch (alt39) {
				case 1 :
					dbg.enterAlt(1);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:264:47: ',' name
					{
					dbg.location(264,47);
					match(input,26,FOLLOW_26_in_signal_dec1241); if (state.failed) return retval;dbg.location(264,50);
					pushFollow(FOLLOW_name_in_signal_dec1242);
					name();
					state._fsp--;
					if (state.failed) return retval;
					}
					break;

				default :
					break loop39;
				}
			}
			} finally {dbg.exitSubRule(39);}
			dbg.location(265,2);
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:265:2: ( fixed_size_array )*
			try { dbg.enterSubRule(40);

			loop40:
			while (true) {
				int alt40=2;
				try { dbg.enterDecision(40, decisionCanBacktrack[40]);

				int LA40_0 = input.LA(1);
				if ( (LA40_0==35) ) {
					alt40=1;
				}

				} finally {dbg.exitDecision(40);}

				switch (alt40) {
				case 1 :
					dbg.enterAlt(1);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:265:3: fixed_size_array
					{
					dbg.location(265,3);
					pushFollow(FOLLOW_fixed_size_array_in_signal_dec1250);
					fixed_size_array19=fixed_size_array();
					state._fsp--;
					if (state.failed) return retval;dbg.location(265,20);
					if ( state.backtracking==0 ) {
						String typeName = "array_"+(fixed_size_array19!=null?((Systemc_basicParser.fixed_size_array_return)fixed_size_array19).size:0);
						STAttrMap attrMap = new STAttrMap();
						attrMap.put("name", typeName );
						attrMap.put("size", (fixed_size_array19!=null?((Systemc_basicParser.fixed_size_array_return)fixed_size_array19).size:0) );
						attrMap.put("type", retval.type);
						cfile_stack.peek().typeDecl.add(templateLib.getInstanceOf("array_type_decl",attrMap));
						retval.type = typeName;
						}
					}
					break;

				default :
					break loop40;
				}
			}
			} finally {dbg.exitSubRule(40);}

			}
			dbg.location(275,2);
			if ( state.backtracking==0 ) {SignalAssignementConversion.getInstance().registerType(slist_stack.peek().names, (sc_signal18!=null?((StringTemplate)sc_signal18.getTemplate()):null).toString());}
			// TEMPLATE REWRITE
			if ( state.backtracking==0 ) {
			  // 275:102: -> signal(name=$slist::namestype=$type)
			  {
			  	retval.st = templateLib.getInstanceOf("signal",new STAttrMap().put("name", slist_stack.peek().names).put("type", retval.type));
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
		dbg.location(276, 1);

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
	// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:280:1: sc_signal : ( 'sc_signal' ( '_rv' )? ctemplate ) -> dummy(val=$ctemplate.st);
	public final Systemc_basicParser.sc_signal_return sc_signal() throws  {
		Systemc_basicParser.sc_signal_return retval = new Systemc_basicParser.sc_signal_return();
		retval.start = input.LT(1);

		ParserRuleReturnScope ctemplate20 =null;

		try { dbg.enterRule(getGrammarFileName(), "sc_signal");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(280, 0);

		try {
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:280:11: ( ( 'sc_signal' ( '_rv' )? ctemplate ) -> dummy(val=$ctemplate.st))
			dbg.enterAlt(1);

			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:281:2: ( 'sc_signal' ( '_rv' )? ctemplate )
			{
			dbg.location(281,2);
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:281:2: ( 'sc_signal' ( '_rv' )? ctemplate )
			dbg.enterAlt(1);

			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:281:3: 'sc_signal' ( '_rv' )? ctemplate
			{
			dbg.location(281,3);
			match(input,69,FOLLOW_69_in_sc_signal1293); if (state.failed) return retval;dbg.location(281,14);
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:281:14: ( '_rv' )?
			int alt41=2;
			try { dbg.enterSubRule(41);
			try { dbg.enterDecision(41, decisionCanBacktrack[41]);

			int LA41_0 = input.LA(1);
			if ( (LA41_0==38) ) {
				alt41=1;
			}
			} finally {dbg.exitDecision(41);}

			switch (alt41) {
				case 1 :
					dbg.enterAlt(1);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:281:15: '_rv'
					{
					dbg.location(281,15);
					match(input,38,FOLLOW_38_in_sc_signal1295); if (state.failed) return retval;
					}
					break;

			}
			} finally {dbg.exitSubRule(41);}
			dbg.location(281,22);
			pushFollow(FOLLOW_ctemplate_in_sc_signal1298);
			ctemplate20=ctemplate();
			state._fsp--;
			if (state.failed) return retval;
			}

			// TEMPLATE REWRITE
			if ( state.backtracking==0 ) {
			  // 281:35: -> dummy(val=$ctemplate.st)
			  {
			  	retval.st = templateLib.getInstanceOf("dummy",new STAttrMap().put("val", (ctemplate20!=null?((StringTemplate)ctemplate20.getTemplate()):null)));
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
		dbg.location(282, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "sc_signal");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "sc_signal"


	public static class ctemplate_return extends ParserRuleReturnScope {
		public StringTemplate st;
		public Object getTemplate() { return st; }
		public String toString() { return st==null?null:st.toString(); }
	};


	// $ANTLR start "ctemplate"
	// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:284:1: ctemplate : LT ( signal_type ) GT -> dummy(val=$signal_type.st);
	public final Systemc_basicParser.ctemplate_return ctemplate() throws  {
		Systemc_basicParser.ctemplate_return retval = new Systemc_basicParser.ctemplate_return();
		retval.start = input.LT(1);

		ParserRuleReturnScope signal_type21 =null;

		try { dbg.enterRule(getGrammarFileName(), "ctemplate");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(284, 0);

		try {
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:285:2: ( LT ( signal_type ) GT -> dummy(val=$signal_type.st))
			dbg.enterAlt(1);

			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:285:4: LT ( signal_type ) GT
			{
			dbg.location(285,4);
			match(input,LT,FOLLOW_LT_in_ctemplate1322); if (state.failed) return retval;dbg.location(285,6);
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:285:6: ( signal_type )
			dbg.enterAlt(1);

			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:285:7: signal_type
			{
			dbg.location(285,7);
			pushFollow(FOLLOW_signal_type_in_ctemplate1324);
			signal_type21=signal_type();
			state._fsp--;
			if (state.failed) return retval;
			}
			dbg.location(285,19);
			match(input,GT,FOLLOW_GT_in_ctemplate1326); if (state.failed) return retval;
			// TEMPLATE REWRITE
			if ( state.backtracking==0 ) {
			  // 285:22: -> dummy(val=$signal_type.st)
			  {
			  	retval.st = templateLib.getInstanceOf("dummy",new STAttrMap().put("val", (signal_type21!=null?((StringTemplate)signal_type21.getTemplate()):null)));
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
		dbg.location(286, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "ctemplate");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "ctemplate"


	public static class signal_type_return extends ParserRuleReturnScope {
		public StringTemplate st;
		public Object getTemplate() { return st; }
		public String toString() { return st==null?null:st.toString(); }
	};


	// $ANTLR start "signal_type"
	// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:288:1: signal_type : ( sc_type -> { $sc_type.st}| ID -> dummy(val=$ID.text));
	public final Systemc_basicParser.signal_type_return signal_type() throws  {
		Systemc_basicParser.signal_type_return retval = new Systemc_basicParser.signal_type_return();
		retval.start = input.LT(1);

		Token ID23=null;
		ParserRuleReturnScope sc_type22 =null;

		try { dbg.enterRule(getGrammarFileName(), "signal_type");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(288, 0);

		try {
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:288:13: ( sc_type -> { $sc_type.st}| ID -> dummy(val=$ID.text))
			int alt42=2;
			try { dbg.enterDecision(42, decisionCanBacktrack[42]);

			int LA42_0 = input.LA(1);
			if ( (LA42_0==39||(LA42_0 >= 64 && LA42_0 <= 65)||LA42_0==70) ) {
				alt42=1;
			}
			else if ( (LA42_0==ID) ) {
				alt42=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 42, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(42);}

			switch (alt42) {
				case 1 :
					dbg.enterAlt(1);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:289:3: sc_type
					{
					dbg.location(289,3);
					pushFollow(FOLLOW_sc_type_in_signal_type1346);
					sc_type22=sc_type();
					state._fsp--;
					if (state.failed) return retval;
					// TEMPLATE REWRITE
					if ( state.backtracking==0 ) {
					  // 289:11: -> { $sc_type.st}
					  {
					  	retval.st =  (sc_type22!=null?((StringTemplate)sc_type22.getTemplate()):null);
					  }


					}

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:290:5: ID
					{
					dbg.location(290,5);
					ID23=(Token)match(input,ID,FOLLOW_ID_in_signal_type1355); if (state.failed) return retval;
					// TEMPLATE REWRITE
					if ( state.backtracking==0 ) {
					  // 290:8: -> dummy(val=$ID.text)
					  {
					  	retval.st = templateLib.getInstanceOf("dummy",new STAttrMap().put("val", (ID23!=null?ID23.getText():null)));
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
		dbg.location(291, 1);

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
	// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:293:1: func_call : ( ID ) '(' ( func_arg ( ',' func_arg )* )? ')' -> func_call(name=$ID.textargs=$slist::stack);
	public final Systemc_basicParser.func_call_return func_call() throws  {
		slist_stack.push(new slist_scope());

		Systemc_basicParser.func_call_return retval = new Systemc_basicParser.func_call_return();
		retval.start = input.LT(1);

		Token ID24=null;


		  slist_stack.peek().stack = new ArrayList();

		try { dbg.enterRule(getGrammarFileName(), "func_call");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(293, 0);

		try {
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:298:2: ( ( ID ) '(' ( func_arg ( ',' func_arg )* )? ')' -> func_call(name=$ID.textargs=$slist::stack))
			dbg.enterAlt(1);

			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:299:2: ( ID ) '(' ( func_arg ( ',' func_arg )* )? ')'
			{
			dbg.location(299,2);
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:299:2: ( ID )
			dbg.enterAlt(1);

			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:299:3: ID
			{
			dbg.location(299,3);
			ID24=(Token)match(input,ID,FOLLOW_ID_in_func_call1388); if (state.failed) return retval;
			}
			dbg.location(299,6);
			match(input,23,FOLLOW_23_in_func_call1390); if (state.failed) return retval;dbg.location(299,9);
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:299:9: ( func_arg ( ',' func_arg )* )?
			int alt44=2;
			try { dbg.enterSubRule(44);
			try { dbg.enterDecision(44, decisionCanBacktrack[44]);

			int LA44_0 = input.LA(1);
			if ( (LA44_0==BIN||(LA44_0 >= HEX && LA44_0 <= ID)||LA44_0==INT||LA44_0==NOT||LA44_0==STRING_LITERAL||LA44_0==23||LA44_0==39||LA44_0==43||(LA44_0 >= 53 && LA44_0 <= 56)||(LA44_0 >= 64 && LA44_0 <= 65)||LA44_0==70||(LA44_0 >= 75 && LA44_0 <= 76)) ) {
				alt44=1;
			}
			} finally {dbg.exitDecision(44);}

			switch (alt44) {
				case 1 :
					dbg.enterAlt(1);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:299:10: func_arg ( ',' func_arg )*
					{
					dbg.location(299,10);
					pushFollow(FOLLOW_func_arg_in_func_call1392);
					func_arg();
					state._fsp--;
					if (state.failed) return retval;dbg.location(299,19);
					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:299:19: ( ',' func_arg )*
					try { dbg.enterSubRule(43);

					loop43:
					while (true) {
						int alt43=2;
						try { dbg.enterDecision(43, decisionCanBacktrack[43]);

						int LA43_0 = input.LA(1);
						if ( (LA43_0==26) ) {
							alt43=1;
						}

						} finally {dbg.exitDecision(43);}

						switch (alt43) {
						case 1 :
							dbg.enterAlt(1);

							// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:299:20: ',' func_arg
							{
							dbg.location(299,20);
							match(input,26,FOLLOW_26_in_func_call1395); if (state.failed) return retval;dbg.location(299,24);
							pushFollow(FOLLOW_func_arg_in_func_call1397);
							func_arg();
							state._fsp--;
							if (state.failed) return retval;
							}
							break;

						default :
							break loop43;
						}
					}
					} finally {dbg.exitSubRule(43);}

					}
					break;

			}
			} finally {dbg.exitSubRule(44);}
			dbg.location(299,36);
			match(input,24,FOLLOW_24_in_func_call1402); if (state.failed) return retval;
			// TEMPLATE REWRITE
			if ( state.backtracking==0 ) {
			  // 299:40: -> func_call(name=$ID.textargs=$slist::stack)
			  {
			  	retval.st = templateLib.getInstanceOf("func_call",new STAttrMap().put("name", (ID24!=null?ID24.getText():null)).put("args", slist_stack.peek().stack));
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
		dbg.location(300, 1);

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
	// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:302:1: port_decl : port_type name ( ',' name )* -> port(name=$slist::namestype=$port_type.st);
	public final Systemc_basicParser.port_decl_return port_decl() throws  {
		slist_stack.push(new slist_scope());

		Systemc_basicParser.port_decl_return retval = new Systemc_basicParser.port_decl_return();
		retval.start = input.LT(1);

		ParserRuleReturnScope port_type25 =null;


		  slist_stack.peek().names = new ArrayList();

		try { dbg.enterRule(getGrammarFileName(), "port_decl");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(302, 0);

		try {
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:306:2: ( port_type name ( ',' name )* -> port(name=$slist::namestype=$port_type.st))
			dbg.enterAlt(1);

			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:307:2: port_type name ( ',' name )*
			{
			dbg.location(307,2);
			pushFollow(FOLLOW_port_type_in_port_decl1441);
			port_type25=port_type();
			state._fsp--;
			if (state.failed) return retval;dbg.location(307,12);
			pushFollow(FOLLOW_name_in_port_decl1443);
			name();
			state._fsp--;
			if (state.failed) return retval;dbg.location(307,17);
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:307:17: ( ',' name )*
			try { dbg.enterSubRule(45);

			loop45:
			while (true) {
				int alt45=2;
				try { dbg.enterDecision(45, decisionCanBacktrack[45]);

				int LA45_0 = input.LA(1);
				if ( (LA45_0==26) ) {
					alt45=1;
				}

				} finally {dbg.exitDecision(45);}

				switch (alt45) {
				case 1 :
					dbg.enterAlt(1);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:307:18: ',' name
					{
					dbg.location(307,18);
					match(input,26,FOLLOW_26_in_port_decl1446); if (state.failed) return retval;dbg.location(307,22);
					pushFollow(FOLLOW_name_in_port_decl1448);
					name();
					state._fsp--;
					if (state.failed) return retval;
					}
					break;

				default :
					break loop45;
				}
			}
			} finally {dbg.exitSubRule(45);}
			dbg.location(307,29);
			if ( state.backtracking==0 ) {SignalAssignementConversion.getInstance().registerType(slist_stack.peek().names, (port_type25!=null?((StringTemplate)port_type25.getTemplate()):null).toString());}
			// TEMPLATE REWRITE
			if ( state.backtracking==0 ) {
			  // 307:128: -> port(name=$slist::namestype=$port_type.st)
			  {
			  	retval.st = templateLib.getInstanceOf("port",new STAttrMap().put("name", slist_stack.peek().names).put("type", (port_type25!=null?((StringTemplate)port_type25.getTemplate()):null)));
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
		dbg.location(308, 1);

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
	// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:311:1: name : ID ;
	public final Systemc_basicParser.name_return name() throws  {
		Systemc_basicParser.name_return retval = new Systemc_basicParser.name_return();
		retval.start = input.LT(1);

		Token ID26=null;

		try { dbg.enterRule(getGrammarFileName(), "name");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(311, 0);

		try {
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:312:2: ( ID )
			dbg.enterAlt(1);

			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:313:2: ID
			{
			dbg.location(313,2);
			ID26=(Token)match(input,ID,FOLLOW_ID_in_name1481); if (state.failed) return retval;dbg.location(313,5);
			if ( state.backtracking==0 ) {slist_stack.peek().names.add((ID26!=null?ID26.getText():null));}
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
		dbg.location(314, 1);

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
	// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:316:1: port_type : ( sc_clock -> clock_type(| sc_in -> input_type(type=$sc_in.st)| sc_out -> output_type(type=$sc_out.st)| sc_inout -> inout_type(type=$sc_inout.st));
	public final Systemc_basicParser.port_type_return port_type() throws  {
		Systemc_basicParser.port_type_return retval = new Systemc_basicParser.port_type_return();
		retval.start = input.LT(1);

		ParserRuleReturnScope sc_in27 =null;
		ParserRuleReturnScope sc_out28 =null;
		ParserRuleReturnScope sc_inout29 =null;

		try { dbg.enterRule(getGrammarFileName(), "port_type");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(316, 0);

		try {
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:316:11: ( sc_clock -> clock_type(| sc_in -> input_type(type=$sc_in.st)| sc_out -> output_type(type=$sc_out.st)| sc_inout -> inout_type(type=$sc_inout.st))
			int alt46=4;
			try { dbg.enterDecision(46, decisionCanBacktrack[46]);

			switch ( input.LA(1) ) {
			case 58:
				{
				alt46=1;
				}
				break;
			case 57:
			case 59:
			case 60:
				{
				alt46=2;
				}
				break;
			case 66:
			case 67:
			case 68:
				{
				alt46=3;
				}
				break;
			case 61:
			case 62:
			case 63:
				{
				alt46=4;
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

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:317:3: sc_clock
					{
					dbg.location(317,3);
					pushFollow(FOLLOW_sc_clock_in_port_type1495);
					sc_clock();
					state._fsp--;
					if (state.failed) return retval;
					// TEMPLATE REWRITE
					if ( state.backtracking==0 ) {
					  // 317:12: -> clock_type(
					  {
					  	retval.st = templateLib.getInstanceOf("clock_type");
					  }


					}

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:318:3: sc_in
					{
					dbg.location(318,3);
					pushFollow(FOLLOW_sc_in_in_port_type1505);
					sc_in27=sc_in();
					state._fsp--;
					if (state.failed) return retval;
					// TEMPLATE REWRITE
					if ( state.backtracking==0 ) {
					  // 318:9: -> input_type(type=$sc_in.st)
					  {
					  	retval.st = templateLib.getInstanceOf("input_type",new STAttrMap().put("type", (sc_in27!=null?((StringTemplate)sc_in27.getTemplate()):null)));
					  }


					}

					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:319:3: sc_out
					{
					dbg.location(319,3);
					pushFollow(FOLLOW_sc_out_in_port_type1518);
					sc_out28=sc_out();
					state._fsp--;
					if (state.failed) return retval;
					// TEMPLATE REWRITE
					if ( state.backtracking==0 ) {
					  // 319:10: -> output_type(type=$sc_out.st)
					  {
					  	retval.st = templateLib.getInstanceOf("output_type",new STAttrMap().put("type", (sc_out28!=null?((StringTemplate)sc_out28.getTemplate()):null)));
					  }


					}

					}
					break;
				case 4 :
					dbg.enterAlt(4);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:320:3: sc_inout
					{
					dbg.location(320,3);
					pushFollow(FOLLOW_sc_inout_in_port_type1531);
					sc_inout29=sc_inout();
					state._fsp--;
					if (state.failed) return retval;
					// TEMPLATE REWRITE
					if ( state.backtracking==0 ) {
					  // 320:12: -> inout_type(type=$sc_inout.st)
					  {
					  	retval.st = templateLib.getInstanceOf("inout_type",new STAttrMap().put("type", (sc_inout29!=null?((StringTemplate)sc_inout29.getTemplate()):null)));
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
		dbg.location(321, 1);

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
	// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:324:1: sc_inout : ( 'sc_inout' ( ctemplate ) -> dummy(val=$ctemplate.st)| 'sc_inout_resolved' -> logic(| 'sc_inout_rv' ( ctemplate ) -> logic_vector(size=$ctemplate.text));
	public final Systemc_basicParser.sc_inout_return sc_inout() throws  {
		Systemc_basicParser.sc_inout_return retval = new Systemc_basicParser.sc_inout_return();
		retval.start = input.LT(1);

		ParserRuleReturnScope ctemplate30 =null;
		ParserRuleReturnScope ctemplate31 =null;

		try { dbg.enterRule(getGrammarFileName(), "sc_inout");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(324, 0);

		try {
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:324:10: ( 'sc_inout' ( ctemplate ) -> dummy(val=$ctemplate.st)| 'sc_inout_resolved' -> logic(| 'sc_inout_rv' ( ctemplate ) -> logic_vector(size=$ctemplate.text))
			int alt47=3;
			try { dbg.enterDecision(47, decisionCanBacktrack[47]);

			switch ( input.LA(1) ) {
			case 61:
				{
				alt47=1;
				}
				break;
			case 62:
				{
				alt47=2;
				}
				break;
			case 63:
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

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:325:2: 'sc_inout' ( ctemplate )
					{
					dbg.location(325,2);
					match(input,61,FOLLOW_61_in_sc_inout1552); if (state.failed) return retval;dbg.location(325,12);
					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:325:12: ( ctemplate )
					dbg.enterAlt(1);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:325:13: ctemplate
					{
					dbg.location(325,13);
					pushFollow(FOLLOW_ctemplate_in_sc_inout1554);
					ctemplate30=ctemplate();
					state._fsp--;
					if (state.failed) return retval;
					}

					// TEMPLATE REWRITE
					if ( state.backtracking==0 ) {
					  // 325:25: -> dummy(val=$ctemplate.st)
					  {
					  	retval.st = templateLib.getInstanceOf("dummy",new STAttrMap().put("val", (ctemplate30!=null?((StringTemplate)ctemplate30.getTemplate()):null)));
					  }


					}

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:326:4: 'sc_inout_resolved'
					{
					dbg.location(326,4);
					match(input,62,FOLLOW_62_in_sc_inout1569); if (state.failed) return retval;
					// TEMPLATE REWRITE
					if ( state.backtracking==0 ) {
					  // 326:26: -> logic(
					  {
					  	retval.st = templateLib.getInstanceOf("logic");
					  }


					}

					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:327:4: 'sc_inout_rv' ( ctemplate )
					{
					dbg.location(327,4);
					match(input,63,FOLLOW_63_in_sc_inout1582); if (state.failed) return retval;dbg.location(327,17);
					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:327:17: ( ctemplate )
					dbg.enterAlt(1);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:327:18: ctemplate
					{
					dbg.location(327,18);
					pushFollow(FOLLOW_ctemplate_in_sc_inout1584);
					ctemplate31=ctemplate();
					state._fsp--;
					if (state.failed) return retval;
					}

					// TEMPLATE REWRITE
					if ( state.backtracking==0 ) {
					  // 327:30: -> logic_vector(size=$ctemplate.text)
					  {
					  	retval.st = templateLib.getInstanceOf("logic_vector",new STAttrMap().put("size", (ctemplate31!=null?input.toString(ctemplate31.start,ctemplate31.stop):null)));
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
		dbg.location(328, 1);

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
	// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:331:1: sc_out : ( 'sc_out' ( ctemplate ) -> dummy(val=$ctemplate.st)| 'sc_out_resolved' -> logic(| 'sc_out_rv' ( ctemplate ) -> logic_vector(size=$ctemplate.text));
	public final Systemc_basicParser.sc_out_return sc_out() throws  {
		Systemc_basicParser.sc_out_return retval = new Systemc_basicParser.sc_out_return();
		retval.start = input.LT(1);

		ParserRuleReturnScope ctemplate32 =null;
		ParserRuleReturnScope ctemplate33 =null;

		try { dbg.enterRule(getGrammarFileName(), "sc_out");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(331, 0);

		try {
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:331:8: ( 'sc_out' ( ctemplate ) -> dummy(val=$ctemplate.st)| 'sc_out_resolved' -> logic(| 'sc_out_rv' ( ctemplate ) -> logic_vector(size=$ctemplate.text))
			int alt48=3;
			try { dbg.enterDecision(48, decisionCanBacktrack[48]);

			switch ( input.LA(1) ) {
			case 66:
				{
				alt48=1;
				}
				break;
			case 67:
				{
				alt48=2;
				}
				break;
			case 68:
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

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:332:2: 'sc_out' ( ctemplate )
					{
					dbg.location(332,2);
					match(input,66,FOLLOW_66_in_sc_out1609); if (state.failed) return retval;dbg.location(332,11);
					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:332:11: ( ctemplate )
					dbg.enterAlt(1);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:332:12: ctemplate
					{
					dbg.location(332,12);
					pushFollow(FOLLOW_ctemplate_in_sc_out1612);
					ctemplate32=ctemplate();
					state._fsp--;
					if (state.failed) return retval;
					}

					// TEMPLATE REWRITE
					if ( state.backtracking==0 ) {
					  // 332:23: -> dummy(val=$ctemplate.st)
					  {
					  	retval.st = templateLib.getInstanceOf("dummy",new STAttrMap().put("val", (ctemplate32!=null?((StringTemplate)ctemplate32.getTemplate()):null)));
					  }


					}

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:333:4: 'sc_out_resolved'
					{
					dbg.location(333,4);
					match(input,67,FOLLOW_67_in_sc_out1626); if (state.failed) return retval;
					// TEMPLATE REWRITE
					if ( state.backtracking==0 ) {
					  // 333:23: -> logic(
					  {
					  	retval.st = templateLib.getInstanceOf("logic");
					  }


					}

					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:334:4: 'sc_out_rv' ( ctemplate )
					{
					dbg.location(334,4);
					match(input,68,FOLLOW_68_in_sc_out1639); if (state.failed) return retval;dbg.location(334,15);
					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:334:15: ( ctemplate )
					dbg.enterAlt(1);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:334:16: ctemplate
					{
					dbg.location(334,16);
					pushFollow(FOLLOW_ctemplate_in_sc_out1641);
					ctemplate33=ctemplate();
					state._fsp--;
					if (state.failed) return retval;
					}

					// TEMPLATE REWRITE
					if ( state.backtracking==0 ) {
					  // 334:28: -> logic_vector(size=$ctemplate.text)
					  {
					  	retval.st = templateLib.getInstanceOf("logic_vector",new STAttrMap().put("size", (ctemplate33!=null?input.toString(ctemplate33.start,ctemplate33.stop):null)));
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
		dbg.location(335, 1);

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
	// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:337:1: sc_in : ( 'sc_in' ( ctemplate ) -> dummy(val=$ctemplate.st)| 'sc_in_resolved' -> logic(| 'sc_in_rv' ( ctemplate ) -> logic_vector(size=$ctemplate.text));
	public final Systemc_basicParser.sc_in_return sc_in() throws  {
		Systemc_basicParser.sc_in_return retval = new Systemc_basicParser.sc_in_return();
		retval.start = input.LT(1);

		ParserRuleReturnScope ctemplate34 =null;
		ParserRuleReturnScope ctemplate35 =null;

		try { dbg.enterRule(getGrammarFileName(), "sc_in");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(337, 0);

		try {
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:337:7: ( 'sc_in' ( ctemplate ) -> dummy(val=$ctemplate.st)| 'sc_in_resolved' -> logic(| 'sc_in_rv' ( ctemplate ) -> logic_vector(size=$ctemplate.text))
			int alt49=3;
			try { dbg.enterDecision(49, decisionCanBacktrack[49]);

			switch ( input.LA(1) ) {
			case 57:
				{
				alt49=1;
				}
				break;
			case 59:
				{
				alt49=2;
				}
				break;
			case 60:
				{
				alt49=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 49, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}
			} finally {dbg.exitDecision(49);}

			switch (alt49) {
				case 1 :
					dbg.enterAlt(1);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:338:2: 'sc_in' ( ctemplate )
					{
					dbg.location(338,2);
					match(input,57,FOLLOW_57_in_sc_in1663); if (state.failed) return retval;dbg.location(338,9);
					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:338:9: ( ctemplate )
					dbg.enterAlt(1);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:338:10: ctemplate
					{
					dbg.location(338,10);
					pushFollow(FOLLOW_ctemplate_in_sc_in1665);
					ctemplate34=ctemplate();
					state._fsp--;
					if (state.failed) return retval;
					}

					// TEMPLATE REWRITE
					if ( state.backtracking==0 ) {
					  // 338:21: -> dummy(val=$ctemplate.st)
					  {
					  	retval.st = templateLib.getInstanceOf("dummy",new STAttrMap().put("val", (ctemplate34!=null?((StringTemplate)ctemplate34.getTemplate()):null)));
					  }


					}

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:339:4: 'sc_in_resolved'
					{
					dbg.location(339,4);
					match(input,59,FOLLOW_59_in_sc_in1679); if (state.failed) return retval;
					// TEMPLATE REWRITE
					if ( state.backtracking==0 ) {
					  // 339:22: -> logic(
					  {
					  	retval.st = templateLib.getInstanceOf("logic");
					  }


					}

					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:340:4: 'sc_in_rv' ( ctemplate )
					{
					dbg.location(340,4);
					match(input,60,FOLLOW_60_in_sc_in1692); if (state.failed) return retval;dbg.location(340,14);
					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:340:14: ( ctemplate )
					dbg.enterAlt(1);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:340:15: ctemplate
					{
					dbg.location(340,15);
					pushFollow(FOLLOW_ctemplate_in_sc_in1694);
					ctemplate35=ctemplate();
					state._fsp--;
					if (state.failed) return retval;
					}

					// TEMPLATE REWRITE
					if ( state.backtracking==0 ) {
					  // 340:27: -> logic_vector(size=$ctemplate.text)
					  {
					  	retval.st = templateLib.getInstanceOf("logic_vector",new STAttrMap().put("size", (ctemplate35!=null?input.toString(ctemplate35.start,ctemplate35.stop):null)));
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
		dbg.location(341, 1);

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
	// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:343:1: sc_clock : 'sc_in_clk' ;
	public final Systemc_basicParser.sc_clock_return sc_clock() throws  {
		Systemc_basicParser.sc_clock_return retval = new Systemc_basicParser.sc_clock_return();
		retval.start = input.LT(1);

		try { dbg.enterRule(getGrammarFileName(), "sc_clock");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(343, 0);

		try {
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:343:10: ( 'sc_in_clk' )
			dbg.enterAlt(1);

			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:344:2: 'sc_in_clk'
			{
			dbg.location(344,2);
			match(input,58,FOLLOW_58_in_sc_clock1716); if (state.failed) return retval;
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
		dbg.location(345, 1);

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
	// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:348:1: func_body : block -> func_body(declarations=$block.varsoperations=$block.elts);
	public final Systemc_basicParser.func_body_return func_body() throws  {
		Systemc_basicParser.func_body_return retval = new Systemc_basicParser.func_body_return();
		retval.start = input.LT(1);

		ParserRuleReturnScope block36 =null;

		try { dbg.enterRule(getGrammarFileName(), "func_body");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(348, 0);

		try {
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:349:2: ( block -> func_body(declarations=$block.varsoperations=$block.elts))
			dbg.enterAlt(1);

			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:350:2: block
			{
			dbg.location(350,2);
			pushFollow(FOLLOW_block_in_func_body1729);
			block36=block();
			state._fsp--;
			if (state.failed) return retval;
			// TEMPLATE REWRITE
			if ( state.backtracking==0 ) {
			  // 350:8: -> func_body(declarations=$block.varsoperations=$block.elts)
			  {
			  	retval.st = templateLib.getInstanceOf("func_body",new STAttrMap().put("declarations", (block36!=null?((Systemc_basicParser.block_return)block36).vars:null)).put("operations", (block36!=null?((Systemc_basicParser.block_return)block36).elts:null)));
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
		dbg.location(351, 1);

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
	// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:353:1: block returns [List elts, HashMap vars] : '{' ( variable_decl[$vars] SEMICOLON | sc_assignement SEMICOLON | v_assignement SEMICOLON | cconstruct | func_call SEMICOLON | flux SEMICOLON )* '}' ;
	public final Systemc_basicParser.block_return block() throws  {
		Systemc_basicParser.block_return retval = new Systemc_basicParser.block_return();
		retval.start = input.LT(1);

		ParserRuleReturnScope sc_assignement37 =null;
		ParserRuleReturnScope v_assignement38 =null;
		ParserRuleReturnScope cconstruct39 =null;


		  retval.elts = new ArrayList();
		  retval.vars = new HashMap();

		try { dbg.enterRule(getGrammarFileName(), "block");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(353, 0);

		try {
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:358:2: ( '{' ( variable_decl[$vars] SEMICOLON | sc_assignement SEMICOLON | v_assignement SEMICOLON | cconstruct | func_call SEMICOLON | flux SEMICOLON )* '}' )
			dbg.enterAlt(1);

			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:360:2: '{' ( variable_decl[$vars] SEMICOLON | sc_assignement SEMICOLON | v_assignement SEMICOLON | cconstruct | func_call SEMICOLON | flux SEMICOLON )* '}'
			{
			dbg.location(360,2);
			match(input,80,FOLLOW_80_in_block1769); if (state.failed) return retval;dbg.location(361,2);
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:361:2: ( variable_decl[$vars] SEMICOLON | sc_assignement SEMICOLON | v_assignement SEMICOLON | cconstruct | func_call SEMICOLON | flux SEMICOLON )*
			try { dbg.enterSubRule(50);

			loop50:
			while (true) {
				int alt50=7;
				try { dbg.enterDecision(50, decisionCanBacktrack[50]);

				switch ( input.LA(1) ) {
				case 39:
				case 42:
				case 49:
				case 51:
				case 52:
				case 64:
				case 65:
				case 70:
				case 72:
				case 73:
				case 77:
				case 78:
					{
					alt50=1;
					}
					break;
				case ID:
					{
					switch ( input.LA(2) ) {
					case EQUAL:
						{
						alt50=3;
						}
						break;
					case 23:
						{
						alt50=5;
						}
						break;
					case 30:
					case 31:
						{
						alt50=6;
						}
						break;
					case ID:
					case LT:
					case 25:
					case 36:
						{
						alt50=1;
						}
						break;
					case 28:
					case 35:
						{
						alt50=2;
						}
						break;
					}
					}
					break;
				case 50:
				case 74:
				case 79:
					{
					alt50=4;
					}
					break;
				}
				} finally {dbg.exitDecision(50);}

				switch (alt50) {
				case 1 :
					dbg.enterAlt(1);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:361:3: variable_decl[$vars] SEMICOLON
					{
					dbg.location(361,3);
					pushFollow(FOLLOW_variable_decl_in_block1773);
					variable_decl(retval.vars);
					state._fsp--;
					if (state.failed) return retval;dbg.location(361,24);
					match(input,SEMICOLON,FOLLOW_SEMICOLON_in_block1776); if (state.failed) return retval;
					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:362:3: sc_assignement SEMICOLON
					{
					dbg.location(362,3);
					pushFollow(FOLLOW_sc_assignement_in_block1780);
					sc_assignement37=sc_assignement();
					state._fsp--;
					if (state.failed) return retval;dbg.location(362,18);
					match(input,SEMICOLON,FOLLOW_SEMICOLON_in_block1782); if (state.failed) return retval;dbg.location(362,27);
					if ( state.backtracking==0 ) { retval.elts.add((sc_assignement37!=null?((StringTemplate)sc_assignement37.getTemplate()):null));}
					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:363:3: v_assignement SEMICOLON
					{
					dbg.location(363,3);
					pushFollow(FOLLOW_v_assignement_in_block1787);
					v_assignement38=v_assignement();
					state._fsp--;
					if (state.failed) return retval;dbg.location(363,17);
					match(input,SEMICOLON,FOLLOW_SEMICOLON_in_block1789); if (state.failed) return retval;dbg.location(363,26);
					if ( state.backtracking==0 ) { retval.elts.add((v_assignement38!=null?((StringTemplate)v_assignement38.getTemplate()):null));}
					}
					break;
				case 4 :
					dbg.enterAlt(4);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:364:3: cconstruct
					{
					dbg.location(364,3);
					pushFollow(FOLLOW_cconstruct_in_block1794);
					cconstruct39=cconstruct();
					state._fsp--;
					if (state.failed) return retval;dbg.location(364,15);
					if ( state.backtracking==0 ) { retval.elts.add((cconstruct39!=null?((StringTemplate)cconstruct39.getTemplate()):null));}
					}
					break;
				case 5 :
					dbg.enterAlt(5);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:365:3: func_call SEMICOLON
					{
					dbg.location(365,3);
					pushFollow(FOLLOW_func_call_in_block1801);
					func_call();
					state._fsp--;
					if (state.failed) return retval;dbg.location(365,13);
					match(input,SEMICOLON,FOLLOW_SEMICOLON_in_block1803); if (state.failed) return retval;
					}
					break;
				case 6 :
					dbg.enterAlt(6);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:366:4: flux SEMICOLON
					{
					dbg.location(366,4);
					pushFollow(FOLLOW_flux_in_block1808);
					flux();
					state._fsp--;
					if (state.failed) return retval;dbg.location(366,9);
					match(input,SEMICOLON,FOLLOW_SEMICOLON_in_block1810); if (state.failed) return retval;
					}
					break;

				default :
					break loop50;
				}
			}
			} finally {dbg.exitSubRule(50);}
			dbg.location(367,2);
			match(input,82,FOLLOW_82_in_block1815); if (state.failed) return retval;
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
		dbg.location(368, 1);

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
	// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:370:1: cconstruct : ( case_construct -> dummy(val=$case_construct.st)| if_construct -> dummy(val=$if_construct.st)| while_construct );
	public final Systemc_basicParser.cconstruct_return cconstruct() throws  {
		Systemc_basicParser.cconstruct_return retval = new Systemc_basicParser.cconstruct_return();
		retval.start = input.LT(1);

		ParserRuleReturnScope case_construct40 =null;
		ParserRuleReturnScope if_construct41 =null;

		try { dbg.enterRule(getGrammarFileName(), "cconstruct");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(370, 0);

		try {
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:371:2: ( case_construct -> dummy(val=$case_construct.st)| if_construct -> dummy(val=$if_construct.st)| while_construct )
			int alt51=3;
			try { dbg.enterDecision(51, decisionCanBacktrack[51]);

			switch ( input.LA(1) ) {
			case 74:
				{
				alt51=1;
				}
				break;
			case 50:
				{
				alt51=2;
				}
				break;
			case 79:
				{
				alt51=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 51, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}
			} finally {dbg.exitDecision(51);}

			switch (alt51) {
				case 1 :
					dbg.enterAlt(1);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:372:2: case_construct
					{
					dbg.location(372,2);
					pushFollow(FOLLOW_case_construct_in_cconstruct1828);
					case_construct40=case_construct();
					state._fsp--;
					if (state.failed) return retval;
					// TEMPLATE REWRITE
					if ( state.backtracking==0 ) {
					  // 372:17: -> dummy(val=$case_construct.st)
					  {
					  	retval.st = templateLib.getInstanceOf("dummy",new STAttrMap().put("val", (case_construct40!=null?((StringTemplate)case_construct40.getTemplate()):null)));
					  }


					}

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:373:3: if_construct
					{
					dbg.location(373,3);
					pushFollow(FOLLOW_if_construct_in_cconstruct1842);
					if_construct41=if_construct();
					state._fsp--;
					if (state.failed) return retval;
					// TEMPLATE REWRITE
					if ( state.backtracking==0 ) {
					  // 373:16: -> dummy(val=$if_construct.st)
					  {
					  	retval.st = templateLib.getInstanceOf("dummy",new STAttrMap().put("val", (if_construct41!=null?((StringTemplate)if_construct41.getTemplate()):null)));
					  }


					}

					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:374:3: while_construct
					{
					dbg.location(374,3);
					pushFollow(FOLLOW_while_construct_in_cconstruct1856);
					while_construct();
					state._fsp--;
					if (state.failed) return retval;
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
		dbg.location(375, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "cconstruct");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "cconstruct"


	public static class while_construct_return extends ParserRuleReturnScope {
		public StringTemplate st;
		public Object getTemplate() { return st; }
		public String toString() { return st==null?null:st.toString(); }
	};


	// $ANTLR start "while_construct"
	// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:377:1: while_construct : 'while' '(' cond ')' ( if_content ) ;
	public final Systemc_basicParser.while_construct_return while_construct() throws  {
		Systemc_basicParser.while_construct_return retval = new Systemc_basicParser.while_construct_return();
		retval.start = input.LT(1);

		try { dbg.enterRule(getGrammarFileName(), "while_construct");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(377, 0);

		try {
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:378:2: ( 'while' '(' cond ')' ( if_content ) )
			dbg.enterAlt(1);

			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:379:2: 'while' '(' cond ')' ( if_content )
			{
			dbg.location(379,2);
			match(input,79,FOLLOW_79_in_while_construct1869); if (state.failed) return retval;dbg.location(379,9);
			match(input,23,FOLLOW_23_in_while_construct1870); if (state.failed) return retval;dbg.location(379,12);
			pushFollow(FOLLOW_cond_in_while_construct1871);
			cond();
			state._fsp--;
			if (state.failed) return retval;dbg.location(379,17);
			match(input,24,FOLLOW_24_in_while_construct1873); if (state.failed) return retval;dbg.location(379,20);
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:379:20: ( if_content )
			dbg.enterAlt(1);

			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:379:22: if_content
			{
			dbg.location(379,22);
			pushFollow(FOLLOW_if_content_in_while_construct1876);
			if_content();
			state._fsp--;
			if (state.failed) return retval;
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
		dbg.location(380, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "while_construct");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "while_construct"


	public static class if_construct_return extends ParserRuleReturnScope {
		public StringTemplate st;
		public Object getTemplate() { return st; }
		public String toString() { return st==null?null:st.toString(); }
	};


	// $ANTLR start "if_construct"
	// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:383:1: if_construct : 'if' '(' cond ')' ( if_content ) ( elsif_construct )* -> if_construct(condition=$cond.stelts=$if_content.contentalternatives= $slist::stack);
	public final Systemc_basicParser.if_construct_return if_construct() throws  {
		slist_stack.push(new slist_scope());

		Systemc_basicParser.if_construct_return retval = new Systemc_basicParser.if_construct_return();
		retval.start = input.LT(1);

		ParserRuleReturnScope elsif_construct42 =null;
		ParserRuleReturnScope cond43 =null;
		ParserRuleReturnScope if_content44 =null;


		  slist_stack.peek().stack = new ArrayList();

		try { dbg.enterRule(getGrammarFileName(), "if_construct");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(383, 0);

		try {
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:388:2: ( 'if' '(' cond ')' ( if_content ) ( elsif_construct )* -> if_construct(condition=$cond.stelts=$if_content.contentalternatives= $slist::stack))
			dbg.enterAlt(1);

			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:389:2: 'if' '(' cond ')' ( if_content ) ( elsif_construct )*
			{
			dbg.location(389,2);
			match(input,50,FOLLOW_50_in_if_construct1900); if (state.failed) return retval;dbg.location(389,6);
			match(input,23,FOLLOW_23_in_if_construct1901); if (state.failed) return retval;dbg.location(389,9);
			pushFollow(FOLLOW_cond_in_if_construct1902);
			cond43=cond();
			state._fsp--;
			if (state.failed) return retval;dbg.location(389,14);
			match(input,24,FOLLOW_24_in_if_construct1904); if (state.failed) return retval;dbg.location(389,17);
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:389:17: ( if_content )
			dbg.enterAlt(1);

			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:389:19: if_content
			{
			dbg.location(389,19);
			pushFollow(FOLLOW_if_content_in_if_construct1907);
			if_content44=if_content();
			state._fsp--;
			if (state.failed) return retval;
			}
			dbg.location(390,2);
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:390:2: ( elsif_construct )*
			try { dbg.enterSubRule(52);

			loop52:
			while (true) {
				int alt52=2;
				try { dbg.enterDecision(52, decisionCanBacktrack[52]);

				int LA52_0 = input.LA(1);
				if ( (LA52_0==46) ) {
					alt52=1;
				}

				} finally {dbg.exitDecision(52);}

				switch (alt52) {
				case 1 :
					dbg.enterAlt(1);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:390:3: elsif_construct
					{
					dbg.location(390,3);
					pushFollow(FOLLOW_elsif_construct_in_if_construct1912);
					elsif_construct42=elsif_construct();
					state._fsp--;
					if (state.failed) return retval;dbg.location(390,19);
					if ( state.backtracking==0 ) { slist_stack.peek().stack.add((elsif_construct42!=null?((StringTemplate)elsif_construct42.getTemplate()):null));}
					}
					break;

				default :
					break loop52;
				}
			}
			} finally {dbg.exitSubRule(52);}

			// TEMPLATE REWRITE
			if ( state.backtracking==0 ) {
			  // 390:65: -> if_construct(condition=$cond.stelts=$if_content.contentalternatives= $slist::stack)
			  {
			  	retval.st = templateLib.getInstanceOf("if_construct",new STAttrMap().put("condition", (cond43!=null?((StringTemplate)cond43.getTemplate()):null)).put("elts", (if_content44!=null?((Systemc_basicParser.if_content_return)if_content44).content:null)).put("alternatives",  slist_stack.peek().stack));
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
		dbg.location(391, 1);

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
	// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:393:1: elsif_construct : 'else' ( 'if' '(' cond ')' (ifc= if_content ) -> elsif_construct(condition=$cond.stelts=$ifc.content)|elsec= if_content -> else_construct(elts=$elsec.content)) ;
	public final Systemc_basicParser.elsif_construct_return elsif_construct() throws  {
		Systemc_basicParser.elsif_construct_return retval = new Systemc_basicParser.elsif_construct_return();
		retval.start = input.LT(1);

		ParserRuleReturnScope ifc =null;
		ParserRuleReturnScope elsec =null;
		ParserRuleReturnScope cond45 =null;

		try { dbg.enterRule(getGrammarFileName(), "elsif_construct");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(393, 0);

		try {
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:394:2: ( 'else' ( 'if' '(' cond ')' (ifc= if_content ) -> elsif_construct(condition=$cond.stelts=$ifc.content)|elsec= if_content -> else_construct(elts=$elsec.content)) )
			dbg.enterAlt(1);

			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:395:2: 'else' ( 'if' '(' cond ')' (ifc= if_content ) -> elsif_construct(condition=$cond.stelts=$ifc.content)|elsec= if_content -> else_construct(elts=$elsec.content))
			{
			dbg.location(395,2);
			match(input,46,FOLLOW_46_in_elsif_construct1955); if (state.failed) return retval;dbg.location(396,2);
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:396:2: ( 'if' '(' cond ')' (ifc= if_content ) -> elsif_construct(condition=$cond.stelts=$ifc.content)|elsec= if_content -> else_construct(elts=$elsec.content))
			int alt53=2;
			try { dbg.enterSubRule(53);
			try { dbg.enterDecision(53, decisionCanBacktrack[53]);

			int LA53_0 = input.LA(1);
			if ( (LA53_0==50) ) {
				alt53=1;
			}
			else if ( (LA53_0==ID||LA53_0==80) ) {
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

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:396:3: 'if' '(' cond ')' (ifc= if_content )
					{
					dbg.location(396,3);
					match(input,50,FOLLOW_50_in_elsif_construct1960); if (state.failed) return retval;dbg.location(396,7);
					match(input,23,FOLLOW_23_in_elsif_construct1961); if (state.failed) return retval;dbg.location(396,10);
					pushFollow(FOLLOW_cond_in_elsif_construct1962);
					cond45=cond();
					state._fsp--;
					if (state.failed) return retval;dbg.location(396,15);
					match(input,24,FOLLOW_24_in_elsif_construct1964); if (state.failed) return retval;dbg.location(396,19);
					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:396:19: (ifc= if_content )
					dbg.enterAlt(1);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:396:20: ifc= if_content
					{
					dbg.location(396,24);
					pushFollow(FOLLOW_if_content_in_elsif_construct1971);
					ifc=if_content();
					state._fsp--;
					if (state.failed) return retval;
					}

					// TEMPLATE REWRITE
					if ( state.backtracking==0 ) {
					  // 396:38: -> elsif_construct(condition=$cond.stelts=$ifc.content)
					  {
					  	retval.st = templateLib.getInstanceOf("elsif_construct",new STAttrMap().put("condition", (cond45!=null?((StringTemplate)cond45.getTemplate()):null)).put("elts", (ifc!=null?((Systemc_basicParser.if_content_return)ifc).content:null)));
					  }


					}

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:397:3: elsec= if_content
					{
					dbg.location(397,9);
					pushFollow(FOLLOW_if_content_in_elsif_construct1997);
					elsec=if_content();
					state._fsp--;
					if (state.failed) return retval;
					// TEMPLATE REWRITE
					if ( state.backtracking==0 ) {
					  // 397:22: -> else_construct(elts=$elsec.content)
					  {
					  	retval.st = templateLib.getInstanceOf("else_construct",new STAttrMap().put("elts", (elsec!=null?((Systemc_basicParser.if_content_return)elsec).content:null)));
					  }


					}

					}
					break;

			}
			} finally {dbg.exitSubRule(53);}

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
	// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:402:1: if_content returns [List content] : ( ( v_assignement ) SEMICOLON | block );
	public final Systemc_basicParser.if_content_return if_content() throws  {
		Systemc_basicParser.if_content_return retval = new Systemc_basicParser.if_content_return();
		retval.start = input.LT(1);

		ParserRuleReturnScope v_assignement46 =null;
		ParserRuleReturnScope block47 =null;


		  retval.content = new ArrayList();

		try { dbg.enterRule(getGrammarFileName(), "if_content");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(402, 0);

		try {
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:406:2: ( ( v_assignement ) SEMICOLON | block )
			int alt54=2;
			try { dbg.enterDecision(54, decisionCanBacktrack[54]);

			int LA54_0 = input.LA(1);
			if ( (LA54_0==ID) ) {
				alt54=1;
			}
			else if ( (LA54_0==80) ) {
				alt54=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 54, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(54);}

			switch (alt54) {
				case 1 :
					dbg.enterAlt(1);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:407:2: ( v_assignement ) SEMICOLON
					{
					dbg.location(407,2);
					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:407:2: ( v_assignement )
					dbg.enterAlt(1);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:407:3: v_assignement
					{
					dbg.location(407,3);
					pushFollow(FOLLOW_v_assignement_in_if_content2033);
					v_assignement46=v_assignement();
					state._fsp--;
					if (state.failed) return retval;
					}
					dbg.location(407,18);
					match(input,SEMICOLON,FOLLOW_SEMICOLON_in_if_content2036); if (state.failed) return retval;dbg.location(407,28);
					if ( state.backtracking==0 ) {retval.content.add((v_assignement46!=null?((StringTemplate)v_assignement46.getTemplate()):null));}
					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:408:4: block
					{
					dbg.location(408,4);
					pushFollow(FOLLOW_block_in_if_content2043);
					block47=block();
					state._fsp--;
					if (state.failed) return retval;dbg.location(408,11);
					if ( state.backtracking==0 ) {retval.content.addAll((block47!=null?((Systemc_basicParser.block_return)block47).elts:null));}
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
		dbg.location(409, 1);

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
	protected Stack<cond_scope> cond_stack = new Stack<cond_scope>();

	public static class cond_return extends ParserRuleReturnScope {
		public StringTemplate st;
		public Object getTemplate() { return st; }
		public String toString() { return st==null?null:st.toString(); }
	};


	// $ANTLR start "cond"
	// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:411:1: cond : test_express -> dummy(val=$test_express.st);
	public final Systemc_basicParser.cond_return cond() throws  {
		cond_stack.push(new cond_scope());
		Systemc_basicParser.cond_return retval = new Systemc_basicParser.cond_return();
		retval.start = input.LT(1);

		ParserRuleReturnScope test_express48 =null;


		  cond_stack.peek().vals = new ArrayList();
		  cond_stack.peek().ops = new ArrayList();

		try { dbg.enterRule(getGrammarFileName(), "cond");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(411, 0);

		try {
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:420:2: ( test_express -> dummy(val=$test_express.st))
			dbg.enterAlt(1);

			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:422:3: test_express
			{
			dbg.location(422,3);
			pushFollow(FOLLOW_test_express_in_cond2073);
			test_express48=test_express();
			state._fsp--;
			if (state.failed) return retval;
			// TEMPLATE REWRITE
			if ( state.backtracking==0 ) {
			  // 422:17: -> dummy(val=$test_express.st)
			  {
			  	retval.st = templateLib.getInstanceOf("dummy",new STAttrMap().put("val", (test_express48!=null?((StringTemplate)test_express48.getTemplate()):null)));
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
		dbg.location(423, 1);

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
	protected Stack<test_express_scope> test_express_stack = new Stack<test_express_scope>();

	public static class test_express_return extends ParserRuleReturnScope {
		public StringTemplate st;
		public Object getTemplate() { return st; }
		public String toString() { return st==null?null:st.toString(); }
	};


	// $ANTLR start "test_express"
	// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:445:1: test_express options {backtrack=true; } : expression ( logic_op tx= test_express )? -> conditions(vals=$test_express::valsops=$test_express::ops);
	public final Systemc_basicParser.test_express_return test_express() throws  {
		test_express_stack.push(new test_express_scope());
		Systemc_basicParser.test_express_return retval = new Systemc_basicParser.test_express_return();
		retval.start = input.LT(1);

		ParserRuleReturnScope tx =null;
		ParserRuleReturnScope expression49 =null;
		ParserRuleReturnScope logic_op50 =null;


		  test_express_stack.peek().vals = new ArrayList();
		  test_express_stack.peek().ops = new ArrayList();

		try { dbg.enterRule(getGrammarFileName(), "test_express");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(445, 0);

		try {
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:456:2: ( expression ( logic_op tx= test_express )? -> conditions(vals=$test_express::valsops=$test_express::ops))
			dbg.enterAlt(1);

			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:457:2: expression ( logic_op tx= test_express )?
			{
			dbg.location(457,2);
			pushFollow(FOLLOW_expression_in_test_express2122);
			expression49=expression();
			state._fsp--;
			if (state.failed) return retval;dbg.location(457,13);
			if ( state.backtracking==0 ) {test_express_stack.peek().vals.add((expression49!=null?((StringTemplate)expression49.getTemplate()):null)) ;}dbg.location(458,2);
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:458:2: ( logic_op tx= test_express )?
			int alt55=2;
			try { dbg.enterSubRule(55);
			try { dbg.enterDecision(55, decisionCanBacktrack[55]);

			int LA55_0 = input.LA(1);
			if ( (LA55_0==22||LA55_0==81) ) {
				alt55=1;
			}
			} finally {dbg.exitDecision(55);}

			switch (alt55) {
				case 1 :
					dbg.enterAlt(1);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:458:3: logic_op tx= test_express
					{
					dbg.location(458,3);
					pushFollow(FOLLOW_logic_op_in_test_express2128);
					logic_op50=logic_op();
					state._fsp--;
					if (state.failed) return retval;dbg.location(458,12);
					if ( state.backtracking==0 ) {test_express_stack.peek().ops.add((logic_op50!=null?((StringTemplate)logic_op50.getTemplate()):null)) ;}dbg.location(458,56);
					pushFollow(FOLLOW_test_express_in_test_express2136);
					tx=test_express();
					state._fsp--;
					if (state.failed) return retval;dbg.location(458,71);
					if ( state.backtracking==0 ) {test_express_stack.peek().vals.add((tx!=null?((StringTemplate)tx.getTemplate()):null)) ;}
					}
					break;

			}
			} finally {dbg.exitSubRule(55);}

			// TEMPLATE REWRITE
			if ( state.backtracking==0 ) {
			  // 458:109: -> conditions(vals=$test_express::valsops=$test_express::ops)
			  {
			  	retval.st = templateLib.getInstanceOf("conditions",new STAttrMap().put("vals", test_express_stack.peek().vals).put("ops", test_express_stack.peek().ops));
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
		dbg.location(459, 1);

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
	// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:461:1: enclosed_expr : '(' expr= test_express ')' -> enclosed(val=$expr.st);
	public final Systemc_basicParser.enclosed_expr_return enclosed_expr() throws  {
		Systemc_basicParser.enclosed_expr_return retval = new Systemc_basicParser.enclosed_expr_return();
		retval.start = input.LT(1);

		ParserRuleReturnScope expr =null;

		try { dbg.enterRule(getGrammarFileName(), "enclosed_expr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(461, 0);

		try {
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:461:15: ( '(' expr= test_express ')' -> enclosed(val=$expr.st))
			dbg.enterAlt(1);

			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:462:2: '(' expr= test_express ')'
			{
			dbg.location(462,2);
			match(input,23,FOLLOW_23_in_enclosed_expr2170); if (state.failed) return retval;dbg.location(462,12);
			pushFollow(FOLLOW_test_express_in_enclosed_expr2177);
			expr=test_express();
			state._fsp--;
			if (state.failed) return retval;dbg.location(462,29);
			match(input,24,FOLLOW_24_in_enclosed_expr2181); if (state.failed) return retval;
			// TEMPLATE REWRITE
			if ( state.backtracking==0 ) {
			  // 462:33: -> enclosed(val=$expr.st)
			  {
			  	retval.st = templateLib.getInstanceOf("enclosed",new STAttrMap().put("val", (expr!=null?((StringTemplate)expr.getTemplate()):null)));
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
	// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:465:1: expression options {backtrack=true; } : ( ( ( NOT )? enclosed_expr ) -> dummy(val=$enclosed_expr.st)| ( test ) -> dummy(val=$test.st));
	public final Systemc_basicParser.expression_return expression() throws  {
		Systemc_basicParser.expression_return retval = new Systemc_basicParser.expression_return();
		retval.start = input.LT(1);

		ParserRuleReturnScope enclosed_expr51 =null;
		ParserRuleReturnScope test52 =null;

		try { dbg.enterRule(getGrammarFileName(), "expression");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(465, 0);

		try {
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:467:4: ( ( ( NOT )? enclosed_expr ) -> dummy(val=$enclosed_expr.st)| ( test ) -> dummy(val=$test.st))
			int alt57=2;
			try { dbg.enterDecision(57, decisionCanBacktrack[57]);

			switch ( input.LA(1) ) {
			case NOT:
				{
				int LA57_1 = input.LA(2);
				if ( (synpred1_Systemc_basic()) ) {
					alt57=1;
				}
				else if ( (true) ) {
					alt57=2;
				}

				}
				break;
			case 23:
				{
				int LA57_2 = input.LA(2);
				if ( (synpred1_Systemc_basic()) ) {
					alt57=1;
				}
				else if ( (true) ) {
					alt57=2;
				}

				}
				break;
			case BIN:
			case HEX:
			case ID:
			case INT:
			case STRING_LITERAL:
			case 39:
			case 43:
			case 53:
			case 54:
			case 55:
			case 56:
			case 64:
			case 65:
			case 70:
			case 75:
			case 76:
				{
				alt57=2;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 57, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}
			} finally {dbg.exitDecision(57);}

			switch (alt57) {
				case 1 :
					dbg.enterAlt(1);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:468:4: ( ( NOT )? enclosed_expr )
					{
					dbg.location(468,4);
					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:468:4: ( ( NOT )? enclosed_expr )
					dbg.enterAlt(1);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:468:5: ( NOT )? enclosed_expr
					{
					dbg.location(468,5);
					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:468:5: ( NOT )?
					int alt56=2;
					try { dbg.enterSubRule(56);
					try { dbg.enterDecision(56, decisionCanBacktrack[56]);

					int LA56_0 = input.LA(1);
					if ( (LA56_0==NOT) ) {
						alt56=1;
					}
					} finally {dbg.exitDecision(56);}

					switch (alt56) {
						case 1 :
							dbg.enterAlt(1);

							// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:468:6: NOT
							{
							dbg.location(468,6);
							match(input,NOT,FOLLOW_NOT_in_expression2218); if (state.failed) return retval;
							}
							break;

					}
					} finally {dbg.exitSubRule(56);}
					dbg.location(468,12);
					pushFollow(FOLLOW_enclosed_expr_in_expression2222);
					enclosed_expr51=enclosed_expr();
					state._fsp--;
					if (state.failed) return retval;
					}

					// TEMPLATE REWRITE
					if ( state.backtracking==0 ) {
					  // 468:27: -> dummy(val=$enclosed_expr.st)
					  {
					  	retval.st = templateLib.getInstanceOf("dummy",new STAttrMap().put("val", (enclosed_expr51!=null?((StringTemplate)enclosed_expr51.getTemplate()):null)));
					  }


					}

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:469:5: ( test )
					{
					dbg.location(469,5);
					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:469:5: ( test )
					dbg.enterAlt(1);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:469:6: test
					{
					dbg.location(469,6);
					pushFollow(FOLLOW_test_in_expression2241);
					test52=test();
					state._fsp--;
					if (state.failed) return retval;
					}

					// TEMPLATE REWRITE
					if ( state.backtracking==0 ) {
					  // 469:12: -> dummy(val=$test.st)
					  {
					  	retval.st = templateLib.getInstanceOf("dummy",new STAttrMap().put("val", (test52!=null?((StringTemplate)test52.getTemplate()):null)));
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
		dbg.location(470, 1);

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
	// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:473:1: test : l= value (op= comp_op r= value )? -> test(l=$l.str=$r.stoperator=$op.text);
	public final Systemc_basicParser.test_return test() throws  {
		Systemc_basicParser.test_return retval = new Systemc_basicParser.test_return();
		retval.start = input.LT(1);

		ParserRuleReturnScope l =null;
		ParserRuleReturnScope op =null;
		ParserRuleReturnScope r =null;

		try { dbg.enterRule(getGrammarFileName(), "test");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(473, 0);

		try {
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:473:6: (l= value (op= comp_op r= value )? -> test(l=$l.str=$r.stoperator=$op.text))
			dbg.enterAlt(1);

			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:474:3: l= value (op= comp_op r= value )?
			{
			dbg.location(474,5);
			pushFollow(FOLLOW_value_in_test2271);
			l=value();
			state._fsp--;
			if (state.failed) return retval;dbg.location(474,12);
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:474:12: (op= comp_op r= value )?
			int alt58=2;
			try { dbg.enterSubRule(58);
			try { dbg.enterDecision(58, decisionCanBacktrack[58]);

			int LA58_0 = input.LA(1);
			if ( (LA58_0==EQUAL||LA58_0==GT||(LA58_0 >= LT && LA58_0 <= NOT)) ) {
				alt58=1;
			}
			} finally {dbg.exitDecision(58);}

			switch (alt58) {
				case 1 :
					dbg.enterAlt(1);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:474:14: op= comp_op r= value
					{
					dbg.location(474,17);
					pushFollow(FOLLOW_comp_op_in_test2277);
					op=comp_op();
					state._fsp--;
					if (state.failed) return retval;dbg.location(474,28);
					pushFollow(FOLLOW_value_in_test2283);
					r=value();
					state._fsp--;
					if (state.failed) return retval;
					}
					break;

			}
			} finally {dbg.exitSubRule(58);}

			// TEMPLATE REWRITE
			if ( state.backtracking==0 ) {
			  // 474:39: -> test(l=$l.str=$r.stoperator=$op.text)
			  {
			  	retval.st = templateLib.getInstanceOf("test",new STAttrMap().put("l", (l!=null?((StringTemplate)l.getTemplate()):null)).put("r", (r!=null?((StringTemplate)r.getTemplate()):null)).put("operator", (op!=null?input.toString(op.start,op.stop):null)));
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
		dbg.location(475, 1);

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
	// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:477:1: comp_op : ( LT | GT | NOT | '=' ) ( '=' )? ;
	public final Systemc_basicParser.comp_op_return comp_op() throws  {
		Systemc_basicParser.comp_op_return retval = new Systemc_basicParser.comp_op_return();
		retval.start = input.LT(1);

		try { dbg.enterRule(getGrammarFileName(), "comp_op");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(477, 0);

		try {
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:477:9: ( ( LT | GT | NOT | '=' ) ( '=' )? )
			dbg.enterAlt(1);

			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:478:2: ( LT | GT | NOT | '=' ) ( '=' )?
			{
			dbg.location(478,2);
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
			}dbg.location(478,23);
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:478:23: ( '=' )?
			int alt59=2;
			try { dbg.enterSubRule(59);
			try { dbg.enterDecision(59, decisionCanBacktrack[59]);

			int LA59_0 = input.LA(1);
			if ( (LA59_0==EQUAL) ) {
				alt59=1;
			}
			} finally {dbg.exitDecision(59);}

			switch (alt59) {
				case 1 :
					dbg.enterAlt(1);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:478:24: '='
					{
					dbg.location(478,24);
					match(input,EQUAL,FOLLOW_EQUAL_in_comp_op2340); if (state.failed) return retval;
					}
					break;

			}
			} finally {dbg.exitSubRule(59);}

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
		dbg.location(479, 1);

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
	// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:480:1: logic_op : ( '&&' -> vhdl_and(| '||' -> vhdl_or();
	public final Systemc_basicParser.logic_op_return logic_op() throws  {
		Systemc_basicParser.logic_op_return retval = new Systemc_basicParser.logic_op_return();
		retval.start = input.LT(1);

		try { dbg.enterRule(getGrammarFileName(), "logic_op");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(480, 0);

		try {
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:480:10: ( '&&' -> vhdl_and(| '||' -> vhdl_or()
			int alt60=2;
			try { dbg.enterDecision(60, decisionCanBacktrack[60]);

			int LA60_0 = input.LA(1);
			if ( (LA60_0==22) ) {
				alt60=1;
			}
			else if ( (LA60_0==81) ) {
				alt60=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 60, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(60);}

			switch (alt60) {
				case 1 :
					dbg.enterAlt(1);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:481:2: '&&'
					{
					dbg.location(481,2);
					match(input,22,FOLLOW_22_in_logic_op2352); if (state.failed) return retval;
					// TEMPLATE REWRITE
					if ( state.backtracking==0 ) {
					  // 481:8: -> vhdl_and(
					  {
					  	retval.st = templateLib.getInstanceOf("vhdl_and");
					  }


					}

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:482:4: '||'
					{
					dbg.location(482,4);
					match(input,81,FOLLOW_81_in_logic_op2364); if (state.failed) return retval;
					// TEMPLATE REWRITE
					if ( state.backtracking==0 ) {
					  // 482:10: -> vhdl_or(
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
		dbg.location(483, 1);

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
	protected Stack<case_construct_scope> case_construct_stack = new Stack<case_construct_scope>();

	public static class case_construct_return extends ParserRuleReturnScope {
		public StringTemplate st;
		public Object getTemplate() { return st; }
		public String toString() { return st==null?null:st.toString(); }
	};


	// $ANTLR start "case_construct"
	// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:484:1: case_construct : 'switch' '(' value ')' '{' ( case_elt )* '}' -> switch(cases=$case_construct::casesvar=$value.st);
	public final Systemc_basicParser.case_construct_return case_construct() throws  {
		case_construct_stack.push(new case_construct_scope());
		Systemc_basicParser.case_construct_return retval = new Systemc_basicParser.case_construct_return();
		retval.start = input.LT(1);

		ParserRuleReturnScope case_elt53 =null;
		ParserRuleReturnScope value54 =null;


		  case_construct_stack.peek().cases = new ArrayList();

		try { dbg.enterRule(getGrammarFileName(), "case_construct");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(484, 0);

		try {
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:491:2: ( 'switch' '(' value ')' '{' ( case_elt )* '}' -> switch(cases=$case_construct::casesvar=$value.st))
			dbg.enterAlt(1);

			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:492:2: 'switch' '(' value ')' '{' ( case_elt )* '}'
			{
			dbg.location(492,2);
			match(input,74,FOLLOW_74_in_case_construct2391); if (state.failed) return retval;dbg.location(492,10);
			match(input,23,FOLLOW_23_in_case_construct2392); if (state.failed) return retval;dbg.location(492,13);
			pushFollow(FOLLOW_value_in_case_construct2393);
			value54=value();
			state._fsp--;
			if (state.failed) return retval;dbg.location(492,18);
			match(input,24,FOLLOW_24_in_case_construct2394); if (state.failed) return retval;dbg.location(492,21);
			match(input,80,FOLLOW_80_in_case_construct2395); if (state.failed) return retval;dbg.location(493,2);
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:493:2: ( case_elt )*
			try { dbg.enterSubRule(61);

			loop61:
			while (true) {
				int alt61=2;
				try { dbg.enterDecision(61, decisionCanBacktrack[61]);

				int LA61_0 = input.LA(1);
				if ( (LA61_0==41||LA61_0==44) ) {
					alt61=1;
				}

				} finally {dbg.exitDecision(61);}

				switch (alt61) {
				case 1 :
					dbg.enterAlt(1);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:493:3: case_elt
					{
					dbg.location(493,3);
					pushFollow(FOLLOW_case_elt_in_case_construct2399);
					case_elt53=case_elt();
					state._fsp--;
					if (state.failed) return retval;dbg.location(493,13);
					if ( state.backtracking==0 ) {   case_construct_stack.peek().cases.add((case_elt53!=null?((StringTemplate)case_elt53.getTemplate()):null));}
					}
					break;

				default :
					break loop61;
				}
			}
			} finally {dbg.exitSubRule(61);}
			dbg.location(494,2);
			match(input,82,FOLLOW_82_in_case_construct2407); if (state.failed) return retval;
			// TEMPLATE REWRITE
			if ( state.backtracking==0 ) {
			  // 494:6: -> switch(cases=$case_construct::casesvar=$value.st)
			  {
			  	retval.st = templateLib.getInstanceOf("switch",new STAttrMap().put("cases", case_construct_stack.peek().cases).put("var", (value54!=null?((StringTemplate)value54.getTemplate()):null)));
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
		dbg.location(495, 1);

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
	protected Stack<case_elt_scope> case_elt_stack = new Stack<case_elt_scope>();

	public static class case_elt_return extends ParserRuleReturnScope {
		public StringTemplate st;
		public Object getTemplate() { return st; }
		public String toString() { return st==null?null:st.toString(); }
	};


	// $ANTLR start "case_elt"
	// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:497:1: case_elt : ( 'case' ( ID ) | 'default' ) ':' ( v_assignement SEMICOLON | sc_assignement SEMICOLON | if_construct | func_call SEMICOLON | block SEMICOLON | flux SEMICOLON )* ( 'break' SEMICOLON )? -> case(val=$ID.textcont=$case_elt::cont);
	public final Systemc_basicParser.case_elt_return case_elt() throws  {
		case_elt_stack.push(new case_elt_scope());
		Systemc_basicParser.case_elt_return retval = new Systemc_basicParser.case_elt_return();
		retval.start = input.LT(1);

		Token ID60=null;
		ParserRuleReturnScope v_assignement55 =null;
		ParserRuleReturnScope sc_assignement56 =null;
		ParserRuleReturnScope if_construct57 =null;
		ParserRuleReturnScope func_call58 =null;
		ParserRuleReturnScope block59 =null;


		  case_elt_stack.peek().cont = new ArrayList();

		try { dbg.enterRule(getGrammarFileName(), "case_elt");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(497, 0);

		try {
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:504:2: ( ( 'case' ( ID ) | 'default' ) ':' ( v_assignement SEMICOLON | sc_assignement SEMICOLON | if_construct | func_call SEMICOLON | block SEMICOLON | flux SEMICOLON )* ( 'break' SEMICOLON )? -> case(val=$ID.textcont=$case_elt::cont))
			dbg.enterAlt(1);

			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:505:2: ( 'case' ( ID ) | 'default' ) ':' ( v_assignement SEMICOLON | sc_assignement SEMICOLON | if_construct | func_call SEMICOLON | block SEMICOLON | flux SEMICOLON )* ( 'break' SEMICOLON )?
			{
			dbg.location(505,2);
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:505:2: ( 'case' ( ID ) | 'default' )
			int alt62=2;
			try { dbg.enterSubRule(62);
			try { dbg.enterDecision(62, decisionCanBacktrack[62]);

			int LA62_0 = input.LA(1);
			if ( (LA62_0==41) ) {
				alt62=1;
			}
			else if ( (LA62_0==44) ) {
				alt62=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 62, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(62);}

			switch (alt62) {
				case 1 :
					dbg.enterAlt(1);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:505:3: 'case' ( ID )
					{
					dbg.location(505,3);
					match(input,41,FOLLOW_41_in_case_elt2447); if (state.failed) return retval;dbg.location(505,10);
					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:505:10: ( ID )
					dbg.enterAlt(1);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:505:11: ID
					{
					dbg.location(505,11);
					ID60=(Token)match(input,ID,FOLLOW_ID_in_case_elt2450); if (state.failed) return retval;
					}

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:505:17: 'default'
					{
					dbg.location(505,17);
					match(input,44,FOLLOW_44_in_case_elt2455); if (state.failed) return retval;
					}
					break;

			}
			} finally {dbg.exitSubRule(62);}
			dbg.location(505,28);
			match(input,29,FOLLOW_29_in_case_elt2458); if (state.failed) return retval;dbg.location(506,2);
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:506:2: ( v_assignement SEMICOLON | sc_assignement SEMICOLON | if_construct | func_call SEMICOLON | block SEMICOLON | flux SEMICOLON )*
			try { dbg.enterSubRule(63);

			loop63:
			while (true) {
				int alt63=7;
				try { dbg.enterDecision(63, decisionCanBacktrack[63]);

				switch ( input.LA(1) ) {
				case ID:
					{
					switch ( input.LA(2) ) {
					case EQUAL:
						{
						alt63=1;
						}
						break;
					case 23:
						{
						alt63=4;
						}
						break;
					case 30:
					case 31:
						{
						alt63=6;
						}
						break;
					case 28:
					case 35:
						{
						alt63=2;
						}
						break;
					}
					}
					break;
				case 50:
					{
					alt63=3;
					}
					break;
				case 80:
					{
					alt63=5;
					}
					break;
				}
				} finally {dbg.exitDecision(63);}

				switch (alt63) {
				case 1 :
					dbg.enterAlt(1);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:506:3: v_assignement SEMICOLON
					{
					dbg.location(506,3);
					pushFollow(FOLLOW_v_assignement_in_case_elt2463);
					v_assignement55=v_assignement();
					state._fsp--;
					if (state.failed) return retval;dbg.location(506,17);
					match(input,SEMICOLON,FOLLOW_SEMICOLON_in_case_elt2465); if (state.failed) return retval;dbg.location(506,26);
					if ( state.backtracking==0 ) {  case_elt_stack.peek().cont.add((v_assignement55!=null?((StringTemplate)v_assignement55.getTemplate()):null));}
					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:507:3: sc_assignement SEMICOLON
					{
					dbg.location(507,3);
					pushFollow(FOLLOW_sc_assignement_in_case_elt2470);
					sc_assignement56=sc_assignement();
					state._fsp--;
					if (state.failed) return retval;dbg.location(507,18);
					match(input,SEMICOLON,FOLLOW_SEMICOLON_in_case_elt2472); if (state.failed) return retval;dbg.location(507,27);
					if ( state.backtracking==0 ) {  case_elt_stack.peek().cont.add((sc_assignement56!=null?((StringTemplate)sc_assignement56.getTemplate()):null));}
					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:508:3: if_construct
					{
					dbg.location(508,3);
					pushFollow(FOLLOW_if_construct_in_case_elt2477);
					if_construct57=if_construct();
					state._fsp--;
					if (state.failed) return retval;dbg.location(508,16);
					if ( state.backtracking==0 ) { case_elt_stack.peek().cont.add((if_construct57!=null?((StringTemplate)if_construct57.getTemplate()):null));}
					}
					break;
				case 4 :
					dbg.enterAlt(4);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:509:3: func_call SEMICOLON
					{
					dbg.location(509,3);
					pushFollow(FOLLOW_func_call_in_case_elt2483);
					func_call58=func_call();
					state._fsp--;
					if (state.failed) return retval;dbg.location(509,13);
					match(input,SEMICOLON,FOLLOW_SEMICOLON_in_case_elt2485); if (state.failed) return retval;dbg.location(509,22);
					if ( state.backtracking==0 ) {  case_elt_stack.peek().cont.add((func_call58!=null?((StringTemplate)func_call58.getTemplate()):null));}
					}
					break;
				case 5 :
					dbg.enterAlt(5);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:510:3: block SEMICOLON
					{
					dbg.location(510,3);
					pushFollow(FOLLOW_block_in_case_elt2490);
					block59=block();
					state._fsp--;
					if (state.failed) return retval;dbg.location(510,9);
					match(input,SEMICOLON,FOLLOW_SEMICOLON_in_case_elt2492); if (state.failed) return retval;dbg.location(510,18);
					if ( state.backtracking==0 ) {  case_elt_stack.peek().cont.addAll((block59!=null?((Systemc_basicParser.block_return)block59).elts:null));}
					}
					break;
				case 6 :
					dbg.enterAlt(6);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:511:3: flux SEMICOLON
					{
					dbg.location(511,3);
					pushFollow(FOLLOW_flux_in_case_elt2497);
					flux();
					state._fsp--;
					if (state.failed) return retval;dbg.location(511,8);
					match(input,SEMICOLON,FOLLOW_SEMICOLON_in_case_elt2499); if (state.failed) return retval;
					}
					break;

				default :
					break loop63;
				}
			}
			} finally {dbg.exitSubRule(63);}
			dbg.location(513,2);
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:513:2: ( 'break' SEMICOLON )?
			int alt64=2;
			try { dbg.enterSubRule(64);
			try { dbg.enterDecision(64, decisionCanBacktrack[64]);

			int LA64_0 = input.LA(1);
			if ( (LA64_0==40) ) {
				alt64=1;
			}
			} finally {dbg.exitDecision(64);}

			switch (alt64) {
				case 1 :
					dbg.enterAlt(1);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:513:3: 'break' SEMICOLON
					{
					dbg.location(513,3);
					match(input,40,FOLLOW_40_in_case_elt2507); if (state.failed) return retval;dbg.location(513,11);
					match(input,SEMICOLON,FOLLOW_SEMICOLON_in_case_elt2509); if (state.failed) return retval;
					}
					break;

			}
			} finally {dbg.exitSubRule(64);}

			// TEMPLATE REWRITE
			if ( state.backtracking==0 ) {
			  // 513:23: -> case(val=$ID.textcont=$case_elt::cont)
			  {
			  	retval.st = templateLib.getInstanceOf("case",new STAttrMap().put("val", (ID60!=null?ID60.getText():null)).put("cont", case_elt_stack.peek().cont));
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
		dbg.location(514, 1);

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
	// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:516:1: flux : ( ID '::' )? ID '<<' value ( '<<' value )* ;
	public final Systemc_basicParser.flux_return flux() throws  {
		Systemc_basicParser.flux_return retval = new Systemc_basicParser.flux_return();
		retval.start = input.LT(1);

		try { dbg.enterRule(getGrammarFileName(), "flux");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(516, 0);

		try {
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:516:6: ( ( ID '::' )? ID '<<' value ( '<<' value )* )
			dbg.enterAlt(1);

			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:516:7: ( ID '::' )? ID '<<' value ( '<<' value )*
			{
			dbg.location(516,7);
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:516:7: ( ID '::' )?
			int alt65=2;
			try { dbg.enterSubRule(65);
			try { dbg.enterDecision(65, decisionCanBacktrack[65]);

			int LA65_0 = input.LA(1);
			if ( (LA65_0==ID) ) {
				int LA65_1 = input.LA(2);
				if ( (LA65_1==30) ) {
					alt65=1;
				}
			}
			} finally {dbg.exitDecision(65);}

			switch (alt65) {
				case 1 :
					dbg.enterAlt(1);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:516:8: ID '::'
					{
					dbg.location(516,8);
					match(input,ID,FOLLOW_ID_in_flux2539); if (state.failed) return retval;dbg.location(516,10);
					match(input,30,FOLLOW_30_in_flux2540); if (state.failed) return retval;
					}
					break;

			}
			} finally {dbg.exitSubRule(65);}
			dbg.location(516,16);
			match(input,ID,FOLLOW_ID_in_flux2543); if (state.failed) return retval;dbg.location(516,19);
			match(input,31,FOLLOW_31_in_flux2545); if (state.failed) return retval;dbg.location(516,24);
			pushFollow(FOLLOW_value_in_flux2547);
			value();
			state._fsp--;
			if (state.failed) return retval;dbg.location(516,30);
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:516:30: ( '<<' value )*
			try { dbg.enterSubRule(66);

			loop66:
			while (true) {
				int alt66=2;
				try { dbg.enterDecision(66, decisionCanBacktrack[66]);

				int LA66_0 = input.LA(1);
				if ( (LA66_0==31) ) {
					alt66=1;
				}

				} finally {dbg.exitDecision(66);}

				switch (alt66) {
				case 1 :
					dbg.enterAlt(1);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:516:31: '<<' value
					{
					dbg.location(516,31);
					match(input,31,FOLLOW_31_in_flux2550); if (state.failed) return retval;dbg.location(516,37);
					pushFollow(FOLLOW_value_in_flux2553);
					value();
					state._fsp--;
					if (state.failed) return retval;
					}
					break;

				default :
					break loop66;
				}
			}
			} finally {dbg.exitSubRule(66);}

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
		dbg.location(517, 2);

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
	// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:520:1: v_assignement : ID EQUAL assignement_value -> var_assign(var=$ID.textval=$assignement_value.st);
	public final Systemc_basicParser.v_assignement_return v_assignement() throws  {
		Systemc_basicParser.v_assignement_return retval = new Systemc_basicParser.v_assignement_return();
		retval.start = input.LT(1);

		Token ID61=null;
		ParserRuleReturnScope assignement_value62 =null;

		try { dbg.enterRule(getGrammarFileName(), "v_assignement");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(520, 0);

		try {
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:521:2: ( ID EQUAL assignement_value -> var_assign(var=$ID.textval=$assignement_value.st))
			dbg.enterAlt(1);

			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:522:2: ID EQUAL assignement_value
			{
			dbg.location(522,2);
			ID61=(Token)match(input,ID,FOLLOW_ID_in_v_assignement2571); if (state.failed) return retval;dbg.location(522,5);
			match(input,EQUAL,FOLLOW_EQUAL_in_v_assignement2573); if (state.failed) return retval;dbg.location(522,11);
			pushFollow(FOLLOW_assignement_value_in_v_assignement2575);
			assignement_value62=assignement_value();
			state._fsp--;
			if (state.failed) return retval;
			// TEMPLATE REWRITE
			if ( state.backtracking==0 ) {
			  // 522:30: -> var_assign(var=$ID.textval=$assignement_value.st)
			  {
			  	retval.st = templateLib.getInstanceOf("var_assign",new STAttrMap().put("var", (ID61!=null?ID61.getText():null)).put("val", (assignement_value62!=null?((StringTemplate)assignement_value62.getTemplate()):null)));
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
		dbg.location(523, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "v_assignement");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "v_assignement"


	protected static class sc_assignement_scope {
		StringTemplate var;
	}
	protected Stack<sc_assignement_scope> sc_assignement_stack = new Stack<sc_assignement_scope>();

	public static class sc_assignement_return extends ParserRuleReturnScope {
		public StringTemplate st;
		public Object getTemplate() { return st; }
		public String toString() { return st==null?null:st.toString(); }
	};


	// $ANTLR start "sc_assignement"
	// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:525:1: sc_assignement : ID ( array_index[$sc_assignement::var] )? '.write(' assignement_value ')' -> signal_assignement(dest=$sc_assignement::varsource=SignalAssignementConversion.getInstance().getAssignementValue($ID.text, $assignement_value.st.toString()));
	public final Systemc_basicParser.sc_assignement_return sc_assignement() throws  {
		sc_assignement_stack.push(new sc_assignement_scope());
		Systemc_basicParser.sc_assignement_return retval = new Systemc_basicParser.sc_assignement_return();
		retval.start = input.LT(1);

		Token ID63=null;
		ParserRuleReturnScope array_index64 =null;
		ParserRuleReturnScope assignement_value65 =null;

		try { dbg.enterRule(getGrammarFileName(), "sc_assignement");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(525, 0);

		try {
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:529:2: ( ID ( array_index[$sc_assignement::var] )? '.write(' assignement_value ')' -> signal_assignement(dest=$sc_assignement::varsource=SignalAssignementConversion.getInstance().getAssignementValue($ID.text, $assignement_value.st.toString())))
			dbg.enterAlt(1);

			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:530:2: ID ( array_index[$sc_assignement::var] )? '.write(' assignement_value ')'
			{
			dbg.location(530,2);
			ID63=(Token)match(input,ID,FOLLOW_ID_in_sc_assignement2610); if (state.failed) return retval;dbg.location(530,4);
			if ( state.backtracking==0 ) {sc_assignement_stack.peek().var = templateLib.getInstanceOf("dummy",new STAttrMap().put("val", (ID63!=null?ID63.getText():null)));}dbg.location(530,101);
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:530:101: ( array_index[$sc_assignement::var] )?
			int alt67=2;
			try { dbg.enterSubRule(67);
			try { dbg.enterDecision(67, decisionCanBacktrack[67]);

			int LA67_0 = input.LA(1);
			if ( (LA67_0==35) ) {
				alt67=1;
			}
			} finally {dbg.exitDecision(67);}

			switch (alt67) {
				case 1 :
					dbg.enterAlt(1);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:530:102: array_index[$sc_assignement::var]
					{
					dbg.location(530,102);
					pushFollow(FOLLOW_array_index_in_sc_assignement2613);
					array_index64=array_index(sc_assignement_stack.peek().var);
					state._fsp--;
					if (state.failed) return retval;dbg.location(530,135);
					if ( state.backtracking==0 ) {sc_assignement_stack.peek().var =(array_index64!=null?((StringTemplate)array_index64.getTemplate()):null);}
					}
					break;

			}
			} finally {dbg.exitSubRule(67);}
			dbg.location(530,176);
			match(input,28,FOLLOW_28_in_sc_assignement2618); if (state.failed) return retval;dbg.location(530,185);
			pushFollow(FOLLOW_assignement_value_in_sc_assignement2619);
			assignement_value65=assignement_value();
			state._fsp--;
			if (state.failed) return retval;dbg.location(530,202);
			match(input,24,FOLLOW_24_in_sc_assignement2620); if (state.failed) return retval;
			// TEMPLATE REWRITE
			if ( state.backtracking==0 ) {
			  // 530:206: -> signal_assignement(dest=$sc_assignement::varsource=SignalAssignementConversion.getInstance().getAssignementValue($ID.text, $assignement_value.st.toString()))
			  {
			  	retval.st = templateLib.getInstanceOf("signal_assignement",new STAttrMap().put("dest", sc_assignement_stack.peek().var).put("source", SignalAssignementConversion.getInstance().getAssignementValue((ID63!=null?ID63.getText():null), (assignement_value65!=null?((StringTemplate)assignement_value65.getTemplate()):null).toString())));
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
			sc_assignement_stack.pop();
		}
		dbg.location(531, 1);

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
	// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:533:1: assignement_value : h= value ( OP t= value )? -> expression(head=$h.stop=$OP.texttail=$t.st);
	public final Systemc_basicParser.assignement_value_return assignement_value() throws  {
		Systemc_basicParser.assignement_value_return retval = new Systemc_basicParser.assignement_value_return();
		retval.start = input.LT(1);

		Token OP66=null;
		ParserRuleReturnScope h =null;
		ParserRuleReturnScope t =null;

		try { dbg.enterRule(getGrammarFileName(), "assignement_value");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(533, 0);

		try {
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:534:2: (h= value ( OP t= value )? -> expression(head=$h.stop=$OP.texttail=$t.st))
			dbg.enterAlt(1);

			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:535:4: h= value ( OP t= value )?
			{
			dbg.location(535,5);
			pushFollow(FOLLOW_value_in_assignement_value2654);
			h=value();
			state._fsp--;
			if (state.failed) return retval;dbg.location(535,13);
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:535:13: ( OP t= value )?
			int alt68=2;
			try { dbg.enterSubRule(68);
			try { dbg.enterDecision(68, decisionCanBacktrack[68]);

			int LA68_0 = input.LA(1);
			if ( (LA68_0==OP) ) {
				alt68=1;
			}
			} finally {dbg.exitDecision(68);}

			switch (alt68) {
				case 1 :
					dbg.enterAlt(1);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:535:14: OP t= value
					{
					dbg.location(535,14);
					OP66=(Token)match(input,OP,FOLLOW_OP_in_assignement_value2658); if (state.failed) return retval;dbg.location(535,18);
					pushFollow(FOLLOW_value_in_assignement_value2662);
					t=value();
					state._fsp--;
					if (state.failed) return retval;
					}
					break;

			}
			} finally {dbg.exitSubRule(68);}

			// TEMPLATE REWRITE
			if ( state.backtracking==0 ) {
			  // 535:27: -> expression(head=$h.stop=$OP.texttail=$t.st)
			  {
			  	retval.st = templateLib.getInstanceOf("expression",new STAttrMap().put("head", (h!=null?((StringTemplate)h.getTemplate()):null)).put("op", (OP66!=null?OP66.getText():null)).put("tail", (t!=null?((StringTemplate)t.getTemplate()):null)));
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
		dbg.location(536, 1);

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
	// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:538:1: value : ( HEX -> hex(val= $HEX.text.substring(2))| BIN -> bin(val= $BIN.text.substring(2))| INT -> dummy(val= $INT.text)| STRING_LITERAL -> dummy(val= $STRING_LITERAL.text)| scconstructor -> dummy(val=$scconstructor.st)| func_call -> dummy(val=$func_call.st)|h= var_value -> dummy(val=$h.st)| sc_method[null] -> dummy(val=$sc_method.st));
	public final Systemc_basicParser.value_return value() throws  {
		Systemc_basicParser.value_return retval = new Systemc_basicParser.value_return();
		retval.start = input.LT(1);

		Token HEX67=null;
		Token BIN68=null;
		Token INT69=null;
		Token STRING_LITERAL70=null;
		ParserRuleReturnScope h =null;
		ParserRuleReturnScope scconstructor71 =null;
		ParserRuleReturnScope func_call72 =null;
		ParserRuleReturnScope sc_method73 =null;

		try { dbg.enterRule(getGrammarFileName(), "value");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(538, 0);

		try {
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:539:3: ( HEX -> hex(val= $HEX.text.substring(2))| BIN -> bin(val= $BIN.text.substring(2))| INT -> dummy(val= $INT.text)| STRING_LITERAL -> dummy(val= $STRING_LITERAL.text)| scconstructor -> dummy(val=$scconstructor.st)| func_call -> dummy(val=$func_call.st)|h= var_value -> dummy(val=$h.st)| sc_method[null] -> dummy(val=$sc_method.st))
			int alt69=8;
			try { dbg.enterDecision(69, decisionCanBacktrack[69]);

			switch ( input.LA(1) ) {
			case HEX:
				{
				alt69=1;
				}
				break;
			case BIN:
				{
				alt69=2;
				}
				break;
			case INT:
				{
				alt69=3;
				}
				break;
			case STRING_LITERAL:
				{
				alt69=4;
				}
				break;
			case 39:
			case 64:
			case 65:
			case 70:
				{
				alt69=5;
				}
				break;
			case ID:
				{
				int LA69_6 = input.LA(2);
				if ( (LA69_6==23) ) {
					alt69=6;
				}
				else if ( (LA69_6==EQUAL||LA69_6==GT||(LA69_6 >= LT && LA69_6 <= SEMICOLON)||LA69_6==22||LA69_6==24||(LA69_6 >= 26 && LA69_6 <= 27)||LA69_6==31||LA69_6==35||LA69_6==37||LA69_6==81) ) {
					alt69=7;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 69, 6, input);
						dbg.recognitionException(nvae);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case NOT:
				{
				alt69=7;
				}
				break;
			case 23:
			case 43:
			case 53:
			case 54:
			case 55:
			case 56:
			case 75:
			case 76:
				{
				alt69=8;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 69, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}
			} finally {dbg.exitDecision(69);}

			switch (alt69) {
				case 1 :
					dbg.enterAlt(1);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:540:3: HEX
					{
					dbg.location(540,3);
					HEX67=(Token)match(input,HEX,FOLLOW_HEX_in_value2703); if (state.failed) return retval;
					// TEMPLATE REWRITE
					if ( state.backtracking==0 ) {
					  // 540:8: -> hex(val= $HEX.text.substring(2))
					  {
					  	retval.st = templateLib.getInstanceOf("hex",new STAttrMap().put("val",  (HEX67!=null?HEX67.getText():null).substring(2)));
					  }


					}

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:541:4: BIN
					{
					dbg.location(541,4);
					BIN68=(Token)match(input,BIN,FOLLOW_BIN_in_value2720); if (state.failed) return retval;
					// TEMPLATE REWRITE
					if ( state.backtracking==0 ) {
					  // 541:9: -> bin(val= $BIN.text.substring(2))
					  {
					  	retval.st = templateLib.getInstanceOf("bin",new STAttrMap().put("val",  (BIN68!=null?BIN68.getText():null).substring(2)));
					  }


					}

					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:542:4: INT
					{
					dbg.location(542,4);
					INT69=(Token)match(input,INT,FOLLOW_INT_in_value2737); if (state.failed) return retval;
					// TEMPLATE REWRITE
					if ( state.backtracking==0 ) {
					  // 542:9: -> dummy(val= $INT.text)
					  {
					  	retval.st = templateLib.getInstanceOf("dummy",new STAttrMap().put("val",  (INT69!=null?INT69.getText():null)));
					  }


					}

					}
					break;
				case 4 :
					dbg.enterAlt(4);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:543:4: STRING_LITERAL
					{
					dbg.location(543,4);
					STRING_LITERAL70=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_value2754); if (state.failed) return retval;
					// TEMPLATE REWRITE
					if ( state.backtracking==0 ) {
					  // 543:21: -> dummy(val= $STRING_LITERAL.text)
					  {
					  	retval.st = templateLib.getInstanceOf("dummy",new STAttrMap().put("val",  (STRING_LITERAL70!=null?STRING_LITERAL70.getText():null)));
					  }


					}

					}
					break;
				case 5 :
					dbg.enterAlt(5);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:544:4: scconstructor
					{
					dbg.location(544,4);
					pushFollow(FOLLOW_scconstructor_in_value2774);
					scconstructor71=scconstructor();
					state._fsp--;
					if (state.failed) return retval;
					// TEMPLATE REWRITE
					if ( state.backtracking==0 ) {
					  // 544:18: -> dummy(val=$scconstructor.st)
					  {
					  	retval.st = templateLib.getInstanceOf("dummy",new STAttrMap().put("val", (scconstructor71!=null?((StringTemplate)scconstructor71.getTemplate()):null)));
					  }


					}

					}
					break;
				case 6 :
					dbg.enterAlt(6);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:545:4: func_call
					{
					dbg.location(545,4);
					pushFollow(FOLLOW_func_call_in_value2789);
					func_call72=func_call();
					state._fsp--;
					if (state.failed) return retval;
					// TEMPLATE REWRITE
					if ( state.backtracking==0 ) {
					  // 545:14: -> dummy(val=$func_call.st)
					  {
					  	retval.st = templateLib.getInstanceOf("dummy",new STAttrMap().put("val", (func_call72!=null?((StringTemplate)func_call72.getTemplate()):null)));
					  }


					}

					}
					break;
				case 7 :
					dbg.enterAlt(7);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:546:4: h= var_value
					{
					dbg.location(546,5);
					pushFollow(FOLLOW_var_value_in_value2807);
					h=var_value();
					state._fsp--;
					if (state.failed) return retval;
					// TEMPLATE REWRITE
					if ( state.backtracking==0 ) {
					  // 546:18: -> dummy(val=$h.st)
					  {
					  	retval.st = templateLib.getInstanceOf("dummy",new STAttrMap().put("val", (h!=null?((StringTemplate)h.getTemplate()):null)));
					  }


					}

					}
					break;
				case 8 :
					dbg.enterAlt(8);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:547:4: sc_method[null]
					{
					dbg.location(547,4);
					pushFollow(FOLLOW_sc_method_in_value2825);
					sc_method73=sc_method(null);
					state._fsp--;
					if (state.failed) return retval;
					// TEMPLATE REWRITE
					if ( state.backtracking==0 ) {
					  // 547:20: -> dummy(val=$sc_method.st)
					  {
					  	retval.st = templateLib.getInstanceOf("dummy",new STAttrMap().put("val", (sc_method73!=null?((StringTemplate)sc_method73.getTemplate()):null)));
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
		dbg.location(548, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "value");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "value"


	public static class scconstructor_return extends ParserRuleReturnScope {
		public StringTemplate st;
		public Object getTemplate() { return st; }
		public String toString() { return st==null?null:st.toString(); }
	};


	// $ANTLR start "scconstructor"
	// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:550:1: scconstructor : sc_type '(' value ')' -> dummy(val=$value.st);
	public final Systemc_basicParser.scconstructor_return scconstructor() throws  {
		Systemc_basicParser.scconstructor_return retval = new Systemc_basicParser.scconstructor_return();
		retval.start = input.LT(1);

		ParserRuleReturnScope value74 =null;

		try { dbg.enterRule(getGrammarFileName(), "scconstructor");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(550, 0);

		try {
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:551:2: ( sc_type '(' value ')' -> dummy(val=$value.st))
			dbg.enterAlt(1);

			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:552:2: sc_type '(' value ')'
			{
			dbg.location(552,2);
			pushFollow(FOLLOW_sc_type_in_scconstructor2850);
			sc_type();
			state._fsp--;
			if (state.failed) return retval;dbg.location(552,9);
			match(input,23,FOLLOW_23_in_scconstructor2851); if (state.failed) return retval;dbg.location(552,12);
			pushFollow(FOLLOW_value_in_scconstructor2852);
			value74=value();
			state._fsp--;
			if (state.failed) return retval;dbg.location(552,17);
			match(input,24,FOLLOW_24_in_scconstructor2853); if (state.failed) return retval;
			// TEMPLATE REWRITE
			if ( state.backtracking==0 ) {
			  // 552:21: -> dummy(val=$value.st)
			  {
			  	retval.st = templateLib.getInstanceOf("dummy",new STAttrMap().put("val", (value74!=null?((StringTemplate)value74.getTemplate()):null)));
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
		dbg.location(553, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "scconstructor");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "scconstructor"


	protected static class var_value_scope {
		StringTemplate val;
	}
	protected Stack<var_value_scope> var_value_stack = new Stack<var_value_scope>();

	public static class var_value_return extends ParserRuleReturnScope {
		public StringTemplate st;
		public Object getTemplate() { return st; }
		public String toString() { return st==null?null:st.toString(); }
	};


	// $ANTLR start "var_value"
	// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:578:1: var_value : ( NOT )? ( var_name ) ( var_comp[$var_value::val] )? -> var_value(not=$NOT.textvar=$var_value::val);
	public final Systemc_basicParser.var_value_return var_value() throws  {
		var_value_stack.push(new var_value_scope());
		Systemc_basicParser.var_value_return retval = new Systemc_basicParser.var_value_return();
		retval.start = input.LT(1);

		Token NOT77=null;
		ParserRuleReturnScope var_name75 =null;
		ParserRuleReturnScope var_comp76 =null;

		try { dbg.enterRule(getGrammarFileName(), "var_value");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(578, 0);

		try {
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:582:2: ( ( NOT )? ( var_name ) ( var_comp[$var_value::val] )? -> var_value(not=$NOT.textvar=$var_value::val))
			dbg.enterAlt(1);

			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:583:2: ( NOT )? ( var_name ) ( var_comp[$var_value::val] )?
			{
			dbg.location(583,2);
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:583:2: ( NOT )?
			int alt70=2;
			try { dbg.enterSubRule(70);
			try { dbg.enterDecision(70, decisionCanBacktrack[70]);

			int LA70_0 = input.LA(1);
			if ( (LA70_0==NOT) ) {
				alt70=1;
			}
			} finally {dbg.exitDecision(70);}

			switch (alt70) {
				case 1 :
					dbg.enterAlt(1);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:583:3: NOT
					{
					dbg.location(583,3);
					NOT77=(Token)match(input,NOT,FOLLOW_NOT_in_var_value2885); if (state.failed) return retval;
					}
					break;

			}
			} finally {dbg.exitSubRule(70);}
			dbg.location(583,10);
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:583:10: ( var_name )
			dbg.enterAlt(1);

			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:583:11: var_name
			{
			dbg.location(583,11);
			pushFollow(FOLLOW_var_name_in_var_value2891);
			var_name75=var_name();
			state._fsp--;
			if (state.failed) return retval;dbg.location(583,20);
			if ( state.backtracking==0 ) {var_value_stack.peek().val = (var_name75!=null?((StringTemplate)var_name75.getTemplate()):null);}
			}
			dbg.location(583,55);
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:583:55: ( var_comp[$var_value::val] )?
			int alt71=2;
			try { dbg.enterSubRule(71);
			try { dbg.enterDecision(71, decisionCanBacktrack[71]);

			int LA71_0 = input.LA(1);
			if ( (LA71_0==27||LA71_0==35) ) {
				alt71=1;
			}
			} finally {dbg.exitDecision(71);}

			switch (alt71) {
				case 1 :
					dbg.enterAlt(1);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:583:56: var_comp[$var_value::val]
					{
					dbg.location(583,56);
					pushFollow(FOLLOW_var_comp_in_var_value2897);
					var_comp76=var_comp(var_value_stack.peek().val);
					state._fsp--;
					if (state.failed) return retval;dbg.location(583,82);
					if ( state.backtracking==0 ) {var_value_stack.peek().val = (var_comp76!=null?((StringTemplate)var_comp76.getTemplate()):null);}
					}
					break;

			}
			} finally {dbg.exitSubRule(71);}

			// TEMPLATE REWRITE
			if ( state.backtracking==0 ) {
			  // 583:119: -> var_value(not=$NOT.textvar=$var_value::val)
			  {
			  	retval.st = templateLib.getInstanceOf("var_value",new STAttrMap().put("not", (NOT77!=null?NOT77.getText():null)).put("var", var_value_stack.peek().val));
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
			var_value_stack.pop();
		}
		dbg.location(584, 1);

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
	// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:587:1: var_comp[StringTemplate attTemplate] : ( ( '.' ( ( sc_method[$attTemplate] ) | ( method ) ) ) | ( array_index[$attTemplate] ) ) (vcomp= var_comp[$attTemplate] )? -> dummy(val=$attTemplate);
	public final Systemc_basicParser.var_comp_return var_comp(StringTemplate attTemplate) throws  {
		Systemc_basicParser.var_comp_return retval = new Systemc_basicParser.var_comp_return();
		retval.start = input.LT(1);

		ParserRuleReturnScope vcomp =null;
		ParserRuleReturnScope sc_method78 =null;
		ParserRuleReturnScope method79 =null;
		ParserRuleReturnScope array_index80 =null;

		try { dbg.enterRule(getGrammarFileName(), "var_comp");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(587, 0);

		try {
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:587:39: ( ( ( '.' ( ( sc_method[$attTemplate] ) | ( method ) ) ) | ( array_index[$attTemplate] ) ) (vcomp= var_comp[$attTemplate] )? -> dummy(val=$attTemplate))
			dbg.enterAlt(1);

			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:588:2: ( ( '.' ( ( sc_method[$attTemplate] ) | ( method ) ) ) | ( array_index[$attTemplate] ) ) (vcomp= var_comp[$attTemplate] )?
			{
			dbg.location(588,2);
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:588:2: ( ( '.' ( ( sc_method[$attTemplate] ) | ( method ) ) ) | ( array_index[$attTemplate] ) )
			int alt73=2;
			try { dbg.enterSubRule(73);
			try { dbg.enterDecision(73, decisionCanBacktrack[73]);

			int LA73_0 = input.LA(1);
			if ( (LA73_0==27) ) {
				alt73=1;
			}
			else if ( (LA73_0==35) ) {
				alt73=2;
			}

			else {
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

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:588:3: ( '.' ( ( sc_method[$attTemplate] ) | ( method ) ) )
					{
					dbg.location(588,3);
					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:588:3: ( '.' ( ( sc_method[$attTemplate] ) | ( method ) ) )
					dbg.enterAlt(1);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:588:4: '.' ( ( sc_method[$attTemplate] ) | ( method ) )
					{
					dbg.location(588,4);
					match(input,27,FOLLOW_27_in_var_comp2937); if (state.failed) return retval;dbg.location(589,2);
					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:589:2: ( ( sc_method[$attTemplate] ) | ( method ) )
					int alt72=2;
					try { dbg.enterSubRule(72);
					try { dbg.enterDecision(72, decisionCanBacktrack[72]);

					int LA72_0 = input.LA(1);
					if ( (LA72_0==23||LA72_0==43||(LA72_0 >= 53 && LA72_0 <= 56)||(LA72_0 >= 75 && LA72_0 <= 76)) ) {
						alt72=1;
					}
					else if ( (LA72_0==ID) ) {
						alt72=2;
					}

					else {
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

							// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:589:3: ( sc_method[$attTemplate] )
							{
							dbg.location(589,3);
							// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:589:3: ( sc_method[$attTemplate] )
							dbg.enterAlt(1);

							// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:589:5: sc_method[$attTemplate]
							{
							dbg.location(589,5);
							pushFollow(FOLLOW_sc_method_in_var_comp2943);
							sc_method78=sc_method(attTemplate);
							state._fsp--;
							if (state.failed) return retval;dbg.location(589,29);
							if ( state.backtracking==0 ) {attTemplate = (sc_method78!=null?((StringTemplate)sc_method78.getTemplate()):null) ; }
							}

							}
							break;
						case 2 :
							dbg.enterAlt(2);

							// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:590:4: ( method )
							{
							dbg.location(590,4);
							// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:590:4: ( method )
							dbg.enterAlt(1);

							// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:590:5: method
							{
							dbg.location(590,5);
							pushFollow(FOLLOW_method_in_var_comp2953);
							method79=method();
							state._fsp--;
							if (state.failed) return retval;dbg.location(590,12);
							if ( state.backtracking==0 ) {attTemplate = (method79!=null?((StringTemplate)method79.getTemplate()):null) ; }
							}

							}
							break;

					}
					} finally {dbg.exitSubRule(72);}

					}

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:593:4: ( array_index[$attTemplate] )
					{
					dbg.location(593,4);
					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:593:4: ( array_index[$attTemplate] )
					dbg.enterAlt(1);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:593:5: array_index[$attTemplate]
					{
					dbg.location(593,5);
					pushFollow(FOLLOW_array_index_in_var_comp2969);
					array_index80=array_index(attTemplate);
					state._fsp--;
					if (state.failed) return retval;dbg.location(593,31);
					if ( state.backtracking==0 ) {attTemplate = (array_index80!=null?((StringTemplate)array_index80.getTemplate()):null) ;}
					}

					}
					break;

			}
			} finally {dbg.exitSubRule(73);}
			dbg.location(594,4);
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:594:4: (vcomp= var_comp[$attTemplate] )?
			int alt74=2;
			try { dbg.enterSubRule(74);
			try { dbg.enterDecision(74, decisionCanBacktrack[74]);

			int LA74_0 = input.LA(1);
			if ( (LA74_0==27||LA74_0==35) ) {
				alt74=1;
			}
			} finally {dbg.exitDecision(74);}

			switch (alt74) {
				case 1 :
					dbg.enterAlt(1);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:594:5: vcomp= var_comp[$attTemplate]
					{
					dbg.location(594,11);
					pushFollow(FOLLOW_var_comp_in_var_comp2984);
					vcomp=var_comp(attTemplate);
					state._fsp--;
					if (state.failed) return retval;dbg.location(594,36);
					if ( state.backtracking==0 ) {attTemplate = (vcomp!=null?((StringTemplate)vcomp.getTemplate()):null) ;}
					}
					break;

			}
			} finally {dbg.exitSubRule(74);}

			// TEMPLATE REWRITE
			if ( state.backtracking==0 ) {
			  // 594:67: -> dummy(val=$attTemplate)
			  {
			  	retval.st = templateLib.getInstanceOf("dummy",new STAttrMap().put("val", attTemplate));
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
		dbg.location(595, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "var_comp");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "var_comp"


	public static class array_index_return extends ParserRuleReturnScope {
		public StringTemplate st;
		public Object getTemplate() { return st; }
		public String toString() { return st==null?null:st.toString(); }
	};


	// $ANTLR start "array_index"
	// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:597:1: array_index[StringTemplate attTemplate] : '[' value ']' -> array_value(var=$attTemplateindex=$value.st);
	public final Systemc_basicParser.array_index_return array_index(StringTemplate attTemplate) throws  {
		Systemc_basicParser.array_index_return retval = new Systemc_basicParser.array_index_return();
		retval.start = input.LT(1);

		ParserRuleReturnScope value81 =null;

		try { dbg.enterRule(getGrammarFileName(), "array_index");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(597, 0);

		try {
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:598:2: ( '[' value ']' -> array_value(var=$attTemplateindex=$value.st))
			dbg.enterAlt(1);

			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:599:2: '[' value ']'
			{
			dbg.location(599,2);
			match(input,35,FOLLOW_35_in_array_index3015); if (state.failed) return retval;dbg.location(599,5);
			pushFollow(FOLLOW_value_in_array_index3016);
			value81=value();
			state._fsp--;
			if (state.failed) return retval;dbg.location(599,10);
			match(input,37,FOLLOW_37_in_array_index3017); if (state.failed) return retval;
			// TEMPLATE REWRITE
			if ( state.backtracking==0 ) {
			  // 599:15: -> array_value(var=$attTemplateindex=$value.st)
			  {
			  	retval.st = templateLib.getInstanceOf("array_value",new STAttrMap().put("var", attTemplate).put("index", (value81!=null?((StringTemplate)value81.getTemplate()):null)));
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
		dbg.location(600, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "array_index");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "array_index"


	public static class var_name_return extends ParserRuleReturnScope {
		public StringTemplate st;
		public Object getTemplate() { return st; }
		public String toString() { return st==null?null:st.toString(); }
	};


	// $ANTLR start "var_name"
	// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:602:1: var_name : ID -> dummy(val=$ID.text.trim());
	public final Systemc_basicParser.var_name_return var_name() throws  {
		Systemc_basicParser.var_name_return retval = new Systemc_basicParser.var_name_return();
		retval.start = input.LT(1);

		Token ID82=null;

		try { dbg.enterRule(getGrammarFileName(), "var_name");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(602, 0);

		try {
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:603:2: ( ID -> dummy(val=$ID.text.trim()))
			dbg.enterAlt(1);

			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:604:2: ID
			{
			dbg.location(604,2);
			ID82=(Token)match(input,ID,FOLLOW_ID_in_var_name3050); if (state.failed) return retval;
			// TEMPLATE REWRITE
			if ( state.backtracking==0 ) {
			  // 604:5: -> dummy(val=$ID.text.trim())
			  {
			  	retval.st = templateLib.getInstanceOf("dummy",new STAttrMap().put("val", (ID82!=null?ID82.getText():null).trim()));
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
		dbg.location(605, 1);

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
	// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:609:1: sc_type : ( 'sc_lv' ( LT INT GT ) -> logic_vector(size=$INT.text)| 'sc_uint' ( LT INT GT ) -> logic_vector(size=$INT.text)| 'sc_logic' -> logic(| 'bool' -> bool();
	public final Systemc_basicParser.sc_type_return sc_type() throws  {
		Systemc_basicParser.sc_type_return retval = new Systemc_basicParser.sc_type_return();
		retval.start = input.LT(1);

		Token INT83=null;
		Token INT84=null;

		try { dbg.enterRule(getGrammarFileName(), "sc_type");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(609, 0);

		try {
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:609:9: ( 'sc_lv' ( LT INT GT ) -> logic_vector(size=$INT.text)| 'sc_uint' ( LT INT GT ) -> logic_vector(size=$INT.text)| 'sc_logic' -> logic(| 'bool' -> bool()
			int alt75=4;
			try { dbg.enterDecision(75, decisionCanBacktrack[75]);

			switch ( input.LA(1) ) {
			case 65:
				{
				alt75=1;
				}
				break;
			case 70:
				{
				alt75=2;
				}
				break;
			case 64:
				{
				alt75=3;
				}
				break;
			case 39:
				{
				alt75=4;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 75, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}
			} finally {dbg.exitDecision(75);}

			switch (alt75) {
				case 1 :
					dbg.enterAlt(1);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:610:2: 'sc_lv' ( LT INT GT )
					{
					dbg.location(610,2);
					match(input,65,FOLLOW_65_in_sc_type3074); if (state.failed) return retval;dbg.location(610,9);
					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:610:9: ( LT INT GT )
					dbg.enterAlt(1);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:610:10: LT INT GT
					{
					dbg.location(610,10);
					match(input,LT,FOLLOW_LT_in_sc_type3076); if (state.failed) return retval;dbg.location(610,13);
					INT83=(Token)match(input,INT,FOLLOW_INT_in_sc_type3078); if (state.failed) return retval;dbg.location(610,17);
					match(input,GT,FOLLOW_GT_in_sc_type3080); if (state.failed) return retval;
					}

					// TEMPLATE REWRITE
					if ( state.backtracking==0 ) {
					  // 610:21: -> logic_vector(size=$INT.text)
					  {
					  	retval.st = templateLib.getInstanceOf("logic_vector",new STAttrMap().put("size", (INT83!=null?INT83.getText():null)));
					  }


					}

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:611:4: 'sc_uint' ( LT INT GT )
					{
					dbg.location(611,4);
					match(input,70,FOLLOW_70_in_sc_type3095); if (state.failed) return retval;dbg.location(611,14);
					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:611:14: ( LT INT GT )
					dbg.enterAlt(1);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:611:15: LT INT GT
					{
					dbg.location(611,15);
					match(input,LT,FOLLOW_LT_in_sc_type3098); if (state.failed) return retval;dbg.location(611,18);
					INT84=(Token)match(input,INT,FOLLOW_INT_in_sc_type3100); if (state.failed) return retval;dbg.location(611,22);
					match(input,GT,FOLLOW_GT_in_sc_type3102); if (state.failed) return retval;
					}

					// TEMPLATE REWRITE
					if ( state.backtracking==0 ) {
					  // 611:26: -> logic_vector(size=$INT.text)
					  {
					  	retval.st = templateLib.getInstanceOf("logic_vector",new STAttrMap().put("size", (INT84!=null?INT84.getText():null)));
					  }


					}

					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:612:4: 'sc_logic'
					{
					dbg.location(612,4);
					match(input,64,FOLLOW_64_in_sc_type3117); if (state.failed) return retval;
					// TEMPLATE REWRITE
					if ( state.backtracking==0 ) {
					  // 612:15: -> logic(
					  {
					  	retval.st = templateLib.getInstanceOf("logic");
					  }


					}

					}
					break;
				case 4 :
					dbg.enterAlt(4);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:613:4: 'bool'
					{
					dbg.location(613,4);
					match(input,39,FOLLOW_39_in_sc_type3128); if (state.failed) return retval;
					// TEMPLATE REWRITE
					if ( state.backtracking==0 ) {
					  // 613:11: -> bool(
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
		dbg.location(614, 1);

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
	// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:659:1: sc_method[StringTemplate signalSt] : ( 'range(' from= INT ',' to= INT ')' -> range(sc=$signalStfrom=$from.textto=$to.text)| 'concat(' left= value ',' right= value ')' -> concat(left=$left.stright=$right.st)| 'read()' -> dummy(val=$signalSt)| 'posedge()' -> posedge(signal=$signalSt)| 'negedge()' -> negedge(signal=$signalSt)| 'to_int()' -> integer_conv(signal=$signalSt)| 'to_uint()' -> uinteger_conv(signal=$signalSt)| '(' left= value ',' right= value ')' -> concat(left=$left.stright=$right.st));
	public final Systemc_basicParser.sc_method_return sc_method(StringTemplate signalSt) throws  {
		Systemc_basicParser.sc_method_return retval = new Systemc_basicParser.sc_method_return();
		retval.start = input.LT(1);

		Token from=null;
		Token to=null;
		ParserRuleReturnScope left =null;
		ParserRuleReturnScope right =null;

		try { dbg.enterRule(getGrammarFileName(), "sc_method");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(659, 0);

		try {
			// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:660:2: ( 'range(' from= INT ',' to= INT ')' -> range(sc=$signalStfrom=$from.textto=$to.text)| 'concat(' left= value ',' right= value ')' -> concat(left=$left.stright=$right.st)| 'read()' -> dummy(val=$signalSt)| 'posedge()' -> posedge(signal=$signalSt)| 'negedge()' -> negedge(signal=$signalSt)| 'to_int()' -> integer_conv(signal=$signalSt)| 'to_uint()' -> uinteger_conv(signal=$signalSt)| '(' left= value ',' right= value ')' -> concat(left=$left.stright=$right.st))
			int alt76=8;
			try { dbg.enterDecision(76, decisionCanBacktrack[76]);

			switch ( input.LA(1) ) {
			case 55:
				{
				alt76=1;
				}
				break;
			case 43:
				{
				alt76=2;
				}
				break;
			case 56:
				{
				alt76=3;
				}
				break;
			case 54:
				{
				alt76=4;
				}
				break;
			case 53:
				{
				alt76=5;
				}
				break;
			case 75:
				{
				alt76=6;
				}
				break;
			case 76:
				{
				alt76=7;
				}
				break;
			case 23:
				{
				alt76=8;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 76, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}
			} finally {dbg.exitDecision(76);}

			switch (alt76) {
				case 1 :
					dbg.enterAlt(1);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:661:2: 'range(' from= INT ',' to= INT ')'
					{
					dbg.location(661,2);
					match(input,55,FOLLOW_55_in_sc_method3153); if (state.failed) return retval;dbg.location(661,15);
					from=(Token)match(input,INT,FOLLOW_INT_in_sc_method3158); if (state.failed) return retval;dbg.location(661,21);
					match(input,26,FOLLOW_26_in_sc_method3160); if (state.failed) return retval;dbg.location(661,28);
					to=(Token)match(input,INT,FOLLOW_INT_in_sc_method3166); if (state.failed) return retval;dbg.location(661,33);
					match(input,24,FOLLOW_24_in_sc_method3167); if (state.failed) return retval;
					// TEMPLATE REWRITE
					if ( state.backtracking==0 ) {
					  // 661:37: -> range(sc=$signalStfrom=$from.textto=$to.text)
					  {
					  	retval.st = templateLib.getInstanceOf("range",new STAttrMap().put("sc", signalSt).put("from", (from!=null?from.getText():null)).put("to", (to!=null?to.getText():null)));
					  }


					}

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:662:3: 'concat(' left= value ',' right= value ')'
					{
					dbg.location(662,3);
					match(input,43,FOLLOW_43_in_sc_method3196); if (state.failed) return retval;dbg.location(662,19);
					pushFollow(FOLLOW_value_in_sc_method3203);
					left=value();
					state._fsp--;
					if (state.failed) return retval;dbg.location(662,28);
					match(input,26,FOLLOW_26_in_sc_method3206); if (state.failed) return retval;dbg.location(662,37);
					pushFollow(FOLLOW_value_in_sc_method3211);
					right=value();
					state._fsp--;
					if (state.failed) return retval;dbg.location(662,45);
					match(input,24,FOLLOW_24_in_sc_method3213); if (state.failed) return retval;
					// TEMPLATE REWRITE
					if ( state.backtracking==0 ) {
					  // 662:48: -> concat(left=$left.stright=$right.st)
					  {
					  	retval.st = templateLib.getInstanceOf("concat",new STAttrMap().put("left", (left!=null?((StringTemplate)left.getTemplate()):null)).put("right", (right!=null?((StringTemplate)right.getTemplate()):null)));
					  }


					}

					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:663:4: 'read()'
					{
					dbg.location(663,4);
					match(input,56,FOLLOW_56_in_sc_method3235); if (state.failed) return retval;
					// TEMPLATE REWRITE
					if ( state.backtracking==0 ) {
					  // 663:13: -> dummy(val=$signalSt)
					  {
					  	retval.st = templateLib.getInstanceOf("dummy",new STAttrMap().put("val", signalSt));
					  }


					}

					}
					break;
				case 4 :
					dbg.enterAlt(4);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:664:4: 'posedge()'
					{
					dbg.location(664,4);
					match(input,54,FOLLOW_54_in_sc_method3251); if (state.failed) return retval;
					// TEMPLATE REWRITE
					if ( state.backtracking==0 ) {
					  // 664:16: -> posedge(signal=$signalSt)
					  {
					  	retval.st = templateLib.getInstanceOf("posedge",new STAttrMap().put("signal", signalSt));
					  }


					}

					}
					break;
				case 5 :
					dbg.enterAlt(5);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:665:4: 'negedge()'
					{
					dbg.location(665,4);
					match(input,53,FOLLOW_53_in_sc_method3267); if (state.failed) return retval;
					// TEMPLATE REWRITE
					if ( state.backtracking==0 ) {
					  // 665:16: -> negedge(signal=$signalSt)
					  {
					  	retval.st = templateLib.getInstanceOf("negedge",new STAttrMap().put("signal", signalSt));
					  }


					}

					}
					break;
				case 6 :
					dbg.enterAlt(6);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:666:4: 'to_int()'
					{
					dbg.location(666,4);
					match(input,75,FOLLOW_75_in_sc_method3283); if (state.failed) return retval;
					// TEMPLATE REWRITE
					if ( state.backtracking==0 ) {
					  // 666:15: -> integer_conv(signal=$signalSt)
					  {
					  	retval.st = templateLib.getInstanceOf("integer_conv",new STAttrMap().put("signal", signalSt));
					  }


					}

					}
					break;
				case 7 :
					dbg.enterAlt(7);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:667:4: 'to_uint()'
					{
					dbg.location(667,4);
					match(input,76,FOLLOW_76_in_sc_method3299); if (state.failed) return retval;
					// TEMPLATE REWRITE
					if ( state.backtracking==0 ) {
					  // 667:16: -> uinteger_conv(signal=$signalSt)
					  {
					  	retval.st = templateLib.getInstanceOf("uinteger_conv",new STAttrMap().put("signal", signalSt));
					  }


					}

					}
					break;
				case 8 :
					dbg.enterAlt(8);

					// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:668:3: '(' left= value ',' right= value ')'
					{
					dbg.location(668,3);
					match(input,23,FOLLOW_23_in_sc_method3313); if (state.failed) return retval;dbg.location(668,13);
					pushFollow(FOLLOW_value_in_sc_method3320);
					left=value();
					state._fsp--;
					if (state.failed) return retval;dbg.location(668,21);
					match(input,26,FOLLOW_26_in_sc_method3322); if (state.failed) return retval;dbg.location(668,30);
					pushFollow(FOLLOW_value_in_sc_method3327);
					right=value();
					state._fsp--;
					if (state.failed) return retval;dbg.location(668,37);
					match(input,24,FOLLOW_24_in_sc_method3328); if (state.failed) return retval;
					// TEMPLATE REWRITE
					if ( state.backtracking==0 ) {
					  // 668:40: -> concat(left=$left.stright=$right.st)
					  {
					  	retval.st = templateLib.getInstanceOf("concat",new STAttrMap().put("left", (left!=null?((StringTemplate)left.getTemplate()):null)).put("right", (right!=null?((StringTemplate)right.getTemplate()):null)));
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
		dbg.location(669, 1);

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
	public final void synpred1_Systemc_basic_fragment() throws  {
		// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:468:4: ( ( ( NOT )? enclosed_expr ) )
		dbg.enterAlt(1);

		// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:468:4: ( ( NOT )? enclosed_expr )
		{
		dbg.location(468,4);
		// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:468:4: ( ( NOT )? enclosed_expr )
		dbg.enterAlt(1);

		// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:468:5: ( NOT )? enclosed_expr
		{
		dbg.location(468,5);
		// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:468:5: ( NOT )?
		int alt77=2;
		try { dbg.enterSubRule(77);
		try { dbg.enterDecision(77, decisionCanBacktrack[77]);

		int LA77_0 = input.LA(1);
		if ( (LA77_0==NOT) ) {
			alt77=1;
		}
		} finally {dbg.exitDecision(77);}

		switch (alt77) {
			case 1 :
				dbg.enterAlt(1);

				// /home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/Systemc_basic.g:468:6: NOT
				{
				dbg.location(468,6);
				match(input,NOT,FOLLOW_NOT_in_synpred1_Systemc_basic2218); if (state.failed) return;
				}
				break;

		}
		} finally {dbg.exitSubRule(77);}
		dbg.location(468,12);
		pushFollow(FOLLOW_enclosed_expr_in_synpred1_Systemc_basic2222);
		enclosed_expr();
		state._fsp--;
		if (state.failed) return;
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


	protected DFA10 dfa10 = new DFA10(this);
	static final String DFA10_eotS =
		"\40\uffff";
	static final String DFA10_eofS =
		"\40\uffff";
	static final String DFA10_minS =
		"\1\12\3\uffff\1\52\1\63\5\12\2\16\3\12\2\uffff\1\6\1\12\2\15\1\12\1\uffff"+
		"\3\10\4\12\1\10";
	static final String DFA10_maxS =
		"\1\116\3\uffff\2\110\4\44\1\12\2\16\3\44\2\uffff\1\43\1\44\3\15\1\uffff"+
		"\2\10\1\32\2\44\1\15\1\44\1\32";
	static final String DFA10_acceptS =
		"\1\uffff\1\1\1\2\1\3\14\uffff\1\6\1\4\5\uffff\1\5\10\uffff";
	static final String DFA10_specialS =
		"\40\uffff}>";
	static final String[] DFA10_transitionS = {
			"\1\17\25\uffff\1\20\6\uffff\1\16\2\uffff\1\7\5\uffff\1\3\1\10\1\uffff"+
			"\1\6\1\5\4\uffff\7\1\1\15\1\13\3\1\1\2\1\14\1\uffff\1\5\1\12\3\uffff"+
			"\1\4\1\11",
			"",
			"",
			"",
			"\1\7\10\uffff\1\6\1\5\23\uffff\1\5",
			"\1\6\1\5\23\uffff\1\5",
			"\1\22\16\uffff\1\21\12\uffff\1\21",
			"\1\22\16\uffff\1\21\12\uffff\1\21",
			"\1\22\16\uffff\1\21\12\uffff\1\21",
			"\1\22\16\uffff\1\21\12\uffff\1\21",
			"\1\23",
			"\1\24",
			"\1\25",
			"\1\22\16\uffff\1\21\12\uffff\1\21",
			"\1\22\16\uffff\1\21\12\uffff\1\21",
			"\1\22\3\uffff\1\26\12\uffff\1\21\12\uffff\1\21",
			"",
			"",
			"\1\21\12\uffff\1\21\5\uffff\1\27\2\uffff\1\21\3\uffff\1\27\4\uffff\1"+
			"\21",
			"\1\22\16\uffff\1\21\12\uffff\1\21",
			"\1\30",
			"\1\31",
			"\1\32\2\uffff\1\32",
			"",
			"\1\33",
			"\1\34",
			"\1\36\21\uffff\1\35",
			"\1\22\16\uffff\1\21\12\uffff\1\21",
			"\1\22\16\uffff\1\21\12\uffff\1\21",
			"\1\37\2\uffff\1\37",
			"\1\22\16\uffff\1\21\12\uffff\1\21",
			"\1\36\21\uffff\1\35"
	};

	static final short[] DFA10_eot = DFA.unpackEncodedString(DFA10_eotS);
	static final short[] DFA10_eof = DFA.unpackEncodedString(DFA10_eofS);
	static final char[] DFA10_min = DFA.unpackEncodedStringToUnsignedChars(DFA10_minS);
	static final char[] DFA10_max = DFA.unpackEncodedStringToUnsignedChars(DFA10_maxS);
	static final short[] DFA10_accept = DFA.unpackEncodedString(DFA10_acceptS);
	static final short[] DFA10_special = DFA.unpackEncodedString(DFA10_specialS);
	static final short[][] DFA10_transition;

	static {
		int numStates = DFA10_transitionS.length;
		DFA10_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA10_transition[i] = DFA.unpackEncodedString(DFA10_transitionS[i]);
		}
	}

	protected class DFA10 extends DFA {

		public DFA10(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 10;
			this.eot = DFA10_eot;
			this.eof = DFA10_eof;
			this.min = DFA10_min;
			this.max = DFA10_max;
			this.accept = DFA10_accept;
			this.special = DFA10_special;
			this.transition = DFA10_transition;
		}
		@Override
		public String getDescription() {
			return "136:2: ( port_decl SEMICOLON | signal_dec SEMICOLON | enum_decl SEMICOLON | variable_decl[$vars] SEMICOLON | func_decl ( SEMICOLON )? | actor )";
		}
		public void error(NoViableAltException nvae) {
			dbg.recognitionException(nvae);
		}
	}

	public static final BitSet FOLLOW_pre_processor_in_cfile63 = new BitSet(new long[]{0xFE1B048500200400L,0x000000000000637FL});
	public static final BitSet FOLLOW_declarations_in_cfile68 = new BitSet(new long[]{0xFE1B048500000400L,0x000000000000637FL});
	public static final BitSet FOLLOW_module_decl_in_cfile75 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_SEMICOLON_in_cfile77 = new BitSet(new long[]{0xFE1B048100200402L,0x000000000000637FL});
	public static final BitSet FOLLOW_pre_processor_in_cfile82 = new BitSet(new long[]{0xFE1B048100200402L,0x000000000000637FL});
	public static final BitSet FOLLOW_declarations_in_cfile86 = new BitSet(new long[]{0xFE1B048100200402L,0x000000000000637FL});
	public static final BitSet FOLLOW_21_in_pre_processor111 = new BitSet(new long[]{0x0000A00000001800L});
	public static final BitSet FOLLOW_INCLUDE_in_pre_processor113 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_define_in_pre_processor119 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IFNDEF_in_pre_processor125 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_47_in_pre_processor130 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_45_in_define143 = new BitSet(new long[]{0x0000000000100400L});
	public static final BitSet FOLLOW_WS_in_define146 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_ID_in_define155 = new BitSet(new long[]{0x0000000000182202L});
	public static final BitSet FOLLOW_WS_in_define160 = new BitSet(new long[]{0x0000000000082202L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_define168 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_HEX_in_define175 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_define207 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_34_in_module_decl256 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_23_in_module_decl258 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_ID_in_module_decl260 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_24_in_module_decl262 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
	public static final BitSet FOLLOW_80_in_module_decl264 = new BitSet(new long[]{0xFE1B048100000400L,0x000000000000637FL});
	public static final BitSet FOLLOW_module_body_in_module_decl274 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
	public static final BitSet FOLLOW_82_in_module_decl284 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_declarations_in_module_body468 = new BitSet(new long[]{0xFE1B048100000402L,0x000000000000637FL});
	public static final BitSet FOLLOW_port_decl_in_declarations486 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_SEMICOLON_in_declarations488 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_signal_dec_in_declarations496 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_SEMICOLON_in_declarations498 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_enum_decl_in_declarations505 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_SEMICOLON_in_declarations507 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_variable_decl_in_declarations514 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_SEMICOLON_in_declarations517 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_func_decl_in_declarations522 = new BitSet(new long[]{0x0000000000020002L});
	public static final BitSet FOLLOW_SEMICOLON_in_declarations524 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_actor_in_declarations530 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_v_type_in_func_decl546 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_ID_in_func_decl551 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_30_in_func_decl552 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_ID_in_func_decl558 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_23_in_func_decl560 = new BitSet(new long[]{0x001A048001000400L,0x0000000000006343L});
	public static final BitSet FOLLOW_v_type_in_func_decl563 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_ID_in_func_decl565 = new BitSet(new long[]{0x0000000005000000L});
	public static final BitSet FOLLOW_26_in_func_decl568 = new BitSet(new long[]{0x001A048000000400L,0x0000000000006343L});
	public static final BitSet FOLLOW_v_type_in_func_decl569 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_ID_in_func_decl571 = new BitSet(new long[]{0x0000000005000000L});
	public static final BitSet FOLLOW_24_in_func_decl577 = new BitSet(new long[]{0x0000000000000002L,0x0000000000010000L});
	public static final BitSet FOLLOW_func_body_in_func_decl582 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_48_in_enum_decl610 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_ID_in_enum_decl612 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
	public static final BitSet FOLLOW_80_in_enum_decl614 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_name_in_enum_decl616 = new BitSet(new long[]{0x0000000004000000L,0x0000000000040000L});
	public static final BitSet FOLLOW_26_in_enum_decl619 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_name_in_enum_decl621 = new BitSet(new long[]{0x0000000004000000L,0x0000000000040000L});
	public static final BitSet FOLLOW_82_in_enum_decl625 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_v_type_in_variable_decl653 = new BitSet(new long[]{0x0000001002000400L});
	public static final BitSet FOLLOW_ID_in_variable_decl671 = new BitSet(new long[]{0x0000000804000042L});
	public static final BitSet FOLLOW_26_in_variable_decl680 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_ID_in_variable_decl684 = new BitSet(new long[]{0x0000000804000042L});
	public static final BitSet FOLLOW_fixed_size_array_in_variable_decl690 = new BitSet(new long[]{0x0000000800000042L});
	public static final BitSet FOLLOW_assignement_in_variable_decl693 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_35_in_fixed_size_array713 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_INT_in_fixed_size_array714 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_37_in_fixed_size_array715 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EQUAL_in_assignement729 = new BitSet(new long[]{0x01E008800088A610L,0x0000000000001843L});
	public static final BitSet FOLLOW_value_in_assignement731 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_80_in_array_of_value742 = new BitSet(new long[]{0x0000000000002080L,0x0000000000010000L});
	public static final BitSet FOLLOW_INT_in_array_of_value744 = new BitSet(new long[]{0x0000000004000000L,0x0000000000040000L});
	public static final BitSet FOLLOW_array_of_value_in_array_of_value747 = new BitSet(new long[]{0x0000000004000000L,0x0000000000040000L});
	public static final BitSet FOLLOW_FLOAT_in_array_of_value751 = new BitSet(new long[]{0x0000000004000000L,0x0000000000040000L});
	public static final BitSet FOLLOW_26_in_array_of_value755 = new BitSet(new long[]{0x0000000000002080L,0x0000000000010000L});
	public static final BitSet FOLLOW_INT_in_array_of_value758 = new BitSet(new long[]{0x0000000004000000L,0x0000000000040000L});
	public static final BitSet FOLLOW_array_of_value_in_array_of_value761 = new BitSet(new long[]{0x0000000004000000L,0x0000000000040000L});
	public static final BitSet FOLLOW_FLOAT_in_array_of_value765 = new BitSet(new long[]{0x0000000004000000L,0x0000000000040000L});
	public static final BitSet FOLLOW_82_in_array_of_value769 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_v_signed_modifier_in_v_type782 = new BitSet(new long[]{0x0018000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_v_size_modifier_in_v_type785 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_51_in_v_type789 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_v_signed_modifier_in_v_type794 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_42_in_v_type798 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_49_in_v_type801 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_78_in_v_type803 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_73_in_v_type806 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_ID_in_v_type808 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_sc_type_in_v_type812 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_v_type815 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_otemplate_in_v_type817 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_77_in_v_signed_modifier844 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LT_in_otemplate853 = new BitSet(new long[]{0x0000000000002400L});
	public static final BitSet FOLLOW_set_in_otemplate855 = new BitSet(new long[]{0x0000000004000100L});
	public static final BitSet FOLLOW_26_in_otemplate862 = new BitSet(new long[]{0x0000000000002400L});
	public static final BitSet FOLLOW_set_in_otemplate864 = new BitSet(new long[]{0x0000000004000100L});
	public static final BitSet FOLLOW_GT_in_otemplate871 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_32_in_actor881 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_23_in_actor882 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_ID_in_actor883 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_24_in_actor884 = new BitSet(new long[]{0x0000000020000000L,0x0000000000010000L});
	public static final BitSet FOLLOW_29_in_actor888 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_actor_inst_in_actor890 = new BitSet(new long[]{0x0000000004000000L,0x0000000000010000L});
	public static final BitSet FOLLOW_26_in_actor893 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_actor_inst_in_actor894 = new BitSet(new long[]{0x0000000004000000L,0x0000000000010000L});
	public static final BitSet FOLLOW_80_in_actor900 = new BitSet(new long[]{0x0000000200000400L});
	public static final BitSet FOLLOW_actor_body_in_actor903 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
	public static final BitSet FOLLOW_82_in_actor906 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_actor_inst924 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_ID_in_actor_inst930 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_23_in_actor_inst931 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_actor_inst932 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_24_in_actor_inst933 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_connection949 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_27_in_connection950 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_link_in_connection951 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_link964 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_23_in_link965 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_ID_in_link968 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_24_in_link969 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_71_in_sensitive999 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_31_in_sensitive1001 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_ID_in_sensitive1003 = new BitSet(new long[]{0x0000000008000002L});
	public static final BitSet FOLLOW_27_in_sensitive1006 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_method_in_sensitive1007 = new BitSet(new long[]{0x0000000008000002L});
	public static final BitSet FOLLOW_ID_in_method1033 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_23_in_method1034 = new BitSet(new long[]{0x01E008800188A610L,0x0000000000001843L});
	public static final BitSet FOLLOW_func_arg_in_method1036 = new BitSet(new long[]{0x0000000005000000L});
	public static final BitSet FOLLOW_26_in_method1038 = new BitSet(new long[]{0x01E008800088A610L,0x0000000000001843L});
	public static final BitSet FOLLOW_func_arg_in_method1041 = new BitSet(new long[]{0x0000000005000000L});
	public static final BitSet FOLLOW_24_in_method1048 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_value_in_func_arg1074 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_actor_method_decl_in_actor_method1103 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_SEMICOLON_in_actor_method1105 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
	public static final BitSet FOLLOW_sensitive_in_actor_method1110 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_SEMICOLON_in_actor_method1112 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
	public static final BitSet FOLLOW_33_in_actor_method_decl1147 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_ID_in_actor_method_decl1152 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_24_in_actor_method_decl1153 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_actor_body_elt_in_actor_body1166 = new BitSet(new long[]{0x0000000200000402L});
	public static final BitSet FOLLOW_actor_method_in_actor_body_elt1185 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_func_call_in_actor_body_elt1193 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_SEMICOLON_in_actor_body_elt1195 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_connection_in_actor_body_elt1201 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_SEMICOLON_in_actor_body_elt1204 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_sc_signal_in_signal_dec1233 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_name_in_signal_dec1238 = new BitSet(new long[]{0x0000000804000002L});
	public static final BitSet FOLLOW_26_in_signal_dec1241 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_name_in_signal_dec1242 = new BitSet(new long[]{0x0000000804000002L});
	public static final BitSet FOLLOW_fixed_size_array_in_signal_dec1250 = new BitSet(new long[]{0x0000000800000002L});
	public static final BitSet FOLLOW_69_in_sc_signal1293 = new BitSet(new long[]{0x0000004000004000L});
	public static final BitSet FOLLOW_38_in_sc_signal1295 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_ctemplate_in_sc_signal1298 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LT_in_ctemplate1322 = new BitSet(new long[]{0x0000008000000400L,0x0000000000000043L});
	public static final BitSet FOLLOW_signal_type_in_ctemplate1324 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_GT_in_ctemplate1326 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_sc_type_in_signal_type1346 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_signal_type1355 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_func_call1388 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_23_in_func_call1390 = new BitSet(new long[]{0x01E008800188A610L,0x0000000000001843L});
	public static final BitSet FOLLOW_func_arg_in_func_call1392 = new BitSet(new long[]{0x0000000005000000L});
	public static final BitSet FOLLOW_26_in_func_call1395 = new BitSet(new long[]{0x01E008800088A610L,0x0000000000001843L});
	public static final BitSet FOLLOW_func_arg_in_func_call1397 = new BitSet(new long[]{0x0000000005000000L});
	public static final BitSet FOLLOW_24_in_func_call1402 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_port_type_in_port_decl1441 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_name_in_port_decl1443 = new BitSet(new long[]{0x0000000004000002L});
	public static final BitSet FOLLOW_26_in_port_decl1446 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_name_in_port_decl1448 = new BitSet(new long[]{0x0000000004000002L});
	public static final BitSet FOLLOW_ID_in_name1481 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_sc_clock_in_port_type1495 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_sc_in_in_port_type1505 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_sc_out_in_port_type1518 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_sc_inout_in_port_type1531 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_61_in_sc_inout1552 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_ctemplate_in_sc_inout1554 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_62_in_sc_inout1569 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_63_in_sc_inout1582 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_ctemplate_in_sc_inout1584 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_66_in_sc_out1609 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_ctemplate_in_sc_out1612 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_67_in_sc_out1626 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_68_in_sc_out1639 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_ctemplate_in_sc_out1641 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_57_in_sc_in1663 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_ctemplate_in_sc_in1665 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_sc_in1679 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_60_in_sc_in1692 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_ctemplate_in_sc_in1694 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_58_in_sc_clock1716 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_block_in_func_body1729 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_80_in_block1769 = new BitSet(new long[]{0x001E048000000400L,0x000000000004E743L});
	public static final BitSet FOLLOW_variable_decl_in_block1773 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_SEMICOLON_in_block1776 = new BitSet(new long[]{0x001E048000000400L,0x000000000004E743L});
	public static final BitSet FOLLOW_sc_assignement_in_block1780 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_SEMICOLON_in_block1782 = new BitSet(new long[]{0x001E048000000400L,0x000000000004E743L});
	public static final BitSet FOLLOW_v_assignement_in_block1787 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_SEMICOLON_in_block1789 = new BitSet(new long[]{0x001E048000000400L,0x000000000004E743L});
	public static final BitSet FOLLOW_cconstruct_in_block1794 = new BitSet(new long[]{0x001E048000000400L,0x000000000004E743L});
	public static final BitSet FOLLOW_func_call_in_block1801 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_SEMICOLON_in_block1803 = new BitSet(new long[]{0x001E048000000400L,0x000000000004E743L});
	public static final BitSet FOLLOW_flux_in_block1808 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_SEMICOLON_in_block1810 = new BitSet(new long[]{0x001E048000000400L,0x000000000004E743L});
	public static final BitSet FOLLOW_82_in_block1815 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_case_construct_in_cconstruct1828 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_if_construct_in_cconstruct1842 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_while_construct_in_cconstruct1856 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_79_in_while_construct1869 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_23_in_while_construct1870 = new BitSet(new long[]{0x01E008800088A610L,0x0000000000001843L});
	public static final BitSet FOLLOW_cond_in_while_construct1871 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_24_in_while_construct1873 = new BitSet(new long[]{0x0000000000000400L,0x0000000000010000L});
	public static final BitSet FOLLOW_if_content_in_while_construct1876 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_50_in_if_construct1900 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_23_in_if_construct1901 = new BitSet(new long[]{0x01E008800088A610L,0x0000000000001843L});
	public static final BitSet FOLLOW_cond_in_if_construct1902 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_24_in_if_construct1904 = new BitSet(new long[]{0x0000000000000400L,0x0000000000010000L});
	public static final BitSet FOLLOW_if_content_in_if_construct1907 = new BitSet(new long[]{0x0000400000000002L});
	public static final BitSet FOLLOW_elsif_construct_in_if_construct1912 = new BitSet(new long[]{0x0000400000000002L});
	public static final BitSet FOLLOW_46_in_elsif_construct1955 = new BitSet(new long[]{0x0004000000000400L,0x0000000000010000L});
	public static final BitSet FOLLOW_50_in_elsif_construct1960 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_23_in_elsif_construct1961 = new BitSet(new long[]{0x01E008800088A610L,0x0000000000001843L});
	public static final BitSet FOLLOW_cond_in_elsif_construct1962 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_24_in_elsif_construct1964 = new BitSet(new long[]{0x0000000000000400L,0x0000000000010000L});
	public static final BitSet FOLLOW_if_content_in_elsif_construct1971 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_if_content_in_elsif_construct1997 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_v_assignement_in_if_content2033 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_SEMICOLON_in_if_content2036 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_block_in_if_content2043 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_test_express_in_cond2073 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_test_express2122 = new BitSet(new long[]{0x0000000000400002L,0x0000000000020000L});
	public static final BitSet FOLLOW_logic_op_in_test_express2128 = new BitSet(new long[]{0x01E008800088A610L,0x0000000000001843L});
	public static final BitSet FOLLOW_test_express_in_test_express2136 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_23_in_enclosed_expr2170 = new BitSet(new long[]{0x01E008800088A610L,0x0000000000001843L});
	public static final BitSet FOLLOW_test_express_in_enclosed_expr2177 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_24_in_enclosed_expr2181 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_expression2218 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_enclosed_expr_in_expression2222 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_test_in_expression2241 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_value_in_test2271 = new BitSet(new long[]{0x000000000000C142L});
	public static final BitSet FOLLOW_comp_op_in_test2277 = new BitSet(new long[]{0x01E008800088A610L,0x0000000000001843L});
	public static final BitSet FOLLOW_value_in_test2283 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_set_in_comp_op2324 = new BitSet(new long[]{0x0000000000000042L});
	public static final BitSet FOLLOW_EQUAL_in_comp_op2340 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_22_in_logic_op2352 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_81_in_logic_op2364 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_74_in_case_construct2391 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_23_in_case_construct2392 = new BitSet(new long[]{0x01E008800088A610L,0x0000000000001843L});
	public static final BitSet FOLLOW_value_in_case_construct2393 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_24_in_case_construct2394 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
	public static final BitSet FOLLOW_80_in_case_construct2395 = new BitSet(new long[]{0x0000120000000000L,0x0000000000040000L});
	public static final BitSet FOLLOW_case_elt_in_case_construct2399 = new BitSet(new long[]{0x0000120000000000L,0x0000000000040000L});
	public static final BitSet FOLLOW_82_in_case_construct2407 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_41_in_case_elt2447 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_ID_in_case_elt2450 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_44_in_case_elt2455 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_29_in_case_elt2458 = new BitSet(new long[]{0x0004010000000402L,0x0000000000010000L});
	public static final BitSet FOLLOW_v_assignement_in_case_elt2463 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_SEMICOLON_in_case_elt2465 = new BitSet(new long[]{0x0004010000000402L,0x0000000000010000L});
	public static final BitSet FOLLOW_sc_assignement_in_case_elt2470 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_SEMICOLON_in_case_elt2472 = new BitSet(new long[]{0x0004010000000402L,0x0000000000010000L});
	public static final BitSet FOLLOW_if_construct_in_case_elt2477 = new BitSet(new long[]{0x0004010000000402L,0x0000000000010000L});
	public static final BitSet FOLLOW_func_call_in_case_elt2483 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_SEMICOLON_in_case_elt2485 = new BitSet(new long[]{0x0004010000000402L,0x0000000000010000L});
	public static final BitSet FOLLOW_block_in_case_elt2490 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_SEMICOLON_in_case_elt2492 = new BitSet(new long[]{0x0004010000000402L,0x0000000000010000L});
	public static final BitSet FOLLOW_flux_in_case_elt2497 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_SEMICOLON_in_case_elt2499 = new BitSet(new long[]{0x0004010000000402L,0x0000000000010000L});
	public static final BitSet FOLLOW_40_in_case_elt2507 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_SEMICOLON_in_case_elt2509 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_flux2539 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_30_in_flux2540 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_ID_in_flux2543 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_31_in_flux2545 = new BitSet(new long[]{0x01E008800088A610L,0x0000000000001843L});
	public static final BitSet FOLLOW_value_in_flux2547 = new BitSet(new long[]{0x0000000080000002L});
	public static final BitSet FOLLOW_31_in_flux2550 = new BitSet(new long[]{0x01E008800088A610L,0x0000000000001843L});
	public static final BitSet FOLLOW_value_in_flux2553 = new BitSet(new long[]{0x0000000080000002L});
	public static final BitSet FOLLOW_ID_in_v_assignement2571 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_EQUAL_in_v_assignement2573 = new BitSet(new long[]{0x01E008800088A610L,0x0000000000001843L});
	public static final BitSet FOLLOW_assignement_value_in_v_assignement2575 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_sc_assignement2610 = new BitSet(new long[]{0x0000000810000000L});
	public static final BitSet FOLLOW_array_index_in_sc_assignement2613 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_28_in_sc_assignement2618 = new BitSet(new long[]{0x01E008800088A610L,0x0000000000001843L});
	public static final BitSet FOLLOW_assignement_value_in_sc_assignement2619 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_24_in_sc_assignement2620 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_value_in_assignement_value2654 = new BitSet(new long[]{0x0000000000010002L});
	public static final BitSet FOLLOW_OP_in_assignement_value2658 = new BitSet(new long[]{0x01E008800088A610L,0x0000000000001843L});
	public static final BitSet FOLLOW_value_in_assignement_value2662 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_HEX_in_value2703 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BIN_in_value2720 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_value2737 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_value2754 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_scconstructor_in_value2774 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_func_call_in_value2789 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_var_value_in_value2807 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_sc_method_in_value2825 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_sc_type_in_scconstructor2850 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_23_in_scconstructor2851 = new BitSet(new long[]{0x01E008800088A610L,0x0000000000001843L});
	public static final BitSet FOLLOW_value_in_scconstructor2852 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_24_in_scconstructor2853 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_var_value2885 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_var_name_in_var_value2891 = new BitSet(new long[]{0x0000000808000002L});
	public static final BitSet FOLLOW_var_comp_in_var_value2897 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_27_in_var_comp2937 = new BitSet(new long[]{0x01E0080000800400L,0x0000000000001800L});
	public static final BitSet FOLLOW_sc_method_in_var_comp2943 = new BitSet(new long[]{0x0000000808000002L});
	public static final BitSet FOLLOW_method_in_var_comp2953 = new BitSet(new long[]{0x0000000808000002L});
	public static final BitSet FOLLOW_array_index_in_var_comp2969 = new BitSet(new long[]{0x0000000808000002L});
	public static final BitSet FOLLOW_var_comp_in_var_comp2984 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_35_in_array_index3015 = new BitSet(new long[]{0x01E008800088A610L,0x0000000000001843L});
	public static final BitSet FOLLOW_value_in_array_index3016 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_37_in_array_index3017 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_var_name3050 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_sc_type3074 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_LT_in_sc_type3076 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_INT_in_sc_type3078 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_GT_in_sc_type3080 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_70_in_sc_type3095 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_LT_in_sc_type3098 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_INT_in_sc_type3100 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_GT_in_sc_type3102 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_sc_type3117 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_39_in_sc_type3128 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_55_in_sc_method3153 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_INT_in_sc_method3158 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_26_in_sc_method3160 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_INT_in_sc_method3166 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_24_in_sc_method3167 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_43_in_sc_method3196 = new BitSet(new long[]{0x01E008800088A610L,0x0000000000001843L});
	public static final BitSet FOLLOW_value_in_sc_method3203 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_26_in_sc_method3206 = new BitSet(new long[]{0x01E008800088A610L,0x0000000000001843L});
	public static final BitSet FOLLOW_value_in_sc_method3211 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_24_in_sc_method3213 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_56_in_sc_method3235 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_54_in_sc_method3251 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_53_in_sc_method3267 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_75_in_sc_method3283 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_76_in_sc_method3299 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_23_in_sc_method3313 = new BitSet(new long[]{0x01E008800088A610L,0x0000000000001843L});
	public static final BitSet FOLLOW_value_in_sc_method3320 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_26_in_sc_method3322 = new BitSet(new long[]{0x01E008800088A610L,0x0000000000001843L});
	public static final BitSet FOLLOW_value_in_sc_method3327 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_24_in_sc_method3328 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_synpred1_Systemc_basic2218 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_enclosed_expr_in_synpred1_Systemc_basic2222 = new BitSet(new long[]{0x0000000000000002L});
}
