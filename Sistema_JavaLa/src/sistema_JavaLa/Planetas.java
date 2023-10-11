package sistema_JavaLa;

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


	public Planetas(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	
	public float caucularDiasDoInstante(int tempoDoInstante) {
		float dias = tempoDeRotacao * tempoDoInstante;
		atualizarDias(dias);
		return dias;
		
	}
	
	private void calcularAnos(int posicaoX, int posicaoY) {
		if (posicaoX == posicaoInicialX && posicaoY == posicaoInicialY) {
			atualizarAnos(1);
		}
	}
	
	public void translacionar(int tempoDoInstante) {
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
