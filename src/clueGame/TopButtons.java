package clueGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TopButtons extends JPanel{
	private Board b;
	private BottomButtons bb;
	private TopButtons me;
	private JTextField playerName;
	public TopButtons(Board b,BottomButtons bb){
		me = this;
		this.b = b;
		this.bb = bb;
		JButton nextPlayer = new JButton();		
		nextPlayer.setText("Next Player");
		nextPlayer.addActionListener(new NextPlayer());
		JButton makeAnAccusation = new JButton();
		makeAnAccusation.setText("Make an accusation");
		makeAnAccusation.addActionListener(new MakeAnAccusation());
		JLabel whoseTurn = new JLabel();
		whoseTurn.setText("Whose turn?");
		JTextField playerName = new JTextField();
		this.playerName = playerName;
		playerName.setText("Colonel Mustard");
		playerName.setEditable(false);
		add(whoseTurn);
		add(playerName);
		nextPlayer.setSize(100,50);
		add(nextPlayer);
		add(makeAnAccusation);
	}
	private class NextPlayer implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{
			b.nextPlayer(bb,me);
			
			System.out.println("Button pressed");
		}
	}
	private class MakeAnAccusation implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{
			b.clueGame.displayAccusationPanel();		
		}
	}
	public void setPlayersName(String name){
		playerName.setText(name);
	}
}
