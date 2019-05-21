package mainGui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import itemManagement.Inventory;
import itemManagement.Item;

public class OutpostContent extends JPanel {
	
	private Inventory inventory = Inventory.getInstance();
	
	private MainScreen window;

	/**
	 * Create the panel.
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
		
		populatePanel();
	}
	
	/**
	 * Populates the outpost content panel
	 */
	private void populatePanel() {
		// Item type searator's
		JSeparator invSeparator1 = new JSeparator();
		invSeparator1.setOrientation(SwingConstants.VERTICAL);
		invSeparator1.setBounds(700, 95, 1, 380);
		invSeparator1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		add(invSeparator1);
		
		// Labels for items for sale
		JLabel storeLbl = new JLabel("ITEMS FOR SALE");
		storeLbl.setFont(new Font("Unispace", Font.PLAIN, 15));
		storeLbl.setHorizontalAlignment(SwingConstants.CENTER);
		storeLbl.setBounds(205, 80, 300, 24);
		add(storeLbl);
		
		// Labels for own items
		JLabel invLbl = new JLabel("INVENTORY");
		invLbl.setFont(new Font("Unispace", Font.PLAIN, 15));
		invLbl.setHorizontalAlignment(SwingConstants.CENTER);
		invLbl.setBounds(690, 80, 300, 24);
		add(invLbl);
		
		// Store display section
		JScrollPane storeScroll = new JScrollPane();
		storeScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		storeScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		storeScroll.setBounds(20, 105, 670, 364);
		add(storeScroll);
		
		JPanel storePanel = new JPanel();
		storeScroll.setViewportView(storePanel);
		storePanel.setLayout(null);
		
		// Inventory display section
		JScrollPane invScroll = new JScrollPane();
		invScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		invScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		invScroll.setBounds(710, 105, 260, 364);
		add(invScroll);
		
		JPanel invPanel = new JPanel();
		invScroll.setViewportView(invPanel);
		invPanel.setLayout(null);
		
		this.populateInventory(invPanel);
	}
	
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
				System.out.println("WORKING!");
				JButton btn = item.getSellBtn(btnXY[0], btnXY[1]);
				section.add(btn);
				
				if((current % 2) == 1) { // Set coords for the next item on the right
					btnXY[0] += 125;
				}
				else { // Set coords for next item on the bottom left.
					btnXY[0] -= 125;
					btnXY[1] += 35;
				}
				current += 1;
			}
		}
	}

}
