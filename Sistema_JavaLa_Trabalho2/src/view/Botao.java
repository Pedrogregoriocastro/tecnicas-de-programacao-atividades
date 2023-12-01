package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import java.awt.Font;

public class Botao extends JButton{
	 
	public Botao(String nome) {
		setPreferredSize(new Dimension(150, 80));
		setForeground(Color.WHITE);
		setToolTipText(nome);
		setText(nome);
		setBorderPainted(false);
		setFocusPainted(false);
		setBackground(Color.decode("#1E2291"));
		setFont(new Font("Agency FB", Font.BOLD , 12));
		setSize(150, 200);
		setVisible(true);
	}
}
