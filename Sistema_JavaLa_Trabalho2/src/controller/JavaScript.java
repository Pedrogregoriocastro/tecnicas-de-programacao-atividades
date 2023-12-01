package controller;

public class JavaScript extends Planetas {
	
	public JavaScript(String nome) {
		super(nome);
		this.posicaoX = 9;
		this.posicaoY = 7;
		this.velocidade = 3;
		this.limiteInferiorX = 5;
		this.limiteSuperiorX = 9;
		this.limiteInferiorY = 5;
		this.limiteSuperiorY = 9;
		this.posicaoInicialX = 9;
		this.posicaoInicialY = 7;
		this.tempoDeRotacao = 10;
	}

	public int getX() {
		return posicaoX;
	}

	public int getY() {
		return posicaoY;
	}
	
	public void ResumoDaLinguagem() {
		System.out.println("JavaScript e uma linguagem de programacao Web que e usada para\nfazer paginas interativas da internet,como graficos 2D/3D animados e mapas");
		
	}
}
