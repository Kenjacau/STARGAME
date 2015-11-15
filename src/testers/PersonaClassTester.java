package testers;

import playerCharacter.Persona;

/**
Class: PersonaClassTester
Purpose: The PersonaClassTester tests the Persona objects.
- Author: @cdeluna
- Email: cdeluna@ggc.edu
- Version: 0.0.2
- Date: 2015-11-13
**/
public class PersonaClassTester {
	
	/**
	 * hasName - Tests to see if player name is null.
	 * 
	 * @param user
	 * @return true
	 */
	public boolean hasName(Persona user) {
		if (user.getName() == null) {
			throw new IllegalArgumentException("Player name is null.");
		}
		else {
		return true;
		}
	}
	
	/**
	 * hasHealthPoints - Tests to see if zero health points equals incapacitated state.
	 * 
	 * @param user
	 * @return true
	 */
	public boolean hasHealthPoints(Persona user) {
		if (user.getHealthPoints() == 0) {
			throw new IllegalArgumentException("You're dead!");
		}
		else {
		return true;
		}
	}
	
	/**
	 * hasAttackPoints - Tests to see if a certain amount of attack points equals the ability to attack.
	 * 
	 * @param user
	 * @return true
	 */
	public boolean hasAttackPoints(Persona user) {
		if (user.getAttackPoints() == 5) {
			throw new IllegalArgumentException("Attack!");
		}
		else {
		return true;
		}
	}
	
	/**
	 * hasDefensePoints - Tests to see if a certain amount of defense points equals the ability to defend.
	 * 
	 * @param user
	 * @return true
	 */
	public boolean hasDefensePoints(Persona user) {
		if (user.getDefensePoints() == 5) {
			throw new IllegalArgumentException("Defend!");
		}
		else {
		return true;
		}
		
	}
}