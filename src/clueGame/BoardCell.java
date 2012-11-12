package clueGame;

import java.awt.Graphics;


public abstract class BoardCell {
	public String roomName;
	int row;
	int col;
	public int boardWidth;

	public abstract boolean isWalkway();

	public abstract boolean isRoom();

	public abstract boolean isDoorway();

	public abstract char getRooomName();

	abstract void draw(Graphics g, Board b);

	public void setRow(int row) {
		this.row = row;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public void setBoardWidth(int w) {
		this.boardWidth = w;
	}

	public int getIndex() {
		return row * boardWidth + col;
	}
}
