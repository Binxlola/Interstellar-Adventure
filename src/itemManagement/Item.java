package itemManagement;

import javax.swing.JButton;

import mainGui.MainScreen;

/**
 * The interface for all item class
 * @author Jason Smit
 * @author Ariel Evangelista
 *
 */
public interface Item {
	
	/**
	 * Will return the name the item
	 * @return A String representing the name of the item.
	 */
	public String getName();
	
	/**
	 * Will return the category the item would fall into (the items type)
	 * @return A String representing what kind of item this is.
	 */
	public String getType();
	
	/**
	 * Adds 1 to the items count, representing how many of this type item the player owns.
	 */
	public void addCount();
	
	/**
	 * Deducts 1 to the items count, representing how many of this type item the player owns.
	 */
	public void deductCount();
	
	/**
	 * Gets the current number of item of this type
	 * @return Current number of item of this type
	 */
	public int getCount();
	
	/**
	 * Gets the chance of this item to drop
	 * @return The chance of this item to drop
	 */
	public double getDropChance();
	
	/**
	 * Gets the price of this item
	 * @return The price of this item
	 */
	public int getPrice();
	
	/**
	 * Creates a JButton that can be used to display the item in a players inventory.
	 * @param x position of the button in the x axis
	 * @param y position of the button in the y axis
	 * @param window The managing MainScreen class
	 * @return The created item JButton
	 */
	public JButton getUseBtn(int x, int y, MainScreen window);
	
	/**
	 * Creates a JButton that can be used to display the item in the space outpost.
	 * @param x position of the button in the x axis
	 * @param y position of the button in the y axis
	 * @param window The managing MainScreen class
	 * @return The created item JButton
	 */
	public JButton getBuyBtn(int x, int y, MainScreen window);
	
	/**
	 * Creates a JButton that can be used to display the item in a player's inventory at the space outpost.
	 * @param x position of the button in the x axis
	 * @param y position of the button in the y axis
	 * @param window The managing MainScreen class
	 * @return The created item JButton
	 */
	public JButton getSellBtn(int x, int y, MainScreen window);

}
