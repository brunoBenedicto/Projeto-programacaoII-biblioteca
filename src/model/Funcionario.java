package model;

public class Funcionario {
	protected String nome;
	protected int idFuncionario;
	protected Telefone telefone;

	public Funcionario(String nome, int idFuncionario, Telefone telefone) {
		super();
		this.nome = nome;
		this.idFuncionario = idFuncionario;
		this.telefone = telefone;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	public int getIdFuncionario() {
		return idFuncionario;
	}

}
