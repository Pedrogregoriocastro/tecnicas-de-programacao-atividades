package sistema_JavaLa;

public class Bug implements Iposisionavel {
	private int posicaoX;
	private int posicaoY;
	
	public Bug(int x, int y ) {
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
