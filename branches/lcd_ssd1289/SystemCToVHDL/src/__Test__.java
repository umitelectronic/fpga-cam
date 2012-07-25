import java.io.FileReader;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.stringtemplate.StringTemplateGroup;
import org.antlr.stringtemplate.language.AngleBracketTemplateLexer;

public class __Test__ {

	public static StringTemplateGroup templates;

	public static void main(String args[]) throws Exception {

		String templateFileName = "/home/jpiat/workspace/SystemCToVHDL/grammar/VHDL.stg";
		templates = new StringTemplateGroup(new FileReader(templateFileName),
				AngleBracketTemplateLexer.class);
		templates.registerRenderer(String.class, new UpperCaseRenderer());
		Systemc_basicLexer lex = new Systemc_basicLexer(new ANTLRFileStream(
				"/home/jpiat/workspace/SystemCToVHDL/src/__Test___input.txt",
				"UTF8"));
		CommonTokenStream tokens = new CommonTokenStream(lex);

		Systemc_basicParser g = new Systemc_basicParser(tokens, 49105, null);
		g.setTemplateLib(templates);
		try {
			g.cfile();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
	}
}