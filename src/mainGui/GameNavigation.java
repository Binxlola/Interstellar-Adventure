package mainGui;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;

public class GameNavigation extends JPanel {

	/**
	 * Create the panel.
	 */
	public GameNavigation() {
		setBounds(0, 0, 1000, 600);
		setLayout(null);
		
		// ======Nav Buttons======
		JButton travelPlanetBtn = new JButton("Travel to planet");
		travelPlanetBtn.setBounds(0, 0, 140, 30);
		add(travelPlanetBtn);
		
		JButton travelOutpostBtn = new JButton("Travel to outpost");
		travelOutpostBtn.setBounds(0, 30, 140, 30);
		add(travelOutpostBtn);
		
		JButton newDayBtn = new JButton("Start a new day");
		newDayBtn.setBounds(0, 60, 140, 30);
		add(newDayBtn);
		
		JButton viewProgressBtn = new JButton("View progress");
		viewProgressBtn.setBounds(0, 90, 140, 30);
		add(viewProgressBtn);
		
		JButton viewShipBtn = new JButton("View ship");
		viewShipBtn.setBounds(0, 120, 140, 30);
		add(viewShipBtn);
		
		JButton inventoryBtn = new JButton("");
		inventoryBtn.setIcon(new ImageIcon(GameNavigation.class.getResource("/images/inventory.png")));
		inventoryBtn.setBounds(930, 0, 64, 64);
		add(inventoryBtn);

	}
}
