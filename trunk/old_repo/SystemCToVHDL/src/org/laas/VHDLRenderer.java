package org.laas;

import org.antlr.stringtemplate.AttributeRenderer;

public class VHDLRenderer implements AttributeRenderer {

	public String toString(Object o) {
		return o.toString();
	}

	public String toString(Object o, String formatName) {
		if (formatName.equals("toUpper")) {
			return o.toString().toUpperCase();
		} else if (formatName.equals("toLower")) {
			return o.toString().toLowerCase();
		} else {
			throw new IllegalArgumentException("Unsupported format name");
		}
	}

}
