package clueGame;
import java.awt.GridLayout;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;


public class WeaponCheck extends JPanel {
	private JCheckBox one;
	private JCheckBox two;
	private JCheckBox three;
	private JCheckBox four;
	private JCheckBox five;
	private JCheckBox six;
	
	public WeaponCheck() {
		setLayout(new GridLayout(2,3));
		one = new JCheckBox("Pipe");
		two = new JCheckBox("Knife");
		three = new JCheckBox("Pool Stick");
		four = new JCheckBox("Pistol");
		five = new JCheckBox("Rope");
		six = new JCheckBox("Candlestick");
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
