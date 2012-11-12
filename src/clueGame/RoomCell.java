package clueGame;

import java.awt.Color;
import java.awt.Graphics;

public class RoomCell extends BoardCell {

	//added a toString method to the DoorDirection enum
	public enum DoorDirection {
		UP("Up"), DOWN("Down"), LEFT("Left"), RIGHT("Right"), NONE("None");
		private String value;
		DoorDirection(String avalue) {
			value = avalue;
		}
		public String toString() {
			return value;
		}
	}

	private DoorDirection doorDirection;
	private char roomName;

	public RoomCell() {
		doorDirection = DoorDirection.NONE;
	}

	public void setRoom(char r) {
		this.roomName = r;
	}

	public boolean isRoom() {
		if (this.getRooomName() != 'X') {
			return true;
		} else {
			return false;
		}
	}

	public boolean isWalkway() {
		return false;
	}

	public boolean isDoorway() {
		if (doorDirection != DoorDirection.NONE) {
			return true;
		} else {
			return false;
		}
	}
//
//	@Override
//	void draw() {
//		// TODO Auto-generated method stub
//	}

	public DoorDirection getDoorDirection() {
		return doorDirection;
	}

	public char getRooomName() {
		return roomName;
	}

	public void setDoorDirection(char d) {
		if (d == 'U') {
			this.doorDirection = DoorDirection.UP;
		} else if (d == 'D') {
			this.doorDirection = DoorDirection.DOWN;
		} else if (d == 'L') {
			this.doorDirection = DoorDirection.LEFT;
		} else if (d == 'R') {
			this.doorDirection = DoorDirection.RIGHT;
		}
	}

	@Override
	void draw(Graphics g, Board b) {
		// TODO Auto-generated method stub
		
		g.setColor(Color.gray);
		g.fillRect(col*20, row*20,20,20);
		//draw doorway
		g.setColor(Color.blue);
		switch(doorDirection){
		case DOWN:
			g.fillRect(col*20, row*20+17, 20, 3);
			
			break;
		case LEFT:
			g.fillRect(col*20, row*20, 3, 20);
			break;
		case NONE:
			break;
		case RIGHT:
			g.fillRect(col*20+17, row*20, 3, 20);
			break;
		case UP:
			g.fillRect(col*20, row*20, 20, 3);
			break;
		default:
			break;

			
		}
		
	}

}
