package itemManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import management.AddGameScore;

/**
 * The Inventory class of the game which holds the data for all available items for the player
 * @author Jason Smit
 * @author Ariel Evangelista
 *
 */
public class Inventory {
	
	/**
	 * The one and only one instance of the Inventory class
	 */
	public static Inventory _session = null;
	
	/**
	 * The list of all the player's item of type potion
	 */
	private List<Item> potions = new ArrayList<Item>();
	
	/**
	 * The list of all the player's item of type food
	 */
	private List<Item> foods = new ArrayList<Item>();
	
	/**
	 * The list of all the player's item of type misc
	 */
	private List<Item> misc = new ArrayList<Item>();

	/**
	 * The current money of the player
	 */
	private int wallet = 0;

	
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
	 * Gets the list of all items in the players inventory that are of type potion and returns it.
	 * @return A List holding all the potions currently in the players inventory.
	 */
	public List<Item> getPotions() {
		return this.potions;
	}
	
	/**
	 * Gets the list of all items in the players inventory that are of type food and returns it.
	 * @return A List holding all the foods currently in the players inventory.
	 */
	public List<Item> getFoods() {
		return this.foods;
	}
	
	/**
	 * Gets the list of all items in the players inventory that are of type misc and returns it.
	 * @return A List holding all the miscs currently in the players inventory.
	 */
	public List<Item> getMisc() {
		return this.misc;
	}
	
	/**
	 * Returns the players wallet value as a string to be displayed in the inventory window.
	 * @return A String describing the players wallet value.
	 */
	public String getWallet() {
		String temp = String.format("%s coins", this.wallet);
		return temp;
	}
	
	/**
	 * Returns the player's wallet value as an integer
	 * @return An Integer representing the players wallet value
	 */
	public int getCoins() {
		return this.wallet;
	}
	
	/**
	 * Check if the player can afford some item
	 * @param cost The cost of the item a player tries to buy
	 * @return Returns true if the player can afford the item
	 */
	public boolean canAfford(int cost) {
		return (this.wallet >= cost);
	}
	
	/**
	 * Pays for an item bought by the player
	 * @param cost The cost of the item a player bought
	 */
	public void payItem(int cost) {
		this.wallet -= cost;
	}
	
	/**
	 * Add coins to the player's wallet
	 * @param cost The number of coins to be added to the wallet
	 */
	public void addCoins(int cost) {
		this.wallet += cost;
	}
	
	/**
	 * Adds a given item to the players inventory, if the item is not in the list then the item will be added. 
	 * If the item is already in the list then it's count will be incremented.
	 * @param item A Item object representing the item to be added to the inventory.
	 */
	public void addItem(Item item) {
		String itemType = "";
		if (item != null) {
			itemType = item.getType();
			int scoreRoll = (int) (10 * item.getPrice() * new Random().nextDouble());
			new AddGameScore(scoreRoll);
		}
		
		switch(itemType) {
		case "Potion":
			this.addPotion(item);
			break;
		case "Food":
			this.addFood(item);
			break;
		case "Misc":
			this.addMisc(item);
			break;
		case "Coin":
			this.addCoins(item.getCount());
		}
	}
	
	/**
	 * Deducts a given item to the players inventory then it's count will be incremented.
	 * @param item A Item object representing the item to be deducted to the inventory.
	 */
	public void deductItem(Item item) {
		String itemType = item.getType();
		
		switch(itemType) {
		case "Potion":
			this.deductPotion(item);
			break;
		case "Food":
			this.deductFood(item);
			break;
		case "Misc":
			this.deductMisc(item);
			break;
		}
	}
	
	/**
	 * Checks if the item already exists in an item list
	 * @param newItem The Item that is to be found
	 * @param itemList The list of Item where the newItem are to be searched
	 * @return the index of the item in the list
	 */
	private int itemInList(Item newItem, List<Item> itemList) {
		for (Item item: itemList) {
			if (item.getClass() == newItem.getClass()) {
				return itemList.indexOf(item);
			}
		}
		return -1;
	}
	
	/**
	 * Adds the item of type potion to the potions array.
	 * @param item The Item that is to be added to the players inventory.
	 */
	private void addPotion(Item item) {
		int indx = itemInList(item, potions);
		if(indx > -1) {
			Item owned = potions.get(indx);
			owned.addCount();
		}
		else {
			potions.add(item);
		}
	}
	
	/**
	 * Adds the item of type potion to the potions array.
	 * @param item The Item that is to be added to the players inventory.
	 */
	private void addFood(Item item) {
		int indx = itemInList(item, foods);
		if(indx > -1) {
			Item owned = foods.get(indx);
			owned.addCount();
		}
		else {
			foods.add(item);
		}
	}
	
	/**
	 * Adds the item of type potion to the potions array.
	 * @param item The Item that is to be added to the players inventory.
	 */
	private void addMisc(Item item) {
		int indx = itemInList(item, misc);
		if(indx > -1) {
			Item owned = misc.get(indx);
			owned.addCount();
		}
		else {
			misc.add(item);
		}
	}
	
	/**
	 * Deducts an item of type potion from the potions array.
	 * @param item The Item that is to be deducted to the players inventory.
	 */
	private void deductPotion(Item item) {
		int indx = itemInList(item, potions);
		Item owned = potions.get(indx);
		owned.deductCount();
	}
	
	/**
	 * Deducts an item of type food from the foods array.
	 * @param item The Item that is to be deducted to the players inventory.
	 */
	private void deductFood(Item item) {
		int indx = itemInList(item, foods);
		Item owned = foods.get(indx);
		owned.deductCount();
	}
	
	/**
	 * Deducts an item of type misc from the misc array.
	 * @param item The Item that is to be deducted to the players inventory.
	 */
	private void deductMisc(Item item) {
		int indx = itemInList(item, misc);
		Item owned = misc.get(indx);
		owned.deductCount();
	}
	
	/**
	 * Resets the inventory fresh for a new game
	 */
	public void resetInv() {
		potions.removeAll(potions);
		foods.removeAll(foods);
		misc.removeAll(misc);
		this.wallet = 0;
	}

}
