package interfaces;

import java.util.ArrayList;

import excecoes.EmprestimoNaoEncontradoExcepition;
import excecoes.SemHistoricoDeEmprestimosExcepition;
import model.Emprestimo;

public interface IEmprestimos {
	
	void adicionar(Emprestimo emprestimo);
	Emprestimo pesquisar(int idEmprestimo) throws EmprestimoNaoEncontradoExcepition;
	void remover(Emprestimo emprestimo) throws EmprestimoNaoEncontradoExcepition;
	void finalizar(Emprestimo emprestimo) throws EmprestimoNaoEncontradoExcepition;
	ArrayList<Emprestimo> pesquizarPorCliente(int idCliente) throws SemHistoricoDeEmprestimosExcepition;
	ArrayList<Emprestimo> pesquizarPorAutor(String nome) throws SemHistoricoDeEmprestimosExcepition;
	ArrayList<Emprestimo> pesquizarPorTitulo(String titulo) throws SemHistoricoDeEmprestimosExcepition;
}
