package environment;

import java.util.Random;

import javax.swing.JOptionPane;

import crewManagement.SpaceShip;

public class AsteroidEvent {
	
	private boolean pilot;
	private SpaceShip spaceShip = SpaceShip.getInstance();
	
	public AsteroidEvent(boolean newPilot) {
		this.pilot = newPilot;
		System.out.println("IM CALLED");
		initialize();
	}
	
	/**
	 * Initializing the event with 50% chance of happening
	 */
	private void initialize() {
		double chance = new Random().nextDouble();
		if (chance < 0.5) {
			if (this.pilot) {
				JOptionPane.showMessageDialog(null, "Your ship passed through an asteroid belt!"
						+ "\nLuckily, an experienced Pilot was flying your ship"
						+ "\n   so the ship only took 20 damage!");
				spaceShip.deductShield(20);
			} else {
				JOptionPane.showMessageDialog(null, "Your ship passed through an asteroid belt!"
						+ "\n       Your ship took 40 damage!");
				spaceShip.deductShield(40);
			}
		}

	}
}
