
package model;

public class Cliente {
	private int idCliente;
	private String nome;
	private boolean aptoAEmprestimos;
	private Telefone telefone;

	public Cliente(String nome, Telefone telefone) {
		this.nome = nome;
		this.telefone = telefone;
	}

	public boolean isAptoAEmprestimos() {
		return aptoAEmprestimos;
	}

	public void setAptoAEmprestimos(boolean aptoAEmprestimos) {
		this.aptoAEmprestimos = aptoAEmprestimos;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int id) {
		this.idCliente = id;
	}

	public String getNome() {
		return nome;
	}

}
