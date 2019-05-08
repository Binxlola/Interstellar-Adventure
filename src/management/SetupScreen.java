package management;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SetupScreen {

	private JFrame frmInterstellarAdventures;
	private JTextField shipNameFld;
	private int crewSize;
	private int gameDuration;
	
	//For setup3 window
	private ArrayList<JTextField> crewName = new ArrayList<JTextField>();
	private ArrayList<JComboBox<Object>> crewCombo = new ArrayList<JComboBox<Object>>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetupScreen window = new SetupScreen();
					window.frmInterstellarAdventures.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SetupScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmInterstellarAdventures = new JFrame();
		frmInterstellarAdventures.setTitle("Interstellar Adventures");
		frmInterstellarAdventures.setBounds(100, 100, 1000, 600);
		frmInterstellarAdventures.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmInterstellarAdventures.getContentPane().setLayout(new CardLayout(0, 0));
		frmInterstellarAdventures.setResizable(false);
		
		// Create a Jpanel that will act as a card stack
		JPanel setup = new JPanel();
		frmInterstellarAdventures.getContentPane().add(setup, "name_621061748124305");
		setup.setLayout(new CardLayout(0, 0));
		
		// Create setup1 card that will be added to the setup card stack
		JPanel setup1 = new JPanel();
		setup.add(setup1, "name_621206693201140");
		
		// Create new game button and add event handler
		JButton newGameBtn = new JButton("New Game");
		newGameBtn.setBounds(320, 382, 102, 31);
		newGameBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)(setup.getLayout());
		        cl.show(setup, "name_621220876675124");
			}
		});
		setup1.setLayout(null);
		setup1.add(newGameBtn);
		
		// Create load game buttons and add event handler
		JButton loadGameBtn = new JButton("Load Game");
		loadGameBtn.setBounds(470, 383, 102, 31);
		setup1.add(loadGameBtn);
		
		// Create how to play buttons and add event handler
		JButton howToBtn = new JButton("How to play");
		howToBtn.setBounds(395, 425, 102, 31);
		setup1.add(howToBtn);
		
		// Create a label field that will act as an image holder for the game logo
		JLabel gameLogo = new JLabel("");
		gameLogo.setIcon(new ImageIcon(SetupScreen.class.getResource("/images/game_logo.png")));
		gameLogo.setBounds(0, 0, 984, 348);
		setup1.add(gameLogo);
		
		
		// Create setup2 card which will be added to the setup card stack
		JPanel setup2 = new JPanel();
		setup.add(setup2, "name_621220876675124");
		
		// Create test button and add event handler !!!!Must Be changed!!!!
		JButton setup2Back = new JButton("Back");
		setup2Back.setBounds(5, 340, 100, 50);
		setup2Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)(setup.getLayout());
		        cl.show(setup, "name_621206693201140");
			}
		});
		setup2.setLayout(null);
		setup2.add(setup2Back);
		
		// ===========Game Length===========
		
		// Game Length
		JLabel gameLengthLbl = new JLabel("Game Length:");
		gameLengthLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		gameLengthLbl.setBounds(5, 5, 95, 20);
		setup2.add(gameLengthLbl);
		
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
		gameLengthSldr.setBounds(100, 5, 200, 30);
		setup2.add(gameLengthSldr);
		
		// Ship Name
		JLabel shipNameLbl = new JLabel("Ship Name:");
		shipNameLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		shipNameLbl.setBounds(5, 60, 95, 20);
		setup2.add(shipNameLbl);
		
		shipNameFld = new JTextField();
		shipNameFld.setBounds(100, 62, 200, 20);
		setup2.add(shipNameFld);
		shipNameFld.setColumns(10);
		
		// Crew Size
		JLabel crewSizeLbl = new JLabel("Crew Size:");
		crewSizeLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		crewSizeLbl.setBounds(5, 110, 95, 30);
		setup2.add(crewSizeLbl);
		
		JSlider crewSizeSldr = new JSlider();
		crewSizeSldr.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider) e.getSource();
				crewSize = source.getValue();
				
			}
		});
		crewSizeSldr.setSnapToTicks(true);
		crewSizeSldr.setMinimum(4);
		crewSizeSldr.setMaximum(6);
		crewSizeSldr.setValue(1);
		crewSizeSldr.setPaintLabels(true);
		crewSizeSldr.setMajorTickSpacing(1);
		crewSizeSldr.setBounds(100, 111, 200, 30);
		setup2.add(crewSizeSldr);
		
		// Create setup3 before setup2's Next Button creation
		JPanel setup3 = new JPanel();
		
		// Create the users set game parameters.
		JButton setup2Next = new JButton("Next");
		setup2Next.setBounds(150, 340, 100, 50);
		setup2Next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Crew size: " + crewSize);
				System.out.println("Game duration: " + gameDuration);
				System.out.println(shipNameFld.getText());
				
				//---can be removed
				CardLayout cl = (CardLayout)(setup.getLayout());
				createCrewFields(crewSize, setup3);
		        cl.show(setup, "name_621220876675248");
				//-----------------
			}
		});
		setup2.add(setup2Next);
		
		//--can be removed
		
		// Create setup3 card which will be added to the setup card stack
		// Window 3: The Crew Editor
		setup.add(setup3, "name_621220876675248");
		setup3.setLayout(null);
		
		//-----------------
		
		
		// ======Ship Icons======
		JLabel selectShipLbl = new JLabel("Ship Icon");
		selectShipLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		selectShipLbl.setBounds(500, 5, 70, 20);
		setup2.add(selectShipLbl);
		
		// Adding the ship icons as buttons
		JButton ship1Btn = new JButton(""); // Ship 1
		ship1Btn.addActionListener(new SelectedIconListener(setup2, 520, 350));
		ship1Btn.setIcon(new ImageIcon(SetupScreen.class.getResource("/images/ship1.png")));
		ship1Btn.setBounds(450, 40, 50, 50);
		setup2.add(ship1Btn);
		
		JButton ship2Btn = new JButton(""); // Ship 2
		ship2Btn.addActionListener(new SelectedIconListener(setup2, 520, 350));
		ship2Btn.setIcon(new ImageIcon(SetupScreen.class.getResource("/images/ship2.png")));
		ship2Btn.setBounds(520, 40, 50, 50);
		setup2.add(ship2Btn);
		
		JButton ship3Btn = new JButton(""); // Ship 3
		ship3Btn.addActionListener(new SelectedIconListener(setup2, 520, 350));
		ship3Btn.setIcon(new ImageIcon(SetupScreen.class.getResource("/images/ship3.png")));
		ship3Btn.setBounds(590, 40, 50, 50);
		setup2.add(ship3Btn);
		
		JButton ship4Btn = new JButton(""); // Ship 4
		ship4Btn.addActionListener(new SelectedIconListener(setup2, 520, 350));
		ship4Btn.setIcon(new ImageIcon(SetupScreen.class.getResource("/images/ship4.png")));
		ship4Btn.setBounds(450, 100, 50, 50);
		setup2.add(ship4Btn);
		
		JButton ship5Btn = new JButton(""); // Ship 5
		ship5Btn.addActionListener(new SelectedIconListener(setup2, 520, 350));
		ship5Btn.setIcon(new ImageIcon(SetupScreen.class.getResource("/images/ship5.png")));
		ship5Btn.setBounds(520, 100, 50, 50);
		setup2.add(ship5Btn);
		
		JButton ship6Btn = new JButton(""); // Ship 6
		ship6Btn.addActionListener(new SelectedIconListener(setup2, 520, 350));
		ship6Btn.setIcon(new ImageIcon(SetupScreen.class.getResource("/images/ship6.png")));
		ship6Btn.setBounds(590, 100, 50, 50);
		setup2.add(ship6Btn);
		
		JButton ship7Btn = new JButton(""); // Ship 7
		ship7Btn.addActionListener(new SelectedIconListener(setup2, 520, 350));
		ship7Btn.setIcon(new ImageIcon(SetupScreen.class.getResource("/images/ship7.png")));
		ship7Btn.setBounds(450, 160, 50, 50);
		setup2.add(ship7Btn);
		
		JButton ship8Btn = new JButton(""); // Ship 8
		ship8Btn.addActionListener(new SelectedIconListener(setup2, 520, 350));
		ship8Btn.setIcon(new ImageIcon(SetupScreen.class.getResource("/images/ship8.png")));
		ship8Btn.setBounds(520, 160, 50, 50);
		setup2.add(ship8Btn);
		
		JButton ship9Btn = new JButton(""); // Ship 9
		ship9Btn.addActionListener(new SelectedIconListener(setup2, 520, 350));
		ship9Btn.setIcon(new ImageIcon(SetupScreen.class.getResource("/images/ship9.png")));
		ship9Btn.setBounds(590, 160, 50, 50);
		setup2.add(ship9Btn);
		
		JButton testBtn = new JButton("");
		testBtn.setBounds(520, 350, 50, 50);
		setup2.add(testBtn);
	}
	
	private void createCrewFields(int size, JPanel panel) {
		int[] locTxt = {139, 127, 489, 127, 139, 277, 489, 277, 139, 427, 489, 427};
		int[] locLbl = {40, 83, 390, 83, 40, 233, 390, 233, 40, 383, 390, 383};
		int[] locName = {40, 126, 390, 126, 40, 276, 390, 276, 40, 426, 390, 426};
		int[] locType = {40, 157, 390, 157, 40, 307, 390, 307, 40, 457, 390, 457};
		int[] locCombo = {139, 163, 489, 163, 139, 313, 489, 313, 139, 463, 489, 463};
		for (int i = 0; (i/2) < crewSize; i+=2) {
			// add components to the panel
			JTextField textField = new JTextField();
			textField.setBounds(locTxt[i], locTxt[i+1], 137, 21);
			panel.add(textField);
			textField.setColumns(10);
			crewName.add(textField);
			
			JLabel lblNewLabel = new JLabel("CREW #" + ((i/2) + 1));
			lblNewLabel.setFont(new Font("Unispace", Font.PLAIN, 18));
			lblNewLabel.setBounds(locLbl[i], locLbl[i+1], 103, 27);
			panel.add(lblNewLabel);
			
			JLabel lblCrewName = new JLabel("CREW NAME:");
			lblCrewName.setFont(new Font("Rockwell", Font.PLAIN, 14));
			lblCrewName.setBounds(locName[i], locName[i+1], 114, 21);
			panel.add(lblCrewName);
			
			JLabel lblCrewType = new JLabel("CREW TYPE:");
			lblCrewType.setFont(new Font("Rockwell", Font.PLAIN, 14));
			lblCrewType.setBounds(locType[i], locType[i+1], 103, 27);
			panel.add(lblCrewType);
			
			JComboBox<Object> comboBox = new JComboBox<Object>();
			comboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {"Captain", "Engineer", "Medic", "Scout"}));
			comboBox.setBounds(locCombo[i], locCombo[i+1], 137, 21);
			panel.add(comboBox);
			crewCombo.add(comboBox);
		}
	}
	
	// Not Complete, it will change a buttons icons based on a icon selected.
	public static void getSelectedIcon(JButton button, JButton selected) {
		Icon iconSelected = button.getIcon();
		selected.setIcon(iconSelected);
		
	}
}
