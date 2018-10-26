package repositorioArrayList;

import java.util.ArrayList;

import model.Emprestimo;

public class RepositorioEmprestimos {
	private ArrayList<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
	
	public RepositorioEmprestimos(ArrayList<Emprestimo> emprestimos) {
		
	}
	
	public void adicionar (Emprestimo emprestimo) {
		this.emprestimos.add(emprestimo);
	}
	

}
