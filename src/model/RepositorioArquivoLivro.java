package model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import telas.NovoCliente;

public class RepositorioArquivoLivro {
	{
		try {
			FileInputStream leitor = new FileInputStream("Arquivos\\ListaDeLivros.txt");
			InputStreamReader arquivo = new InputStreamReader(leitor);
			BufferedReader br = new BufferedReader(arquivo);
			FileOutputStream saida = new FileOutputStream("Arquivos\\ListaDeLivrosoutput.txt");
			PrintWriter pw = new PrintWriter(saida);
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	

	}
}