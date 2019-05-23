package crewManagement;

/** Represents the abstract class of crew members.
 * @author Jason Smit
 * @author Ariel Evangelista
*/
public abstract class CrewMember {
	
	abstract public String getName();
	
	abstract public void setHealth(int health);
	
	abstract public void addHealth(int health);
	
	abstract public int getHealth();
	
	abstract public String getType();
	
	abstract public int getMoves();
	
	abstract public void addMove();
	
	abstract public void deductMove();
	
	abstract public void resetMoves();
	
	abstract public void setInfection();
	
	abstract public int getHunger();
	
	abstract public int getTiredness();
	
	abstract public void cureInfection();
	
	abstract public boolean isInfected();
	
	abstract public void sleep();
	
	abstract public void eat(int amount);

	abstract public void setTiredness(int amount);
	
	abstract public void setHunger(int amount);
}
