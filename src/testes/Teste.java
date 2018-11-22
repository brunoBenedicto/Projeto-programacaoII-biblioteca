package testes;

import controle.Fachada;
import excecoes.ClienteJaAdicionadoExcepition;
import excecoes.ClienteNaoEncontradoExcepition;
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
		Fachada fachada = Fachada.getInstance();
		Factory fabrica = new Factory();
		try {
			fachada.adicionar(fabrica.novoCliente("bruno", fabrica.novoTelefone(81, 84367170)));
		} catch (ClienteJaAdicionadoExcepition e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DddInvalidoExcepiton e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumeroInvalidoExcepiton e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			System.out.println(fachada.procurar("bruno").getNome()+" "+ fachada.procurar("bruno").getIdCliente());
		} catch (ClienteNaoEncontradoExcepition e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
