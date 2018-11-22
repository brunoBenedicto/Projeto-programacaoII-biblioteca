package repositorioArrayList;

import java.util.ArrayList;

import excecoes.EmprestimoNaoEncontradoExcepition;
import excecoes.SemHistoricoDeEmprestimosExcepition;
import interfaces.IEmprestimos;
import model.Emprestimo;
import model.Livro;

public class RepositorioEmprestimos  implements IEmprestimos{
	private ArrayList<Emprestimo> emprestimos = new ArrayList<Emprestimo>();

	public RepositorioEmprestimos() {

	}

	public void adicionar(Emprestimo emprestimo) {
		this.emprestimos.add(emprestimo);
	}

	public Emprestimo pesquisar(int idEmprestimo) throws EmprestimoNaoEncontradoExcepition {
		for (Emprestimo e : this.emprestimos)
			if (e.getIdEmprestimo()==idEmprestimo)
				return e;

		throw new EmprestimoNaoEncontradoExcepition();
	}

	public void remover(Emprestimo emprestimo) throws EmprestimoNaoEncontradoExcepition {
		if (this.existe(emprestimo))
			this.emprestimos.remove(emprestimo);
		else
			throw new EmprestimoNaoEncontradoExcepition();
	}

	private boolean existe(Emprestimo emprestimo) {
		if (this.emprestimos.contains(emprestimo))
			return true;
		return false;
	}

	public void finalizar(Emprestimo emprestimo) throws EmprestimoNaoEncontradoExcepition {
		pesquisar(emprestimo.getCliente().getIdCliente()).finalizarEmprestimo();
	}

	
	
	public ArrayList<Emprestimo> pesquizarPorCliente(int idCliente) throws SemHistoricoDeEmprestimosExcepition {
		ArrayList<Emprestimo> emprestimosPorCliente = new ArrayList<Emprestimo>();
		for(Emprestimo e : emprestimos) {
			if(e.getCliente().getIdCliente() == idCliente)
				emprestimosPorCliente.add(e);
		}
		if(!emprestimosPorCliente.isEmpty())
			return emprestimosPorCliente;
		else
			throw new SemHistoricoDeEmprestimosExcepition();
	}


	public ArrayList<Emprestimo> pesquizarPorAutor(String nome) throws SemHistoricoDeEmprestimosExcepition {
		ArrayList<Emprestimo> emprestimosPorAutor = new ArrayList<Emprestimo>();
		for(Emprestimo e : emprestimos) {
			for(Livro l : e.getLivros())
				if(l.getAutor().equals(nome))
					emprestimosPorAutor.add(e);
		}
		if(!emprestimosPorAutor.isEmpty())
			return emprestimosPorAutor;
		else
			throw new SemHistoricoDeEmprestimosExcepition();
	}

	
	public ArrayList<Emprestimo> pesquizarPorTitulo(String titulo) throws SemHistoricoDeEmprestimosExcepition {
		ArrayList<Emprestimo> emprestimosPorTitulo = new ArrayList<Emprestimo>();
		for(Emprestimo e : emprestimos) {
			for(Livro l : e.getLivros())
				if(l.getAutor().equals(titulo))
					emprestimosPorTitulo.add(e);
		}
		if(!emprestimosPorTitulo.isEmpty())
			return emprestimosPorTitulo;
		else
			throw new SemHistoricoDeEmprestimosExcepition();
	}
}