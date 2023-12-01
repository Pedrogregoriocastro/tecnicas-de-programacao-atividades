package model.Banco_de_Dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexao {
	private String host;
	private String usuario;
	private String senha;
	private String banco;

	public Conexao() {

		this.host = "da_java.mysql.dbaas.com.br";
		this.banco = "da_java";
		this.usuario = "da_java";
		this.senha = "Tecnicas*2023@";
	}

	public Connection getConexao() {
		String url="jdbc:mysql://" + this.host + "/" + this.banco+"?verifyServerCertificate=false&useSSL=true";
		try {
			return DriverManager.getConnection(url, usuario, senha);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Não foi possível conectar ao banco de dados", "Erro" ,JOptionPane.WARNING_MESSAGE);
			e.printStackTrace();
		}
		return null;
	}

}
