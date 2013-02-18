package org.laas;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.EarlyExitException;
import org.antlr.stringtemplate.StringTemplate;

public class SystemCToVHDL {

	public static void Main(String[] args) {

		try {
			// TODO: muste iterate over a directory of files

			CharStream inputStream = new ANTLRFileStream(args[0]);
			CommonTokenStream tokens = new CommonTokenStream();

			Systemc_basicLexer lexer = new Systemc_basicLexer(inputStream); // create
			// tokenizer
			tokens.setTokenSource(lexer);
			Systemc_basicParser parser = new Systemc_basicParser(tokens); // create/attach

			// parser

			StringTemplate fileDecl = (StringTemplate) parser.cfile()
					.getTemplate();
			FileWriter fileWriter;
			File printFile = new File();// TODO: must get parsed file path and
										// generate new VHDL file path
			if (!printFile.exists()) {
				printFile.createNewFile();
			}
			fileWriter = new FileWriter(printFile);
			fileWriter.write(fileDecl.toString());
			fileWriter.close();

		} catch (EarlyExitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // invoke the start rule
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
