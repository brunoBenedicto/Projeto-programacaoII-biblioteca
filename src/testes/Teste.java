package testes;

import excecoes.DddInvalidoExcepiton;
import excecoes.LivroNaoEncontradoException;
import excecoes.NumeroInvalidoExcepiton;
import interfaces.IClientes;
import interfaces.IEmprestimos;
import interfaces.Ilivros;
import model.Atendente;
import model.Factory;
import model.Funcionario;
import model.Telefone;
import repositorioArrayList.RepositorioClientes;
import repositorioArrayList.RepositorioEmprestimos;
import repositorioArrayList.RepositorioLivros;

public class Teste {

	public static void main(String[] args)  {
		IClientes clientes = new RepositorioClientes();
		Ilivros livros = new RepositorioLivros();
		IEmprestimos emprestimos = new RepositorioEmprestimos();
		Funcionario funcionario = new Atendente("atendente", null);
		Factory fabrica = new Factory();
		Telefone tel;
		
		try {
			tel = new Telefone(21, 2345678);
		} catch (DddInvalidoExcepiton e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (NumeroInvalidoExcepiton e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	
	}

}
