package environment;

import java.util.ArrayList;
import java.util.Random;

/** Represents the Medic type of crew member.
 * @author Jason Smit
 * @author Ariel Evangelista
*/
public class Environment {
	
	// Disabled until Item Wheel is implemented
	//private ItemWheel itemWheel = ItemWheel.getInstance();
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
	
	public void presentPlanets() {
		System.out.println(); // Empty line to make content more readable
		
		int currentPosition = 1;
		for (Planet planet: planets) {
			String temp = String.format("%s. %s", currentPosition, planet);
			System.out.println(temp);
			currentPosition ++;
		}
		
	}
	
	public ArrayList<Planet> getPlanets() {
		return planets;
	}
	/* Will be re-implemented to fit the GUI
	public Planet selectPlanet() {
		int selection = Utilities.getInputInt(1, planets.size(), "The selected planet is invalid");
		Planet planet = planets.get(selection - 1);
		return planet;
	}
	*/
}