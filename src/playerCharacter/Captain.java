package playerCharacter;

import java.util.ArrayList;

/*
Class: Captain
Purpose: The Captain class manages the display of player information, selection of crew members, and actions related to combat.
- Author: @cdeluna
- Email: cdeluna@ggc.edu
- Version: 0.0.1
- Date: 11/5/2015  
*/
public class Captain {

	private static String captainName = "";
	private static int[] bossesBeat = new int[0];
	private static String[] crewSelection = new String[6];
	private static ArrayList<String> captainCrew = new ArrayList<String>();

	/**
	 * @return the captainName
	 */
	public static String getCaptainName() {
		return captainName;
	}

	/**
	 * @param playerName
	 *            the captainName to set
	 */
	public static void setCaptainName(String captainName) {
		Captain.captainName = captainName;
	}

	/**
	 * @return the crewSelection
	 */
	public static String[] getCrewSelection() {
		return crewSelection;
	}

	/**
	 * @param selection
	 *            the selection to set
	 */
	public static void setCrewSelection(String[] selection) {
		Captain.crewSelection = selection;
	}

	/**
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

	public static boolean hasSurveyOfficer() {
		return true;
	}

	public static boolean hasEngineerOfficer() {
		return true;
	}

	public static boolean hasNavigationOfficer() {
		return true;
	}

	public static boolean hasTacticalOfficer() {
		return true;
	}

	public void selectWithNavigationOfficer() {

	}

	public void selectWithoutNavigationOfficer() {

	}

	public void selectPlanet(String targetPlanet) {

	}

	public Boolean requestSave() {
		return null;
	}

	public Boolean fleeCombat() {
		return null;
	}

}
