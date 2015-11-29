package testers;

import obstacles.Planet;
import obstacles.PlanetMaker;
import obstacles.Puzzle;
import obstacles.PuzzleMaker;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class: PuzzleClassTester
 * Description:
 *
 * @author Kenny Cauthen
 *         kcauthen@ggc.edu
 * @version 0.0.1, 11/14/2015
 *          Course: ITEC 3150 Fall 2015
 *          Assignment: Final Project
 */
public class PuzzleClassTester {
	private Scanner in = new Scanner(System.in);
	private String userInput = "";
	private ArrayList<Puzzle> allPuzzles = new PuzzleMaker().getPuzzleArrayList();
	private ArrayList<Planet> testPlanets = new PlanetMaker().getPlanetArrayList();

	public static void main(String[] args) {
		PuzzleClassTester newPuzzleTest = new PuzzleClassTester();

		newPuzzleTest.printAllPuzzleAttributes();
		newPuzzleTest.solveThreePuzzles();

	}

	public void printAllPuzzleAttributes() {
		for (Puzzle p : allPuzzles) {
			for (String s : p.getPuzzleChoices()) {
				System.out.println(s);
			}
			for (String st : p.getPuzzleChoiceMessages()) {
				System.out.println(st);
			}
			System.out.println(p.getPuzzleHint());
			System.out.println(p.getPuzzleHomePlanet());
		}
	}

	public void solvePuzzle(Planet planetPuzzle) {
		for (Planet p : testPlanets) {
			System.out.println(p.getPlanetName());
		}
		boolean puzzleNotSolved = true;
		Puzzle thisPuzzle = new Puzzle();

		for (Puzzle p : allPuzzles) {
			if (removeNonWords(p.getPuzzleHomePlanet()).contains(removeNonWords(planetPuzzle.getPlanetName()))) {
				thisPuzzle = p;
			}
		}

		headerPrint();


		while (puzzleNotSolved) {
			choicesString();
			for (String s : thisPuzzle.getPuzzleChoices()) {
				System.out.print(" :: " + s);
			}
			wWJD();
			listener();


			switch (removeNonWords(planetPuzzle.getPlanetName())) {
				case "51pegasib":
				case "lv426":

					if (booleanMaker(thisPuzzle.getPuzzleChoices()[0])) {
						System.out.println(thisPuzzle.getPuzzleChoiceMessages()[0]);
						System.out.println("Choice 1 Does something");
						puzzleNotSolved = false;

					} else if (booleanMaker(thisPuzzle.getPuzzleChoices()[1])) {
						System.out.println(thisPuzzle.getPuzzleChoiceMessages()[1]);
						System.out.println("Choice 2 Does something else");
						puzzleNotSolved = false;

					} else {
						genericHelpOrInputFailure();
					}
					break;

				case "shadowfax":
					if (booleanMaker(thisPuzzle.getPuzzleChoices()[0])) {
						System.out.println(thisPuzzle.getPuzzleChoiceMessages()[0]);
						System.out.println("Choice 1 Does something");
						puzzleNotSolved = false;

					} else if (booleanMaker(thisPuzzle.getPuzzleChoices()[1]) ||
							booleanMaker(thisPuzzle.getPuzzleChoices()[2])) {
						System.out.println(thisPuzzle.getPuzzleChoiceMessages()[1]);
						System.out.println("Choice 2 Does something else");
						puzzleNotSolved = false;

					} else {
						genericHelpOrInputFailure();

					}
					break;

			}
		}

	}

	public void solveThreePuzzles() {
		//51 Pegasi B testPuzzle 1
		solvePuzzle(testPlanets.get(0));
		//LV426 testPuzzle 2
		solvePuzzle(testPlanets.get(1));
		//ShadowFax testPuzzle 3
		solvePuzzle(testPlanets.get(2));
	}

	//Menu Making Helper Methods//

	/**
	 * Method: removeNonWords()
	 *
	 * @param string String that you want to remove all whitespace and non word characters from.
	 * @return string with all non word characters including whitespace removed
	 * Last Edit: Kenny Cauthen
	 * Remarks:
	 */
	public String removeNonWords(String string) {
		return (string.replaceAll("[^\\p{L}\\p{Nd}]+", "")).toLowerCase();
	}

	/**
	 * Method: headerPrint()
	 * Prints a header thingy.
	 *
	 * @return void
	 * @author kenny
	 */
	public void headerPrint() {
		nl(1);
		System.out.println("==================================================================");
		nl(1);
	}

	public void choicesString() {
		System.out.println("------------------------------------------------------------------");
		System.out.println("Here are your choices:");
		nl(1);
	}


	/**
	 * Method: wWJD()
	 * Description: Print statement requesting next command.
	 *
	 * @return void
	 * @author kenny
	 */
	public void wWJD() { //HAHAHAHA!!! WWJD, really? Fuck me running. -JCB
		nl(1);
		System.out.println("------------------------------------------------------------------");
		System.out.println("What would you like to do?");
	}

	/**
	 * Method: nl()
	 * Description: goes to next line @param number of times.
	 *
	 * @param numberOfNextLines
	 * @author kenny
	 */
	public void nl(int numberOfNextLines) {
		for (int i = 0; i < numberOfNextLines; i++) {
			System.out.println();
		}

	}

	/**
	 * Method: listener()
	 * Description: Takes in user input, removes all non-words and whitespace, then sets the final value to userInput.
	 *
	 * @return void
	 * @author kenny
	 */
	public void listener() {
		userInput = removeNonWords(in.nextLine());
	}

	/**
	 * Method: booleanMaker()
	 * Description: Takes in a String input and converts tests whether userInput contains the whole
	 * String, first char, or just the first word.
	 * <p>
	 * Example: booleanMaker("Exit Menu") <-- will be true if input is "Exit Menu", "Exit", or E
	 *
	 * @param input String to test userInput against.
	 * @return boolean if userInput matches @param input
	 */
	public boolean booleanMaker(String input) {
		return userInput.contains(removeNonWords(input)) || userInput.contains((removeNonWords(input.substring(0, 1)))) ||
				userInput.contains(input.substring(0, input.indexOf(" ")));

	}

	/**
	 * Method: genericHelpOrInputFailure()
	 * If userInput contains Help then display help menu. Else, prints a generic failure message.
	 *
	 * @return void
	 * @author kenny, jcbrough
	 */
	public void genericHelpOrInputFailure() {
		if (booleanMaker("Help")) {
			System.out.println("Displaying Help Menu");
		} else {
			System.out.println("Input failure!");
		}
	}

	/**
	 * Method: inputFailure()
	 * Prints a failure based on passed parameters
	 *
	 * @return void
	 * @author jcbrough
	 * <p>
	 * Use case:
	 * String garbage = in.nextline();
	 * if (garbage != validInput) {
	 * inputFailure("Hey, Captain! " + garbage.toUpperCase() + " is not a valid input!");
	 * tryInputAgain();
	 * }
	 */
	public void inputFailure(String message) {
		System.out.println(message);
	}
}




