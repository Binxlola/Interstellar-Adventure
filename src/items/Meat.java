package items;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import crewManagement.CrewMember;
import crewManagement.CrewSelector;
import itemManagement.Inventory;
import itemManagement.Item;
import mainGui.MainScreen;

public class Meat implements Item {
	
	private Inventory inv = Inventory.getInstance();
	private double dropChance = 15;
	private String name = "Meat";
	private String type = "Food";
	private int itemCount = 1;
	private int price = 50;
	
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
	public JButton getUseBtn(int x, int y, MainScreen window) {
		JButton test = new JButton(this.name + " (" + getCount() + ")");
		test.setBounds(x, y, 130, 30);
		test.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (getCount() > 0) {
					CrewSelector useItem = new CrewSelector("Select a Crew to eat " + getName() + ":", "Use Item");
					CrewMember crewUser = useItem.getCrew();
					if (crewUser == null) JOptionPane.showMessageDialog(null, "You have to select a Crew to eat this item!");
					else {
						deductCount();
						crewUser.eat(50);
						crewUser.deductMove();
						JOptionPane.showMessageDialog(null, crewUser.getName() + " ate the " + getName() + " and become 50 less hungry!");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Sorry! You don't have this item anymore!");
				}
				window.changeContent("Inventory");
			}
		});
		return test;
	}
	
	/**
	 * Creates a JButton that can be used to display the item in the space outpost.
	 * @return The created item JButton
	 */
	public JButton getBuyBtn(int x, int y, MainScreen window) {
		JButton test = new JButton(this.name + " (" + getPrice() + " coins)");
		test.setBounds(x, y, 180, 100);
		test.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (inv.canAfford(getPrice()) ) {
					int input = JOptionPane.showConfirmDialog(null, "Are you sure you want to buy " + getName() +"?",
							"Buy", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
					if (input == 0) {
						Meat item = new Meat();
						inv.addItem(item);
						inv.payItem(getPrice());
					}
				} else {
					JOptionPane.showMessageDialog(null, "Sorry! You don't have enough coins!");
				}
				window.changeContent("Outpost");
			}
		});
		return test;
	}
	
	/**
	 * Creates a JButton that can be used to display the item in a player's inventory at the space outpost.
	 * @return The created item JButton
	 */
	public JButton getSellBtn(int x, int y, MainScreen window) {
		JButton test = new JButton(this.name + " (" + getCount() + ")");
		test.setBounds(x, y, 170, 40);
		test.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (getCount() > 0) {
					int input = JOptionPane.showConfirmDialog(null, "Are you sure you want to sell " + getName() +"?",
							"Sell", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
					if (input == 0) {
						deductCount();
						if (getCount() <= 0) test.setVisible(false);
						inv.addCoins((int)(0.5*getPrice()));
					}
				} else {
					test.setVisible(false);
					JOptionPane.showMessageDialog(null, "You no longer have " + getName() + "!");
				}
				window.changeContent("Outpost");
			}
		});
		return test;
	}
}
