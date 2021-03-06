package controle;

import java.util.ArrayList;

import excecoes.ClienteJaAdicionadoExcepition;
import excecoes.ClienteNaoEncontradoExcepition;
import interfaces.IClientes;
import model.Cliente;
import repositorioArrayList.RepositorioClientes;

public class ControleClientes {
	private IClientes clientes = new RepositorioClientes();

	public ControleClientes() {
	}

	public void adicionar(Cliente cliente) throws ClienteJaAdicionadoExcepition {
		this.clientes.adicionar(cliente);
	}

	public Cliente procurar(int id) throws ClienteNaoEncontradoExcepition {
		return this.clientes.procurar(id);
	}

	public ArrayList<Cliente> procurar(String nome) {
		return this.clientes.procurar(nome);
	}

	public void Atualizar(Cliente cliente) throws ClienteNaoEncontradoExcepition {
		this.clientes.Atualizar(cliente);
	}
}
