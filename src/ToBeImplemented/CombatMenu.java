package ToBeImplemented;

import java.util.Scanner;
import controllers.Combat;
import obstacles.Enemy;
import playerCharacter.Captain;

/**
 * 
 * @author Travis T3 Keating
 * 
 * This is a self contained combat menu for easy testing, will be integrated into the game controller later and use
 * the interface
 * 
 * Created on 11/3/15
 * EDIT HISTORY:
 * 		>11/4/15 Travis K
 *
 */
public class CombatMenu {

	public static void main(String[] args) {
		
		//Create Scanner
		Scanner in = new Scanner(System.in);/*Should this be closed inside the method or in the game controller*/
		
		//Main combat menu intro text... because Duke Nukeum
		System.out.println("You've come to kill aliens and chew bubble gum... and you're all out of bubble gum");
		
		boolean captainAlive = true; //Will later use the method isAlive() from Persona
		boolean enemyAlive = true; //Will later use the method isAlive() from Persona
		boolean hasTacticalOfficer = true; //Will later use the method hasTacticalOfficer() from Captain
		
		boolean hasFled = false; /**This needs to be added to Captain to allow player to flee*/
		
		//Dummy Stats to be replaced with the appropriate methods from the combat interface
		int captainATK = 10;
		int captainDEF = 6;
		int captainHP = 20;
		int currentCaptainHP = captainHP;/**This needs to be added to prevent the player from healing past max*/
		
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

}}

//// Back up
//
//// Create Scanner
//Scanner in = new Scanner(System.in);
//
//// Main combat menu intro text
//System.out.println("You've come to kill aliens and chew bubble gum... and you're all out of bubble gum");
//
//private boolean captainAlive = true;
//private boolean enemyAlive = true;
//private boolean hasFled = false;
//private int currentCaptainHP = healthPoints;
//private int enemyCurrentHP = healthPoints;
//private Captain captain;
//private Enemy enemy;
//
////public void getCaptainStats() {
////	captain.setHealthPoints(100);
////	captain.setAttackPoints(20);
////	captain.setDefensePoints(20);
////}
////
////public void getEnemyStats() {
////		enemy.getHealth();
////		enemy.getAttackPoints();
////		enemy.getDefensePoints();
////		enemy.getAmbushStatus();
////	}
//
//{
//
//// Start point for each combat round, assuming both parties are alive
//while (captainAlive == true && enemyAlive == true && hasFled == false) {
//
//	// Loop for ambush round
//	if (enemy.getAmbushStatus() == 1) {
//		// if enemy survives initiate Enemy on player Combat
//		System.out.println("Captain! " + enemy.getEnemyName() + "Appears to be readying for an attack!\n");
//		System.out.println("Incoming lasers! Brace for impact in 3... 2... 1!\n");
//
//		// Determine damage
//		int enemyDamage = enemy.getAttackPoints() - captain.getDefensePoints();
//
//		// Sustain Damage
//		currentCaptainHP = currentCaptainHP - enemyDamage;
//
//		// Display damage dealt
//		System.out.println("Captain! Our sensors are showing us that we have sustained class " + enemyDamage
//				+ " damage to our hull!\n");
//		System.out.println("Sir our shields are at level " + currentCaptainHP + "!\n");
//
//		// If player dies
//		if (currentCaptainHP <= 0) {
//			System.out.println("GAME OVER");
//			captainAlive = false;
//			// TODO Game Over Sequence
//		}
//
//		// Combat menu
//		System.out.println("Your orders captain?");
//		System.out.println("[A]ttack");
//
//		// Allow player to flee if they have the Tac Officer
//		if (captain.hasTacticalOfficer() == true) {
//			System.out.println("[F]lee");
//		}
//
//		// Declare string to hold player choice
//		String playerAction = in.nextLine();
//
//		// Menu loop
//
//		// When player chooses to ATTACK
//		if (playerAction.equalsIgnoreCase("Attack")) {
//			System.out.println("Roger that Captain. Target acquired, firing lasers!\n");
//
//			// Player on Enemy combat
//
//			// Determine damage
//			int captainDamage = captain.getAttackPoints() - enemy.getDefensePoints();
//
//			// Inflict damage
//			enemyCurrentHP = enemy.getHealth() - captainDamage;
//
//			// Display damage dealt
//			System.out.println("Captain, our scanners report that " + enemy.getEnemyName() + " has sustained class "
//					+ captainDamage + " damage.\n");
//
//			// Determine if enemy is still alive
//			if (enemy.getHealth() <= 0) {
//				System.out.println("Sir, " + enemy.getEnemyName() + " has been neutralized\n");
//				enemyAlive = false;
//			} else {
//
//				// if enemy survives initiate Enemy on player Combat
//				System.out.println("Captain! " + enemy.getEnemyName() + "Appears to be readying for an attack!\n");
//				System.out.println("Incoming lasers! Brace for impact in 3... 2... 1!\n");
//
//				// Determine damage
//				enemyDamage = enemy.getAttackPoints() - captain.getDefensePoints();
//
//				// Sustain Damage
//				currentCaptainHP = currentCaptainHP - enemyDamage;
//
//				// Display damage dealt
//				System.out.println("Captain! Our sensors are showing us that we have sustained class " + enemyDamage
//						+ " damage to our hull!\n");
//				System.out.println("Sir our shields are at level " + currentCaptainHP + "!\n");
//
//				// If player dies
//				if (currentCaptainHP <= 0) {
//					System.out.println("GAME OVER");
//					captainAlive = false;
//					// TODO Game Over Sequence
//				}
//			}
//
//			// Handle Flee Command
//		} else if (playerAction.equalsIgnoreCase("Flee")) {
//			System.out.println("Roger that captain! Preparing for ludicrous Speed!");
//			System.out.println("Ludicrous Speed reached! Sir we've gone Plaid.\n");
//			hasFled = true;
//			// TODO: Then enter into planet selection because player jumped
//			// into hyper space.
//		}
//
//		// Handle incorrect commands
//		else {
//			System.out.println("Sir we can't do that here!\n");
//		}
//	}
//}
