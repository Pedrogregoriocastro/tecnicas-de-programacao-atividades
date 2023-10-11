package sistema_JavaLa;

public class Celula {
	public int posicaoX;
	public int posicaoY;
	private Iposisionavel conteudo;
	
	

	public Celula(int posicaoX, int posicaoY) {
		this.posicaoX = posicaoX;
		this.posicaoY = posicaoY;
	}
	
	public void adicionarConteudo(Iposisionavel conteudo) {
		this.conteudo = conteudo;
	}
	public Iposisionavel getConteudo() {
		return conteudo;
	}
}
