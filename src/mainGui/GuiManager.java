package mainGui;

public class GuiManager {
	
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
		System.out.println("this worked");
	}
	
	private void launchMain() {
		@SuppressWarnings("unused")
		MainScreen mainWindow = new MainScreen(this);
	}
	
	public PlanetMain getPlanetPanel() {
		PlanetMain content = new PlanetMain();
		return content;
	}
}
