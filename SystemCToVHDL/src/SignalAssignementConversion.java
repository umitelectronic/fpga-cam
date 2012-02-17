import java.util.HashMap;
import java.util.List;

public class SignalAssignementConversion {

	public HashMap<String, VHDLSignalTypes> signal_to_type;

	public static SignalAssignementConversion instance;

	private SignalAssignementConversion() {
		signal_to_type = new HashMap<String, VHDLSignalTypes>();
	}

	public static SignalAssignementConversion getInstance() {
		if (instance == null) {
			instance = new SignalAssignementConversion();
		}
		return instance;
	}

	public void registerType(String name, String type) {
		signal_to_type.put(name, VHDLSignalTypes.fromString(type));
	}

	public void registerType(List<?> names, String type) {
		for (String varName : ((List<String>) names)) {
			signal_to_type.put(varName, VHDLSignalTypes.fromString(type));
		}
	}

	public String getAssignementValue(String varName, String assignement) {
		if (signal_to_type.get(varName) != null) {
			switch (signal_to_type.get(varName)) {
			case std_logic_vector:
				if (assignement.trim().equals("0")) {
					return "(others => '0')";
				} else if (isInteger(assignement.trim())) {
					return "\""
							+ Integer.toBinaryString(Integer.decode(assignement
									.trim())) + "\"";
				} else {
					return assignement;
				}
			case std_logic:
				if (assignement.trim().equals("0")) {
					return "'0'";
				} else if (assignement.trim().equals("1")) {
					return "'1'";
				} else {
					return assignement;
				}
			default:
				return assignement;
			}
		}
		return null;
	}

	private boolean isInteger(String val) {
		try {
			Integer.decode(val);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
