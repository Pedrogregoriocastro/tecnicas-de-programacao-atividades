package sistema_de_vendas_cachorro_quente;

public class Pedido {
	public Aluno aluno;
	public Cachorro_quente[] cachorros_quentes;
	public String[] bebidas;
	
	public Pedido(Aluno aluno) {
		this.aluno = aluno;
	}
	
	public void FazerCachorroQuente(int tamanho, Cachorro_quente[] cachorro_quente) {
		cachorros_quentes = new Cachorro_quente[tamanho];
		cachorros_quentes = cachorro_quente;
		
	}
	
	public void ColocarAdicionais(int i ,int tamanho, String[] novosAdicionais ) {
		cachorros_quentes[i].setAdicionais(tamanho, novosAdicionais);	
		
	}
	
	public void EscolherBebida(int quantidade, String[] bebidas) {
		this.bebidas = new String[quantidade];
		this.bebidas = bebidas;
	}
	
		
	
	
	
}
