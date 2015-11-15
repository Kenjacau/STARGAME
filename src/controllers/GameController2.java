package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import obstacles.*;
import playerCharacter.Captain;
import testers.*; 

/*
Class: GameController
The GameController class is the primary controller, featuring the interfaces, the runnables and the starting point for the game. 
- Author: @jbroughton
- joshua.c.broughton@gmail.com, jbroughton@ggc.edu
- Version: 0.0.2
- 2015-11-03    
*/
public class GameController2 {
	//Static constants.
	private static final String SPACE_GAME_TITLE = "Super Elite: Space Adventure";
	private final String EXTENSION = ".ser";
	private Game thisGame;
	private Captain captain;
	private ArrayList<Planet> planetArrayList;
	private ArrayList<Puzzle> puzzleArrayList = new PuzzleMaker().getPuzzleArrayList();
	private ArrayList<Enemy> enemyArrayList;
	private Planet currentPlanet;
	private Scanner in = new Scanner(System.in);
	private String userInput = "";

	/**main()
	 * STATIC METHOD
	 * This serves as the starting point for the GameController class.
	 * @param args Command line arguments
	 * @throws IOException
	 */
	public static void main (String[] args) throws IOException {
		GameController2 thisGameController = new GameController2();
		thisGameController.titleScreen();
	}

	//TODO: Quit Game Menu with save option
	//TODO: Display Planet selection menu.
	//TODO: Display Planet menu
	//TODO: Display Combat menu
	//saveGame method and loadGame Constructor should be implemented in game class.
	//Menu to get path for loadGame should be done below.
	//TODO: method saveGame
	//TODO: method loadGame

	//ALL Menu Methods
	
	/**titleScreen()
	 * Displays dat title screen. 
	 * 
	 * @return void
	 * @author kenny
	 */
	public void titleScreen() {
		boolean titleNotComplete = true;

		headerPrint();
		System.out.println(SPACE_GAME_TITLE);
		nl(1);
		System.out.println("Welcome to dat world, Captain! Here are your options.");
		nl(1);

		while (titleNotComplete) {
			System.out.println("dat New Game (N)  :  Load dat Game (L)  :  Exit dat Game (E)  :  dat Help Menu (H)");
			wWJD();
			nl(1);
			listener();
			if (booleanMaker("New Game")) {
				//Construct New game object.
				Game thisGame = new Game();
				thisGame.setNumPreviousSaves(0);
				loadThisGameElements(thisGame);
				
				//Set Captain's name through menu
				captainNameMenu(thisGame); 

				//Set Captain's Crew through menu
				crewSelectionMenu(thisGame);
				//End loop
				titleNotComplete = false;

				//Open load game menu. Returns path of directory where save game is found. Creates Game with attributes.
			} else if (booleanMaker("Load Game")) {
				//TODO: Display LoadGame/SaveGame menu that returns a string path.

				//String path = loadGameMenu(); //TODO: Remove this when menu sys implemented.
				thisGame = new Game(loadGameMenu());
				loadThisGameElements(thisGame);

				titleNotComplete = false;

			} else if (booleanMaker("Exit Game")) {
				System.exit(0);

				titleNotComplete = false;

			} 
			else {
				genericHelpOrInputFailure();
			}
		}
		headerPrint();
		System.out.println("Let's get started Captain!");
		if (currentPlanet != null) {
			planetMenu(currentPlanet);
		} else
			planetSelectionMenu();
	}

	/**captainNameMenu
	 * displays a menu for setting the Captain's name. 
	 * 
	 * @param game The current game.
	 * @author jcbrough
	 */
	private void captainNameMenu(Game game) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in); 
		
		headerPrint(); 
		System.out.println("A new captain! What's your name?");
		String response = in.nextLine(); 
		
		game.getCaptain().setName(response);
		
		System.out.println("Thank you, Captain " + game.getCaptain().getName() + "!"); 
	}

	public void loadThisGameElements(Game thisGame) {
		captain = thisGame.getCaptain();
		planetArrayList = thisGame.getPlanets();

		if (thisGame.getCurrentPlanet() != null) {
			currentPlanet = thisGame.getCurrentPlanet();
		}

	}

	/** planetSelectionMenu()
	 * Displays the planet selection menu. 
	 * 
	 * @return void
	 * @author jcbrough, kenny
	 * 
	 */
	public void planetSelectionMenu() {
		headerPrint();
		nl(1);
		System.out.println("TODO Displaying planet Selection Menu");
		//TODO Planet Selection Menu
	}

	public void planetMenu(Planet planet) {
		headerPrint();
		nl(1);
		System.out.println("TODO Displaying planet menu with planet" + planet);
		//TODO Planet Menu
	}

	public void helpMenu() {
		//TODO
		headerPrint();
		System.out.println("TODO Displaying Help Menu");
		nl(2);
	}

	/**
	 * Method: loadGameMenu()
	 * Description: Load Game menu that displays
	 *
	 * @return String path for Game.loadGame
	 * @author jcbrough, kenny
	 */
	public String loadGameMenu() {
		System.out.println("TODO loadGameMenu. Which game would you like to load?");
		//selectedGame should be the saved game that the player chooses. This is just filler.
		Game selectedGame = new Game();
		if (selectedGame.getNumPreviousSaves() <= 3) {
			System.out.println("Sorry, Captain! You're too old for active duty!");
			titleScreen();
		}
		return System.getProperty("user.home") + "\\Desktop\\" + EXTENSION;
		//TODO load game menu that returns path for Game secondary constructor.
	}

	public void saveGameMenu() {
		String nextAvailableSavePath = "";
		//TODO Save Game Menu to save Game
		System.out.println("TODO Save Game Menu");
		try {
			thisGame.saveGame(nextAvailableSavePath);
		} catch (IOException e) {
			System.out.println("Error Blah Blah");
			e.printStackTrace();
		}

	}


	public void crewSelectionMenu(Game game) {
		
		ArrayList<String> selectedCrew = new ArrayList<String>(); 	
		
		if (game.getNumPreviousSaves() == 0) {
			headerPrint();
			System.out.println("Captain! You must select a crew! You can only choose three!"); //Yeah, I made that up.
			System.out.println("Here is a list of currently unassigned crew:");
			for (String s : game.getCaptain().getFullCrewList()) {
				System.out.println("		" + s + "?");
			}
			
			System.out.println("The rest of the officers of SuperElite StarFleet have been disqualified for active duty for a felony involving a can of pureed pumpkin.");
			System.out.println("Please type three crew members, and press enter between each one!");
			System.out.println("You must type their names EXACTLY, or I don't be able to undestand you finger-accent.");
			nl(1); 
			for (int i = 0; i <= 2; i++) {
				selectedCrew.add(in.nextLine());
			}

			//Confirm selection. This method is an external recurse.
			if (game.getCaptain().confirmCrew(selectedCrew)) {			
				//TODO: Continue. 
			}

			else{
				System.out.println("Something screwed up, captain! Let's do that again!");
				crewSelectionMenu(game); 
			}
		}
		else {
			System.out.println("Captain, this is who you're travelling with: ");
			for (String crewName : selectedCrew) {
				System.out.println(crewName);
				game.getCaptain().setCaptainCrew(selectedCrew);
			}
			//displayPlanetSelectionMenu();
		}
		
		
		
	
	}


	//Menu Making Helper Methods//

	/**
	 * Method: removeNonWords()
	 *
	 * @param string String that you want to remove all whitespace and non word characters from.
	 * @return string with all non word characters including whitespace removed
	 * Last Edit: Kenny Cauthen
	 * Remarks:
	 */
	public String removeNonWords(String string) {
		return (string.replaceAll("[^\\p{L}\\p{Nd}]+", "")).toLowerCase();
	}
	
	/**
	 * Method: headerPrint()
	 * Prints a header thingy. 
	 * @return void
	 * @author kenny
	 */
	public void headerPrint() {
		nl(1);
		System.out.println("==================================================================");
		nl(1);
	}

	/**
	 * Method: wWJD()
	 * Description: Print statement requesting next command. 
	 *
	 * @return void
	 * @author kenny
	 */
	public void wWJD() { //HAHAHAHA!!! WWJD, really? Fuck me running. -JCB
		System.out.println("------------------------------------------------------------------");
		System.out.println("What would you like to do?");
	}

	/**
	 * Method: nl()
	 * Description: goes to next line @param number of times.
	 *
	 * @param numberOfNextLines
	 * @author kenny
	 */
	public void nl(int numberOfNextLines) {
		for (int i = 0; i < numberOfNextLines; i++) {
			System.out.println();
		}

	}
	
	/**
	 * Method: listener()
	 * Description: Takes in user input, removes all non-words and whitespace, then sets the final value to userInput.
	 *
	 * @return void
	 * @author kenny
	 */
	public void listener() {
		userInput = removeNonWords(in.nextLine());
	}

	/**
	 * Method: booleanMaker()
	 * Description: Takes in a String input and converts tests whether userInput contains the whole
	 * String, first char, or just the first word.
	 *
	 * Example: booleanMaker("Exit Menu") <-- will be true if input is "Exit Menu", "Exit", or E
	 *
	 * @param input String to test userInput against.
	 * @return boolean if userInput matches @param input
	 */
	public boolean booleanMaker(String input) {
		return userInput.contains(removeNonWords(input)) || userInput.contains((removeNonWords(input.substring(0, 1)))) ||
				userInput.contains(input.substring(0, input.indexOf(" ")));

	}
	
	/**
	 * Method: genericHelpOrInputFailure()
	 * if userInput contains Help then displays help menu Else Prints a generic failure message.
	 *
	 * @return void
	 * @author kenny, jcbrough
	 */
	public void genericHelpOrInputFailure() {
		if (booleanMaker("Help")) {
			helpMenu();
			System.out.println("Displaying Help Menu");
		} else {
			System.out.println("Input failure!");
		}
	}


	/**
	 * Method: inputFailure()
	 * Prints a failure based on passed parameters
	 *
	 * @return void
	 * @author jcbrough
	 * 
	 * Use case: 
	 *	String garbage = in.nextline(); 
	 * 	if (garbage != validInput) {
	 *	 	inputFailure("Hey, Captain! " + garbage.toUpperCase() + " is not a valid input!");
	 * 		tryInputAgain(); 
	 * 	}
	 */
	public void inputFailure(String message) {
		System.out.println(message);
	}
}
