package management;

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
}
