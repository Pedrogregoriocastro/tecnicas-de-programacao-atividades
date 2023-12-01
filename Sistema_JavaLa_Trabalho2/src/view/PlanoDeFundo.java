package view;


import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlanoDeFundo extends JPanel {
	
	private ImageIcon imagem = new ImageIcon("imagens/espaco(2).jpeg");
	private JLabel painel;

	public PlanoDeFundo() {
		setVisible(true);
		setPreferredSize(new Dimension(1000, 750));
		painel = new JLabel();
		painel.setIcon(imagem);
		add(painel);
	}
	
	
}
