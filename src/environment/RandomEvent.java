package environment;

import java.util.Random;

import javax.swing.JOptionPane;

import crewManagement.Crew;
import crewManagement.SpaceShip;
import itemManagement.Inventory;

/**
 * Initializing random event
 * 40% chance for each event: {Space Plague, Alien Pirates}
 * @author Ariel Evangelista
 */
public class RandomEvent {
	
	public RandomEvent() {
		double chance = new Random().nextDouble();
		if (chance < 0.40) {
			new SpacePlague();
		} else if (chance < 0.80) {
			new AlienPirates();
		}
	}
}
