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
	private final String[] planetList = new String[]{"WASP -12b", "Theta-10c", "Nore", "51 Pegasi b", "LV-426", "Shadowfax",
			"Lisus", "Insula", "Heralda", "Kepler-11f", "Nasqueron", "Altair IV", "TrES-2b",
			"55 Cancri e", "Gilese 436 b", "Rignus", "Helnetia", "Nitia", "Jor", "Jmea",
			"Atani Starship", "Drabenus", "Eos", "Zaria-3a", "Alpha08c", "Prion", "Planet Z",
			"Waldovo", "Genesis", "Gaia"}; //I entered these to get myself a list of planets in the GameController. --JCB
	private final String[] exploreMessageList = new String[]{"Test ExploreMessage 1", "Test ExploreMessage 2",
			"Test ExploreMessage 3"};
	private final String[] scanMessageList = new String[]{"Test ScanMessage 1", "Test ScanMessage 2", "Test ScanMessage 3"};
	private final String[] arrivalMessageList = new String[]{"Test ArrivalMessage 1", "Test ArrivalMessage 2",
			"Test ArrivalMessage 3"};
	static ArrayList<Planet> planetArrayList = new ArrayList<>();


	public PlanetMaker() {
		Collections.addAll(planetArrayList,
				//Planet Name, Arrival Message,Scan Message, Explore Message, Explore Flag, Planet Flag, Planet Explored)
				new Planet(planetList[3], arrivalMessageList[0], scanMessageList[0], exploreMessageList[0], 0, 3, false),
				new Planet(planetList[4], arrivalMessageList[1], scanMessageList[1], exploreMessageList[1], 2, 0, false),
				new Planet(planetList[5], arrivalMessageList[2], scanMessageList[2], exploreMessageList[2], 2, 2, false)
		);

	}

	public static ArrayList<Planet> getPlanetArrayList() {
		return planetArrayList;
	}

}
