import java.io.*;

import org.antlr.runtime.*;
import org.antlr.runtime.debug.DebugEventSocketProxy;
import org.antlr.stringtemplate.StringTemplateGroup;
import org.antlr.stringtemplate.language.AngleBracketTemplateLexer;


public class __Test__template {

	
	public static StringTemplateGroup templates;
	
	
    public static void main(String args[]) throws Exception {
    	
    	String templateFileName = "/home/jpiat/workspace/SystemCToVHDL/grammar/VHDL.stg";
		templates = new StringTemplateGroup(new FileReader(templateFileName),
				AngleBracketTemplateLexer.class);
		templates.registerRenderer(String.class,VHDLRenderer.getInstance());
        Systemc_basicLexer lex = new Systemc_basicLexer(new ANTLRFileStream("/home/jpiat/workspace/SystemCToVHDL/src/__Test___input.txt", "UTF8"));
        CommonTokenStream tokens = new CommonTokenStream(lex);

        Systemc_basicParser g = new Systemc_basicParser(tokens, 49105, null);
        g.setTemplateLib(templates);
        try {
        	 RuleReturnScope r = g.cfile();
    		System.out.println(r.getTemplate());
        } catch (RecognitionException e) {
            e.printStackTrace();
        }
    }
}