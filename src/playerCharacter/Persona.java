package playerCharacter;

import controllers.Combat;

/*
Class: Persona
Purpose: The Persona class stores attributes, which gets and sets stat points necessary for combat.
- Author: @cdeluna
- Email: cdeluna@ggc.edu
- Version: 0.0.4
- Date: 2015-11-05
*/
public abstract class Persona implements Combat {

	private static String name = "";
	private boolean alive = true;
	private int healthPoints;
	private int attackPoints;
	private int defensePoints;

	/**
	 * Method: getName - Getter method for the name of player
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public static void setName(String name) {
		Persona.name = name;
	}

	/**
	 * Method: isAlive - Determines the player's status based on amount of
	 * health points
	 * 
	 * @return true
	 */
	public boolean isAlive() {
		return true;
	}

	/**
	 * Method: getHealthPoints - Getter method for the health points of the
	 * player
	 *
	 * @return the healthPoints
	 */
	public int getHealthPoints() {
		return healthPoints;
	}

	/**
	 * @param healthPoints
	 *            the healthPoints to set
	 */
	public void setHealthPoints(int healthPoints) {
		this.healthPoints = healthPoints;
	}

	/**
	 * Method: getAttackPoints - Getter method for the attack points of the
	 * player
	 *
	 * @return the attackPoints
	 */
	public int getAttackPoints() {
		return attackPoints;
	}

	/**
	 * @param attackPoints
	 *            the attackPoints to set
	 */
	public void setAttackPoints(int attackPoints) {
		this.attackPoints = attackPoints;
	}

	/**
	 * Method: getDefensePoints - Getter method for the defense points of the
	 * player
	 *
	 * @return the defensePoints
	 */
	public int getDefensePoints() {
		return defensePoints;
	}

	/**
	 * @param defensePoints
	 *            the defensePoints to set
	 */
	public void setDefensePoints(int defensePoints) {
		this.defensePoints = defensePoints;
	}

}
