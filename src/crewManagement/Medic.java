package crewManagement;

import java.util.Objects;

/** Represents the Medic type of crew member.
 * @author Jason Smit
 * @author Ariel Evangelista
*/
public class Medic extends CrewMember {
	private final String type = "Medic";
	private String name = "";
	private int memberMoves;
	private double memberHealth;
	private boolean infected = false;
	
	/**
	 * Sets the name of the current crew member.
	 * @param newName A String describing the desired name of the current crew member.
	 */
	public Medic(String newName) {
		name = newName;
		memberMoves = 2;
		memberHealth = 100;
	}
	
	/**
	 * Gets the type of Crew member the current member is.
	 * @return Will return a String representing the type of crew member.
	 */
	public String getType() {
		return this.type;
	}
	
	/**
	 * Gets the name of the current crew member.
	 */
	public String getName() {
		return this.name;
	}
	
	public double getHealth() {
		return this.memberHealth;
	}
	
	/** This Method is to set the Health of the crew member relative to the specialization. */
	public void setHealth(int health) {
			this.memberHealth = health;
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
	 * Deducts a move from the members current available moves.
	 */
	public void deductMove() {
		if((memberMoves - 1) >= 0) {
			memberMoves -= 1;
		}
	}
	
	/**
	 * Will set infected to true if current crew member is not already infected.
	 */
	public void setInfection() {
		if(!this.infected) {
			this.infected = true;
		}
	}

}
