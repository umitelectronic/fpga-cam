import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

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
		String outputPath = args[1];
		File moduleFile = new File(modulePath);
		List<String> modules = new ArrayList<String>();
		if (moduleFile.isDirectory()) {
			for (File child : moduleFile.listFiles()) {
				if (child.getName().endsWith(".cpp")) {
					modules.add(child.getAbsolutePath());
				}
			}
		} else if (moduleFile.exists()) {
			modules.add(modulePath);
		} else {
			System.out.println("Module " + modulePath + " does not exists");
			return;
		}
		for (String cModulePath : modules) {
			try {
				System.out.println("Processing file "+cModulePath);
				String moduleName = cModulePath.substring(cModulePath
						.lastIndexOf(File.separator));
				moduleName = moduleName.substring(0, moduleName.lastIndexOf('.'));
				CharStream input = new ANTLRFileStream(cModulePath);
				Systemc_basicLexer lexer = new Systemc_basicLexer(input);
				CommonTokenStream tokens = new CommonTokenStream(lexer);
				Systemc_basicParser parser = new Systemc_basicParser(tokens);
				parser.setTemplateLib(templates);
				RuleReturnScope r = parser.cfile();
				System.out.println(r.getTemplate());
				File outputFile = new File(outputPath + moduleName + ".vhd");
				if (!outputFile.exists()) {
					outputFile.createNewFile();
				}
				FileOutputStream StStream = new FileOutputStream(outputFile);
				StStream.write(r.getTemplate().toString().getBytes());
				StStream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}