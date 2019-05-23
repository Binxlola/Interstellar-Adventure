package gameEvents;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;

import itemManagement.Inventory;
import itemManagement.Item;


/**
 * Alien Pirates event has 33% chance to be picked by Random Event handler
 * A random item may be picked out by the alien pirates (including ship part)
 * but very unlikely
 * The item to be stolen has a chance based on the item's drop chance
 * @author Ariel Evangelista
 */
public class AlienPirates {
	
	Inventory inv = Inventory.getInstance();
	private List<Item> potions = inv.getPotions();
	private List<Item> foods = inv.getFoods();
	private List<Item> misc = inv.getMisc();

	public AlienPirates() {
		initialize();
	}
	
	/**
	 * Initializes Alien Pirates Event
	 */
	private void initialize() {
		
		if (potions.size() == 0 && foods.size() == 0 && misc.size() == 0) {
			JOptionPane.showMessageDialog(null, "Oh no! Alien Pirates boarded your ship!"
					+ "\nLuckily, you don't have anything in your inventory!");
		} else {
			// 60%: Food, 30%: Potion, 10% Ship Part, 20% Nothing
			List<Item> items = new ArrayList<Item>();
			Item stolenItem = null;
			
			while (stolenItem == null) {
				double type = new Random().nextDouble();
				if (type < 0.1) items = misc;
				else if (type < 0.40) items = potions;
				else items = foods;
				
				// calculate the total weight
				double weight_sum = 0;
				for(Item item: items) {
					weight_sum += item.getDropChance();
				}
				// get a random value
				double value = new Random().nextDouble() * weight_sum;	
				// locate the random value based on the weights
				for(Item item: items) {
					value -= item.getDropChance();		
					if(value < 0) stolenItem = item;
				}
			}
			
			if (stolenItem.getType() == "Ship Part") {
				JOptionPane.showMessageDialog(null, "Oh no! Alien Pirates boarded your ship and stole a Ship Part!"
						+ "\nYou must not allow the warp drive to fall"
						+ "\n             to the wrong hands!");
			} else {
				JOptionPane.showMessageDialog(null, "Oh no! Alien Pirates boarded your ship and stole " + stolenItem.getName() + "!");
			}
			
			stolenItem.deductCount();
		}
	}
}
