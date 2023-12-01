package model.Banco_de_Dados;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import controller.JavaLarSystem;
import model.leitura_de_arquivos.LeitorDeArquivo;

public class JavaLarSystemDAO_Upload {
	
	public void EnviarDados(JavaLarSystem jogo) {
		try {
			Connection conexao = new Conexao().getConexao();
			
			PreparedStatement inserir = conexao.prepareStatement("INSERT INTO javalar (nome, matricula, nome_arquivo, "
					+ "bug_python, bug_javascript, bug_ruby, bug_php, bug_csharp, bug_cmais, bug_c, "
					+ "dev_python, dev_javascript, dev_ruby, dev_php, dev_csharp, dev_cmais, dev_c, "
					+ "v_python, v_javascript, v_ruby, v_php, v_csharp, v_cmais, v_c, "
					+ "d_python, d_javascript, d_ruby, d_php, d_csharp, d_cmais, d_c, "
					+ "a_python, a_javascript, a_ruby, a_php, a_csharp, a_cmais, a_c, "
					+ "bug_q1, bug_q2, bug_q3, bug_q4, dev_q1, dev_q2, dev_q3, dev_q4) "
					+ "values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
				inserir.setString(1, "Pedro Henrique Gregorio Castro");
				inserir.setString(2, "552295");
				inserir.setString(3, LeitorDeArquivo.arquivo_de_entrada.getName());
				for (int i = 4; i <= 10;) {
					for (int j = 0; j < jogo.planetasLista.size(); j++) {
						inserir.setInt(i, jogo.planetasLista.get(j).getBugsColididos());
						i++;
					}
				}
				for (int i = 11; i <= 17;) {
					for (int j = 0; j < jogo.planetasLista.size(); j++) {
						inserir.setInt(i, jogo.planetasLista.get(j).getDesenvolvedoresColididos());
						i++;
					}
				}
				for (int i = 18; i <= 24;) {
					for (int j = 0; j < jogo.planetasLista.size(); j++) {
						inserir.setInt(i, jogo.planetasLista.get(j).caucularVelocidadeMedia());
						i++;
					}
				}
				for (int i = 25; i <= 31;) {
					for (int j = 0; j < jogo.planetasLista.size(); j++) {
						inserir.setInt(i, jogo.planetasLista.get(j).getDiasPassados());
						i++;
					}
				}
				for (int i = 32; i <= 38;) {
					for (int j = 0; j < jogo.planetasLista.size(); j++) {
						inserir.setInt(i, jogo.planetasLista.get(j).getAnosJavaLa());
						i++;
					}
				}
				inserir.setInt(39, jogo.getBugsQ1());
				inserir.setInt(40, jogo.getBugsQ2());
				inserir.setInt(41, jogo.getBugsQ3());
				inserir.setInt(42, jogo.getBugsQ4());
				inserir.setInt(43, jogo.getDevsQ1());
				inserir.setInt(44, jogo.getDevsQ2());
				inserir.setInt(45, jogo.getDevsQ3());
				inserir.setInt(46, jogo.getDevsQ4());
				inserir.executeUpdate();
				conexao.close();
				JOptionPane.showMessageDialog(null, "Relatório inserido com sucesso!", "Sucesso",JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Não foi possível Fazer o upload!", "Erro" ,JOptionPane.WARNING_MESSAGE);
			e.printStackTrace();
		}
	}
	
}
