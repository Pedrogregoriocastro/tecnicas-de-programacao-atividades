package sistema_de_vendas_cachorro_quente;

import java.util.Scanner;


public class Main {
	
	public static String[] colocar_todos_os_adicionais() {
		String[] adicionar = new String[4];
		adicionar[0]= "maionese";
		adicionar[1]= "ketchup";
		adicionar[2]= "ovo";
		adicionar[3]= "batata palha";
		
		return adicionar;
	}
	
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		Sistema_de_vendas sistema_principal = new Sistema_de_vendas();


		System.out.println("vende-se cachorros quentes");
		System.out.println("proteinas: salsicha, linguica, frango ou bacon");
		System.out.println("queijos: mussarela, prato, parmesão ou coalho");
		System.out.println("adicionais: batata palha, mayonese, ovo, ketchup");
		System.out.println("bebidas: : Coca-cola, Del Rio ou Suco do Chaves" + "\n obs: as bebidas acompanham cada cachorroquente que o aluno pedir");
		System.out.println("\n");
		System.out.println("digite o nome e a matricula do aluno");
		Aluno cliente = new Aluno(entrada.next(), entrada.nextInt());

		System.out.println("\n");

		System.out.println("diga a quantidade de cachorros quente");
		Pedido pedido = new Pedido(cliente);
		Cachorro_quente[] cachorro_quente = new Cachorro_quente [entrada.nextInt()];

		System.out.println("\n");

		for (int j = 0; j < cachorro_quente.length; j++) {
			System.out.println("diga a proteina e o queijo do cachorro quente "+(j+1));
			cachorro_quente[j] = new Cachorro_quente(entrada.next(), entrada.next());

			pedido.FazerCachorroQuente(cachorro_quente.length, cachorro_quente);

			System.out.println("\n");

			System.out.println("Digite a quantidade de adicionais do cachorro quente "+(j+1)+" (max: 4 adicionais)");
			String[] adicionais = new String[entrada.nextInt()];

			while (adicionais.length > 4) {
				System.out.println("nao e possivel colocar mais de 4 adicionais, tente de novo");
				adicionais = new String[entrada.nextInt()];
			}

			if (adicionais.length == 4) {
				System.out.println("todos os adicionais foram colocados no cachorro quente "+(j+1));;
				pedido.ColocarAdicionais(j, 4, colocar_todos_os_adicionais());
			}
			else {
				for (int i = 0; i < adicionais.length; i++) {
					System.out.println("diga o nome do adicional "+(i+1)+" do cachorro quente "+(j+1));
					adicionais[i] = entrada.next();
				}
				pedido.ColocarAdicionais(j, adicionais.length, adicionais);
			} 

		}

		String[] bebidas = new String[cachorro_quente.length];
		for (int i = 0; i < cachorro_quente.length; i++) {
			System.out.println("digite o nome da bebida "+(i+1));
			bebidas[i] = entrada.next();
		}
		pedido.EscolherBebida(cachorro_quente.length, bebidas);

		sistema_principal.RegistrarPedido(pedido);

		System.out.println("\n");


		System.out.println("\n \n \n \n");

		
		sistema_principal.mostrar_pedidos();
		System.out.println("\n");
	}	
}	
