package clueGame;
import java.awt.Color;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;


public class HumanPlayer extends Player {
	public HumanPlayer() {
		super();
	}
	
	public HumanPlayer(String name, Color color, int index) {
		super(name, color, index);
	}
	
	@Override
	public BoardCell pickLocation(Set<BoardCell> targets) {
		ArrayList<BoardCell> numbas = new ArrayList<BoardCell>();
	
		int i = 0;
		int j = 0;
		for(BoardCell cell: targets) {
			String room = cell.roomName;
			System.out.println(i + ": " + room);
			numbas.add(cell);
			
		}
		Scanner scan = new Scanner(System.in);
		System.out.println("Select a target by choosing it's corresponding number: ");
		int selection = scan.nextInt();

		return numbas.get(selection);
		
		
		
	}


}