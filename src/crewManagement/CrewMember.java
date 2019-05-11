package crewManagement;

/** Represents the Medic type of crew member.
 * @author Jason Smit
 * @author Ariel Evangelista
*/
public abstract class CrewMember {
	
	abstract public String getName();
	
	abstract public void setHealth(int health);
	
	abstract public double getHealth();
	
	abstract public String getType();
	
	@Override
	abstract public String toString();
	
	@Override
	abstract public boolean equals(Object obj);
	
	abstract public int getMoves();
	
	abstract public void addMove();
	
	abstract public void deductMove();
	
	abstract public void resetMoves();
	
	abstract public void setInfection();

}