package crewManagement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import crewAbilities.ActivateAbility;


/** Represents the Medic type of crew member.
 * @author Jason Smit
 * @author Ariel Evangelista
*/
public class Crew {
	
	/**
	 * List of all current crew members
	 */
	private ArrayList<CrewMember> crewMembers = new ArrayList<CrewMember>();
	
	/**
	 * The one and only one instance of crew
	 */
	private static Crew _session = null;
	
	private Crew() {
		
	}
	
	/**
	 * The unique instance of Crew class
	 * @return The instance of the Crew class
	 */
	public static Crew getInstance() {
		if(_session == null) {
			_session = new Crew();
		}
		return _session;
	}
	
	/**
	 * Creates and adds crew members to the crew array based off the users selected crew names and crew types.
	 * @param crewNames A List containing the JTextField's that hold the names for each crew memeber.
	 * @param crewTypes A List containing the JComboBox's that hold the types for each crew member.
	 * @param size The size of the crew
	 */
	public void createCrew(List<JTextField> crewNames, List<JComboBox<Object>> crewTypes, int size) {
		crewMembers.removeAll(crewMembers);
		for (int i = 0; i < size; i++) { 
		    String name = crewNames.get(i).getText(); // Get the name for each crew member
		    String type= (String) crewTypes.get(i).getSelectedItem(); // Get the type for each crew member
		    
		    // create crew member and add to crew array
		    switch(type) {
		    case "Captain":
		    	Captain captain = new Captain(name);
		    	this.addMember(captain);
		    	break;
		    case "Engineer":
		    	Engineer engineer = new Engineer(name);
		    	this.addMember(engineer);
		    	break;
		    case "Medic":
		    	Medic medic = new Medic(name);
		    	this.addMember(medic);
		    	break;
		    case "Scout":
		    	Scout scout = new Scout(name);
		    	this.addMember(scout);
		    	break;
		    case "Pilot":
		    	Pilot pilot = new Pilot(name);
		    	this.addMember(pilot);
		    	break;
		    case "Scientist":
		    	Scientist scientist = new Scientist(name);
		    	this.addMember(scientist);
		    	break;
		    }
		}
		
	}
	
	/**
	 * Adds member to the list of current crew members
	 * @param o The crew member to be added onto the list
	 */
	private void addMember(CrewMember o) {
		crewMembers.add(o);
	}
	
	/**
	 * Get the list of current crew members
	 * @return The list of current crew members
	 */
	public ArrayList<CrewMember> getCrew() {
		return crewMembers;
	}
	
	/**
	 * Will call resetMoves method for each crew member.
	 */
	public void resetCrewMoves () {
		for(CrewMember member: crewMembers) {
			member.resetMoves();
		}
	}
	
	/**
	 * Will apply certain effects after new day is called
	 * Hunger: Increases by 20 (max 100)
	 * 
	 * Infected: Decreases health by 30
	 * Hunger at 100%: Decreases health by 10
	 * Tiredness at 100%: Moves deducted by 1
	 */
	public void newDay() {
		for (CrewMember member: crewMembers) {
			if (member.getHealth() > 0) {
				member.resetMoves();
				
				new ActivateAbility(member);
				
				if (member.isInfected()) member.setHealth(member.getHealth() - 30);;
				if (member.getHunger() >= 100) member.setHealth(member.getHealth() - 10);
				if (member.getHealth() <= 0) {
					member.setHealth(0);
					member.setHunger(0);
					member.setTiredness(0);
					member.cureInfection();
					JOptionPane.showMessageDialog(null, member.getType()
							+ " " + member.getName()
							+ " died!");
				}
				
				member.setHunger(member.getHunger() + 20);
				if (member.getHunger() > 100) member.setHunger(100);
				
				if (member.getTiredness() >= 100) member.deductMove();
			}
		}
	}
	
	/**
	 * Returns the current number of crews
	 * @return Returns the size of crew
	 */
	public int size() {
		return crewMembers.size();
	}
	
	/**
	 * Returns the number of all actions remaining for the crew
	 * @return The total moves of all crew members
	 */
	public int getAllMoves() {
		int sum = 0;
		for (CrewMember crew: crewMembers) {
			if (crew.getHealth() > 0) sum += crew.getMoves();
		}
		return sum;
	}
	
	/**
	 * Returns the number of crew members alive
	 * @return The number of crew members still alive
	 */
	public int getAlive() {
		int alive = this.size();
		for (CrewMember crew: crewMembers) {
			if (crew.getHealth() == 0) alive -= 1;
		}
		return alive;
	}
}
