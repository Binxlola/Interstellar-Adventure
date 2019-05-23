import mainGui.GuiManager;

/**
 * The main class to run the Interstellar Adventure!
 * @author Jason Smit
 * @author Ariel Evangelista
 * @version 1.0, May 2019.
 */
public class Main {
	
	/**
	 * Start the game by calling the GUI manager
	 * @param args
	 */
	public static void main(String[] args) {
		GuiManager game = new GuiManager();
		game.startGame();
	}
}
