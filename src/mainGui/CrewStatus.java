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
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import crewManagement.Crew;
import management.GameManager;

public class CrewStatus extends JPanel {
	
	Crew crew = Crew.getInstance();
	MainScreen window;

	/**
	 * Create the panel.
	 */
	public CrewStatus(MainScreen incomingWindow) {
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
				window.changeContent("CrewStatus");
			}
		});
		add(refreshBtn);
		
		JLabel selectLbl = new JLabel("CREW MEMBERS STATUS");
		selectLbl.setFont(new Font("Distant Galaxy", Font.PLAIN, 24));
		selectLbl.setBounds(42, 33, 600, 40);
		this.add(selectLbl);
		
		createCrewFields();
	}
	
	/*
	 * Creates the check buttons for each crew members
	 */
	private void createCrewFields() {
		
		int[] xCoord = {60, 60, 60, 60, 60, 60}; // X coordinate for each component, starting from the first set.
		int[] yCoord = {120, 140, 160, 180, 200, 240}; // Y coordinate for each component, starting from the first set.
		int current = 0;
		
		while(current < crew.size()) {
			
			JLabel crewNameLbl = new JLabel(crew.getCrew().get(current).getType() + " " + crew.getCrew().get(current).getName());
			crewNameLbl.setFont(new Font("Rockwell", Font.PLAIN, 18));
			crewNameLbl.setBounds(xCoord[0], yCoord[0], 500, 50);
			this.add(crewNameLbl);
		
			String status = "";
			if (crew.getCrew().get(current).isInfected()) status = "Infected";
			else if (crew.getCrew().get(current).getHealth() == 0) status = "Dead";
			else if (crew.getCrew().get(current).getHealth() < 15) status = "Dying";
			else status = "Healthy";
			
			JLabel crewStatusLbl = new JLabel("Status: " + status);
			crewStatusLbl.setFont(new Font("Rockwell", Font.ITALIC, 14));
			crewStatusLbl.setBounds(xCoord[1], yCoord[1], 500, 50);
			this.add(crewStatusLbl);
			
			JLabel crewHealthLbl = new JLabel("Health: " + crew.getCrew().get(current).getHealth() + "%");
			crewHealthLbl.setFont(new Font("Rockwell", Font.ITALIC, 14));
			crewHealthLbl.setBounds(xCoord[2], yCoord[2], 500, 50);
			this.add(crewHealthLbl);
			
			JLabel crewHungerLbl = new JLabel("Hunger: " + crew.getCrew().get(current).getHunger() + "%");
			crewHungerLbl.setFont(new Font("Rockwell", Font.ITALIC, 14));
			crewHungerLbl.setBounds(xCoord[3], yCoord[3], 500, 50);
			this.add(crewHungerLbl);
			
			JLabel crewTirednessLbl = new JLabel("Tiredness: " + crew.getCrew().get(current).getTiredness() + "%");
			crewTirednessLbl.setFont(new Font("Rockwell", Font.ITALIC, 14));
			crewTirednessLbl.setBounds(xCoord[4], yCoord[4], 500, 50);
			this.add(crewTirednessLbl);
			
			int sleepIndex = current;
			JButton sleepBtn = new JButton("Sleep");
			sleepBtn.setBounds(xCoord[5], yCoord[5], 140, 30);
			sleepBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (crew.getCrew().get(sleepIndex).getTiredness() == 0) {
						int input = JOptionPane.showConfirmDialog(null, crew.getCrew().get(sleepIndex).getType() + " " + crew.getCrew().get(sleepIndex).getName()
								+ " is not tired at all.\n Are you sure you want him to sleep?", "Sleep", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
						if (input == 0) {
							if (crew.getCrew().get(sleepIndex).getMoves() > 0) {
								crew.getCrew().get(sleepIndex).sleep();
								JOptionPane.showMessageDialog(null, crew.getCrew().get(sleepIndex).getType() + " " + crew.getCrew().get(sleepIndex).getName()
										+ " slept and became less tired!");
							} else {
								JOptionPane.showMessageDialog(null, crew.getCrew().get(sleepIndex).getType() + " " + crew.getCrew().get(sleepIndex).getName()
										+ " doesn't have any moves left!");
							}
						}
					} else {
						if (crew.getCrew().get(sleepIndex).getMoves() > 0) {
							crew.getCrew().get(sleepIndex).sleep();
							JOptionPane.showMessageDialog(null, crew.getCrew().get(sleepIndex).getType() + " " + crew.getCrew().get(sleepIndex).getName()
									+ " slept and became less tired!");
						} else {
							JOptionPane.showMessageDialog(null, crew.getCrew().get(sleepIndex).getType() + " " + crew.getCrew().get(sleepIndex).getName()
									+ " doesn't have any moves left!");
						}
					}
				}
			});
			add(sleepBtn);
			
			
			if((current%2) == 0) { // even numbers change only the X coordinate, so next item will have new X but same Y.
				int i = 0;
				while(i < xCoord.length) {
					xCoord[i] += 350;
					i ++;
				}
			}
			else { // Odd numbers get the X coordinate taken back to previous value, and increases Y coordinate to new value.
				int i = 0;
				while(i < xCoord.length && i < yCoord.length) {
					xCoord[i] -= 350;
					yCoord[i] += 150;
					i ++;
				}
			}
			current ++; // Increment the current, so the next crew member field is processed next.
		}
	}
}
