package environment;

import java.util.Random;

import management.*;

/** Represents an planet found in the game environment.
 * @author Jason Smit
 * @author Ariel Evangelista
*/
public class Planet {
	
	/**
	 * The one and only one instance of the GameManager class
	 */
	private GameManager gameManager = GameManager.getInstance();
	
	/**
	 * Reflects if a piece is already found on this planet
	 */
	private Boolean pieceFound = false;
	
	/**
	 * The name of the planet
	 */
	private String planetName = ""; // randomly given from a list of names
	
	/**
	 * Reflect if the planet is already visited by the player or not
	 */
	private boolean visited = false;
	
	/**
	 * Constructor initializing the planet with name
	 * @param name The name of the planet
	 */
	public Planet(String name) {
		this.planetName = name;
	}
	
	/**
	 * String representation of the name of the planet
	 * @return The name of the planet
	 */
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
	
	/**
	 * Information about the planet exploration
	 * @return The string describing the exploration
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
	
	/**
	 * Sets the planet as already found a ship part
	 */
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
