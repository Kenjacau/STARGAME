package controllers;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OptionalDataException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import obstacles.*;
import playerCharacter.Captain;

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
	private static final String SPACE_GAME_TITLE = "Super Elite: Space Adventure!";
	private static final String SAVE_FILE_EXTENSION = ".ser";
	private static final String DESKTOP_PATH = System.getProperty("user.home") + "\\Desktop\\";
	private static final int MAX_NUMBER_OF_SAVES = 3;
	private static GameController2 gcSingleton = null;
	// Other private variables
	private Game thisGame;
	private Captain captain;
	private ArrayList<Planet> planetArrayList;
	private ArrayList<Puzzle> puzzleArrayList = new PuzzleMaker().getPuzzleArrayList();
	private ArrayList<Enemy> enemyArrayList = new EnemyMaker().getEnemyArrayList();
	private Planet currentPlanet;
	private Scanner in = new Scanner(System.in);
	private String userInput = "";
	
	/**
	 * GameController2 CONSTRUCTOR
	 * This constructor is PRIVATE. It exists ONLY TO DEFEAT GC INSTANTIATION.
	 *
	 * @author jcbrough
	 */
	private GameController2() {
	}
	
	/**
	 * main()
	 * STATIC METHOD
	 * This serves as the starting point for the GameController class.
	 *
	 * @param args Command line arguments
	 * @throws IOException
	 * @throws ClassNotFoundException
	 *
	 * @author jcbrough
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		getGameControllerInstance().titleScreen();
	}
	
	/**getGameControllerInstance
	 * Make sure the GameController2 control object is a Singleton
	 * 
	 * @return GameController2 object.
	 * 
	 * @author jcbrough
	 */
	private static GameController2 getGameControllerInstance() {
		if (gcSingleton == null) {
			gcSingleton = new GameController2();
		}		
		return gcSingleton; 
	}

	/**
	 * titleScreen() - Displays title screen
	 *
	 * @return void
	 * 
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * @author kenny, jcbrough
	 */
	public void titleScreen() throws ClassNotFoundException, IOException {
		boolean titleNotComplete = true;

		headerPrint();
		System.out.println("   _____                         ______ _ _ _       \n" +
				"  / ____|                       |  ____| (_) |      \n" +
				" | (___  _   _ _ __   ___ _ __  | |__  | |_| |_ ___ \n" +
				"  \\___ \\| | | | '_ \\ / _ \\ '__| |  __| | | | __/ _ \\\n" +
				"  ____) | |_| | |_) |  __/ |    | |____| | | ||  __/\n" +
				" |_____/ \\__,_| .__/ \\___|_|    |______|_|_|\\__\\___|\n" +
				"              | |                                   \n" +
				"              |_|                                   ");
		nl(1);
		System.out.println(SPACE_GAME_TITLE);
		headerPrint();
		pause(1500);
		System.out.println("Welcome to the world, Captain! Here are your options:");
		nl(1);

		while (titleNotComplete) {
			System.out.println("[N]ew Game  :  [L]oad Game  :  [E]xit Game  :  [H]elp Menu");
			wWJD();
			nl(1);
			listener();
			if (booleanMaker("New Game")) {
				// Construct New game object, captain object, and ArrayList of default planets.
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
				@SuppressWarnings("resource") //Known bug. Don't yell at me.
				Scanner in = new Scanner(System.in); 
				System.out.println("What is the EXACT name of the world recording, without the \"*.ser\" extension?");
				thisGame = loadGame(in.nextLine()); 
				loadThisGameElements(thisGame);
				nl(1); 
				headerPrint(); 
				nl(1); 
				
				//Print some info for the returning captain: 
				System.out.println("Welcome back, Captain! This is who you're travelling with: ");
				for (String crewName : captain.getCaptainCrew()) {
					System.out.println(crewName);
				}
				nl(1); 
				thisGame.getCaptain().printAllAttributes();
				nl(1); 
				System.out.println("You have recorded the world " + thisGame.getNumPreviousSaves() + " time(s)."); 
				System.out.println("Max number of world recordings is: " + MAX_NUMBER_OF_SAVES + ". Be careful out there, Captain!");
				nl(1); 
				headerPrint(); 
				nl(1); 
				
				//Begin. 
				System.out.println("Let's get started, Captain!");

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
	 * loadThisGameElements()
	 * Pulls saved planetArrayList and
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
	 * softSaveGame()
	 * Soft saves captain and planet ArrayList
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
	 * 
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * 
	 * @author jcbrough, kenny
	 */
	public void planetSelectionMenu() throws ClassNotFoundException, IOException {
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
					pause(400);
					System.out.println("		" + thisPlanet.getPlanetName());
				}
				pause(600);
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
									+ "! BOLDLY GOING NOW, CAPTAIN!");
							dotPrinter();
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
			youWin(); //OH SHIT
		}

	}

	/**
	 * youWin() - Displays player's victory
	 *
	 * @return void
	 * @author kenny
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public void youWin() throws ClassNotFoundException, IOException {
		headerPrint();
		System.out.println("After Exploring the Galaxy you realize there is nothing better than...");
		pause(800);
		System.out.println("to sitting at home and watching Netflix.");
		pause(800);
		headerPrint();
		System.out.println(" __     ______  _    _  __          _______ _   _ \n" +
				" \\ \\   / / __ \\| |  | | \\ \\        / /_   _| \\ | |\n" +
				"  \\ \\_/ / |  | | |  | |  \\ \\  /\\  / /  | | |  \\| |\n" +
				"   \\   /| |  | | |  | |   \\ \\/  \\/ /   | | | . ` |\n" +
				"    | | | |__| | |__| |    \\  /\\  /   _| |_| |\\  |\n" +
				"    |_|  \\____/ \\____/      \\/  \\/   |_____|_| \\_|\n" +
				"                                                 ");
		nl(1);
		System.out.println("Congratulations! YOU WIN!");
		softSaveGame();
		nl(2); 
		titleScreen();
	}

	/**
	 * youLose() - Displays player's loss
	 *
	 * @return void
	 * @author kenny
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public void youLose() throws ClassNotFoundException, IOException {
		headerPrint();
		pause(800);
		System.out.println(" __     ______  _    _   _      ____   _____ ______ _ \n" +
				" \\ \\   / / __ \\| |  | | | |    / __ \\ / ____|  ____| |\n" +
				"  \\ \\_/ / |  | | |  | | | |   | |  | | (___ | |__  | |\n" +
				"   \\   /| |  | | |  | | | |   | |  | |\\___ \\|  __| | |\n" +
				"    | | | |__| | |__| | | |___| |__| |____) | |____|_|\n" +
				"    |_|  \\____/ \\____/  |______\\____/|_____/|______(_)");
		nl(1); 
		System.out.println("Bleh! YOU LOSE!");
		softSaveGame();
		nl(2); 
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

	/**
	 * Method: PlanetMenu()
	 * Description:
	 * 
	 * author: Kenny
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public void planetMenu() throws ClassNotFoundException, IOException {
		softSaveGame();
		headerPrint();
		nl(1);
		System.out.println("You have arrived at " + currentPlanet.getPlanetName());
		nl(1);
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

	/**
	 * Method:specialPlanetMenu()
	 * Description: If the planet is special, this is what happens. 
	 * 
	 * author: Kenny
	 * 
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public void specialPlanetMenu() throws ClassNotFoundException, IOException {
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

	/**
	 * Method:rockPaperScissor()
	 * Description:
	 * author: Kenny
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public void rockPaperScissor() throws ClassNotFoundException, IOException {
		boolean playerThinking = true;
		int playerChoice = 0;
		int enemyChoice = 0;
		String enemySign = "";
		int winCount = 0;
		int loseCount = 0;
		System.out.println("Seems like we have no choice...");

		while (winCount < 2 && loseCount < 2) {
			while (playerThinking) {
				nl(1);
				System.out.println(" Rock, Paper, or Scissors");
				listener();
				if (booleanMaker("Rock")) {
					playerChoice = 1;
					playerThinking = false;
				} else if (booleanMaker("Paper")) {
					playerChoice = 2;
					playerThinking = false;
				} else if (booleanMaker("Scissors")) {
					playerChoice = 3;
					playerThinking = false;
				} else {
					System.out.println("Looks like they did not understand our choice.");
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
				enemySign = "Scissors";
			}

			System.out.println("The Enemy chose " + enemySign);

			if (enemyChoice == playerChoice) {
				System.out.println("Looks like a tie... Try again.");
			} else if ((playerChoice == 1 && enemyChoice == 3) || (playerChoice == 2 && enemyChoice == 1)
					|| (playerChoice == 3 && enemyChoice == 2)) {
				winCount++;
				playerThinking = true;
				System.out.println("");
			} else {
				loseCount++;
				playerThinking = true;
				System.out.println();

			}
		}
		if (winCount == 2) {
			youWin();
		} else {
			youLose();
		}
	}

	/**
	 * Method:planetMenuSelection()
	 * Description:
	 * author: Kenny
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public void planetMenuSelection() throws ClassNotFoundException, IOException {
		final int REPAIR_HEALTH_AMOUNT = 25;
		boolean planetMenuNotFinished = true;
		boolean notScanned = true;
		boolean notExplored = true;
		boolean notRepaired = true;


		while (planetMenuNotFinished && captain.isAlive()) {
			headerPrint();
			pause(1600);
			System.out.println("Captain, our options are: ");
			if (notScanned) {
				System.out.print("| [S]can ");
			}
			if (notExplored) {
				System.out.print("| [E]xplore ");
			}
			if (captain.hasEngineerOfficer() && notRepaired) {
				System.out.print("| [R]epair ");
			}
			System.out.println("| [L]eave | [C]ondition |");
			nl(1);
			nl(1); 
			wWJD();
			listener();
			nl(1);
			if (booleanMaker("Scan") && notScanned) {
				System.out.println(currentPlanet.getScanMessage());
				notScanned = false;
				softSaveGame();
			} else if (booleanMaker("Explore") && notExplored) {
				exploreMenu();
				notExplored = false;
				softSaveGame();
			} else if (booleanMaker("Repair") && notRepaired) {
				if (captain.getHealthPoints() + REPAIR_HEALTH_AMOUNT > 99) {

					System.out.println("At max health Captain!");
					captain.setHealthPoints(100);
				} else {
					captain.setHealthPoints(captain.getHealthPoints() + REPAIR_HEALTH_AMOUNT);
				}
				captain.printAllAttributes();
				notRepaired = false;
				softSaveGame();
			} else if (booleanMaker("Leave")) {
				planetMenuNotFinished = false;
				softSaveGame();

				planetSelectionMenu();

			} else if (booleanMaker("Condition")) {
				captain.printAllAttributes();

			} else if (booleanMaker("Help")) {
				helpMenu();
			} else {
				System.out.println("We seem to be having communication issues, Captain. \n" + "You know, like your " +
						"parents back home in Wisconsin? Let's try that again.");
			}
		}
		isCaptainAlive();
	}

	public void dotPrinter() {

		for (int i = 0; i < 30; i++) {
			pause(100);
			System.out.print(".");
		}
		System.out.println(".");
	}

	/**
	 * Method:
	 * Description:
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public void exploreMenu() throws ClassNotFoundException, IOException {
		Dice dwellerEncounter = new Dice(25);
		Dice invisibleEncounter = new Dice(50);
		System.out.println(currentPlanet.getExploreMessage());
		if (currentPlanet.getExploreFlag() == 0) {
			if (removeNonWords(currentPlanet.getPlanetName()).equals(removeNonWords("Eos"))) {
				System.out.println(currentPlanet.getExploreMessage());
				System.out.println("The harsh climate caused some damage. Durn.");
				captain.setHealthPoints(captain.getHealthPoints() - 25);
				isCaptainAlive();
				captain.printAllAttributes();
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

	/**
	 * Method:puzzleMenu()
	 * Description: Dispalys puzzle menus for non-special planets. 
	 * 
	 * Author: Kenny
	 * 
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public void puzzleMenu() throws ClassNotFoundException, IOException {
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
			pause(1600);
			System.out.println("Hmm, so what you think we should do Captain?");
			if (currentPuzzle.getPuzzleChoices().length == 3) {
				System.out.println("[" + currentPuzzle.getPuzzleChoices()[0] + "] | or | [" + currentPuzzle.getPuzzleChoices()[1] + "] | or | [" + currentPuzzle.getPuzzleChoices()[2] + "]");
			} else {
				System.out.println("[" + currentPuzzle.getPuzzleChoices()[0] + "] | or | ["+ currentPuzzle.getPuzzleChoices()[1] + "]");
			}
			if (captain.hasSurveyOfficer()) {
				System.out.println("Captain, we can have our Survey Officer inspect the area to give us a [Hint].");
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
								System.out.println("We made some room for the Survey Officer!");
								nl(1);
								System.out.println(captain.getCaptainCrew());
							} else {
								System.out.println("Sorry, Captain! We had to decline the offer since we already have a Survey Officer!");
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
								System.out.println("Seems like this Navigation Officer is attracted to the Artifact.");
								if (!captain.hasNavigationOfficer()) {
									captain.getCaptainCrew().add("Navigation Officer");
									System.out.println("The Navigation Officer has joined the crew!");
									System.out.println(captain.getCaptainCrew());
								} else {
									System.out.println("Sorry, Captain! We had to throw them overboard since we " +
											"already have a Navigation Officer! You're an ***!");
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
							planetSelectionMenu();


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
								System.out.println("After wandering the forest for days, you return to your ship with half health.");
								captain.setHealthPoints(captain.getHealthPoints() / 2);
								isCaptainAlive();
								captain.printAllAttributes();
							} else {
								System.out.println("After wandering the forest, you find a Sentinel Bot patrolling " +
										"aimlessly.");
								nl(1);
								System.out.println("It seems to want to join your team.");

								if (!captain.hasCrew("Sentinel Bot")) {
									captain.getCaptainCrew().add("Sentinel Bot");
									nl(1);
									System.out.println("The Sentinel Bot has joined our crew!");
									System.out.println(captain.getCaptainCrew());
								} else {
									System.out.println("Sorry, Captain! We scrapped the Sentinel Bot since we have one already!");
								}

							}
							puzzleNotComplete = false;
						}
						break;
					case "Insula":

						if (booleanMaker(currentPuzzle.getPuzzleChoices()[0])) {
							printChoice(currentPuzzle.getPuzzleChoices()[0]);
							System.out.println(currentPuzzle.getPuzzleChoiceMessages()[0]);
							System.out.println("Due to the harsh environment, you have taken 30 damage.");
							captain.setHealthPoints(captain.getHealthPoints() - 30);
							isCaptainAlive();
							captain.printAllAttributes();
							puzzleNotComplete = false;
						} else if (booleanMaker(currentPuzzle.getPuzzleChoices()[1])) {
							printChoice(currentPuzzle.getPuzzleChoices()[1]);
							System.out.println(currentPuzzle.getPuzzleChoiceMessages()[1]);
							if (dice50.roll()) {
								System.out.println("The door opens, and you see a device capable of lifting the ship laying on the table.");
							} else {
								System.out.println("As door creeks open, you notice glaring eyes on the other side...");
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
								System.out.println("Thanks to the Device, a Tactical Officer has found our ship and wishes to join our crew.");
								if (!captain.hasCrew("Tactical Officer")) {
									captain.getCaptainCrew().add("Tactical Officer");
									System.out.println("Tactical Officer has joined the crew!");
									System.out.println(captain.getCaptainCrew());
								} else {
									System.out.println("Sorry, Captain! We assigned the Tactical Officer to kitchen duty since we have one already!");
								}
							}
							puzzleNotComplete = false;
						}
						break;

					default:
						System.out.println("Looks like there are some issues with the comm. Let's try this again.");
						break;
				}
			}
		}
		isCaptainAlive();
	}

	/**
	 * Method:isCaptainAlive()
	 * Description: If the captain is dead, you lose!!
	 * 
	 * Author: Kenny
	 * 
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public void isCaptainAlive() throws ClassNotFoundException, IOException  {
		if (captain.getHealthPoints() <= 0) {
			System.out.println(" __     ______  _    _    _____ _____ ______ _____  _ \n" +
					" \\ \\   / / __ \\| |  | |  |  __ \\_   _|  ____|  __ \\| |\n" +
					"  \\ \\_/ / |  | | |  | |  | |  | || | | |__  | |  | | |\n" +
					"   \\   /| |  | | |  | |  | |  | || | |  __| | |  | | |\n" +
					"    | | | |__| | |__| |  | |__| || |_| |____| |__| |_|\n" +
					"    |_|  \\____/ \\____/   |_____/_____|______|_____/(_)");
			nl(2);
			pause(200);
			titleScreen();
		}
	}

	/**
	 * Method:printChoice()
	 * Description: Helper method to display choice player made
	 * Author: Kenny
	 */
	public void printChoice(String s) {
		System.out.println("You've chosen " + s);
		headerPrint();
	}

	/**
	 * Method:pause()
	 * Description:Pause thread
	 * Author: Kenny
	 */
	public void pause(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}

	private void helpMenu() {
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
	 * loadGame
	 * Deserializer for a saveGame.ser file. 
	 * @param saveGameFileName The name of the save file. 
	 *
	 * @return Fully constructed Game object. 
	 * 
	 * @author jcbrough, kenny
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	private Game loadGame(String saveGameFileName) throws IOException, ClassNotFoundException {
		
		FileInputStream fis = new FileInputStream(getFullPathForLoad(saveGameFileName));
	    ObjectInputStream ois = new ObjectInputStream(fis);
	    Game loadedGame = new Game(); 
	    try {
	    	loadedGame = (Game) ois.readObject();
	    } catch (OptionalDataException e) {
	        if (!e.eof) throw e;
	    } finally {
	        ois.close();
	    }
		
		return loadedGame; 
	}

	public void saveGameMenu() {
		System.out.println("You [sure] you want to do this? The world will fall after recording.");
		listener();

		if (booleanMaker("Sure")) {
			//See class header for globals. 
			if (thisGame.getNumPreviousSaves() >= MAX_NUMBER_OF_SAVES) {
				System.out.println("Captain... we cannot record the world. You're too old... you'll die in the attempt!");
				return; 
			}
			
			else { //Save the game!
				thisGame.setNumPreviousSaves(thisGame.getNumPreviousSaves() + 1);
				@SuppressWarnings("resource")
				Scanner in = new Scanner(System.in);
				System.out.println("What would you like the save file to be called?");
				String saveGameFileName  = in.next(); 
				try {
					//Declare helpers
					FileOutputStream saveGameFileOut = new FileOutputStream(getFullPathForSave(saveGameFileName)); //FileOutputStream takes a String, not a StringBuilder object.
					ObjectOutputStream out = new ObjectOutputStream(saveGameFileOut);
			        
					//Do the work
					out.writeObject(thisGame);
			       
					//Cleanup. 
					saveGameFileOut.close();
					saveGameFileOut.close();
					System.out.printf("World recorded and saved to: " + getFullPathForSave(saveGameFileName) + ". Goodbye, Captain " + thisGame.getCaptain().getName() + "."); 
					System.exit(0); 
			    } 
				catch(IOException e) {
			         e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Method:crewSelectionMenu()
	 * Author:Kenny
	 * Description:
	 */
	private void crewSelectionMenu() {
		ArrayList<String> selectedCrew = new ArrayList<String>();

		headerPrint();
		System.out.println("Captain! You must select a crew! You can only choose three!");
		pause(600);
		System.out.println("Here is a list of currently unassigned crew: ");
		for (String s : captain.getFullCrewList()) {
			pause(400);
			System.out.println("		" + s + "?");
		}
		pause(400);

		System.out.println("The rest of the officers of SuperElite StarFleet have been disqualified \nfor active duty " +
				"" + "for a felony involving a can of pureed pumpkin.");
		nl(1);
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
			System.out.println("Something screwed up, Captain! Let's do that again!");
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
		pause(300);
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
				removeNonWords(currentPlanet.getPlanetName()).equals(removeNonWords("TrES-2b")));
	}

	/**
	 * combatMenu() - Displays the combat menu
	 *
	 * @return void
	 * @author tkeating, cdeluna, kenny
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public void combatMenu() throws ClassNotFoundException, IOException {
		boolean hasNotFled = true;
		Enemy enemy = new Enemy();

		for (Enemy e : enemyArrayList) {
			if (removeNonWords(e.getEnemyLocation()).equals(removeNonWords(currentPlanet.getPlanetName()))) {
				enemy = e;
			} else if (e.getName().equals("Gas Giant Dwellers") && (dwellerEncounter() || removeNonWords(currentPlanet
					.getPlanetName()).equals(removeNonWords("Nasqueron")))) {
				enemy = e;
			}
		}

		//System.out.println(enemy.getEnemyDescription());

		if (enemy.getAmbushStatus() == 1) {
			// If enemy survives initiate Enemy on player Combat
			System.out.println("::::::::::::::::AMBUSH!::::::::::::::::::");
			hitCaptain(enemy);
			isCaptainAlive();
			nl(1);
		}
		while ((captain.isAlive() && enemy.isAlive()) && hasNotFled) {
			headerPrint();
			pause(800);
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
				System.out.println("Roger that, Captain! Preparing for ludicrous speed!");
				dotPrinter();
				System.out.println("Ludicrous speed reached! Sir, we've gone plaid.");
				nl(1);
				hasNotFled = false;
			} else {
				System.out.println("There seems to be an issue with comms. Let's try that again.");

			}
		}

		if (!captain.isAlive()) {
			isCaptainAlive();
		} else if (!enemy.isAlive()) {
			nl(1);
			System.out.println("Sir, " + enemy.getName() + " has been neutralized.");
			if (enemy.getName().equals("Gas Giant Dweller")) {
				enemyArrayList = new EnemyMaker().getEnemyArrayList();
			}
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
		pause(1000);
		nl(1);
		enemy.setHealthPoints(enemy.getHealthPoints() - captainDamage);
		if (enemy.getHealthPoints() <= 0) {
			System.out.println(enemy.getName() + " Looks to be in critical condition...");
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
		System.out.println("Captain! " + enemy.getName() + " appears to be readying for an attack! Brace for impact!");
		int enemyDamage = enemy.getAttackPoints() - captain.getDefensePoints();
		captain.setHealthPoints(captain.getHealthPoints() - enemyDamage);
		pause(1000);
		nl(1);
		System.out.println("Captain! Our sensors are showing us that we have sustained class " + enemyDamage + " damage!");
		if (captain.getHealthPoints() <= 0) {
			System.out.println("Captain... U-uh... W-we are not l-looking to g..oo..d...");
		} else {
			System.out.println("Sir, our shields are at level " + captain.getHealthPoints() + "!");
		}
	}
	
	/**getFullPathForSave
	 * Constructs a full save game path based on the users's desktop and the static file extension variable. 
	 * 
	 * @param saveFile The name of the save file. 
	 * @return The full path. If the param is "test", return should look like this: 
	 * 		C:\Users\jcbrough\Desktop\test - Captain Jim.ser
	 * 
	 * @author jcbrough
	 */
	public String getFullPathForSave(String saveFile) {
		StringBuilder saveGameFileName = new StringBuilder(saveFile);
		saveGameFileName.append(" - ");
		saveGameFileName.append("Captain " + captain.getName());
		saveGameFileName.append(SAVE_FILE_EXTENSION);
		StringBuilder fullPath = new StringBuilder(DESKTOP_PATH); //Changed name for readability. 
		fullPath.append(saveGameFileName);
		return fullPath.toString(); 
	}
	
	/**getFullPathForLoad
	 * Constructs a full save game path based on the users's desktop and the static file extension variable. 
	 * 
	 * @param saveFile The name of the save file, with Captian name. 
	 * @return The full path. If the param is "test", return should look like this: 
	 * 		C:\Users\jcbrough\Desktop\test - Captain Jim.ser
	 * 
	 * @author jcbrough
	 */
	public String getFullPathForLoad(String saveFile) {
		StringBuilder saveGameFileName = new StringBuilder(saveFile);
		saveGameFileName.append(SAVE_FILE_EXTENSION);
		StringBuilder fullPath = new StringBuilder(DESKTOP_PATH); //Changed name for readability. 
		fullPath.append(saveGameFileName);
		return fullPath.toString(); 
	}
}
