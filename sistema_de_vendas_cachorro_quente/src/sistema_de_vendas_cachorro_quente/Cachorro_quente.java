package sistema_de_vendas_cachorro_quente;

public class Cachorro_quente {
	private String proteina;
	private String queijo;
	public String[] adicionais;
	
	public Cachorro_quente(String proteina, String queijo) {
		this.proteina = proteina;
		this.queijo = queijo;
	}
	
	public void setAdicionais(int tamanho, String[] novosAdicionais) {
		adicionais = new String [tamanho];
		adicionais = novosAdicionais;
	}
	
	public String getQueijo() {
		return queijo;
	}

	public void setQueijo(String queijo) {
		this.queijo = queijo;
	}

	public String getProteina() {
		return proteina;
	}
	
	public void setProteina(String proteina) {
		this.proteina = proteina;
	}
	
		
		
	}
