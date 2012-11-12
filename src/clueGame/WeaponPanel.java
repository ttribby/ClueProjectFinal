package clueGame;
import java.awt.BorderLayout;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;


public class WeaponPanel extends JPanel {
	private JComboBox guess;
	private WeaponCheck weapons;
	
	public WeaponPanel() {
		guess = CreateComboBox();
		weapons = new WeaponCheck();
		add(weapons);
		add(guess);
		setBorder(new TitledBorder(new EtchedBorder(), "Weapons"));

	}
	
	private JComboBox CreateComboBox() {
		JComboBox combo = new JComboBox();
		combo.addItem("Pipe");
		combo.addItem("Knife");
		combo.addItem("Pool Stick");
		combo.addItem("Pistol");
		combo.addItem("Rope");
		combo.addItem("Candlestick");
		return combo;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
