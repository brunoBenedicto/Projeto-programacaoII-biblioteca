package repositorioArrayList;

import java.time.LocalDate;
import java.util.ArrayList;

import excecoes.ClienteNaoApitoParaEmprestimos;
import excecoes.EmprestimoNaoEncontradoExcepition;
import excecoes.LivriNaoDisponivelExcepition;
import excecoes.SemClientesEmAtrasoExcepition;
import excecoes.SemHistoricoDeEmprestimosExcepition;
import interfaces.IEmprestimos;
import model.Cliente;
import model.Emprestimo;
import model.Livro;

public class RepositorioEmprestimos implements IEmprestimos {
	private ArrayList<Emprestimo> emprestimos = new ArrayList<Emprestimo>();

	public RepositorioEmprestimos() {

	}

	public void adicionar(Emprestimo emprestimo) throws ClienteNaoApitoParaEmprestimos, LivriNaoDisponivelExcepition {
		if (emprestimo.getCliente().isAptoAEmprestimos()) {
			if (!emprestimo.getLivros()[0].isDisponivel()||!emprestimo.getLivros()[1].isDisponivel()) {
				throw new LivriNaoDisponivelExcepition ();
			}
				else {
					this.emprestimos.add(emprestimo);
					emprestimo.getCliente().setAptoAEmprestimos(false);
					for (int i = 0; i < emprestimo.getLivros().length; i++) {
							emprestimo.getLivros()[i].setDisponivel(false);
					}
				}
		} else
			throw new ClienteNaoApitoParaEmprestimos(emprestimo.getCliente().getIdCliente());
		/*if (!emprestimo.getLivros()[0].isDisponivel()||!emprestimo.getLivros()[1].isDisponivel()) {
			throw new LivriNaoDisponivelExcepition ();
		}
		else {
			this.emprestimos.add(emprestimo);
			emprestimo.getCliente().setAptoAEmprestimos(false);
			for (int i = 0; i < emprestimo.getLivros().length; i++) {
				if(emprestimo.getLivros()[i]!= null)
				emprestimo.getLivros()[i].setDisponivel(false);
			}
		}*/
	}

	public Emprestimo pesquisar(int idEmprestimo) throws EmprestimoNaoEncontradoExcepition {
		for (Emprestimo e : this.emprestimos)
			if (e.getIdEmprestimo() == idEmprestimo) {
				return e;
			}
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
		pesquisar(emprestimo.getIdEmprestimo()).finalizarEmprestimo();
	}

	public ArrayList<Emprestimo> pesquisarPorCliente(int idCliente) throws SemHistoricoDeEmprestimosExcepition {
		ArrayList<Emprestimo> emprestimosPorCliente = new ArrayList<Emprestimo>();
		for (Emprestimo e : emprestimos) {
			if (e.getCliente().getIdCliente() == idCliente)
				emprestimosPorCliente.add(e);
		}
		if (!emprestimosPorCliente.isEmpty())
			return emprestimosPorCliente;
		else
			throw new SemHistoricoDeEmprestimosExcepition();
	}

	public ArrayList<Emprestimo> pesquisarPorAutor(String nome) throws SemHistoricoDeEmprestimosExcepition {
		ArrayList<Emprestimo> emprestimosPorAutor = new ArrayList<Emprestimo>();
		for (Emprestimo e : emprestimos) {
			for (Livro l : e.getLivros())
				if (l.getAutor().equals(nome))
					emprestimosPorAutor.add(e);
		}
		if (!emprestimosPorAutor.isEmpty())
			return emprestimosPorAutor;
		else
			throw new SemHistoricoDeEmprestimosExcepition();
	}

	public ArrayList<Emprestimo> pesquisarPorTitulo(String titulo) throws SemHistoricoDeEmprestimosExcepition {
		ArrayList<Emprestimo> emprestimosPorTitulo = new ArrayList<Emprestimo>();
		for (Emprestimo e : emprestimos) {
			for (Livro l : e.getLivros())
				if (l.getAutor().equals(titulo))
					emprestimosPorTitulo.add(e);
		}
		if (!emprestimosPorTitulo.isEmpty())
			return emprestimosPorTitulo;
		else
			throw new SemHistoricoDeEmprestimosExcepition();
	}

	public ArrayList<Emprestimo> pesquisarAtrasados() throws SemClientesEmAtrasoExcepition {
		ArrayList<Emprestimo> atrasados = new ArrayList<Emprestimo>();
		for (Emprestimo e : this.emprestimos) {
			if (e.getDevolucao().getDataPrevista().toEpochDay() < LocalDate.now().toEpochDay()
					&& e.getDevolucao().getDataDevolucao() != null)
				atrasados.add(e);
		}
		if (!atrasados.isEmpty())
			return atrasados;
		else
			throw new SemClientesEmAtrasoExcepition();
	}

	@Override
	public ArrayList<Emprestimo> getEmprestimo() {
		return this.emprestimos;
	}
}