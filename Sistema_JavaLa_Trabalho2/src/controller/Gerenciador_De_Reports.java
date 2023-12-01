package controller;

import javax.swing.JOptionPane;

import model.Banco_de_Dados.DataWorkDAO;
import model.Escrita_de_Arquivos.Escritor_de_Arquivo;

public class Gerenciador_De_Reports implements Runnable{
	
	private DataWorkDAO acessoDataBase = new DataWorkDAO();
	private Escritor_de_Arquivo Escritor = new Escritor_de_Arquivo();
	private String Report = "";
	private String[] nomePlanetas = {"Python", "JavaScript", "Ruby on Rails", "PHP", "C#", "C++", "C"};
	
	public void LerDadosDosOutros() {
		try {
			StringBuilder conteudo = new StringBuilder();
			
			Aluno aluno = acessoDataBase.getAlunoQueProcessouMaisInstantes();
			
			conteudo.append(aluno.getMatricula() + " - " + aluno.getNome());
			conteudo.append(", " + acessoDataBase.getPlanetaMaisMorto());
			conteudo.append(", " + acessoDataBase.getPlanetaComMaisVida());
			conteudo.append(", " + acessoDataBase.getQuadranteComMaisBugs());
			conteudo.append(", " + acessoDataBase.getQuadranteComMaisDevs());
			conteudo.append(", " + acessoDataBase.getQuantidadeDeInstantesAnalizados() + ", ");
			
			double[] velocidadeMedia = acessoDataBase.getVelocidadeMediaDeCadaPlaneta();
			
			for (int i = 0; i < velocidadeMedia.length; i++) {
				String Linha = nomePlanetas[i] + ": " + String.format("%.2f", velocidadeMedia[i]);
				conteudo.append(", " + Linha);
			}
			
			conteudo.append(", " + acessoDataBase.getOcorrenciasDeBugs());
			conteudo.append(", " + acessoDataBase.getOcorrenciasDeDevs());
			conteudo.append(", " + acessoDataBase.getQuantidadeDeHorasPassadas());
			conteudo.append(", " + acessoDataBase.getQuantidadeDeAnosPassados());
			
			Report = conteudo.toString();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Dados lidos com sucesso", "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
		}
		
		
	}
	
	public void GerarArquivoDeSaida() {
		Escritor.gerarArquivoDeSaida(Report);
	}

	@Override
	public void run() {
		LerDadosDosOutros();
		
	}
	
}
