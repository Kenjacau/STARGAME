package controllers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import obstacles.*;
import playerCharacter.*; 


/*
Class: SaveGame
The SaveGame class houses all functionality for saving and loading games.  
- Author: @jbroughton
- joshua.c.broughton@gmail.com, jbroughton@ggc.edu
- Version: 0.0.2
- 2015-11-04    
*/
public class SaveGame {
	private final static String PATH = System.getProperty("user.home") + "\\Desktop\\";
	private final static String EXTENSION = ".ser"; 
	private String saveGameName = ""; 
	private static ArrayList<String> planetsVisited = new ArrayList<String>(); 
	private static ArrayList<String> bossesDefeated = new ArrayList<String>(); 
	private static ArrayList<String> crew = new ArrayList<String>(); 
	private static String captainName; 
	private int numPreviousSaves; 
	
	/**SaveGame()
	 * Full constructor for the save game object.
	 * @param fileName The name of the file. 
	 * @param captainName The name of the captain. 
	 * @param planetsVisited The planets visited by the captain in previous games. 
	 * @param bossesDefeated The bosses defeated by the captain in previous games. 
	 * @param crew 
	 * @return void
	 */
	public SaveGame (String fileName, String captainName, ArrayList<String> planetsVisited, ArrayList<String> bossesDefeated, ArrayList<String> crew) {
		String fullPath = getPATH().concat(fileName + SaveGame.getEXTENSION());
		this.captainName = captainName; 
		this.planetsVisited = planetsVisited;
		this.bossesDefeated = bossesDefeated; 
		this.crew = crew; 
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
	public static void writeOutData(String path) throws IOException {
	
	}
	
	/**readInData()
	 * Reads save game data in for game start.  
	 * @param path Path to which to read the file. 
	 * @return void
	 */
	public static SaveGame readInData(String path) throws IOException {
		File saveGameFile = new File(path); 
		String fileName = ""; 
		String captainName = ""; 
		ArrayList<String> planetsVisited = new ArrayList<String>(); 
		ArrayList<String> bossesDefeated = new ArrayList<String>();
		ArrayList<String> crew = new ArrayList<String>(); 
		
		//TODO: Read in current number of saves.
		//TODO: Read in captain's name and set it. 
		//TODO: Read in captain's crew and set them.
		//TODO: Read in Planets Visited and set them.
		//TODO: Read in Bosses defeated and set them.
		
		SaveGame returningCaptain = new SaveGame(fileName, captainName, planetsVisited, bossesDefeated, crew);
		return returningCaptain; 
		
	}
	
	/**addVisistedPlanet()
	 * Adds a visited planet to the private array. 
	 * @param planet Planet to add. 
	 * @return void
	 */
	public static void addVisistedPlanet(String planetName) {
		planetsVisited.add(planetName); 
	}
	
	/**addBossDefeated()
	 * Adds a defeated boss to the private array. 
	 * @param enemy Enemy to add. 
	 * @return void
	 */
	public static void addBossDefeated(String enemyName) {
		bossesDefeated.add(enemyName); 
	}
	/**
	 * @return the planetsVisited
	 */
	public static ArrayList<String> getPlanetsVisited() {
		return planetsVisited;
	}

	/**
	 * @param planetsVisited the planetsVisited to set
	 */
	public static void setPlanetsVisited(ArrayList<String> planetsVisited) {
		SaveGame.planetsVisited = planetsVisited;
	}

	/**
	 * @return the bossesDefeated
	 */
	public static ArrayList<String> getBossesDefeated() {
		return bossesDefeated;
	}

	/**
	 * @param bossesDefeated the bossesDefeated to set
	 */
	public static void setBossesDefeated(ArrayList<String> bossesDefeated) {
		SaveGame.bossesDefeated = bossesDefeated;
	}

	/**
	 * @return the captainName
	 */
	public static String getCaptainName() {
		return captainName;
	}

	/**
	 * @param captainName the captainName to set
	 */
	public static void setCaptainName(String captainName) {
		SaveGame.captainName = captainName;
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
	public static ArrayList<String> getCrew() {
		return crew;
	}

	/**
	 * @param crew the crew to set
	 */
	public static void setCrew(ArrayList<String> crew) {
		SaveGame.crew = crew;
	}

}
