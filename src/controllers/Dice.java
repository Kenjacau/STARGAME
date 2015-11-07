package controllers;

import java.util.Random;

/**
 * Class: DiceRoll
 * Description: Methods and attributes to create a dice with certain amount of "sides".
 * Modifier is equal to percent chance of dice rolling in favor.
 *
 * @author Kenny Cauthen
 *         kcauthen@ggc.edu
 * @version 0.0.2, 11/7/2015
 *          Course: ITEC 3150 Fall 2015
 *          Assignment:
 */
public class Dice {
	private double modifier;

	/**
	 * Constructor: Dice()
	 * Description: Main constructor that creates a Dice with the ability to "roll".
	 *
	 * @param newModifier percent chance in favor of player
	 */
	public Dice(double newModifier) {
		modifier = newModifier;
	}

	/**
	 * Method: roll()
	 * Description: simulate dice roll
	 *
	 * @return boolean of dice rolling in favor of modifier
	 */
	public boolean roll() {
		boolean result;
		int randomNumber;
		Random rand = new Random();
		randomNumber = rand.nextInt(100) + 1;

		return randomNumber <= modifier;
	}
}
