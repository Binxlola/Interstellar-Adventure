package mainGui;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

import crewManagement.Crew;
import crewManagement.CrewMember;
import crewManagement.CrewSelector;
import crewManagement.SpaceShip;
import gameEvents.RandomEvent;
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
	SpaceShip spaceShip = SpaceShip.getInstance();
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
		JLabel partsLbl = new JLabel("Ship Parts: " + gameManager.getPartsFound() + " / " + gameManager.getPartsToFind());
		partsLbl.setFont(new Font("Unispace", Font.PLAIN, 15));
		partsLbl.setHorizontalAlignment(SwingConstants.CENTER);
		partsLbl.setBounds(355, 165, 300, 24);
		this.add(partsLbl);
		
		// Labels for all moves left
		JLabel movesLbl = new JLabel("Moves Left: " + crew.getAllMoves());
		movesLbl.setFont(new Font("Unispace", Font.PLAIN, 15));
		movesLbl.setHorizontalAlignment(SwingConstants.CENTER);
		movesLbl.setBounds(355, 215, 300, 24);
		this.add(movesLbl);
		
		// Labels for ship
		JLabel shipLbl = new JLabel("Ship Shield: " + spaceShip.getShipShield() + "%");
		shipLbl.setFont(new Font("Unispace", Font.PLAIN, 15));
		shipLbl.setHorizontalAlignment(SwingConstants.CENTER);
		shipLbl.setBounds(355, 265, 300, 24);
		this.add(shipLbl);
		
		
		// Wallet display section
		JLabel walletLbl = new JLabel("Wallet: " + inventory.getWallet());
		walletLbl.setBounds(425, 305, 300, 30);
		walletLbl.setFont(new Font("Unispace", Font.PLAIN, 15));
		this.add(walletLbl);
		
		// Wallet display section
		JLabel scoreLbl = new JLabel("Score: " + gameManager.getGameScore());
		scoreLbl.setBounds(455, 355, 300, 30);
		scoreLbl.setFont(new Font("Unispace", Font.PLAIN, 15));
		this.add(scoreLbl);
		
		// Crew section
		int y = 25;
		for (int i = 0; i < crew.size(); i++) {
			JLabel newCrew = new JLabel(crew.getCrew().get(i).getType() + " " + crew.getCrew().get(i).getName());
			newCrew.setBounds(700, y+=70, 300, 30);
			newCrew.setFont(new Font("Rockwell", Font.PLAIN, 15));
			this.add(newCrew);
			
			String status = "";
			if (crew.getCrew().get(i).isInfected()) status = "Infected";
			else if (crew.getCrew().get(i).getHealth() <= 0) status = "Dead";
			else if (crew.getCrew().get(i).getHealth() < 15) status = "Dying";
			else status = "Healthy";
			
			JLabel crewStatusLbl = new JLabel("Status: " + status);
			crewStatusLbl.setFont(new Font("Rockwell", Font.ITALIC, 10));
			crewStatusLbl.setBounds(700, y+10, 300, 50);
			this.add(crewStatusLbl);
			
			
			JLabel crewHealthLbl = new JLabel("Health: " + crew.getCrew().get(i).getHealth() + "%");
			crewHealthLbl.setFont(new Font("Rockwell", Font.ITALIC, 10));
			crewHealthLbl.setBounds(700, y+20, 300, 50);
			this.add(crewHealthLbl);
			
			JLabel crewHungerLbl = new JLabel("Hunger: " + crew.getCrew().get(i).getHunger() + "%");
			crewHungerLbl.setFont(new Font("Rockwell", Font.ITALIC, 10));
			crewHungerLbl.setBounds(700, y+30, 300, 50);
			this.add(crewHungerLbl);
			
			JLabel crewTirednessLbl = new JLabel("Tiredness: " + crew.getCrew().get(i).getTiredness() + "%");
			crewTirednessLbl.setFont(new Font("Rockwell", Font.ITALIC, 10));
			crewTirednessLbl.setBounds(700, y+40, 300, 50);
			this.add(crewTirednessLbl);
		}

		
		
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
					if (gameManager.allPartsFound()) {
						gameManager.endGame(true, "You have found all the ship parts!");
						window.changeContent("GameOver");
					}
					else if (!gameManager.endGame()) {
						String day = Integer.toString(gameManager.getCurrentDay() + 1);
						String duration = Integer.toString(gameManager.getGameDuration());
						String msg = "Today is a new day, you are now on day " + day;
						msg += " of your " + duration + " day journey.";
						JOptionPane.showMessageDialog(null, msg);
						//gameManager.startNewDay();
						if (!gameManager.startNewDay()) {
							gameManager.endGame(false, "All of your crew members died!");
							window.changeContent("GameOver");
						} else {
							window.changeContent("mainScreen");
						}
					} else {
						gameManager.endGame(false, "You have failed to find all the ship parts!");
						window.changeContent("GameOver");
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
