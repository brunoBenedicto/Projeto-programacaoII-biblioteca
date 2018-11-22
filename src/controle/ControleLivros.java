package controle;

import java.util.ArrayList;

import excecoes.LivroNaoEncontradoException;
import interfaces.Ilivros;
import model.Livro;
import repositorioArrayList.RepositorioLivros;

public class ControleLivros {
	private Ilivros livros = new RepositorioLivros();
	
	public void adicionar(Livro livro) {
		this.livros.adicionar(livro);
	}
	
	public ArrayList<Livro> procurarPorAutor (String autor){
		return this.livros.procurarPorAutor(autor);
	}
	
	public ArrayList<Livro> procurarPorTitulo (String titulo){
		return this.livros.procurarPorTitulo(titulo);
	}
	
	public Livro procurar(int id) throws LivroNaoEncontradoException{
	return this.livros.procurar(id);	
	}
	
	public void remover(Livro livro) {
		this.livros.remover(livro);
	}
	
	//livros
	

}
