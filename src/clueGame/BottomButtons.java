package clueGame;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BottomButtons extends JPanel {
	public JTextField rollResult;
	public JTextField guessResult;
	public JTextField responseResult;
	public BottomButtons(){
		JLabel dieRoll = new JLabel();
		rollResult = new JTextField();
		JLabel guess = new JLabel();
		 guessResult = new JTextField();
		JLabel response = new JLabel();
		responseResult = new JTextField();
		dieRoll.setText("Die Roll");
		rollResult.setEditable(false);
		rollResult.setText("5");
		guess.setText("Guess");
		guessResult.setText("");
		guessResult.setEditable(false);
		response.setText("Response");
		responseResult.setEditable(false);
		responseResult.setText("");
		add(dieRoll);
		add(rollResult);
		add(guess);
		add(guessResult);
		add(response);
		add(responseResult);
		setDice(diceNum);
	}
	public static int diceNum = 0;
	public void setDice(int num){
		rollResult.setText(num + "");
	}
	public void setDisplay(String guess, String response){
		guessResult.setText(guess);
		responseResult.setText(response);
	}
	
}
