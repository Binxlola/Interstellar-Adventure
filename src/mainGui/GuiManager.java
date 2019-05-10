package mainGui;

/**
 * Control center for the core GUI functionality, primarily acting as a middle man between the main screen and content panes.
 * @author jasonsmit
 *
 */
public class GuiManager {
	
	/**
	 * Launches the SetupScreen which will be the entry point to the game.
	 */
	public void startGame() {
		this.launchSetup();
	}
	
	/**
	 * Create a SetupScreen class.
	 */
	private void launchSetup() {
		@SuppressWarnings("unused")
		SetupScreen setupWindow = new SetupScreen(this);
	}
	
	/**
	 * Closes the given SetupScreen, and call the method to start the main window.
	 * @param setupWindow A SetupScreen that refers to the window that needs to be closed.
	 */
	public void closeSetupScreen(SetupScreen setupWindow) {
		setupWindow.closeWindow();
		this.launchMain();
	}
	
	/**
	 * Starts up the main screen of the game
	 */
	private void launchMain() {
		@SuppressWarnings("unused")
		MainScreen mainWindow = new MainScreen(this);
	}
	
	/**
	 * Will create a new PlanetMain JPanel,
	 * @return Will return a PlanetMain JPanel that will then be loaded onto the main screen.
	 */
	public PlanetMain getPlanetPanel(MainScreen window) {
		PlanetMain content = new PlanetMain(window);
		return content;
	}
}
