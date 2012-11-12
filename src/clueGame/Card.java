package clueGame;


public class Card {
	public enum CardType {
		PLAYER("Player"), WEAPON("Weapon"), ROOM("Room");
		private String value;
		CardType(String avalue) {
			value = avalue;
		}
		public String toString() {
			return value;
		}
	}
	public CardType cardType;
	public String name;
	public Card(String x, String y) {
		if(x.equalsIgnoreCase("Player")) {
			this.cardType = CardType.PLAYER;
		}else if(x.equalsIgnoreCase("Weapon")) {
			this.cardType = CardType.WEAPON;
		}else if(x.equalsIgnoreCase("Room")) {
			this.cardType = CardType.ROOM;
		}
		this.name = y;
	}
	
	public String toString() {
		return name + " " + cardType.toString();
	}

}
