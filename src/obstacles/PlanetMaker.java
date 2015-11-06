package obstacles;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Class: testPlanetMaker
 * Description: This defines all the methods and attributes needed to create all Planet objects and set to arraylist
 *
 * @author Kenny Cauthen
 * @version 0.0.1, 11/5/2015
 *          Course: ITEC 3860 Fall 2015
 *          Assignment: Final Project
 */
public class PlanetMaker {
	ArrayList<Planet> planetArrayList;
	private static String[] planetList = new String[]{"WASP -12b", "Theta-10c", "Nore", "51 Pegasi b", "LV-426", "Shadowfax",
			"Lisus", "Insula", "Heralda", "Kepler-11f", "Nasqueron", "Altair IV", "TrES-2b",
			"55 Cancri e", "Gilese 436 b", "Rignus", "Helnetia", "Nitia", "Jor", "Jmea",
			"Atani Starship", "Drabenus", "Eos", "Zaria-3a", "Alpha08c", "Prion", "Planet Z",
			"Waldovo", "Genesis", "Gaia"}; //I entered these to get myself a list of planets in the GameController. --JCB

	private static String[] exploreMessageList;

	private static String[] scanMessageList;

	private static String[] arrivalMessageList;


	public PlanetMaker() {
		Collections.addAll(planetArrayList,
				new Planet(planetList[0], "Test Planet 1 Arrival Message", "Test Planet 1 Scan Message",
						"Test Planet 1 Explore Message", 0, 0, false),
				new Planet(planetList[1], "Test Planet 2 Arrival Message", "Test Planet 2 Scan Message",
						"Test Planet 2 Explore Message", 0, 0, false),
				new Planet(planetList[2], "Test Planet 3 Arrival Message", "Test Planet 3 Scan Message",
						"Test Planet 3 Explore Message", 0, 0, false)

		);

	}

	public ArrayList<Planet> getPlanetArrayList() {
		return planetArrayList;
	}

	//getPlanetList removed, Edited source.

}
