
package repositorioArrayList;

import java.util.ArrayList;

import excecoes.ClienteJaAdicionadoExcepition;
import excecoes.ClienteNaoEncontradoExcepition;
import interfaces.IClientes;
import model.Cliente;

public class RepositorioClientes implements IClientes{
	private static int idCliente;
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();

	public RepositorioClientes() {
		RepositorioClientes.idCliente =0;
	}

	private boolean existe(Cliente cliente) {
		for (Cliente c : clientes) {
			if (c.getNome() == cliente.getNome() && c.getTelefone().equals(cliente.getTelefone()))
				return true;
		}
		return false;
	}

	public void adicionar(Cliente cliente) throws ClienteJaAdicionadoExcepition {
		if(!existe(cliente)) {
			RepositorioClientes.idCliente = RepositorioClientes.idCliente + 1;
			cliente.setIdCliente(RepositorioClientes.idCliente);
			this.clientes.add(cliente);
		}
		else
			throw new ClienteJaAdicionadoExcepition(cliente.getNome());
	}

	public Cliente procurar(int id) throws ClienteNaoEncontradoExcepition {
		for(Cliente c: clientes) {
			if(c.getIdCliente() == id)
				return c;
		}
		throw new ClienteNaoEncontradoExcepition();
	}

	public ArrayList<Cliente> procurar(String nome) {
		ArrayList<Cliente> lista = new ArrayList<Cliente>();
		for(Cliente c: clientes) {
			if(c.getNome().contains(nome))
				lista.add(c);
		}
			return lista;
	}

	public void Atualizar(Cliente cliente) throws ClienteNaoEncontradoExcepition {
		Cliente c = this.procurar(cliente.getIdCliente());
		c.setAptoAEmprestimos(cliente.isAptoAEmprestimos());
		c.setTelefone(cliente.getTelefone());
	}
}
