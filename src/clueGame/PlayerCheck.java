package clueGame;
import java.awt.GridLayout;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;


public class PlayerCheck extends JPanel {
	private JCheckBox one;
	private JCheckBox two;
	private JCheckBox three;
	private JCheckBox four;
	private JCheckBox five;
	private JCheckBox six;
	
	public PlayerCheck() {
		setLayout(new GridLayout(2,3));
		one = new JCheckBox("Darth Vader");
		two = new JCheckBox("Randy Moss");
		three = new JCheckBox("Liam Neeson");
		four = new JCheckBox("Michael Jordan");
		five = new JCheckBox("Teen Mom");
		six = new JCheckBox("You");
		add(one);
		add(two);
		add(three);
		add(four);
		add(five);
		add(six);

	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
