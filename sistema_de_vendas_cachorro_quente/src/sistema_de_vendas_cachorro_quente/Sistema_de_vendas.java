package sistema_de_vendas_cachorro_quente;

public class Sistema_de_vendas {
	public Pedido pedido;
	
	public void RegistrarPedido(Pedido Novo_pedido) {
		pedido = Novo_pedido;
	}
	
	public void mostrar_pedidos() {
			System.out.println("pedido "+1);
			System.out.println("aluno: " + pedido.aluno.getNome() + "\n" + "matricula: " + pedido.aluno.getMatricula() + "\n");
			
			System.out.println("\n");
			for (int j = 0; j < pedido.cachorros_quentes.length; j++) {
				System.out.println("cachorro quente "+(j+1));
				System.out.println("proteina: " + pedido.cachorros_quentes[j].getProteina());
				System.out.println("queijo: " + pedido.cachorros_quentes[j].getQueijo());
				
				System.out.println("\n");
				
				for (int i = 0; i < pedido.cachorros_quentes[j].adicionais.length; i++) {
					System.out.println("-adicional " + (i+1) + " " + pedido.cachorros_quentes[j].adicionais[i]);
				}
				
				System.out.println("\n");
				
				for (int x = 0; x < pedido.bebidas.length; x++) {
					System.out.println("-bebida " + (x+1) + " " + pedido.bebidas[x]);
				}
				
			}
			System.out.println("\n \n");
		}
}
