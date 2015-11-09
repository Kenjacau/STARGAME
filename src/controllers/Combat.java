package controllers;

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
