package model;

import java.time.LocalDate;

public class Emprestimo {

	private static final long PERIODO_DE_EMPRESTIMO = 15;
	private static final int MULTA_DIARIA = 1;
	private Livro[] livros = new Livro[2];
	private Atendente atendente;
	private Cliente cliente;
	private LocalDate dataInicio;
	private Devolucao devolucao;

	public Emprestimo(Livro livro1, Livro livro2, Atendente atendente, Cliente cliente) {
		this.livros[0] = livro1;
		this.livros[2] = livro1;
		this.atendente = atendente;
		this.cliente = cliente;
		this.dataInicio = LocalDate.now();
		this.devolucao = new Devolucao(this.dataInicio.plusDays(PERIODO_DE_EMPRESTIMO));
	}

	public Emprestimo(Livro livro, Atendente atendente, Cliente cliente) {
		this.livros[0] = livro;
		this.atendente = atendente;
		this.cliente = cliente;
		this.dataInicio = LocalDate.now();
		this.devolucao = new Devolucao(this.dataInicio.plusDays(PERIODO_DE_EMPRESTIMO));
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

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void finalizarEmprestimo() {
		this.devolucao.setDataDevolucao(LocalDate.now());
		if (this.devolucao.getDataPrevista().isAfter(this.devolucao.getDataDevolucao())) {
			this.gerarMulta();
		}

	}

	private void gerarMulta() {
		long tempoDeAtraso = this.devolucao.getDataDevolucao().toEpochDay()
				- this.devolucao.getDataPrevista().toEpochDay();
		double valorDaMulta = tempoDeAtraso * MULTA_DIARIA;
		this.devolucao.setValorMulta(valorDaMulta);
	}
}
