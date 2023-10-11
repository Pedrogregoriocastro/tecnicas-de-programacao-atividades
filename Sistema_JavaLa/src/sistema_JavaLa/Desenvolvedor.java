package sistema_JavaLa;

public class Desenvolvedor implements Iposisionavel {
	private int posicaoX;
	private int posicaoY;
	
	public Desenvolvedor(int x, int y ) {
		posicaoX = x;
		posicaoY = y;
	}

	public int getX() {
		return posicaoX;
	}

	public int getY() {
		return posicaoY;
	}

}
