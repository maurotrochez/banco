package co.edu.uniajc.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import co.edu.uniajc.DAO.ITiposUsuariosDAO;
import co.edu.uniajc.model.TiposUsuarios;
import co.edu.uniajc.utils.IValidate;

public class TiposUsuariosLogic implements ITiposUsuariosLogic {

	@Autowired
	ITiposUsuariosDAO tipoUsuarioDAO;
	
	@Autowired
	IValidate validate;
	
	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void save(TiposUsuarios tipoUsuario) throws Exception {
		if(validate.validateObject(tipoUsuario))
			throw new Exception("El tipo de usuario es nulo");
		
		if(validate.validateId(tipoUsuario.getTusuCodigo()))
			throw new Exception("La codigo es obligatorio");
		
		if(validate.validateObject(tipoUsuario.getTusuNombre()))
			throw new Exception("El nombre es obligatorio");
		
		tipoUsuarioDAO.save(tipoUsuario);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void update(TiposUsuarios tipoUsuario) throws Exception {
		if(validate.validateObject(tipoUsuario))
			throw new Exception("El tipo usuario es nulo");
		
		if(validate.validateId(tipoUsuario.getTusuCodigo()))
			throw new Exception("La codigo es obligatorio");
		
		if(validate.validateObject(tipoUsuario.getTusuNombre()))
			throw new Exception("El nombre es obligatorio");
		
		tipoUsuarioDAO.update(tipoUsuario);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void delete(TiposUsuarios tipoUsuario) throws Exception {
		if(validate.validateObject(tipoUsuario)){
			throw new Exception("No el tipo de usuario");
		}
		
		tipoUsuarioDAO.delete(tipoUsuario);

	}

	@Override
	@Transactional(readOnly=true,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public TiposUsuarios consultarPorId(Long tipoUsuarioId) throws Exception {
		if(validate.validateId(tipoUsuarioId))
			throw new Exception("La id es obligatorio");
		
		TiposUsuarios tUsr = tipoUsuarioDAO.consultarPorId(tipoUsuarioId);
		
		if(validate.validateObject(tUsr))
			throw new Exception("El tipo usuario no existe");
		else 
			return tUsr;
	}

	@Override
	@Transactional(readOnly=true,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public List<TiposUsuarios> consultarTodos() throws Exception {
		List<TiposUsuarios> tUsrs = tipoUsuarioDAO.consultarTodos();
		if(validate.validateObject(tUsrs))
			throw new Exception("No hay creados tipos de usuarios");
		return tUsrs;
	}

}
