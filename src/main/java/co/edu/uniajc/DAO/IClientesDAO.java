package co.edu.uniajc.DAO;

import java.util.List;

import co.edu.uniajc.model.Clientes;

public interface IClientesDAO {
	
	public void save(Clientes cliente) throws Exception;
	public void update(Clientes cliente) throws Exception;
	public void delete(Clientes cliente) throws Exception;
	public Clientes consultarPorId(Long cliId) throws Exception;
	public List<Clientes> consultarTodos() throws Exception;
}
