package crewManagement;

import java.util.Objects;

/** Represents the Engineer type of crew member.
 * @author Jason Smit
 * @author Ariel Evangelista
*/
public class Engineer extends CrewMember {
	
	private final String type = "Engineer";
	private String name = "";
	private int memberMoves;
	private double memberHealth;
	private boolean infected = false;
	private double memberHunger;
	private double memberTiredness;
	
	public Engineer(String newName) {
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
	public double getHealth() {
		return this.memberHealth;
	}
	
	/**
	 * This method will reload the crew members moves.
	 */
	public void resetMoves() {
		this.memberMoves = 2;
	}
	
	/**
	 * Will add one move count for the crew member.
	 */
	public void addMove() {
		this.memberMoves += 1;
	}
	
	/**
	 * Overrides java.lang.Object.toString to give a descriptive string representation of the object.
	 * @return Will return a String describing the current object.
	 */
	@Override
	public String toString() {
		String temp = String.format("%s has %s moves left and %s current health.", name, memberMoves, memberHealth);
		return temp;
	}
	
	/**
	 * Overrides java.lang.Object.equals to compare if the given object is the same as the current object.
	 * @return Will return a boolean value dependent on if the two objects are the same or not. 
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj == this) {
			return true;
		}
		if(obj == null) {
			return false;
		}
		if (!getClass().equals(obj.getClass())) {
	        return false;
	    }
		CrewMember otherObj = (CrewMember) obj;
	    return Objects.equals(name, otherObj.getName()) && Objects.equals(memberMoves, otherObj.getMoves()) && Objects.equals(memberHealth, otherObj.getHealth());
	}
	
	/**
	 * This method will get and return this crew members current amount of moves available.
	 * @return An integer describing the member available moves.
	 */
	public int getMoves() {
		return memberMoves;
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
	 * Each move will increase tiredness by 10
	 */
	public void deductMove() {
		if((memberMoves - 1) >= 0) {
			memberMoves -= 1;
			memberTiredness += 10;
			if (memberTiredness >= 100) memberTiredness = 100;
		}
	}
	
	/**
	 * Get the current hunger rate of this crew member
	 * @return The current hunger rate of this crew member
	 */
	public double getHunger() {
		return this.memberHunger;
	}
	
	/*
	 * Get the current tiredness rate of this crew member
	 * @return The current tiredness rate of this crew member
	 */
	public double getTiredness() {
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
	 * Will apply certain effects after new day is called
	 * Hunger: Increases by 20 (max 100)
	 * 
	 * Infected: Decreases health by 20
	 * Hunger at 100%: Decreases health by 10
	 * Tiredness at 100%: Maximum moves capped at 1
	 */
	public void newDay() {
		if (memberHealth > 0) {
			if(isInfected()) memberHealth -= 20;
			if(memberHunger >= 100) memberHealth -= 10;
			if (memberHealth < 0) setHealth(0);
			
			memberHunger += 20;
			if (memberHunger > 100) memberHunger = 100;
			if (memberTiredness > 100) memberTiredness = 100;
			
			resetMoves();
			
			if(memberTiredness >= 100) deductMove();
		}
	}
	
	/**
	 * Crew Member sleeps becoming less tired by 80 units
	 */
	public void sleep() {
		if((memberMoves - 1) >= 0) {
			memberMoves -= 1;
			memberTiredness -= 80;
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
}
