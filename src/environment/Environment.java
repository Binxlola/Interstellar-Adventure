package environment;

import java.util.ArrayList;
import java.util.Random;

/** Represents the Environment of the game
 * Contains all the planets and the current planet the player is into
 * @author Jason Smit
 * @author Ariel Evangelista
*/
public class Environment {
	
	// Disabled until Item Wheel is implemented
	//private ItemWheel itemWheel = ItemWheel.getInstance();
	private int selectedPlanet = -1;
	private ArrayList<Planet> planets = new ArrayList<Planet>();
	private String[] planetNames = {
			"Inater",
			"Cingaturn",
			"Bonnapus",
			"Chaphiri",
			"Gunov",
			"Diepra",
			"Thaharilia",
			"Drioliv",
			"Chiuq V645",
			"Grao X6S1",
			"Tolruiruta",
			"Xinrania",
			"Chidypso",
			"Yunnomia",
			"Cotov",
			"Geotov",
			"Lautania",
			"Gnikerus",
			"Bypso 68SD",
			"Nosie 7L8",
			"Codraruta",
			"Hankecury",
			"Dustriri",
			"Budriri",
			"Zulea",
			"Cemia",
			"Valatera",
			"Struxenus",
			"Guna G2I",
			"Gragua UO"
	};
	
	private static Environment _session = null;
	
	/**
	 * Private constructor so Environment can not be instantiated from the outside.
	 */
	private Environment() {
	}
	
	/**
	 * This checks if there is already an instance of the Environment, if not then one will be created.
	 * @return The instance of the Environment (can only ever have one.)
	 */
	public static Environment getInstance() {
		if(_session == null) {
			_session = new Environment();
		}
		return _session;
	}
	
	/* Disabled until Item Wheel is implemented
	public ItemWheel getWheel() {
		return this.itemWheel;
	}
	*/
	
	public void buildEnvironment(int gameDuration) {
		createPlanets(gameDuration);
	}
	
	private void createPlanets(int gameLength) {
		planets.removeAll(planets);
		Random rand = new Random();
		ArrayList<Integer> usedNames = new ArrayList<Integer>();
		
		for(int i = 0; i < (gameLength * 2); i++) {
			int nameIndex = rand.nextInt(planetNames.length - 1);
			while(usedNames.contains(nameIndex)) {
				nameIndex = rand.nextInt(planetNames.length - 1);
			}
			
			Planet temp = new Planet(planetNames[nameIndex]);
			planets.add(temp);
			usedNames.add(nameIndex);
			
			
		}
			
	}
	
	/**
	 * Returns the list of all the planets in the game
	 * @return The list of all the planets
	 */
	public ArrayList<Planet> getPlanets() {
		return planets;
	}
	
	/*
	 * Sets the index of selected planet to travel to
	 * @param Index of the planet to be selected
	 */
	public void selectPlanet(int i) {
		selectedPlanet = i;
	}
	
	/*
	 * Get the index of selected planet to travel to
	 * @return Returns the index of the planet the ship will travel to
	 */
	public int getSelectedPlanetIndex() {
		return selectedPlanet;
	}
	
	/*
	 * Get the selected Planet object to travel to
	 * @return Returns the selected planet object the ship will travel to
	 */
	public Planet getSelectedPlanet() {
		if (selectedPlanet == -1) {
			return null;
		} else {
			return planets.get(selectedPlanet);
		}
	}
}
