package playerCharacter;

import java.util.Scanner;
import controllers.Game;

/**
Class: Persona
Purpose: The Persona class stores attributes, which gets and sets stat points necessary for combat.
- Author: @cdeluna
- Email: cdeluna@ggc.edu
- Version: 0.0.5
- Date: 2015-11-05
**/
public abstract class Persona {

	private String name = "";
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
	public void setName(String name) {
		this.name = name;
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
	
	// Combat stuff here
//	public static void main(String[] args) {
//		
//		//Create Scanner
//		Scanner in = new Scanner(System.in);/*Should this be closed inside the method or in the game controller*/
//
//		//Main combat menu intro text
//		System.out.println("You've come to kill aliens and chew bubble gum... and you're all out of bubble gum");
//		
//		boolean captainAlive = true; //Will later use the method isAlive() from Persona
//		boolean enemyAlive = true; //Will later use the method isAlive() from Persona
//		boolean hasTacticalOfficer = true; //Will later use the method hasTacticalOfficer() from Captain
//		
//		boolean hasFled = false; /**This needs to be added to Captain to allow player to flee*/
		
		public void getCaptainStats(Game game) {
			game.getCaptain().getHealthPoints();
		}
		//Dummy Stats to be replaced with the appropriate methods from the combat interface
		int captainATK = 10;
		int captainDEF = 6;
		int captainHP = 20;
		int currentCaptainHP = captainHP;/**This needs to be added to prevent the player from healing past max*/
//		Insert captain attributes here
		
		int foeATK = 20;
		int foeDEF = 3;
		int foeHP = 20;
		String foeName = "Lord Soth";
		int ambushStatus = 1;

		
		//Start point for each combat round, assuming both parties are alive
		while (captainAlive  == true && enemyAlive == true && hasFled == false){
			
			//Loop for ambush round
			if(ambushStatus == 1){
				//if enemy survives initiate Enemy on player Combat
				System.out.println("Captain! " + foeName + "Appears to be readying for an attack!\n");
				System.out.println("Incoming lasers! Brace for impact in 3... 2... 1!\n");
				
				//Determine damage
				int foeDmg = foeATK - captainDEF;
				
				//Sustain Damage
				currentCaptainHP = currentCaptainHP - foeDmg;
				
				//Display damage dealt
				System.out.println("Captain! Our sensors are showing us that we have sustained class " 
						+ foeDmg + " damage to our hull!\n");
				System.out.println("Sir our shields are at level " + currentCaptainHP + "!\n");
				
				//If player dies
				if(currentCaptainHP <= 0){
					System.out.println("GAME OEVER");
					captainAlive = false;
					//TODO Game Over Sequence
			}
			
			//Combat menu
			System.out.println("Your orders captain?");
			System.out.println("@ ATTACK");
			
			
			//Allow player to flee if they have the Tac Officer
			if (hasTacticalOfficer == true){
				System.out.println("@ FLEE");
			}
			
			//Declare string to hold player choice
			String playerAction = in.nextLine();
			
			//Menu loop
			
			//When player chooses to ATTACK
			if( playerAction.equalsIgnoreCase("ATTACK")){
				System.out.println("Roger that Captain. Target acquired, firing lasers!\n");
				
				//Player on Enemy combat
				
				//Determine damage
				int dmg = captainATK - foeDEF;
				
				//Inflict damage
				foeHP = foeHP - dmg;
				
				//Display damage dealt
				System.out.println("Captain, our scanners report that " + foeName + " has sustained class "
						+ dmg + " damage.\n");
				
				//Determine if enemy is still alive
				if (foeHP <= 0){
					System.out.println("Sir, " + foeName + " has been neutralized\n");
					enemyAlive = false;
				}else{
					
					//if enemy survives initiate Enemy on player Combat
					System.out.println("Captain! " + foeName + "Appears to be readying for an attack!\n");
					System.out.println("Incoming lasers! Brace for impact in 3... 2... 1!\n");
					
					//Determine damage
					foeDmg = foeATK - captainDEF;
					
					//Sustain Damaeg
					currentCaptainHP = currentCaptainHP - foeDmg;
					
					//Display damage dealt
					System.out.println("Captain! Our sensors are showing us that we have sustained class " 
							+ foeDmg + " damage to our hull!\n");
					System.out.println("Sir our shields are at level " + currentCaptainHP + "!\n");
					
					//If player dies
					if(currentCaptainHP <= 0){
						System.out.println("GAME OEVER");
						captainAlive = false;
						//TODO Game Over Sequence
					}
				}
					
			//Handle Flee Command
			}else if(playerAction.equalsIgnoreCase("FLEE")){
				System.out.println("Roger that captain! Preparing for ludicrous Speed!");
				System.out.println("Ludicrous Speed reached! Sir we've gone Plaid.\n");
				hasFled = true;
				//TODO: Then enter into planet selection because player jumped into hyper space.
			}
			
			//Handle incorrect commands
			else{
				System.out.println("Sir we can't do that here!\n");
			}
			}
		}
	}
}
