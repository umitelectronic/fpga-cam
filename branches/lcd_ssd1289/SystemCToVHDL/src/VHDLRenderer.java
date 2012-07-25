import java.util.HashMap;

import org.antlr.stringtemplate.AttributeRenderer;

public class VHDLRenderer implements AttributeRenderer {

	private static VHDLRenderer instance;

	private HashMap<String, SystemCSignalTypes> nameToType;

	private VHDLRenderer() {
		nameToType = new HashMap<String, SystemCSignalTypes>();
	}

	public void addSignal(String name, SystemCSignalTypes type) {
		nameToType.put(name, type);
	}

	public static VHDLRenderer getInstance() {
		if (instance == null) {
			instance = new VHDLRenderer();
		}
		return instance;
	}

	public String toString(Object o) {
		return o.toString();
	}

	public String toString(Object o, String formatName) {
		if (formatName.equals("toUpper")) {
			return o.toString().toUpperCase();
		} else if (formatName.equals("toLower")) {
			return o.toString().toLowerCase();
		} else if (formatName.equals("toVHDL")) {
			String withoutSpaces = ((String) o).trim();
			if (withoutSpaces.equals("==")) {
				return "=";
			} else if (withoutSpaces.equals("!=")) {
				return "/=";
			} else if (withoutSpaces.equals("SC_LOGIC_0")) {
				return "'0'";
			} else if (withoutSpaces.equals("SC_LOGIC_1")) {
				return "'1'";
			} else if (withoutSpaces.equals("SC_LOGIC_Z")) {
				return "'Z'";
			} else if (withoutSpaces.equals("SC_LOGIC_X")) {
				return "'X'";
			} else {
				return withoutSpaces;
			}
		} else if (formatName.equals("decrement")) {
			String withoutSpaces = ((String) o).trim();
			try{
				Integer val = Integer.decode(withoutSpaces);
				val -= 1 ;
				return val.toString();
			}catch(Exception e){
				return withoutSpaces+" -1";
			}
		}else {
			throw new IllegalArgumentException("Unsupported format name");
		}
	}

}
