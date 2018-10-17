package model;

import java.util.Date;

public class Livro {

	private String nome;
	private String autor;
	private Date dataDeLancamento;
	private boolean disponivel;

	public Livro(String nome, String autor, Date dataDeLancamento, boolean disponivel) {
		super();
		this.nome = nome;
		this.autor = autor;
		this.dataDeLancamento = dataDeLancamento;
		this.disponivel = disponivel;
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

	public Date getDataDeLancamento() {
		return dataDeLancamento;
	}

}
