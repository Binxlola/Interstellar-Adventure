package mainGui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import environment.Environment;
import environment.Planet;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the selection of planet to travel to
 * @author Ariel Evangelista
 * @version 1.0, May 2019.
 */
@SuppressWarnings("serial")
public class TravelPlanetSelect extends JPanel {

	/**
	 * The managing MainScreen window
	 */
	private MainScreen window;
	
	/**
	 * The one and only one instance of Environment class
	 */
	private Environment env = Environment.getInstance();
	
	/**
	 * The label of the selected planet
	 */
	private JLabel planetLbl;
	
	/**
	 * A list of all JButton representing the planets
	 */
	private List<JButton> planetBtns = new ArrayList<JButton>();
	
	/**
	 * Create the panel
	 * @param incomingWindow The managing MainScreen class
	 */
	public TravelPlanetSelect(MainScreen incomingWindow) {
		window = incomingWindow;
		setBounds(0, 0, 1000, 600);
		setLayout(null);
		
		env.selectPlanet(-1);
		
		JLabel lblSelectCrewMembers = new JLabel("SELECT PLANET TO TRAVEL TO");
		lblSelectCrewMembers.setFont(new Font("Distant Galaxy", Font.PLAIN, 24));
		lblSelectCrewMembers.setBounds(42, 33, 600, 40);
		this.add(lblSelectCrewMembers);
		
		planetLbl = new JLabel("Click a planet to see its description");
		planetLbl.setHorizontalAlignment(SwingConstants.CENTER);
		planetLbl.setFont(new Font("Courier New", Font.PLAIN, 15));
		planetLbl.setBounds(0, 450, 976, 20);
		this.add(planetLbl);
		
		JButton backBtn = new JButton("Back");
		backBtn.setBounds(50, 500, 140, 30);
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				window.changeContent("mainScreen");
			}
		});
		add(backBtn);
		
		JButton confirmBtn = new JButton("Confirm");
		confirmBtn.setBounds(200, 500, 140, 30);
		confirmBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (env.getSelectedPlanetIndex() == -1) {
					JOptionPane.showMessageDialog(null, "Please select a planet to travel to!");
				} else {
					window.changeContent("TravelCrewSelect");
				}
			}
		});
		add(confirmBtn);
		
		createPlanetButtons();
	}
	
	/*
	 * Create all the buttons for each planet
	 */
	private void createPlanetButtons() {
		ArrayList<Planet> planets = env.getPlanets();
		int x = 80;
		int y = 20;
		int i = 0;
		for (i = 0; i < planets.size(); i++) {
			String planetName = planets.get(i).getName();
			JButton planetBtn = new JButton(planetName);
			planetBtn.setToolTipText(planets.get(i).toString());
			if (i < 5) {
				planetBtn.setBounds(x, y+=70, 190, 60);
				planetBtn = addListener(planetBtn, i);
				this.add(planetBtn);
			} else if (i < 10) {
				if (i == 5) y = 20;
				planetBtn.setBounds(x+200, y+=70, 190, 60);
				planetBtn = addListener(planetBtn, i);
				this.add(planetBtn);
			} else if (i < 15) {
				if (i == 10) y = 20;
				planetBtn.setBounds(x+400, y+=70, 190,60);
				planetBtn = addListener(planetBtn, i);
				this.add(planetBtn);
			} else if (i < 20) {
				if (i == 15) y = 20;
				planetBtn.setBounds(x+600, y+=70, 190,60);
				planetBtn = addListener(planetBtn, i);
				this.add(planetBtn);
			}
			
			if (planets.get(i).isPieceFound()) planetBtn.setBackground(Color.green);
			else if (planets.get(i).isVisited()) planetBtn.setBackground(Color.cyan);
			
			planetBtns.add(planetBtn);
		}
	}
	
	/*
	 * A method that adds an OnClick event to a given JButton object
	 * This will select the desired planet's index on the planets list
	 * @param The button you wished to add an ActionListener
	 */
	private JButton addListener(JButton btn, int i) {
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				env.selectPlanet(i);
				planetLbl.setText(env.getPlanets().get(i).toString());
			}
		});
		return btn;
	}

}
