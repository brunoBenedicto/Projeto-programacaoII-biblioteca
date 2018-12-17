package model;


public class Livro {
	private static int contadorLivros;
	private int idLivro;
	private String nome;
	private String autor;
	private int dataDeLancamento;
	private boolean disponivel;

	public Livro(String nome, String autor, int dataDeLancamento, boolean disponivel) {
		this.nome = nome;
		this.autor = autor;
		this.dataDeLancamento = dataDeLancamento;
		this.disponivel = disponivel;
		this.idLivro = Livro.contadorLivros++;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

	public String getNome() {
		return nome;
	}

	public String getAutor() {
		return autor;
	}

	public int getDataDeLancamento() {
		return dataDeLancamento;
	}

	public int getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(int idLivro) {
		this.idLivro = idLivro;
	}

}
