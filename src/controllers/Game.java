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
import obstacles.PlanetMaker;
import obstacles.Puzzle;
import playerCharacter.Captain;

public class Game {
	private final String EXTENSION = ".ser";
	private int numPreviousSaves;
	private Captain captain = new Captain();
	private Planet currentPlanet;
	private ArrayList<Planet> planets;

	//private ArrayList<Enemy> bossesBeat;
	//private ArrayList<Puzzle> puzzlesSolved;
	//private ArrayList<String> crew;

	//Comment from Kenny: I think the game class should handle all initializing of Captain, Planets and Enemys.
	//                    Same for methods to save those elements to game.
	/**Game()
	 * CONSTRUCTOR
	 * @param newCaptain The captain playing the game.
	 * @param newPlanets The planets the captain has visited.
	 */
	public Game(Captain newCaptain, ArrayList<Planet> newPlanets) {
		super();
		captain = newCaptain;
		planets = newPlanets;
	}
	
	/**
	 * ONE ARG CONSTRUCTOR
	 */
	public Game() {
		captain = new Captain();
		planets = new PlanetMaker().getPlanetArrayList();
		// TODO Auto-generated constructor stub
	}

	public Game(String path) {
		//TODO: Read in these from the file. Blanks for now.

		captain = new Captain();
		planets = new PlanetMaker().getPlanetArrayList();


	}

	/**
	 * @return the numPreviousSaves
	 */
	public int getNumPreviousSaves() {
		return numPreviousSaves;
	}

	/**
	 * @param newNumPreviousSaves the numPreviousSaves to set
	 */
	public void setNumPreviousSaves(int newNumPreviousSaves) {
		numPreviousSaves = newNumPreviousSaves;
	}


	//Edited by: Kenny
	//Comment: If a method is returning a game object from a class constructor, isnt that just a constructor for a game object.
	//         Didnt see when else this method would be used except on loading a game. So created another constructor.
//	public Game loadGame(String path) throws IOException {
//		//TODO: Read in these from the file. Blanks for now.
//		Captain captain = new Captain();
//		ArrayList<Planet> planets = new ArrayList<Planet>();
//
//		//Construct game object.
//		Game game = new Game(captain, planets);
//
//		if (game.numPreviousSaves <= 3) {
//			System.out.println("Sorry, Captain! You're too old for active duty!");
//			System.exit(0);
//		}
//
//		return game;
//	}

	/**saveGame()
	 * Writes savegame data to a file.
	 * @param path Path to which to write the file.
	 * @return void
	 */
	public void saveGame(String path) throws IOException {
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
	public String getExtension() {
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

	public Planet getCurrentPlanet() {
		return currentPlanet;
	}

	public void setCurrentPlanet(Planet currentPlanet) {
		this.currentPlanet = currentPlanet;
	}
}
