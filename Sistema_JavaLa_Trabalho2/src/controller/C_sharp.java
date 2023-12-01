package controller;

public class C_sharp extends Planetas {
	
	public C_sharp(String nome) {
		super(nome);
		this.posicaoX = 12;
		this.posicaoY = 7;
		this.velocidade = 1;
		this.limiteInferiorX = 2;
		this.limiteSuperiorX = 12;
		this.limiteInferiorY = 2;
		this.limiteSuperiorY = 12;
		this.posicaoInicialX = 12;
		this.posicaoInicialY = 7;
		this.tempoDeRotacao = 4;
	}
	
	public int getX() {
		return posicaoX;
	}

	public int getY() {
		return posicaoY;
	}
	
	public void ResumoDaLinguagem() {
		System.out.println("C# e uma linguagem de programacao orientada a objetos e a componentes que deriva-se tambem da linguagem C, o\nC# tem como caracteristica a geracao de codigo eficiente");
		
	}
}
