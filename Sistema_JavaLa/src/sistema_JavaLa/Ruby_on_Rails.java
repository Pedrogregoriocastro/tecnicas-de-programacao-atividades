package sistema_JavaLa;

public class Ruby_on_Rails extends Planetas {
	
	public Ruby_on_Rails(String nome) {
		super(nome);
		this.posicaoX = 10;
		this.posicaoY = 7;
		this.velocidade = 2;
		this.limiteInferiorX = 4;
		this.limiteSuperiorX = 10;
		this.limiteInferiorY = 4;
		this.limiteSuperiorY = 10;
		this.posicaoInicialX = 10;
		this.posicaoInicialY = 7;
		this.tempoDeRotacao = 48;
	}
	
	public int getX() {
		return posicaoX;
	}

	public int getY() {
		return posicaoY;
	}

	public void ResumoDaLinguagem() {
		System.out.println("Ruby on Rails e uma linguagem de programacao que foi criado para desenvolver aplicações web para startups\ne foi totalmente inspirado no desenvolvimento ágil utilizado nesse tipo de empresa");
		
	}
}
