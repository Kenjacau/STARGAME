package testers;

import playerCharacter.Captain;
import playerCharacter.Persona;

/**
Class: PersonaClassTester
Purpose: The PersonaClassTester tests the Persona objects.
- Author: @cdeluna
- Email: cdeluna@ggc.edu
- Version: 0.0.3
- Date: 2015-11-13
**/
public class PersonaClassTester {
	private Persona persona;
	
	/**
	 * PersonaClassTester - Constructor
	 * 
	 * @param _persona
	 */
	public PersonaClassTester(Persona _persona) {
		this.persona = _persona; 
	}
	
	/**
	 * hasName - Tests to see if player name was null
	 * 
	 * @param user
	 * @return true
	 */
	public boolean hasName(Persona user) {
		if (user.getName() == null) {
			throw new IllegalArgumentException("Player name was null.");
		} else {
		return true;
		}
	}
	
	/**
	 * hasHealthPoints - Tests to see if health points was null
	 * 
	 * @param user
	 * @return true
	 */
	public boolean hasHealthPoints(Persona user) {
		if (user.getHealthPoints() < 0) {
			throw new IllegalArgumentException("Health points was null.");
		} else {
		return true;
		}
	}
	
	/**
	 * hasAttackPoints - Tests to see if attack points was null
	 * 
	 * @param user
	 * @return true
	 */
	public boolean hasAttackPoints(Persona user) {
		if (user.getAttackPoints() < 0) {
			throw new IllegalArgumentException("Attack points was null.");
		} else {
		return true;
		}
	}
	
	/**
	 * hasDefensePoints - Tests to see if defense points was null
	 * 
	 * @param user
	 * @return true
	 */
	public boolean hasDefensePoints(Persona user) {
		if (user.getDefensePoints() < 0) {
			throw new IllegalArgumentException("Defense points was null.");
		} else {
		return true;
		}
	}
	
}