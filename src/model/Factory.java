package model;

import java.time.LocalDate;

public class Factory {
	
	public Cliente novoCliente(String nome, Telefone telefone) {
		return new Cliente(nome, telefone);
	}
	
	public Livro novoLivro(String nome, String autor, LocalDate dataDeLancamento) {
		return new Livro(nome, autor, dataDeLancamento, true);
	}
	
	public Emprestimo novoEmprestimo(Livro livro1, Livro livro2, Atendente atendente, Cliente cliente) {
		return new Emprestimo( livro1, livro2, atendente, cliente);
	}
	
	public Emprestimo novoEmprestimo(Livro livro1, Atendente atendente, Cliente cliente) {
		return new Emprestimo( livro1, atendente, cliente);
	}

}
