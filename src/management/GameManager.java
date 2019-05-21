package management;

import crewManagement.Crew;
import environment.Environment;

/**
 * Control center of a players game.
 * @author Jason Smit
 * @author Ariel Evangelista
 */
public class GameManager {
	private static GameManager _session;
	
	private int gameDuration;
	private int crewSize;
	private String shipName;
	private int currentDay;
	private int partsFound;
	private int partsToFind;
	private Crew crew = Crew.getInstance();

	
	/**
	 * Private constructor, object can only be created from and inside call to the constructor.
	 */
	private GameManager() {}
	
	/**
	 * Acts as a constructor, so the object can either be created or grabbed from the outside.
	 * @return Will return the GameManager instance.
	 */
	public static GameManager getInstance() {
		if(_session == null) {
			_session = new GameManager();
		}
		return _session;
	}
	
	/**
	 * A method that is intended to be used after the creation of the GameManager instance, allowing key game parameters to be passed in.
	 * @param duration
	 * @param size
	 * @param name
	 */
	public void initializeManager(int duration, int size, String name) {
		this.setDuration(duration);
		this.setCrewSize(size);
		this.setShipName(name);
		this.setPartsToFind(duration);
		this.currentDay = 1;
		Environment env = Environment.getInstance();
		env.buildEnvironment(gameDuration);
		System.out.println(this.gameDuration);
		System.out.println(this.crewSize);
		System.out.println(this.shipName);
		System.out.println(env.getPlanets().size());
	}
	
	/**
	 * Sets the game duration to the given Integer value 'duration'.
	 * @param duration An Integer that represents how long the player would like a game to last.
	 */
	private void setDuration(int duration) {
		this.gameDuration = duration;
	}
	
	/**
	 * Sets the crew size to the given Integer value 'size'.
	 * @param size An integer that represents how big the players crew is.
	 */
	private void setCrewSize(int size) {
		this.crewSize = size;
	}
	
	/**
	 * Sets the ship name to the given String 'name'.
	 * @param name A String that represents the players desired ship name.
	 */
	private void setShipName(String name) {
		this.shipName = name;
	}
	
	/**
	 * A method to calculate and set the number of ship parts to find, based on the players desired game length.
	 * @param duration An Integer value describing the players desired game length.
	 */
	private void setPartsToFind(int duration) {
		double temp = (2.0/3.0) * (double)duration;
		int parts = (int)temp;
		partsToFind = parts;
		
	}
	
	public void startNewDay() {
		// Move to new day if possible.
		if(!this.endGame()) {
			this.currentDay += 1;
			crew.resetCrewMoves(); // reset all crew member move counts.
			// RANDOM OCCURENCE
			//alienPirates.randomAttack();
		}
		else {
			System.out.println("You have reached the end of your " + this.gameDuration + " day journey.");
			
			if(this.allPartsFound()) {
				System.out.println("You have found all the missing ship parts, you need to install them to win the game.");
			}
			else {
				// Need to run a check to see if the player could possibly still find and install the missing parts............
				System.out.println("You are still missing " + this.partsToFind + " Ship Parts, find and install them to win the game." );
			}
			// NOT COMPLETE
		}
	}
	
	/**
	 * Adds 1 to the partsFound and subtracts 1 to the partsToFind
	 */
	public void partFound() {
		partsToFind -= 1;
		partsFound +=1;
	}
	
	/**
	 * Checks if the player already found all the parts required
	 * @return Returns true if the player already found all the parts required
	 */
	public boolean allPartsFound() {
		if(this.partsFound == this.partsToFind) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Get the current day of the game
	 * @return Current day of the game
	 */
	public int getCurrentDay() {
		return this.currentDay;
	}
	
	/**
	 * Get the duration of the game
	 * @return The duration of the game
	 */
	public int getGameDuration() {
		return this.gameDuration;
	}
	
	/**
	 * Checks if the game already reached the last day
	 * @return True if the game reached the last day
	 */
	public boolean endGame() {
		if (this.currentDay <= this.gameDuration) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * Gets the remaining ship parts to find
	 * @return The number of ship parts to find
	 */
	public int getPartsToFind() {
		return this.partsToFind;
	}
	
	/**
	 * Gets the current number of ship parts found
	 * @return The number of ship parts already found
	 */
	public int getPartsFound() {
		return this.partsFound;
	}
}
