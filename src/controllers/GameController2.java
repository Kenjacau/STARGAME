package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import obstacles.Enemy;
import obstacles.Planet;
import obstacles.Puzzle;
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
	
	/**main()
	 * STATIC METHOD
	 * This serves as the starting point for the GameController class.
	 * @param args Command line arguments
	 * @throws IOException
	 */
	public static void main (String[] args) throws IOException {
		 @SuppressWarnings("resource")
		 Scanner in = new Scanner(System.in); 
		 System.out.println("Welcome to the world, Captain. Would  you like to load a savegame? (Y or N) (H for Help)");
		 		 
		 String response = in.nextLine(); 
		 
		 if (response.toLowerCase().equals("y")) {
			 //TODO: Display SaveGame menu that returns a string path. 
			 String path = ""; //TODO: Remove this when menu sys implemented.  
			 Game game = Game.loadGame(System.getProperty("user.home") + "\\Desktop\\" + Game.getExtension()); 
		 }
		 
		 if (response.toLowerCase().equals("h")) {
			 //TODO: Display Help menu. 
		 }
		 
		 else {
			 //TODO: Display Menu for a new Game that returns a Game object.
			 //Create empty arrays for Game constructor. Remove when menu sys implemented.
			 Captain captain = new Captain(); 
			 ArrayList<Planet> planets = new ArrayList<Planet>(); 
			 
			 //Construct game object. 
			 Game game = new Game(captain, planets);
			 
			 //TODO: Display menu for crew selection that returns an ArrayList<String> of the crew. 
			 ArrayList<String> tempCrewArray = new ArrayList<String>(); //TODO: Remove this when menu sys implemented. 
			 game.getCaptain().setCaptainCrew(tempCrewArray);	
			 game.setNumPreviousSaves(0);
		 }
		 
		 System.out.println("Let's get started Captain!");
		 
		 //TODO: Display Planet selection menu. 

		 //TODO: Display Planet menu
		 
		 //TODO: Display Combat menu
		 
	}
	
	//TODO: Static method saveGame
	//TODO: Static method loadGame
}
