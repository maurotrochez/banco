package co.edu.uniajc.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniajc.DAO.ITiposUsuariosDAO;
import co.edu.uniajc.DAO.IUsuariosDAO;
import co.edu.uniajc.model.Clientes;
import co.edu.uniajc.model.TiposUsuarios;
import co.edu.uniajc.model.Usuarios;
import co.edu.uniajc.utils.IValidate;

@Service
@Scope("singleton")
public class UsuariosLogic implements IUsuariosLogic {

	@Autowired
	IUsuariosDAO usuariosDAO;
	
	@Autowired
	ITiposUsuariosDAO tiposUsuarioDAO;
	
	@Autowired
	IValidate validate;
	
	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void save(Usuarios usuario) throws Exception {
		if(validate.validateObject(usuario))
			throw new Exception("El usuario es nulo");
		
		if(validate.validateId(usuario.getUsuCedula()))
			throw new Exception("La cedula es obligatoria");
		
		if(validate.validateObject(usuario.getTiposUsuarios()))
			throw new Exception("El tipo de usuario es obligatorio");
		
		if(validate.validateString(usuario.getUsuNombre()))
			throw new Exception("El nombre es obligatorio");
		
		if(validate.validateString(usuario.getUsuLogin()))
			throw new Exception("El login es obligatorio");
		
		if(validate.validateString(usuario.getUsuClave()))
			throw new Exception("La clave es obligatoria");
		
		TiposUsuarios tpU = tiposUsuarioDAO.consultarPorId(usuario.getTiposUsuarios().getTusuCodigo());
		
		if(validate.validateObject(tpU))
			throw new Exception("El tipo de usuario no existe");
		
		Usuarios usr = usuariosDAO.consultarPorId(usuario.getUsuCedula());
		
		if(!validate.validateObject(usr))
			throw new Exception("El usuario ya existe");
		
		usuariosDAO.save(usuario);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void update(Usuarios usuario) throws Exception {
		if(validate.validateObject(usuario))
			throw new Exception("El usuario es nulo");
		
		if(validate.validateId(usuario.getUsuCedula()))
			throw new Exception("La cedula es obligatoria");
		
		if(validate.validateObject(usuario.getTiposUsuarios()))
			throw new Exception("El tipo de usuario es obligatorio");
		
		if(validate.validateString(usuario.getUsuNombre()))
			throw new Exception("El nombre es obligatorio");
		
		if(validate.validateString(usuario.getUsuLogin()))
			throw new Exception("El login es obligatorio");
		
		if(validate.validateString(usuario.getUsuClave()))
			throw new Exception("La clave es obligatoria");
		
		TiposUsuarios tpU = tiposUsuarioDAO.consultarPorId(usuario.getTiposUsuarios().getTusuCodigo());
		
		if(validate.validateObject(tpU))
			throw new Exception("El tipo de usuario no existe");
		
		usuariosDAO.update(usuario);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void delete(Usuarios usuario) throws Exception {
		if(validate.validateObject(usuario)){
			throw new Exception("No existe usuario");
		}
		
		usuariosDAO.delete(usuario);

	}

	@Override
	@Transactional(readOnly=true,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public Usuarios consultarPorId(Long usuarioId) throws Exception {
		if(validate.validateId(usuarioId))
			throw new Exception("La identificacion es obligatoria");
		
		Usuarios usr = usuariosDAO.consultarPorId(usuarioId);
		
		if(validate.validateObject(usr))
			throw new Exception("Usuario no existe");
		else 
			return usr;
	}

	@Override
	@Transactional(readOnly=true,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public List<Usuarios> consultarTodos() throws Exception {
		List<Usuarios> usrs = usuariosDAO.consultarTodos();
		if(validate.validateObject(usrs))
			throw new Exception("No hay creados usuarios");
		return usrs;
	}

}
