package sistema_JavaLa;

public class C extends Planetas {
	
	public C(String nome) {
		super(nome);
		this.posicaoX = 14;
		this.posicaoY = 7;
		this.velocidade = 10;
		this.limiteInferiorX = 0;
		this.limiteSuperiorX = 14;
		this.limiteInferiorY = 0;
		this.limiteSuperiorY = 14;
		this.posicaoInicialX = 14;
		this.posicaoInicialY = 7;
		this.tempoDeRotacao = (float) 0.1;
	}
	
	public int getX() {
		return posicaoX;
	}

	public int getY() {
		return posicaoY;
	}

	public void ResumoDaLinguagem() {
		System.out.println("C e uma linguagem de programacao de baixo nivel criada em 1972 e existe desde antes da internet,\ne uma linguagem que a maquina consegue entender com facilidade,\ne foi utilizada para criar sistemas operacionais");
		
	}
}
