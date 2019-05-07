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
import javax.swing.ImageIcon;

public class SetupScreen {

	private JFrame frmInterstellarAdventures;

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
		JButton button2 = new JButton("go 1");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)(setup.getLayout());
		        cl.show(setup, "name_621206693201140");
			}
		});
		setup2.add(button2);
		
		JLabel label2 = new JLabel("panel 2");
		setup2.add(label2);
	}
}
