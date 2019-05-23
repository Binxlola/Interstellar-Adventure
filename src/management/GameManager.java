package management;

import javax.swing.Icon;

import crewManagement.Crew;
import crewManagement.SpaceShip;
import environment.Environment;
import gameEvents.RandomEvent;

/**
 * Control center of a players game.
 * @author Jason Smit
 * @author Ariel Evangelista
 */
public class GameManager {
	private static GameManager _session;
	
	private int gameDuration;
	private int currentDay;
	private int partsFound;
	private int partsToFind;
	private Crew crew = Crew.getInstance();
	private SpaceShip spaceShip = SpaceShip.getInstance();
	
	private boolean gameResult;
	private String gameComment;
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
	 * @param duration
	 * @param size
	 * @param name
	 * @param shipIcon
	 */
	public void initializeManager(int duration, String name, Icon shipIcon) {
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
	 * @param score The score of the player
	 */
	public void endGame(boolean result, String message) {
		this.gameResult = result;
		this.gameComment = message;
		int extraScore = 0;
		extraScore += (getGameDuration() - getCurrentDay()) * 1000;
		extraScore += (getPartsToFind() * 100) * (getPartsFound() / getPartsToFind());
		extraScore += crew.getAlive() * 100;
		addGameScore(extraScore);
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
