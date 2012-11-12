package clueGame;



import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class ClueGame extends JFrame{
	public static int EXIT_ON_CLOSE;
	public MyCards mc;
	ClueGame() {
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("hi");
		setSize(600,550);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuBar.add(createFileMenu());
	    Board b = new Board();
	    add (b,BorderLayout.CENTER);
	    b.deal();
	    mc = new  MyCards(b.you);
	    mc.setLayout(new BoxLayout( mc, BoxLayout.Y_AXIS ) );
	    add(mc,BorderLayout.EAST);
	    SouthDisplay sd = new SouthDisplay();
	    sd.setLayout(new BoxLayout( sd, BoxLayout.Y_AXIS ) );
	    add(sd,BorderLayout.SOUTH);
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
}
