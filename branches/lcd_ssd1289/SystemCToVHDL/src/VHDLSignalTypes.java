enum VHDLSignalTypes {
	std_logic, std_logic_vector, custom;

	public static VHDLSignalTypes fromString(String val) {
		if (val.contains(std_logic_vector.toString())) {
			return VHDLSignalTypes.std_logic_vector;
		} else if (val.contains(std_logic.toString())) {
			return VHDLSignalTypes.std_logic;
		} else {
			return VHDLSignalTypes.custom;
		}
	}
}
