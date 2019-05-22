package mainGui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import crewManagement.Crew;
import crewManagement.CrewMember;
import crewManagement.CrewSelector;
import environment.Environment;
import environment.Planet;
import itemManagement.Inventory;
import itemManagement.Item;
import itemManagement.ItemWheel;
import management.GameManager;

public class PlanetMain extends JPanel {
	
	private MainScreen window;
	private Environment env = Environment.getInstance();
	private Planet currentPlanet = env.getSelectedPlanet();
	private ItemWheel itemWheel = ItemWheel.getInstance();
	private Inventory inventory = Inventory.getInstance();

	/**
	 * Create the panel.
	 */
	public PlanetMain(MainScreen incomingWindow) {
		window = incomingWindow;
		
		setBounds(0, 0, 1000, 600);
		setLayout(null);
		
		/* REMOVE */
		JLabel someLbl = new JLabel("maybe some planet image?");
		someLbl.setBounds(150, 200, 600, 40);
		this.add(someLbl);
		
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
				if (searchCrew == null) {
					JOptionPane.showMessageDialog(null, "You must select one crew to search!");
				} else {
					searchCrew.deductMove();
					
					Item item = itemWheel.getItem();
					
					if (item == null)  {
						JOptionPane.showMessageDialog(null, "You did not find anything.");
					} else {
						if (currentPlanet.isPieceFound()) {
							while (item.getName() == "Ship Part") {
								item = itemWheel.getItem();
							}
						}
						
						if (item.getName() == "Ship Part" && !currentPlanet.isPieceFound()) {
							currentPlanet.pieceFound();
							JOptionPane.showMessageDialog(null, "You found a part of your ship!");
						} else {
							JOptionPane.showMessageDialog(null, "You found a " + item.getName() + "!");
						}
						inventory.addItem(item);
					}
					
					// Another item if there is a Scout
					if (searchCrew.getType() == "Scout") {
						Item extraItem = itemWheel.getItem();
						
						if (extraItem != null)  {
							if (currentPlanet.isPieceFound()) {
								while (extraItem.getName() == "Ship Part") {
									extraItem = itemWheel.getItem();
								}
							}
							
							if (extraItem.getName() == "Ship Part" && !currentPlanet.isPieceFound()) {
								currentPlanet.pieceFound();
								JOptionPane.showMessageDialog(null, "Scouts can find extra items!\nYou found a part of your ship!");
							} else {
								JOptionPane.showMessageDialog(null, "Scouts can find extra items!\nYou found a " + extraItem.getName() + "!");
							}
							inventory.addItem(item);
						}
					}
				}
				
				window.changeContent("PlanetMain");
				
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
