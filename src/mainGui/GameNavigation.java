package mainGui;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

import crewManagement.Crew;
import itemManagement.Inventory;
import management.GameManager;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
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
	Inventory inventory = Inventory.getInstance();
	Crew crew = Crew.getInstance();

	/**
	 * Create the panel.
	 */
	public GameNavigation(MainScreen window) {
		setBounds(0, 0, 1000, 600);
		setLayout(null);
		
		// Labels for day
		JLabel dayLbl = new JLabel("DAY " + gameManager.getCurrentDay() + " OF " + gameManager.getGameDuration());
		dayLbl.setFont(new Font("Unispace", Font.PLAIN, 15));
		dayLbl.setHorizontalAlignment(SwingConstants.CENTER);
		dayLbl.setBounds(355, 115, 300, 24);
		this.add(dayLbl);
		
		// Labels for ship parts
		JLabel partsLbl = new JLabel("Ship Parts: " + gameManager.getPartsFound() + " / " + (gameManager.getPartsFound() + gameManager.getPartsToFind()));
		partsLbl.setFont(new Font("Unispace", Font.PLAIN, 15));
		partsLbl.setHorizontalAlignment(SwingConstants.CENTER);
		partsLbl.setBounds(355, 165, 300, 24);
		this.add(partsLbl);
		
		// Labels for all moves left
		JLabel movesLbl = new JLabel("Moves Left: " + crew.getAllMoves());
		movesLbl.setFont(new Font("Unispace", Font.PLAIN, 15));
		movesLbl.setHorizontalAlignment(SwingConstants.CENTER);
		movesLbl.setBounds(355, 225, 300, 24);
		this.add(movesLbl);
		
		
		// Wallet display section
		JLabel walletLbl = new JLabel("Wallet: " + inventory.getWallet());
		walletLbl.setBounds(425, 315, 300, 30);
		walletLbl.setFont(new Font("Unispace", Font.PLAIN, 15));
		this.add(walletLbl);
		
		JLabel titleLbl = new JLabel("INTERSTELLAR ADVENTURES");
		titleLbl.setFont(new Font("Distant Galaxy", Font.PLAIN, 24));
		titleLbl.setBounds(42, 33, 600, 40);
		this.add(titleLbl);
		
		// ======Nav Buttons======
		JButton travelPlanetBtn = new JButton("Travel to Planet");
		travelPlanetBtn.setBounds(60, 120, 140, 30);
		travelPlanetBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				window.changeContent("TravelPlanetSelect");
			}
		});
		add(travelPlanetBtn);
		
		JButton travelOutpostBtn = new JButton("Visit an Outpost");
		travelOutpostBtn.setBounds(60, 160, 140, 30);
		travelOutpostBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				window.changeContent("Outpost");
			}
		});
		add(travelOutpostBtn);
		
		JButton newDayBtn = new JButton("Next Day");
		newDayBtn.setBounds(60, 200, 140, 30);
		newDayBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int input = JOptionPane.showConfirmDialog(null, "Are you sure you want to move on to the next day?",
						"New Day", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
				if (input == 0) {
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
			}
		});
		add(newDayBtn);
		
		JButton viewShipBtn = new JButton("View Ship");
		viewShipBtn.setBounds(60,240, 140, 30);
		viewShipBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				window.changeContent("ShipStatus");
			}
		});
		add(viewShipBtn);
		
		JButton viewCrewBtn = new JButton("View Crew");
		viewCrewBtn.setBounds(60, 280, 140, 30);
		viewCrewBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				window.changeContent("CrewStatus");
			}
		});
		add(viewCrewBtn);
		
		JButton viemInv = new JButton("View Inventory");
		viemInv.setBounds(60, 320, 140, 30);
		viemInv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				window.changeContent("Inventory");
			}
		});
		add(viemInv);
		
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
