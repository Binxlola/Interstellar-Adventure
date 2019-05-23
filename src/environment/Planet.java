package environment;

import java.util.Random;

import management.*;

/** Represents an planet found in the game environment.
 * @author Jason Smit
 * @author Ariel Evangelista
*/
public class Planet {
	
	private GameManager gameManager = GameManager.getInstance();
	private Boolean pieceFound = false;
	private String planetName = ""; // randomly given from a list of names
	private boolean visited = false;
	
	public Planet(String name) {
		this.planetName = name;
	}
	
	public String getName() {
		return this.planetName;
	}
	
	@Override
	public String toString() {
		String visitedString = "Not yet visited";
		String partString = "Ship Part not yet found";
		if(this.visited) {
			visitedString = "Already Visited";
		}
		if(this.pieceFound) {
			partString = "Ship Part already found";
		}
		return String.format("%s (%s, %s.)", this.planetName, visitedString, partString);
	}
	
	/*
	 * Returns information about the planet exploration
	 */
	public String getInfo() {
		String visitedString = "First time visit";
		String partString = "Ship Part not yet found";
		if(this.visited) {
			visitedString = "Already Visited";
		}
		if(this.pieceFound) {
			partString = "Ship Part already found";
		}
		return String.format("%s, %s.", visitedString, partString);
	}
	
	/**
	 * Sets the planet as already visited
	 */
	public void visited() {
		int scoreRoll = (int) (100 * new Random().nextDouble());
		new AddGameScore(scoreRoll);
		this.visited = true;
	}
	
	public void pieceFound() {
		this.gameManager.partFound();
		int scoreRoll = (int) (300 * new Random().nextDouble());
		new AddGameScore(scoreRoll);
		this.pieceFound = true;
	}
	
	/**
	 * Checks if a part is already found on the planet
	 * @return
	 */
	public boolean isPieceFound() {
		return this.pieceFound;
	}
	
	/**
	 * Checks if a planet is already visited
	 * @return
	 */
	public boolean isVisited() {
		return this.visited;
	}
}
