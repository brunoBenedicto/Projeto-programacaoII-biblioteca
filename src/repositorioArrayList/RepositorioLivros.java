package repositorioArrayList;

import java.util.ArrayList;

import model.Livro;

public class RepositorioLivros {
	private ArrayList<Livro> repositorio = new ArrayList<Livro>();
	private static int idLivros;
	
	public RepositorioLivros() {
		RepositorioLivros.idLivros =0;
	}
	
	public void adicionar(Livro livro) {
		RepositorioLivros.idLivros = RepositorioLivros.idLivros +1;
		livro.setIdLivro(RepositorioLivros.idLivros);
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
	
	public void disponivelParaEmprestimo(Livro livro) {
		Livro l = this.procurar(livro.getIdLivro());
		l.setDisponivel(livro.isDisponivel());
	}
	
	 

}
