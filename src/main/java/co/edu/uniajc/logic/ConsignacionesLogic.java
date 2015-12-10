package co.edu.uniajc.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import co.edu.uniajc.DAO.IConsignacionesDAO;
import co.edu.uniajc.DAO.IUsuariosDAO;
import co.edu.uniajc.model.Consignaciones;
import co.edu.uniajc.model.ConsignacionesId;
import co.edu.uniajc.model.Usuarios;
import co.edu.uniajc.utils.IValidate;

@Service
@Scope("singleton")
public class ConsignacionesLogic implements IConsignacionesLogic {

	@Autowired
	IConsignacionesDAO consignacionDAO;
	
	@Autowired
	IUsuariosDAO usuariosDAO;
	
	@Autowired
	IValidate validate;
	
	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void save(Consignaciones consignacion) throws Exception {
		if(validate.validateObject(consignacion))
			throw new Exception("La consignacion es nulo");
		
		if(validate.validateObject(consignacion.getId()))
			throw new Exception("El id es obligatorio");
		
		if(validate.validateObject(consignacion.getUsuarios()))
			throw new Exception("El tipo de usuario es obligatorio");
		
		if(validate.validateObject(consignacion.getCuentas()))
			throw new Exception("El nombre es obligatorio");
		
		if(validate.validateString(consignacion.getConDescripcion()))
			throw new Exception("La descripcion es obligatoria");
		
		if(validate.validateDate(consignacion.getConFecha()))
			throw new Exception("La fecha es obligatoria");
		
		Usuarios usr = usuariosDAO.consultarPorId(consignacion.getUsuarios().getUsuCedula());
		
		if(validate.validateObject(usr))
			throw new Exception("El usuario no existe");
		
		Consignaciones con = consignacionDAO.consultarPorId(consignacion.getId());
		
		if(!validate.validateObject(con))
			throw new Exception("La consignacion ya existe");
		
		consignacionDAO.save(consignacion);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void update(Consignaciones consignacion) throws Exception {
		if(validate.validateObject(consignacion))
			throw new Exception("La consignacion es nulo");
		
		if(validate.validateObject(consignacion.getId()))
			throw new Exception("El id es obligatorio");
		
		if(validate.validateObject(consignacion.getUsuarios()))
			throw new Exception("El tipo de usuario es obligatorio");
		
		if(validate.validateObject(consignacion.getCuentas()))
			throw new Exception("El nombre es obligatorio");
		
		if(validate.validateString(consignacion.getConDescripcion()))
			throw new Exception("La descripcion es obligatoria");
		
		if(validate.validateDate(consignacion.getConFecha()))
			throw new Exception("La fecha es obligatoria");
		
		Usuarios usr = usuariosDAO.consultarPorId(consignacion.getUsuarios().getUsuCedula());
		
		if(validate.validateObject(usr))
			throw new Exception("El usuario no existe");
		
		consignacionDAO.update(consignacion);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void delete(Consignaciones consignacion) throws Exception {
		if(validate.validateObject(consignacion)){
			throw new Exception("La consignacion no exite");
		}
		
		consignacionDAO.delete(consignacion);

	}

	@Override
	@Transactional(readOnly=true,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public Consignaciones consultarPorId(ConsignacionesId consignacionId) throws Exception {
		if(validate.validateObject(consignacionId))
			throw new Exception("La identificacion es obligatoria");
		
		Consignaciones con = consignacionDAO.consultarPorId(consignacionId);
		
		if(validate.validateObject(con))
			throw new Exception("La consignacion no existe");
		else 
			return con;
	}

	@Override
	@Transactional(readOnly=true,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public List<Consignaciones> consultarTodos() throws Exception {
		List<Consignaciones> cons = consignacionDAO.consultarTodos();
		if(validate.validateObject(cons))
			throw new Exception("No hay creados consignaciones");
		return cons;
	}
}
