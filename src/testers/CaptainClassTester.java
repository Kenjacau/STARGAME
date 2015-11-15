package testers;

import java.util.ArrayList;

import playerCharacter.Captain;

/**
Class: CaptainClassTester 
Purpose: The CaptainClassTester tests the Captain object.
- Author: @cdeluna, @jcbrough
- Email: cdeluna@ggc.edu, jbroughton@ggc.edu
- Version: 0.0.3
- Date: 2015-11-13
**/
public class CaptainClassTester {
//	String[] captainSelectionArray = {"Crew Test 1", "Crew Test 2", "Crew Test 3"};
//	String[] captainCrewArray = {"Crew Test 1", "Crew Test 2"};

	/**
	 * hasCrewSelection - Tests to see if crew selection is null.
	 * 
	 * @return true
	 */
	public boolean hasCrewSelection() {
		if (Captain.getCrewSelection() == null) {
			throw new IllegalArgumentException("Crew selection is null.");
		} else {
			return true;
		}
	}
	
	/**
	 * hasCaptainCrew - Tests to see if captain crew is null.
	 * 
	 * @return true
	 */
	public boolean hasCaptainCrew() {
		if (Captain.getCaptainCrew() == null) {
			throw new IllegalArgumentException("Captain crew is null.");
		} else {
			return true;
		}
		
	}
	
	/**doesPlayerHaveFullCrew
	 * Makes sure the captain has three crew members. 
	 * 
	 * @param selectedCrew An ArrayList of selected crewmenbers. 
	 * 
	 * @return Boolean flag for correct crew list. 
	 * 
	 * @author jcbrough
	 */
	public boolean doesPlayerHaveFullCrew(ArrayList<String> selectedCrew) {
		if (selectedCrew.size() != 3) {
			return false;
		}
		else {
			return true;
		}
	}
}