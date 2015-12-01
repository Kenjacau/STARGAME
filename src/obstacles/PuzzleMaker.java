package obstacles;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Class: PuzzleMaker
 * Description:
 *
 * @author Kenny Cauthen
 *         kcauthen@ggc.edu
 * @version 0.0.2, 11/5/2015
 *          Course: ITEC 3860 Fall 2015
 *          Assignment: Final Project
 */
public class PuzzleMaker {

	private ArrayList<Puzzle> puzzleArrayList = new ArrayList<>();

	/**
	 * Constructor: PuzzleMaker()
	 * Description: main constructor for creating all Puzzles and adding them to an ArrayList of Puzzles
	 */
	public PuzzleMaker() {
		String[] puzzleChoices = getPuzzleChoices();
		ArrayList<String[]> puzzleChoiceList = puzzleArrayListGenerator(puzzleChoices, 3);
		String[] puzzleChoiceResultMessages = getPuzzleChoiceResultMessages();
		ArrayList<String[]> puzzleChoiceResultMessageList = puzzleArrayListGenerator(puzzleChoiceResultMessages, 0);

		String[] puzzleHintArray = getPuzzleHintArray();
		Collections.addAll(puzzleArrayList,
				new Puzzle("51 Pegasi b", puzzleHintArray[0], puzzleChoiceList.get(0), puzzleChoiceResultMessageList.get(0)),
				new Puzzle("LV-426", puzzleHintArray[1], puzzleChoiceList.get(1), puzzleChoiceResultMessageList.get(1)),
				new Puzzle("Shadowfax", puzzleHintArray[2], puzzleChoiceList.get(2), puzzleChoiceResultMessageList.get(2)),
				new Puzzle("Lisus", puzzleHintArray[3], puzzleChoiceList.get(3), puzzleChoiceResultMessageList.get(3)),
				new Puzzle("Insula", puzzleHintArray[4], puzzleChoiceList.get(4), puzzleChoiceResultMessageList.get(4)),
				new Puzzle("Heralda", puzzleHintArray[5], puzzleChoiceList.get(5), puzzleChoiceResultMessageList.get(5))
		);

	}

	/**
	 * Method: getPuzzleArrayList()
	 * Description: returns all the generated puzzles as an ArrayList of puzzles
	 *
	 * @return puzzleArrayList
	 */
	public ArrayList<Puzzle> getPuzzleArrayList() {
		return puzzleArrayList;
	}

	//List of all puzzle hints. 
	private String[] getPuzzleHintArray() {
		return new String[]{"We may be able to utilize the skilled crew should they survive.",
				"We have to consider why that facility is empty and where everyone went. If you continue be prepared for anything.",
				"Two of these doors appear identical in every way. There’s something strange about the middle door. Its glow seems… foreboding.",
				"This forest looks dangerous but the markings on nearby landmarks suggest that it may have been home to a " +
						"technologically advanced society at some point.",
				"Whoever is inside this domicile may be our only chance to get off this planet in one piece.",
				"Sorry. You're on your own on this one."
		};
	}
	
	//List of all possible puzzle answer choices.
	//Kenny did this. Ask him about the syntax. 
	private String[] getPuzzleChoices() {
		return new String[]{"Abandon", "Rescue", "Leave", "Search", "Left", "Middle", "Right", "Leave", "Stay", "Leave", "Mallet", "Leave", "Device"
		};
	}

	private String[] getPuzzleChoiceResultMessages() {
		return new String[]{"As you abandon the station it explodes...", "The search and rescue mission was a success and you managed to save the entire crew! \n" +
				"The Survey Officer of the station wishes to join your crew",
				"Oh no! Something is heading towards you...You should get your blaster ready", "You found an ARTIFACT!",
				"As you step through the door you notice that you are now back in your ship hovering over the same planet.",
				"As you step through the door your vision goes dark. You awake on the flight deck overlooking a very familiar planet...Earth",
				"You head back to the ship and leave the planet's surface.", "You attempt to navigate the forest...",
				"You had back to the ship and spend a day digging out the ship with your plasma shovel",
				"You take the mallet and strike the door...", "You leave the body and head back to the ship",
				"You head over to the body and grab the device..."
		};
	}

	/**
	 * Method: puzzleArrayListGenerator
	 * Description: creates and returns an ArrayList from an array of String values.
	 *
	 * @param list
	 * @param rowWithThreeChoices
	 * @return ArrayList of String array, tempArrayList
	 * 
	 * @author Kenny
	 */
	private ArrayList<String[]> puzzleArrayListGenerator(String[] list, int rowWithThreeChoices) {
		ArrayList<String[]> tempArrayList = new ArrayList<>();
		int count = 0;

		for (int i = 0; i < list.length; i += 2) {
			String[] temp2 = new String[2];
			String[] temp3 = new String[3];

			if (rowWithThreeChoices == 0) {
				temp2[0] = list[i];
				temp2[1] = list[i + 1];
				tempArrayList.add(temp2);
				count++;
			} else if (count != rowWithThreeChoices - 1) {
				temp2[0] = list[i];
				temp2[1] = list[i + 1];
				tempArrayList.add(temp2);
				count++;

			} else {
				temp3[0] = list[i];
				temp3[1] = list[i + 1];
				temp3[2] = list[i + 2];
				tempArrayList.add(temp3);
				count++;
				i++;
			}
		}
		return tempArrayList;
	}
}