package items;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import itemManagement.Inventory;
import itemManagement.Item;

public class Bread implements Item {
	
	private Inventory inv = Inventory.getInstance();
	private double dropChance = 20;
	private String name = "Bread";
	private String type = "Food";
	private int itemCount = 1;
	private int price = 20;
	
	/**
	 * Will return the name the item
	 * @return A String representing the name of the item.
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Will return the category the item would fall into (the items type)
	 * @return A String representing what kind of item this is.
	 */
	public String getType() {
		return this.type;
	}
	
	/**
	 * Adds 1 to the items count, representing how many of this type item the player owns.
	 */
	public void addCount() {
		this.itemCount += 1;
	}
	
	/**
	 * Deducts 1 to the items count, representing how many of this type item the player owns.
	 */
	public void deductCount() {
		this.itemCount -= 1;
	}
	
	/**
	 * Gets the current number of item of this type
	 * @return Current number of item of this type
	 */
	public int getCount() {
		return this.itemCount;
	}
	
	/**
	 * Gets the chance of this item to drop
	 * @return The chance of this item to drop
	 */
	public double getDropChance() {
		return this.dropChance;
	}
	
	/**
	 * Gets the price of this item
	 * @return The price of this item
	 */
	public int getPrice() {
		return this.price;
	}
	
	/**
	 * Creates a JButton that can be used to display the item in a players inventory.
	 * @return The created item JButton
	 */
	public JButton getUseBtn(int x, int y) {
		JButton test = new JButton(this.name + " (" + getCount() + ")");
		test.setBounds(x, y, 130, 30);
		test.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		return test;
	}
	
	/**
	 * Creates a JButton that can be used to display the item in the space outpost.
	 * @return The created item JButton
	 */
	public JButton getBuyBtn(int x, int y) {
		JButton test = new JButton(this.name + " (" + getPrice() + " coins)");
		test.setBounds(x, y, 180, 100);
		test.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (inv.canAfford(getPrice()) ) {
					Bread item = new Bread();
					inv.addItem(item);
					inv.payItem(getPrice());
					JOptionPane.showMessageDialog(null, "You bought a " + getName());
				} else {
					JOptionPane.showMessageDialog(null, "Sorry! You don't have enough coins!");
				}
			}
		});
		return test;
	}
	
	/**
	 * Creates a JButton that can be used to display the item in a player's inventory at the space outpost.
	 * @return The created item JButton
	 */
	public JButton getSellBtn(int x, int y) {
		JButton test = new JButton(this.name + " (" + (int)(0.5*getPrice()) + " coins)");
		test.setBounds(x, y, 170, 40);
		test.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (getCount() > 0) {
					deductCount();
					if (getCount() <= 0) test.setVisible(false);
					inv.addCoins((int)(0.5*getPrice()));
					JOptionPane.showMessageDialog(null, "You sold a " + getName() + " for " + (int)(0.5*getPrice()) + " coins!");
				} else {
					test.setVisible(false);
					JOptionPane.showMessageDialog(null, "You no longer have " + getName() + "!");
				}
			}
		});
		return test;
	}
}
