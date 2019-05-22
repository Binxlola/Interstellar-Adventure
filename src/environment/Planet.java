package environment;

import crewManagement.Crew;
import itemManagement.Inventory;
import itemManagement.Item;
import management.*;

/** Represents an planet found in the game environment.
 * @author Jason Smit
 * @author Ariel Evangelista
*/
public class Planet {
	
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
		this.visited = true;
	}
	
	public void pieceFound() {
		this.pieceFound = true;
	}
	
	/**
	 * Checks if a part is already found on the planet
	 * @return
	 */
	public boolean isPieceFound() {
		return this.pieceFound;
	}
}
