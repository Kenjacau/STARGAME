package obstacles;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Class: EnemyMaker
 * Description: Creates and populates an arrayList with enemies
 *
 * @author Kenny Cauthen
 *         kcauthen@ggc.edu
 *         Travis Keating
 *         tkeating@ggc.edu
 * @version 0.5, 11/20/2015
 *          Course: ITEC 3150 Fall 2015
 *          Assignment:
 */
//TODO Travis I Need an Arraylist of all enemies. Similar to how I implemented PlanetMaker and PuzzleMaker.
public class EnemyMaker
{
	//Enemy Name
	private final String[] enemyList = new String[]
	{ "Space Pirates", "Alien Warriors", "Amber Eyes", "Parasitic Aliens",
			"Hooded Figure", "Gas Giant Dwellers", "Invisible Monster",
			"Reptilian Dogs", "Giant Serpent" };

	//Ambush Status
	private final int[] ambushStatus = new int[]
	{ 1, 1, 1, 0, 0, 1, 1, 0, 0 };

	//Attack Points
	private final int[] attackPoints = new int[]
	{ 20, 0, 25, 15, 10, 15, 10, 20, 20 };

	//Defense Points
	private final int[] defensePoints = new int[]
	{ 0, 0, 0, 0, 0, 0, 0, 0, 0 };

	//Health Points
	private final int[] health = new int[]
	{ 120, 999, 100, 40, 50, 75, 75, 80, 80 };

	//Enemy Locations
	private final String[] enemyLocation = new String[]{"WASP-12b", "Theta-10c", "Nore", "LV-426", "Insula", "Gas " +
			"Giants",
			"Altair IV", "Rignus", "Helnetia" };

	//Enemy Description
	private final String[] enemyDescription = new String[]
	{
			//Space Pirate description text
			"*The hull of the ship shakes. you see red plasma bolts fly past the "
			+ "cockpit* CAPTAIN! We have a squad of pirates at 6 O'clock!",

			//Alien Warriors description text
			"*A massive dark ship covered in enough spikes to classify it as a boss"
			+ " appears from hyperspace right in front of the ship. The com-link crackles"
			+ " to life* You have one chance human! Rock, Paper, or Scissors?",

			//Amber Eyes description text
			"*The planet disappears from the ships contact list. The ship loses power"
			+ " and drifts slowly through space. Slowly, a mist envelopes the ship and"
			+ " seeps through each deck. Sharp as flames, a massive beast appears before"
			+ " the ship within a gaseous body and unleashes a bellowing roar.*",

			//Parasitic Aliens description text
			"*Strange flesh colored pods encased in metal surround the ship* Captain! Our "
			+ "scanners are showing that these are parasitic life forms encased in defensive"
			+ " vessels. We cannot allow them on board!",

			//Hooded Figure description text
			"*A tall hooded figure appears from the mist, he raises his hand and you feel "
			+ "your airways slowly closing. It's now or never. There isn't much time left"
			+ " you have to stop him before you and your whole crew dies!*",

			//Gas Giant Dwellers description text
			"*Out of the gaseous atmosphere of the planet before you arise several ghostly"
			+ " ships that appear to be half synthetic and half organic* Captain! Sensors"
			+ " are reading that each of those vessels is a single organism!",

			//Invisible Monster description text
			"*The vessel shudders and shakes* Captain! We aren't getting any visual or"
			+ " thermal signals but the electromagtronosphere is spiking like crazy! I "
			+ "don't know where or what this thing is but if we don't stop it we'll be torn"
			+ " to shreds!",

			//Reptilian Dogs description text
			"*Your ship soon lands, and the animals scatter through the forest. When you "
			+ "set foot outside, you notice that the air around you has shifted, and a "
			+ "strange sound if coming your way. You turn your head towards the noise, "
			+ "and see 3 creatures sprinting towards you. It's time to fight.*",

			//Giant Serpent description text
			"*As you begin setting down over an azure blue lake a massive tendril "
			+ "shoots out of the water and begins to crush the ship. You hear the "
			+ "creaking of the ship hull as it slowly succumbs to the serpents vice grip"
			+ ". It looks like you'll be fighting this one on foot* Captain! I'll grab the"
			+ " hover boards!" };

	//Create Array List to hold enemies
	private ArrayList<Enemy> enemyArrayList = new ArrayList<>();

	//Populate enemyArrayList
	public EnemyMaker()
	{
		Collections.addAll(enemyArrayList,
				//Enemy Name, Ambush Status, Attack Points, Defense Points, Health, Enemy Location, Enemy Description
				new Enemy(enemyList[0], ambushStatus[0], attackPoints[0],
						defensePoints[0], health[0], enemyLocation[0],
						enemyDescription[0]),
				new Enemy(enemyList[1], ambushStatus[1], attackPoints[1],
						defensePoints[1], health[1], enemyLocation[1],
						enemyDescription[1]),
				new Enemy(enemyList[2], ambushStatus[2], attackPoints[2],
						defensePoints[2], health[2], enemyLocation[2],
						enemyDescription[2]),
				new Enemy(enemyList[3], ambushStatus[3], attackPoints[3],
						defensePoints[3], health[3], enemyLocation[3],
						enemyDescription[3]),
				new Enemy(enemyList[4], ambushStatus[4], attackPoints[4],
						defensePoints[4], health[4], enemyLocation[4],
						enemyDescription[4]),
				new Enemy(enemyList[5], ambushStatus[5], attackPoints[5],
						defensePoints[5], health[5], enemyLocation[5],
						enemyDescription[5]),
				new Enemy(enemyList[6], ambushStatus[6], attackPoints[6],
						defensePoints[6], health[6], enemyLocation[6],
						enemyDescription[6]),
				new Enemy(enemyList[7], ambushStatus[7], attackPoints[7],
						defensePoints[7], health[7], enemyLocation[7],
						enemyDescription[7]),
				new Enemy(enemyList[8], ambushStatus[8], attackPoints[8],
						defensePoints[8], health[8], enemyLocation[8],
						enemyDescription[8]));
	}

	public ArrayList<Enemy> getEnemyArrayList()
	{
		return enemyArrayList;
	}

}

