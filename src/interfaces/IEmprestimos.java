package interfaces;

import java.util.ArrayList;

import excecoes.ClienteNaoApitoParaEmprestimos;
import excecoes.EmprestimoNaoEncontradoExcepition;
import excecoes.SemClientesEmAtrasoExcepition;
import excecoes.SemHistoricoDeEmprestimosExcepition;
import model.Cliente;
import model.Emprestimo;

public interface IEmprestimos {
	
	void adicionar(Emprestimo emprestimo) throws ClienteNaoApitoParaEmprestimos;
	Emprestimo pesquisar(int idEmprestimo) throws EmprestimoNaoEncontradoExcepition;
	void remover(Emprestimo emprestimo) throws EmprestimoNaoEncontradoExcepition;
	void finalizar(Emprestimo emprestimo) throws EmprestimoNaoEncontradoExcepition;
	ArrayList<Emprestimo> pesquizarPorCliente(int idCliente) throws SemHistoricoDeEmprestimosExcepition;
	ArrayList<Emprestimo> pesquizarPorAutor(String nome) throws SemHistoricoDeEmprestimosExcepition;
	ArrayList<Emprestimo> pesquizarPorTitulo(String titulo) throws SemHistoricoDeEmprestimosExcepition;
	ArrayList<Cliente> pesquizarAtrasados() throws SemClientesEmAtrasoExcepition;
}
