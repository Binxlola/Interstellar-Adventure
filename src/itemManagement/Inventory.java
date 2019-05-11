package itemManagement;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
	
	public static Inventory _session = null;
	private List<Item> inventory = new ArrayList<Item>();
	private int wallet;
	
	/** Private constructor for Inventory class, and as such can only be created from inside. */
	private Inventory() {}
	
	/**
	 * Checks if there is already an instance of the Inventory, if not then one will be created.
	 * @return The instance of the Inventory (can only ever have one.)
	 */
	public static Inventory getInstance() {
		if(_session == null) {
			_session = new Inventory();
		}
		return _session;
	}
	
	/**
	 * Gets the list of all items in inventory and returns it.
	 * @return A List<Item> holding all the items currently in the players inventory.
	 */
	public List<Item> getInventory() {
		return this.inventory;
	}
	
	/**
	 * Adds a given item to the players inventory, if the item is not in the list then the item will be added. 
	 * If the item is already in the list then it's count will be incremented.
	 * @param item A Item object representing the item to be added to the inventory.
	 * @return A string describing if the item was already in the list, or it it was not.
	 */
	public String addItem(Item item) {
		if(inventory.contains(item)) {
			return "Item is here";
			}
		else {
			inventory.add(item);
			return "Item is not here";
		}
	}
}
