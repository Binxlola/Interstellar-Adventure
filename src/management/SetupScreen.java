package management;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class SetupScreen {

	private JFrame frmInterstellarAdventures;
	private JTextField shipNameFld;

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
		
		// Create a Jpanel that will act as a card stack
		JPanel setup = new JPanel();
		frmInterstellarAdventures.getContentPane().add(setup, "name_621061748124305");
		setup.setLayout(new CardLayout(0, 0));
		
		// Create setup1 card that will be added to the setup card stack
		JPanel setup1 = new JPanel();
		setup.add(setup1, "name_621206693201140");
		
		// Creat new game button and add event handler
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
		crewSizeSldr.setSnapToTicks(true);
		crewSizeSldr.setMinimum(4);
		crewSizeSldr.setMaximum(6);
		crewSizeSldr.setValue(1);
		crewSizeSldr.setPaintLabels(true);
		crewSizeSldr.setMajorTickSpacing(1);
		crewSizeSldr.setBounds(100, 111, 200, 30);
		setup2.add(crewSizeSldr);
		
		JButton setup2Next = new JButton("Next");
		setup2Next.setBounds(150, 340, 100, 50);
		setup2.add(setup2Next);
		
		// Adding the ship icons as buttons
		JButton ship1Btn = new JButton("");
		ship1Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton cl = (JButton)(setup2.getComponentAt(520, 350));
				getSelectedIcon(ship1Btn, cl);
			}
		});
		ship1Btn.setIcon(new ImageIcon(SetupScreen.class.getResource("/images/ship1.png")));
		ship1Btn.setBounds(450, 40, 50, 50);
		setup2.add(ship1Btn);
		
		JLabel selectShipLbl = new JLabel("Ship Icon");
		selectShipLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		selectShipLbl.setBounds(500, 5, 70, 20);
		setup2.add(selectShipLbl);
		
		JButton ship2Btn = new JButton("");
		ship2Btn.setIcon(new ImageIcon(SetupScreen.class.getResource("/images/ship2.png")));
		ship2Btn.setBounds(520, 40, 50, 50);
		setup2.add(ship2Btn);
		
		JButton ship3Btn = new JButton("");
		ship3Btn.setIcon(new ImageIcon(SetupScreen.class.getResource("/images/ship3.png")));
		ship3Btn.setBounds(590, 40, 50, 50);
		setup2.add(ship3Btn);
		
		JButton ship4Btn = new JButton("");
		ship4Btn.setIcon(new ImageIcon(SetupScreen.class.getResource("/images/ship4.png")));
		ship4Btn.setBounds(450, 100, 50, 50);
		setup2.add(ship4Btn);
		
		JButton ship5Btn = new JButton("");
		ship5Btn.setIcon(new ImageIcon(SetupScreen.class.getResource("/images/ship5.png")));
		ship5Btn.setBounds(520, 100, 50, 50);
		setup2.add(ship5Btn);
		
		JButton ship6Btn = new JButton("");
		ship6Btn.setIcon(new ImageIcon(SetupScreen.class.getResource("/images/ship6.png")));
		ship6Btn.setBounds(590, 100, 50, 50);
		setup2.add(ship6Btn);
		
		JButton ship7Btn = new JButton("");
		ship7Btn.setIcon(new ImageIcon(SetupScreen.class.getResource("/images/ship7.png")));
		ship7Btn.setBounds(450, 160, 50, 50);
		setup2.add(ship7Btn);
		
		JButton ship8Btn = new JButton("");
		ship8Btn.setIcon(new ImageIcon(SetupScreen.class.getResource("/images/ship8.png")));
		ship8Btn.setBounds(520, 160, 50, 50);
		setup2.add(ship8Btn);
		
		JButton ship9Btn = new JButton("");
		ship9Btn.setIcon(new ImageIcon(SetupScreen.class.getResource("/images/ship9.png")));
		ship9Btn.setBounds(590, 160, 50, 50);
		setup2.add(ship9Btn);
		
		JButton testBtn = new JButton("");
		testBtn.setBounds(520, 350, 50, 50);
		setup2.add(testBtn);
	}
	
	// Not Complete, it will change a buttons icons based on a icon selected. Currently only works for the first Button.
	private void getSelectedIcon(JButton button, JButton selected) {
		Icon iconSelected = button.getIcon();
		selected.setIcon(iconSelected);
		
	}
}
