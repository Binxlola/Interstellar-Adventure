package mainGui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PlanetMain extends JPanel {

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
			}
		});
		add(backBtn);
		
		JButton confirmBtn = new JButton("Confirm");
		confirmBtn.setBounds(200, 450, 140, 30);
		add(confirmBtn);
	}

}
