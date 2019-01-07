package interfaces;

import java.util.ArrayList;

import excecoes.ClienteNaoApitoParaEmprestimos;
import excecoes.EmprestimoNaoEncontradoExcepition;
import excecoes.LivriNaoDisponivelExcepition;
import excecoes.SemClientesEmAtrasoExcepition;
import excecoes.SemHistoricoDeEmprestimosExcepition;
import model.Cliente;
import model.Emprestimo;

public interface IEmprestimos {
	
	void adicionar(Emprestimo emprestimo) throws ClienteNaoApitoParaEmprestimos, LivriNaoDisponivelExcepition;
	Emprestimo pesquisar(int idEmprestimo) throws EmprestimoNaoEncontradoExcepition;
	void remover(Emprestimo emprestimo) throws EmprestimoNaoEncontradoExcepition;
	void finalizar(Emprestimo emprestimo) throws EmprestimoNaoEncontradoExcepition;
	ArrayList<Emprestimo> pesquisarPorCliente(int idCliente) throws SemHistoricoDeEmprestimosExcepition;
	ArrayList<Emprestimo> pesquisarPorAutor(String nome) throws SemHistoricoDeEmprestimosExcepition;
	ArrayList<Emprestimo> pesquisarPorTitulo(String titulo) throws SemHistoricoDeEmprestimosExcepition;
	ArrayList<Emprestimo> pesquisarAtrasados() throws SemClientesEmAtrasoExcepition;
	ArrayList<Emprestimo>getEmprestimo();
}
