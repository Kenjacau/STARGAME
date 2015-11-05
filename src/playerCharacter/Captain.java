package playerCharacter;
/*
Class: Captain
TODO: Write class definition here.
- Author: @CdLuna
- TODO: Write your email address here.
- Version: 0.0.0
- TODO: Date goes here.    
*/
public class Captain {
	
	private static String captainName = "";
	private static String[] captainCrew = new String[3];
	
	
	/**
	 * @return the captainName
	 */
	public static String getCaptainName() {
		return captainName;
	}

	/**
	 * @param playerName the captainName to set
	 */
	public static void setCaptainName(String captainName) {
		Captain.captainName = captainName;
	}
	
	/**
	 * @param crew the crew to set
	 */
	public static void setCrew (String[] crew) {
		Captain.captainCrew = crew; 
	}

	public static boolean hasNavigationOfficer() {
		return true; 
	}
}
