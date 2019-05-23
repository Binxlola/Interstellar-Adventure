package mainGui;

import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Color;

import javax.swing.border.MatteBorder;

import itemManagement.Inventory;
import itemManagement.Item;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Represents the inventory of the player
 * @author Jason Smit
 * @author Ariel Evangelista
 * @version 1.0, May 2019.
 */
@SuppressWarnings("serial")
public class InventoryDisplay extends JPanel {
	
	/**
	 * The managing MainScreen class
	 */
	MainScreen window;
	
	/**
	 * The one and only one instance of the Inventory class
	 */
	private Inventory inventory = Inventory.getInstance();

	/**
	 * Create the panel
	 * @param incomingWindow The managing MainScreen
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
		potionsLbl.setFont(new Font("Rockwell", Font.PLAIN, 18));
		potionsLbl.setHorizontalAlignment(SwingConstants.CENTER);
		potionsLbl.setBounds(10, 60, 300, 24);
		add(potionsLbl);
		
		JLabel foodLbl = new JLabel("Food");
		foodLbl.setHorizontalAlignment(SwingConstants.CENTER);
		foodLbl.setFont(new Font("Rockwell", Font.PLAIN, 18));
		foodLbl.setBounds(341, 60, 300, 24);
		add(foodLbl);
		
		JLabel micLbl = new JLabel("Misc");
		micLbl.setHorizontalAlignment(SwingConstants.CENTER);
		micLbl.setFont(new Font("Rockwell", Font.PLAIN, 18));
		micLbl.setBounds(671, 60, 300, 24);
		add(micLbl);
		
		JLabel invLbl = new JLabel("INVENTORY");
		invLbl.setHorizontalAlignment(SwingConstants.CENTER);
		invLbl.setBounds(341, 11, 300, 25);
		invLbl.setFont(new Font("Distant Galaxy", Font.PLAIN, 24));
		add(invLbl);
		
		// Button to close inventory
		JButton backBtn = new JButton("Back");
		backBtn.setBounds(50, 500, 140, 30);
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				window.changeContent("mainScreen");
			}
		});
		add(backBtn);
		
		// Potion item display section
		JScrollPane potionScroll = new JScrollPane();
		potionScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		potionScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		potionScroll.setBounds(20, 96, 305, 364);
		add(potionScroll);
		
		JPanel potionPanel = new JPanel();
		potionScroll.setViewportView(potionPanel);
		potionPanel.setLayout(null);
		
		List<Item> potions = inventory.getPotions();
		this.populateItems(potionPanel, potions);
		
		// Food item display section
		JScrollPane foodScroll = new JScrollPane();
		foodScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		foodScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		foodScroll.setBounds(343, 96, 305, 364);
		add(foodScroll);
		
		JPanel foodPanel = new JPanel();
		foodScroll.setViewportView(foodPanel);
		foodPanel.setLayout(null);
		
		List<Item> foods = inventory.getFoods();
		this.populateItems(foodPanel, foods);
		
		// Misc item display section
		JScrollPane miscScroll = new JScrollPane();
		miscScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		miscScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		miscScroll.setBounds(675, 96, 305, 364);
		add(miscScroll);
		
		JPanel miscPanel = new JPanel();
		miscScroll.setViewportView(miscPanel);
		miscPanel.setLayout(null);
		
		List<Item> misc = inventory.getMisc();
		this.populateItems(miscPanel, misc);
		
		// Wallet display section
		JLabel walletLbl = new JLabel("Wallet: " + inventory.getWallet());
		walletLbl.setBounds(200, 500, 300, 30);
		walletLbl.setFont(new Font("Unispace", Font.PLAIN, 18));
		add(walletLbl);
	}
	
	/**
	 * Populates the inventory with the player's items
	 * @param section The panel to be populated
	 * @param items The items to populate the panel
	 */
	private void populateItems(JPanel section, List<Item> items) {
		int current = 1;
		// 6, 5
		int[] btnXY = new int[] {20, 5};
		for(Item item: items) {
			if (item.getCount() > 0) {
				JButton btn = item.getUseBtn(btnXY[0], btnXY[1], window);
				section.add(btn);
				
				if((current % 2) == 1) { // Set coords for the next item on the right
					// 136
					btnXY[0] += 136;
				}
				else { // Set coords for next item on the bottom left.
					btnXY[0] -= 136;
					btnXY[1] += 35;
				}
				current += 1;
			}
		}
	}
}
