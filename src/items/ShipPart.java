package items;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import itemManagement.Item;

public class ShipPart implements Item {
	private double dropChance = 0.1;
	private String name = "Ship Part";
	private String type = "Misc";
	private int itemCount = 1;
	
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
	 * Creates a JButton that can be used to display the item in a players inventory.
	 * @return The created item JButton
	 */
	public JButton getBtn(int x, int y) {
		JButton test = new JButton(this.name + " (" + getCount() + ")");
		test.setBounds(x, y, 130, 30);
		test.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		return test;
	}
}
