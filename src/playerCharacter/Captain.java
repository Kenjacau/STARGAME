package playerCharacter;

import java.util.ArrayList;

/*
Class: Captain
Purpose: The Captain class manages the display of player information, selection of crew members, and actions related to combat.
- Author: @cdeluna, @jcbrough
- Email: cdeluna@ggc.edu, jbroughton@ggc.edu
- Version: 0.0.4
- Date: 11/5/2015  
*/
public class Captain extends Persona {

	private int[] bossesBeat;
	private ArrayList<String> crewSelection;
	private ArrayList<String> captainCrew;

	/**
	 * Method: getCrewSelection - Getter method for selecting a crew member
	 * 
	 * @return the crewSelection
	 */
	public ArrayList<String> getCrewSelection() {
		return crewSelection;
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
		return true;
	}

	/**
	 * @return true
	 */
	public boolean hasEngineerOfficer() {
		return true;
	}

	/**
	 * @return true
	 */
	public boolean hasNavigationOfficer() {
		return true;
	}

	/**
	 * @return true
	 */
	public boolean hasTacticalOfficer() {
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see controllers.Combat#attack(int, int)
	 */
	@Override
	public void attack(int attackPoints, int defensePoints) {
		// TODO Auto-generated method stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see controllers.Combat#ambush(int, int)
	 */
	@Override
	public void ambush(int attackPoints, int defensePoints) {
		// TODO Auto-generated method stub
	}


}
