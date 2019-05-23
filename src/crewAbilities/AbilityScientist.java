package crewAbilities;

import java.util.Random;

import javax.swing.JOptionPane;

import crewManagement.CrewMember;
import crewManagement.SpaceShip;
import itemManagement.Inventory;
import itemManagement.Item;
import items.LargeHP;
import items.SmallHP;
import items.SpacePills;

/**
 * Ability class that handles Scientist's abilities
 * @author Ariel Evangelista
 */
public class AbilityScientist {
	
	private CrewMember scientist;
	private Inventory inv = Inventory.getInstance();
	private SpaceShip ship = SpaceShip.getInstance();

	public AbilityScientist(CrewMember crew) {
		scientist = crew;
		double chance = new Random().nextDouble();
		if (chance < 0.20) extraMove();
		else if (chance < 0.30) loseHealth();
		else if (chance < 0.40) gainHealth();
		else if (chance < 0.50) getTired();
		else if (chance < 0.60) getHungry();
		else if (chance < 0.70) synthesize();
		else if (chance < 0.80) gainShipShield();
	}
	
	/**
	 * The scientist gains an extra move
	 */
	private void extraMove() {
		scientist.addMove();
		JOptionPane.showMessageDialog(null, scientist.getType()
				+ " " + scientist.getName()
				+ " gained an extra move through experiments!");
	}
	
	/**
	 * The scientist loses health
	 */
	private void loseHealth() {
		scientist.setHealth(scientist.getHealth() - 10);
		JOptionPane.showMessageDialog(null, scientist.getType()
				+ " " + scientist.getName()
				+ " lost 10 health because of a failed experiment!");
	}
	
	/**
	 * The scientist gains health
	 */
	private void gainHealth() {
		scientist.setHealth(scientist.getHealth() + 10);
		JOptionPane.showMessageDialog(null, scientist.getType()
				+ " " + scientist.getName()
				+ " gained 10 health through experiments!");
	}
	
	/**
	 * The scientist gets tired
	 */
	private void getTired() {
		scientist.setTiredness(scientist.getTiredness() + 10);
		JOptionPane.showMessageDialog(null, scientist.getType()
				+ " " + scientist.getName()
				+ " got 10 tiredness because of sleepless night!");
	}
	
	/**
	 * The scientist gets hungry
	 */
	private void getHungry() {
		scientist.setHunger(scientist.getHunger() + 10);
		JOptionPane.showMessageDialog(null, scientist.getType()
				+ " " + scientist.getName()
				+ " got 10 hunger because of skipping meals!");
	}
	
	/**
	 * The scientist developed some potions
	 */
	private void synthesize() {
		double chance = new Random().nextDouble();
		Item item;
		if (chance < 0.40) item = new LargeHP();
		else if (chance < 0.80) item = new SmallHP();
		else item = new SpacePills();
		inv.addItem(item);
		JOptionPane.showMessageDialog(null, scientist.getType()
				+ " " + scientist.getName()
				+ " synthesized " + item.getName() + "!");
	}
	
	/**
	 * The scientist improves the ships shield
	 */
	private void gainShipShield() {
		ship.addShield(20);
		JOptionPane.showMessageDialog(null, scientist.getType()
				+ " " + scientist.getName()
				+ " improved the ship's shield and gained 20 more shields!");
	}
}
