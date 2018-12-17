package controle;


import excecoes.DddInvalidoExcepiton;
import excecoes.NumeroInvalidoExcepiton;
import model.Atendente;
import model.Cliente;
import model.Emprestimo;
import model.Livro;
import model.Telefone;

public class Factory {
	
	private static Factory instance;
	private Factory() {
	}

	public static Factory getInstance() {
		if (Factory.instance == null)
			instance = new Factory();
		return Factory.instance;
	}

	public Cliente novoCliente(String nome, Telefone telefone) {
		return new Cliente(nome, telefone);
	}

	public Livro novoLivro(String nome, String autor, int dataDeLancamento) {
		return new Livro(nome, autor, dataDeLancamento, true);
	}

	public Emprestimo novoEmprestimo(Livro livro1, Livro livro2, Atendente atendente, Cliente cliente) {
		return new Emprestimo(livro1, livro2, atendente, cliente);
	}

	public Emprestimo novoEmprestimo(Livro livro1, Atendente atendente, Cliente cliente) {
		return new Emprestimo(livro1, atendente, cliente);
	}

	public Telefone novoTelefone(int ddd, int numero) throws DddInvalidoExcepiton, NumeroInvalidoExcepiton {
		return new Telefone(ddd, numero);
	}

}
