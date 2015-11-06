package obstacles;

/*
Class: Enemy
TODO: Write class definition here.
- Author: @tkeating
- TODO: Write your email addresss here.
- Version: 0.0.0
- TODO: Date goes here.    
*/
public class Enemy {
	//TODO: Write this class. Stubbed for inclusion into the controllers.GameController class.
	//Need Enemy constructor that takes in String of planetName.
	public Enemy(String originPlanet) {
	}
	
	//Declare enemy specific Attributes
	private String enemyName;
	private String enemyDescription;
	private String enemyLocation;
	private int ambushStatus;

	/**
	 * CONSTRUCTOR FOR ENEMIES with super()
	 * @param enemyName
	 * @param enemyDescription
	 * @param enemyLocation
	 * @param ambushStatus
	 * 
	 * CREATED: 11/3/15
	 * LAST EDITED ON: 11/3/15  BY: Travis K.
	 */
	public Enemy(String enemyName, String enemyDescription, String enemyLocation, int ambushStatus) {
		super();
		
		this.enemyName = enemyName;
		this.enemyDescription = enemyDescription;
		this.enemyLocation = enemyLocation;
		this.ambushStatus = ambushStatus;
	}

	
	
	/**
	 * @return the enemy name
	 */
	
	public String getEnemyName() {
		return enemyName;
	}
	
	/**
	 * @return the enemy description
	 */
	public String getEnemyDescription() {
		return enemyDescription;
	}
	
	/**
	 * @return the enemy location
	 */
	public String getEnemyLocation() {
		return enemyLocation;
	}
	
	/**
	 * @return the ambush status
	 * 
	 * Note to Self: 
	 * 		When ambushStatus == 0 -> not an ambush
	 * 		When ambushStatus == 1 -> is an ambush
	 * 	I'm assuming this is what ambushStatus is supposed to be?
	 * 		--Travis K.
	 */
	public int getAmbushStatus() {
		return ambushStatus;
	}


////Implement Combat Interface
//	public int attack(int attackPoints, int defensePoints) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//	
    //private int[] enemyList;
		/* I'm leaving enemyList out for now, I don't think it has much
		 * use in this class, Let me know if you want here --Travis K*/
	
	
}

