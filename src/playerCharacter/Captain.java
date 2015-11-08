package playerCharacter;

import java.util.ArrayList;

/*
Class: Captain
Purpose: The Captain class manages the display of player information, selection of crew members, and actions related to combat.
- Author: @cdeluna
- Email: cdeluna@ggc.edu
- Version: 0.0.2
- Date: 11/5/2015  
*/
public class Captain extends Persona {

	private static String captainName = "";
	private static int[] bossesBeat = new int[0];
	private static String[] crewSelection = new String[6];
	private static ArrayList<String> captainCrew = new ArrayList<String>();

	/**
	 * Constructor: Captain - Creates Captain object with attributes
	 */
	public Captain() {
		// TODO Combat attributes needed
	}

	/**
	 * Method: getCaptainName - Getter method for the name of the captain
	 *
	 * @return the captainName
	 */
	public static String getCaptainName() {
		return captainName;
	}

	/**
	 * @param captainName
	 *            the captainName to set
	 */
	public static void setCaptainName(String captainName) {
		Captain.captainName = captainName;
	}

	/**
	 * Method: getCrewSelection - Getter method for selecting a crew member
	 * 
	 * @return the crewSelection
	 */
	public static String[] getCrewSelection() {
		return crewSelection;
	}

	/**
	 * Method: getCaptainCrew - Getter method for captainCrew as an ArrayList of
	 * crew members
	 * 
	 * @return the captainCrew
	 */
	public static ArrayList<String> getCaptainCrew() {
		return captainCrew;
	}

	/**
	 * @param crew
	 *            the crew to set
	 */
	public static void setCaptainCrew(ArrayList<String> crew) {
		Captain.captainCrew = crew;
	}

	/**
	 * @return true
	 */
	public static boolean hasSurveyOfficer() {
		return true;
	}

	/**
	 * @return true
	 */
	public static boolean hasEngineerOfficer() {
		return true;
	}

	/**
	 * @return true
	 */
	public static boolean hasNavigationOfficer() {
		return true;
	}

	/**
	 * @return true
	 */
	public static boolean hasTacticalOfficer() {
		return true;
	}

	/**
	 * @return void
	 */
	public void selectWithNavigationOfficer() {

	}

	/**
	 * @return void
	 */
	public void selectWithoutNavigationOfficer() {

	}

	/**
	 * @return void
	 */
	public void selectPlanet(String targetPlanet) {

	}

	/**
	 * @return null
	 */
	public Boolean requestSave() {
		return null;
	}

	/**
	 * @return null
	 */
	public Boolean fleeCombat() {
		return null;
	}

}
