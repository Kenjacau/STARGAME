package playerCharacter;

import java.util.ArrayList;
import java.util.Scanner;
import controllers.GameController2;

/**
Class: Captain
Purpose: The Captain class manages the display of player information, selection of crew members, and actions related to combat.
 - Author: @cdeluna, @jcbrough, @kcauthen
- Email: cdeluna@ggc.edu, jbroughton@ggc.edu, kcauthen@ggc.edu
- Version: 0.0.7
- Date: 2015-11-05 
**/
public class Captain extends Persona {
	private ArrayList<String> captainCrew = new ArrayList<String>();
	
	/**
	 * Method: Captain - No-arg constructor that sets default attributes to Captain
	 * 
	 */
	public Captain() {
		super();
		this.setHealthPoints(100); //Subject to change
		this.setAttackPoints(20); //Subject to change
		this.setDefensePoints(20); //Subject to change
	}
	
	/**
	 * Method: getAttributesToCrew - Sets attributes from selected crew member to Captain
	 * 
	 */
	public void getAttributesToCrew() {
		for (String s : captainCrew) {
			switch(s) {
			case "Tactical Officer": //Subject to change
				setHealthPoints(150); //Subject to change
				break;
			case "Sentinel Bot": //Subject to change
				setAttackPoints(40); //Subject to change
				break;
			case "Security Officer": //Subject to change
				setDefensePoints(40); //Subject to change
				break;
			}
		}
	}

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
		fullCrewList.add("Engineer Officer");
		
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
		System.out.println("Please enter [yes] or [no]!");
		
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
	 * Method: getCaptainCrew - Getter method for captainCrew as an ArrayList of
	 * crew members
	 * 
	 * @return the captainCrew
	 */
	public ArrayList<String> getCaptainCrew() {
		return captainCrew;
	}

	/**
	 * @param newCaptainCrew
	 *            the captainCrew to set
	 */
	public void setCaptainCrew(ArrayList<String> newCaptainCrew) {
		captainCrew = newCaptainCrew;
	}

	/**
	 * @return true
	 */
	public boolean hasSurveyOfficer() {

		return hasCrew("Survey Officer");
	}

	/**
	 * @return true
	 * author: Kenny
	 */
	public boolean hasEngineerOfficer() {

		return hasCrew("Engineer Officer");
	}

	/**
	 * @return true
	 */
	public boolean hasNavigationOfficer() {
		return hasCrew("Navigation Officer");
	}

	/**
	 * @return true
	 */
	public boolean hasTacticalOfficer() {
		return hasCrew("Tactical Officer");
	}

	/**
	 * @return boolean
	 * author: Kenny
	 */
	public boolean hasCrew(String crewName) {
		boolean crewMember = false;
		for (String s : captainCrew) {
			if (removeNonWords(s).contains(removeNonWords(crewName))) {
				crewMember = true;
			}
		}
		return crewMember;
	}


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

	public String removeNonWords(String string) {
		return (string.replaceAll("[^\\p{L}\\p{Nd}]+", "")).toLowerCase();
	}

}
