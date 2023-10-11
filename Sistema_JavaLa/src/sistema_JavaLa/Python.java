package sistema_JavaLa;

public class Python extends Planetas {
	
	public Python(String nome) {
		super(nome);
		this.posicaoX = 8;
		this.posicaoY = 7;
		this.velocidade = 4;
		this.limiteInferiorX = 6;
		this.limiteSuperiorX = 8;
		this.limiteInferiorY = 6;
		this.limiteSuperiorY = 8;
		this.posicaoInicialX = 8;
		this.posicaoInicialY = 7;
		this.tempoDeRotacao = 24;
	}
	
	
	public int getX() {
		return posicaoX;
	}

	public int getY() {
		return posicaoY;
	}

	public void ResumoDaLinguagem() {
		System.out.println("Python e uma linguagem de programacao amplamente usada em aplicacoes Web,\ndesenvolvimento de software, ciencia de dados e machine learning(ML)");
		
	}

}