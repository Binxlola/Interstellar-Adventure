package crewManagement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JTextField;






/** Represents the Medic type of crew member.
 * @author Jason Smit
 * @author Ariel Evangelista
*/
public class Crew {
	
	private ArrayList<CrewMember> crewMembers = new ArrayList<CrewMember>();
	private static Crew _session = null;
	
	private Crew() {
		
	}
	
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
	 */
	public void createCrew(List<JTextField> crewNames, List<JComboBox<Object>> crewTypes, int size) {
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
	private void addMember(CrewMember o) {
		crewMembers.add(o);
	}
	
	public ArrayList<CrewMember> getCrew() {
		return crewMembers;
	}
	
	/**
	 * A method to validate if a given crew member has enough moves left to perform an action.
	 * @return A boolean describing if the given crew member can perform an action or not.
	 */
	public static boolean allowedAction(CrewMember member) {
		if(member.getMoves() < 1) {
			return false;
		}
		else {
			return true;
		}
	}
	
	/**
	 * Presents the list of crew member to the player.
	 */
	public void presentCrew() {
		System.out.println(); // Empty line to make content more readable
		
		int currentPosition = 1;
		for (CrewMember member: crewMembers) {
			String temp = String.format("%s. %s", currentPosition, member);
			System.out.println(temp);
			currentPosition ++;
		}
		
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
	 * Returns the current number of crews
	 */
	public int size() {
		return crewMembers.size();
	}
	
	/**
	 * Returns the number of all actions remaining for the crew
	 */
	public int getAllMoves() {
		int sum = 0;
		for (CrewMember crew: crewMembers) {
			sum += crew.getMoves();
		}
		return sum;
	}

}
