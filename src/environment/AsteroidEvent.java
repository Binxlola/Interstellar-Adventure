package environment;

import java.util.Random;

import javax.swing.JOptionPane;

import crewManagement.SpaceShip;
import mainGui.MainScreen;
import management.AddGameScore;
import management.GameManager;

/**
 * This class contains what will happen when the player
 * encounters an Asteroid Belt. It will damage the ship
 * by 40. If a pilot is flying the ship, it will damage
 * the ship by 20 instead.
 * @author Ariel Evangelista
 *
 */
public class AsteroidEvent {
	
	private boolean pilot;
	private MainScreen window;
	private SpaceShip spaceShip = SpaceShip.getInstance();
	private GameManager gameManager = GameManager.getInstance();
	
	public AsteroidEvent(boolean newPilot, MainScreen incomingWindow) {
		this.pilot = newPilot;
		this.window = incomingWindow;
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
				int scoreRoll = (int) (200 * new Random().nextDouble());
				new AddGameScore(scoreRoll);
			} else {
				JOptionPane.showMessageDialog(null, "Your ship passed through an asteroid belt!"
						+ "\n       Your ship took 40 damage!");
				spaceShip.deductShield(40);
			}
		}
		
		if (spaceShip.getShipShield() == 0) {
			gameManager.endGame(false, "Your ship was destroyed!");
			window.changeContent("GameOver");
		}

	}
}
