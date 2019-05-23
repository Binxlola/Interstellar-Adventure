package crewAbilities;

import javax.swing.JOptionPane;

import crewManagement.Crew;
import crewManagement.CrewMember;

/**
 * Ability Medic:
 * Heals the first one in the crew that has
 * health below 50 except the medic itself
 * @author Ariel Evangelista
 *
 */
public class AbilityMedic {
	
	/**
	 * The Crew instance of Crew class
	 */
	Crew crew = Crew.getInstance();

	/**
	 * Selects the first member other than the medic itself
	 * who is below 50 health and heals them for 10 health
	 * @param medic
	 */
	public AbilityMedic(CrewMember medic) {
		boolean healed = false;
		for (CrewMember crew: crew.getCrew()) {
			if (crew.getHealth() < 50 && crew.getHealth() > 0 && !healed && crew != medic) {
				crew.setHealth(crew.getHealth() + 10);
				healed = true;
				JOptionPane.showMessageDialog(null, medic.getType()
						+ " " + medic.getName()
						+ " healed " + crew.getType() + " " + crew.getName() + "for 10 health!");
			}
		}
	}
}
