package management;

/**
 * A helper class to be called to add a game score
 * @author Ariel Evangelista
 * @version 1.0, May 2019.
 */
public class AddGameScore {
	
	/**
	 * The one and only one instance of GameManager class
	 */
	private GameManager gameManager = GameManager.getInstance();

	/**
	 * Add game score to the current game
	 * @param score The score to be added
	 */
	public AddGameScore(int score) {
		gameManager.addGameScore(score);
	}
}
