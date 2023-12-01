package controller;

public abstract class Planetas extends Relatorio implements Iposisionavel {
	protected String nome;
	protected boolean seExplodiu = false;
	protected int posicaoX;
	protected int posicaoY;
	protected int velocidade;
	protected int limiteSuperiorX;
	protected int limiteInferiorX;
	protected int limiteSuperiorY;
	protected int limiteInferiorY;
	protected int posicaoInicialX;
	protected int posicaoInicialY;
	protected float tempoDeRotacao;
	protected int tempoDoInstante;

	public Planetas(String nome) {
		this.nome = nome;
	}
	
	
	
	public int getTempoDoInstante() {
		return tempoDoInstante;
	}

	public void setTempoDoInstante(int tempoDoInstante) {
		this.tempoDoInstante = tempoDoInstante;
	}



	public String getNome() {
		return nome;
	}
	
	
	public float caucularDiasDoInstante() {
		float dias = tempoDeRotacao * tempoDoInstante;
		atualizarDias(dias);
		return dias;
		
	}
	
	private void calcularAnos(int posicaoX, int posicaoY) {
		if (posicaoX == posicaoInicialX && posicaoY == posicaoInicialY) {
			atualizarAnos(1);
		}
	}
	
	public void translacionar() {
		int i = 0;
		while (i<velocidade*tempoDoInstante) {
			++i;
			
			if (posicaoX==limiteSuperiorX && posicaoY>limiteInferiorY) {
				posicaoY--;
			} else if (posicaoX>limiteInferiorX && posicaoY==limiteInferiorY) {
				posicaoX--;
			} else if (posicaoX<limiteSuperiorX && posicaoY==limiteSuperiorY) {
				posicaoX++;
			} else if (posicaoX==limiteInferiorX && posicaoY<limiteSuperiorY) {
				posicaoY++;
			}
			calcularAnos(posicaoX, posicaoY);
		}
		
	}
	
}
