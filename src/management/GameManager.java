package management;

import javax.swing.Icon;

import crewManagement.Crew;
import crewManagement.SpaceShip;
import environment.Environment;
import gameEvents.RandomEvent;
import itemManagement.Inventory;
import itemManagement.Item;

/**
 * Control center of a players game.
 * @author Jason Smit
 * @author Ariel Evangelista
 */
public class GameManager {
	
	/**
	 * The session of the GameManager, there can only be one
	 */
	private static GameManager _session;
	
	/**
	 * The duration of the game in days
	 */
	private int gameDuration;
	
	/**
	 * The current day of the game
	 */
	private int currentDay;
	
	/**
	 * The current parts found
	 */
	private int partsFound;
	
	/**
	 * The total parts to find
	 */
	private int partsToFind;
	
	/**
	 * The one and only one instance of Crew class
	 */
	private Crew crew = Crew.getInstance();
	
	/**
	 * The one and only one instance of SpaceShip class
	 */
	private SpaceShip spaceShip = SpaceShip.getInstance();
	
	/**
	 * The one and only one instance of Inventory class
	 */
	private Inventory inv = Inventory.getInstance();
	
	/**
	 * The boolean result of the game
	 */
	private boolean gameResult;
	
	/**
	 * The comments why is the game resulted in the gameResult
	 */
	private String gameComment;
	
	/**
	 * The current score for the game
	 */
	private int gameScore;

	
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
	 * @param duration	The duration of the game in days
	 * @param name The name of the ship
	 * @param shipIcon The icon of the ship
	 */
	public void initializeManager(int duration, String name, Icon shipIcon) {
		this.partsFound = 0;
		this.setDuration(duration);
		spaceShip.initializeShip(name, shipIcon);
		this.setPartsToFind(duration);
		this.currentDay = 1;
		this.gameScore = 0;
		Environment env = Environment.getInstance();
		env.buildEnvironment(gameDuration);
	}
	
	/**
	 * Stores the result of the game
	 * @param result True for win, false for lose
	 * @param message Some message why a win or a lose happened
	 */
	public void endGame(boolean result, String message) {
		this.gameResult = result;
		this.gameComment = message;
		int extraScore = 0;
		extraScore += (getGameDuration() - getCurrentDay()) * 1000;
		extraScore += ((10 - getGameDuration()) * 500);
		extraScore += (getPartsToFind() * 100) * (getPartsFound() / getPartsToFind());
		extraScore += crew.getAlive() * 100;
		extraScore += ((4 - crew.size()) * 3000);
		extraScore += inv.getCoins() * 5;
		for (Item item: inv.getFoods()) {
			extraScore += item.getPrice() * item.getCount() * 5;
		}
		for (Item item: inv.getPotions()) {
			extraScore += item.getPrice() * item.getCount() * 5;
		}
		addGameScore(extraScore);
		
		inv.resetInv();
	}
	
	/**
	 * Returns the result of the game
	 * @return String representation of the game result
	 */
	public String getGameResult() {
		if (gameResult) return "YOU WIN!";
		return "YOU LOSE!";
	}
	
	/**
	 * Get the comments about the game result
	 * @return Comments about the game result
	 */
	public String getGameComment() {
		return this.gameComment;
	}
	
	/**
	 * Get the overall score achieved in the game
	 * @return The overall score achieved by the player
	 */
	public int getGameScore() {
		return this.gameScore;
	}
	
	/**
	 * Add a certain amount of score for the player
	 * @param amount The amount to add to the score
	 */
	public void addGameScore(int amount) {
		this.gameScore += amount;
	}
	
	/**
	 * Sets the game duration to the given Integer value 'duration'.
	 * @param duration An Integer that represents how long the player would like a game to last.
	 */
	private void setDuration(int duration) {
		this.gameDuration = duration;
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
	
	public boolean startNewDay() {
		// Move to new day if possible.
		if(!this.endGame()) {
			this.currentDay += 1;
			crew.newDay();
			if (crew.getAlive() > 0) {
				new RandomEvent();
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	/**
	 * Adds 1 to the partsFound
	 */
	public void partFound() {
		partsFound +=1;
	}
	
	/**
	 * Deducts 1 to the partsFound
	 */
	public void partStolen() {
		partsFound -= 1;
	}
	
	/**
	 * Checks if the player already found all the parts required
	 * @return Returns true if the player already found all the parts required
	 */
	public boolean allPartsFound() {
		if (this.partsFound >= this.partsToFind) {
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
		if (this.currentDay < this.gameDuration) {
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
