package mainGui;

import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class InventoryDisplay extends JPanel {

	/**
	 * Create the panel.
	 */
	public InventoryDisplay() {
		setBounds(0, 0, 1000, 600);
		setLayout(null);
		
		// Item type searator's
		JSeparator invSeparator1 = new JSeparator();
		invSeparator1.setOrientation(SwingConstants.VERTICAL);
		invSeparator1.setBounds(330, 60, 1, 400);
		invSeparator1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		add(invSeparator1);
		
		JSeparator invSeparator2 = new JSeparator();
		invSeparator2.setOrientation(SwingConstants.VERTICAL);
		invSeparator2.setBounds(660, 60, 1, 400);
		invSeparator2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		add(invSeparator2);
		
		// Labels for content being displayed
		JLabel potionsLbl = new JLabel("Potions");
		potionsLbl.setFont(new Font("Courier New", Font.PLAIN, 15));
		potionsLbl.setHorizontalAlignment(SwingConstants.CENTER);
		potionsLbl.setBounds(10, 60, 300, 24);
		add(potionsLbl);
		
		JLabel foodLbl = new JLabel("Food");
		foodLbl.setHorizontalAlignment(SwingConstants.CENTER);
		foodLbl.setFont(new Font("Courier New", Font.PLAIN, 15));
		foodLbl.setBounds(341, 60, 300, 24);
		add(foodLbl);
		
		JLabel micLbl = new JLabel("Misc");
		micLbl.setHorizontalAlignment(SwingConstants.CENTER);
		micLbl.setFont(new Font("Courier New", Font.PLAIN, 15));
		micLbl.setBounds(671, 60, 300, 24);
		add(micLbl);
		
		JLabel walletLbl = new JLabel("Wallet:");
		walletLbl.setHorizontalAlignment(SwingConstants.CENTER);
		walletLbl.setFont(new Font("Courier New", Font.PLAIN, 15));
		walletLbl.setBounds(10, 565, 100, 24);
		add(walletLbl);
		
		JLabel invLbl = new JLabel("INVENTORY");
		invLbl.setHorizontalAlignment(SwingConstants.CENTER);
		invLbl.setBounds(341, 11, 300, 25);
		invLbl.setFont(new Font("Dialog", Font.PLAIN, 24));
		add(invLbl);
		
		// Button to close inventory
		JButton closeBtn = new JButton("Close");
		closeBtn.setBounds(882, 566, 89, 23);
		closeBtn.setFont(new Font("Courier New", Font.PLAIN, 15));
		add(closeBtn);

	}
}
