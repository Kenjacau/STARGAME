package testers;

import java.io.IOException;
import java.util.ArrayList;

import controllers.Game;
import obstacles.Planet;
import playerCharacter.Captain;

/**
Class: GameClassTester
The GameClassTester tests the Game object.
- Author: @jbroughton
- joshua.c.broughton@gmail.com, jbroughton@ggc.edu
- Version: 0.0.0
- 2015-11-03    
*/
public class GameClassTester {
	private final static int NUM_OF_PLANETS = 30; //Provided for ease of changing. 
	
	/**testHasCaptain()
	 * Tests to see if the captain object is null. 
	 * @param game A game object.
	 * @return Flag for a passing test. 
	 */
	public Boolean testHasCaptain(Game game) {
		if (game.getCaptain() == null) {
			throw new IllegalArgumentException("Captain was null.");		
		}
		else {
			return true; 
		}
	}
	
	/**testHasPlanets()
	 * Tests to see if the game object has the correct number of planets. 
	 * @param game A game object.
	 * @return Flag for a passing test. 
	 */
	public Boolean testHasPlanets(Game game) {
		if (game.getPlanets().size() != NUM_OF_PLANETS) {
			if (game.getPlanets().size() < NUM_OF_PLANETS) {
				throw new IllegalArgumentException("Too few planets in Game class.");
			}

			else if (game.getPlanets().size() > NUM_OF_PLANETS) {
				throw new IllegalArgumentException("Too many planets in Game class.");
			}

			return false; 
		}

		else {
			return true; 
		}
	}
}	
