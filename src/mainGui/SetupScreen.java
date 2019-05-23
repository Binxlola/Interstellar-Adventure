package mainGui;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import crewManagement.Crew;
import management.GameManager;

/**
 * Represents and application window that will act as the main entry point to the game, where a user can set the game parameters when starting a new game.
 * User may also load a previously saved game from this setup window.
 * @author Jason Smit
 * @author Ariel Evangelista
 * @version 1.0, May 2019.
 *
 */
public class SetupScreen {
	
	/**
	 * The initial window the player will see
	 */
	private JFrame frame;
	
	/**
	 * The textbox of ship name
	 */
	private JTextField shipNameFld;
	
	/**
	 * The size of crew members
	 */
	private int crewSize;
	
	/**
	 * The duration of the game in days
	 */
	private int gameDuration;
	
	/**
	 * The managing GUI manager
	 */
	private GuiManager manager;
	
	/**
	 * The icon for the ship
	 */
	private static Icon shipIcon;
	
	/**
	 * The boolean if a ship icon was selected
	 */
	private boolean iconSelected = false;
	
	/**
	 * List of text box containing the textbox of crew name
	 */
	private List<JTextField> crewNames = new ArrayList<JTextField>();
	
	/**
	 * List of combo box containing the types of crew
	 */
	private List<JComboBox<Object>> crewTypes = new ArrayList<JComboBox<Object>>();
	
	/**
	 * List of labels containing the labels of crew numbers
	 */
	private List<JLabel> crewNumLbl = new ArrayList<JLabel>();
	
	/**
	 * List of labels containing the labels of crew names
	 */
	private List<JLabel> crewNamesLbl = new ArrayList<JLabel>();
	
	/**
	 * List of labels containing the labels of crew types
	 */
	private List<JLabel> crewTypesLbl = new ArrayList<JLabel>();

	/**
	 * Initialize the setup screen
	 * @param incomingManager The GUI manager
	 */
	public SetupScreen(GuiManager incomingManager) {
		initialize();
		this.manager = incomingManager;
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Interstellar Adventure");
		frame.setBounds(100, 100, 1000, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		// Create a JPanel that will act as a card stack / Also the first card of the deck, where player starts new game.
		JPanel setup = new JPanel();
		setup.setBounds(0, 0, 994, 571);
		frame.getContentPane().add(setup);
		setup.setLayout(new CardLayout(0, 0));
		
		// Create setup1 card that will be added to the setup card stack
		JPanel setup1 = new JPanel();
		setup.add(setup1, "name_621206693201140");
		
		// Create new game button and add event handler
		JButton newGameBtn = new JButton("New Game");
		newGameBtn.setBounds(200, 500, 140, 30);
		newGameBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)(setup.getLayout());
		        cl.show(setup, "name_621220876675124");
			}
		});
		setup1.setLayout(null);
		setup1.add(newGameBtn);
		
		// Create How to play button
		JButton howToPlayBtn = new JButton("How to Play");
		howToPlayBtn.setBounds(50, 500, 140, 30);
		howToPlayBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "\nA. How to win\r\n" + 
						"		i.   Find all the missing Ship Parts within a given number of days\r\n" + 
						"\r\n" + 
						"	B. How to lose\r\n" + 
						"		i.   Reach the end of the given days with missing Ship Parts\r\n" + 
						"		ii.  Let all the crew members die\r\n" + 
						"		iii. Let your ship be destroyed\r\n" + 
						"\r\n" + 
						"	C. Game Setup\r\n" + 
						"		i.   You can pick the duration of the game between 3 to 10 days\r\n" + 
						"		ii.  You can pick the number of crew between 2 to 4 members\r\n" + 
						"		iii. You need to pick a ship name, ship icon, crew name and types for your team\r\n" + 
						"\r\n" + 
						"	D. Abilities\r\n" + 
						"		i.   Captain   - the leader of the team gets an extra move each day (3 moves)\r\n" + 
						"		ii.  Engineer  - the one who can repair the ship  for 20 more efficiently than anyone else\r\n" + 
						"		iii. Medic     - heals (10hp) a person who is below 50 health each day.\r\n" + 
						"		iv.  Pilot     - the ace of the team, if you let him fly, he avoid rocks in the sky\r\n" + 
						"		v.   Scientist - the madman who constantly do bizzare experiments each day\r\n" + 
						"		vi.  Scout     - the pathfinder, scavenger, he can get more for searching!\r\n");
				JOptionPane.showMessageDialog(null, "	E. Random Events\r\n" + 
						"		i.   Asteroid Belt - There is a chance of passing through an asteroid belth when\r\n" + 
						"			travelling to another planet\r\n" + 
						"		ii.  Alien Pirates - Each day there is a chance of some Alien Pirates boarding your ship\r\n" + 
						"			stealing your chips!\r\n" + 
						"		iii. Space Plague - A space plague that constantly infects the universe, there is no\r\n" + 
						"			vaccine available for this but Space Pills does the job\r\n" + 
						"\r\n" + 
						"	F. Items\r\n" + 
						"		i.    Bread: -30 Hunger\r\n" + 
						"		ii.   Chips: -10 Hunger\r\n" + 
						"		iii.  Meat: -50 Hunger\r\n" + 
						"		iv.   Ice Cream: -40 Hunger\r\n" + 
						"		v.    Water: - 15 Hunger\r\n" + 
						"		vi.   Energy Drink: +1 Move\r\n" + 
						"		vii.  Small HP: +40 Health\r\n" + 
						"		viii. Large HP: +70 Health\r\n" + 
						"		ix.   Space Pills: Cures Space Plagues\n\n");
			}
		});
		setup1.add(howToPlayBtn);
		
		// Create a label field that will act as an image holder for the game logo
		JLabel gameLogo = new JLabel("");
		gameLogo.setIcon(new ImageIcon(SetupScreen.class.getResource("/images/game_logo.png")));
		gameLogo.setBounds(0, 0, 984, 348);
		setup1.add(gameLogo);
		
		// Create setup3 before setup2's Next Button creation
		JPanel setup3 = new JPanel();
		
		// ======Window 2: Game Parameters======
		
		// Create setup2 card which will be added to the setup card stack
		JPanel setup2 = new JPanel();
		setup.add(setup2, "name_621220876675124");
		
		JLabel gameSetupLbl = new JLabel("GAME SETUP");
		gameSetupLbl.setFont(new Font("Distant Galaxy", Font.PLAIN, 24));
		gameSetupLbl.setBounds(42, 33, 600, 40);
		setup2.add(gameSetupLbl);
		
		// Create back button for Window 2
		JButton setup2Back = new JButton("Back");
		setup2Back.setBounds(50, 500, 140, 30);
		setup2Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)(setup.getLayout());
		        cl.show(setup, "name_621206693201140");
			}
		});
		setup2.setLayout(null);
		setup2.add(setup2Back);
		
		
		// Ship Name setup
		JLabel shipNameLbl = new JLabel("Ship Name:");
		shipNameLbl.setFont(new Font("Rockwell", Font.PLAIN, 14));
		shipNameLbl.setBounds(50, 170, 95, 20);	
		setup2.add(shipNameLbl);
		
		shipNameFld = new JTextField();
		shipNameFld.setBounds(145, 170, 200, 30);
		setup2.add(shipNameFld);
		shipNameFld.setColumns(10);
		
		// Game Length setup
		JLabel gameLengthLbl = new JLabel("Game Length:");
		gameLengthLbl.setFont(new Font("Rockwell", Font.PLAIN, 14));
		gameLengthLbl.setBounds(45, 228, 150, 20);
		setup2.add(gameLengthLbl);
		
		JLabel daysLbl = new JLabel("(DAYS)");
		daysLbl.setFont(new Font("Rockwell", Font.PLAIN, 14));
		daysLbl.setBounds(75, 248, 150, 20);
		setup2.add(daysLbl);
		
		JSlider gameLengthSldr = new JSlider();
		gameLengthSldr.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider) e.getSource();
				gameDuration = source.getValue();
				
			}
		});
		gameLengthSldr.setSnapToTicks(true);
		gameLengthSldr.setPaintLabels(true);
		gameLengthSldr.setMajorTickSpacing(1);
		gameLengthSldr.setMinimum(3);
		gameLengthSldr.setMaximum(10);
		gameLengthSldr.setValue(3);
		gameLengthSldr.setBounds(145, 230, 200, 40);
		setup2.add(gameLengthSldr);

		// Crew Size setup
		JLabel crewSizeLbl = new JLabel("Crew Size:");
		crewSizeLbl.setFont(new Font("Rockwell", Font.PLAIN, 14));
		crewSizeLbl.setBounds(50, 285, 95, 30);
		setup2.add(crewSizeLbl);
		
		JSlider crewSizeSldr = new JSlider();
		crewSizeSldr.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider) e.getSource();
				crewSize = source.getValue();
				
			}
		});
		crewSizeSldr.setSnapToTicks(true);
		crewSizeSldr.setMinimum(2);
		crewSizeSldr.setMaximum(4);
		crewSizeSldr.setValue(1);
		crewSizeSldr.setPaintLabels(true);
		crewSizeSldr.setMajorTickSpacing(1);
		crewSizeSldr.setBounds(145, 287, 200, 40);
		setup2.add(crewSizeSldr);
		
		// ======Ship Icons======
		JLabel selectShipLbl = new JLabel("Ship Icons");
		selectShipLbl.setFont(new Font("Unispace", Font.PLAIN, 14));
		selectShipLbl.setBounds(497, 105, 100, 20);
		setup2.add(selectShipLbl);
		
		// The selected icon button, displays to user what ship icon will be saved.
		JButton testBtn = new JButton("");
		testBtn.setBounds(210, 90, 50, 50);
		setup2.add(testBtn);
		
		// Adding the ship icons as buttons
		JButton ship1Btn = new JButton(""); // Ship 1
		ship1Btn.addActionListener(new SelectedIconListener(setup2, 210, 90));
		ship1Btn.setIcon(new ImageIcon(SetupScreen.class.getResource("/images/ship1.png")));
		ship1Btn.setBounds(450, 140, 50, 50);
		addIconChecker(ship1Btn);
		setup2.add(ship1Btn);
		
		JButton ship2Btn = new JButton(""); // Ship 2
		ship2Btn.addActionListener(new SelectedIconListener(setup2, 210, 90));
		ship2Btn.setIcon(new ImageIcon(SetupScreen.class.getResource("/images/ship2.png")));
		ship2Btn.setBounds(520, 140, 50, 50);
		addIconChecker(ship2Btn);
		setup2.add(ship2Btn);
		
		JButton ship3Btn = new JButton(""); // Ship 3
		ship3Btn.addActionListener(new SelectedIconListener(setup2, 210, 90));
		ship3Btn.setIcon(new ImageIcon(SetupScreen.class.getResource("/images/ship3.png")));
		ship3Btn.setBounds(590, 140, 50, 50);
		addIconChecker(ship3Btn);
		setup2.add(ship3Btn);
		
		JButton ship4Btn = new JButton(""); // Ship 4
		ship4Btn.addActionListener(new SelectedIconListener(setup2, 210, 90));
		ship4Btn.setIcon(new ImageIcon(SetupScreen.class.getResource("/images/ship4.png")));
		ship4Btn.setBounds(450, 200, 50, 50);
		addIconChecker(ship4Btn);
		setup2.add(ship4Btn);
		
		JButton ship5Btn = new JButton(""); // Ship 5
		ship5Btn.addActionListener(new SelectedIconListener(setup2, 210, 90));
		ship5Btn.setIcon(new ImageIcon(SetupScreen.class.getResource("/images/ship5.png")));
		ship5Btn.setBounds(520, 200, 50, 50);
		addIconChecker(ship5Btn);
		setup2.add(ship5Btn);
		
		JButton ship6Btn = new JButton(""); // Ship 6
		ship6Btn.addActionListener(new SelectedIconListener(setup2, 210, 90));
		ship6Btn.setIcon(new ImageIcon(SetupScreen.class.getResource("/images/ship6.png")));
		ship6Btn.setBounds(590, 200, 50, 50);
		addIconChecker(ship6Btn);
		setup2.add(ship6Btn);
		
		JButton ship7Btn = new JButton(""); // Ship 7
		ship7Btn.addActionListener(new SelectedIconListener(setup2, 210, 90));
		ship7Btn.setIcon(new ImageIcon(SetupScreen.class.getResource("/images/ship7.png")));
		ship7Btn.setBounds(450, 260, 50, 50);
		addIconChecker(ship7Btn);
		setup2.add(ship7Btn);
		
		JButton ship8Btn = new JButton(""); // Ship 8
		ship8Btn.addActionListener(new SelectedIconListener(setup2, 210, 90));
		ship8Btn.setIcon(new ImageIcon(SetupScreen.class.getResource("/images/ship8.png")));
		ship8Btn.setBounds(520, 260, 50, 50);
		addIconChecker(ship8Btn);
		setup2.add(ship8Btn);
		
		JButton ship9Btn = new JButton(""); // Ship 9
		ship9Btn.addActionListener(new SelectedIconListener(setup2, 210, 90));
		ship9Btn.setIcon(new ImageIcon(SetupScreen.class.getResource("/images/ship9.png")));
		ship9Btn.setBounds(590, 260, 50, 50);
		addIconChecker(ship9Btn);
		setup2.add(ship9Btn);
		
		// ======End Ship Icons======
		
		createCrewFields(setup3); // Pre-emptive initialization for setup3
		
		// Create the users set game parameters.
		JButton setup2Next = new JButton("Next");
		setup2Next.setBounds(200, 500, 140, 30);
		setup2Next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (shipNameFld.getText().equals("")) {
					JOptionPane.showMessageDialog(frame, "Please enter the name of your ship!");
				} else if (shipNameFld.getText().length() > 20){
					JOptionPane.showMessageDialog(frame, "Ship name must be up to 20 characters long!");
					shipNameFld.setText("");
				} else if (!iconSelected) {
					JOptionPane.showMessageDialog(frame, "Please select your ship icon!");
				} else {
				
					CardLayout cl = (CardLayout)(setup.getLayout());
					resetCrewFields();
			        cl.next(setup);
				}
			}
		});
		setup2.add(setup2Next);
		
		// ======Window 3: Crew Editor======
		
		// Create setup3 card which will be added to the setup card stack
		setup.add(setup3, "name_621220876675248");
		setup3.setLayout(null);
		
		// Create label for setup3 card
		JLabel CustomizeCrewMemberslbl = new JLabel("CUSTOMIZE YOUR CREW");
		CustomizeCrewMemberslbl.setFont(new Font("Distant Galaxy", Font.PLAIN, 24));
		CustomizeCrewMemberslbl.setBounds(42, 33, 600, 40);
		setup3.add(CustomizeCrewMemberslbl);
		
		// Create back button for Window 3
		JButton setup3Back = new JButton("Back");
		setup3Back.setBounds(50, 500, 140, 30);
		setup3Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)(setup.getLayout());
				resetCrewFields();
		        cl.previous(setup);
			}
		});
		setup3.add(setup3Back);
		
		// Create next button for Window 3
		JButton setup3Next = new JButton("Next");
		setup3Next.setBounds(200, 500, 140, 30);
		setup3Next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean crewNameFldCheck = true;
				
				// Checks if any fields are empty
				int i = 0;
				for (JTextField crewNameFld: crewNames) {
					if (crewNameFld.getText().equals("") && crewNameFldCheck && i < crewSize) {
						JOptionPane.showMessageDialog(frame, "Crew names cannot be empty!");
						crewNameFldCheck = false;
						break;
					} else if (crewNameFld.getText().length() > 20) {
						JOptionPane.showMessageDialog(frame, "Crew names must be up to 20 characters long!");
						crewNameFld.setText("");
					}
					
					// Checks if a field value is the same as any other field
					int j = 0;
					for (JTextField otherNameFld: crewNames) {
						if (crewNameFld.getText().equals(otherNameFld.getText())
								&& crewNames.indexOf(crewNameFld) != crewNames.indexOf(otherNameFld)
								&& crewNameFldCheck
								&& j < crewSize) {
							JOptionPane.showMessageDialog(frame, "Crew names cannot be the same!");
							crewNameFldCheck = false;
							break;
						}
						j++;
					}
					i++;
				}
				
				if (crewNameFldCheck) {
					GameManager gameManager = GameManager.getInstance();
					gameManager.initializeManager(gameDuration, shipNameFld.getText(), shipIcon);
					Crew crew = Crew.getInstance();
					crew.createCrew(crewNames, crewTypes, crewSize);
					
					finishedWindow();
					
					String day = Integer.toString(gameManager.getCurrentDay());
					String duration = Integer.toString(gameManager.getGameDuration());
					String msg = "                                                               Welcome Aboard!"
							+ "\nHumans achieved great success within centuries of advancing technology.  A group of spacemans"
							+ "\nwas  secretly  tasked to develop  a  prototype FTL engine  device called warp drive.  But the project"
							+ "\nfailed when the unexpected happened. The prototype warp drive malfunctioned beyond explanation"
							+ "\nand they have been transported to an unknown planetary system.  Some parts of the ship was torn"
							+ "\ninto pieces. Luckily, these pieces emits radiation and was detected across the surrounding planets."
							+ "\nTheir task was to retrieve the parts within a few days before the alien pirates find about this secret"
							+ "\n                                                                  technology!";
					JOptionPane.showMessageDialog(null, msg);
					String notif = "You are now on day " + day + " of your " + duration + " day journey.";
					notif += "\n                    Good Luck!";
					JOptionPane.showMessageDialog(null, notif);
				}
			}
		});
		setup3.add(setup3Next);
		
	}
	
	/**
	 * This is a function that will add the required number of crew edit sets to the given panel.
	 * @param size An Integer the describes the size of the crew, given by the user.
	 * @param panel A JPanel which refers to the panel that should have the crew edit sets added.
	 */
	private void createCrewFields(JPanel panel) {
		int[] xCoord = {139, 40, 40, 40, 139}; // X coordinate for each component, starting from the first set.
		int[] yCoord = {167, 123, 166, 197, 203}; // Y coordinate for each component, starting from the first set.
		int current = 0;
		int crewTypeDifference = -1;
		
		while(current < 4) {
			if (crewTypeDifference >= 3) crewTypeDifference = 0;
			JTextField textField = new JTextField();
			textField.setBounds(xCoord[0], yCoord[0], 137, 21);
			panel.add(textField);
			textField.setColumns(10);
			crewNames.add(textField);
			
			JLabel lblNewLabel = new JLabel("CREW #" + (current + 1)); // taken out that weird math calculation.
			lblNewLabel.setFont(new Font("Unispace", Font.PLAIN, 18));
			lblNewLabel.setBounds(xCoord[1], yCoord[1], 103, 27);
			panel.add(lblNewLabel);
			crewNumLbl.add(lblNewLabel);
			
			JLabel lblCrewName = new JLabel("CREW NAME:");
			lblCrewName.setFont(new Font("Rockwell", Font.PLAIN, 14));
			lblCrewName.setBounds(xCoord[2], yCoord[2], 114, 21);
			panel.add(lblCrewName);
			crewNamesLbl.add(lblCrewName);
			
			JLabel lblCrewType = new JLabel("CREW TYPE:");
			lblCrewType.setFont(new Font("Rockwell", Font.PLAIN, 14));
			lblCrewType.setBounds(xCoord[3], yCoord[3], 103, 27);
			panel.add(lblCrewType);
			crewTypesLbl.add(lblCrewType);
			
			JComboBox<Object> comboBox = new JComboBox<Object>();
			comboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {"Captain", "Engineer", "Medic", "Scout", "Pilot", "Scientist"}));
			comboBox.setSelectedIndex(crewTypeDifference+=1);
			comboBox.setBounds(xCoord[4], yCoord[4], 137, 21);
			panel.add(comboBox);
			crewTypes.add(comboBox);
			
			if((current%2) == 0) { // even numbers change only the X coordinate, so next item will have new X but same Y.
				int i = 0;
				while(i < xCoord.length) {
					xCoord[i] += 350;
					i ++;
				}
			}
			else { // Odd numbers get the X coordinate taken back to previous value, and increases Y coordinate to new value.
				int i = 0;
				while(i < xCoord.length && i < yCoord.length) {
					xCoord[i] -= 350;
					yCoord[i] += 150;
					i ++;
				}
			}
			current ++; // Increment the current, so the next crew member field is processed next.
		}
		
	}
	
	/**
	 * This a function that will remove all components previously added by the createCrewFields method call. Essentially reseting the panel.
	 * @param size An Integer that describes the crew size number given by the user.
	 * @param panel A JPanel that refers to the panel for which crew edit sets should be removed from.
	 */
	private void resetCrewFields() {
		for (int i = 0; i < 4; i++) {
			crewNames.get(i).setText("");
			if (i < crewSize) {
				crewNames.get(i).setVisible(true);
				crewTypes.get(i).setVisible(true);
				crewNumLbl.get(i).setVisible(true);
				crewNamesLbl.get(i).setVisible(true);
				crewTypesLbl.get(i).setVisible(true);
			} else {
				crewNames.get(i).setVisible(false);
				crewTypes.get(i).setVisible(false);
				crewNumLbl.get(i).setVisible(false);
				crewNamesLbl.get(i).setVisible(false);
				crewTypesLbl.get(i).setVisible(false);
			}
		}
	}
	
	// Not Complete, it will change a buttons icons based on a icon selected.
	public static void getSelectedIcon(JButton button, JButton selected) {
		Icon iconSelected = button.getIcon();
		shipIcon = iconSelected;
		selected.setIcon(iconSelected);
	}
	
	private void addIconChecker(JButton btn) {
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iconSelected = true;
			}
		});
	}
	
	/**
	 * Will clear all content from window, close it.
	 */
	public void closeWindow() {
		frame.dispose();
	}
	
	/**
	 * Uses the GuiManager close function to clear contents from frame and close application.
	 */
	public void finishedWindow() {
		manager.closeSetupScreen(this);
	}
}
