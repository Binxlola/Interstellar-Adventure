package mainGui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class SelectedIconListener implements ActionListener {
	
	private JPanel frame;
	private int xCoord;
	private int yCoord;
	
	public SelectedIconListener(JPanel theFrame, int x, int y) {
		frame = theFrame;
		xCoord = x;
		yCoord = y;
	}

	
	/**
	 * Will get the source of an action, and will pass the source and target location to getSelectedIcon().
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton)(e.getSource());
		JButton toChange = (JButton) frame.getComponentAt(xCoord, yCoord);
		SetupScreen.getSelectedIcon(button, toChange);
	}

}
