package repositorioArrayList;

import java.util.ArrayList;

import excecoes.LivroNaoEncontradoException;
import interfaces.Ilivros;
import model.Livro;

public class RepositorioLivros implements Ilivros {
	private ArrayList<Livro> repositorio = new ArrayList<Livro>();

	public RepositorioLivros() {
	}

	public void adicionar(Livro livro) {
		this.repositorio.add(livro);

	}

	public ArrayList<Livro> procurarPorAutor(String autor) {
		ArrayList<Livro> livros = new ArrayList<Livro>();
		for (Livro l : repositorio) {
			if (l.getAutor().contains(autor)) {
				livros.add(l);
			}
		}
		return livros;
	}

	public ArrayList<Livro> procurarPorTitulo(String titulo) {
		ArrayList<Livro> livros = new ArrayList<Livro>();
		for (Livro l : repositorio) {
			if (l.getNome().contains(titulo)) {
				livros.add(l);
			}
		}
		return livros;
	}

	public Livro procurar(int id) throws LivroNaoEncontradoException {
		for (Livro l : repositorio)
			if (l.getIdLivro() == id) {
				return l;
			}
		throw new LivroNaoEncontradoException();
	}

	public void remover(Livro livro) {
		if (this.repositorio.contains(livro))
			this.repositorio.remove(livro);
	}

}
