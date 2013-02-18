package org.laas;

import java.util.ArrayList;
import java.util.List;

public class SignalAssignementConversion {

	private static SignalAssignementConversion instance = null;

	List<String> typeNames = null;

	public static SignalAssignementConversion getInstance() {
		if (instance == null) {
			instance = new SignalAssignementConversion();
		}
		return instance;
	}

	private SignalAssignementConversion() {
		typeNames = new ArrayList<String>();
	}

	public String getAssignementValue(String text, String text2) {
		return "";
	}

	public void registerType(List names, String string) {
		// TODO Auto-generated method stub
	}

}
