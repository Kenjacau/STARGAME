package testers;

import java.io.IOException;
import java.util.ArrayList;

import controllers.Game;
import obstacles.Planet;
import playerCharacter.Captain;

/**
Class: GameClassTester
The GameController class is the primary controller, featuring the interfaces, the runnables and the starting point for the game. 
- Author: @jbroughton
- joshua.c.broughton@gmail.com, jbroughton@ggc.edu
- Version: 0.0.0
- 2015-11-03    
*/
public class GameClassTester {
	private final static int NUM_OF_PLANETS = 30; //Provided for ease of changing. 
	
	/**main()
	 * STATIC METHOD
	 * This serves as the starting point for the GameController class.
	 * @param args Command line arguments
	 * @throws IOException
	 */
	public static void main(String[] args) {
		//Start a game and run tests on it. 
		Captain captain = new Captain(); 
		ArrayList<Planet> planetList = new ArrayList<Planet>(); 
		Game game = new Game(captain, planetList); 
		
		if (game.getCaptain() == null) {
			throw new IllegalArgumentException("Captain was null.");
		}
		if (game.getPlanets().size() != NUM_OF_PLANETS) {
			if (game.getPlanets().size() < NUM_OF_PLANETS) {
				throw new IllegalArgumentException("Too few planets.");
			}
			
			else if (game.getPlanets().size() > NUM_OF_PLANETS) {
				throw new IllegalArgumentException("To many planets.");
			}
		}
	}

}
