package model.leitura_de_arquivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class LeitorDeArquivo {
	
	public static File arquivo_de_entrada;
	
	public LeitorDeArquivo() {
		
		String valor[] = new String[10];
		String linha = null;
		
		
		try {
			BuscarArquivo();
			FileReader fr = new FileReader(arquivo_de_entrada);
			BufferedReader br = new BufferedReader(fr);
			
			br.readLine();
			while (br.ready()) {
				linha = br.readLine();
				valor = linha.split(",");
				
				armazenar_na_memoria(new Instante(valor));
			
			}
			br.close();
			fr.close();
		} catch ( IOException ex ) {
			ex.printStackTrace();
		}
	}

	public void armazenar_na_memoria(Instante ins) {
		JavalarArquivos.dados.add(ins);
	}	
	
	public void BuscarArquivo() throws IOException{
		
		JFileChooser fileChooser = new JFileChooser();

		FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos CSV", "csv");
		fileChooser.setFileFilter(filter);
		
		int resposta = fileChooser.showOpenDialog(null);
		
		if (resposta == JFileChooser.APPROVE_OPTION) {
			arquivo_de_entrada = fileChooser.getSelectedFile();
		}
	}
		
	public String getNomeDoArquivo() {
		return arquivo_de_entrada.getName();
	}
	
	
}
