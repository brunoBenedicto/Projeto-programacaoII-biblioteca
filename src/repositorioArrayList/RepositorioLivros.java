  package repositorioArrayList;

import java.util.ArrayList;

import interfaces.Ilivros;
import model.Livro;

public class RepositorioLivros implements Ilivros {
	private ArrayList<Livro> repositorio = new ArrayList<Livro>();
	
	
	public RepositorioLivros() {
	}
	
	public void adicionar(Livro livro) {
		this.repositorio.add(livro);
		
	}
	
	public ArrayList<Livro> procurarPorAutor (String autor) {
		ArrayList<Livro> livros = new ArrayList<Livro>();
		for(Livro l : repositorio) {
			if(l.getAutor().equals(autor)) {
				livros.add(l);
			}
		}
		return livros;
	}
	
	public ArrayList<Livro> procurarPorTitulo (String titulo) {
		ArrayList<Livro> livros = new ArrayList<Livro>();
		for(Livro l : repositorio) {
			if(l.getNome().equals(titulo)) {
				livros.add(l);
			}
		}
		return livros;
	}
	
	public Livro procurar(int id) {
		for(Livro l : repositorio) 
			if(l.getIdLivro() == id) 
				return l;
		return null;	
	}
	
	public void remover(Livro livro) {
		if(this.repositorio.contains(livro))
			this.repositorio.remove(livro);
	}

}
