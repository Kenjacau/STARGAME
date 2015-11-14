package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

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
public class GameController2 {
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
	public void titleScreen() {
		boolean titleNotComplete = true;

		headerPrint();
		System.out.println("Space Game Title");
		nl(1);
		System.out.println("Welcome to the world, Captain. Here are your options.");
		nl(1);

		while (titleNotComplete) {
			System.out.println("New Game(N)  :  Load Game(L)  :  Exit Game(E)  :  Help Menu(H)");
			wWJD();
			nl(1);
			listener();
			if (booleanMaker("New Game")) {
				//Construct New game object.
				thisGame = new Game();
				thisGame.setNumPreviousSaves(0);
				loadThisGameElements(thisGame);

				//Set Captain's Crew through menu
				crewSelectionMenu(captain);
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
			} else if (booleanMaker("Help Menu")) {
				//TODO Help Menu
				helpMenu();

			} else {
				inputFailureMessage();
			}
		}
		headerPrint();
		System.out.println("Let's get started Captain!");
		if (currentPlanet != null) {
			planetMenu(currentPlanet);
		} else
			planetSelectionMenu();
	}

	public void loadThisGameElements(Game thisGame) {
		captain = thisGame.getCaptain();
		planetArrayList = thisGame.getPlanets();

		if (thisGame.getCurrentPlanet() != null) {
			currentPlanet = thisGame.getCurrentPlanet();
		}

	}

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


	public void crewSelectionMenu(Captain captain) {
		//TODO Menu for crewSelection that returns ArrayList
		ArrayList<String> newCrew = new ArrayList<>();


		//Ending Statement
		captain.setCaptainCrew(newCrew);
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
		return (string.replaceAll("//W", "")).toLowerCase();
	}

	public void headerPrint() {
		nl(1);
		System.out.println("==================================================================");
		nl(1);
	}

	public void wWJD() {
		System.out.println("------------------------------------------------------------------");
		System.out.println("What would you like to do?");
	}

	/**
	 * Method: nl()
	 * Description: goes to next line @param number of times.
	 *
	 * @param numberOfNextLines
	 */
	public void nl(int numberOfNextLines) {
		for (int i = 0; i < numberOfNextLines; i++) {
			System.out.println();
		}

	}

	public void listener() {
		userInput = removeNonWords(in.nextLine());
	}

	/**
	 * Method: booleanMaker()
	 * Description: Takes in a String input and converts tests whether userInput contains the whole
	 * String or the first char.
	 *
	 * @param input String to test userInput against.
	 * @return boolean if userInput matches @param input
	 */
	public boolean booleanMaker(String input) {
		return userInput.contains(removeNonWords(input)) || userInput.contains((removeNonWords(input.substring(0, 1)))) ||
				userInput.contains(input.substring(0, input.indexOf(" ")));

	}

	public void inputFailureMessage() {
		System.out.println("Please try your entry again...");
	}


}
