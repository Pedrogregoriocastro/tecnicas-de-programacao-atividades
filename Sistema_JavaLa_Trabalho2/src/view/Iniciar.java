package view;

import model.leitura_de_arquivos.LeitorDeArquivo;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JFrame;

import controller.*;

public class Iniciar extends JFrame {
	
	GridDoSistema Grid = new GridDoSistema();
	JavaLarSystem jogo = new JavaLarSystem(Grid);
	Interface_de_botoes controles = new Interface_de_botoes();
	Gerenciador_De_Reports Reportar = new Gerenciador_De_Reports();
	
	public Iniciar () {
		setLayout(new BorderLayout());
		setTitle("Javalar");
		setSize(1000,750);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false); 
		setLocationRelativeTo(null);
		add(controles);
		add(Grid, BorderLayout.CENTER);
		add(new PlanoDeFundo(), BorderLayout.CENTER);
		controles();
		setVisible(true);	
	}
	
	public void controles() {
		controles.getProximoInstante().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jogo.Jogar();
				
			}
		});
		
		controles.getLerArquivo().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new LeitorDeArquivo();
				
			}
		});
		
		controles.getGravarRelatorio().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jogo.run();
				
			}
		});
		
		controles.getLerDadosDeOutros().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Reportar.run();;
				
			}
		});
		
		controles.getGravarArquivo().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Reportar.GerarArquivoDeSaida();
				
			}
		});
	}
	
	public static void main(String[] args) {
		new Iniciar();
	}
}