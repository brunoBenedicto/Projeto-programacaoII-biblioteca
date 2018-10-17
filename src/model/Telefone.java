package model;

public class Telefone {
	private byte ddd;
	private int numero;

	public Telefone(byte ddd, int numero) {
		super();
		this.ddd = ddd;
		this.numero = numero;
	}

	public byte getDdd() {
		return ddd;
	}

	public void setDdd(byte ddd) {
		this.ddd = ddd;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

}
