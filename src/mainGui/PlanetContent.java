package mainGui;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PlanetContent extends JPanel {


	/**
	 * Create the panel.
	 */
	public PlanetContent() {
		setBounds(0, 0, 1000, 600);
		setLayout(null);
		
		// ======Nav Buttons======
		JButton travelPlanetBtn = new JButton("it worked");
		travelPlanetBtn.setBounds(0, 0, 140, 30);
		add(travelPlanetBtn);
	}

}
