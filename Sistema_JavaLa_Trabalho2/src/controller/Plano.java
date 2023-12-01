package controller;


import java.util.ArrayList;

public class Plano {
	private ArrayList<Celula> plano= new ArrayList<Celula>();
	
	protected int BugsQ1 = 0;
	protected int BugsQ2 = 0;
	protected int BugsQ3 = 0;
	protected int BugsQ4 = 0;
	protected int DevsQ1 = 0;
	protected int DevsQ2 = 0;
	protected int DevsQ3 = 0;
	protected int DevsQ4 = 0;
	
	public Plano() {
		montarPlano();
	}
	
	public void Scannear_Quadrantes() {
		int d_Q1 = 0;
		int b_Q1 = 0;
		for (int x = 0; x <= 6; x++) {
			for (int y = 0; y <= 6; y++) {
				if (buscarCelula(x, y).getConteudo() instanceof Desenvolvedor) {
					d_Q1++;
				} else if (buscarCelula(x, y).getConteudo() instanceof Bug) {
					b_Q1++;
				}
			}
		}
		int d_Q2 = 0;
		int b_Q2 = 0;
		for (int x = 8; x <= 14; x++) {
			for (int y = 0; y <= 6; y++) {
				if (buscarCelula(x, y).getConteudo() instanceof Desenvolvedor) {
					d_Q2++;
				} else if (buscarCelula(x, y).getConteudo() instanceof Bug) {
					b_Q2++;
				}
			}
		}
		int d_Q3 = 0;
		int b_Q3 = 0;
		for (int x = 0; x <= 6; x++) {
			for (int y = 8; y <= 14; y++) {
				if (buscarCelula(x, y).getConteudo() instanceof Desenvolvedor) {
					d_Q3++;
				} else if (buscarCelula(x, y).getConteudo() instanceof Bug) {
					b_Q3++;
				}
			}
		}
		int d_Q4 = 0;
		int b_Q4 = 0;
		for (int x = 8; x <= 14; x++) {
			for (int y = 8; y <= 14; y++) {
				if (buscarCelula(x, y).getConteudo() instanceof Desenvolvedor) {
					d_Q4++;
				} else if (buscarCelula(x, y).getConteudo() instanceof Bug) {
					b_Q4++;
				}
			}
		}
		
		DevsQ1 = d_Q1;
		DevsQ2 = d_Q2;
		DevsQ3 = d_Q3;
		DevsQ4 = d_Q4;
		BugsQ1 = b_Q1;
		BugsQ2 = b_Q2;
		BugsQ3 = b_Q3;
		BugsQ4 = b_Q4;
		
	}
	
	
	protected void limparConteudoDaCelula(int x, int y) {
		buscarCelula(x, y).adicionarConteudo(null);
	}
	
	protected int reposicionarPlanetas(int x, int y , Planetas planeta) {
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
	
	protected void posicionarPlanetas(int x, int y, Iposisionavel planeta) {
		buscarCelula(x, y).adicionarConteudo(planeta);
	}
	
	protected int adicionarDesenvolvedores(int x, int y, Desenvolvedor desenvolvedor ) {
		int i = plano.indexOf(buscarCelula(x, y));
		if(plano.get(i).getConteudo() instanceof Bug ) {
			plano.get(i).adicionarConteudo(desenvolvedor);
			return 1 ;
			
		}else if (plano.get(i).getConteudo() instanceof Desenvolvedor ) {
			return 2 ;
			
		} else if (plano.get(i).getConteudo() instanceof Planetas ) {
			return 3 ;
			
		}else if (plano.get(i).getConteudo() instanceof Java) {
			return 3 ;
			
		} else {
			plano.get(i).adicionarConteudo(desenvolvedor);
			return 4 ;
		}
	}
	
	protected int adicionarBugs(int x, int y, Bug bug ) {
		int i = plano.indexOf(buscarCelula(x, y));
		if(plano.get(i).getConteudo() instanceof Desenvolvedor ) {
			plano.get(i).adicionarConteudo(bug);
			return 1 ;
			
		}else if (plano.get(i).getConteudo() instanceof Bug ) {
			return 2 ;

		} else if (plano.get(i).getConteudo() instanceof Planetas) {
			return 3 ;
			
		}else if (plano.get(i).getConteudo() instanceof Java) {
			return 3 ;
			
		}else {
			plano.get(i).adicionarConteudo(bug);
			return 4 ;
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
	
 	public int[] RetornarPosicoesPlanetas() {
		 	
	 	int posicoesPlanetas[] = new int[7];
		
		for (int i = 0; i < plano.size(); i++) {
			if (plano.get(i).getConteudo() instanceof Python) {
				posicoesPlanetas[0] = i;
				
			} else if(plano.get(i).getConteudo() instanceof JavaScript){
				posicoesPlanetas[1] = i;
				
			} else if(plano.get(i).getConteudo() instanceof Ruby_on_Rails){
				posicoesPlanetas[2] = i;
				
			} else if(plano.get(i).getConteudo() instanceof PHP){
				posicoesPlanetas[3] = i;
				
			} else if(plano.get(i).getConteudo() instanceof C_sharp){
				posicoesPlanetas[4] = i;
				
			} else if(plano.get(i).getConteudo() instanceof Cpp){
				posicoesPlanetas[5] = i;
				
			} else if(plano.get(i).getConteudo() instanceof C){
				posicoesPlanetas[6] = i;
			}
		}
		
		return posicoesPlanetas;
		
	}
 	public ArrayList<Integer> RetornarPosicoesBugs() {
 		ArrayList<Integer> posicoesBugs = new ArrayList<Integer>();
 		for (int i = 0; i < plano.size(); i++) {
			if (plano.get(i).getConteudo() instanceof Bug) {
				posicoesBugs.add(i);
			}
		}
 		return posicoesBugs;
 	}
 	public ArrayList<Integer> RetornarPosicoesDevs() {
 		ArrayList<Integer> posicoesDevs = new ArrayList<Integer>();
 		for (int i = 0; i < plano.size(); i++) {
			if (plano.get(i).getConteudo() instanceof Desenvolvedor) {
				posicoesDevs.add(i);
			}
		}
 		return posicoesDevs;
	}

	public int getBugsQ1() {
		return BugsQ1;
	}

	public int getBugsQ2() {
		return BugsQ2;
	}

	public int getBugsQ3() {
		return BugsQ3;
	}

	public int getBugsQ4() {
		return BugsQ4;
	}

	public int getDevsQ1() {
		return DevsQ1;
	}

	public int getDevsQ2() {
		return DevsQ2;
	}

	public int getDevsQ3() {
		return DevsQ3;
	}

	public int getDevsQ4() {
		return DevsQ4;
	}
 	
}
