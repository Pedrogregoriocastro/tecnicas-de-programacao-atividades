package sistema_JavaLa;

import java.util.ArrayList;

abstract public class Relatorio {
	protected int DesenvolvedoresColididos = 0;
	protected int BugsColididos = 0;
	protected int anoAnterior = 0;
	protected int AnosJavaLa = 0;
	protected float diasPassados = 0;
	protected ArrayList<Integer> HistoricoDeVelocidades = new ArrayList<>();
	
	public void atualizarDias(float dias) {
		diasPassados += dias;
	}
	
	private void setarAnoAnterior() {
		anoAnterior = AnosJavaLa;
	}
	
	public void atualizarAnos(int novoAno) {
		AnosJavaLa += novoAno;
	}
	
	public int getAnoanterior() {
		int memoria = anoAnterior;
		setarAnoAnterior();
		return memoria;
	}
	
	public void salvarVelocidade(int velocidade) {
		HistoricoDeVelocidades.add(velocidade);
	}
	
	public float caucularVelocidadeMedia() {
		int acumulador = 0;
		for (Integer velocidade : HistoricoDeVelocidades) {
			acumulador += velocidade;
		}
		if (HistoricoDeVelocidades.size() == 0) {
			return 0;
		} else {
			return acumulador/HistoricoDeVelocidades.size();
		}
	}
	
	public abstract void ResumoDaLinguagem();
}
