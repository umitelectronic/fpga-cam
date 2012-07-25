enum SystemCSignalTypes {
	bool, sc_logic, sc_resolved, sc_lv, custom;

	public static SystemCSignalTypes fromString(String val) {
		if (val.equals(bool)) {
			return SystemCSignalTypes.bool;
		} else if (val.equals(sc_logic)) {
			return SystemCSignalTypes.sc_logic;
		} else if (val.equals(sc_resolved)) {
			return SystemCSignalTypes.sc_resolved;
		} else if (val.equals(sc_lv)) {
			return SystemCSignalTypes.sc_lv;
		} else {
			return SystemCSignalTypes.custom;
		}
	}
}
