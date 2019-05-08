package management;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class test {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test window = new test();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public test() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblSelectYourCrew = new JLabel("SELECT YOUR CREW");
		lblSelectYourCrew.setFont(new Font("Ethnocentric", Font.PLAIN, 30));
		lblSelectYourCrew.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectYourCrew.setBounds(231, 20, 515, 49);
		frame.getContentPane().add(lblSelectYourCrew);
		
		int[] locTxt = {139, 127, 489, 127, 139, 277, 489, 277, 139, 427, 489, 427};
		int[] locLbl = {40, 83, 390, 83, 40, 233, 390, 233, 40, 383, 390, 383};
		int[] locName = {40, 126, 390, 126, 40, 276, 390, 276, 40, 426, 390, 426};
		int[] locType = {40, 157, 390, 157, 40, 307, 390, 307, 40, 457, 390, 457};
		int[] locCombo = {139, 163, 489, 163, 139, 313, 489, 313, 139, 463, 489, 463};
		ArrayList<JTextField> crewName = new ArrayList<JTextField>();
		ArrayList<JComboBox<Object>> crewCombo = new ArrayList<JComboBox<Object>>();
		for (int i = 0; i < 12; i+=2) {
			JTextField textField = new JTextField();
			textField.setBounds(locTxt[i], locTxt[i+1], 137, 21);
			frame.getContentPane().add(textField);
			textField.setColumns(10);
			// Saves that textfield
			crewName.add(textField);
			
			JLabel lblNewLabel = new JLabel("CREW #" + ((i/2) + 1));
			lblNewLabel.setFont(new Font("Unispace", Font.PLAIN, 18));
			lblNewLabel.setBounds(locLbl[i], locLbl[i+1], 103, 27);
			frame.getContentPane().add(lblNewLabel);
			
			JLabel lblCrewName = new JLabel("CREW NAME:");
			lblCrewName.setFont(new Font("Rockwell", Font.PLAIN, 14));
			lblCrewName.setBounds(locName[i], locName[i+1], 114, 21);
			frame.getContentPane().add(lblCrewName);
			
			JLabel lblCrewType = new JLabel("CREW TYPE:");
			lblCrewType.setFont(new Font("Rockwell", Font.PLAIN, 14));
			lblCrewType.setBounds(locType[i], locType[i+1], 103, 27);
			frame.getContentPane().add(lblCrewType);
			
			JComboBox<Object> comboBox = new JComboBox<Object>();
			comboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {"Captain", "Engineer", "Medic", "Scout"}));
			comboBox.setBounds(locCombo[i], locCombo[i+1], 137, 21);
			frame.getContentPane().add(comboBox);
			crewCombo.add(comboBox);
		}
		/*
		textField = new JTextField();
		textField.setBounds(139, 127, 137, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("CREW #1");
		lblNewLabel.setFont(new Font("Unispace", Font.PLAIN, 18));
		lblNewLabel.setBounds(40, 83, 103, 27);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblCrewName = new JLabel("CREW NAME:");
		lblCrewName.setFont(new Font("Rockwell", Font.PLAIN, 14));
		lblCrewName.setBounds(40, 126, 114, 21);
		frame.getContentPane().add(lblCrewName);
		
		JLabel lblNewLabel_1 = new JLabel("CREW TYPE:");
		lblNewLabel_1.setFont(new Font("Rockwell", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(40, 157, 103, 27);
		frame.getContentPane().add(lblNewLabel_1);
		
		JComboBox<Object> comboBox = new JComboBox<Object>();
		comboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {"Captain", "Engineer", "Medic", "Scout"}));
		comboBox.setBounds(139, 163, 137, 21);
		frame.getContentPane().add(comboBox);
		*/
	}
}
