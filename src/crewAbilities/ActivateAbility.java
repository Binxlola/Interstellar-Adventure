package crewAbilities;

import crewManagement.CrewMember;

/**
 * Further filters the type of crew member
 * and activates their respective abilities
 * @author Ariel Evangelista
 *
 */
public class ActivateAbility {

	/**
	 * Detect the type of the crew activating its ability
	 * @param crew The crew member activating its ability
	 */
	public ActivateAbility(CrewMember crew) {
		String crewType = crew.getType();
		if (crew.getHealth() > 0) {
			switch(crewType) {
			case "Medic":
				new AbilityMedic(crew);
				break;
			case "Scientist":
				new AbilityScientist(crew);
				break;
			}
		}
	}
}
