package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import environment.Environment;

class EnvironmentTest {

	@Test
	void environmentTest() {
		Environment env = Environment.getInstance();
		
		env.buildEnvironment(3);
		
		assertEquals(6, env.getPlanets().size());
		assertEquals(-1, env.getSelectedPlanetIndex());
		env.selectPlanet(1);
		assertEquals(1, env.getSelectedPlanetIndex());
		assertEquals(env.getSelectedPlanet(), env.getPlanets().get(1));
		
	}

}
