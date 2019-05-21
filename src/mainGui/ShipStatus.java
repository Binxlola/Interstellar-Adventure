package mainGui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.List;

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
import management.GameManager;

public class ShipStatus extends JPanel {
	
	Crew crew = Crew.getInstance();
	GameManager gameManager = GameManager.getInstance();
	SpaceShip spaceShip = SpaceShip.getInstance();
	MainScreen window;
	
	private CrewMember repairCrew;
	private List<JRadioButton> repairCrewList = new ArrayList<JRadioButton>();

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
		
		JButton refreshBtn = new JButton("Refresh");
		refreshBtn.setBounds(525, 500, 140, 30);
		refreshBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				window.changeContent("ShipStatus");
			}
		});
		add(refreshBtn);
		
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
						repairCrewList.removeAll(repairCrewList);
						boolean search = getRepairCrew();
						if (search) JOptionPane.showMessageDialog(null, "The ship was repaird and regained some shields!");
					}
				} else {
					repairCrewList.removeAll(repairCrewList);
					boolean search = getRepairCrew();
					if (search) JOptionPane.showMessageDialog(null, "The ship was repaird and regained some shields!");
				}
			}
		});
		add(repairBtn);
	}
	
	
	/**
	 * Produces the Message Dialog containing checkboxes of all crews available
	 * to search and returns true or false if searching or not
	 * @return Returns true (ok) or false (cancel) based on the user preference
	 */
	private boolean getRepairCrew() {
		JRadioButton radBtn1 = new JRadioButton("");
		JRadioButton radBtn2 = new JRadioButton("");
		JRadioButton radBtn3 = new JRadioButton("");
		JRadioButton radBtn4 = new JRadioButton("");
		JRadioButton radBtn5 = new JRadioButton("");
		JRadioButton radBtn6 = new JRadioButton("");
		repairCrewList.add(radBtn1);
		repairCrewList.add(radBtn2);
		repairCrewList.add(radBtn3);
		repairCrewList.add(radBtn4);
		repairCrewList.add(radBtn5);
		repairCrewList.add(radBtn6);
		String msg = "Select a repair crew";
		Object[] params = {msg, radBtn1, radBtn2, radBtn3, radBtn4, radBtn5, radBtn6};
		for (int i = 0; i < repairCrewList.size(); i++) {
			if (i < crew.size()) {
				String name = crew.getCrew().get(i).getName();
				String type = crew.getCrew().get(i).getType();
				int move = crew.getCrew().get(i).getMoves();
				
				repairCrewList.get(i).setText(type + " " + name + " (" + move + " moves left)");
				
				addListener(repairCrewList.get(i));
				
				if (move <= 0) repairCrewList.get(i).setEnabled(false);
			} else {
				repairCrewList.get(i).setVisible(false);
			}
	
		}
		
		boolean repairCrewSelected = false;
		
		int input = JOptionPane.showConfirmDialog(null, params, "Repair", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		if (input == 0) {
			for (JRadioButton btn: repairCrewList) {
				if (btn.isSelected()) {
					int radioIndex = repairCrewList.indexOf(btn);
					repairCrewSelected = true;
					repairCrew = crew.getCrew().get(radioIndex);
					repairCrew.deductMove();
					spaceShip.addShield(50);
				}
			}
			if (!repairCrewSelected) JOptionPane.showMessageDialog(null, "You must select one crew to repair the ship!");
		}
		
		return repairCrewSelected;
	}
	
	/*
	 * Adds an event listener to a given radio button
	 * @param Radio button to be added an event listener
	 */
	private void addListener(JRadioButton rb) {
		rb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JRadioButton source = (JRadioButton) e.getSource();
				if (source.isSelected()) {
					for (JRadioButton btn: repairCrewList) {
						if (btn != source) {
							btn.setSelected(false);
						}
					}
				} else {
					source.setSelected(true);
				}
			}
		});
	}
}
