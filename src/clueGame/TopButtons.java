package clueGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TopButtons extends JPanel{
	public TopButtons(){
		JButton nextPlayer = new JButton();		
		nextPlayer.setText("Next Player");
		nextPlayer.addActionListener(new NextPlayer());
		JButton makeAnAccusation = new JButton();
		makeAnAccusation.setText("Make an accusation");
		makeAnAccusation.addActionListener(new MakeAnAccusation());
		JLabel whoseTurn = new JLabel();
		whoseTurn.setText("Whose turn?");
		JTextField playerName = new JTextField();
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
			int raa =(new Random(6)).nextInt();
			BottomButtons.diceNum = raa;
			System.out.println("Button pressed");
		}
	}
	private class MakeAnAccusation implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{
			System.out.println("Button pressed");
		}
	}

}
