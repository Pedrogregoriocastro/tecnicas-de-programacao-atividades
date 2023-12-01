package view.Elementos_do_grid;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class Bug extends JLabel implements Elementos {
	
	protected int posX;
	protected int posY;
	protected ImageIcon icone = new ImageIcon("imagens/Bug.png");
	
	public Bug() {
		setIcon(icone);
		setSize(20, 20);
		setHorizontalAlignment(CENTER);
		setToolTipText("Bug");
		setBorder(new LineBorder(Color.decode("#4C0B78"), 1));
		setVisible(true);
	}
}
