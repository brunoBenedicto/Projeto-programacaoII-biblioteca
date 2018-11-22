package controle;

import java.util.ArrayList;

import com.sun.javafx.scene.control.skin.EmbeddedTextContextMenuContent;

import excecoes.ClienteJaAdicionadoExcepition;
import excecoes.ClienteNaoEncontradoExcepition;
import excecoes.EmprestimoNaoEncontradoExcepition;
import excecoes.LivroNaoEncontradoException;
import excecoes.SemHistoricoDeEmprestimosExcepition;
import model.Cliente;
import model.Emprestimo;
import model.Livro;

public class Fachada {
	private ControleClientes clientes;
	private ControleEmprestimos emprestimos;
	private ControleLivros livros;
	private static Fachada instance;

	private Fachada() {
		this.clientes = new ControleClientes();
		this.emprestimos = new ControleEmprestimos();
		this.livros = new ControleLivros();
	}

	public static Fachada getInstance() {
		if (Fachada.instance == null)
			instance = new Fachada();
		return Fachada.instance;
	}

	/* 
	 * clientes
	 */
	public void adicionar(Cliente cliente) throws ClienteJaAdicionadoExcepition {
		this.clientes.adicionar(cliente);
	}

	public Cliente procurarCliente(int id) throws ClienteNaoEncontradoExcepition {
		return this.clientes.procurar(id);
	}

	public Cliente procurar(String nome) throws ClienteNaoEncontradoExcepition {
		return this.clientes.procurar(nome);
	}

	public void Atualizar(Cliente cliente) throws ClienteNaoEncontradoExcepition {
		this.clientes.Atualizar(cliente);
	}

	
	/*
	 * emprestimos
	 */
	// emprestimos
public void adicionar(Emprestimo emprestimo) {
		this.emprestimos.adicionar(emprestimo);
	}

	public Emprestimo pesquisar(int idEmprestimo) throws EmprestimoNaoEncontradoExcepition {
		return this.emprestimos.pesquisar(idEmprestimo);
	}

	public void remover(Emprestimo emprestimo) throws EmprestimoNaoEncontradoExcepition {
		this.emprestimos.remover(emprestimo);
	}

	public void finalizar(Emprestimo emprestimo) throws EmprestimoNaoEncontradoExcepition {
		this.emprestimos.finalizar(emprestimo);
	}

	public ArrayList<Emprestimo> pesquizarPorCliente(int idCliente) throws SemHistoricoDeEmprestimosExcepition {
		return this.emprestimos.pesquizarPorCliente(idCliente);
	}

	public ArrayList<Emprestimo> pesquizarPorAutor(String nome) throws SemHistoricoDeEmprestimosExcepition {
		return this.emprestimos.pesquizarPorAutor(nome);
	}

	public ArrayList<Emprestimo> pesquizarPorTitulo(String titulo) throws SemHistoricoDeEmprestimosExcepition {
		return this.emprestimos.pesquizarPorTitulo(titulo);
	}

	/*
	 * livros
	 */
	
	// livros
public void adicionar(Livro livro) {
		this.livros.adicionar(livro);
	}

	public ArrayList<Livro> procurarPorAutor(String autor) {
		return this.livros.procurarPorAutor(autor);
	}

	public ArrayList<Livro> procurarPorTitulo(String titulo) {
		return this.livros.procurarPorTitulo(titulo);
	}

	public Livro procurarLivro(int id) throws LivroNaoEncontradoException {
		return this.livros.procurar(id);
	}

	public void remover(Livro livro) {
		this.livros.remover(livro);
	}

}
