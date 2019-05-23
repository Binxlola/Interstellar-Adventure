package mainGui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import crewManagement.Crew;
import environment.AsteroidEvent;
import management.GameManager;

/**
 * Represents the selection of crew to travel to a planet
 * @author Ariel Evangelista
 * @version 1.0, May 2019.
 */
@SuppressWarnings("serial")
public class TravelCrewSelect extends JPanel {
	
	/**
	 * The one and only one instance of GameManager class
	 */
	GameManager gameManager = GameManager.getInstance();
	
	/**
	 * The one and only one instance of Crew class
	 */
	Crew crew = Crew.getInstance();
	
	/**
	 * The managing MainScreen class
	 */
	MainScreen window;
	
	/**
	 * The list of all available to view check boxes for crew
	 */
	private List<JCheckBox> checkBoxList = new ArrayList<JCheckBox>();
	
	/**
	 * The list of all check boxes for crew
	 */
	private List<JCheckBox> crewCheckBoxList = new ArrayList<JCheckBox>();
	
	/**
	 * The current selected crew on the screen
	 */
	private int maxSelected = 0;
	
	/**
	 * Boolean if there is a crew of type pilot selected
	 */
	private boolean pilot = false;

	/**
	 * Create the panel
	 * @param incomingWindow The managing MainScreen class
	 */
	public TravelCrewSelect(MainScreen incomingWindow) {
		window = incomingWindow;
		setBounds(0, 0, 1000, 600);
		setLayout(null);
		
		JButton backBtn = new JButton("Back");
		backBtn.setBounds(50, 500, 140, 30);
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				window.changeContent("TravelPlanetSelect");
			}
		});
		add(backBtn);
		
		JButton confirmBtn = new JButton("Confirm");
		confirmBtn.setBounds(200, 500, 140, 30);
		confirmBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (maxSelected < 2) {
					JOptionPane.showMessageDialog(null, "Please select at least two crew members to pilot your ship!");
				} else {
					deductMoves();
					window.changeContent("PlanetMain");
					new AsteroidEvent(pilot, window);
				}
			}
		});
		add(confirmBtn);
		
		JLabel selectLbl = new JLabel("SELECT CREW MEMBERS TO PILOT");
		selectLbl.setFont(new Font("Distant Galaxy", Font.PLAIN, 24));
		selectLbl.setBounds(42, 33, 600, 40);
		this.add(selectLbl);
		
		createCheckBtn();
		checkAvailableCrew();
	}
	
	/*
	 * Creates the check buttons for each crew members
	 */
	private void createCheckBtn() {
		int y = 50;
		
		// Create all appropriate labels
		for (int i = 0; i < crew.size(); i++) {
			// Get the crew members name
			JLabel crewNameLbl = new JLabel(crew.getCrew().get(i).getName());
			crewNameLbl.setFont(new Font("Rockwell", Font.PLAIN, 14));
			crewNameLbl.setBounds(50, y+=50, 150, 50);
			this.add(crewNameLbl);
			
			JLabel crewTypeLbl = new JLabel(crew.getCrew().get(i).getType());
			crewTypeLbl.setFont(new Font("Rockwell", Font.ITALIC, 11));
			crewTypeLbl.setBounds(50, y+20, 150, 50);
			this.add(crewTypeLbl);
			
			JCheckBox crewCheckBox = new JCheckBox("   " + crew.getCrew().get(i).getMoves() + " moves left");
			crewCheckBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JCheckBox source = (JCheckBox) e.getSource();
					if (source.isSelected()) {
						maxSelected += 1;
						if (maxSelected >= 2) {
							disableCheckBoxes();
						}
					} else {
						maxSelected -= 1;
						enableCheckBoxes();
					}
				}
			});
			crewCheckBox.setBounds(300, y+20, 150, 20);
			this.add(crewCheckBox);
			
			// Checks if the crew member has moves left
			if (crew.getCrew().get(i).getMoves() > 0) {
				checkBoxList.add(crewCheckBox);
			} else {
				crewCheckBox.setEnabled(false);
			}
			
			crewCheckBoxList.add(crewCheckBox);
		}
	}
	
	/**
	 * Deducts the move of checked crew members by 1
	 */
	private void deductMoves() {
		for (JCheckBox checkBox: crewCheckBoxList) {
			int i = crewCheckBoxList.indexOf(checkBox);
			if (checkBox.isSelected()) {
				crew.getCrew().get(i).deductMove();
				if (crew.getCrew().get(i).getType() == "Pilot") pilot = true;
			}
		}
	}
	
	/**
	 * Checks the number of crews available to pilot.
	 * If the number of crews available is 1 or less,
	 * this method pops a notification to the player.
	 */
	private void checkAvailableCrew() {
		if (checkBoxList.size() < 2) {
			JOptionPane.showMessageDialog(null, "You don't have enough crew to pilot the ship!\n         Time to start a new day!");
			window.changeContent("mainScreen");
		}
	}
	
	/**
	 * Disables unselected check boxes
	 */
	private void disableCheckBoxes() {
		for (JCheckBox checkBox: checkBoxList) {
			if (!checkBox.isSelected()) {
				checkBox.setEnabled(false);
			}
		}
	}
	
	/**
	 * Enables all check boxes
	 */
	private void enableCheckBoxes() {
		for (JCheckBox checkBox: checkBoxList) {
			checkBox.setEnabled(true);
		}
	}
}
