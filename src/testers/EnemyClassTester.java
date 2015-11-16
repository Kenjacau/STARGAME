package testers;

import obstacles.Enemy;
import playerCharacter.Captain;

/**
 * Class: EnemyTester 
 * The Enemy class is a sub class of Persona that controls the creation of enemy objects. 
 * - Author: @TKeating 
 * - tkeating@ggc.edu, arcane.supernova@gmail.com 
 * - Version: 0.0.0 
 * - 11/13/2015
 */
public class EnemyClassTester extends PersonaClassTester {
	private Enemy enemy; 
	
	/**EnemyClassTester
	 * CONSTRUCTOR
	 * 
	 * @param _enemy The enemy to be tested. 
	 * 
	 * @author jcbrough
	 */
	public EnemyClassTester(Enemy _enemy) {
		this.enemy = _enemy; 
	}
	
	
	/**
	 * doesEnemyHaveDescription()
	 * 
	 * @param e Enemy for testing.
	 * @return Flag for successful test.
	 * 
	 * @author jcbrough, Travis
	 */
	public boolean doesEnemyHaveDescription(Enemy e) {
		if (e.getEnemyDescription() == "" || e.getEnemyDescription() == null) {
			throw new IllegalArgumentException("Enemy description was null or empty.");		
		} else {
			return true;
		}
	}

	/**
	 * doesEnemyHaveName()
	 * 
	 * @param e Enemy for testing
	 * @return Flag for successful test.
	 * 
	 * @author jcbrough, Travis
	 */
	public boolean doesEnemyHaveName(Enemy e) {
		if (e.getName() == "" || e.getName() == null) {
			throw new IllegalArgumentException("Enemy name was null or empty.");		
		} else {
			return true;
		}
	}

	/**
	 * doesEnemyHaveLocation()
	 * 
	 * @param e Enemy for testing
	 * @return Flag for successful test.
	 * 
	 * @author jcbrough, Travis
	 */
	public boolean doesEnemyHaveLocation(Enemy e) {
		if (e.getEnemyLocation() == "" || e.getEnemyLocation() == null) {
			throw new IllegalArgumentException("Enemy location was null or empty.");		
		} else {
			return true;
		}
	}

	/**
	 * doesEnemyHaveAmbushStatus()
	 * 
	 * @param e Enemy for testing
	 * @return Flag for successful test.
	 * @author jcbrough, Travis
	 */
	public boolean doesEnemyHaveAmbushStatus(Enemy e) {
		if (e.getAmbushStatus() < 0 || e.getAmbushStatus() > 0 || e.getEnemyLocation() == null) {
			throw new IllegalArgumentException("Enemy ambush status was null or empty.");		
		} else {
			return true;
		}
		
	}
}