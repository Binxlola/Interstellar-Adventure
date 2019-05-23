package items;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import crewManagement.CrewMember;
import itemManagement.Inventory;
import itemManagement.Item;
import mainGui.MainScreen;
import management.AddGameScore;
import crewManagement.CrewSelector;

/**
 * The class implementation of the item EnergyDrink
 * @author Ariel Evangelista
 *
 */
public class EnergyDrink implements Item {
	
	/**
	 * The one any only one instance of the Inventory class
	 */
	private Inventory inv = Inventory.getInstance();
	
	/**
	 * The drop chance of the item
	 */
	private double dropChance = 10;
	
	/**
	 * The name of the item
	 */
	private String name = "Energy Drink";
	
	/**
	 * The type of the item
	 */
	private String type = "Food";
	
	/**
	 * The initial count of the item
	 */
	private int itemCount = 1;
	
	/**
	 * The price of the item
	 */
	private int price = 120;
	
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
					CrewSelector useItem = new CrewSelector("Select a Crew to drink " + getName() + ":", "Use Item");
					CrewMember crewUser = useItem.getCrew();
					if (crewUser != null) {
						deductCount();
						crewUser.eat(10);
						crewUser.addMove();
						crewUser.addMove();
						JOptionPane.showMessageDialog(null, crewUser.getName() + " drank the " + getName() + " and become 10 less hungry!"
								+ "\nBecause of energy boost, he gained one more move!"
								+ "\n                              (No moves deducted)");
						new AddGameScore(getPrice());
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
						EnergyDrink item = new EnergyDrink();
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
