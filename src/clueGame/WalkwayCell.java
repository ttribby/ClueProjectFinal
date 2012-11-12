package clueGame;

import java.awt.Color;
import java.awt.Graphics;

public class WalkwayCell extends BoardCell {

	public WalkwayCell() {
		super();
	}

	public boolean isWalkway() {
		return true;
	}

	public boolean isRoom() {
		return false;
	}

	public boolean isDoorway() {
		return false;
	}


	@Override
	public char getRooomName() {
		return 'W';
	}

	@Override
	void draw(Graphics g, Board b) {
		g.setColor(Color.yellow);
		g.fillRect(super.col*20, super.row*20,20,20);
		g.setColor(Color.black);
		g.drawRect(super.col*20, super.row*20,20, 20);
		
	
		
	}
}
