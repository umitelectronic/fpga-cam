import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RuleReturnScope;
import org.antlr.stringtemplate.StringTemplateGroup;
import org.antlr.stringtemplate.language.AngleBracketTemplateLexer;

public class STTest {

	public static StringTemplateGroup templates;

	/*
	 * 
	 */
	public static void main(String[] args) throws Exception {
		String templateFileName = "/home/jpiat/workspace/SystemCToVHDL/grammar/VHDL.stg";
		templates = new StringTemplateGroup(new FileReader(templateFileName),
				AngleBracketTemplateLexer.class);
		templates.registerRenderer(String.class, VHDLRenderer.getInstance());

		String modulePath = args[0];
		CharStream input = new ANTLRFileStream(modulePath + ".h");
		Systemc_basicLexer lexer = new Systemc_basicLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		Systemc_basicParser parser = new Systemc_basicParser(tokens);
		parser.setTemplateLib(templates);
		RuleReturnScope r = parser.cfile();
		System.out.println(r.getTemplate());
		File outputTemplate = new File(modulePath + ".st");
		if (!outputTemplate.exists()) {
			outputTemplate.createNewFile();
		}
		FileOutputStream StStream = new FileOutputStream(outputTemplate);
		StStream.write(r.getTemplate().toString().getBytes());
		StStream.close();
	}
}