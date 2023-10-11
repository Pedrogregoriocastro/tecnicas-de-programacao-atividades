package sistema_JavaLa;

public class Cpp extends Planetas {
	
	public Cpp(String nome) {
		super(nome);
		this.posicaoX = 13;
		this.posicaoY = 7;
		this.velocidade = 2;
		this.limiteInferiorX = 1;
		this.limiteSuperiorX = 13;
		this.limiteInferiorY = 1;
		this.limiteSuperiorY = 13;
		this.posicaoInicialX = 13;
		this.posicaoInicialY = 7;
		this.tempoDeRotacao = (float) 0.5;
	}
	
	public int getX() {
		return posicaoX;
	}

	public int getY() {
		return posicaoY;
	}

	public void ResumoDaLinguagem() {
		System.out.println("C++ e uma linguagem de programacao que tambem deriva da linguagem C e tambem e orientada a objetos,\nela e usada amplamente pelos desenvolvedores para programar aplicativos e jogos");
		
	}
}
