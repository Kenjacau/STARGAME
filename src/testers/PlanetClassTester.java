package testers;

import obstacles.Planet;
import obstacles.PlanetMaker;

import java.util.ArrayList;

/**
 * Class: PlanetClassTester
 * Description:
 *
 * @author Kenny Cauthen
 *         kcauthen@ggc.edu
 * @version 0.0.1, 11/14/2015
 *          Course: ITEC 3150 Fall 2015
 *          Assignment: Final Project
 */
public class PlanetClassTester {
	public static void main(String[] args) {

		ArrayList<Planet> testingPlanets = new PlanetMaker().getPlanetArrayList();
		int count = 1;
		for (Planet p : testingPlanets) {
			System.out.println("Test " + count + " Should Print Planet Name:: " + p.getPlanetName());
			System.out.println("Test " + count + " Should Print Arrival Message:: " + p.getArrivalMessage());
			System.out.println("Test " + count + " Should Print Explore Message:: " + p.getExploreMessage());
			System.out.println("Test " + count + " Should Print Scan Message:: " + p.getScanMessage());
			System.out.println("Test " + count + " Should Print Integer Value less than 3 for Explore Flag:: " + p.getExploreFlag());
			System.out.println("Test " + count + " Should Print Integer Value less than 4 for Planet Flag:: " + p.getPlanetFlag());
			System.out.println("Test " + count + " Should Print Boolean Value False for Planet Explored:: " + p.isPlanetExplored());
			System.out.println("Test " + count + " Changing boolean for planet:: " + p.getPlanetName());
			p.setPlanetExplored(true);
			System.out.println("Test " + count + " Should Now Print Boolean Value True for Planet Explored:: " + p.isPlanetExplored());
			count++;
		}


	}
}
