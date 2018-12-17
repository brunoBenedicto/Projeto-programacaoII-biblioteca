package testes;

import java.time.LocalDate;
import java.time.Month;

import controle.Fachada;
import controle.Factory;
import excecoes.ClienteJaAdicionadoExcepition;
import excecoes.ClienteNaoApitoParaEmprestimos;
import excecoes.ClienteNaoEncontradoExcepition;
import excecoes.DddInvalidoExcepiton;
import excecoes.EmprestimoNaoEncontradoExcepition;
import excecoes.LivroNaoEncontradoException;
import excecoes.NumeroInvalidoExcepiton;
import interfaces.IClientes;
import interfaces.IEmprestimos;
import interfaces.Ilivros;
import model.Atendente;
import model.Funcionario;
import model.Livro;
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
		
		fachada.adicionar(fabrica.novoLivro("auto da compadecida", "ariano suassuna", LocalDate.of(1980, Month.APRIL, 20)));
		fachada.adicionar(fabrica.novoLivro("auto da compadecida", "ariano suassuna", LocalDate.of(1980, Month.APRIL, 20)));

		for(Livro l : fachada.procurarPorAutor("ariano")) {
			System.out.println(l.getIdLivro());
		}
		
		try {
			fachada.adicionar(fabrica.novoEmprestimo(fachada.procurarLivro(1), null, fachada.procurar("bruno")));
		} catch (ClienteNaoApitoParaEmprestimos e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LivroNaoEncontradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClienteNaoEncontradoExcepition e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		try {
			fachada.adicionar(fabrica.novoEmprestimo(fachada.procurarLivro(1), null, fachada.procurar("bruno")));
		} catch (ClienteNaoApitoParaEmprestimos e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LivroNaoEncontradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClienteNaoEncontradoExcepition e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			fachada.finalizar(fachada.pesquisar(0));
		} catch (EmprestimoNaoEncontradoExcepition e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			System.out.println(fachada.pesquisar(0).getCliente().getNome());
		} catch (EmprestimoNaoEncontradoExcepition e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			fachada.adicionar(fabrica.novoEmprestimo(fachada.procurarLivro(1), null, fachada.procurar("bruno")));
		} catch (ClienteNaoApitoParaEmprestimos e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LivroNaoEncontradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClienteNaoEncontradoExcepition e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
