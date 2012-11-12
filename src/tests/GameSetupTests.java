//package tests;
//
//import static org.junit.Assert.assertEquals;
//
//import java.awt.Color;
//
//import junit.framework.Assert;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import clueGame.Board;
//import clueGame.Card;
//import clueGame.ComputerPlayer;
//import clueGame.HumanPlayer;
//import clueGame.Player;
//
//public class GameSetupTests {
//	Board brd;
//
//	@Before 
//	public void setUp() throws Exception {
//		brd = new Board();
//		Card testwep = new Card("Weapon", "Pipe" ); //sample test weapon card
//		Card testPlayer = new Card("Player", "D. Vader" ); //sample card
//		Card testroom = new Card("Room", "Study" ); // test card
//		Player test = new HumanPlayer("Michael Jordan", Color.BLUE , 111); //test player
//		Player test2 = new ComputerPlayer("Teen Mom", Color.YELLOW, 133); //test player
//		}
//
//	@Test
//	public void peopleLoaded() {
//		brd = new Board();
//		Assert.assertEquals(6, brd.players.size()); //tests to see if we have exactly 6 players
//		Player test = new ComputerPlayer("Michael Jordan", Color.BLUE , 111); //tests to see that our player is a player
//		Player test2 = new ComputerPlayer("Teen Mom", Color.YELLOW, 133);
//		assert(brd.players.contains(test));
//		assert(brd.players.contains(test2));
//
//	}
//
//	@Test
//	public void deckLoaded() {
//
//		Assert.assertEquals(21, brd.deck.size()); // tests to see if our deck is the right size we made it
//		Card testwep = new Card("Weapon", "Pipe" );
//		Card testPlayer = new Card("Player", "D. Vader" );
//		Card testroom = new Card("Room", "Study" );
//
//		assert(brd.deck.contains(testwep));   //tests to see if one of our weapons is in the deck
//		assert(brd.deck.contains(testPlayer)); //tests to see if one of our players is in the deck
//		assert(brd.deck.contains(testroom)); //tests to see if one of our rooms is in the deck
//	}
//	
//	
//	@Test
//	public void dealTest() {
//		brd = new Board();
//		brd.deal();
//		System.out.println(brd.players.toString());
//		System.out.println(brd.players.size());
//		for(Player p: brd.players) {
//			System.out.println(p.myCards.size());
//			System.out.println(p.myCards.toString());
//			assertEquals(p.myCards.size(),  3);
//		}
//
//
//		}
//
//
//	
//		}
//
//
