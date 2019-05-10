package mainGui;

import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

/**
 * Represent a JPanel displaying multiple buttons used for navigating the main content modules of the game.
 * Each buttons has a simple ActionListener attached which will simply call the ChangeContent method of the main screen, giving a String describing the content to be changed to.
 * @author Jason Smit
 *
 */
public class GameNavigation extends JPanel {

	/**
	 * Create the panel.
	 */
	public GameNavigation(MainScreen window) {
		setBounds(0, 0, 1000, 600);
		setLayout(null);
		
		// ======Nav Buttons======
		JButton travelPlanetBtn = new JButton("Travel to planet");
		travelPlanetBtn.setBounds(0, 0, 140, 30);
		travelPlanetBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				window.changeContent("Planet");
			}
		});
		add(travelPlanetBtn);
		
		JButton travelOutpostBtn = new JButton("Travel to outpost");
		travelOutpostBtn.setBounds(0, 30, 140, 30);
		travelOutpostBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				window.changeContent("Outpost");
			}
		});
		add(travelOutpostBtn);
		
		JButton newDayBtn = new JButton("Start a new day");
		newDayBtn.setBounds(0, 60, 140, 30);
		newDayBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				window.changeContent("New Day");
			}
		});
		add(newDayBtn);
		
		JButton viewProgressBtn = new JButton("View progress");
		viewProgressBtn.setBounds(0, 90, 140, 30);
		viewProgressBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				window.changeContent("Progress");
			}
		});
		add(viewProgressBtn);
		
		JButton viewShipBtn = new JButton("View ship");
		viewShipBtn.setBounds(0, 120, 140, 30);
		viewShipBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				window.changeContent("Ship");
			}
		});
		add(viewShipBtn);
		
		JButton inventoryBtn = new JButton("");
		inventoryBtn.setIcon(new ImageIcon(GameNavigation.class.getResource("/images/inventory.png")));
		inventoryBtn.setBounds(930, 0, 64, 64);
		inventoryBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				window.changeContent("Inventory");
			}
		});
		add(inventoryBtn);
		

	}
}
