package interfaces;

import model.Emprestimo;

public interface IEmprestimos {
	
	void adicionar(Emprestimo emprestimo);
	Emprestimo pesquisar(int idEmprestimo);
	void remover(Emprestimo emprestimo);
	void finalizar(Emprestimo emprestimo);
}
