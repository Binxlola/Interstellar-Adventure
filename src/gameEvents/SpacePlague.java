package gameEvents;

import java.util.Random;

import javax.swing.JOptionPane;

import crewManagement.Crew;

/**
 * Space Plague event has 33% chance to be picked by Random Event handler
 * A random crew member may be picked out to be infected
 * All crew members has an equal chance to be infected
 * @author Ariel Evangelista
 */
public class SpacePlague {
	
	/**
	 * The one and only one instance of the Crew class
	 */
	Crew crew = Crew.getInstance();

	/**
	 * Constructor for the Space Plague calling initialize method
	 */
	public SpacePlague() {
		initialize();
	}
	
	/**
	 * Initializes the Space Plague Event and infects an unlucky crew member
	 * with all crew member having equal chances of getting infected
	 */
	private void initialize() {
		
		// There will be a 1 / size of crew chance for each crew to get infected
		double total = crew.size();
		boolean infected = false;
		
		double random = new Random().nextDouble();
		
		for (int i = 0; i < crew.size(); i++) {
			if ((random < (i+1)/total) && !infected && !crew.getCrew().get(i).isInfected())  {
				if (crew.getCrew().get(i).getHealth() > 0) {
					infected = true;
					crew.getCrew().get(i).setInfection();
					JOptionPane.showMessageDialog(null, "There is an epidemic of Space Plague!"
							+ "\n" + crew.getCrew().get(i).getType() + " " + crew.getCrew().get(i).getName() + " was infected!");
				}
			}
		}
	}
}