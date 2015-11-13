package controllers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/*
Class: Game
The Game class is the primary interface between the captian, the planets, the puzzles, the bosses and all that stuff. 
- Author: @jbroughton
- joshua.c.broughton@gmail.com, jbroughton@ggc.edu
- Version: 0.0.0
- 2015-11-03    
*/
import obstacles.Enemy;
import obstacles.Planet;
import obstacles.Puzzle;
import playerCharacter.Captain;

public class Game {
	private static final String EXTENSION = ".ser";
	private static int numPreviousSaves;
	private Captain captain = new Captain();
	private Planet currentPlanet;
	private ArrayList<Planet> planets;

	//private ArrayList<Enemy> bossesBeat;
	//private ArrayList<Puzzle> puzzlesSolved;
	//private ArrayList<String> crew;
	
	/**Game()
	 * CONSTRUCTOR
	 * @param captain The captain playing the game. 
	 * @param planets The planets the captain has visited.
	 */
	public Game(Captain captain, ArrayList<Planet> planets) {
		super();
		this.captain = captain;
		this.planets = planets;
	}
	
	/**
	 * ONE ARG CONSTRUCTOR
	 */
	public Game() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the numPreviousSaves
	 */
	public static int getNumPreviousSaves() {
		return numPreviousSaves;
	}

	/**
	 * @param numPreviousSaves the numPreviousSaves to set
	 */
	public static void setNumPreviousSaves(int numPreviousSaves) {
		Game.numPreviousSaves = numPreviousSaves;
	}

	public static Game loadGame(String path) throws IOException {
		//TODO: Read in these from the file. Blanks for now.
		Captain captain = new Captain();
		ArrayList<Planet> planets = new ArrayList<Planet>();

		//Construct game object.
		Game game = new Game(captain, planets);

		if (game.numPreviousSaves <= 3) {
			System.out.println("Sorry, Captain! You're too old for active duty!");
			System.exit(0);
		}

		return game;
	}

	/**saveGame()
	 * Writes savegame data to a file.
	 * @param path Path to which to write the file.
	 * @return void
	 */
	public static void saveGame(Game thisGame, String path) throws IOException {
		File saveGame = new File(path);
		if (saveGame.exists()) {
			//TODO: Clear the file and rewrite.
		} else {
			//TODO: Create the file and write.
		}
	}

	/**
	 * @return the extension
	 */
	public static String getExtension() {
		return EXTENSION;
	}

	/**
	 * @return the captain
	 */
	public Captain getCaptain() {
		return captain;
	}

	/**
	 * @param captain the captain to set
	 */
	public void setCaptain(Captain captain) {
		this.captain = captain;
	}

	/**
	 * @return planets the planets to get
	 */
	public ArrayList<Planet> getPlanets() {
		return planets;
	}

	/**
	 * @param planets the planets to set
	 */

	public void setPlanets(ArrayList<Planet> planets) {
		this.planets = planets;
	}
}
