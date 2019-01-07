package model;

import excecoes.DddInvalidoExcepiton;
import excecoes.NumeroInvalidoExcepiton;

public class Telefone {
	private int ddd;
	private int numero;

	public Telefone(int ddd, int numero) throws DddInvalidoExcepiton, NumeroInvalidoExcepiton {
		super();
		this.setDdd(ddd);
		this.setNumero(numero);
	}

	public int getDdd() {
		return ddd;
	}

	public void setDdd(int ddd) throws DddInvalidoExcepiton {
		if (ddd % 10 != 0 && ddd > 10 && ddd < 100)
			this.ddd = ddd;
		else
			throw new DddInvalidoExcepiton();
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) throws NumeroInvalidoExcepiton {
		String s = Integer.toString(numero);
		if (s.length() == 8)
			this.numero = numero;
		else if (s.length() == 9 && s.startsWith("9")) {
			this.numero = numero;
		} else
			throw new NumeroInvalidoExcepiton();
	}

	public String toString() {
		return "(" + this.getDdd() + ") " + this.getNumero();
	}

}
