package model;

import java.time.LocalDate;

public class Devolucao {
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

	public void setValorMulta(double valorMulta) {
		this.valorMulta = valorMulta;
	}
	

}
