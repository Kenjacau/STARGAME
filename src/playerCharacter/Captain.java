package playerCharacter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import controllers.GameController2;
import obstacles.Planet;

/**
 * Class: Captain
 * Purpose: The Captain class manages the display of player information, selection of crew members, and actions related to combat.
 * - Author: @cdeluna, @jcbrough, @kcauthen
 * - Email: cdeluna@ggc.edu, jbroughton@ggc.edu, kcauthen@ggc.edu
 * - Version: 0.0.9
 * - Date: 2015-11-05
 **/
@SuppressWarnings("serial") //Always compatable. Stop fooling.
public class Captain extends Persona implements Serializable {
	private static final int HEALTH_POINTS = 100;
	private static final int ATTACK_POINTS = 25;
	private static final int DEFENSE_POINTS = 0;
	private static final int SENTINEL_BOT_BONUS = 5;
	private static final int SECURITY_OFFICER_BONUS = 40;
	private ArrayList<String> captainCrew = new ArrayList<String>();
	private Planet currentPlanet = null;
	private int planetCount = 0;

	/**
	 * Method: Captain - No-arg constructor that sets default attributes to Captain
	 */
	public Captain() {
		super();
		this.setHealthPoints(HEALTH_POINTS);
		this.setAttackPoints(ATTACK_POINTS);
		this.setDefensePoints(DEFENSE_POINTS);
	}

	/**
	 * Method: getAttributesToCrew - Sets attributes from selected crew member to Captain
	 */
	public void getAttributesFromCrew() {
		for (String s : captainCrew) {
			switch (s) {
				case "Sentinel Bot":
					setDefensePoints(SENTINEL_BOT_BONUS);
					break;
				case "Security Officer":
					setAttackPoints(SECURITY_OFFICER_BONUS);
					break;
			}
		}
	}

	/**
	 * getFullCrewList
	 * Gets a full list of all possible crew choices.
	 *
	 * @return fullCrewList All possible crew members.
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


	/**
	 * Method:confirmList()
	 * Description:
	 * author: Kenny
	 */
	public boolean confirmList(ArrayList<String> selectedCrew) {
		int count = 0;
		ArrayList<String> cc = getFullCrewList();
		for (String sC : selectedCrew) {
			for (String s : cc) {
				if (removeNonWords(sC).equals(removeNonWords(s))) {
					count++;
				}
			}
		}
		return count == 3;
	}

	/**
	 * confirmCrew
	 * Gets a full list of all possible crew choices.
	 *
	 * @param selectedCrew An ArrayList of selected crewmenbers.
	 * @return Boolean flag for correct crew list.
	 * @author jcbrough, Kenny
	 */
	public boolean confirmCrew(ArrayList<String> selectedCrew) {
		boolean confirmed = true;
		headerPrint();
		if (!confirmList(selectedCrew)) {
			confirmed = false;
		} else {
			System.out.println("Captain! Is your crew selection correct?");
			for (String s : selectedCrew) {
				System.out.println("		" + s);
			}
			System.out.println("\n");
			System.out.println("Please enter [y]es or [n]o!");

			@SuppressWarnings("resource") Scanner in = new Scanner(System.in);
			String response = in.nextLine();
			if (!response.toLowerCase().equals("y")) {
				confirmed = false;
			}
		}
		return confirmed;
	}
	
//	public boolean confirmCrew(ArrayList<String> selectedCrew) {
//	boolean crewSelectionNotComplete = true;
//	while (crewSelectionNotComplete) {
//		headerPrint(); 
//		System.out.println("Captain! Is your crew selection correct?");
//		for (String s : selectedCrew) {
//			System.out.println("		" + s);
//			}
//		System.out.println("\n");
//		System.out.println("Please enter [y]es or [n]o!");
//		nl(1);
//		for (captain.getCaptainCrew() : captain.getFullCrewList()) {
//			if (userInput.contains(removeNonWords(selectedCrew.getCaptainCrew()))) {
//				captainCrew = selectedCrew;
//				selectedCrew.setPlanetExplored(true);
//				System.out.println("Thank you, Captain!");
//				System.out.println("You have chosen to go to " + selectedPlanet.getPlanetName()
//						+ "! BOLDLY GOING NOW, CAPTAIN!!!");
//				crewSelectionNotComplete = false;
//				confirmCrew();
//			} else if (planetChoices.indexOf(selectedPlanet) < planetChoices.size() - 1) {
//				// continues loop until planetSelectionNotComplete == false
//			} else {
//				nl(1);
//				headerPrint();
//				System.out.println("Captain, the input \"" + userInput + "\" is garbage!!! You are a crazy person!");
//				System.out.println("Let's try that again!");
//				nl(1);
//				headerPrint();
//				nl(1);
//				// continues loop until planetSelectionNotComplete == false
//			}
//		}
//	}
//}

	/**
	 * printAllAttributes
	 * Prints all the captain's attributes!
	 *
	 * @author cdeluna, jcbrough
	 */
	public void printAllAttributes() {
		System.out.println("Here are your stats, Captain!");
		nl(1);
		System.out.println("Current Health: " + getHealthPoints());
		System.out.println("Current Attack: " + getAttackPoints());
		System.out.println("Current Defense: " + getDefensePoints());
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
	 * @param newCaptainCrew the captainCrew to set
	 */
	public void setCaptainCrew(ArrayList<String> newCaptainCrew) {
		captainCrew = newCaptainCrew;
	}

	/**
	 * @return hasCrew
	 */
	public boolean hasSurveyOfficer() {
		return hasCrew("Survey Officer");
	}

	/**
	 * @return hasCrew
	 * author: Kenny
	 */
	public boolean hasEngineerOfficer() {
		return hasCrew("Engineer Officer");
	}

	/**
	 * @return hasCrew
	 */
	public boolean hasNavigationOfficer() {
		return hasCrew("Navigation Officer");
	}

	/**
	 * @return hasCrew
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

	/**
	 * Method: removeNonWords
	 * Description: replaces non-words
	 *
	 * @param string
	 * @author kenny
	 */
	public String removeNonWords(String string) {
		return (string.replaceAll("[^\\p{L}\\p{Nd}]+", "")).toLowerCase();
	}

	/**
	 * @return the currentPlanet
	 */
	public Planet getCurrentPlanet() {
		return currentPlanet;
	}

	/**
	 * @param currentPlanet the currentPlanet to set
	 */
	public void setCurrentPlanet(Planet currentPlanet) {
		this.currentPlanet = currentPlanet;
	}

	public int getPlanetCount() {
		return planetCount;
	}

	public void setPlanetCount(int planetCount) {
		this.planetCount = planetCount;
	}

}
