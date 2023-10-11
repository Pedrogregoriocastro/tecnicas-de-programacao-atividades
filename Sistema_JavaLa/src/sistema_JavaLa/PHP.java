package sistema_JavaLa;

public class PHP extends Planetas {
	
	public PHP(String nome) {
		super(nome);
		this.posicaoX = 11;
		this.posicaoY = 7;
		this.velocidade = 2;
		this.limiteInferiorX = 3;
		this.limiteSuperiorX = 11;
		this.limiteInferiorY = 3;
		this.limiteSuperiorY = 11;
		this.posicaoInicialX = 11;
		this.posicaoInicialY = 7;
		this.tempoDeRotacao = 60;
	}
	
	public int getX() {
		return posicaoX;
	}

	public int getY() {
		return posicaoY;
	}

	public void ResumoDaLinguagem() {
		System.out.println("PHP é uma linguagem de script open source de uso geral, muito utilizada, e\nespecialmente adequada para o desenvolvimento web e que pode ser embutida dentro do HTML");
		
	}
}
