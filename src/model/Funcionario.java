package model;

public class Funcionario {
	protected static int ContadorFuncionario;
	protected String nome;
	protected int idFuncionario;
	protected Telefone telefone;

	public Funcionario(String nome, Telefone telefone) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.idFuncionario = Funcionario.ContadorFuncionario++;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	

}
