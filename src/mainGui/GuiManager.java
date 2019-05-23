package mainGui;

/**
 * Control center for the core GUI functionality, primarily acting as a middle man between the main screen and content panes.
 * @author Jason Smit
 * @author Ariel Evangelista
 * @version 1.0, May 2019.
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
	 * Close up the main screen of the game and launch a new game
	 */
	public void finishGame(MainScreen mainScreen) {
		mainScreen.closeWindow();
		this.startGame();
	}
	
	/**
	 * Will create a new GameNavigation JPanel
	 * @param window The current MainScreen window who has the overall control
	 * @return Will return a GameNavigation JPanel that will be loaded onto the main screen.
	 */
	public GameNavigation getMainScreenPanel(MainScreen window) {
		GameNavigation content = new GameNavigation(window);
		return content;
	}
	
	/**
	 * Will create a new TravelCrewSelect JPanel,
	 * @return Will return a TravelCrewSelect JPanel that will then be loaded onto the main screen.
	 */
	public TravelCrewSelect getTravelCrewPanel(MainScreen window) {
		TravelCrewSelect content = new TravelCrewSelect(window);
		return content;
	}
	
	/**
	 * Will create a new TravelPlanetSelect JPanel
	 * @return Will return a TravelPlanetSelect JPanel that will then be loaded onto the main screen.
	 */
	public TravelPlanetSelect getTravelPlanetPanel(MainScreen window) {
		TravelPlanetSelect content = new TravelPlanetSelect(window);
		return content;
	}
	
	/**
	 * Will create a new PlanetMain JPanel
	 * @return Will return a PlanetMain JPanel that will then be loaded onto the main screen.
	 */
	public PlanetMain getPlanetMain(MainScreen window) {
		PlanetMain content = new PlanetMain(window);
		return content;
	}
	
	/**
	 * Will create a new InventoryDisplay JPanel
	 * @return Will return a InventoryDisplay JPanel that will then be loaded onto the main screen.
	 */
	public InventoryDisplay getInventoryPanel(MainScreen window) {
		InventoryDisplay content = new InventoryDisplay(window);
		return content;
	}
	
	/**
	 * Will create a new OutpostContent JPanel
	 * @return Will return a OutpostContent JPanel that will then be loaded onto the main screen.
	 */
	public OutpostContent getOutpostPanel(MainScreen window) {
		OutpostContent content = new OutpostContent(window);
		return content;
	}
	
	/**
	 * Will create a new CrewStatus JPanel
	 * @return Will return a CrewStatus JPanel that will then be loaded onto the main screen.
	 */
	public CrewStatus getCrewStatusPanel(MainScreen window) {
		CrewStatus content = new CrewStatus(window);
		return content;
	}
	
	/**
	 * Will create a new ShipStatus JPanel
	 * @return Will return a ShipStatus JPanel that will then be loaded onto the main screen.
	 */
	public ShipStatus getShipStatusPanel(MainScreen window) {
		ShipStatus content = new ShipStatus(window);
		return content;
	}
	
	/**
	 * Will create a new GameOver JPanel
	 * @return Will return a GameOver JPanel that will then be loaded onto the main screen.
	 */
	public GameOver getGameOverPanel(MainScreen window) {
		GameOver content = new GameOver(window);
		return content;
	}
}
