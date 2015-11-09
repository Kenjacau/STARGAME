package controllers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import obstacles.Enemy;
import obstacles.Planet;
import obstacles.Puzzle;
import playerCharacter.Captain;
import controllers.Game; 

/*
Class: SaveGame
The SaveGame class houses all functionality for saving and loading games.  
- Author: @jbroughton
- joshua.c.broughton@gmail.com, jbroughton@ggc.edu
- Version: 0.0.2
- 2015-11-04    
*/
public class SaveGame {
	private final static String EXTENSION = ".ser"; 
	private final static String PATH = System.getProperty("user.home") + "\\Desktop\\";
	private String saveGameName = ""; 
	private ArrayList<Planet> planetsVisited; 
	private ArrayList<Enemy> bossesBeat; 
	private ArrayList<Puzzle> puzzlesSolved; 
	private ArrayList<String> crew; 
	private Captain captain; 
	private int numPreviousSaves; 
	
	/**SaveGame()
	 * Full constructor for the save game object.
	 * @param fileName The name of the file. 
	 * @param captainName The name of the captain. 
	 * @param planetsVisited The planets visited by the captain in previous games. 
	 * @param bossesBeat The bosses defeated by the captain in previous games. 
	 * @param crew 
	 * @return void
	 */
	public SaveGame (String fileName, Captain captain, ArrayList<Planet> planetsVisited, ArrayList<Enemy> bossesBeat, ArrayList<String> crew) {
		String fullPath = getPATH().concat(fileName + SaveGame.getEXTENSION());
		this.captain = captain; 
		this.setPlanetsVisited(planetsVisited);
		this.setBossesBeat(bossesBeat); 
		this.setCrew(crew); 
	}
	
	/**SaveGame()
	 * One-arg constructor for the save game object.
	 * @param fileName The name of the file. Sits on the desktop, the extension will be EXTENSION. 
	 * @return void
	 */
	public SaveGame (String fileName) {
		
	}
	
	/**writeOutData()
	 * Writes savegame data to a file. 
	 * @param path Path to which to write the file. 
	 * @return void
	 */
	public static void writeOutData(SaveGame thisGame, String path) throws IOException {
		 File saveGame = new File(path); 
		 if (saveGame.exists()) {
			 //TODO: Clear the file and rewrite.
		 }
		 
		 else {
			 //TODO: Create the file and write.
		 }
	
	}
	
	/**readInData()
	 * Reads save game data in for game start.  
	 * @param path Path to which to read the file. 
	 * @return void
	 */
	public static Game readInData(String path) throws IOException {
		//TODO: Read in these from the file. Blanks for now. 
		Captain captain = new Captain(); 
		ArrayList<Planet> planetsVisisted = new ArrayList<Planet>(); 
		ArrayList<Enemy> bossesBeat = new ArrayList<Enemy>();
		ArrayList<Puzzle> puzzlesSolved = new ArrayList<Puzzle>();
		ArrayList<String> crew =  new ArrayList<String>(); 
		
		//Construct game object. 
		Game game = new Game(captain, planetsVisisted, bossesBeat, puzzlesSolved, crew); 
		 
		return game; 
	}
	
	/**
	 * @return the PATH
	 */
	public static String getPATH() {
		return PATH;
	}

	/**
	 * @return the numPreviousSaves
	 */
	public int getNumPreviousSaves() {
		return numPreviousSaves;
	}

	/**
	 * @return the saveGameName
	 */
	public String getSaveGameName() {
		return saveGameName;
	}

	/**
	 * @param saveGameName the saveGameName to set
	 */
	public void setSaveGameName(String saveGameName) {
		this.saveGameName = saveGameName;
	}

	/**
	 * @param numPreviousSaves the numPreviousSaves to set
	 */
	public void setNumPreviousSaves(int numPreviousSaves) {
		this.numPreviousSaves = numPreviousSaves;
	}

	/**
	 * @return the extension
	 */
	public static String getEXTENSION() {
		return EXTENSION;
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
	
	/**getFullPath
	 * STATIC METHOD
	 * Returns a concatenation of the path, captain's name and file extension. 
	 * Note: added for ease of maintenance later... devs can change the savegame path to whatever using this method. 
	 * @return fullPath A string like this: 
	 * 		C:/users/<current user>/CaptainsName.ser
	 */
	public String getFullPath() {
		String fullPath = getPATH().concat(getCaptain().getCaptainName()); 
		fullPath = fullPath.concat(getEXTENSION()); 
		return fullPath; 
	}
	
	/**
	 * @return puzzles solved
	 */
	public ArrayList<Puzzle> getPuzzlesSolved() {
		// TODO Auto-generated method stub
		return null;
	}

	public Captain getCaptain() {
		// TODO Auto-generated method stub
		return captain;
	}

	/**
	 * @param planetsVisited the planetsVisited to set
	 */
	public void setPlanetsVisited(ArrayList<Planet> planetsVisited) {
		this.planetsVisited = planetsVisited;
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
	 * @param puzzlesSolved the puzzlesSolved to set
	 */
	public void setPuzzlesSolved(ArrayList<Puzzle> puzzlesSolved) {
		this.puzzlesSolved = puzzlesSolved;
	}
}
