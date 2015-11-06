package obstacles;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Class: Planet
 * Description: This class defines all methods and attributes that define a Planet object.
 *
 * @author Kenny Cauthen
 *         kcauthen@ggc.edu
 * @version 0.0.1, 11/5/2015
 *          Course: ITEC 3860 Fall 2015
 *          Assignment: Final Project
 */
public class Planet {

	//TODO: Write this class. Stubbed for inclusion into the controllers.GameController class.

	private String planetName = "";
	// Description same as arrival message? <------------------SEE JCB----------------
	private String arrivalMessage = "";
	private String scanMessage = "";
	private String exploreMessage = "";
	//Changed exploreStatus to exploreFlag for less confusion on what it is
	private int exploreFlag = 0;
	private boolean planetExplored = false;
	private int planetFlag = 0;
	// Found out there were no cases where any two below exists at the same time so created flag above instead
	//private boolean gasPlanet=false;
	//private boolean bossPlanet=false;
	//private boolean specialPlanet = false;

	//I think Enemy and Puzzle should be done from explore. Constructor for Puzzle and Enemy should take in planetName

	/**
	 * @see controllers.GameController
	 */
	//private Enemy enemyInResidence = new Enemy(); //Stubbed for your convenience!
	public Planet(String newPlanetName, String newArrivalMessage, String newScanMessage, String newExploreMessage,
				  int newExploreFlag, int newPlanetFlag, boolean newPlanetExplored) {

		planetName = newPlanetName;
		arrivalMessage = newArrivalMessage;
		scanMessage = newScanMessage;
		exploreMessage = newExploreMessage;
		exploreFlag = newExploreFlag; //Trigger 0 = message only, 1 = puzzle, or 2 = enemy
		planetFlag = newPlanetFlag; //Trigger 0 = normal planet, 1 = bossPlanet, 2 = gasPlanet, 3 = specialPlanet
		planetExplored = newPlanetExplored;

	}

	public String getPlanetName() {
		return planetName;
	}

	public String getArrivalMessage() {
		return arrivalMessage;
	}

	public String getExploreMessage() {
		return exploreMessage;
	}

	public String getScanMessage() {
		return scanMessage;
	}

	public int getExploreFlag() {
		return exploreFlag;
	}

	public int getPlanetFlag() {
		return planetFlag;
	}

	public boolean isPlanetExplored() {
		return planetExplored;
	}

	public void setPlanetExplored(boolean value) {
		planetExplored = value;
	}

	//getPlanetList Moved to testPlanetMaker <---------------- SEE JCB

}
