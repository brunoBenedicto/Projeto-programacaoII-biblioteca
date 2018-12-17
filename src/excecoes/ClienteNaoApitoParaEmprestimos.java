package excecoes;

public class ClienteNaoApitoParaEmprestimos extends Exception {
	private int idCliente;
	public ClienteNaoApitoParaEmprestimos (int idCliente) {
		super("Cliente não autoriazado a emprestimos");
		this.idCliente = idCliente;
	}
	
	public int getIdCliente() {
		return this.idCliente;
	}

}
