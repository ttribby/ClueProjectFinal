package clueGame;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;
import java.util.Set;


public class ComputerPlayer extends Player {
	public ArrayList<Card> seenCards = new ArrayList();
	
	public ComputerPlayer() {
		super();
	}
	
	public ComputerPlayer(String name, Color color, int index) {
		super(name, color, index);
	}
	public void createSuggestion() {
		
	}
	public void updateSeen(Card seen){
		seenCards = new ArrayList();
		seenCards.add(seen);
		
	}
	

	public BoardCell pickLocation(Set<BoardCell> targets) { //supposed to be void???? 
		BoardCell b = new WalkwayCell();
		Random rnd = new Random();
		int selection = rnd.nextInt(targets.size());
		int i = 0;
		for(BoardCell cell : targets) {
			if (selection == i) {
				return cell;
				
				}else {
					i++;
				}
			
		}
		return null;
	}
}

