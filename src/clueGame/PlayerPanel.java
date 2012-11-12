package clueGame;
import java.awt.BorderLayout;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;


public class PlayerPanel extends JPanel {
	private JComboBox guess;
	private PlayerCheck people;
	
	public PlayerPanel() {
		guess = CreateComboBox();
		people = new PlayerCheck();
		add(people, BorderLayout.PAGE_START);
		add(guess);
		setBorder(new TitledBorder(new EtchedBorder(), "People"));
		
	}
	
	private JComboBox CreateComboBox() {
		setBorder(new TitledBorder(new EtchedBorder(), "People Guess"));
		JComboBox combo = new JComboBox();
		combo.addItem("Darth Vader");
		combo.addItem("Randy Moss");
		combo.addItem("Liam Neeson");
		combo.addItem("Michael Jordan");
		combo.addItem("Teen Mom");
		combo.addItem("You");
		return combo;

	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
