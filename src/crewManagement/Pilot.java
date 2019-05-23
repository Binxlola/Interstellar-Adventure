package crewManagement;

/** Represents the Pilot type of crew member.
 * @author Jason Smit
 * @author Ariel Evangelista
*/
public class Pilot extends CrewMember {
	
	/**
	 * Type of the Crew Member
	 */
	private final String type = "Pilot";
	
	/**
	 * Name of the Crew Member
	 */
	private String name = "";
	
	/**
	 * Remaining Moves of the crew member
	 */
	private int memberMoves;
	
	/**
	 * Remaining Health of the crew member
	 */
	private int memberHealth;
	
	/**
	 * Current health state of the crew member
	 */
	private boolean infected = false;
	
	/**
	 * Current hunger of the crew member
	 */
	private int memberHunger;
	
	/**
	 * Current tiredness of the crew member
	 */
	private int memberTiredness;
	
	/**
	 * Sets the name of the current crew member.
	 * @param newName A String describing the desired name of the current crew member.
	 */
	public Pilot(String newName) {
		name = newName;
		memberMoves = 2;
		memberHealth = 100;
		memberHunger = 0;
		memberTiredness = 0;
	}
	
	/**
	 * Gets the type of Crew member the current member is.
	 * @return Will return a String representing the type of crew member.
	 */
	public String getType() {
		return this.type;
	}
	
	public String getName() {
		return this.name;
	}
	
	/** This Method is to set the Health of the crew member relative to the specialization. */
	public void setHealth(int health) {
			this.memberHealth = health;
	}
	
	/**
	 * Returns the current health of this crew member
	 */
	public int getHealth() {
		return this.memberHealth;
	}
	
	/**
	 * This method will reload the crew members moves.
	 */
	public void resetMoves() {
		if (getHealth() > 0) this.memberMoves = 2;
		else this.memberMoves = 0;
	}
	
	/**
	 * Will add one move count for the crew member.
	 */
	public void addMove() {
		this.memberMoves += 1;
	}
	
	/**
	 * This method will get and return this crew members current amount of moves available.
	 * @return An integer describing the member available moves.
	 */
	public int getMoves() {
		if (getHealth() > 0) return memberMoves;
		else return 0;
	}
	
	/**
	 * Will set infected to true if current crew member is not already infected.
	 */
	public void setInfection() {
		if(!this.infected) {
			this.infected = true;
		}
	}
	
	/**
	 * Deducts a move from the members current available moves.
	 * Each move will increase tiredness by 15
	 */
	public void deductMove() {
		if((memberMoves - 1) >= 0) {
			memberMoves -= 1;
			memberTiredness += 15;
			if (memberTiredness >= 100) memberTiredness = 100;
		}
	}
	
	/**
	 * Get the current hunger rate of this crew member
	 * @return The current hunger rate of this crew member
	 */
	public int getHunger() {
		return this.memberHunger;
	}
	
	/*
	 * Get the current tiredness rate of this crew member
	 * @return The current tiredness rate of this crew member
	 */
	public int getTiredness() {
		return this.memberTiredness;
	}
	
	/**
	 * Will set infected to false if current crew member is infected.
	 */
	public void cureInfection() {
		if(this.infected) {
			this.infected = false;
		}
	}
	
	/**
	 * Returns true if the crew member is currently infected
	 */
	public boolean isInfected() {
		return this.infected;
	}
	
	/**
	 * Crew Member sleeps becoming less tired by 80 units
	 */
	public void sleep() {
		if((memberMoves - 1) >= 0) {
			memberMoves -= 1;
			memberTiredness -= 100;
			if (memberTiredness < 0) memberTiredness = 0;
		}
	}
	
	/**
	 * Crew Member eats becoming less hungry by certain amount
	 * @param amount The unit to be deducted to this member's hungriness
	 */
	public void eat(int amount) {
		memberHunger -= amount;
		memberMoves -= 1;
		if (memberHunger < 0) memberHunger = 0;
	}
	
	/**
	 * Set the tiredness of this crew member to certain amount
	 * @param amount The number of amount to be set
	 */
	public void setTiredness(int amount) {
		this.memberTiredness = amount;
	}
	
	/**
	 * Set the hunger of this crew member to certain amount
	 * @param amount The number of amount to be set
	 */
	public void setHunger(int amount) {
		this.memberHunger = amount;
	}
}
