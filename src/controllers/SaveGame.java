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
- Version: 0.0.0
- 2015-11-03    
*/
public class SaveGame {
	private final String PATH = ""; 
	private static ArrayList<Planet> planetsVisited = new ArrayList<Planet>(); 
	private static ArrayList<Enemy> bossesDefeated = new ArrayList<Enemy>(); 
	private static String playerName; 
	
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
		
}
