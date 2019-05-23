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
	
	Crew crew = Crew.getInstance();

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
