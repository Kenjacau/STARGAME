package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import obstacles.*;
import playerCharacter.Captain;
import sun.font.TrueTypeFont;
import testers.GameClassTester;

/*
Class: GameController
The GameController class is the primary controller, featuring the interfaces, the runnables and the starting point for the game. 
- Author: @jbroughton
- joshua.c.broughton@gmail.com, jbroughton@ggc.edu
- Version: 0.0.2
- 2015-11-03    
*/
public class GameController2 {
	// Static constants
	private static final String SPACE_GAME_TITLE = "Super Elite: Space Adventure";
	private static final String SAVE_FILE_EXTENSION = ".ser";
	private static final String DESKTOP_PATH = System.getProperty("user.home") + "\\Desktop\\";

	// Other private variables
	private Game thisGame;
	private Captain captain;
	private ArrayList<Planet> planetArrayList;
	private ArrayList<Puzzle> puzzleArrayList = new PuzzleMaker().getPuzzleArrayList();
	private ArrayList<Enemy> enemyArrayList = new EnemyMaker().getEnemyArrayList();
	private Planet currentPlanet;
	private Scanner in = new Scanner(System.in);
	private String userInput = "";
	private GameClassTester gameTester = new GameClassTester();

	/**
	 * main() STATIC METHOD This serves as the starting point for the
	 * GameController class.
	 *
	 * @param args Command line arguments
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		GameController2 thisGameController = new GameController2();
		thisGameController.titleScreen();

		// TODO: Quit Game Menu with save option
		// TODO: Display Planet selection menu.
		// TODO: Display Planet menu
		// TODO: Display Combat menu
		// saveGame method and loadGame Constructor should be implemented in
		// game class.
		// Menu to get path for loadGame should be done below.
		// TODO: method saveGame
		// TODO: method loadGame
	}
	
	// ALL Menu Methods

	/**
	 * titleScreen() - Displays title screen
	 *
	 * @return void
	 * @author kenny
	 */
	public void titleScreen() {
		boolean titleNotComplete = true;

		headerPrint();
		System.out.println(SPACE_GAME_TITLE);
		nl(1);
		System.out.println("Welcome to the world, Captain! Here are your options.");
		nl(1);

		while (titleNotComplete) {
			System.out.println("[N]ew Game  :  [L]oad Game  :  [E]xit Game  :  [H]elp Menu");
			wWJD();
			nl(1);
			listener();
			if (booleanMaker("New Game")) {
				// Construct New game object, captain object, and ArrayList of
				// default planets.
				thisGame = new Game();
				captain = new Captain();
				thisGame.setCaptain(captain);
				planetArrayList = new PlanetMaker().getPlanetArrayList();
				thisGame.setNumPreviousSaves(0);

				// Set Captain's name through menu
				captainNameMenu();

				// Set Captain's Crew through menu
				crewSelectionMenu();
				// End loop
				titleNotComplete = false;

				System.out.println("Let's get started Captain!");
				planetSelectionMenu();

			} else if (booleanMaker("Load Game")) {
				// TODO: Display LoadGame/SaveGame menu that returns a string
				// path.

				// String path = loadGameMenu(); //TODO: Remove this when menu
				// sys implemented.
				thisGame = new Game(loadGameMenu(userInput));
				loadThisGameElements(thisGame);
				System.out.println("Captain, this is who you're travelling with: ");
				for (String crewName : captain.getCaptainCrew()) {
					System.out.println(crewName);
				}

				System.out.println("Let's get started Captain!");

				if (captain.getCurrentPlanet() != null) {
					planetMenu();
				} else {
					planetSelectionMenu();
				}

				titleNotComplete = false;

			} else if (booleanMaker("Exit Game")) {
				System.exit(0);

				titleNotComplete = false;

			} else if (booleanMaker("Help Menu")) {
				headerPrint();
				System.out.println("Captain! You have to start a game to get help with one!");
				headerPrint();
				titleScreen();
			} else {
				genericInputFailure();
			}
		}
		headerPrint();
		isCaptainAlive();
	}

	/**
	 * captainNameMenu() - Displays a menu for setting the Captain's name.
	 *
	 * @author jcbrough
	 */
	private void captainNameMenu() {

		headerPrint();
		System.out.println("A new captain! What's your name?");
		captain.setName(getExactResponse());
	}

	/**
	 * loadThisGameElements() - Pulls saved planetArrayList and
	 * captain object from game object to current Game Controllers Attributes.
	 * 
	 * @author: kenny
	 */
	private void loadThisGameElements(Game game) {
		captain = game.getCaptain();
		planetArrayList = game.getPlanets();

		if (captain.getCurrentPlanet() != null) {
			currentPlanet = captain.getCurrentPlanet();
		}
	}

	/**
	 * softSaveGame() - Soft saves captain and planet ArrayList
	 * 
	 * @author kenny
	 */
	public void softSaveGame() {
		thisGame.setCaptain(captain);
		thisGame.setPlanets(planetArrayList);
	}

	/**
	 * planetSelectionMenu() - Displays the planet selection menu.
	 *
	 * @return void
	 * @author jcbrough, kenny
	 */
	public void planetSelectionMenu() {
		boolean planetSelectionNotComplete = true;
		ArrayList<Planet> planetChoices = new ArrayList<>();

		if (captain.hasNavigationOfficer()) {
			planetChoices = randomPlanets(3);
		} else {
			planetChoices = randomPlanets(2);
		}

		if (!(captain.getPlanetCount() > 9)) {
			while (planetSelectionNotComplete && captain.isAlive()) {
				System.out.println("What is our destination, Captain " + captain.getName() + "?");
				System.out.println("Based on our current position, these are our options: ");
				for (Planet thisPlanet : planetChoices) {
					System.out.println("		" + thisPlanet.getPlanetName());
				}
				System.out.println("Please type [help] or the name of the planet you'd like to visit: ");
				System.out.println(
						"Please note: if the planet name isn't input into the navigation system with precision, we'll be...");
				System.out.println("LOOOOOSSSST IIIINNNNN SSPPPPPPPAAAAACCCEEEEE!!!!!");
				listener();
				nl(1);
				if (booleanMaker("Help")) {
					helpMenu();
				} else {
					for (Planet selectedPlanet : planetChoices) {
						if (userInput.contains(removeNonWords(selectedPlanet.getPlanetName()))) {
							currentPlanet = selectedPlanet;
							selectedPlanet.setPlanetExplored(true);
							System.out.println("Thank you, Captain!");
							System.out.println("You have chosen to go to " + selectedPlanet.getPlanetName()
									+ "! BOLDLY GOING NOW, CAPTAIN!!!");
							planetSelectionNotComplete = false;
							captain.setPlanetCount(captain.getPlanetCount() + 1);
							softSaveGame();
							planetMenu();
							break;

						} else if (planetChoices.indexOf(selectedPlanet) < planetChoices.size() - 1) {
							// continues loop until planetSelectionNotComplete == false
						} else {
							nl(1);
							headerPrint();
							System.out.println("Captain, the input \"" + userInput + "\" is garbage!!! You are a crazy person!");
							System.out.println("Let's try that again!");
							nl(1);
							// continues loop until planetSelectionNotComplete == false
						}
					}
				}
			}
		} else {
			youWin();
		}

	}

	/**
	 * youWin() - Displays player's victory
	 *
	 * @return void
	 * @author kenny
	 */
	public void youWin() {
		System.out.println("Congratulations! You win!");
		softSaveGame();
		titleScreen();
	}

	/**
	 * youLose() - Displays player's loss
	 *
	 * @return void
	 * @author kenny
	 */
	public void youLose() {
		System.out.println("Bleh! You Lose!");
		softSaveGame();
		titleScreen();
	}

	/**
	 * randomPlanets() - Picks randomized planets from
	 * available planetArrayList author: Kenny
	 *
	 * @param numberOfPlanets
	 * @return ArrayList
	 */
	public ArrayList<Planet> randomPlanets(int numberOfPlanets) {

		boolean randomPlanetNotComplete = true;
		ArrayList<Planet> randomPlanets = new ArrayList<>();
		int count = 0;
		Random rand = new Random();
		int randomNumber;

		while (randomPlanetNotComplete) {
			randomNumber = rand.nextInt(planetArrayList.size());
			for (Planet p : planetArrayList) {
				if (captain.getPlanetCount() == 9) {
					if (count == numberOfPlanets) {
						randomPlanetNotComplete = false;
						break;
					} else if (!p.isPlanetExplored() && randomNumber == planetArrayList.indexOf(p)
							&& !randomPlanets.contains(p) && (p.getPlanetFlag() == 1 || p.getPlanetName().equals("Theta-10c"))) {
						randomPlanets.add(p);
						count++;
					}
				} else {
					if (count == numberOfPlanets) {
						randomPlanetNotComplete = false;
						break;
					} else if (!p.isPlanetExplored() && randomNumber == planetArrayList.indexOf(p)
							&& !randomPlanets.contains(p) && p.getPlanetFlag() != 1) {
						randomPlanets.add(p);
						count++;
					}
				}
			}
		}

		return randomPlanets;
	}

	public void planetMenu() {
		softSaveGame();
		headerPrint();
		nl(1);
		System.out.println("You have arrived at " + currentPlanet.getPlanetName());
		if (!currentPlanet.getArrivalMessage().contains("Nothing")) {
			System.out.println(currentPlanet.getArrivalMessage());
		}
		//Normal Planet
		if (currentPlanet.getPlanetFlag() == 0) {
			planetMenuSelection();
		}
		//Boss Planet
		else if (currentPlanet.getPlanetFlag() == 1) {
			combatMenu();
			planetMenuSelection();
			//All the other Planets with special conditions
		} else {
			specialPlanetMenu();
		}
	}

	public void specialPlanetMenu() {
		Dice dice25 = new Dice(25);
		if (currentPlanet.getPlanetName().equals("Theta-10c")) {
			rockPaperScissor();
			planetMenuSelection();
		} else if (currentPlanet.getPlanetName().equals("51 Pegasi b")) {
			puzzleMenu();
			planetMenuSelection();
		} else if (currentPlanet.getPlanetName().equals("Shadowfax")) {
			if (dice25.roll()) {
				combatMenu();
			}
			planetMenuSelection();
		}



	}

	public void rockPaperScissor() {
		boolean notTie = true;
		boolean playerThinking = true;
		int playerChoice = 0;
		int enemyChoice = 0;
		String enemySign = "";

		System.out.println("Seems like we have no choice...");

		while (notTie) {
			while (playerThinking) {
				nl(1);
				System.out.println(" Rock, Paper, or Scissor");
				listener();
				if (booleanMaker("Rock")) {
					playerChoice = 1;
					playerThinking = false;
				} else if (booleanMaker("Paper")) {
					playerChoice = 2;
					playerThinking = false;
				} else if (booleanMaker("Scissor")) {
					playerChoice = 3;
					playerThinking = false;
				} else {
					System.out.println("Looks like they did not understand out choice");
				}
			}


			System.out.println("You chose " + userInput);
			Random rand = new Random();
			enemyChoice = rand.nextInt(3) + 1;

			if (enemyChoice == 1) {
				enemySign = "Rock";
			} else if (enemyChoice == 2) {
				enemySign = "Paper";
			} else {
				enemySign = "Scissor";
			}

			System.out.println("The Enemy chose " + enemySign);

			if (enemyChoice == playerChoice) {
				System.out.println("Look Like a Tie...Try Again");
			} else if ((playerChoice == 1 && enemyChoice == 3) || (playerChoice == 2 && enemyChoice == 1)
					|| (playerChoice == 3 && enemyChoice == 2)) {
				notTie = false;
				youWin();
			} else {
				notTie = false;
				youLose();

			}


		}
	}

	public void planetMenuSelection() {
		final int REPAIR_HEALTH_AMOUNT = 25;
		boolean planetMenuNotFinished = true;
		boolean notScanned = true;
		boolean notExplored = true;
		boolean notRepaired = true;


		while (planetMenuNotFinished && captain.isAlive()) {
			headerPrint();
			System.out.println("Here are your options Captain");
			System.out.print("| [S]can | [E]xplore | [L]eave |");
			if (captain.hasEngineerOfficer()) {
				System.out.println(" [R]epair |");
			}
			wWJD();
			listener();
			if (booleanMaker("Scan") && notScanned) {
				System.out.println(currentPlanet.getScanMessage());
				notScanned = false;
				softSaveGame();
			} else if (booleanMaker("Explore") && notExplored) {
				exploreMenu();
				notExplored = false;
				softSaveGame();
			} else if (booleanMaker("Repair") && notRepaired && !(captain.getHealthPoints() > 100)) {
				captain.setHealthPoints(captain.getHealthPoints() + REPAIR_HEALTH_AMOUNT);
				captain.getAllAttributes();
				notRepaired = false;
				softSaveGame();
			} else if (booleanMaker("Leave")) {
				planetMenuNotFinished = false;
				softSaveGame();
				planetSelectionMenu();

			} else if (booleanMaker("Help")) {
				helpMenu();
			} else {
				System.out.println("Not sure what you are saying Captain... Lets try that again");
			}
		}
		isCaptainAlive();
	}

	public void exploreMenu() {
		Dice dwellerEncounter = new Dice(25);
		Dice invisibleEncounter = new Dice(50);
		System.out.println(currentPlanet.getExploreMessage());
		if (currentPlanet.getExploreFlag() == 0) {
			if (removeNonWords(currentPlanet.getPlanetName()).equals(removeNonWords("Eos"))) {
				System.out.println(currentPlanet.getExploreMessage());
				System.out.println("The harsh climate cause some damage though");
				captain.setHealthPoints(captain.getHealthPoints() - 25);
				isCaptainAlive();
				captain.getAllAttributes();
			}


		} else if (currentPlanet.getExploreFlag() == 1) {
			if (dwellerEncounter()) {
				if (dwellerEncounter.roll()) {
					combatMenu();
				}
			} else if (removeNonWords(currentPlanet.getPlanetName()).equals(removeNonWords("Altair IV"))) {
				if (invisibleEncounter.roll()) {
					combatMenu();
				}
			} else {
				combatMenu();
			}

		} else if (currentPlanet.getExploreFlag() == 2) {
			puzzleMenu();
		}

	}

	public void puzzleMenu() {
		Dice dice50 = new Dice(50);
		boolean puzzleNotComplete = true;
		Puzzle currentPuzzle = new Puzzle();
		for (Puzzle p : puzzleArrayList) {
			if (removeNonWords(p.getPuzzleHomePlanet()).equals(removeNonWords(currentPlanet.getPlanetName()))) {
				currentPuzzle = p;
			}
		}
		while (puzzleNotComplete && captain.isAlive()) {
			headerPrint();
			nl(1);
			System.out.println("Hmm...So what you think we should do Captain?");
			if (currentPuzzle.getPuzzleChoices().length == 3) {
				System.out.println(currentPuzzle.getPuzzleChoices()[0] + " | or | " + currentPuzzle.getPuzzleChoices()[1]
						+ " | or | " + currentPuzzle.getPuzzleChoices()[2]);
			} else {
				System.out.println(currentPuzzle.getPuzzleChoices()[0] + " | or | " + currentPuzzle.getPuzzleChoices()[1]);
			}
			if (captain.hasSurveyOfficer()) {
				System.out.println("Captain we can have our Survey Officer inspect the area to give us a [H]int");
			}

			listener();
			if (booleanMaker("Hint")) {
				System.out.println(currentPuzzle.getPuzzleHint());
			} else if (booleanMaker("Help")) {
				helpMenu();
			} else {

				switch (currentPuzzle.getPuzzleHomePlanet()) {
					case "51 Pegasi b":
						if (booleanMaker(currentPuzzle.getPuzzleChoices()[0])) {
							printChoice(currentPuzzle.getPuzzleChoices()[0]);
							System.out.println(currentPuzzle.getPuzzleChoiceMessages()[0]);
							puzzleNotComplete = false;
						} else if (booleanMaker(currentPuzzle.getPuzzleChoices()[1])) {
							printChoice(currentPuzzle.getPuzzleChoices()[1]);
							System.out.println(currentPuzzle.getPuzzleChoiceMessages()[1]);
							if (!captain.hasSurveyOfficer()) {
								captain.getCaptainCrew().add("Survey Officer");
								System.out.println(captain.getCaptainCrew());
							} else {
								System.out.println("Sorry Captain we had to decline the offer since we already have a Survey Officer");
							}
							puzzleNotComplete = false;
						}

						break;
					case "LV-426":
						if (booleanMaker(currentPuzzle.getPuzzleChoices()[0])) {
							printChoice(currentPuzzle.getPuzzleChoices()[0]);
							if (dice50.roll()) {
								System.out.println(currentPuzzle.getPuzzleChoiceMessages()[0]);
								combatMenu();
							}
							puzzleNotComplete = false;
						} else if (booleanMaker(currentPuzzle.getPuzzleChoices()[1])) {
							printChoice(currentPuzzle.getPuzzleChoices()[1]);
							if (dice50.roll()) {
								System.out.println(currentPuzzle.getPuzzleChoiceMessages()[0]);
								combatMenu();
							} else {
								System.out.println(currentPuzzle.getPuzzleChoiceMessages()[1]);
								if (!captain.hasNavigationOfficer()) {
									System.out.println("Seems like this Navigation Officer is attracted to the Artifact.");
									captain.getCaptainCrew().add("Navigation Officer");
									System.out.println(captain.getCaptainCrew());
								} else {
									System.out.println("Sorry Captain we had to throw them overboard since we already have a Navigation Officer");
								}
							}
							puzzleNotComplete = false;
						}
						break;
					case "Shadowfax":
						if (booleanMaker(currentPuzzle.getPuzzleChoices()[0])) {
							printChoice(currentPuzzle.getPuzzleChoices()[0]);
							System.out.println(currentPuzzle.getPuzzleChoiceMessages()[0]);

							puzzleNotComplete = false;

						} else if (booleanMaker(currentPuzzle.getPuzzleChoices()[1])) {
							printChoice(currentPuzzle.getPuzzleChoices()[1]);
							System.out.println(currentPuzzle.getPuzzleChoiceMessages()[1]);
							captain.setPlanetCount(0);
							puzzleNotComplete = false;

						} else if (booleanMaker(currentPuzzle.getPuzzleChoices()[2])) {
							printChoice(currentPuzzle.getPuzzleChoices()[2]);
							System.out.println(currentPuzzle.getPuzzleChoiceMessages()[0]);
							puzzleNotComplete = false;

						}
						break;

					case "Lisus":
						if (booleanMaker(currentPuzzle.getPuzzleChoices()[0])) {
							printChoice(currentPuzzle.getPuzzleChoices()[0]);
							System.out.println(currentPuzzle.getPuzzleChoiceMessages()[0]);
							puzzleNotComplete = false;
						} else if (booleanMaker(currentPuzzle.getPuzzleChoices()[1])) {
							System.out.println(currentPuzzle.getPuzzleChoiceMessages()[1]);
							if (dice50.roll()) {
								System.out.println("After wandering the forest for days, you return to your ship with half health");
								captain.setHealthPoints(captain.getHealthPoints() / 2);
								isCaptainAlive();
								captain.getAllAttributes();
							} else {
								System.out.println(currentPuzzle.getPuzzleChoiceMessages()[0]);
								if (!captain.hasCrew("Sentinel Bot")) {
									captain.getCaptainCrew().add("Sentinel Bot");
									System.out.println(captain.getCaptainCrew());
								} else {
									System.out.println("Sorry Captain. We scrapped the Sentinel Bot since we have one already");
								}

							}
							puzzleNotComplete = false;
						}
						break;
					case "Insula":

						if (booleanMaker(currentPuzzle.getPuzzleChoices()[0])) {
							printChoice(currentPuzzle.getPuzzleChoices()[0]);
							System.out.println(currentPuzzle.getPuzzleChoiceMessages()[0]);
							System.out.println("Due to the harsh environment you have taken 30 damage");
							captain.setHealthPoints(captain.getHealthPoints() - 30);
							isCaptainAlive();
							captain.getAllAttributes();
							puzzleNotComplete = false;
						} else if (booleanMaker(currentPuzzle.getPuzzleChoices()[1])) {
							printChoice(currentPuzzle.getPuzzleChoices()[1]);
							System.out.println(currentPuzzle.getPuzzleChoiceMessages()[1]);
							if (dice50.roll()) {
								System.out.println("The door opens and you see a device capable of lifting the ship laying on the table");
							} else {
								System.out.println("As door creeks open you notice glaring eyes on the other side...");
								combatMenu();
							}
							puzzleNotComplete = false;
						}
						break;
					case "Heralda":
						if (booleanMaker(currentPuzzle.getPuzzleChoices()[0])) {
							printChoice(currentPuzzle.getPuzzleChoices()[0]);
							System.out.println(currentPuzzle.getPuzzleChoiceMessages()[0]);
							puzzleNotComplete = false;
						} else if (booleanMaker(currentPuzzle.getPuzzleChoices()[1])) {
							printChoice(currentPuzzle.getPuzzleChoices()[1]);
							System.out.println(currentPuzzle.getPuzzleChoiceMessages()[1]);
							if (dice50.roll()) {
								System.out.println("The Device just crumbles in your hands...");
							} else {
								System.out.println("Thanks to the Device, A Tactical Officer has found our ship and wishes to join our crew");
								if (!captain.hasCrew("Tactical Officer")) {
									captain.getCaptainCrew().add("Tactical Officer");
									System.out.println(captain.getCaptainCrew());
								} else {
									System.out.println("Sorry Captain. We assigned the Tactical Officer to kitchen duty since we have one already");
								}
							}
							puzzleNotComplete = false;
						}
						break;

					default:
						System.out.println("Looks like there was some issues with the comm. Lets try this again");
						break;


				}
			}
		}
		isCaptainAlive();
	}

	public void isCaptainAlive() {
		if (captain.getHealthPoints() <= 0) {
			System.out.println("YOU HAVE DIED...");
			titleScreen();
		}
	}

	public void printChoice(String s) {
		System.out.println("You chosen " + s);
	}

	private void helpMenu() {
		// TODO Help Menu
		headerPrint();
		System.out.println("You get very little help, Captain!");
		System.out.println("You can [save], and that's about it.");
		nl(1);
		System.out.println("What would you like to do?");
		headerPrint();
		listener();
		if (booleanMaker("save")) {
			System.out.println("Copy that, Captain!");
			nl(1);
			headerPrint();
			nl(1);
			softSaveGame();
			saveGameMenu();
		}
		nl(2);
	}

	/**
	 * Method: loadGameMenu() Description: Load Game menu that displays
	 *
	 * @return String path for Game.loadGame
	 * @author jcbrough, kenny
	 */
	private String loadGameMenu(String fileName) {
		System.out.println("Which game would you like to load?"); //TODO: Create loadgame menu. 
		// selectedGame should be the saved game that the player chooses. This
		// is just filler.
		Game selectedGame = new Game();
		if (selectedGame.getNumPreviousSaves() <= 3) {
			System.out.println("Sorry, Captain! You're too old for active duty!");
			titleScreen();
		}
		return System.getProperty("user.home") + "\\Desktop\\" + Game.getExtension();
		// TODO load game menu that returns path for Game secondary constructor.
	}

	public void saveGameMenu() {
		// TODO Save Game Menu to save Game
		//At this point, a valid savegame is not being passed to this method. 
		System.out.println("Would you like to [save] your game? Or are you [done] with this cruel world?!");
		listener();

		if (booleanMaker("Save")) {
			@SuppressWarnings("resource")
			Scanner in = new Scanner(System.in);
			System.out.println("What would you like the save file to be called?");
			StringBuilder saveGameFileName = new StringBuilder(in.nextLine());
			System.out.println(saveGameFileName.length());
			saveGameFileName.append(" - ");
			saveGameFileName.append("Captain " + captain.getName());
			saveGameFileName.append(SAVE_FILE_EXTENSION);
			StringBuilder fullPath = new StringBuilder(DESKTOP_PATH); //Changed name for readability. 
			fullPath.append(saveGameFileName);
			//TODO: FULL PATH ACQUIRED. 
			//TODO: Serialize game and get it get it .
		}
	}

	private void crewSelectionMenu() {
		ArrayList<String> selectedCrew = new ArrayList<String>();

		headerPrint();
		System.out.println("Captain! You must select a crew! You can only choose three!");
		System.out.println("Here is a list of currently unassigned crew:");
		for (String s : captain.getFullCrewList()) {
			System.out.println("		" + s + "?");
		}

		System.out.println(
				"The rest of the officers of SuperElite StarFleet have been disqualified for active duty for a felony involving a can of pureed pumpkin.");
		System.out.println("Please type three crew members, and press enter between each one!");
		System.out.println("You must type their names EXACTLY, or I won't be able to understand your finger-accent.");
		nl(1);
		for (int i = 0; i <= 2; i++) {
			selectedCrew.add(getExactResponse());
		}

		// Confirm selection.
		if (captain.confirmCrew(selectedCrew)) { //Confirm the selection.
			captain.setCaptainCrew(selectedCrew); //Set the selection
			captain.getAttributesFromCrew(); //Grant the attributes.

		} else {
			System.out.println("Something screwed up, captain! Let's do that again!");
			crewSelectionMenu();
		}
	}


	// Menu Making Helper Methods//

	/**
	 * Method: removeNonWords()
	 *
	 * @param string String that you want to remove all whitespace and non word
	 *               characters from.
	 * @return string with all non word characters including whitespace removed
	 * Last Edit: Kenny Cauthen Remarks:
	 */
	public String removeNonWords(String string) {
		return (string.replaceAll("[^\\p{L}\\p{Nd}]+", "")).toLowerCase();
	}

	/**
	 * Method: headerPrint() Prints a header thingy.
	 *
	 * @return void
	 * @author kenny
	 */
	public void headerPrint() {
		nl(1);
		System.out.println("==================================================================");
		nl(1);
	}

	/**
	 * Method: wWJD() Description: Print statement requesting next command.
	 *
	 * @return void
	 * @author kenny
	 */
	private void wWJD() { // HAHAHAHA!!! WWJD, really? Fuck me running. -JCB
		System.out.println("------------------------------------------------------------------");
		System.out.println("What would you like to do?");
	}

	/**
	 * Method: nl() Description: goes to next line @param number of times.
	 *
	 * @param numberOfNextLines
	 * @author kenny
	 */
	private void nl(int numberOfNextLines) {
		for (int i = 0; i < numberOfNextLines; i++) {
			System.out.println();
		}
	}

	/**
	 * Method: listener() Description: Takes in user input, removes all
	 * non-words and whitespace, then sets the final value to userInput.
	 *
	 * @return void
	 * @author kenny
	 */
	private void listener() {
		userInput = removeNonWords(in.nextLine());
	}

	private String getExactResponse() {
		return in.nextLine();
	}

	/**
	 * Method: booleanMaker() Description: Takes in a String input and converts
	 * tests whether userInput contains the whole String, first char, or just
	 * the first word.
	 * <p>
	 * Example: booleanMaker("Exit Menu") <-- will be true if input is
	 * "Exit Menu", "Exit", or E Author: Kenny
	 *
	 * @param input String to test userInput against.
	 * @return boolean if userInput matches @param input
	 */
	public boolean booleanMaker(String input) {
		return userInput.equals(removeNonWords(input))
				|| userInput.compareTo(removeNonWords(input.substring(0, 1))) == 0;
		// || userInput.contains(input.substring(0, input.indexOf(" ")));
	}

	/**
	 * Method: genericInputFailure() Prints a generic failure message.
	 *
	 * @return void
	 * @author kenny, jcbrough
	 */
	private void genericInputFailure() {
		System.out.println("Input failure!");

	}


	/**
	 * Method: inputFailure() Prints a failure based on passed parameters. Used
	 * for readability.
	 *
	 * @return void
	 * @author jcbrough
	 * <p>
	 * Use case: String garbage = in.nextline(); if (garbage !=
	 * validInput) { inputFailure("Hey, Captain! " +
	 * garbage.toUpperCase() + " is not a valid input!");
	 * tryInputAgain(); }
	 */
	public void inputFailure(String message) {
		System.out.println(message);
	}

	/**
	 * @return the thisGame
	 */
	public Game getThisGame() {
		return thisGame;
	}

	/**
	 * @param thisGame the thisGame to set
	 */
	public void setThisGame(Game thisGame) {
		this.thisGame = thisGame;
	}

	/**
	 * dwellerEncounter() - Encounters an enemy in specified planets
	 *
	 * @return boolean if currentPlanet matches planetName
	 * @author kenny
	 */
	public boolean dwellerEncounter() {
		return (removeNonWords(currentPlanet.getPlanetName()).equals(removeNonWords("Jor")) ||
				removeNonWords(currentPlanet.getPlanetName()).equals(removeNonWords("Prion")) ||
				removeNonWords(currentPlanet.getPlanetName()).equals(removeNonWords("Shadowfax")) ||
				removeNonWords(currentPlanet.getPlanetName()).equals(removeNonWords("TrES-2b")) ||
				removeNonWords(currentPlanet.getPlanetName()).equals(removeNonWords("Nasqueron")));
	}

	/**
	 * combatMenu() - Displays the combat menu
	 *
	 * @return void
	 * @author tkeating, cdeluna, kenny
	 */
	public void combatMenu() {
		boolean hasNotFled = true;
		Enemy enemy = new Enemy();

		for (Enemy e : enemyArrayList) {
			if (removeNonWords(e.getEnemyLocation()).equals(removeNonWords(currentPlanet.getPlanetName()))) {
				enemy = e;
			} else if (e.getName().equals("Gas Giant Dwellers") && dwellerEncounter()) {
				enemy = e;
			}
		}

		//System.out.println(enemy.getEnemyDescription());

		if (enemy.getAmbushStatus() == 1) {
			// If enemy survives initiate Enemy on player Combat
			System.out.println("Captain! " + enemy.getName() + " appear to be readying for an attack! Brace for impact!");
			hitCaptain(enemy);
			isCaptainAlive();
			nl(1);
		}
		while ((captain.isAlive() && enemy.isAlive()) && hasNotFled) {

			System.out.println("Captain! What are you orders?");
			System.out.print("| [A]ttack |");
			// Flee with Tactical Officer
			if (captain.hasTacticalOfficer()) {
				System.out.println(" or | [F]lee | ");
			}

			listener();
			if (booleanMaker("Help")) {
				helpMenu();
			} else if (booleanMaker("Attack")) {
				hitEnemy(enemy);
				if (enemy.isAlive()) {
					hitCaptain(enemy);
				}
			} else if (captain.hasTacticalOfficer() && booleanMaker("Flee")) {
				System.out.println("Roger that captain! Preparing for ludicrous Speed!");
				System.out.println("Ludicrous Speed reached! Sir we've gone Plaid.\n");
				hasNotFled = false;
			} else {
				System.out.println("There seems to be an issue with comms. Lets try that again.");

			}
		}

		if (!captain.isAlive()) {
			isCaptainAlive();
		} else if (!enemy.isAlive()) {
			System.out.println("Sir, " + enemy.getName() + " has been neutralized");
			nl(1);
		}
	}
	
	/**
	 * hitEnemy() - Captain attacks enemy
	 *
	 * @return void
	 * @author tkeating, cdeluna, kenny
	 */
	public void hitEnemy(Enemy enemy) {
		int captainDamage = captain.getAttackPoints() - enemy.getDefensePoints();

		System.out.println("Roger that, Captain! Target acquired, firing lasers at " + enemy.getName() + "!");
		nl(1);
		enemy.setHealthPoints(enemy.getHealthPoints() - captainDamage);
		if (enemy.getHealthPoints() <= 0) {
			System.out.println(enemy.getName() + " Looks to be unstable");
		} else {
			System.out.println("Sir, scanners show enemy health at " + enemy.getHealthPoints() + "!");
		}
	}

	/**
	 * hitCaptain() - Enemy attacks captain
	 *
	 * @return void
	 * @author tkeating, cdeluna, kenny
	 */
	public void hitCaptain(Enemy enemy) {
		int enemyDamage = enemy.getAttackPoints() - captain.getDefensePoints();
		System.out.println("Captain! " + enemy.getName() + "appears to be readying for an attack! Brace for impact!");
		nl(1);

		captain.setHealthPoints(captain.getHealthPoints() - enemyDamage);

		System.out.println("Captain! Our sensors are showing us that we have sustained class " + enemyDamage
				+ " damage to our hull!");
		if (captain.getHealthPoints() <= 0) {
			System.out.println("Captain...We are not looking to good...");
		} else {
			System.out.println("Sir, our shields are at level " + captain.getHealthPoints() + "!");
		}
	}

}
