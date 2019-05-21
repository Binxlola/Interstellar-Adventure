package mainGui;

import javax.swing.JPanel;

import management.GameManager;

import javax.swing.JButton;
import javax.swing.JOptionPane;

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
	
	GameManager gameManager = GameManager.getInstance();

	/**
	 * Create the panel.
	 */
	public GameNavigation(MainScreen window) {
		setBounds(0, 0, 1000, 600);
		setLayout(null);
		
		// ======Nav Buttons======
		JButton travelPlanetBtn = new JButton("Travel to Planet");
		travelPlanetBtn.setBounds(0, 0, 140, 30);
		travelPlanetBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				window.changeContent("TravelPlanetSelect");
			}
		});
		add(travelPlanetBtn);
		
		JButton travelOutpostBtn = new JButton("Visit an Outpost");
		travelOutpostBtn.setBounds(0, 30, 140, 30);
		travelOutpostBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				window.changeContent("Outpost");
			}
		});
		add(travelOutpostBtn);
		
		JButton newDayBtn = new JButton("Next Day");
		newDayBtn.setBounds(0, 60, 140, 30);
		newDayBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameManager.startNewDay();
				String day = Integer.toString(gameManager.getCurrentDay());
				String duration = Integer.toString(gameManager.getGameDuration());
				if (!gameManager.endGame()) {
					String msg = "Today is a new day, you are now on day " + day;
					msg += " of your " + duration + " day journey.";
					JOptionPane.showMessageDialog(null, msg);
				} else {
					String msg = "You have reached the end of your " + duration + " day journey.";
					
					if(gameManager.allPartsFound()) {
						msg += "\nYou have found all the missing ship parts, you need to install them to win the game.";
					}
					else {
						msg += "\nYou are still missing " + gameManager.getPartsToFind() + " Ship Parts";
						msg += "\n You Lose!";
						window.finishedWindow();
					}
					JOptionPane.showMessageDialog(null, msg);
				}
			}
		});
		add(newDayBtn);
		
		JButton viewShipBtn = new JButton("View Ship");
		viewShipBtn.setBounds(0, 90, 140, 30);
		viewShipBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				window.changeContent("Ship");
			}
		});
		add(viewShipBtn);
		
		JButton viewCrewBtn = new JButton("View Crew");
		viewCrewBtn.setBounds(0, 120, 140, 30);
		viewCrewBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				window.changeContent("CrewStatus");
			}
		});
		add(viewCrewBtn);
		
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
