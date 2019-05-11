package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import itemManagement.Inventory;
import items.LargeHP;
import items.ShipPart;
import items.SmallHP;

class InventoryTest {

	@Test
	void addItem() {
		Inventory inventory = Inventory.getInstance();
		ShipPart part = new ShipPart();
		LargeHP largeHP = new LargeHP();
		SmallHP smallHP = new SmallHP();
		
		// Check that items are not in the list.
		assertEquals("Item is not here", inventory.addItem(part));
		assertEquals("Item is not here", inventory.addItem(largeHP));
		assertEquals("Item is not here", inventory.addItem(smallHP));
		
		// Check that after last tests the items were added.
		assertEquals("Item is here", inventory.addItem(part));
		assertEquals("Item is here", inventory.addItem(largeHP));
		assertEquals("Item is here", inventory.addItem(smallHP));
		
		//Double check that the size of the inventory list is as expected.
		assertEquals(3, inventory.getInventory().size());
		//fail("Not yet implemented");
	}

}
