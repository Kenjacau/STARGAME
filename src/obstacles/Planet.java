package obstacles;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/*
Class: Planet
TODO: Write class definition here.
- Author: @KCauthen
- TODO: Write your email address here.
- Version: 0.0.1
- TODO: Date goes here.    
*/
public class Planet {
	//TODO: Write this class. Stubbed for inclusion into the controllers.GameController class.
	private Enemy enemyInResidence = new Enemy(); //Stubbed for your convenience! 
	private String description = ""; 
	private String planetName = ""; 
	private static String[] planetList = new String[] {"WASP -12b", "Theta-10c", "Nore", "51 Pegasi b", "LV-426", "Shadowfax", 
			"Lisus", "Insula", "Heralda", "Kepler-11f", "Nasqueron", "Altair IV", "TrES-2b", 
			"55 Cancri e", "Gilese 436 b", "Rignus", "Helnetia", "Nitia", "Jor", "Jmea", 
			"Atani Starship", "Drabenus", "Eos", "Zaria-3a", "Alpha08c", "Prion", "Planet Z", 
			"Waldovo", "Genesis", "Gaia"}; //I entered these to get myself a list of planets in the GameController. --JCB
	private static Random randomGenerator; 
	
	public Enemy getEnemy()  {
		//TODO: Return an enemy for the GameController class.
		return enemyInResidence; 
	}
	public String getPlanetName() {
		// TODO Auto-generated method stub
		return planetName;
	}
	public String getDescription() {
		// TODO Auto-generated method stub
		return description;
	}
	public char[] getExploreMessage() {
		// TODO Auto-generated method stub
		return null;
	}
	public char[] getScanMessage() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static String[] getPlanetList() {
		return planetList;
	}
	
	public  Planet(String name) {
		//TODO: Constructor with args. I added "name" just to get shit started. --JCB
		this.planetName = name; 
	}
	
	public static boolean isBossPlanet() {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**getRandomPlanet
	 * STATIC METHOD
	 * Returns the name of a random planet. 
	 * @param availablePlanets An arrayList of Strings: available planet names.  
	 * @return A single, random element in the paramater. 
	 */
	public static String getRandomPlanet(ArrayList<String> availablePlanets) {
		int index = ThreadLocalRandom.current().nextInt(0, availablePlanets.size());
		return availablePlanets.get(index); 
	}
}
