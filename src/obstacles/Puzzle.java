package obstacles;

/**
 * Class: Puzzle
 * Description: Attributes and methods for a Puzzle object.
 *
 * @author Kenny Cauthen
 * @version 0.0.1 11/5/2015
 *          Course: ITEC 3860 Fall 2015
 *          Assignment: Final Project
 */
public class Puzzle {
	private String puzzleHint = "";
	private String[] puzzleChoices;
	private String[] puzzleChoiceMessages;
	private String puzzleHomePlanet;

	public Puzzle() {

	}

	/**
	 * Constructor:Puzzle
	 * Description: creates Puzzle object with Attributes
	 * 
	 * @author Kenny
	 */
	public Puzzle(String homePlanet, String hint, String[] choices, String[] choiceMessages) {
		puzzleHomePlanet = homePlanet;
		puzzleHint = hint;
		puzzleChoices = choices;
		puzzleChoiceMessages = choiceMessages;
	}

	/**
	 * Method: getPuzzleHomePlanet()
	 * Description: return puzzle's home planet name
	 *
	 * @return puzzleHomePlanet name of planet the puzzle is associated with
	 * 
	 * @author Kenny
	 */
	public String getPuzzleHomePlanet() {
		return puzzleHomePlanet;
	}

	/**
	 * Method: getPuzzleHint()
	 * Description: returns the string value of the player hint for the puzzle
	 *
	 * @return puzzleHint
	 * 
	 * @author Kenny
	 */
	public String getPuzzleHint() {
		return puzzleHint;
	}

	/**
	 * Method: getPuzzleChoices()
	 * Description: returns the string array of player choices for the puzzle
	 *
	 * @return puzzleChoices
	 * 
	 * @author Kenny
	 */
	public String[] getPuzzleChoices() {
		return puzzleChoices;
	}

	/**
	 * Method: getPuzzleChoiceMessages
	 * Description: returns the string array of resulting messages for the choices
	 * the player might choose.
	 * @return puzzleChoiceMessages
	 * 
	 * @author Kenny
	 */
	public String[] getPuzzleChoiceMessages() {
		return puzzleChoiceMessages;
	}

}
