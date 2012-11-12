package clueGame;
import java.awt.GridLayout;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;


public class RoomCheck extends JPanel {
	private JCheckBox one;
	private JCheckBox two;
	private JCheckBox three;
	private JCheckBox four;
	private JCheckBox five;
	private JCheckBox six;
	private JCheckBox seven;
	private JCheckBox eight;
	private JCheckBox nine;
	
	public RoomCheck() {
		setLayout(new GridLayout(2,3));
		one = new JCheckBox("Conservatory");
		two = new JCheckBox("Ballroom");
		three = new JCheckBox("Kitchen");
		four = new JCheckBox("Billiard Room");
		five = new JCheckBox("Library");
		six = new JCheckBox("Study");
		seven = new JCheckBox("Lounge");
		eight = new JCheckBox("Dining Room");
		nine = new JCheckBox("Hall");
		add(one);
		add(two);
		add(three);
		add(four);
		add(five);
		add(six);
		add(seven);
		add(eight);
		add(nine);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
