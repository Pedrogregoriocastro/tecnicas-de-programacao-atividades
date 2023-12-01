package controller;


import javax.swing.JOptionPane;
import model.leitura_de_arquivos.JavalarArquivos;
import java.util.Random;
import java.util.ArrayList;

import model.Banco_de_Dados.JavaLarSystemDAO_Upload;
import model.leitura_de_arquivos.Instante;
import view.GridDoSistema;


public class JavaLarSystem extends Plano implements Runnable {
	private ArrayList<Instante> dados = JavalarArquivos.dados;
	public ArrayList<Planetas> planetasLista = new ArrayList<>();
	private int numeroTotalDeBugs = 0;
	private int numeroTotalDeDesenvolvedores = 0;
	private int numeroDeInstantesSolicitados = 0;
	private Random sorteador = new Random();
	private JavaLarSystemDAO_Upload upload = new JavaLarSystemDAO_Upload();
	int a = 0;
	
	GridDoSistema Grid = null;
	
	public JavaLarSystem(GridDoSistema Grid) {
		
		this.Grid = Grid;
		
		planetasLista.add(new Python("Python"));
		planetasLista.add(new JavaScript("JavaScript"));
		planetasLista.add(new Ruby_on_Rails("Ruby on Rails"));
		planetasLista.add(new PHP("PHP"));
		planetasLista.add(new C_sharp("C#"));
		planetasLista.add(new Cpp("C++"));
		planetasLista.add(new C("C"));
		
		for (Planetas lista : planetasLista) {
			posicionarPlanetas(lista.getX(), lista.getY() , lista);
		}
		posicionarPlanetas(7, 7, new Java());
		
		
	}

	
	public void Jogar() {

		try {

			int n1 = 0;
			int n2 = 0;
			if (a == dados.size() && a == 0) {
				JOptionPane.showMessageDialog(null, "Selecione um arquivo de entrada");
			}else if (a == dados.size()) {
				JOptionPane.showMessageDialog(null, "Fim do arquivo de entrada");
				a=0;
			}else {	

				atualizarTempoDoInstante();

				System.out.print("\tNumero Total de Desenvolvedores: " + numeroTotalDeDesenvolvedores);
				System.out.print("\tNumero Total de Bugs: " + numeroTotalDeBugs);
				System.out.println("\n");
				System.out.println(" -> Quantos desenvolvedores voce deseja adicionar no plano?");
				n1 = dados.get(a).getDev();
				System.out.println(n1);
				System.out.println(" -> Quantos bugs voce deseja adicionar no plano?");
				n2 =  dados.get(a).getBug();
				System.out.println(n2);
				numeroTotalDeDesenvolvedores += n1;
				numeroTotalDeBugs += n2;
				adicionarDesenvolvedores();
				adicionarBugs();
				System.out.print("\n");
				System.out.print("\tNumero Total de Desenvolvedores: " + numeroTotalDeDesenvolvedores);
				System.out.print("\tNumero Total de Bugs: " + numeroTotalDeBugs);
				System.out.println("\n");


				++numeroDeInstantesSolicitados;
				System.out.print("\tNumero Inicial de Desenvolvedores na Rodada: " + numeroTotalDeDesenvolvedores);
				System.out.print("\t Numero Inicial de Bugs na Rodada: " + numeroTotalDeBugs);
				System.out.println("\n");
				translacionarPlanetas();
				verificarExplosoes();
				Scannear_Quadrantes();
				System.out.print("\tNumero Final de Desenvolvedores na Rodada: " + numeroTotalDeDesenvolvedores);
				System.out.print("\tNumero Final de Bugs na Rodada: " + numeroTotalDeBugs);
				System.out.println("\n\n");

				System.out.println("Dias (Em Horas) que se passaram em cada planeta\n ");
				rotacionarPlanetas();
				System.out.println("Anos que se passaram em cada planeta\n");
				avisarAnoNovo();
				++a;

				Grid.atualizarGrid(RetornarPosicoesPlanetas(), RetornarPosicoesDevs(), RetornarPosicoesBugs());



			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Arquivo de entrada inexistente, selecione um com a opção Ler Novo Arquivo de Entrada");
		}
	}
	
	
	private void verificarExplosoes() {
		for (Planetas planeta : planetasLista) {
			if (planeta.velocidade == 0 && !planeta.seExplodiu) {
				planeta.seExplodiu = true;
				System.out.println("\n\t" + "| " + planeta.getNome() + " EXPLODIU!!!!!!! |\n");
			}
		}
	}
	
 	private void translacionarPlanetas() {
		int E ;
		
		
		for (Planetas planeta : planetasLista) {
			
			
			if (!planeta.seExplodiu) {
				
				limparConteudoDaCelula(planeta.getX(), planeta.getY());
				
				planeta.salvarVelocidade(planeta.velocidade);
				
				planeta.translacionar();

				E = reposicionarPlanetas(planeta.getX(), planeta.getY(), planeta);


				if (E == 1) {
					++planeta.velocidade;
					++planeta.DesenvolvedoresColididos;
					--numeroTotalDeDesenvolvedores;
					System.out.println("\tINFORMACAO: \n" + "\t" + planeta.getNome() + " foi atingido por um desenvolvedor " + "\t\t" + planeta.getNome() + " ficou mais rapido!!!");
					System.out.print("\t- Velocidade anterior do Planeta " + planeta.getNome() + ": " + (-1+planeta.velocidade) + " ");
				} else if (E == 2) {
					--planeta.velocidade;
					++planeta.BugsColididos;
					--numeroTotalDeBugs;
					System.out.println("\tINFORMACAO: \n" + "\t" + planeta.getNome() + " foi atingido por um Bug " + "\t\t" + planeta.getNome() + " ficou mais lento!!!");
					System.out.print("\t- Velocidade anterior do Planeta " + planeta.getNome() + ": " + (1+planeta.velocidade) + " ");
					
				} else if (E == 3) {
					System.out.println("nao foi feito o procedimento no planeta " + planeta.getNome());
				}
				System.out.print("\t+ Velocidade atual do Planeta " + planeta.getNome() + ": " + planeta.velocidade + "\n");
				System.out.print("\t+ Posicao atual do Planeta " + planeta.getNome() + " (" + planeta.getX() + "," + planeta.getY() + ")\n\n");
			}
		}
	}

	private void atualizarTempoDoInstante() throws NullPointerException {
		planetasLista.get(0).setTempoDoInstante(dados.get(a).getPython());
		planetasLista.get(1).setTempoDoInstante(dados.get(a).getJavaScript());
		planetasLista.get(2).setTempoDoInstante(dados.get(a).getRubyOnRails());
		planetasLista.get(3).setTempoDoInstante(dados.get(a).getPHP());
		planetasLista.get(4).setTempoDoInstante(dados.get(a).getCsharp());
		planetasLista.get(5).setTempoDoInstante(dados.get(a).getCpp());
		planetasLista.get(6).setTempoDoInstante(dados.get(a).getC());
		
	}
	
	private void adicionarDesenvolvedores() throws NullPointerException {
		int E;
		int x = 0;
		int y = 0;
		for (int i = 0; i < dados.get(a).getDev(); i++) {
			do {
				x = sorteador.nextInt(14);
				y = sorteador.nextInt(14);
				E = adicionarDesenvolvedores(x, y, new Desenvolvedor(x, y));
			} while (E == 2 || E == 3);
			if (E == 1) {
				--numeroTotalDeBugs;
			}
		}			
	}
	
	private void adicionarBugs() throws NullPointerException {
		int E;
		int x = 0;
		int y = 0;
		for (int i = 0; i < dados.get(a).getBug(); i++) {
			do {
				x = sorteador.nextInt(14);
				y = sorteador.nextInt(14);
				E = adicionarBugs(x, y, new Bug(x, y));
			} while (E == 2 || E == 3);
			if (E == 1) {
				--numeroTotalDeDesenvolvedores;
			}
		}			
	}
	
	
	private void rotacionarPlanetas() {
		float N = 0f;
		for (Planetas planeta : planetasLista) {
			if (!planeta.seExplodiu) {
				N = planeta.caucularDiasDoInstante();
			}
			System.out.printf("\tDado o tempo do instante " + planeta.getTempoDoInstante() + " no o planeta " + planeta.getNome() + " passaram-se " + "%.1f" + " dias (Em Horas) \n\n", N);
		}
	}
	
	private void avisarAnoNovo() {
		for (Planetas planeta : planetasLista) {
			if (!planeta.seExplodiu) {
				if (planeta.AnosJavaLa > planeta.getAnoanterior()) {
					System.out.println("\tO planeta " + planeta.getNome() + " completou " + planeta.AnosJavaLa + " anos JavaLa \n\n");
				}
			}
		}
	}
	
	private void FazerUpload() {
		upload.EnviarDados(this);
	}
	
	@Override
	public void run() {
		FazerUpload();
	}
	
}
