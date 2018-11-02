package interfaces;

import java.util.ArrayList;

import model.Livro;

public interface Ilivros {
	
	void adicionar(Livro livro);
	public ArrayList<Livro> procurarPorAutor (String autor);
	public ArrayList<Livro> procurarPorTitulo (String titulo);
	public Livro procurar(int id);
	public void remover(Livro livro);

}
