package model.Escrita_de_Arquivos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import javax.swing.JOptionPane;

public class Escritor_de_Arquivo {
	
	File arquivo;
	String directoryPath = "output/";
	String nomeArquivo = "Relatório Javalar.txt";
	
	public void gerarArquivoDeSaida(String conteudo) {
		arquivo = new File(directoryPath, nomeArquivo);
		
		try {
			if (!arquivo.exists()) {
				arquivo.createNewFile();
			}
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo));
			
			writer.write(conteudo);
			writer.close();
			
			JOptionPane.showMessageDialog(null, "Arquivo gerado com sucesso em 'Sistema_JavaLa_Trabalho2/output/'", "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
			
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "não foi possivel gerar o arquivo", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
}
