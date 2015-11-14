package testers;

import controllers.Dice;

/**
Class: DiceTester
The DiceTester tests the Dice object.
- Author: @jbroughton
- joshua.c.broughton@gmail.com, jbroughton@ggc.edu
- Version: 0.0.0
- 2015-11-03    
*/
public class DiceTester {
	
	/**hasModifier()
	 * Tests to see if the dice has a correct modifier. 
	 * @param d A dice object.
	 * @return Flag for a passing test. 
	 */
	public boolean hasModifier(Dice d) {
		if (d.getModifier() <= 0) {
			return false;
		}
		else {
			return true; 
		}
	}
}
