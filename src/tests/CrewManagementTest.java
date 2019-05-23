package tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import org.junit.jupiter.api.Test;

import crewManagement.Crew;
import crewManagement.CrewMember;

class CrewManagementTest {

	@Test
	void crewTest() {
		Crew crewInstance = Crew.getInstance();
		
		List<JTextField> crewNames = new ArrayList<JTextField>();
		List<JComboBox<Object>> crewTypes = new ArrayList<JComboBox<Object>>();
		
		String[] typeStrings = new String[] {"Captain", "Engineer", "Medic", "Scout", "Pilot", "Scientist"};
		
		for (int i = 0; i < 6; i++) {
			JTextField nameField = new JTextField("");
			nameField.setText(Integer.toString(i));
			crewNames.add(nameField);
			JComboBox<Object> comboBox = new JComboBox<Object>();
			comboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {typeStrings[i]}));
			crewTypes.add(comboBox);
		}
		
		crewInstance.createCrew(crewNames, crewTypes, 6);
		assertEquals(6, crewInstance.size());
		assertEquals(13, crewInstance.getAllMoves());
		assertEquals(6, crewInstance.getAlive());
		crewInstance.resetCrewMoves();
		assertEquals(13, crewInstance.getAllMoves());
		
		ArrayList<CrewMember> crewMembers = crewInstance.getCrew();
		
		for (CrewMember crew: crewMembers) {
			int name = crewMembers.indexOf(crew);
			crew.setHunger(100);
			crew.setTiredness(100);
			crew.setHealth(50);
			assertEquals(Integer.toString(name), crew.getName());
			assertEquals(typeStrings[crewMembers.indexOf(crew)], crew.getType());
			assertEquals(100, crew.getTiredness());
			assertEquals(100, crew.getHunger());
			assertEquals(50, crew.getHealth());
			
			crew.deductMove();
			if (crew.getType() == "Captain") assertEquals(2, crew.getMoves());
			else assertEquals(1, crew.getMoves());
			
			crew.setHealth(0);
			crew.resetMoves();
			assertEquals(0, crew.getMoves());
			
			crew.setInfection();
			assertEquals(true, crew.isInfected());
			crew.cureInfection();
			assertEquals(false, crew.isInfected());
			
			crew.setHealth(100);
			crew.addHealth(10);
			assertEquals(100, crew.getHealth());
			crew.resetMoves();
			crew.eat(100);
			if (crew.getType() == "Captain") assertEquals(2, crew.getMoves());
			else assertEquals(1, crew.getMoves());
			
			crew.resetMoves();
			crew.sleep();
			if (crew.getType() == "Captain") assertEquals(2, crew.getMoves());
			else assertEquals(1, crew.getMoves());
			
			crew.addMove();
			if (crew.getType() == "Captain") assertEquals(3, crew.getMoves());
			else assertEquals(2, crew.getMoves());
		}
	}

}
