package controllers;

import java.util.ArrayList;

/*
Class: Game
The Game class is the primary interface between the captian, the planets, the puzzles, the bosses and all that stuff. 
- Author: @jbroughton
- joshua.c.broughton@gmail.com, jbroughton@ggc.edu
- Version: 0.0.0
- 2015-11-03    
*/
import obstacles.Enemy;
import obstacles.Planet;
import obstacles.Puzzle;
import playerCharacter.Captain;

public class Game {
	private Captain captain = new Captain(); 
	private ArrayList<Planet> planetsVisited; 
	private ArrayList<Enemy> bossesBeat; 
	private ArrayList<Puzzle> puzzlesSolved;
	private ArrayList<String> crew; 
	
	/**Game()
	 * CONSTRUCTOR
	 * @param captain The captain playing the game. 
	 * @param planetsVisisted The planets the captain has visited. 
	 * @param bossesBeat The bosses the captain has defeated. 
	 * @param puzzlesSolved The puzzles the captain has solved. 
	 */
	public Game(Captain captain, ArrayList<Planet> planetsVisisted, ArrayList<Enemy> bossesBeat, ArrayList<Puzzle> puzzlesSolved, ArrayList<String> crew) {
		super();
		this.captain = captain;
		this.planetsVisited = planetsVisisted;
		this.bossesBeat = bossesBeat;
		this.puzzlesSolved = puzzlesSolved;
		this.setCrew(crew); 
	}
	
	/**
	 * ONE ARG CONSTRUCTOR
	 */
	public Game() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the captain
	 */
	public Captain getCaptain() {
		return captain;
	}
	/**
	 * @param captain the captain to set
	 */
	public void setCaptain(Captain captain) {
		this.captain = captain;
	}
	/**
	 * @return the planetsVisited
	 */
	public ArrayList<Planet> getPlanetsVisited() {
		return planetsVisited;
	}
	/**
	 * @param planetsVisited the planetsVisited to set
	 */
	public void setPlanetsVisited(ArrayList<Planet> planetsVisited) {
		this.planetsVisited = planetsVisited;
	}
	/**
	 * @return the bossesBeat
	 */
	public ArrayList<Enemy> getBossesBeat() {
		return bossesBeat;
	}
	/**
	 * @param bossesBeat the bossesBeat to set
	 */
	public void setBossesBeat(ArrayList<Enemy> bossesBeat) {
		this.bossesBeat = bossesBeat;
	}
	/**
	 * @return the puzzlesSolved
	 */
	public ArrayList<Puzzle> getPuzzlesSolved() {
		return puzzlesSolved;
	}
	/**
	 * @param puzzlesSolved the puzzlesSolved to set
	 */
	public void setPuzzlesSolved(ArrayList<Puzzle> puzzlesSolved) {
		this.puzzlesSolved = puzzlesSolved;
	}

	/**
	 * @return the crew
	 */
	public ArrayList<String> getCrew() {
		return crew;
	}

	/**
	 * @param crew the crew to set
	 */
	public void setCrew(ArrayList<String> crew) {
		this.crew = crew;
	}
}
