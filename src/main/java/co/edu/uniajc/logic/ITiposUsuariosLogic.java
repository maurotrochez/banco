package co.edu.uniajc.logic;

import java.util.List;

import co.edu.uniajc.model.TiposUsuarios;

public interface ITiposUsuariosLogic {
	public void save(TiposUsuarios tUsuario) throws Exception;
	public void update(TiposUsuarios tUsuario) throws Exception;
	public void delete(TiposUsuarios tUsuario) throws Exception;
	public TiposUsuarios consultarPorId(Long tUsuarioId) throws Exception;
	public List<TiposUsuarios> consultarTodos() throws Exception;

}
