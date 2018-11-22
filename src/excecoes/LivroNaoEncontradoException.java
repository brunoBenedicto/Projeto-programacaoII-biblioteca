package excecoes;

public class LivroNaoEncontradoException extends Exception {
	private String autor;
	private String titulo;
	
	public LivroNaoEncontradoException(String autor, String titulo) {
		super("Livro não encontrado");
		this.autor = autor;
		this.titulo =titulo;
	}
	public LivroNaoEncontradoException() {
		super("Livro não encontrado");
	}

	public String getAutor() {
		return autor;
	}

	public String getTitulo() {
		return titulo;
	}
	
	
	

}
