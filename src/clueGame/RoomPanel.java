package clueGame;
import java.awt.BorderLayout;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;


public class RoomPanel extends JPanel {
	private JComboBox guess;
	private RoomCheck room;
	
	public RoomPanel() {
		guess = CreateComboBox();
		room = new RoomCheck();
		add(room);
		add(guess);
		setBorder(new TitledBorder(new EtchedBorder(), "Rooms"));
		
	}
	
	private JComboBox CreateComboBox() {
		JComboBox combo = new JComboBox();
		combo.addItem("Conservatory");
		combo.addItem("Ballroom");
		combo.addItem("Kitchen");
		combo.addItem("Billiard Room");
		combo.addItem("Library");
		combo.addItem("Study");
		combo.addItem("Lounge");
		combo.addItem("Dining Room");
		combo.addItem("Hall");
		return combo;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

