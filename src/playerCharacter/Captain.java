package playerCharacter;

import java.util.ArrayList;
import java.util.Scanner;
import controllers.GameController2;

/**
Class: Captain
Purpose: The Captain class manages the display of player information, selection of crew members, and actions related to combat.
- Author: @cdeluna, @jcbrough
- Email: cdeluna@ggc.edu, jbroughton@ggc.edu
- Version: 0.0.6
- Date: 2015-11-05 
**/
public class Captain extends Persona {

	private int[] bossesBeat;
	private static ArrayList<String> crewSelection = new ArrayList<String>();
	private static ArrayList<String> captainCrew = new ArrayList<String>();

	/**getFullCrewList
	 * Gets a full list of all possible crew choices. 
	 * 
	 * @return fullCrewList All possible crew members. 
	 * 
	 * @author jcbrough
	 */
	public ArrayList<String> getFullCrewList() {
		ArrayList<String> fullCrewList = new ArrayList<String>();
		fullCrewList.add("Navigation Officer"); 
		fullCrewList.add("Security Officer");
		fullCrewList.add("Tactical Officer");
		fullCrewList.add("Survey Officer");
		fullCrewList.add("Sentinel Bot");
		fullCrewList.add("Engineer");
		
		return fullCrewList;
	}
	
	/**confirmCrew
	 * Gets a full list of all possible crew choices. 
	 * 
	 * @param selectedCrew An ArrayList of selected crewmenbers. 
	 * 
	 * @return Boolean flag for correct crew list. 
	 * 
	 * @author jcbrough
	 */
	public boolean confirmCrew(ArrayList<String> selectedCrew) {
		headerPrint(); 
		System.out.println("Captain! Is your crew selection correct?");
		for (String s : selectedCrew) {
			System.out.println("		" + s);
		}
		System.out.println("\n");
		System.out.println("Please enter (y)es or (n)o!");
		
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in); 
		String response = in.nextLine(); 
		if (response.toLowerCase().equals("y")) {
			return true; 
		}
		else {
			return false; 
		}
	}
	
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
	public void setCaptainCrew(ArrayList<String> captainCrew) {
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
	
	/**
	 * Method: headerPrint()
	 * Prints a header thingy. 
	 * 
	 * @return void
	 * @author kenny
	 */
	public void headerPrint() {
		nl(1);
		System.out.println("==================================================================");
		nl(1);
	}
	
	/**
	 * Method: nl()
	 * Description: goes to next line @param number of times.
	 *
	 * @param numberOfNextLines
	 * @author kenny
	 */
	public void nl(int numberOfNextLines) {
		for (int i = 0; i < numberOfNextLines; i++) {
			System.out.println();
		}
	}

}
