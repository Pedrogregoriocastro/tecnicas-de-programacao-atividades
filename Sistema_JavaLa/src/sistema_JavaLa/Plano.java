package sistema_JavaLa;


import java.util.ArrayList;

public class Plano {
	private ArrayList<Celula> plano= new ArrayList<Celula>();
	
	
	public Plano() {
		montarPlano();
	}
	
	public void tabelar() {
		int i = 0;
		int a = 0;
		System.out.println("Desenvolvedores no plano:\n");
		while (a<225) {
			if (plano.get(a).getConteudo() == null) {

			} else if (plano.get(a).getConteudo() instanceof Desenvolvedor){
				System.out.print("X: " + plano.get(a).getConteudo().getX() + " Y: " + plano.get(a).getConteudo().getY() + "\t");
				++i;
				if (i == 6) {
					System.out.print("\n\n");
					i = 0;
				}
			}
			++a;	
		}
		a = 0;
		i = 0;
		System.out.println("\n");
		System.out.println("Bugs no plano:\n");
		while (a<225) {
			if (plano.get(a).getConteudo() == null) {

			} else if (plano.get(a).getConteudo() instanceof Bug){
				System.out.print("X: " + plano.get(a).getConteudo().getX() + " Y: " + plano.get(a).getConteudo().getY() + "\t");
				++i;
				if (i == 6) {
					System.out.print("\n\n");
					i = 0;
				}
			}
			++a;
		}
		System.out.println("\n");
	}
	
	public void limparConteudoDaCelula(int x, int y) {
		buscarCelula(x, y).adicionarConteudo(null);
	}
	
	public int reposicionarPlanetas(int x, int y , Planetas planeta) {
		int i = plano.indexOf(buscarCelula(x, y));
		
		if (plano.get(i).getConteudo() == null ) {
			plano.get(i).adicionarConteudo(planeta); 
			return 0;
		} else if (plano.get(i).getConteudo() instanceof Desenvolvedor) {
			plano.get(i).adicionarConteudo(planeta);
			return 1;
		} else if (plano.get(i).getConteudo() instanceof Bug) {
			plano.get(i).adicionarConteudo(planeta);
			return 2;
		}
		return 3;
	}
	
	public void posicionarPlanetas(int x, int y, Iposisionavel planeta) {
		buscarCelula(x, y).adicionarConteudo(planeta);
	}
	
	public boolean adicionarDesenvolvedores(int x, int y, Desenvolvedor desenvolvedor ) {
		int i = plano.indexOf(buscarCelula(x, y));
		if(plano.get(i).getConteudo() != null) {
			return true ;
		}else {
			plano.get(i).adicionarConteudo(desenvolvedor);
			return false ;
		}
	}
	
	public boolean adicionarBugs(int x, int y, Bug bug ) {
		int i = plano.indexOf(buscarCelula(x, y));
		if(plano.get(i).getConteudo() != null) {
			return true ;
		}else {
			plano.get(i).adicionarConteudo(bug);
			return false ;
		}
	}
	
	private Celula buscarCelula(int x, int y) {

		for (int i = 0; i < plano.size(); i++) {

			if(this.plano.get(i).posicaoX == x && this.plano.get(i).posicaoY == y) {
				return this.plano.get(i);
			}
		}
		return null;

	}
	
 	private void montarPlano() {
		for(int i = 0; i<15 ; i++){
			for(int j = 0; j<15 ; j++){
				Celula celula = new Celula(i, j);
				plano.add(celula);
			}
		}
	}
	
}
