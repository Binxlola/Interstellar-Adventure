package itemManagement;

import java.util.ArrayList;
import java.util.Random;

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
import management.GameManager;

import java.util.List;

public class ItemWheel {
	
	private List<Item> potions = new ArrayList<Item>();
	private List<Item> foods = new ArrayList<Item>();
	private List<Item> misc = new ArrayList<Item>();
	
	private static ItemWheel _session = null;
	private GameManager gameManager = GameManager.getInstance();
	
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
		double type = randUniformPositive();
		if (type < 0.3) items = foods;
		else if (type < 0.50) items = potions;
		else if (type < 0.70) items = misc;
		else if (type < 0.90) {
			Coin coin = new Coin();
			double temp = randUniformPositive() * 100;
			double temp2 = randUniformPositive() * 1.25;
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
