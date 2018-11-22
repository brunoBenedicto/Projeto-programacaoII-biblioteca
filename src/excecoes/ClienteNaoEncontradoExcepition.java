package excecoes;

public class ClienteNaoEncontradoExcepition extends Exception {

	private String nome;

	public ClienteNaoEncontradoExcepition() {
		super("Cliente não encontrado");
	}
	public ClienteNaoEncontradoExcepition(String nome) {
		super("Cliente não encontrado");
		this.nome = nome;
	}
	public String getNome() {
		return this.nome;
	}

}
