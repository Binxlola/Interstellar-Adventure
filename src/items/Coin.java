package items;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import itemManagement.Item;

import mainGui.MainScreen;

/**
 * The class implementation of the item Coin
 * @author Ariel Evangelista
 *
 */
public class Coin implements Item {
	
	/**
	 * The drop chance of the item
	 */
	private double dropChance = 15;
	
	/**
	 * The name of the item
	 */
	private String name = "Coin";
	
	/**
	 * The type of the item
	 */
	private String type = "Coin";
	
	/**
	 * The initial count of the item
	 */
	private int itemCount = 1;
	
	/**
	 * The price of the item
	 */
	private int price = 1;
	
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
	 * @param x position of the button in the x axis
	 * @param y position of the button in the y axis
	 * @param window The managing MainScreen class
	 * @return The created item JButton
	 */
	public JButton getUseBtn(int x, int y, MainScreen window) {
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
	 * @param x position of the button in the x axis
	 * @param y position of the button in the y axis
	 * @param window The managing MainScreen class
	 * @return The created item JButton
	 */
	public JButton getBuyBtn(int x, int y, MainScreen window) {
		JButton test = new JButton(this.name + " (" + getPrice() + " coins)");
		test.setBounds(x, y, 180, 100);
		test.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		return test;
	}
	
	/**
	 * Creates a JButton that can be used to display the item in a player's inventory at the space outpost.
	 * @param x position of the button in the x axis
	 * @param y position of the button in the y axis
	 * @param window The managing MainScreen class
	 * @return The created item JButton
	 */
	public JButton getSellBtn(int x, int y, MainScreen window) {
		JButton test = new JButton(this.name + " (" + (int)(0.5*getPrice()) + " coins)");
		test.setBounds(x, y, 170, 40);
		test.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		return test;
	}
}
