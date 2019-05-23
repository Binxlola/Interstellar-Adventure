package mainGui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import itemManagement.Inventory;
import itemManagement.Item;
import items.Bread;
import items.Chips;
import items.EnergyDrink;
import items.IceCream;
import items.LargeHP;
import items.Meat;
import items.SmallHP;
import items.SpacePills;
import items.Water;

/**
 * Represents the Outpost (Store) of the game
 * @author Jason Smit
 * @author Ariel Evangelista
 * @version 1.0, May 2019.
 */
@SuppressWarnings("serial")
public class OutpostContent extends JPanel {
	
	/**
	 * The one and only one instance of Inventory class
	 */
	private Inventory inventory = Inventory.getInstance();
	
	/**
	 * The incoming MainScreen class
	 */
	private MainScreen window;
	
	/**
	 * The Panel of the store
	 */
	private JPanel storePanel;
	
	/**
	 * The panel for the inventory
	 */
	private JPanel invPanel;

	/**
	 * Create the panel.
	 * @param incomingWindow The incoming MainScreen class
	 */
	public OutpostContent(MainScreen incomingWindow) {
		window = incomingWindow;
		setBounds(0, 0, 1000, 600);
		setLayout(null);
		
		JLabel outpostLbl = new JLabel("WELCOME TO THE SPACE OUTPOST");
		outpostLbl.setFont(new Font("Distant Galaxy", Font.PLAIN, 24));
		outpostLbl.setBounds(42, 33, 600, 40);
		this.add(outpostLbl);
		
		
		JButton backBtn = new JButton("Back");
		backBtn.setBounds(50, 500, 140, 30);
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				window.changeContent("mainScreen");
			}
		});
		add(backBtn);
		
		JLabel walletValLbl = new JLabel("Wallet: " + inventory.getWallet());
		walletValLbl.setBounds(200, 500, 300, 30);
		walletValLbl.setFont(new Font("Unispace", Font.PLAIN, 18));
		add(walletValLbl);
		
		JLabel noteLbl = new JLabel("Selling an item will give you 50% of its cost!");
		noteLbl.setHorizontalAlignment(SwingConstants.CENTER);
		noteLbl.setFont(new Font("Rockwell", Font.PLAIN, 18));
		noteLbl.setBounds(450, 490, 500, 50);
		add(noteLbl);
		
		populatePanel();
	}
	
	/**
	 * Populates the outpost content panel
	 */
	private void populatePanel() {
		// Item type searator's
		JSeparator invSeparator1 = new JSeparator();
		invSeparator1.setOrientation(SwingConstants.VERTICAL);
		invSeparator1.setBounds(600, 95, 1, 380);
		invSeparator1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		add(invSeparator1);
		
		// Labels for items for sale
		JLabel storeLbl = new JLabel("ITEMS FOR SALE");
		storeLbl.setFont(new Font("Unispace", Font.PLAIN, 15));
		storeLbl.setHorizontalAlignment(SwingConstants.CENTER);
		storeLbl.setBounds(155, 80, 300, 24);
		add(storeLbl);
		
		// Labels for own items
		JLabel invLbl = new JLabel("INVENTORY");
		invLbl.setFont(new Font("Unispace", Font.PLAIN, 15));
		invLbl.setHorizontalAlignment(SwingConstants.CENTER);
		invLbl.setBounds(640, 80, 300, 24);
		add(invLbl);
		
		// Store display section
		JScrollPane storeScroll = new JScrollPane();
		storeScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		storeScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		storeScroll.setBounds(20, 105, 573, 364);
		add(storeScroll);
		
		storePanel = new JPanel();
		storeScroll.setViewportView(storePanel);
		storePanel.setLayout(null);
		
		// Inventory display section
		JScrollPane invScroll = new JScrollPane();
		invScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		invScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		invScroll.setBounds(610, 105, 360, 364);
		add(invScroll);
		
		invPanel = new JPanel();
		invScroll.setViewportView(invPanel);
		invPanel.setLayout(null);
		
		this.populateInventory(invPanel);
		this.populateStore(storePanel);
	}
	
	/**
	 * Put items in the inventory panel
	 * @param section The panel to be populated
	 */
	private void populateInventory(JPanel section) {
		List<Item> potions = inventory.getPotions();
		List<Item> foods = inventory.getFoods();
		List<Item> misc = inventory.getMisc();
		ArrayList<List<Item>> allItems = new ArrayList<List<Item>>();
		allItems.add(potions);
		allItems.add(foods);
		allItems.add(misc);
		
		
		int current = 1;
		int[] btnXY = new int[] {5, 5};
		
		for (List<Item> cat: allItems) {
			for(Item item: cat) {
				if (item.getCount() > 0) {
				JButton btn = item.getSellBtn(btnXY[0], btnXY[1], window);
				section.add(btn);
				
				if((current % 2) == 1) { // Set coords for the next item on the right
					btnXY[0] += 175;
				}
				else { // Set coords for next item on the bottom left.
					btnXY[0] -= 175;
					btnXY[1] += 45;
				}
				current += 1;
				}
			}
		}
	}
	
	/**
	 * Put items in the store panel
	 * @param section The panel to be populated
	 */
	private void populateStore(JPanel section) {
		List<Item> storeItems = new ArrayList<Item>();
		// Food
		Bread bread = new Bread();
		Chips chips = new Chips();
		EnergyDrink energyDrink = new EnergyDrink();
		IceCream iceCream = new IceCream();
		Meat meat = new Meat();
		Water water = new Water();
		
		// Medical Supplies
		LargeHP largeHP = new LargeHP();
		SmallHP smallHP = new SmallHP();
		SpacePills spacePills = new SpacePills();
		
		storeItems.add(bread);
		storeItems.add(chips);
		storeItems.add(energyDrink);
		storeItems.add(iceCream);
		storeItems.add(meat);
		storeItems.add(water);
		storeItems.add(largeHP);
		storeItems.add(smallHP);
		storeItems.add(spacePills);
		
		
		int i = 0;
		int x = 5;
		int y = -95;
		
		for(i = 0; i < storeItems.size(); i++) {
			JButton btn = new JButton();
			if (i < 3) {
				btn = storeItems.get(i).getBuyBtn(x, y+=110, window);
			} else if (i < 6) {
				if (i == 3) y = -95;
				btn = storeItems.get(i).getBuyBtn(x+190, y+=110, window);
			} else if (i < 9) {
				if (i == 6) y = -95;
				btn = storeItems.get(i).getBuyBtn(x+380, y+=110, window);
			}
			
			section.add(btn);
			
		}
	}

}
