package testers;

import playerCharacter.Captain;

/**
Class: CaptainClassTester 
Purpose: The CaptainClassTester tests the Captain object.
- Author: @cdeluna 
- Email: cdeluna@ggc.edu 
- Version: 0.0.2
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
}