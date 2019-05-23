package gameEvents;

import java.util.Random;

/**
 * Initializing random event
 * 40% chance for each event: {Space Plague, Alien Pirates}
 * @author Ariel Evangelista
 */
public class RandomEvent {
	
	/**
	 * Rolls a pseudo-random chance of getting an event on the start of the day
	 */
	public RandomEvent() {
		double chance = new Random().nextDouble();
		if (chance < 0.40) {
			new SpacePlague();
		} else if (chance < 0.80) {
			new AlienPirates();
		}
	}
}
