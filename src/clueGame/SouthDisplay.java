package clueGame;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class SouthDisplay extends JPanel {
	public TopButtons tp;
	public BottomButtons bb;
	public SouthDisplay(Board b){
		bb = new BottomButtons();
		tp = new TopButtons(b,bb);
		
		tp.setLayout(new BoxLayout( tp, BoxLayout.X_AXIS ) );
		 
		bb.setLayout(new BoxLayout( bb, BoxLayout.X_AXIS ) );
		add (tp,BorderLayout.NORTH);
		add(bb,BorderLayout.SOUTH);
		setBorder(new TitledBorder(new EtchedBorder(),"Turn Info"));
		b.firstNextPlayer(bb, tp);
		
	}
	
}
