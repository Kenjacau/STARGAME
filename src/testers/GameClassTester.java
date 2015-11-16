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
- Version: 0.0.1
- 2015-11-14   
*/
public class GameClassTester {
	private final static int NUM_OF_PLANETS = 30; //Provided for ease of changing. 
	private Game game; 
	
	/**GameClassTester
	 * CONSTRUCTOR
	 * 
	 * @param _game The game to be tested. 
	 * 
	 * @author jcbrough
	 */
	public GameClassTester(Game _game) {
		this.game = _game; 
	}
	
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
	
	/**testNumPreviousSaves()
	 * Tests to see if the game object has a viable number of previous saves. 
	 * @param game A game object.
	 * @return Flag for a passing test. 
	 */
	public boolean testNumPreviousSaves(Game game) {
		if (game.getNumPreviousSaves() < 0 || game.getNumPreviousSaves() > 2)
			throw new IllegalArgumentException("Illegal number of previous saves.");
		else {
			return true; 
		}
	}
	
	/**testExtension()
	 * Tests to see if the game object has a viable file extension. 
	 * @param game A game object.
	 * @return Flag for a passing test. 
	 */
	public boolean testExtension(Game game) {
		if (game.getExtension().length() <= 0) {
			throw new IllegalArgumentException("No file extension detected!");
		}
		else {
			return true;
		}
	}
	
	/**testLoadGame()
	 * Tests to see if a viable game object loaded from the file system.
	 * @param game A game object.
	 * @return Flag for a passing test. 
	 */
	public boolean testLoadGame(Game game) {
		if (testHasCaptain(game)) {
			if (testHasPlanets(game)) {
				if (testNumPreviousSaves(game)) {
					if (testExtension(game)) {
						return true; 
					}
					else {
						return false;
					}
				}
				else {
					return false;
				}
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
}	
