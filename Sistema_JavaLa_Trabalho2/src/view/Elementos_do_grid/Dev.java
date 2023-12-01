package view.Elementos_do_grid;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

public class Dev extends JLabel implements Elementos{
	protected int posX;
	protected int posY;
	protected ImageIcon icone = new ImageIcon("imagens/Dev.png");
	
	public Dev() {
		setIcon(icone);
		setSize(20, 20);
		setHorizontalAlignment(CENTER);
		setToolTipText("Dev");
		setBorder(new LineBorder(Color.decode("#4C0B78"), 1));
		setVisible(true);
	}
}
