package controllers;

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
	private String saveGameName = ""; 
	private static ArrayList<Planet> planetsVisited = new ArrayList<Planet>(); 
	private static ArrayList<Enemy> bossesDefeated = new ArrayList<Enemy>(); 
	private static String captainName; 
	private int numPreviousSaves; 

	/**writeOutData()
	 * Writes savegame data to a file. 
	 * @param path Path to which to write the file. 
	 * @return void
	 */
	public static void writeOutData(String path) throws IOException {
	
	}
	
	/**readInData()
	 * Reads savegame data in for game start.  
	 * @param path Path to which to write the file. 
	 * @return void
	 */
	public static void readInData(String path) throws IOException {
		//TODO: Read in current number of saves.
		//TODO: Read in captain's name and set it. 
		//TODO: Read in captain's crew and set them.
		//TODO: Read in Planets Visited and set them.
		//TODO: Read in Bosses defeated and set them.
	}
	
	/**addVisistedPlanet()
	 * Adds a visited planet to the private array. 
	 * @param planet Planet to add. 
	 * @return void
	 */
	public static void addVisistedPlanet(Planet planet) {
		planetsVisited.add(planet); 
	}
	
	/**addBossDefeated()
	 * Adds a defeated boss to the private array. 
	 * @param enemy Enemy to add. 
	 * @return void
	 */
	public static void addBossDefeated(Enemy enemy) {
		bossesDefeated.add(enemy); 
	}
	/**
	 * @return the planetsVisited
	 */
	public static ArrayList<Planet> getPlanetsVisited() {
		return planetsVisited;
	}

	/**
	 * @param planetsVisited the planetsVisited to set
	 */
	public static void setPlanetsVisited(ArrayList<Planet> planetsVisited) {
		SaveGame.planetsVisited = planetsVisited;
	}

	/**
	 * @return the bossesDefeated
	 */
	public static ArrayList<Enemy> getBossesDefeated() {
		return bossesDefeated;
	}

	/**
	 * @param bossesDefeated the bossesDefeated to set
	 */
	public static void setBossesDefeated(ArrayList<Enemy> bossesDefeated) {
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
}
