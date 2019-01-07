package controle;

import java.util.ArrayList;

import excecoes.ClienteNaoApitoParaEmprestimos;
import excecoes.EmprestimoNaoEncontradoExcepition;
import excecoes.LivriNaoDisponivelExcepition;
import excecoes.SemClientesEmAtrasoExcepition;
import excecoes.SemHistoricoDeEmprestimosExcepition;
import interfaces.IEmprestimos;
import model.Cliente;
import model.Emprestimo;
import repositorioArrayList.RepositorioEmprestimos;

public class ControleEmprestimos {
	
	private IEmprestimos emprestimos = new RepositorioEmprestimos();
	
	public void adicionar(Emprestimo emprestimo) throws ClienteNaoApitoParaEmprestimos, LivriNaoDisponivelExcepition {
		this.emprestimos.adicionar(emprestimo);
	}
	
	public Emprestimo pesquisar(int idEmprestimo) throws EmprestimoNaoEncontradoExcepition{
		return this.emprestimos.pesquisar(idEmprestimo);
	}
	
	public void remover(Emprestimo emprestimo) throws EmprestimoNaoEncontradoExcepition{
		this.emprestimos.remover(emprestimo);
	}
	
	public void finalizar(Emprestimo emprestimo) throws EmprestimoNaoEncontradoExcepition{
		this.emprestimos.finalizar(emprestimo);
	}
	
	public ArrayList<Emprestimo> pesquizarPorCliente(int idCliente) throws SemHistoricoDeEmprestimosExcepition{
		return this.emprestimos.pesquisarPorCliente(idCliente);
	}
	
	public ArrayList<Emprestimo> pesquizarPorAutor(String nome) throws SemHistoricoDeEmprestimosExcepition{
		return this.emprestimos.pesquisarPorAutor(nome);
	}
	
	public ArrayList<Emprestimo> pesquizarPorTitulo(String titulo) throws SemHistoricoDeEmprestimosExcepition{
		return this.emprestimos.pesquisarPorTitulo(titulo);
	}

	public ArrayList<Emprestimo> pesquisarAtrasados() throws SemClientesEmAtrasoExcepition{
		return this.emprestimos.pesquisarAtrasados();
	}
	public ArrayList<Emprestimo> getEmprestimos(){
		return this.emprestimos.getEmprestimo();
	}
}
