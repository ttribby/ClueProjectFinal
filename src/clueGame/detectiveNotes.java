package clueGame;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class detectiveNotes extends JFrame {

	private PlayerPanel player;
	private RoomPanel room;
	private WeaponPanel weapon;
	
	public detectiveNotes() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setSize(new Dimension(800, 400));
		setTitle("Notes");
		
		player = new PlayerPanel();
		weapon = new WeaponPanel();
		room = new RoomPanel();
		
		
		add(player,BorderLayout.NORTH);
		add(room, BorderLayout.CENTER);
		add(weapon, BorderLayout.SOUTH);
		this.pack();
	}


}
