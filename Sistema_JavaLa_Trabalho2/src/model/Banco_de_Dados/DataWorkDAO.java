package model.Banco_de_Dados;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import controller.Aluno;

public class DataWorkDAO {
	
	public Aluno getAlunoQueProcessouMaisInstantes() {
		ArrayList<Aluno> Alunos = new ArrayList<Aluno>();	
		
		try {
			Connection conexao = new Conexao().getConexao();
			String query = "SELECT * FROM javalar";
			ResultSet ListaDados = conexao.prepareStatement(query).executeQuery();
			
			while (ListaDados.next()) {
				String nome = ListaDados.getString("nome");
				String matricula = ListaDados.getString("matricula");
				
				Alunos.add(new Aluno(nome, matricula));	
			}
			
			conexao.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Map<Aluno, Integer> ContagemAlunos = new HashMap<Aluno, Integer>();
		
		for (Aluno aluno : Alunos) {
			 ContagemAlunos.put(aluno, ContagemAlunos.getOrDefault(aluno, 0) + 1);
		}
		
		Aluno AlunoMaisRecorrente = null;
		int frequeciaMax = 0;
		
		for (Map.Entry<Aluno, Integer> entry : ContagemAlunos.entrySet()) {
			if (entry.getValue() > frequeciaMax ) {
				frequeciaMax = entry.getValue();
				AlunoMaisRecorrente = entry.getKey();
			}

		}
		
		return AlunoMaisRecorrente;

	}
	
	public String getPlanetaMaisMorto() {
		
		ArrayList<String> PlanetasMortos = new ArrayList<String>();
		
		try {
			Connection conexao = new Conexao().getConexao();
			String query = "SELECT * FROM javalar";
			ResultSet ListaDados = conexao.prepareStatement(query).executeQuery();
			
			while (ListaDados.next()) {
				if (ListaDados.getInt("v_python") == 0)
					PlanetasMortos.add("Python");
				if (ListaDados.getInt("v_javascript") == 0)
					PlanetasMortos.add("JavaScript");
				if (ListaDados.getInt("v_ruby") == 0)
					PlanetasMortos.add("Ruby On Rails");
				if (ListaDados.getInt("v_php") == 0)
					PlanetasMortos.add("PHP");
				if (ListaDados.getInt("v_csharp") == 0)
					PlanetasMortos.add("C#");
				if (ListaDados.getInt("v_cmais") == 0)
					PlanetasMortos.add("C++");
				if (ListaDados.getInt("v_c") == 0)
					PlanetasMortos.add("C");
			}
			
			conexao.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		for (String planeta : PlanetasMortos) {
			Integer contagem = map.get(planeta); 
			map.put(planeta, (contagem == null) ? 1 : contagem + 1);
		}
		
		String nomePlaneta = "";
		int valormaximo = 0;
		
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue() > valormaximo) {
				valormaximo = entry.getValue();
				nomePlaneta = entry.getKey();

			}			
		}
		return nomePlaneta;
	}
	
	public String getPlanetaComMaisVida() {
		try {
			Connection conexao = new Conexao().getConexao();
			String query = "SELECT * FROM javalar";
			ResultSet ListaDados = conexao.prepareStatement(query).executeQuery();
			
			int[] Planetas = { 0, 0, 0, 0, 0, 0, 0 };
			
			while (ListaDados.next()) {
				Planetas[0] += ListaDados.getInt("v_python");
				Planetas[1] += ListaDados.getInt("v_javascript");
				Planetas[2] += ListaDados.getInt("v_ruby");
				Planetas[3] += ListaDados.getInt("v_php");
				Planetas[4] += ListaDados.getInt("v_csharp");
				Planetas[5] += ListaDados.getInt("v_cmais");
				Planetas[6] += ListaDados.getInt("v_c");
			}
			
			int valorMaximo = 0;
			int planeta = 0;
			
			for (int i = 0; i < Planetas.length; i++) {
				if (Planetas[i] > valorMaximo) {
					valorMaximo = Planetas[i];
					planeta = i + 1;
				}
			}
			
			switch (planeta) {
			case 1:
				return "Python";
			case 2:
				return "JavaScript";
			case 3:
				return "Ruby On Rails";
			case 4:
				return "PHP";
			case 5:
				return "C#";
			case 6:
				return "C++";
			case 7:
				return "C";
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int getQuadranteComMaisBugs() {
		int[] quadrantes = {0, 0, 0, 0};
		
		try {
			Connection conexao = new Conexao().getConexao();
			String query = "SELECT * FROM javalar";
			ResultSet ListaDados = conexao.prepareStatement(query).executeQuery();
			
			while (ListaDados.next()) {
				quadrantes[0] += ListaDados.getInt("bug_q1");
				quadrantes[1] += ListaDados.getInt("bug_q2");
				quadrantes[2] += ListaDados.getInt("bug_q3");
				quadrantes[3] += ListaDados.getInt("bug_q4");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		int valorMaximo = 0;
		int quadrante = 0;
		
		for (int i = 0; i < quadrantes.length; i++) {
			if (quadrantes[i] > valorMaximo) {
				valorMaximo = quadrantes[i];
				quadrante = i + 1;
			}
		}
		return quadrante;
	}
	
	public int getQuadranteComMaisDevs() {
		int[] quadrantes = {0, 0, 0, 0};
		
		try {
			Connection conexao = new Conexao().getConexao();
			String query = "SELECT * FROM javalar";
			ResultSet ListaDados = conexao.prepareStatement(query).executeQuery();
			
			while (ListaDados.next()) {
				quadrantes[0] += ListaDados.getInt("dev_q1");
				quadrantes[1] += ListaDados.getInt("dev_q2");
				quadrantes[2] += ListaDados.getInt("dev_q3");
				quadrantes[3] += ListaDados.getInt("dev_q4");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		int valorMaximo = 0;
		int quadrante = 0;
		
		for (int i = 0; i < quadrantes.length; i++) {
			if (quadrantes[i] > valorMaximo) {
				valorMaximo = quadrantes[i];
				quadrante = i + 1;
			}
		}
		return quadrante;
	}
	
	public int getQuantidadeDeInstantesAnalizados() {
		try {
			Connection conexao = new Conexao().getConexao();
			String query = "SELECT * FROM javalar";
			ResultSet ListaDados = conexao.prepareStatement(query).executeQuery();
			
			int quantidadeInstantes = 0;
			
			while (ListaDados.next()) {
				quantidadeInstantes++;
			}
			
			return quantidadeInstantes;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public double[] getVelocidadeMediaDeCadaPlaneta() {
		
		int[] VelocidadeDeCadaPlaneta = { 0, 0, 0, 0, 0, 0, 0 };
		int quantidadeDeInstantes = getQuantidadeDeInstantesAnalizados();
		
		try {
			Connection conexao = new Conexao().getConexao();
			String query = "SELECT * FROM javalar";
			ResultSet ListaDados = conexao.prepareStatement(query).executeQuery();
			
			while (ListaDados.next()) {
				VelocidadeDeCadaPlaneta[0] += ListaDados.getInt("v_python");
				VelocidadeDeCadaPlaneta[1] += ListaDados.getInt("v_javascript");
				VelocidadeDeCadaPlaneta[2] += ListaDados.getInt("v_ruby");
				VelocidadeDeCadaPlaneta[3] += ListaDados.getInt("v_php");
				VelocidadeDeCadaPlaneta[4] += ListaDados.getInt("v_csharp");
				VelocidadeDeCadaPlaneta[5] += ListaDados.getInt("v_cmais");
				VelocidadeDeCadaPlaneta[6] += ListaDados.getInt("v_c");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		double[] VelocidadeMedia = new double[VelocidadeDeCadaPlaneta.length];
		
		for (int i = 0; i < VelocidadeDeCadaPlaneta.length; i++) {
			VelocidadeMedia[i] = VelocidadeDeCadaPlaneta[i] / (double) quantidadeDeInstantes;
		}
		
		return VelocidadeMedia;
	}

	public int getOcorrenciasDeBugs() {
		try {
			Connection conexao = new Conexao().getConexao();
			String query = "SELECT * FROM javalar";
			ResultSet ListaDados = conexao.prepareStatement(query).executeQuery();
			
			int quantidadeBugs = 0;
			
			while (ListaDados.next()) {
				quantidadeBugs += ListaDados.getInt("bug_python");
				quantidadeBugs += ListaDados.getInt("bug_javascript");
				quantidadeBugs += ListaDados.getInt("bug_ruby");
				quantidadeBugs += ListaDados.getInt("bug_php");
				quantidadeBugs += ListaDados.getInt("bug_csharp");
				quantidadeBugs += ListaDados.getInt("bug_cmais");
				quantidadeBugs += ListaDados.getInt("bug_c");
			}

			return quantidadeBugs;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int getOcorrenciasDeDevs() {
		try {
			Connection conexao = new Conexao().getConexao();
			String query = "SELECT * FROM javalar";
			ResultSet ListaDados = conexao.prepareStatement(query).executeQuery();
			
			int quantidadeDevs = 0;
			
			while (ListaDados.next()) {
				quantidadeDevs += ListaDados.getInt("dev_python");
				quantidadeDevs += ListaDados.getInt("dev_javascript");
				quantidadeDevs += ListaDados.getInt("dev_ruby");
				quantidadeDevs += ListaDados.getInt("dev_php");
				quantidadeDevs += ListaDados.getInt("dev_csharp");
				quantidadeDevs += ListaDados.getInt("dev_cmais");
				quantidadeDevs += ListaDados.getInt("dev_c");
			}

			return quantidadeDevs;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int getQuantidadeDeHorasPassadas() {
		try {
			Connection conexao = new Conexao().getConexao();
			String query = "SELECT * FROM javalar";
			ResultSet ListaDados = conexao.prepareStatement(query).executeQuery();

			int quantidadeHoras = 0;

			while (ListaDados.next()) {
				quantidadeHoras += ListaDados.getInt("d_python");
				quantidadeHoras += ListaDados.getInt("d_javascript");
				quantidadeHoras += ListaDados.getInt("d_ruby");
				quantidadeHoras += ListaDados.getInt("d_php");
				quantidadeHoras += ListaDados.getInt("d_csharp");
				quantidadeHoras += ListaDados.getInt("d_cmais");
				quantidadeHoras += ListaDados.getInt("d_c");
			}

			return quantidadeHoras;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	public int getQuantidadeDeAnosPassados() {
		try {
			Connection conexao = new Conexao().getConexao();
			String query = "SELECT * FROM javalar";
			ResultSet ListaDados = conexao.prepareStatement(query).executeQuery();

			int quantidadeAnos = 0;

			while (ListaDados.next()) {
				quantidadeAnos += ListaDados.getInt("a_python");
				quantidadeAnos += ListaDados.getInt("a_javascript");
				quantidadeAnos += ListaDados.getInt("a_ruby");
				quantidadeAnos += ListaDados.getInt("a_php");
				quantidadeAnos += ListaDados.getInt("a_csharp");
				quantidadeAnos += ListaDados.getInt("a_cmais");
				quantidadeAnos += ListaDados.getInt("a_c");
			}

			return quantidadeAnos;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

}
