package excecoes;

public class ClienteJaAdicionadoExcepition extends Exception {

	private String nome;

	public ClienteJaAdicionadoExcepition(String nome) {
		super("cliente ja adicionado");
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	

}
