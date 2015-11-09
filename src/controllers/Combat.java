package controllers;

/**
 * 
 * @author Travis T3 Keating
 * 
 * LAST EDITED ON 11.9.15
 * 
 * Let me know what you guys think about this. I'm thinking
 * that we have combat happen in either Persona or Planet. 
 * --Travis
 *
 */

public interface Combat {

	/**
	 * METHOD: attack
	 * 
	 * Use when starting combat with a non-ambush enemy
	 * 
	 * @param: attackPoints
	 * @param: defensePoints
	 */
	public void attack(int attackPoints, int defensePoints);
	
	/**
	 * METHOD: ambush
	 * 
	 * Use when starting combat with an ambush enemy
	 * 
	 * @param: attackPoints
	 * @param: defensePoints
	 */
	public void ambush(int attackPoints, int defensePoints);
	
}
