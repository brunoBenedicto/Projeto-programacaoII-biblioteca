package model;

import java.time.LocalDate;

public class Devolucao {
	private static final int MULTA_DIARIA = 1;
	private LocalDate dataDevolucao;
	private LocalDate dataPrevista;
	private double valorMulta;

	public Devolucao(LocalDate dataPrevista) {
		this.dataPrevista = dataPrevista;
	}

	public LocalDate getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(LocalDate dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public LocalDate getDataPrevista() {
		return dataPrevista;
	}

	public void setDataPrevista(LocalDate dataPrevista) {
		this.dataPrevista = dataPrevista;
	}

	public double getValorMulta() {
		return valorMulta;
	}

	public void gerarMulta() {
		long tempoDeAtraso = this.dataDevolucao.toEpochDay() - this.dataPrevista.toEpochDay();
		double valorDaMulta = tempoDeAtraso * MULTA_DIARIA;
		this.valorMulta =valorDaMulta;
	}
}
