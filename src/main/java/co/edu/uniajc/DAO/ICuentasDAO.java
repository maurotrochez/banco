package co.edu.uniajc.DAO;

import java.util.List;

import co.edu.uniajc.model.Cuentas;

public interface ICuentasDAO {

	public void save(Cuentas cuenta) throws Exception;
	public void update(Cuentas cuenta) throws Exception;
	public void delete(Cuentas cuenta) throws Exception;
	public Cuentas consultarPorId(String cuentaId) throws Exception;
	public List<Cuentas> consultarTodos() throws Exception;
}
