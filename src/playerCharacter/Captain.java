package playerCharacter;

import java.util.ArrayList;

/**
Class: Captain
Purpose: The Captain class manages the display of player information, selection of crew members, and actions related to combat.
- Author: @cdeluna, @jbroughton
- Email: cdeluna@ggc.edu, jbroughton@ggc.edu
- Version: 0.0.5
- Date: 2015-11-05 
**/
public class Captain extends Persona {

	private int[] bossesBeat;
	private static ArrayList<String> crewSelection;
	private static ArrayList<String> captainCrew;

	/**
	 * Method: getCrewSelection - Getter method for selecting a crew member
	 * 
	 * @return the crewSelection
	 */
	public static ArrayList<String> getCrewSelection() {
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
	 * @param captainCrew
	 *            the captainCrew to set
	 */
	public static void setCaptainCrew(ArrayList<String> captainCrew) {
		Captain.captainCrew = captainCrew;
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
