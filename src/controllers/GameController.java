package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.lang3.text.WordUtils;
import obstacles.*;
import playerCharacter.Captain;

/*
Class: GameController
The GameController class is the primary controller, featuring the interfaces, the runnables and the starting point for the game. 
- Author: @jbroughton
- joshua.c.broughton@gmail.com, jbroughton@ggc.edu
- Version: 0.0.2
- 2015-11-03    
*/
public class GameController {
	private static boolean startFromSave = false;
	private static int PLANETS_WITH_NAVIGATION = 3;
	private static int PLANETS_WITHOUT_NAVIGATION = 2;
	private static SaveGame returningCaptain;
	private static SaveGame newCaptain;
	private static ArrayList<Planet> planetArrayList = new PlanetMaker().getPlanetArrayList();
<<<<<<< HEAD
=======
	private int test = 1; 
>>>>>>> branch 'master' of https://github.com/Kenjacau/ITEC3860FALL2015STARGAME


	/**main()
	 * STATIC METHOD
	 * This serves as the starting point for the GameController class.
	 * @param args Command line arguments
	 * @throws IOException
	 */
	@SuppressWarnings("static-access") //I'm alone in the woods here.
	public static void main (String[] args) throws IOException {
		Scanner in = new Scanner(System.in);

		System.out.println("Hello Captain! Welcome to the world.");
		System.out.println("Would you like to load a save game? Please enter 'Y' or 'N'");
		String loadSave = in.nextLine().toLowerCase();
		if (loadSave.equals("y")) {
			setStartFromSave(true);
			System.out.println("The savegame file must be on your desktop.");
			System.out.println("Please enter the name of the savegame file without the file extension: ");
			String saveGamePath = SaveGame.getPATH().concat(in.nextLine().toLowerCase());
			returningCaptain = new SaveGame(saveGamePath);
			System.out.println("Welcome back, Captain " + returningCaptain.getCaptainName() + "!");
			if (returningCaptain.getNumPreviousSaves() <= 3) {
				Captain.setCaptainName(returningCaptain.getCaptainName());
				Captain.setCrew(returningCaptain.getCrew());
			}

			else {
				System.out.println("Sorry, " + returningCaptain.getCaptainName() + ". You've been retired. You're just too damn old!");
				System.out.println("End of line.");
				endGame();
			}
		}
		else {
			//Blocking statements are used to halt execution at each of these methods. 
			setCaptainName();
			displayMainMenu();
			displayPlanetSelectionMenu();

		}
	}

	//MENU METNODS ------------------------------------------------------------
	/**displayMainMenu()
	 * STATIC METHOD
	 * Displays the main menu on the console.
	 * @return void
	 */
	public static void displayMainMenu() {
		displayCrewSelectionMenu();
	}

	/**displayCrewSelectionMenu()
	 * STATIC METHOD
	 * Displays the crew selection menu on the console.
	 * @return void
	 */
	public static void displayCrewSelectionMenu() {
		final int MAX_CREW_SIZE = 3;
		Scanner in = new Scanner(System.in);
		String[] availableCrew = new String[] {"Navigation Officer", "Security Officer", "Tactical Officer", "Survey Officer" , "Sentinel Bot", "Engineer"};
		ArrayList<String> selectedCrew = new ArrayList<String>();
		if (!isStartFromSave()) {
			System.out.println("Captain! You must select a crew! You can only choose three!"); //Yeah, I made that up.
			System.out.println("Here is the list of available members:");
			for (String s : availableCrew) {
				System.out.println(s + "?");
			}

			//The Apache clause is an attempt to move every keystroke to lower case, and then appropriately capitalize the crew members. 
			System.out.println("Please type three crew members, and press enter between each one!");
			for (int i = 0; i <= 2; i++) {
				selectedCrew.add(in.nextLine());
			}

			//Confirm selection. This method is an external recurse to the displayCrewSelectionMenu() method. 
			confirmCrew(selectedCrew);

			if (!doesPlayerHaveFullCrew(selectedCrew)) {
				System.out.println("Something screwed up! Let's do that again!");
				displayCrewSelectionMenu(); //recurse. 
			}
		}
		else {
			System.out.println("Captain, this is who you're travelling with: ");
			for (String crewName : returningCaptain.getCrew()) {
				System.out.println(crewName);
			}
			displayPlanetSelectionMenu();
		}
	}

	/**displayPlanetSelectionMenu()
	 * STATIC METHOD
	 * Displays the planet selection menu on the console.
	 * @return void
	 */
	public static void displayPlanetSelectionMenu() {
		Scanner in = new Scanner(System.in);
		String nextPlanet = "";
		ArrayList<String> planetList = new ArrayList<String>();
		ArrayList<String> possiblePlanets = new ArrayList<String>();

		//Clear values for recurse. 
		possiblePlanets.clear();

		//Editted by: Kenny Cauthen
		for (Planet p : planetArrayList) {
			planetList.add(p.getPlanetName());
		}


		if (startFromSave) {
			System.out.println("Here are all the planets you've visited: "); //TODO: Get list of visited planets in there from save game. 
			for (String s : returningCaptain.getPlanetsVisited()) {
				System.out.println(s);
			}

			//This loop of code gets rid of the planets the Captain has already visited from the planet list. 
			for (String thisVisitedPlanet : returningCaptain.getPlanetsVisited()) { 	//For each visited planet...
				for (String thisPlanet : planetList) { 									//...for each planet in the full list...
					if (thisVisitedPlanet.equals(thisPlanet)) { 						//...compare, and if they're equal...
						planetList.remove(thisPlanet); 									//...remove from the full list.
					}
				}
			}
		}

		System.out.println("Which planet would you like to visit? Here is a list of possibilites: ");
		//TODO: Get Christan to fix the hasNavigatioOfficer method.
		if (Captain.hasNavigationOfficer()) {
			for (int i = 1; i <= PLANETS_WITH_NAVIGATION; i++) {
				possiblePlanets.add(getRandomPlanet(planetList));
			}

			for (String thisPlanet : possiblePlanets) {
				System.out.println(thisPlanet);
			}
		}

		else {
			for (int i = 1; i <= PLANETS_WITHOUT_NAVIGATION; i++) {
				possiblePlanets.add(getRandomPlanet(planetList));
			}

			for (String thisPlanet : possiblePlanets) {
				System.out.println(thisPlanet);
			}
		}

		System.out.println("Please enter the planet you'd like to visit. Remember, type the planet name exactly or we'll end up lost in space!!");
		nextPlanet = in.nextLine(); //Oh goodness... the case is going to be bad on this one.  		
		if(!possiblePlanets.contains(nextPlanet)) {
			System.out.println("Oh no, Captain! We're adrift! Attempting to renavigate...");
			displayPlanetSelectionMenu(); //Recurse. 
		}

		//TODO: Planet instantiation constructor here
		for (Planet p : planetArrayList) {
			if (p.getPlanetName().contains(nextPlanet)) {
				displayPlanetMenu(p);
			}
		}
		//Edited By: Kenny Cauthen
		//obstacles.Planet target = new Planet(nextPlanet); //TODO: Need arguments. This is also kinda janky.

	}

	/**displayPlanetMenu(Planet target)
	 * STATIC METHOD
	 * Displays the planet menu on the console.
	 * @return void
	 */
	public static void displayPlanetMenu(Planet targetPlanet) {
		Scanner in = new Scanner(System.in);
		//Pass the planet to the appropriate arrays. 
		if (startFromSave) {
			returningCaptain.addVisistedPlanet(targetPlanet.getPlanetName());
		}
		else{
			newCaptain.addVisistedPlanet(targetPlanet.getPlanetName());
		}

		if (targetPlanet.getPlanetFlag() == 1) {
			System.out.println("Captain! We have landed on " + WordUtils.capitalizeFully(targetPlanet.getPlanetName()) + "!"); //Capitalization is for the civilized. 
			System.out.println("Here is the planet's Wikipedia Entry:");
			System.out.println(targetPlanet.getArrivalMessage());
			System.out.println("What would you like to do? You may Explore (type 'E'), you may Scan (type 'S') or you may choose another planet (type 'get me out of here').");

			String captainsResponse = in.nextLine().toLowerCase(); //Blocking statement.

			if (captainsResponse.equals("get me out of here")) {
				displayPlanetSelectionMenu();
			}

			else if (captainsResponse.equals("e")) {
				System.out.println(targetPlanet.getExploreMessage());
				//TODO: Something
			}

			else if (captainsResponse.equals("s")) {
				System.out.println(targetPlanet.getScanMessage());
				//TODO: What here?			
			}
		}

		else {
			System.out.println("Captain! We are about to be ambushed!!"); //TODO: Travis, what do you want to do with bosses? 
			//TODO: Enter combat. 
		}
	}

	/**displayCombatMenu()
	 * STATIC METHOD
	 * Displays the combat menu on the console.
	 * @param selectedEnemy The enemy to be fought!
	 * @return void
	 */
	public static void displayCombatMenu(Enemy selectedEnemy)	{
		//TODO: Write menu
	}

	/**
	 * displayCombatMenu()
	 *
	 * @param selectedPuzzle The puzzle to be solved!
	 * @return void
	 * @author Kenny Cauthen
	 * Displays the puzzle menu on the console.
	 */
	public boolean displayPuzzleMenu(Puzzle selectedPuzzle) {
		//TODO: Write menu Kenny
		return true;
	}


	/**confirmCrew()
	 * STATIC METHOD
	 * Confirms the captain's crew selection
	 * @param selectedCrew An array of strings with crew names.
	 */
	public static void confirmCrew(ArrayList<String> selectedCrew) {
		Boolean correctCrew = false;
		Scanner in = new Scanner(System.in);

		//Interaction with user:
		System.out.println("Captain! Have you selected the correct crew members?");
		StringBuilder selection = new StringBuilder("You have currently selected: ");
		for (int i = 0; i <= 1; i++) { //Gettin' the first two.
			selection.append(selectedCrew.get(i) + ", ");
		}
		selection.append("and " + selectedCrew.get(2) + ".");
		System.out.println(selection);

		System.out.println("If correct, please type 'Y'. If incorrect, please type 'N'.");
		System.out.println("Please note: if the names aren't exact, the crew can't help you!");
		String replyFromCaptain = in.next().toLowerCase();
		if (replyFromCaptain.toLowerCase().equals("y")) {
			correctCrew = true;
			Captain.setCrew(selectedCrew); //This passes the crew array on the captain object. 
			newCaptain.setCrew(selectedCrew); //This passes the crew array to the currentSavegame object. 
		}

		//Recurse if crew incorrect. 
		if (!correctCrew) {
			displayCrewSelectionMenu();
		}
	}

	/**displayWinMessage()
	 * STATIC METHOD
	 * Displays the win message on the console.
	 * @return void
	 */
	public static void displayWinMessage() {
		System.out.println("Congratulations Captain!! You've won the game!");
		System.out.println("This abomination was programmed by:");
		for (String s : getAuthors()) {
			System.out.println(s);
		}
	}

	/**askIfPlayerWantsToSave()
	 * STATIC METHOD
	 * Asks the Captain for a save game!
	 * @return saveGameNow Boolean flag for saving the game.
	 */
	public static Boolean askIfPlayerWantsToSave() {
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

		if (youSure.equals("y")) {
			System.out.println("Great, Captain! Let's get started.");
			Captain.setCaptainName(captainName); //Pass to captain object. 
			newCaptain.setCaptainName(captainName); //Pass to savegame object.
		} else {
			System.out.println("Ok! Let's try again!");
			setCaptainName();
		}
	}


	//END MENU METHODS-------------------------------------------------------




	//OBSTACLE METHODS-------------------------------------------------------

	/**solvePuzzle()
	 * executes the puzzle on the selected planet.
	 * @param selectedPlanet The planet on which the Captain sits!
	 * @return success Boolean for successful solve!
	 * Last Edit: Kenny Cauthen
	 * Remarks: Why does Puzzle return boolean but Enemy doesnt. I think success should be judged within puzzle.
	 */
	public Boolean solvePuzzle(Planet selectedPlanet)	{
		//TODO: Write whatever this is supposed to be.
		Boolean success = displayPuzzleMenu(new Puzzle(selectedPlanet.getPlanetName()));
		return success;
	}

	/**engageEnemy()
	 * Engages the enemy on the selected planet in combat.
	 * @param selectedPlanet The planet on which the Captain sits!
	 * @return void
	 * Last Edit: Kenny Cauthen - new Enemy should be created based on planetName
	 */
	public void engageEnemy(Planet selectedPlanet)	{
		//TODO: Write whatever this is supposed to be.
		displayCombatMenu(new Enemy(selectedPlanet.getPlanetName()));
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
	 * @throws IOException
	 */
	public static void endGame() throws IOException {
		System.out.println("Goodbye, Captain!");
		if (!startFromSave) {
			try {
				if (askIfPlayerWantsToSave()) {
					if (!startFromSave) {
						newCaptain.writeOutData(newCaptain, newCaptain.getFullPath()); //Yes, this could be DOUBLE extracted. 
					}

					else {
						returningCaptain.writeOutData(returningCaptain, returningCaptain.getFullPath());
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else {
			System.exit(0);
		}
	}

	/**checkWin()
	 * Checks to see if the game has been won!
	 * @param targetGame The saveGame object currently tracking the captain's progress.
	 * @return success Boolean flag to see if the game has been won.
	 */
	public static Boolean checkWin(SaveGame targetGame) {
		//TODO: Confirm criteria for game win. 
		Boolean success = null;
		if (targetGame.getBossesDefeated().size() >= 3) {
			success = true;
		} else {
			success = false;
		}
		return success;
	}

	/**doesPlayerHaveFullCrew()
	 * Checks to see if the player has three crew members.
	 * @param selectedCrew Array of crew members.
	 * @return fullCrew Boolean flag for full crew.
	 */
	public static Boolean doesPlayerHaveFullCrew(ArrayList<String> selectedCrew) {
		Boolean fullCrew = null;

		if (selectedCrew.size() != 3) {
			fullCrew = false;
			return fullCrew;
		}

		for (String s : selectedCrew) {
			if (s == null || s == "") {
				fullCrew = false;
			} else {
				fullCrew = true;
			}
		}

		return fullCrew;
	}

	/**isStartFromSave
	 * Gets the start from save flag.
	 * @return the startFromSave
	 */
	public static boolean isStartFromSave() {
		return startFromSave;
	}

	/**setStartFromSave
	 * Sets the startFromSave flag.
	 * @param newStartFromSave the startFromSave to set
	 */
	public static void setStartFromSave(boolean newStartFromSave) {
		startFromSave = newStartFromSave;
	}

	/**getAuthors()
	 * Gets the authors
	 * @return Author array.
	 */
	public static String[] getAuthors() {
		String[] authors = new String[] {"Christian de Luna", "Travis Keating", "Kenny Cauthen", "Joshua Broughton"};
		return authors;
	}
	//END ADMIN METHODS-----------------------------------------------------


	/**
	 * getRandomPlanet
	 * STATIC METHOD
	 * Returns the name of a random planet.
	 *
	 * @param availablePlanets An arrayList of Strings: available planet names.
	 * @return A single, random element in the paramater.
	 */
	public static String getRandomPlanet(ArrayList<String> availablePlanets) {
		int index = ThreadLocalRandom.current().nextInt(0, availablePlanets.size());
		return availablePlanets.get(index);
	}
}