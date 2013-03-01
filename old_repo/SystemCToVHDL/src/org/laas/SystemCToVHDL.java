package org.laas;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.filechooser.FileNameExtensionFilter;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.EarlyExitException;
import org.antlr.stringtemplate.StringTemplate;
import org.antlr.stringtemplate.StringTemplateGroup;

public class SystemCToVHDL {

	public static void parseOneFile(File f) {
		try {
			String filePath = f.getAbsolutePath();
			String newPath = filePath.substring(0, filePath.lastIndexOf('.'))
					+ ".vhd";
			CharStream inputStream = new ANTLRFileStream(filePath);
			CommonTokenStream tokens = new CommonTokenStream();

			Systemc_basicLexer lexer = new Systemc_basicLexer(inputStream); // create
			// tokenizer
			tokens.setTokenSource(lexer);
			Systemc_basicParser parser = new Systemc_basicParser(tokens); // create/attach
			StringTemplateGroup group = new StringTemplateGroup(
					new FileReader(
							"/home/jpiat/development/FPGA/fpga-cam/old_repo/SystemCToVHDL/grammar/VHDL.stg"));
			parser.setTemplateLib(group);
			// parser

			StringTemplate fileDecl = (StringTemplate) parser.cfile()
					.getTemplate();
			FileWriter fileWriter;
			File printFile = new File(newPath);// TODO: must get parsed file
												// path
												// and
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

	public static void main(String[] args) {
		File dir = new File(args[0]);
		File listDir[] = dir.listFiles();
		for (int i = 0; i < listDir.length; i++) {
			String fileName = listDir[i].getName();
			String extension = null;
			int dotIndex = fileName.lastIndexOf('.');
			int p = Math.max(fileName.lastIndexOf('/'),
					fileName.lastIndexOf('\\'));
			if (dotIndex > p) {
				extension = fileName.substring(i + 1);
			}
			if (!listDir[i].isDirectory() && extension != null
					&& extension.equals("cpp")) {
				System.out.println(listDir[i].getName());
				parseOneFile(listDir[i]);
			}
		}

	}
}
