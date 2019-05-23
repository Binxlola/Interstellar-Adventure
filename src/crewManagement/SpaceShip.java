package crewManagement;

import javax.swing.Icon;

/** Represents the Medic type of crew member.
 * @author Jason Smit
 * @author Ariel Evangelista
*/
public class SpaceShip {
	
	/**
	 * The one and only one instance of SpaceShip class
	 */
	private static SpaceShip _session = null;
	
	/**
	 * The name of the ship
	 */
	private String shipName;
	
	/**
	 * The current shield health of the ship
	 */
	private int shipShield;
	
	/**
	 * The icon of the ship
	 */
	private Icon shipIcon;
	
	private SpaceShip() {
		
	}
	
	/**
	 * Get the one and only one instance of SpaceShip class
	 * @return The active SpaceShip class
	 */
	public static SpaceShip getInstance() {
		if(_session == null) {
			_session = new SpaceShip();
		}
		return _session;
	}
	
	/**
	 * Initializes ships statistics
	 * @param name The name of the ship
	 * @param shipIcon The icon of the ship
	 */
	public void initializeShip(String name, Icon shipIcon) {
		this.shipName = name;
		this.shipShield = 100;
		this.shipIcon = shipIcon;
	}
	
	/**
	 * Get the current ship name
	 * @return The current ship name
	 */
	public String getShipName() {
		return this.shipName;
	}
	
	/**
	 * Get the current ship shield
	 * @return The current ship shield
	 */
	public int getShipShield() {
		return this.shipShield;
	}
	
	/**
	 * Get the icon for this ship
	 * @return The icon for this ship
	 */
	public Icon getShipIcon() {
		return this.shipIcon;
	}
	
	/**
	 * Add shield to the current ship shield by certain amount
	 * @param amount
	 */
	public void addShield(int amount) {
		this.shipShield += amount;
		if (this.shipShield > 100) this.shipShield = 100;
	}
	
	/**
	 * Deduct shield to the current ship shield by certain amount
	 * @param amount
	 */
	public void deductShield(int amount) {
		this.shipShield -= amount;
		if (this.shipShield < 0) this.shipShield = 0;
	}
}
