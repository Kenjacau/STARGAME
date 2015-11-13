package testers;

import java.io.IOException;

import obstacles.Enemy;

/**
Class: EnemyTester
The Enemy class is a sub class of Persona that controls the creation of enemy objects. 
- Author: @TKeating
- tkeating@ggc.edu; arcane.supernova@gmail.com
- Version: 0.0.0
- 11/13/2015 
*/

public class EnemyClassTester {

	/**main()
	 * STATIC METHOD
	 * This serves as the starting point for the GameController class.
	 * @param args Command line arguments
	 * @throws IOException
	 */
	
	public static void main(String[] args) {
		Enemy lordSoth = new Enemy("Enemy Test", "Lord Soth", 1);
		
		String enemyDescription = lordSoth.getEnemyDescription();
		System.out.println(enemyDescription);
		
		String enemyLocation = lordSoth.getEnemyLocation();
		System.out.println(enemyLocation);
		
		int ambushStatus = lordSoth.getAmbushStatus();
		System.out.println(ambushStatus);

	}

}
