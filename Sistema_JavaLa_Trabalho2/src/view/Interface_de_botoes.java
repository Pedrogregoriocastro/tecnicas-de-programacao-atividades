package view;

import javax.swing.JPanel;
public class Interface_de_botoes extends JPanel {
	
	private Botao proximoInstante = new Botao("Processar proximo instante");
	private Botao lerArquivo = new Botao("Ler novo arquivo de entrada");
	private Botao gravarRelatorio = new Botao("Gravar relatorio");
	private Botao lerDadosDeOutros = new Botao("Ler dados de outros participantes");
	private Botao gravarArquivo = new Botao("Gravar arquivo de saida");
	
	public Interface_de_botoes() {
		setSize(150, 500);
		setLocation(800, 100);
		setOpaque(false);
		
		add(proximoInstante);
		add(lerArquivo);
		add(gravarRelatorio);
		add(lerDadosDeOutros);
		add(gravarArquivo);
		setVisible(true);
	}

	public Botao getProximoInstante() {
		return proximoInstante;
	}

	public Botao getLerArquivo() {
		return lerArquivo;
	}

	public Botao getGravarRelatorio() {
		return gravarRelatorio;
	}

	public Botao getLerDadosDeOutros() {
		return lerDadosDeOutros;
	}

	public Botao getGravarArquivo() {
		return gravarArquivo;
	}
	
}
