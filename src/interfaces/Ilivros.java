package interfaces;

import java.util.ArrayList;

import excecoes.LivroNaoEncontradoException;
import model.Livro;

public interface Ilivros {
	
	 void adicionar(Livro livro);
	 ArrayList<Livro> procurarPorAutor (String autor);
	 ArrayList<Livro> procurarPorTitulo (String titulo);
	 Livro procurar(int id) throws LivroNaoEncontradoException;
	 void remover(Livro livro);

}
