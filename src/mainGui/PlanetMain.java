package mainGui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import crewManagement.Crew;
import management.GameManager;

public class PlanetMain extends JPanel {
	
	GameManager gameManager = GameManager.getInstance();
	Crew crew = Crew.getInstance();
	private List<JCheckBox> checkBoxList = new ArrayList<JCheckBox>();

	/**
	 * Create the panel.
	 */
	public PlanetMain(MainScreen window) {
		setBounds(0, 0, 1000, 600);
		setLayout(null);
		
		JButton backBtn = new JButton("Back");
		backBtn.setBounds(50, 450, 140, 30);
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				window.changeContent("mainScreen");
				System.out.println(checkBoxList.size());
			}
		});
		add(backBtn);
		
		JButton confirmBtn = new JButton("Confirm");
		confirmBtn.setBounds(200, 450, 140, 30);
		add(confirmBtn);
		
		createCheckBtn();
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
			crewNameLbl.setBounds(50, y+=50, 150, 20);
			this.add(crewNameLbl);
			
			JLabel crewTypeLbl = new JLabel(crew.getCrew().get(i).getType());
			crewTypeLbl.setFont(new Font("Rockwell", Font.ITALIC, 11));
			crewTypeLbl.setBounds(50, y+20, 150, 20);
			this.add(crewTypeLbl);
			
			JCheckBox crewCheckBox = new JCheckBox("");
			crewCheckBox.setBounds(300, y, 150, 20);
			this.add(crewCheckBox);
			checkBoxList.add(crewCheckBox);
		}
	}

}
