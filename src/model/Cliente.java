package model;

public class Cliente {
	private int idCliente;
	private String nome;
	private boolean aptoAEmprestimos;
	private Telefone telefone;

	public Cliente(int idCliente, String nome, boolean aptoAEmprestimos, Telefone telefone) {
		super();
		this.idCliente = idCliente;
		this.nome = nome;
		this.aptoAEmprestimos = aptoAEmprestimos;
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

	public String getNome() {
		return nome;
	}

}
