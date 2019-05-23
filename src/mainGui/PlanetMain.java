package mainGui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import crewManagement.CrewMember;
import crewManagement.CrewSelector;
import environment.Environment;
import environment.Planet;
import itemManagement.Inventory;
import itemManagement.Item;
import itemManagement.ItemWheel;
import management.GameManager;

/**
 * Represents the Planet in the game
 * @author Ariel Evangelista
 * @version 1.0, May 2019.
 */
@SuppressWarnings("serial")
public class PlanetMain extends JPanel {
	
	/**
	 * The incoming MainScreen class
	 */
	private MainScreen window;
	
	/**
	 * The one and only one instance of Environment class
	 */
	private Environment env = Environment.getInstance();
	
	/**
	 * The current selected planet from the Environment Class
	 */
	private Planet currentPlanet = env.getSelectedPlanet();
	
	/**
	 * The one and only one instance of ItemWheel class
	 */
	private ItemWheel itemWheel = ItemWheel.getInstance();
	
	/**
	 * The one and only one instance of the Inventory class
	 */
	private Inventory inventory = Inventory.getInstance();
	
	/**
	 * The one and only one instance of the GameManager class
	 */
	private GameManager gameManager = GameManager.getInstance();

	/**
	 * Create the panel.
	 * @param incomingWindow The incoming MainScreen class
	 */
	public PlanetMain(MainScreen incomingWindow) {
		window = incomingWindow;
		
		setBounds(0, 0, 1000, 600);
		setLayout(null);
		
		JLabel planetMainLbl = new JLabel("WELCOME TO " + currentPlanet.getName());
		planetMainLbl.setFont(new Font("Distant Galaxy", Font.PLAIN, 24));
		planetMainLbl.setBounds(42, 33, 600, 40);
		this.add(planetMainLbl);
		
		JLabel planetMainSubLbl = new JLabel(currentPlanet.getInfo());
		planetMainSubLbl.setFont(new Font("Courier New", Font.PLAIN, 15));
		planetMainSubLbl.setBounds(42, 60, 600, 40);
		this.add(planetMainSubLbl);
		
		JButton searchBtn = new JButton("Search");
		searchBtn.setToolTipText("Searches this Planet for a random item");
		searchBtn.setBounds(50, 430, 290, 60);
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrewSelector selectCrew = new CrewSelector("Select a Search Crew:", "Search");
				CrewMember searchCrew = selectCrew.getCrew();
				if (searchCrew != null) {
					searchCrew.deductMove();
					
					Item item = itemWheel.getItem();
					
					if (item == null)  {
						JOptionPane.showMessageDialog(null, "You did not find anything.");
					} else {
						if (item.getName() == "Ship Part") {
							if (!currentPlanet.isPieceFound()) {
								currentPlanet.pieceFound();
								JOptionPane.showMessageDialog(null, "You found a part of your ship!");
								inventory.addItem(item);
							} else {
								item = null;
								JOptionPane.showMessageDialog(null, "You did not find anything.");
							}
						} else if (item.getName() == "Coin") {
							JOptionPane.showMessageDialog(null, "You found " + item.getCount() + " coins!");
							inventory.addItem(item);
						} else {
							JOptionPane.showMessageDialog(null, "You found " + item.getName() + "!");
							inventory.addItem(item);
						}
					}
					
					// Another item if there is a Scout
					if (searchCrew.getType() == "Scout") {
						Item extraItem = itemWheel.getItem();
						
						if (extraItem != null)  {
							if (extraItem.getName() == "Ship Part") {
								if (!currentPlanet.isPieceFound() ) {
									currentPlanet.pieceFound();
									JOptionPane.showMessageDialog(null, "Scouts can find extra items!\nYou found a part of your ship!");
									inventory.addItem(extraItem);
								}
							} else if (extraItem.getName() == "Coin") {
								JOptionPane.showMessageDialog(null, "Scouts can find extra items!\nYou found " + extraItem.getCount() + " coins!");
								inventory.addItem(extraItem);
							} else {
								JOptionPane.showMessageDialog(null, "Scouts can find extra items!\nYou found " + extraItem.getName() + "!");
								inventory.addItem(extraItem);
							}
						}
					}
				}
				
				if (gameManager.allPartsFound()) {
					gameManager.endGame(true, "You have found all the ship parts!");
					window.changeContent("GameOver");
				} else {
					window.changeContent("PlanetMain");
				}
				
			}
		});
		this.add(searchBtn);
		
		JButton backBtn = new JButton("Information");
		backBtn.setToolTipText("Show information about this planet");
		backBtn.setBounds(50, 500, 140, 30);
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "This planet is definitely not flat");
			}
		});
		add(backBtn);
		
		JButton confirmBtn = new JButton("Exit Planet");
		confirmBtn.setBounds(200, 500, 140, 30);
		confirmBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentPlanet.visited();
				window.changeContent("mainScreen");
			}
		});
		add(confirmBtn);
		
	}
}
