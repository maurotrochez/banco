package co.edu.uniajc.DAO;

import java.util.List;

import co.edu.uniajc.model.Usuarios;

public interface IUsuariosDAO {

	public void save(Usuarios usuario) throws Exception;
	public void update(Usuarios usuario) throws Exception;
	public void delete(Usuarios usuario) throws Exception;
	public Usuarios consultarPorId(Long usuarioId) throws Exception;
	public List<Usuarios> consultarTodos() throws Exception;
}
