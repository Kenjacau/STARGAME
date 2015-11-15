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
	private String puzzleDescription = "";
	private String puzzleHint = "";
	private String[] puzzleChoices;
	private String[] puzzleChoiceMessages;
	private String puzzleHomePlanet;

	public Puzzle() {

	}

	/**
	 * Constructor:Puzzle
	 * Description: creates Puzzle object with Attributes
	 */
	public Puzzle(String homePlanet, String description, String hint, String[] choices, String[] choiceMessages) {
		puzzleHomePlanet = homePlanet;
		puzzleDescription = description;
		puzzleHint = hint;
		puzzleChoices = choices;
		puzzleChoiceMessages = choiceMessages;

	}

	/**
	 * Method: getPuzzleHomePlanet()
	 * Description: return puzzle's home planet name
	 *
	 * @return puzzleHomePlanet name of planet the puzzle is assoicated with
	 */
	public String getPuzzleHomePlanet() {
		return puzzleHomePlanet;
	}

	/**
	 * Method: getPuzzleDescription()
	 * Description: returns the string value of the description of the puzzle
	 *
	 * @return puzzleDescription
	 */
	public String getPuzzleDescription() {
		return puzzleDescription;
	}

	/**
	 * Method: getPuzzleHint()
	 * Description: returns the string value of the player hint for the puzzle
	 *
	 * @return puzzleHint
	 */
	public String getPuzzleHint() {
		return puzzleHint;
	}

	/**
	 * Method: getPuzzleChoices()
	 * Description: returns the string array of player choices for the puzzle
	 *
	 * @return puzzleChoices
	 */
	public String[] getPuzzleChoices() {
		return puzzleChoices;
	}

	/**
	 * Method: getPuzzleChoiceMessages
	 * Description: returns the string array of resulting messages for the choices
	 * the player might choose.
	 * @return puzzleChoiceMessages
	 */
	public String[] getPuzzleChoiceMessages() {
		return puzzleChoiceMessages;
	}

}
