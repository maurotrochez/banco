package co.edu.uniajc.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import co.edu.uniajc.DAO.IRetirosDAO;
import co.edu.uniajc.DAO.IUsuariosDAO;
import co.edu.uniajc.model.Retiros;
import co.edu.uniajc.model.RetirosId;
import co.edu.uniajc.model.Usuarios;
import co.edu.uniajc.utils.IValidate;

@Service
@Scope("prototype")
public class RetirosLogic implements IRetirosLogic {

	@Autowired
	IRetirosDAO retirosDAO;
	
	@Autowired
	IUsuariosDAO usuariosDAO;
	
	@Autowired
	IValidate validate;
	
	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void save(Retiros retiro) throws Exception {
		if(validate.validateObject(retiro))
			throw new Exception("El retiro es nulo");
		
		if(validate.validateObject(retiro.getId()))
			throw new Exception("El id es obligatorio");
		
		if(validate.validateObject(retiro.getUsuarios()))
			throw new Exception("El tipo de usuario es obligatorio");
		
		if(validate.validateString(retiro.getRetDescripcion()))
			throw new Exception("La descripcion es obligatoria");
		
		if(validate.validateDate(retiro.getRetFecha()))
			throw new Exception("La fecha es obligatoria");
		
		Usuarios usr = usuariosDAO.consultarPorId(retiro.getUsuarios().getUsuCedula());
		
		if(validate.validateObject(usr))
			throw new Exception("El usuario no existe");
		
		Retiros ret = retirosDAO.consultarPorId(retiro.getId());
		
		if(!validate.validateObject(ret))
			throw new Exception("El retiro ya existe");
		
		retirosDAO.save(retiro);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void update(Retiros retiro) throws Exception {
		if(validate.validateObject(retiro))
			throw new Exception("La consignacion es nulo");
		
		if(validate.validateObject(retiro.getId()))
			throw new Exception("El id es obligatorio");
		
		if(validate.validateObject(retiro.getUsuarios()))
			throw new Exception("El tipo de usuario es obligatorio");
		
		if(validate.validateObject(retiro.getCuentas()))
			throw new Exception("El nombre es obligatorio");
		
		if(validate.validateString(retiro.getRetDescripcion()))
			throw new Exception("La descripcion es obligatoria");
		
		if(validate.validateDate(retiro.getRetFecha()))
			throw new Exception("La fecha es obligatoria");
		
		Usuarios usr = usuariosDAO.consultarPorId(retiro.getUsuarios().getUsuCedula());
		
		if(validate.validateObject(usr))
			throw new Exception("El usuario no existe");
		
		retirosDAO.update(retiro);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void delete(RetirosId retiroId) throws Exception {
		
		if(validate.validateObject(retiroId))
			throw new Exception("El retiro no exite");
		
		Retiros ret = retirosDAO.consultarPorId(retiroId);
		
		if(validate.validateObject(ret))
			throw new Exception("El retiro no exite");
		
		retirosDAO.delete(ret);

	}

	@Override
	@Transactional(readOnly=true,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public Retiros consultarPorId(RetirosId retiroId) throws Exception {
		if(validate.validateObject(retiroId))
			throw new Exception("El id es obligatoria");
		
		Retiros ret = retirosDAO.consultarPorId(retiroId);
		
		if(validate.validateObject(ret))
			throw new Exception("El retiro no existe");
		else 
			return ret;
	}

	@Override
	@Transactional(readOnly=true,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public List<Retiros> consultarTodos() throws Exception {
		List<Retiros> rets = retirosDAO.consultarTodos();
		if(validate.validateObject(rets))
			throw new Exception("No hay creados retiros");
		return rets;
	}

}
