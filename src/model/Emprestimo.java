package model;

import java.time.LocalDate;

public class Emprestimo {

	private static final long PERIODO_DE_EMPRESTIMO = 15;
	private static int contadorEmprestimo;
	private int idEmprestimo;
	private Livro[] livros = new Livro[2];
	private Atendente atendente;
	private Cliente cliente;
	private LocalDate dataInicio;
	private Devolucao devolucao;

	public Emprestimo(Livro livro1, Livro livro2, Atendente atendente, Cliente cliente) {

		this.livros[0] = livro1;
		this.livros[1] = livro2;
		this.atendente = atendente;
		this.cliente = cliente;
		this.dataInicio = LocalDate.now();
		this.idEmprestimo = Emprestimo.contadorEmprestimo++;
		this.devolucao = new Devolucao(this.dataInicio.plusDays(PERIODO_DE_EMPRESTIMO));
		
	}

	public int getIdEmprestimo() {
		return idEmprestimo;
	}

	public Emprestimo(Livro livro, Atendente atendente, Cliente cliente) {
		this.livros[0] = livro;
		this.atendente = atendente;
		this.cliente = cliente;
		this.dataInicio = LocalDate.now();
		this.devolucao = new Devolucao(this.dataInicio.plusDays(PERIODO_DE_EMPRESTIMO));
		this.idEmprestimo = Emprestimo.contadorEmprestimo++;

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
		this.getDevolucao().setDataDevolucao(LocalDate.now());
		for (int i = 0; i < 2; i++) {
			if (this.livros[i]!= null)
				this.livros[i].setDisponivel(true);
		}
		cliente.setAptoAEmprestimos(true);

		if (this.getDevolucao().getDataPrevista().isAfter(this.getDevolucao().getDataDevolucao())) {
			this.getDevolucao().gerarMulta();
		}

	}


	public Devolucao getDevolucao() {
		return devolucao;
	}

	

}
