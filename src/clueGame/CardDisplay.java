package clueGame;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class CardDisplay extends JPanel{
	public CardDisplay(Card c){
		
		setBorder(new TitledBorder(new EtchedBorder(), c.cardType + ""));
		JLabel cardName = new JLabel();
		cardName.setText(c.name + "");
		add(cardName);
	}

}
