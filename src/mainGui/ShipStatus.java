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

public class ShipStatus extends JPanel {
	
	Crew crew = Crew.getInstance();
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
		
		JButton refreshBtn = new JButton("Refresh");
		refreshBtn.setBounds(525, 500, 140, 30);
		refreshBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				window.changeContent("ShipStatus");
			}
		});
		add(refreshBtn);
		
		JLabel selectLbl = new JLabel("SHIP STATUS");
		selectLbl.setFont(new Font("Distant Galaxy", Font.PLAIN, 24));
		selectLbl.setBounds(42, 33, 600, 40);
		this.add(selectLbl);
	}
}
