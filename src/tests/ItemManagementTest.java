package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import itemManagement.Inventory;
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

class ItemManagementTest {

	@Test
	void itemTest() {
		Inventory inv = Inventory.getInstance();
		List<Item> itemList = new ArrayList<Item>();
		
		assertEquals(0, inv.getPotions().size());
		assertEquals(0, inv.getFoods().size());
		assertEquals(0, inv.getMisc().size());
	
		// Foods
		Bread bread = new Bread();
		Water water = new Water();
		Chips chips = new Chips();
		EnergyDrink energyDrink = new EnergyDrink();
		IceCream iceCream = new IceCream();
		Meat meat = new Meat();
		// Potions
		LargeHP largeHP = new LargeHP();
		SmallHP smallHP = new SmallHP();
		SpacePills spacePills = new SpacePills();
		// Misc
		ShipPart shipPart = new ShipPart();
		
		// Coin
		Coin coin = new Coin();
		
		assertEquals("Coin", coin.getName());
		coin.deductCount();
		assertEquals(0, coin.getCount());
		
		inv.addItem(bread);
		inv.addItem(smallHP);
		inv.addItem(shipPart);
		inv.addItem(coin);
		assertEquals(1, inv.getPotions().size());
		assertEquals(1, inv.getFoods().size());
		assertEquals(1, inv.getMisc().size());
		
		inv.addCoins(100);
		assertEquals(false, inv.canAfford(101));
		assertEquals(true, inv.canAfford(50));
		assertEquals("100 coins", inv.getWallet());
		inv.payItem(1);
		assertEquals("99 coins", inv.getWallet());
		
		
		String[] itemStrings = new String[] {"Bread", "Water", "Chips", "Energy Drink", "Ice Cream", "Meat",
				"Large HP", "Small HP", "Space Pills", "Ship Part"};
		
		int[] chances = new int[] {20, 20, 20, 10, 15, 15, 30, 50, 20, 10};
		int[] prices = new int[] {20, 15, 10, 120, 25, 50, 100, 60, 150, 100};
		
		itemList.add(bread);
		itemList.add(water);
		itemList.add(chips);
		itemList.add(energyDrink);
		itemList.add(iceCream);
		itemList.add(meat);
		itemList.add(largeHP);
		itemList.add(smallHP);
		itemList.add(spacePills);
		itemList.add(shipPart);
		
		for (Item item: itemList) {
			assertEquals(itemStrings[itemList.indexOf(item)], item.getName());
			assertEquals(chances[itemList.indexOf(item)], item.getDropChance());
			assertEquals(prices[itemList.indexOf(item)], item.getPrice());
			assertEquals(1, item.getCount());
			item.addCount();
			assertEquals(2, item.getCount());
			item.deductCount();
			assertEquals(1, item.getCount());
			if (itemList.indexOf(item) < 6) assertEquals("Food", item.getType());
			else if (itemList.indexOf(item) < 9) assertEquals("Potion", item.getType());
			else assertEquals("Misc", item.getType());
		}
		
		inv.deductItem(bread);
		inv.deductItem(smallHP);
		inv.deductItem(shipPart);
		inv.deductItem(coin);
		assertEquals(0, inv.getPotions().get(0).getCount());
		assertEquals(0, inv.getFoods().get(0).getCount());
		assertEquals(0, inv.getMisc().get(0).getCount());
		
		inv.resetInv();
		assertEquals(0, inv.getPotions().size());
		assertEquals(0, inv.getFoods().size());
		assertEquals(0, inv.getMisc().size());
		assertEquals("0 coins", inv.getWallet());
	}

}
