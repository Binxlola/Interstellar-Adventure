package management;

public class AddGameScore {
	
	private GameManager gameManager = GameManager.getInstance();

	public AddGameScore(int score) {
		gameManager.addGameScore(score);
	}
}
