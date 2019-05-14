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
	private GameManager gameManager = GameManager.getInstance();
	private Environment environment = Environment.getInstance();
	private Crew crew = Crew.getInstance();
	private boolean visited = false;
	
	public Planet(String name) {
		this.planetName = name;
	}
	
	public String getName() {
		return this.planetName;
	}
	
	/**
	 * A method that take a given crew member and search the current planet for a random item.
	 * @param searchMember A CrewMember that will perform the search action and have a move point deducted.
	 */
	/* Disabled until Item Wheel is implemented
	private void searchPlanet(CrewMember searchMember) {
		ItemWheel itemWheel = environment.getWheel(); // Get the itemWheel
		Item item = itemWheel.getItem(); // Drop a random item

		if(pieceFound || gameManager.allPartsFound()) { // Can only find one Ship Part per planet
			while(item.getName() == "Ship Part") {
				item = itemWheel.getItem();
			}
		}
		
		Inventory inventory = Inventory.getInstance(); // Open players inventory instance
		inventory.addItem(item); // add dropped item to players inventory
		
		// No item dropped case
		if(item == null) {
			System.out.println("You did not find anything.");
		}
		else {
			System.out.println(item.getName() + " has been found and added to your inventory.");
			// Set this planets part found to true
			if(item.getName() == "Ship Part") {
				pieceFound = true;
				gameManager.partFound();
				System.out.println("\nNOTE: You can not find anymore ship parts on this planet.");
			}

		}
	}
	*/
	
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
	
	/**
	 * A method that controls the main loop for planet interactions.
	 */
	/* Will be re-implemented to fit the GUI
	public void planetLoop() {
		if(!this.visited) {
			this.visited = true;
		}
		System.out.println("\nWould you like to search " + planetName + "for items?");
		Utilities.presentOptions(new String[]{"Yes", "No (This will move you to a new location in space, and your move points will NOT be refunded)."});
		int input = Utilities.getInputInt(new String[] {"Yes", "No"}, "Your selection is invalid, please try again.");
		
		switch(input) {
		case 1:
			System.out.println("Select the crew member you would like to search the planet.");
			crew.presentCrew();
			CrewMember searchCrew = crew.selectCrewMember();
			searchCrew.deductMove();
			searchPlanet(searchCrew);
			planetLoop();
			break;
		case 2:
			gameManager.gameLoop();
			break;
		}
	}
	*/

}
