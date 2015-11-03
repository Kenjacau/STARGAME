package controllers;

import java.io.IOException;
import java.util.Scanner;

import javax.xml.ws.Response;

import org.apache.commons.lang3.text.WordUtils;

import obstacles.*;
import playerCharacter.Captain;

/*
Class: GameController
The GameController class is the primary controller, featuring the interfaces, the runnables and the starting point for the game. 
- Author: @jbroughton
- joshua.c.broughton@gmail.com, jbroughton@ggc.edu
- Version: 0.0.0
- 2015-11-03    
*/
public class GameController {
	
	/**main()
	 * This serves as the starting point for the GameController class. 
	 * @param args Command line arguments
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public static void main (String[] args) throws IOException{
		Scanner in = new Scanner(System.in); 
		
		System.out.println("Hello Captain! Welcome to the world.");
		System.out.println("Would you like to load a save game? Please enter 'Y' or 'N'");
		String loadSave = in.nextLine(); 
		if (loadSave.toLowerCase() == "Y") {
			System.out.println("Write this method.");
		}
		else {
			setCaptainName(); 
			displayMainMenu(); 
		}
		
		
	}
	
	//MENU METNODS ------------------------------------------------------------
	/**displayMainMenu()
	 * Displays the main menu on the console.
	 * @return void
	 */
	public static void displayMainMenu() {
		displayCrewSelectionMenu(); 
	}
	
	/**displayCrewSelectionMenu()
	 * Displays the crew selection menu on the console.
	 * @return void
	 */
	public static void displayCrewSelectionMenu() {
		//TODO: Write menu
		final int MAX_CREW_SIZE = 3; 
		Scanner in = new Scanner(System.in); 		
		String[] availableCrew = new String[] {"Crew1", "Crew2", "Crew3", "Crew4"}; //Add real crew members 
		String[] selectedCrew = new String[MAX_CREW_SIZE]; 

		System.out.println("Captain! You must select a crew!");
		System.out.println("Here is the list of available members:");
		for (String s : availableCrew) {
			System.out.println(s + "?");
		}
		System.out.println("Please type three crew members, and press enter between each one!");
		
		//The Apache clause is an attempt to move every keystroke to lower case, and then appropriately capitalize the crew members. 
		for (int i = 1; i <= MAX_CREW_SIZE; i++) {
			selectedCrew[i] = WordUtils.capitalizeFully(in.nextLine().toLowerCase()); 
			i++; 
		}
		
		//Confirm selection. This method is an external recurse to the displayCrewSelectionMenu() method. 
		confirmCrew(selectedCrew); 
		
		if (!doesPlayerHaveFullCrew(selectedCrew)) {
			System.out.println("Something screwed up! Let's do that again!");
			displayCrewSelectionMenu(); 
		}
		
		//Cleanup.
		in.close();
	}
	
	/**displayPlanetSelectionMenu()
	 * Displays the planet selection menu on the console.
	 * @return void
	 */
	public void displayPlanetSelectionMenu() {
		//TODO: Write menu
	}
	
	/**displayPlanetMenu()
	 * Displays the planet menu on the console.
	 * @return void
	 */
	public void displayPlanetMenu() {
		//TODO: Write menu
	}
	
	/**displayCombatMenu()
	 * Displays the combat menu on the console.
	 * @param selectedEnemy The enemy to be fought!
	 * @return void
	 */
	public void displayCombatMenu(Enemy selectedEnemy)	{
		//TODO: Write menu
	}
	
	/**confirmCrew()
	 * Confirms the captain's crew selection
	 * @param selectedCrew An array of strings with crew names. 
	 */
	public static void confirmCrew(String[] selectedCrew) {
		Boolean correctCrew = false;
		Scanner in = new Scanner(System.in); 
	
		//Interaction with user:
		System.out.println("Captain! Have you selected the correct crew members?");
		System.out.println("You have currently selected: ");
		
		for (String s : selectedCrew) {
			System.out.println(s + "\n");
		}
		System.out.println("If correct, please type 'T'. If incorrect, please type 'F'.");
		String replyFromCaptain = in.next(); 
		if (replyFromCaptain.toLowerCase() == "t") {
			correctCrew = true;
		}
		
		//Cleanup input.
		in.close(); 
		
		//Recurse if incorrect. 
		if (!correctCrew) {
			displayCrewSelectionMenu(); 
		}	
		
	}
	
	/**displayWinMessage()
	 * Displays the win message on the console.
	 * @return void
	 */
	public void displayWinMessage() {
		System.out.println("Congratulations Captain!! You've won the game!");
		System.out.println("This was programmed by:");
		for (String s : getAuthors()) {
			System.out.println(s);
		}
	}
	
	/**askIfPlayerWantsToSave()
	 * Asks the Captain for a save game!
	 * @return saveGameNow Boolean flag for saving the game. 
	 */
	public Boolean askIfPlayerWantsToSave() {
		Scanner in = new Scanner(System.in); 
		Boolean saveGameNow;
		
		System.out.println("Would you like to save your game? Please type 'Y' or 'N'!");
		String response = in.nextLine().toLowerCase(); 
		
		if (response == "y") {
			saveGameNow = true; 
		}
		else {
			saveGameNow = false;
		}
		
		//Cleanup
		in.close(); 
		
		return saveGameNow; 
	}
	
	/**setCaptainName()
	 * Asks the Captain for a name!
	 * @param none
	 * @return void
	 */
	public static void setCaptainName() {
		Scanner in = new Scanner(System.in); 
		
		System.out.println("First time Captain, huh? That's ok."); 
		System.out.println("There are a few things we must do before we begin.");
		System.out.println("What's your name, Captain?");
		String captainName = in.nextLine(); 
		
		System.out.println(captainName + " eh? You sure? Please enter 'Y' or 'N'.");
		String youSure = in.nextLine().toLowerCase(); 
		System.out.println(youSure);
			
		if (youSure.equals("y")) { 
			System.out.println("Great, Captain! Let's get started.");
			Captain.setCaptainName(captainName);
		}
		
		else {
			System.out.println("Ok! Let's try again!"); 
			setCaptainName(); 
		}
		
		
		
		//Cleanup
		in.close();
		}
		
	//END MENU METHODS-------------------------------------------------------
	
	
	
	
	//OBSTACLE METHODS-------------------------------------------------------
	/**solvePuzzle()
	 * executes the puzzle on the selected planet. 
	 * @param selectedPlanet The planet on which the Captain sits!
	 * @return success Boolean for successful solve!
	 */
	public Boolean solvePuzzle(Planet selectedPlanet)	{
		//TODO: Write whatever this is supposed to be.
		Boolean success = false;
		return success;
	}
	
	/**engageEnemy()
	 * Enagages the enemy on the selected planet in combat. 
	 * @param selectedPlanet The planet on which the Captain sits!
	 * @return void
	 */
	public void engageEnemy(Planet selectedPlanet)	{
		//TODO: Write whatever this is supposed to be.
		displayCombatMenu(selectedPlanet.getEnemy()); 
	}
	//END OBSTACLE METHODS--------------------------------------------------
	
	
	
	//ADMIN METHODS---------------------------------------------------------
	/**newGame()
	 * Starts a new game 
	 * @param none
	 * @return void
	 */
	public void newGame() {
		//TODO: Write method.
	}
	
	/**exitGame()
	 * Exits the game.
	 * @param none
	 * @return void
	 */
	public void endGame() {
		System.out.println("Goodbye, Captain!");
		if (askIfPlayerWantsToSave()) {
			//TODO: SaveGameConstructor here.  
		}
	}
	
	/**checkWin()
	 * Checks to see if the game has been won!
	 * @param None
	 * @return success Boolean flag to see if the game has been won.
	 */
	public Boolean checkWin() {
		Boolean success = false;
		return success; 
	}
	
	/**doesPlayerHaveFullCrew()
	 * Checks to see if the player has three crew members. 
	 * @param crew Array of crew members.
	 * @return fullCrew Boolean flag for full crew.
	 */
	public static Boolean doesPlayerHaveFullCrew(String[] crew) {
		Boolean fullCrew = null;
		
		if (crew.length != 3) {
			fullCrew = false;
			return fullCrew; 
		}
		
		for (String s : crew) {
			if (s == null || s == "") {
				fullCrew = false;
			}
			else {
				fullCrew = true; 
			}
		}
		
		return fullCrew; 
	}
	
	/**getAuthors()
	 * Gets the authors
	 * @return Author array. 
	 */
	public String[] getAuthors() {
		String[] authors = new String[] {"Christian de Luna", "Travis Keating", "Kenny Cauthen", "Joshua Broughton"};
		return authors;
	}

	//END ADMIN METHODS-----------------------------------------------------

}
