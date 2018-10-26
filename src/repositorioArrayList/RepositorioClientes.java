package repositorioArrayList;

import java.util.ArrayList;

import model.Cliente;

public class RepositorioClientes {
	private static int idCliente;
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();

	public RepositorioClientes() {
		RepositorioClientes.idCliente =0;
	}

	public boolean existe(Cliente cliente) {
		for (Cliente c : clientes) {
			if (c.getNome() == cliente.getNome() && c.getTelefone().equals(cliente.getTelefone()))
				return true;
		}
		return false;
	}

	public void adicionar(Cliente cliente) {
		if(!existe(cliente)) {
			RepositorioClientes.idCliente = RepositorioClientes.idCliente + 1;
			cliente.setIdCliente(RepositorioClientes.idCliente);
			this.clientes.add(cliente);
		}
	}

	public Cliente procurar(int id) {
		for(Cliente c: clientes) {
			if(c.getIdCliente() == id)
				return c;
		}
		return null;
	}

	public Cliente procurar(String nome) {
		for(Cliente c: clientes) {
			if(c.getNome() == nome)
				return c;
		}
		return null;
	}

	public void Atualizar(Cliente cliente) {
		Cliente c = this.procurar(cliente.getIdCliente());
		c.setAptoAEmprestimos(cliente.isAptoAEmprestimos());
		c.setTelefone(cliente.getTelefone());
	}
}
