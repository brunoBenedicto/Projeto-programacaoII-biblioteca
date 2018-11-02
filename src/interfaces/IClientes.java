package interfaces;

import model.Cliente;

public interface IClientes {
	void adicionar(Cliente cliente);
	 Cliente procurar(int id);
	 Cliente procurar(String nome);
	 void Atualizar(Cliente cliente);

}
