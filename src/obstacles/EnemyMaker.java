package obstacles;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Class: EnemyMaker
 * Description:
 *
 * @author Kenny Cauthen
 *         kcauthen@ggc.edu
 * @version 0.0, 11/14/2015
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
	private final String[] enemyLocation = new String[]
	{ "WASP-12b", "Theta-10c", "EMPTY SPACE", "LV-426", "insula", "Gas Giants",
			"Altair IV", "Rignus", "Helnetia" };

	//Enemy Description
	private final String[] enemyDescription = new String[]
	{ "Space Pirate Desc.", "Alien Warriors Desc.", "Amber Eyes Desc.",
			"Parasitic Aliens Desc.", "Hooded Figure Desc.",
			"Gas Giant Dwellers Desc.", "Invisible Monster Desc.",
			"Reptilian Dog Desc.", "Giant Serpant Desc." };
	
	//Create Array List to hold enemies
	private ArrayList<Enemy> enemyArrayList = new ArrayList<>();
	
	//Populate enemyArrayList
	public EnemyMaker(){
		Collections.addAll(enemyArrayList,
				//Enemy Name, Ambush Status, Attack Points, Defense Points, Health, Enemy Location, Enemy Description
				new Enemy(enemyList[0], ambushStatus[0], attackPoints[0], defensePoints[0], health[0], enemyLocation[0], enemyDescription[0]));
	}
	
	public ArrayList<Enemy> getEnemyArrayList() {
		return enemyArrayList;
	}
}
