package sistema_JavaLa;

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class JavaLarSystem extends Plano {
	public ArrayList<Planetas> planetasLista = new ArrayList<>();
	private int numeroTotalDeBugs = 0;
	private int numeroTotalDeDesenvolvedores = 0;
	private int numeroDeInstantesSolicitados = 0;
	Scanner entrada = new Scanner(System.in);
	
	private Random sorteador = new Random();
	
	public JavaLarSystem() {
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
		
		System.out.println("===== BEM VINDO AO SISTEMA JAVALAR ===== \n");
		
		Jogar();
	}

	private void Jogar() {
		int i = 1;
		int n1 = 0;
		int n2 = 0;
		int instante = 1;
		boolean controle = true;
		do {
			System.out.print("\n\nMENU DO USUARIO \t");
			System.out.print("*Para sair digite qualquer numero*");
			System.out.println("\n - Escolha uma operacao \n\n 1 - Informar Tempo do Instante \n 2 - Adicionar Desenvolvedores e Bugs ao plano \n 3 - Comecar a rodada \n");
			System.out.print("-> ");
			switch (entrada.nextInt()) {
			
			case 1:
				System.out.println(" -> Diga o tempo do instante");
				i = entrada.nextInt();
				break;
				
			case 2:
				do {
					System.out.print("\tNumero Total de Desenvolvedores: " + numeroTotalDeDesenvolvedores);
					System.out.print("\tNumero Total de Bugs: " + numeroTotalDeBugs);
					System.out.println("\n");
					System.out.println(" -> Quantos desenvolvedores voce deseja adicionar no plano?");
					n1 = entrada.nextInt();
					System.out.println(" -> Quantos bugs voce deseja adicionar no plano?");
					n2 = entrada.nextInt();
				} while (controlarExesso(n1,n2));
				adicionarDesenvolvedores(n1);
				adicionarBugs(n2);
				System.out.print("\n");
				System.out.print("\tNumero Total de Desenvolvedores: " + numeroTotalDeDesenvolvedores);
				System.out.print("\tNumero Total de Bugs: " + numeroTotalDeBugs);
				System.out.println("\n");
				n1 = 0;
				n2 = 0;
				break;
				
			case 3:
				++numeroDeInstantesSolicitados;
				System.out.println("\nINSTANTE: " + instante);
				tabelar();
				System.out.print("\tNumero Inicial de Desenvolvedores na Rodada: " + numeroTotalDeDesenvolvedores);
				System.out.print("\t Numero Inicial de Bugs na Rodada: " + numeroTotalDeBugs);
				System.out.println("\n");
				translacionarPlanetas(i);
				verificarExplosoes();
				System.out.print("\tNumero Final de Desenvolvedores na Rodada: " + numeroTotalDeDesenvolvedores);
				System.out.print("\tNumero Final de Bugs na Rodada: " + numeroTotalDeBugs);
				System.out.println("\n\n");
				
				System.out.println("Dias (Em Horas) que se passaram em cada planeta\n ");
				rotacionarPlanetas(i);
				System.out.println("Anos que se passaram em cada planeta\n");
				avisarAnoNovo();
				++instante;
				break;
				
			default:
				System.out.println("\n\nRELATORIO FINAL");
				System.out.println("Numero de instantes solicitados: " + numeroDeInstantesSolicitados + "\n");
				for (Planetas planeta : planetasLista) {
					if (planeta.seExplodiu) {
						System.out.println("\tPlaneta: " + planeta.getNome() + " EXPLODIU" + "\n");
					} else {
						System.out.println("\tPlaneta: " + planeta.getNome() + "\n");
					}
					System.out.println("\tDesenvolvedores colididos: " + planeta.DesenvolvedoresColididos + "\n");
					System.out.println("\tBugs colididos: " + planeta.BugsColididos + "\n");
					System.out.println("\tVelocidade Final: " + planeta.velocidade + "\n\n" + "\tVelocidade media: " + planeta.caucularVelocidadeMedia());
					System.out.printf("\n\tDias (Em Horas) sobrevividos: " + "%.1f" + "\n", planeta.diasPassados);
					System.out.println("\tAnos JavaLa completados: " + planeta.AnosJavaLa + "\n");
					System.out.println("");
					planeta.ResumoDaLinguagem();
					System.out.println("\n");
				}
				
				controle = false;
				break;
			}	
		} while (controle);
	}
	
	
	private void verificarExplosoes() {
		for (Planetas planeta : planetasLista) {
			if (planeta.velocidade == 0 && !planeta.seExplodiu) {
				planeta.seExplodiu = true;
				System.out.println("\n\t" + "| " + planeta.getNome() + " EXPLODIU!!!!!!! |\n");
			}
		}
	}
	
 	private void translacionarPlanetas(int tempoDoInstante) {
		int E ;
		for (Planetas planeta : planetasLista) {
			
			if (!planeta.seExplodiu) {
				
				limparConteudoDaCelula(planeta.getX(), planeta.getY());
				
				planeta.salvarVelocidade(planeta.velocidade);
				
				planeta.translacionar(tempoDoInstante);

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
				System.out.print("\t+ Velocidade atual do Planeta " + planeta.getNome() + ": " + planeta.velocidade + "\n\n");
			}
		}
	}
	
	private void adicionarDesenvolvedores(int quantidadeDesenvolvedores) {
		boolean E;
		int x = 0;
		int y = 0;
		for (int i = 0; i < quantidadeDesenvolvedores; i++) {
			do {
				x = sorteador.nextInt(14);
				y = sorteador.nextInt(14);
				E = adicionarDesenvolvedores(x, y, new Desenvolvedor(x, y));
			} while (E);
		}			
	}
	
	private void adicionarBugs(int quantidadeBugs) {
		boolean E;
		int x = 0;
		int y = 0;
		for (int i = 0; i < quantidadeBugs; i++) {
			do {
				x = sorteador.nextInt(14);
				y = sorteador.nextInt(14);
				E = adicionarBugs(x, y, new Bug(x, y));
			} while (E);
		}			
	}
	
	private boolean controlarExesso(int n1, int n2) {
		
		if (n1 + n2 == 0) {
			return false;
		} else if (numeroTotalDeBugs + numeroTotalDeDesenvolvedores >= 180 || n1 + n2 > 180){
			System.out.println("---> Por razoes de eficiencia, o maximo de bugs e desenvolvedores foi limitado a 180 <--- \n");
			return true;
		} else {
		numeroTotalDeDesenvolvedores += n1;
		numeroTotalDeBugs += n2;
		return false;
		}
	}
	
	private void rotacionarPlanetas(int tempoDoInstante) {
		float N = 0f;
		for (Planetas planeta : planetasLista) {
			if (!planeta.seExplodiu) {
				N = planeta.caucularDiasDoInstante(tempoDoInstante);
			}
			System.out.printf("\tDado o tempo do instante " + tempoDoInstante + " no o planeta " + planeta.getNome() + " passaram-se " + "%.1f" + " dias (Em Horas) \n\n", N);
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
}
