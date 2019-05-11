package mainGui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;

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
		frame.setContentPane(mainScreen);
		
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
		switch(type) {
		case "Planet":
			JPanel content = manager.getPlanetPanel(this);
			this.setContent(content);
			break;
		case "mainScreen":
			this.setContent(mainScreen);
			break;
		}
	}

}