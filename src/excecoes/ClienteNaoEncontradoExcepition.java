package excecoes;

public class ClienteNaoEncontradoExcepition extends Exception {

	private String nome;

	public ClienteNaoEncontradoExcepition() {
		super("Cliente n�o encontrado");
	}
	public ClienteNaoEncontradoExcepition(String nome) {
		super("Cliente n�o encontrado");
		this.nome = nome;
	}
	public String getNome() {
		return this.nome;
	}

}
