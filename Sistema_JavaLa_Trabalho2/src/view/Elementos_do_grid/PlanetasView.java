package view.Elementos_do_grid;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public abstract class PlanetasView extends JLabel implements Elementos {
	protected ImageIcon icone = new ImageIcon("imagens/" + getClass().getSimpleName() + ".png");
	
	protected PlanetasView() {
		setIcon(icone);
		setSize(20, 20);
		setHorizontalAlignment(CENTER);
		setBorder(new LineBorder(Color.decode("#75B7BA"), 2));
		setVisible(true);
	}
	
	
	
	
	
}
