package interfaces;


import excecoes.ClienteJaAdicionadoExcepition;
import excecoes.ClienteNaoEncontradoExcepition;
import model.Cliente;

public interface IClientes {
	void adicionar(Cliente cliente) throws ClienteJaAdicionadoExcepition;
	 Cliente procurar(int id) throws ClienteNaoEncontradoExcepition;
	 Cliente procurar(String nome) throws ClienteNaoEncontradoExcepition;
	 void Atualizar(Cliente cliente) throws ClienteNaoEncontradoExcepition;

}
