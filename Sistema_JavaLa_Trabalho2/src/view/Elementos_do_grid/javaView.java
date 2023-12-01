package view.Elementos_do_grid;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class javaView extends JLabel implements Elementos {
	
	private ImageIcon icone = new ImageIcon("imagens/java.png");
	
	public javaView() {
		setIcon(icone);
		setToolTipText("Java");
		setSize(20, 20);
		setHorizontalAlignment(CENTER);
		setBorder(new LineBorder(Color.decode("#75B7BA"), 2));
		setVisible(true);
	}
}
