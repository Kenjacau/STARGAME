package testers;

import obstacles.Enemy;

/**
 * Class: EnemyTester 
 * The Enemy class is a sub class of Persona that controls the creation of enemy objects. 
 * - Author: @TKeating 
 * - tkeating@ggc.edu, arcane.supernova@gmail.com 
 * - Version: 0.0.0 
 * - 11/13/2015
 */
public class EnemyClassTester extends PersonaClassTester {

	/**
	 * doesEnemyHaveDescription()
	 * 
	 * @param e
	 *            Enemy for testing.
	 * @return Flag for successful test.
	 */
	public boolean doesEnemyHaveDescription(Enemy e) {
		if (e.getEnemyDescription() == "" || e.getEnemyDescription() == null) {
			// Throw illegal arg exce
			return false;
		} else {
			return true;
		}
	}

	/**
	 * doesEnemyHaveName()
	 * 
	 * @param e
	 *            Enemy for testing
	 * @return Flag for successful test.
	 */
	public boolean doesEnemyHaveName(Enemy e) {
		if (e.getName() == "" || e.getName() == null) {
			// Throw illegal arg exce
			return false;
		} else {
			return true;
		}
	}

	/**
	 * doesEnemyHaveLocation()
	 * 
	 * @param e
	 *            Enemy for testing
	 * @return Flag for successful test.
	 */
	public boolean doesEnemyHaveLocation(Enemy e) {
		if (e.getEnemyLocation() == "" || e.getEnemyLocation() == null) {
			// thorw illegal arg exce
			return false;
		} else {
			return true;
		}
	}

	/**
	 * doesEnemyHaveAmbushStatus()
	 * 
	 * @param e
	 *            Enemy for testing
	 * @return Flag for successful test.
	 */
	public boolean doesEnemyHaveAmbushStatus(Enemy e) {
		if (e.getAmbushStatus() < 0 || e.getAmbushStatus() > 0 || e.getEnemyLocation() == null) {
			// throw illegal arg exce
			return false;
		} else {
			return true;
		}
		
	}
}