package playerCharacter;

import java.util.ArrayList;

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
	private static ArrayList<String> captainCrew = new ArrayList<String>(); 
	  
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
	public static void setCrew (ArrayList<String> crew) {
		Captain.captainCrew = crew; 
	}

	public static boolean hasNavigationOfficer() {
		return true; 
	}
}
