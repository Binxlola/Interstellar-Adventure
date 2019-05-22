package mainGui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import crewManagement.Crew;
import crewManagement.SpaceShip;
import management.GameManager;

public class GameOver extends JPanel {
	
	private Crew crew = Crew.getInstance();
	private MainScreen window;
	private GameManager gameManager = GameManager.getInstance();
	private SpaceShip spaceShip = SpaceShip.getInstance();

	/**
	 * Create the panel.
	 */
	public GameOver(MainScreen incomingWindow) {
		window = incomingWindow;
		setBounds(0, 0, 1000, 600);
		setLayout(null);
		
		JButton exitBtn = new JButton("Exit");
		exitBtn.setBounds(50, 500, 140, 30);
		exitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				window.finishedWindow();
			}
		});
		add(exitBtn);
		
		JLabel gameOverLbl = new JLabel("GAME OVER");
		gameOverLbl.setFont(new Font("Distant Galaxy", Font.PLAIN, 24));
		gameOverLbl.setBounds(42, 33, 600, 40);
		this.add(gameOverLbl);
		
		JLabel resultLbl = new JLabel(gameManager.getGameResult());
		resultLbl.setFont(new Font("Rockwell", Font.PLAIN, 18));
		resultLbl.setBounds(60, 80, 600, 40);
		this.add(resultLbl);
		
		JLabel commentLbl = new JLabel(gameManager.getGameComment());
		commentLbl.setFont(new Font("Rockwell", Font.PLAIN, 18));
		commentLbl.setBounds(60, 110, 800, 40);
		this.add(commentLbl);
		
		
		JLabel scoreLbl = new JLabel("SCORE: " + gameManager.getGameScore());
		scoreLbl.setFont(new Font("Rockwell", Font.PLAIN, 18));
		scoreLbl.setBounds(60, 180, 600, 40);
		this.add(scoreLbl);
		
		JLabel shipLbl = new JLabel("SHIP: " + spaceShip.getShipName());
		shipLbl.setFont(new Font("Rockwell", Font.PLAIN, 18));
		shipLbl.setBounds(60, 220, 600, 40);
		this.add(shipLbl);
		
		JLabel dayLbl = new JLabel("DAYS TAKEN: " + gameManager.getCurrentDay() + " / " + gameManager.getGameDuration());
		dayLbl.setFont(new Font("Rockwell", Font.PLAIN, 18));
		dayLbl.setBounds(60, 260, 600, 40);
		this.add(dayLbl);
		
		JLabel partsLbl = new JLabel("SHIP PARTS FOUND: " + gameManager.getPartsFound() + " / " + gameManager.getPartsToFind());
		partsLbl.setFont(new Font("Rockwell", Font.PLAIN, 18));
		partsLbl.setBounds(60, 300, 600, 40);
		this.add(partsLbl);
	}
}
