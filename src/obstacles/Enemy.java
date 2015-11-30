package obstacles;

import playerCharacter.Persona;

/*
Class: Enemy
TODO: Write class definition here.
- Author: @tkeating
- TODO: Write your email addresss here.
- Version: 0.0.0
- TODO: Date goes here.    
*/
public class Enemy extends Persona
{
	//Declare enemy specific Attributes

	private int ambushStatus;
	private String enemyDescription;
	private String enemyLocation;

	//TODO: Write this class. Stubbed for inclusion into the controllers.GameController class.
	//Need Enemy constructor that takes in String of planetName.
	public Enemy(String newEnemyList, int newAmbushStatus, int newAttackPoints,
			int newDefensePoints, int newHealth, String newEnemyLocation,
			String newEnemyDescription)
	{
		setName(newEnemyList);
		ambushStatus = newAmbushStatus;
		setAttackPoints(newAttackPoints);
		setDefensePoints(newDefensePoints);
		setHealthPoints(newHealth);
		enemyDescription = newEnemyDescription;
		enemyLocation = newEnemyLocation;

	}

	public Enemy() {

	}

	/**
	 * @return the enemy description
	 */
	public String getEnemyDescription()
	{
		return enemyDescription;
	}

	/**
	 * @return the enemy location
	 */
	public String getEnemyLocation()
	{
		return enemyLocation;
	}

	/**
	 * @return the ambush status
	 * 
	 * Note to Self: 
	 * 		When ambushStatus == 0 -> not an ambush
	 * 		When ambushStatus == 1 -> is an ambush
	 * 	I'm assuming this is what ambushStatus is supposed to be?
	 * 		--Travis K.
	 */
	public int getAmbushStatus()
	{
		return ambushStatus;
	}

	

}
