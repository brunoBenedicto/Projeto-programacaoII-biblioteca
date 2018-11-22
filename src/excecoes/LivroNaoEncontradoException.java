package excecoes;

public class LivroNaoEncontradoException extends Exception {
	private String autor;
	private String titulo;
	
	public LivroNaoEncontradoException(String autor, String titulo) {
		super("Livro n�o encontrado");
		this.autor = autor;
		this.titulo =titulo;
	}
	public LivroNaoEncontradoException() {
		super("Livro n�o encontrado");
	}

	public String getAutor() {
		return autor;
	}

	public String getTitulo() {
		return titulo;
	}
	
	
	

}
