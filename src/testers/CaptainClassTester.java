package testers;

import java.util.ArrayList;
import controllers.Game;
import playerCharacter.Captain;

/**
Class: CaptainClassTester 
Purpose: The CaptainClassTester tests the Captain object.
- Author: @cdeluna, @jcbrough
- Email: cdeluna@ggc.edu, jbroughton@ggc.edu
- Version: 0.0.6
- Date: 2015-11-13
**/
public class CaptainClassTester {
	private Captain captain; 

	/**CaptainClassTester
	 * CONSTRUCTOR
	 * 
	 * @param _captain The captain to be tested. 
	 * 
	 * @author jcbrough
	 */
	public CaptainClassTester(Captain _captain) {
		this.captain = _captain; 
	}
	
	/**
	 * hasCaptainCrew - Tests to see if captain crew is null.
	 * 
	 * @return true
	 */
	public boolean hasCaptainCrew() {
		if (captain.getCaptainCrew() == null) {
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
