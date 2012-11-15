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
	public Set<Card> unseenCards;
	public ComputerPlayer(String name, Color color, int index) {
		super(name, color, index);
		unseenCards = Board.deck;
	}
	public void createSuggestion() {
		ArrayList<Card> suggestedRooms = new ArrayList<Card>();
		ArrayList<Card> suggestedWeapons = new ArrayList<Card>();
		ArrayList<Card> suggestedPersons = new ArrayList<Card>();
		for(Card c : unseenCards){
			switch(c.cardType){
			case PLAYER:
				suggestedPersons.add(c);
				break;
			case ROOM:
				suggestedRooms.add(c);
				break;
			case WEAPON:
				suggestedWeapons.add(c);
				break;
			default:
				break;

			}
		}
		if(suggestedRooms.size()>0)
			suggestedRoom = suggestedRooms.get(new Random().nextInt(suggestedRooms.size()));
		else 
			suggestedRoom = null;
		if(suggestedWeapons.size()>0)
			suggestedWeapon = suggestedWeapons.get(new Random().nextInt(suggestedWeapons.size()));
		else
			suggestedWeapon = null;
		if(suggestedPersons.size()>0)
			suggestedPerson = suggestedPersons.get(new Random().nextInt(suggestedPersons.size()));
		else
			suggestedPerson = null;

	}
	public Card suggestedRoom;
	public Card suggestedWeapon;
	public Card suggestedPerson;

	public void updateSeen(Card seen){
		seenCards = new ArrayList();
		seenCards.add(seen);

	}


	public Card getSuggestedRoom() {
		return suggestedRoom;
	}
	public Card getSuggestedWeapon() {
		return suggestedWeapon;
	}
	public Card getSuggestedPerson() {
		return suggestedPerson;
	}
	public BoardCell pickLocation(Set<BoardCell> set){
		for(BoardCell bc : set){
			if(bc.isDoorway()){
				return bc;
			}else if(bc.isRoom()){
				return bc;
			}
		}
		int i=0;
		int rand = new Random().nextInt(set.size());
		for(BoardCell cell : set)
		{
		    if (i == rand)
		        return cell;
		    i = i + 1;
		}
		
		return null;
	}

}

