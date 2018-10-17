package model;

import java.util.Date;

public class Emprestimo {
	private Livro[] livros = new Livro[2];
	private Atendente atendente;
	private Cliente cliente;
	private Date dataInicio, dataFim;

	public Emprestimo(Livro livro1,Livro livro2, Atendente atendente, Cliente cliente, Date dataInicio, Date dataFim) {
		super();
		this.livros[0] = livro1;
		this.livros[2] = livro1;
		this.atendente = atendente;
		this.cliente = cliente;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
	}

	public Emprestimo(Livro livro, Atendente atendente, Cliente cliente, Date dataInicio, Date dataFim) {
		this.livros[0] = livro;
		this.atendente = atendente;
		this.cliente = cliente;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
	}

	public Livro[] getLivros() {
		return livros;
	}

	public Atendente getAtendente() {
		return atendente;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

}
