package testes;

import model.Atendente;
import model.Cliente;
import model.Emprestimo;
import model.Livro;
import model.Telefone;

public class TesteEmprestimo {

	public static void main(String[] args) {
		Livro livro;
		Atendente atendente;
		Cliente cliente;
		Emprestimo emprestimo;
		Telefone telCliente, telFuncionario;

		livro = new Livro("Dracula", "Bram stoker", null, true);
		telFuncionario = new Telefone(81, 987654321);
		telCliente = new Telefone(81, 987654321);
		atendente = new Atendente("nome do funcionario", 123, telFuncionario);
		cliente = new Cliente("nome do cliente", true, telCliente);

		emprestimo = new Emprestimo(livro, atendente, cliente);

		System.out.println(
				"o livro " + emprestimo.getLivros()[0].getNome() + " do autor " + emprestimo.getLivros()[0].getAutor());
		System.out.println("foi emprestado para o cliente " + emprestimo.getCliente().getNome() + " id: "
				+ emprestimo.getCliente().getIdCliente() + "  telefone: ("
				+ emprestimo.getCliente().getTelefone().getDdd() + ") "
				+ emprestimo.getCliente().getTelefone().getNumero());
		System.out.println("feito pelo atendente: " + atendente.getNome() + " id: " + atendente.getIdFuncionario());

	}

}
