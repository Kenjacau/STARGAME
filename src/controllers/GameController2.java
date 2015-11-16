package controllers;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import obstacles.*;
import playerCharacter.Captain;
import sun.font.TrueTypeFont;
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

		
		
		//TODO: Quit Game Menu with save option
		//TODO: Display Planet selection menu.
		//TODO: Display Planet menu
		//TODO: Display Combat menu
		//saveGame method and loadGame Constructor should be implemented in game class.
		//Menu to get path for loadGame should be done below.
		//TODO: method saveGame
		//TODO: method loadGame

		//ALL Menu Methods
	}

	
	
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
				//Construct New game object, captain object, and ArrayList of default planets.
				Game thisGame = new Game();
				captain = new Captain();
				planetArrayList = new PlanetMaker().getPlanetArrayList();
				thisGame.setNumPreviousSaves(0);
				
				//Set Captain's name through menu
				captainNameMenu();

				//Set Captain's Crew through menu
				crewSelectionMenu();
				//End loop
				titleNotComplete = false;

				//Open load game menu. Returns path of directory where save game is found. Creates Game with attributes.
			} else if (booleanMaker("Load Game")) {
				//TODO: Display LoadGame/SaveGame menu that returns a string path.

				//String path = loadGameMenu(); //TODO: Remove this when menu sys implemented.
				thisGame = new Game(loadGameMenu(userInput));
				loadThisGameElements(thisGame);
				System.out.println("Captain, this is who you're travelling with: ");
				for (String crewName : captain.getCaptainCrew()) {
					System.out.println(crewName);
				}


				titleNotComplete = false;

			} else if (booleanMaker("Exit Game")) {
				System.exit(0);

				titleNotComplete = false;

			} 
			else {
				helpChoice();
				genericInputFailure();
			}
		}
		headerPrint();
		System.out.println("Let's get started Captain!");
	
		if (currentPlanet != null) {
			planetMenu(currentPlanet);
		} else if (captain.hasNavigationOfficer()) {
			planetSelectionMenu(3);
		} else {
			planetSelectionMenu(2);
		}

	}

	/**captainNameMenu
	 * displays a menu for setting the Captain's name. 
	 *
	 * @author jcbrough
	 */
	private void captainNameMenu() {
		@SuppressWarnings("resource") //Known bug. in should never be in.close()ed. 
		Scanner in = new Scanner(System.in); 
		
		headerPrint(); 
		System.out.println("A new captain! What's your name?");
		String response = in.nextLine();

		captain.setName(response);

		System.out.println("Thank you, Captain " + captain.getName() + "!");
	}

	/**
	 * Method: loadThisGameElements
	 * Description: Pulls saved planetArrayList and captain object from game object to current Game Controllers Attributes.
	 * Author: Kenny
	 */
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
	public void planetSelectionMenu(int numberOfPlanets) {
		System.out.println("Planet Selection Start");
		boolean planetSelectionNotComplete = true;
		ArrayList<Planet> planetChoices = new ArrayList<>();
		planetChoices = randomPlanets(numberOfPlanets);

		while (planetSelectionNotComplete) {
			System.out.println("What is our first destination, Captain " + captain.getName() + "?");
			System.out.println("Based on our current position, these are our options: ");
			for (Planet thisPlanet : planetChoices) {
				System.out.println("		" + thisPlanet.getPlanetName());
			}
			System.out.println("Please type the EXACT NAME of the planet you'd like to visit: ");
			listener();
			nl(1);
			for (Planet selectedPlanet : planetChoices) {
				if (userInput.contains(removeNonWords(selectedPlanet.getPlanetName()))) {
					currentPlanet = selectedPlanet;
					selectedPlanet.setPlanetExplored(true);
					System.out.println("Thank you, Captain!");
					System.out.println("You have chosen to go to " + selectedPlanet.getPlanetName() + "! BOLDLY GOING NOW, CAPTAIN!!!");
					planetSelectionNotComplete = false;
					planetMenu(selectedPlanet);

				} else if (planetChoices.indexOf(selectedPlanet) < planetChoices.size() - 1) {
					helpChoice();
					//continue for loop
				} else {
					genericInputFailure();
				}
			}
		}


	}

	/**
	 * Method: randomPlanets
	 * Description: picks randomized planets from available planetArrayList
	 * author: Kenny
	 *
	 * @param numberOfPlanets
	 * @return ArrayList
	 */
	public ArrayList<Planet> randomPlanets(int numberOfPlanets) {

		boolean randomPlanetNotComplete = true;
		ArrayList<Planet> randomPlanets = new ArrayList<>();
		int count = 0;
		Random rand = new Random();
		int randomNumber;

		while (randomPlanetNotComplete) {
			randomNumber = rand.nextInt(planetArrayList.size());
			for (Planet p : planetArrayList) {

				if (count == numberOfPlanets) {
					randomPlanetNotComplete = false;
					break;
				} else if (!p.isPlanetExplored() && randomNumber == planetArrayList.indexOf(p) &&
						!randomPlanets.contains(p)) {
					randomPlanets.add(p);
					count++;
				}
			}
		}
		return randomPlanets;
	}

	public void planetMenu(Planet planet) {
		headerPrint();
		nl(1);
		System.out.println("TODO Displaying planet menu with planet" + planet.getPlanetName());
		//TODO Planet Menu
	}

	public void helpMenu() {
		//TODO Help Menu
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
	public String loadGameMenu(String fileName) {
		System.out.println("TODO loadGameMenu. Which game would you like to load?");
		//selectedGame should be the saved game that the player chooses. This is just filler.
		Game selectedGame = new Game();
		if (selectedGame.getNumPreviousSaves() <= 3) {
			System.out.println("Sorry, Captain! You're too old for active duty!");
			titleScreen();
		}
		return System.getProperty("user.home") + "\\Desktop\\" + Game.getExtension();
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

	public void crewSelectionMenu() {
		ArrayList<String> selectedCrew = new ArrayList<String>(); 	

			headerPrint();
			System.out.println("Captain! You must select a crew! You can only choose three!"); //Yeah, I made that up.
			System.out.println("Here is a list of currently unassigned crew:");
		for (String s : captain.getFullCrewList()) {
				System.out.println("		" + s + "?");
			}
			
			System.out.println("The rest of the officers of SuperElite StarFleet have been disqualified for active duty for a felony involving a can of pureed pumpkin.");
			System.out.println("Please type three crew members, and press enter between each one!");
		System.out.println("You must type their names EXACTLY, or I don't be able to understand you finger-accent.");
			nl(1); 
			for (int i = 0; i <= 2; i++) {
				selectedCrew.add(in.nextLine());
			}

		//Confirm selection.
		if (captain.confirmCrew(selectedCrew)) {
			captain.setCaptainCrew(selectedCrew);
			captain.getAttributesToCrew();
			}

			else{
				System.out.println("Something screwed up, captain! Let's do that again!");
			crewSelectionMenu();
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
	 *Author: Kenny
	 * @param input String to test userInput against.
	 * @return boolean if userInput matches @param input
	 */
	public boolean booleanMaker(String input) {
		return userInput.contains(removeNonWords(input)) || userInput.compareTo(removeNonWords(input.substring(0, 1))) == 0;
		//|| userInput.contains(input.substring(0, input.indexOf(" ")));

	}
	
	/**
	 * Method: genericInputFailure()
	 * Prints a generic failure message.
	 *
	 * @return void
	 * @author kenny, jcbrough
	 */
	public void genericInputFailure() {
		System.out.println("Input failure!");

	}

	/**
	 * Method: helpChoice()
	 * Checks for userInput of Help and then displays Help Menu
	 *
	 * @return void
	 * @author kenny, jcbrough
	 */
	public void helpChoice(){
		if (booleanMaker("Help")) {
			helpMenu();
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



	/**
	 * @return the thisGame
	 */
	public Game getThisGame() {
		return thisGame;
	}



	/**
	 * @param thisGame the thisGame to set
	 */
	public void setThisGame(Game thisGame) {
		this.thisGame = thisGame;
	}
}
