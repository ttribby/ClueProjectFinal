package clueGame;

import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class MyCards extends JPanel {
	public MyCards(HumanPlayer currentPlayer){
		setSize(200,200);
		setBorder(new TitledBorder(new EtchedBorder(), "myCards"));	
		for(Card c:currentPlayer.myCards){
			add(new CardDisplay(c));
		}
	}
}
