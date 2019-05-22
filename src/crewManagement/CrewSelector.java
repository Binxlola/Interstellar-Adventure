package crewManagement;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import crewManagement.Crew;
import crewManagement.CrewMember;

/**
 * A utility tool to select a crew from the Crew instance with available moves using pop dialog with radio buttons,
 * which in turn, you can use getCrew() method to get the selected Crew.
 * getCrew() returns null if the player doesn't select any from the presented crew.
 * @author Ariel Evangelista
 *
 */
public class CrewSelector {
	
	private Crew crew = Crew.getInstance();
	private CrewMember crewSelect = null;
	private String msg;
	private String dialog;
	private List<JRadioButton> crewSelectList = new ArrayList<JRadioButton>();
	
	public CrewSelector() {
		crewSelectList.removeAll(crewSelectList);
		msg = "Select a crew";
		dialog = "Select";
		getcrewSelect();
	}
	
	public CrewSelector(String newMsg) {
		crewSelectList.removeAll(crewSelectList);
		msg = newMsg;
		dialog = "Select";
		getcrewSelect();
	}
	
	public CrewSelector(String newMsg, String newDialog) {
		crewSelectList.removeAll(crewSelectList);
		msg = newMsg;
		dialog = newDialog;
		getcrewSelect();
	}
	
	public CrewMember getCrew() {
		return this.crewSelect;
	}
	
	/**
	 * Produces the Message Dialog containing radio buttons of all crews available
	 * @return Returns true (ok) or false (cancel) based on the user preference
	 */
	private void getcrewSelect() {
		JRadioButton radBtn1 = new JRadioButton("");
		JRadioButton radBtn2 = new JRadioButton("");
		JRadioButton radBtn3 = new JRadioButton("");
		JRadioButton radBtn4 = new JRadioButton("");
		JRadioButton radBtn5 = new JRadioButton("");
		JRadioButton radBtn6 = new JRadioButton("");
		crewSelectList.add(radBtn1);
		crewSelectList.add(radBtn2);
		crewSelectList.add(radBtn3);
		crewSelectList.add(radBtn4);
		crewSelectList.add(radBtn5);
		crewSelectList.add(radBtn6);
		Object[] params = {this.msg, radBtn1, radBtn2, radBtn3, radBtn4, radBtn5, radBtn6};
		for (int i = 0; i < crewSelectList.size(); i++) {
			if (i < crew.size()) {
				String name = crew.getCrew().get(i).getName();
				String type = crew.getCrew().get(i).getType();
				int move = crew.getCrew().get(i).getMoves();
				
				crewSelectList.get(i).setText(type + " " + name + " (" + move + " moves left)");
				
				addListener(crewSelectList.get(i));
				
				if (move <= 0) crewSelectList.get(i).setEnabled(false);
			} else {
				crewSelectList.get(i).setVisible(false);
			}
		}
		
		int input = JOptionPane.showConfirmDialog(null, params, this.dialog, JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		
		if (input == 0) {
			for (JRadioButton btn: crewSelectList) {
				if (btn.isSelected()) {
					int radioIndex = crewSelectList.indexOf(btn);
					crewSelect = crew.getCrew().get(radioIndex);
				}
			}
		}
	}
	
	/*
	 * Adds an event listener to a given radio button
	 * @param Radio button to be added an event listener
	 */
	private void addListener(JRadioButton rb) {
		rb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JRadioButton source = (JRadioButton) e.getSource();
				if (source.isSelected()) {
					for (JRadioButton btn: crewSelectList) {
						if (btn != source) {
							btn.setSelected(false);
						}
					}
				} else {
					source.setSelected(true);
				}
			}
		});
	}
}