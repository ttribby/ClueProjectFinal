package clueGame;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class SouthDisplay extends JPanel {
	public TopButtons tp;
	public BottomButtons bb;
	public SouthDisplay(){
		tp = new TopButtons();
		tp.setLayout(new BoxLayout( tp, BoxLayout.X_AXIS ) );
		 bb = new BottomButtons();
		bb.setLayout(new BoxLayout( bb, BoxLayout.X_AXIS ) );
		add (tp,BorderLayout.NORTH);
		add(bb,BorderLayout.SOUTH);
		setBorder(new TitledBorder(new EtchedBorder(),"Turn Info"));
	}
}
