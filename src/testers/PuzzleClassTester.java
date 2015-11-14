package testers;

import obstacles.Puzzle;
import obstacles.PuzzleMaker;

import java.util.ArrayList;

/**
 * Class: PuzzleClassTester
 * Description:
 *
 * @author Kenny Cauthen
 *         kcauthen@ggc.edu
 * @version 0.0, 11/14/2015
 *          Course: ITEC 3150 Fall 2015
 *          Assignment:
 */
public class PuzzleClassTester {

	public static void main(String[] args) {
		ArrayList<Puzzle> allPuzzles = new PuzzleMaker().getPuzzleArrayList();

		for (Puzzle p : allPuzzles) {
			System.out.println(p.getPuzzleChoiceMessages());
		}

	}


}
