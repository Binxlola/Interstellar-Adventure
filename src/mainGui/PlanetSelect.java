package mainGui;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PlanetSelect extends JPanel {


	/**
	 * Create the panel.
	 */
	public PlanetSelect(MainScreen incomingWindow) {
		setBounds(0, 0, 1000, 600);
		setLayout(null);
		
		// ======Nav Buttons======
		JButton travelPlanetBtn = new JButton("it worked");
		travelPlanetBtn.setBounds(0, 0, 140, 30);
		add(travelPlanetBtn);
	}

}
