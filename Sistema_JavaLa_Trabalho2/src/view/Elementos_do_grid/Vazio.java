package view.Elementos_do_grid;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class Vazio extends JLabel implements Elementos {
	
	private int posX;
	private int posY;
	public Vazio(int x, int y) {
		setPreferredSize(new Dimension(20, 20));
		setForeground(Color.WHITE);
		setOpaque(false);
		setBorder(new LineBorder(Color.decode("#4C0B78"), 1));
		setHorizontalAlignment(CENTER);
		posX = x;
		posY = y;
		setToolTipText("x: " + x + " y: " + y);
		setVisible(true);
	}
	public int getPosX() {
		return posX;
	}
	public int getPosY() {
		return posY;
	}
	
}
