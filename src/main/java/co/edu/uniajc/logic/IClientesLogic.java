package co.edu.uniajc.logic;

import java.util.List;

import co.edu.uniajc.model.Clientes;

public interface IClientesLogic {
	public void grabar(Clientes clientes)throws Exception;
	public void modificar(Clientes clientes)throws Exception;
	public void borrar(Clientes clientes)throws Exception;
	public Clientes consultarPorId(Long cliId)throws Exception;
	public List<Clientes> consultarTodos()throws Exception;
}
