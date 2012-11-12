package clueGame;
import java.awt.Color;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;


abstract public class Player {
	public String roomName;
	public String name;
	public Color color;
	public Set<Card> myCards = new HashSet<Card>();
	public int index;
	
	public Player() {
		this.name = null;
		this.color = null;
		this.index = 0;
	}
	
	public Player(String x, Color y, int index) {
		this.name = x;
		this.color = y;
		this.index = index;
		
	}
	
	public String getName() {
		return name;
	}
	
	public BoardCell pickLocation(Set<BoardCell> targets) {
		
		
		
		return null;
	}
	
	public Card disproveSuggestion(String player, String weapon, String room) {
		Card Room = new Card("Room", room);
		Card Player = new Card("Player", player);
		Card Weapon = new Card("Weapon", weapon);
			if(myCards.contains(Room)) {
				System.out.println(Room.toString());
				return Room;

			}else if(myCards.contains(Player)) {
				System.out.println(Player.toString());
				return Player;
			}else if(myCards.contains(Weapon)) {
				System.out.println(Weapon.toString());
				return Weapon;

			}else {
				return Room;
			}

		}
	}


