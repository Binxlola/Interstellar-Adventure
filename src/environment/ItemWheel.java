package environment;

import java.util.ArrayList;
import java.util.Random;

import itemManagement.Item;
import items.Bread;
import items.Chips;
import items.Coin;
import items.EnergyDrink;
import items.IceCream;
import items.LargeHP;
import items.Meat;
import items.ShipPart;
import items.SmallHP;
import items.SpacePills;
import items.Water;

import java.util.List;

public class ItemWheel {
	
	private Environment env = Environment.getInstance();
	private Planet currentPlanet = env.getSelectedPlanet();
	private List<Item> potions = new ArrayList<Item>();
	private List<Item> foods = new ArrayList<Item>();
	private List<Item> misc = new ArrayList<Item>();
	
	private static ItemWheel _session = null;
	
	private ItemWheel() {
		// Initialize list with all items
		
		// Potions
		LargeHP largeHP = new LargeHP();
		SmallHP smallHP = new SmallHP();
		SpacePills spacePills = new SpacePills();
		
		// Foods
		Water water = new Water();
		Bread bread = new Bread();
		Chips chips = new Chips();
		EnergyDrink energyDrink = new EnergyDrink();
		IceCream iceCream = new IceCream();
		Meat meat = new Meat();
		
		// Misc
		ShipPart shipPart = new ShipPart();

		potions.add(largeHP);
		potions.add(smallHP);
		potions.add(spacePills);
		foods.add(water);
		foods.add(bread);
		foods.add(chips);
		foods.add(energyDrink);
		foods.add(iceCream);
		foods.add(meat);
		misc.add(shipPart);

		
	}
	
	public static ItemWheel getInstance() {
		if(_session == null) {
			_session = new ItemWheel();
		}
		return _session;
	}
	
	// Returns the selected index based on the weights(probabilities)
	private Item rouletteSelect() {
		
		// 30%: Food, 20%: Potion, 20% Ship Part, 20% Money, 10% Nothing
		List<Item> items = new ArrayList<Item>();
		double type = new Random().nextDouble();
		if (type < 0.3) items = foods;
		else if (type < 0.50) items = potions;
		else if (type < 0.70) items = misc;
		else if (type < 0.90) {
			Coin coin = new Coin();
			double temp = new Random().nextDouble() * 100;
			double temp2 = new Random().nextDouble() * 5;
			int multiplier = (int)temp2;
			int cost = (int)temp;
			for (int i = 0; i < cost*multiplier; i++) coin.addCount();
			return coin;
		}
		else return null;
		
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
			if(value < 0) return item;
		}
		// when rounding errors occur, we return the last item's index 
		return null;
	}

	/**
	 * Randomly generates an item from the list of all available implemented items
	 * @return Pseudo-randomly generated item
	 */
	public Item getItem() {
		return this.rouletteSelect();
	}
	

}
