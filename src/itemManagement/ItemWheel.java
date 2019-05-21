package itemManagement;

import java.util.ArrayList;
import java.util.Random;

import items.LargeHP;
import items.ShipPart;
import items.SmallHP;
import items.Water;

import java.util.List;

public class ItemWheel {
	
	private List<Item> items = new ArrayList<Item>();
	
	private static ItemWheel _session = null;
	
	private ItemWheel() {
		// Initialize list with all items
		LargeHP largeHP = new LargeHP();
		ShipPart shipPart = new ShipPart();
		SmallHP smallHP = new SmallHP();
		Water water = new Water();
		
		items.add(largeHP);
		items.add(shipPart);
		items.add(smallHP);
		items.add(water);
	}
	
	public static ItemWheel getInstance() {
		if(_session == null) {
			_session = new ItemWheel();
		}
		return _session;
	}
	
	// Returns the selected index based on the weights(probabilities)
	private Item rouletteSelect() {
		// calculate the total weight
		double weight_sum = 0;
		for(Item item: items) {
			weight_sum += item.getDropChance();
		}
		// get a random value
		double value = randUniformPositive() * weight_sum;	
		// locate the random value based on the weights
		for(Item item: items) {		
			value -= item.getDropChance();		
			if(value < 0) return item;
		}
		// when rounding errors occur, we return the last item's index 
		return null;
	}

	// Returns a uniformly distributed double value between 0.0 and 1.0
	private double randUniformPositive() {
		// easiest implementation
		return new Random().nextDouble();
	}
	
	public Item getItem() {
		return this.rouletteSelect();
	}
	

}
