package mainGui;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainScreen {

	private JFrame frame;
	private GuiManager manager;
	private JPanel mainScreen;

	/**
	 * Create the application.
	 */
	public MainScreen(GuiManager incomingManager) {
		initialize();
		this.manager = incomingManager;
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		mainScreen = new GameNavigation(this);
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setContentPane(mainScreen);
		
	}
	
	/**
	 * Will clear all content from window, close it.
	 */
	public void closeWindow() {
		frame.dispose();
	}
	
	/**
	 * Uses the GuiManager close function to clear contents from frame and close application.
	 */
	public void finishedWindow() {
		manager.finishGame(this);
	}
	
	/**
	 * Will set the frames content pane to the given JPanel.
	 * @param panel A JPanel that displays the content that should be loaded onto the frame.
	 */
	private void setContent(JPanel panel) {
		frame.setContentPane(panel);
	}
	
	/**
	 * This will call setContent giving a specific component to be loaded to the frames content pane.
	 * @param type A String that describes what content panel should be retrieved and loaded.
	 */
	public void changeContent(String type) {
		JPanel content;
		switch(type) {
		case "TravelCrewSelect":
			content = manager.getTravelCrewPanel(this);
			this.setContent(content);
			break;
		case "TravelPlanetSelect":
			content = manager.getTravelPlanetPanel(this);
			this.setContent(content);
			break;
		case "PlanetMain":
			content = manager.getPlanetMain(this);
			this.setContent(content);
			break;
		case "mainScreen":
			this.setContent(mainScreen);
			break;
		case "Inventory":
			content = manager.getInventoryPanel(this);
			this.setContent(content);
			break;
		case "Outpost":
			content = manager.getOutpostPanel(this);
			this.setContent(content);
			break;
		}
	}
}
