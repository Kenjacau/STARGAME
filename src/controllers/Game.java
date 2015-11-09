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
	private Captain captain = new Captain(); 
	private ArrayList<Enemy> bossesBeat; 
	private ArrayList<Puzzle> puzzlesSolved;
	private ArrayList<String> crew;
	private ArrayList<Planet> planets; 
	private static int numPreviousSaves;
	private static final String EXTENSION = ".ser"; 
	
	/**Game()
	 * CONSTRUCTOR
	 * @param captain The captain playing the game. 
	 * @param planetsVisisted The planets the captain has visited. 
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
	 * @return the bossesBeat
	 */
	public ArrayList<Enemy> getBossesBeat() {
		return bossesBeat;
	}
	/**
	 * @param bossesBeat the bossesBeat to set
	 */
	public void setBossesBeat(ArrayList<Enemy> bossesBeat) {
		this.bossesBeat = bossesBeat;
	}
	/**
	 * @return the puzzlesSolved
	 */
	public ArrayList<Puzzle> getPuzzlesSolved() {
		return puzzlesSolved;
	}
	/**
	 * @param puzzlesSolved the puzzlesSolved to set
	 */
	public void setPuzzlesSolved(ArrayList<Puzzle> puzzlesSolved) {
		this.puzzlesSolved = puzzlesSolved;
	}

	/**
	 * @return the crew
	 */
	public ArrayList<String> getCrew() {
		return crew;
	}

	/**
	 * @param crew the crew to set
	 */
	public void setCrew(ArrayList<String> crew) {
		this.crew = crew;
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

	/**
	 * @param planets the planets to set
	 */
	public void setPlanets(ArrayList<Planet> planets) {
		this.planets = planets;
	}
	
	public static Game loadGame (String path) throws IOException {
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
		 }
		 
		 else {
			 //TODO: Create the file and write.
		 }
	}

	/**
	 * @return the extension
	 */
	public static String getExtension() {
		return EXTENSION;
	}
}
