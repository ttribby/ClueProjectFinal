package clueGame;



import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class ClueGame extends JFrame{
	public static int EXIT_ON_CLOSE;
	public MyCards mc;
	private AccusationPanel accusationPanel;
	private SuggestionPanel suggestionPanel;
	public Board b;
	private SouthDisplay sd;
	
	ClueGame() {
//		JOptionPane.showMessageDialog(this, "you are darth vader", "Welcome to clue" ,JOptionPane.INFORMATION_MESSAGE);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Clue Game");
		setSize(600,550);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuBar.add(createFileMenu());
	    Board b = new Board(this);
	    this.b = b;
	    add (b,BorderLayout.CENTER);
	    b.deal();
	    mc = new  MyCards(b.you);
	    mc.setLayout(new BoxLayout( mc, BoxLayout.Y_AXIS ) );
	    add(mc,BorderLayout.EAST);
	    sd = new SouthDisplay(b);
	    sd.setLayout(new BoxLayout( sd, BoxLayout.Y_AXIS ) );
	    add(sd,BorderLayout.SOUTH);
	    accusationPanel = new AccusationPanel(b);
	    //suggestionPanel = new SuggestionPanel(b,"error",new Player());
	}
	private JMenu createFileMenu(){
		JMenu menu = new JMenu("File");
		menu.add(createFileNotesItem());
		menu.add(createFileExitItem());
		return menu;
	}
	
	private JMenuItem createFileExitItem(){
		JMenuItem item = new JMenuItem("EXIT");
		class MenuItemListener implements ActionListener {
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		}
		item.addActionListener(new MenuItemListener());
		return item;
	}

	
	private JMenuItem createFileNotesItem(){
		JMenuItem item = new JMenuItem("Detective Notes");
		class MenuItemListener implements ActionListener {
			public void actionPerformed(ActionEvent e){
				dn.setVisible(true);
				////////run windows
			}
		}
		item.addActionListener(new MenuItemListener());
		return item;
	}
	public static detectiveNotes dn;
	public static void main(String[] args) {
		ClueGame first = new ClueGame();
	    first.setVisible(true);
	    dn = new detectiveNotes();
	   

	}
	public void invalidMoveClick(){
		JOptionPane.showMessageDialog(this, "You can't move there idiot", "Bad Move" ,JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void invalidNeedToFinishTurn(){
		JOptionPane.showMessageDialog(this, "You need to finish your turn", "Bad Move" ,JOptionPane.INFORMATION_MESSAGE);
	}
	public void displayAccusationPanel(){
		if(!b.humanTurnWasMade){
			accusationPanel.setVisible(true);
			
		}else{
			JOptionPane.showMessageDialog(this, "You Already Made Your Turn", "Bad Move" ,JOptionPane.INFORMATION_MESSAGE);
		}
	}
	public void showSuggestionPanel(String room,Player p){
		if(b.humanTurnWasMade){
			suggestionPanel = new SuggestionPanel(b,room,p);
			

			suggestionPanel.setVisible(true);		
			
		}else{
			//computer
			((ComputerPlayer)p).createSuggestion();
			String theRoom  = ((ComputerPlayer)p).suggestedRoom.name;
			String thePlayer  = ((ComputerPlayer)p).suggestedPerson.name;
			String theWeapon  = ((ComputerPlayer)p).suggestedWeapon.name;
			if(((ComputerPlayer)p).unseenCards.size() == 3){
				JOptionPane.showMessageDialog(this, "The answer is " + theRoom + " " + thePlayer + " " + theWeapon , "Computer Wins Game Over" ,JOptionPane.INFORMATION_MESSAGE);
			}
				
			Card c= ((ComputerPlayer)p).disproveSuggestion(thePlayer,theWeapon,theRoom);
			b.clueGame.setGuessDisplay(thePlayer + " " + theRoom + " " + theWeapon, c.name);
			for(Player player: b.players){
				if(player.name.equals(thePlayer)){
					player.index = ((ComputerPlayer)p).index;
				}
			}
		}

		
	}
	public void setGuessDisplay(String guess, String response){
		sd.bb.setDisplay(guess, response);
	}
}
