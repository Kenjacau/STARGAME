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

	private final String[] puzzleDescriptionArray = {"TestP 1 Description Message", "TestP 2 Description Message",
			"TestP 3 Description Message"};
	private final String[] puzzleHintArray = {"TestP 1 Hint Message", "TestP 2 Hint Message", "TestP 3Hint Message"};
	private final String[] puzzleChoices = {"testchoice1a", "testchoice1b", "testchoice2a", "testchoice2b",
			"testchoice3a", "testchoice3b", "testchoice3c"};
	private final String[] puzzleChoiceResultMessages = {"testchoiceResult1a", "testchoiceResult1b", "testchoiceResult2a",
			"testchoiceResult2b", "testchoiceResult3a", "testchoiceResult3b"};
	ArrayList<Puzzle> puzzleArrayList = new ArrayList<>();
	private ArrayList<String[]> puzzleChoiceList;

	private ArrayList<String[]> puzzleChoiceResultMessageList;

	/**
	 * Constructor: PuzzleMaker()
	 * Description: main constructor for creating all Puzzles and adding them to an ArrayList of Puzzles
	 */
	public PuzzleMaker() {
		puzzleChoiceList = puzzleArrayListGenerator(puzzleChoices, 3);
		puzzleChoiceResultMessageList = puzzleArrayListGenerator(puzzleChoiceResultMessages, 0);

		Collections.addAll(puzzleArrayList,
				new Puzzle("51 Pegasi b", puzzleDescriptionArray[0], puzzleHintArray[0]
						, puzzleChoiceList.get(0), puzzleChoiceResultMessageList.get(0)),
				new Puzzle("LV-426", puzzleDescriptionArray[1], puzzleHintArray[1]
						, puzzleChoiceList.get(1), puzzleChoiceResultMessageList.get(1)),
				new Puzzle("Shadowfax", puzzleDescriptionArray[2], puzzleHintArray[2]
						, puzzleChoiceList.get(2), puzzleChoiceResultMessageList.get(2))

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

	/**
	 * Method: puzzleArrayListGenerator
	 * Description: creates and returns an ArrayList from an array of String values.
	 *
	 * @param list
	 * @param rowWithThreeChoices
	 * @return ArrayList of String array, tempArrayList
	 */
	private ArrayList<String[]> puzzleArrayListGenerator(String[] list, int rowWithThreeChoices) {
		ArrayList<String[]> tempArrayList = new ArrayList<>();
		int count = 0;
		String[] temp2 = new String[2];
		String[] temp3 = new String[3];

		for (int i = 0; i < list.length; i += 2) {
			if (rowWithThreeChoices == 0) {
				temp2[0] = list[i];
				temp2[1] = list[i + 1];
				count++;
				tempArrayList.add(temp2);
			} else if (count != rowWithThreeChoices - 1) {
				temp2[0] = list[i];
				temp2[1] = list[i + 1];
				count++;
				tempArrayList.add(temp2);
				//System.out.println(list[i]);
				//System.out.println(list[i+1]);

			} else {
				temp3[0] = list[i];
				temp3[1] = list[i + 1];
				temp3[2] = list[i + 2];
				count++;
				tempArrayList.add(temp3);
				//System.out.println(list[i]);
				//System.out.println(list[i+1]);
				//System.out.println(list[i+2]);
				i++;
			}
		}
		return tempArrayList;
	}
}




