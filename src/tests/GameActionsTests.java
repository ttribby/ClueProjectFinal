package tests;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import clueGame.Board;
import clueGame.BoardCell;
import clueGame.Card;
import clueGame.ClueGame;
import clueGame.ComputerPlayer;
import clueGame.HumanPlayer;
import clueGame.Player;
import clueGame.Solution;

public class GameActionsTests {
Board brd;
	@Before
	public void setUp() throws Exception {
		brd = new Board(null);
		Solution solution = new Solution("Liam Neeson", "Pipe", "Kitchen"); //sample test solution
		Player player = new HumanPlayer();
		Player player2 = new ComputerPlayer();
		Card card = player.disproveSuggestion("Michael Jordan", "Rope", "Kitchen");

		final int NUM_CARDS = 21;
	}

	@Test
	public void accusationTest() {
		Solution solution = new Solution("Liam Neeson", "Pipe", "Kitchen");
		Assert.assertTrue(brd.checkAccusation("Liam Neehjson", "Pipe", "Kitchen")); //check to see if the checkAccusation is working
		Assert.assertFalse(brd.checkAccusation("Michael Jordan", "Pipe", "Kitchen")); //make sure when the name is wrong, it is false
		Assert.assertFalse(brd.checkAccusation("Liam Neeson", "Rope", "Kitchen")); //make sure when the weapon is wrong, it is false
		Assert.assertFalse(brd.checkAccusation("Liam Neeson", "Pipe", "Lounge")); //make sure when the room is wrong, it is false
		}
	@Test
	public void computerSuggestionTest() { //have to suggest the ropom that you are in???
		ComputerPlayer player = new ComputerPlayer();
		Card seenWep = new Card("Weapon", "Pipe" );
		Card seenPlayer = new Card("Player", "Teen Mom" );
		Card seenRoom = new Card("Room", "Kitchen" );
		player.updateSeen(seenWep);
		int seenCards = player.seenCards.size();
		Assert.assertEquals(seenCards, 1); //checks to see if upsateSeen() is working
		Assert.assertFalse(player.seenCards.contains(seenPlayer)); //makes sure the player card is not in the seen list
		Assert.assertFalse(player.seenCards.contains(seenRoom));
	}

	@Test
	public void testTargetRandomSelection() {
		ComputerPlayer player = new ComputerPlayer();
		// Pick a location with no rooms in target, just three targets
		brd.calcTargets(brd.calcIndex(0, 5), 1);
		int loc_12_0Tot = 0;
		int loc_14_2Tot = 0;
		int loc_15_4Tot = 0;
		// Run the test 100 times
		for (int i=0; i<100; i++) {
			BoardCell selected = player.pickLocation(brd.getTargets(5,1));
			if (selected == brd.getCellAt(brd.calcIndex(0, 6)))
				loc_12_0Tot++;
			else if (selected == brd.getCellAt(brd.calcIndex(1, 5)))
				loc_14_2Tot++;
			else if (selected == brd.getCellAt(brd.calcIndex(0,4)))
				loc_15_4Tot++;
			else
				Assert.fail("Invalid target selected");
		}
		// Ensure we have 100 total selections (fail should also ensure)
		System.out.println(loc_12_0Tot + loc_14_2Tot + loc_15_4Tot);
		Assert.assertEquals(100, loc_12_0Tot + loc_14_2Tot + loc_15_4Tot);
		// Ensure each target was selected more than once
		System.out.println(loc_12_0Tot);
		System.out.println(loc_14_2Tot);
		System.out.println(loc_15_4Tot);

		
		Assert.assertTrue(loc_12_0Tot > 10);
		Assert.assertTrue(loc_14_2Tot > 10);
		Assert.assertTrue(loc_15_4Tot > 10);
						
	}
	@Test
	public void disproveSuggestion() { //not getting the name of the card just the address
		brd = new Board(null);
		Player player = new ComputerPlayer();

		player.myCards.add(new Card("Weapon", "Rope"));
		player.myCards.add(new Card("Person", "Teen Mom"));
		Card card = player.disproveSuggestion("Michael Jordan", "Rope", "Kitchen");
		Card test = new Card("Room", "Kitchen");
		System.out.println(test.toString());
		System.out.println(card.toString());
		Assert.assertEquals(card.toString(),test.toString()); 
		
		
		
		
		
	}
}


