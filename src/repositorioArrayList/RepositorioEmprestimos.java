package repositorioArrayList;

import java.util.ArrayList;

import interfaces.IEmprestimos;
import model.Emprestimo;

public class RepositorioEmprestimos  implements IEmprestimos{
	private ArrayList<Emprestimo> emprestimos = new ArrayList<Emprestimo>();

	public RepositorioEmprestimos() {

	}

	public void adicionar(Emprestimo emprestimo) {
		this.emprestimos.add(emprestimo);
	}

	public Emprestimo pesquisar(int idEmprestimo) {
		for (Emprestimo e : this.emprestimos)
			if (e.getIdEmprestimo()==idEmprestimo)
				return e;

		return null;
	}

	public void remover(Emprestimo emprestimo) {
		if (this.existe(emprestimo))
			this.emprestimos.remove(emprestimo);
	}

	private boolean existe(Emprestimo emprestimo) {
		if (this.emprestimos.contains(emprestimo))
			return true;
		return false;
	}

	public void finalizar(Emprestimo emprestimo) {
		pesquisar(emprestimo.getCliente().getIdCliente()).finalizarEmprestimo();
	}
}