package items;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import itemManagement.Item;

public class LargeHP implements Item {
	private int dropChance;
	public String type = "Potion";
	private int itemCount = 1;
	
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
	 * Creates a JButton that can be used to display the item in a players inventory.
	 * @return The created item JButton
	 */
	public JButton getBtn(int x, int y) {
		JButton test = new JButton("LargeHP");
		test.setBounds(x, y, 100, 50);
		test.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		return test;
	}
}
