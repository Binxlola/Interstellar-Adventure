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
import environment.Environment;
import environment.Planet;
import management.GameManager;

public class PlanetMain extends JPanel {
	
	MainScreen window;
	private Environment env = Environment.getInstance();
	private Planet currentPlanet = env.getSelectedPlanet();
	private Crew crew = Crew.getInstance();
	private CrewMember searchCrew;
	private List<JRadioButton> searchCrewList = new ArrayList<JRadioButton>();

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
				searchCrewList.removeAll(searchCrewList);
				boolean search = getSearchCrew();
				if (search) {
					//Item Wheel! I dont know how it works hehe
					// just add some item on the inventory and change the notification below!
					JOptionPane.showMessageDialog(null, "Item Wheel must be implemented first!");
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
		
		JButton confirmBtn = new JButton("Finish");
		confirmBtn.setBounds(200, 500, 140, 30);
		confirmBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentPlanet.visited();
				window.changeContent("mainScreen");
			}
		});
		add(confirmBtn);
		
	}
	
	/**
	 * Produces the Message Dialog containing a checkboxes of all crews available
	 * to search and returns true or false if searching or not
	 * @return Returns true (ok) or false (cancel) based on the user preference
	 */
	private boolean getSearchCrew() {
		JRadioButton radBtn1 = new JRadioButton("");
		JRadioButton radBtn2 = new JRadioButton("");
		JRadioButton radBtn3 = new JRadioButton("");
		JRadioButton radBtn4 = new JRadioButton("");
		JRadioButton radBtn5 = new JRadioButton("");
		JRadioButton radBtn6 = new JRadioButton("");
		searchCrewList.add(radBtn1);
		searchCrewList.add(radBtn2);
		searchCrewList.add(radBtn3);
		searchCrewList.add(radBtn4);
		searchCrewList.add(radBtn5);
		searchCrewList.add(radBtn6);
		String msg = "Select a search crew";
		Object[] params = {msg, radBtn1, radBtn2, radBtn3, radBtn4, radBtn5, radBtn6};
		for (int i = 0; i < searchCrewList.size(); i++) {
			if (i < crew.size()) {
				String name = crew.getCrew().get(i).getName();
				String type = crew.getCrew().get(i).getType();
				int move = crew.getCrew().get(i).getMoves();
				
				searchCrewList.get(i).setText(type + " " + name + " (" + move + " moves left)");
				
				addListener(searchCrewList.get(i));
				
				if (move <= 0) searchCrewList.get(i).setEnabled(false);
			} else {
				searchCrewList.get(i).setVisible(false);
			}
	
		}
		
		boolean searchCrewSelected = false;
		int input = 0;
		
		while (!searchCrewSelected && input == 0) {
			input = JOptionPane.showConfirmDialog(null, params, "Search", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
			if (input == 0) {
				for (JRadioButton btn: searchCrewList) {
					if (btn.isSelected()) {
						int radioIndex = searchCrewList.indexOf(btn);
						searchCrewSelected = true;
						searchCrew = crew.getCrew().get(radioIndex);
					}
				}
				if (!searchCrewSelected) JOptionPane.showMessageDialog(null, "You must select one crew to search!");
			}
		}
		
		return searchCrewSelected;
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
					for (JRadioButton btn: searchCrewList) {
						if (btn != source) {
							btn.setSelected(false);
						}
					}
				}
			}
		});
	}
}
