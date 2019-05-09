package mainGui;

import javax.swing.JPanel;
import javax.swing.JButton;

public class GameNavigation extends JPanel {

	/**
	 * Create the panel.
	 */
	public GameNavigation() {
		setLayout(null);
		setBounds(0, 0, 994, 571);
		
		JButton travelPlanetBtn = new JButton("Travel to planet");
		travelPlanetBtn.setBounds(0, 0, 140, 29);
		add(travelPlanetBtn);

	}
}
