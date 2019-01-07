package interfaces;


import java.util.ArrayList;

import excecoes.ClienteJaAdicionadoExcepition;
import excecoes.ClienteNaoEncontradoExcepition;
import model.Cliente;

public interface IClientes {
	void adicionar(Cliente cliente) throws ClienteJaAdicionadoExcepition;
	 Cliente procurar(int id) throws ClienteNaoEncontradoExcepition;
	 ArrayList<Cliente> procurar(String nome);
	 void Atualizar(Cliente cliente) throws ClienteNaoEncontradoExcepition;

}
