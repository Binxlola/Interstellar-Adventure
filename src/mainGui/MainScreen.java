package mainGui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainScreen {

	private JFrame frame;
	private GuiManager manager;

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
		JPanel gameNav = new GameNavigation();
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(gameNav);
	}

}
