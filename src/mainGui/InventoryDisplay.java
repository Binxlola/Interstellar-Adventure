package mainGui;

import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import itemManagement.Inventory;
import itemManagement.Item;
import items.LargeHP;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class InventoryDisplay extends JPanel {
	MainScreen window;
	private JTable table;
	private Inventory inventory = Inventory.getInstance();

	/**
	 * Create the panel.
	 */
	public InventoryDisplay(MainScreen incomingWindow) {
		window = incomingWindow;

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
		
		// Potion item display section
		JScrollPane potionScroll = new JScrollPane();
		potionScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		potionScroll.setBounds(20, 96, 305, 364);
		add(potionScroll);
		
		JPanel potionPanel = new JPanel();
		potionScroll.setViewportView(potionPanel);
		potionPanel.setLayout(null);
		
		List<Item> potions = inventory.getPotions();
		this.populateItems(potionPanel, potions);
		
//		JButton btnItem_1 = new JButton("item 2");
//		btnItem_1.setBounds(6, 5, 64, 64);
//		panel.add(btnItem_1);
//		
//		JButton btnItem = new JButton("item 1");
//		btnItem.setBounds(142, 5, 64, 64);
//		panel.add(btnItem);
//		
//		JLabel lblNewLabel = new JLabel("x5");
//		lblNewLabel.setBounds(218, 43, 16, 16);
//		panel.add(lblNewLabel);
//		
//		JLabel lblX = new JLabel("x3");
//		lblX.setBounds(74, 43, 61, 16);
//		panel.add(lblX);
		

	}
	
	private void populateItems(JPanel section, List<Item> items) {
		int current = 1;
		int[] btnXY = new int[] {6, 5};
		for(Item item: items) {
			JButton btn = item.getBtn(btnXY[0], btnXY[1]);
			section.add(btn);
			
			if((current % 2) == 1) { // Set coords for the next item on the right
				btnXY[0] += 136;
			}
			else { // Set coords for next item on the bottom left.
				btnXY[0] -= 136;
			}
			current += 1;
		}
	}
}
