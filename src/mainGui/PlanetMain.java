package mainGui;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PlanetMain extends JPanel {

	/**
	 * Create the panel.
	 */
	public PlanetMain() {
		setBounds(0, 0, 1000, 600);
		setLayout(null);
		
		JButton travelOutpostBtn = new JButton("This worked!");
		travelOutpostBtn.setBounds(0, 30, 140, 30);
		add(travelOutpostBtn);
	}

}
