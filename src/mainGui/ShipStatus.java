package mainGui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import crewManagement.Crew;
import crewManagement.CrewMember;
import crewManagement.SpaceShip;
import crewManagement.CrewSelector;
import management.AddGameScore;
import management.GameManager;

public class ShipStatus extends JPanel {
	
	Crew crew = Crew.getInstance();
	GameManager gameManager = GameManager.getInstance();
	SpaceShip spaceShip = SpaceShip.getInstance();
	MainScreen window;

	/**
	 * Create the panel.
	 */
	public ShipStatus(MainScreen incomingWindow) {
		window = incomingWindow;
		setBounds(0, 0, 1000, 600);
		setLayout(null);
		
		JButton backBtn = new JButton("Back");
		backBtn.setBounds(50, 500, 140, 30);
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				window.changeContent("mainScreen");
			}
		});
		add(backBtn);
		
		JLabel shipStatusLbl = new JLabel("SHIP STATUS");
		shipStatusLbl.setFont(new Font("Distant Galaxy", Font.PLAIN, 24));
		shipStatusLbl.setBounds(42, 33, 600, 40);
		this.add(shipStatusLbl);
		
		JButton shipIconBtn = new JButton("");
		shipIconBtn.setBounds(100, 200, 50, 50);
		shipIconBtn.setIcon(spaceShip.getShipIcon());
		add(shipIconBtn);
		
		JLabel shipNameLbl = new JLabel("Ship Name: " + spaceShip.getShipName());
		shipNameLbl.setFont(new Font("Rockwell", Font.PLAIN, 18));
		shipNameLbl.setBounds(80, 250, 500, 50);
		this.add(shipNameLbl);
		
		JLabel shipShieldLbl = new JLabel("Shield Health: " + spaceShip.getShipShield());
		shipShieldLbl.setFont(new Font("Rockwell", Font.PLAIN, 18));
		shipShieldLbl.setBounds(80, 280, 500, 50);
		this.add(shipShieldLbl);
		
		JButton repairBtn = new JButton("Repair Ship");
		repairBtn.setBounds(200, 500, 140, 30);
		repairBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (spaceShip.getShipShield() == 100) {
					int input = JOptionPane.showConfirmDialog(null, "The ship still has 100% of its shields.\n Are you sure you want to repair it?",
							"Repair", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
					if (input == 0) {
						CrewSelector selectedCrew = new CrewSelector("Select a Repair Crew:", "Repair Ship");
						CrewMember repairCrew = selectedCrew.getCrew();
						if (repairCrew != null) {
							repairShip(repairCrew);
						}
					}
				} else {
					CrewSelector selectedCrew = new CrewSelector("Select a Repair Crew:", "Repair Ship");
					CrewMember repairCrew = selectedCrew.getCrew();
					if (repairCrew != null) {
						repairShip(repairCrew);
					}
				}
				
				window.changeContent("ShipStatus");
			}
		});
		add(repairBtn);
	}
	
	
	/**
	 * Repairs the ship and regain 50 of its shield.
	 * If Engineer repairs the ship, it gains 20 more shield
	 * @param repairCrew The Crew to repair the ship
	 */
	private void repairShip(CrewMember repairCrew) {
		repairCrew.deductMove();
		if (repairCrew.getType() == "Engineer") {
			spaceShip.addShield(70);
			int scoreRoll = (int) (70 * new Random().nextDouble());
			new AddGameScore(scoreRoll);
			JOptionPane.showMessageDialog(null, "The ship was repaired and regained 70 shields!");
		} else {
			spaceShip.addShield(50);
			int scoreRoll = (int) (50 * new Random().nextDouble());
			new AddGameScore(scoreRoll);
			JOptionPane.showMessageDialog(null, "The ship was repaired and regained 50 shields!");
		}
	}
}
