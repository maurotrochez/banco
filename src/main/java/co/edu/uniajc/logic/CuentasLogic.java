package co.edu.uniajc.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniajc.DAO.IClientesDAO;
import co.edu.uniajc.DAO.ICuentasDAO;
import co.edu.uniajc.model.Clientes;
import co.edu.uniajc.model.Cuentas;
import co.edu.uniajc.utils.IValidate;

@Service
@Scope("singleton")
public class CuentasLogic implements ICuentasLogic {

	@Autowired
	ICuentasDAO cuentasDAO;
	
	@Autowired
	IClientesDAO clientesDAO;
	
	@Autowired
	IValidate validate;
	
	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void save(Cuentas cuenta) throws Exception {
		if(validate.validateObject(cuenta))
			throw new Exception("La cuenta es nula");
		
		if(validate.validateString(cuenta.getCueNumero()))
			throw new Exception("El numero de cuenta es obligatoria");
		
		if(validate.validateNumeric(cuenta.getCueSaldo()))
			throw new Exception("El saldo es obligatorio");
		
		if(validate.validateString(cuenta.getCueActiva()))
			throw new Exception("El tipo de cuenta es obligatorio");
		
		if(validate.validateString(cuenta.getCueClave()))
			throw new Exception("La clave es obligatoria");
		
		Clientes cli = clientesDAO.consultarPorId(cuenta.getClientes().getCliId());
		
		if(validate.validateObject(cli))
			throw new Exception("El cliente no existe");
		
		cuentasDAO.save(cuenta);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void update(Cuentas cuenta) throws Exception {
		if(validate.validateObject(cuenta))
			throw new Exception("La cuenta es nula");
		
		if(validate.validateString(cuenta.getCueNumero()))
			throw new Exception("El numero de cuenta es obligatoria");
		
		if(validate.validateNumeric(cuenta.getCueSaldo()))
			throw new Exception("El saldo es obligatorio");
		
		if(validate.validateString(cuenta.getCueActiva()))
			throw new Exception("El tipo de cuenta es obligatorio");
		
		if(validate.validateString(cuenta.getCueClave()))
			throw new Exception("La clave es obligatoria");
		
		cuentasDAO.update(cuenta);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void delete(Cuentas cuenta) throws Exception {
		if(validate.validateObject(cuenta)){
			throw new Exception("No existe usuario");
		}
		
		cuentasDAO.delete(cuenta);

	}

	@Override
	@Transactional(readOnly=true,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public Cuentas consultarPorId(String cuentaId) throws Exception {
		if(validate.validateString(cuentaId))
			throw new Exception("La id es obligatorio");
		
		Cuentas cue = cuentasDAO.consultarPorId(cuentaId);
		
		if(validate.validateObject(cue))
			throw new Exception("La cuenta no existe");
		else 
			return cue;
	}

	@Override
	@Transactional(readOnly=true,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public List<Cuentas> consultarTodos() throws Exception {
		List<Cuentas> cues = cuentasDAO.consultarTodos();
		if(validate.validateObject(cues))
			throw new Exception("No hay cuentas creadas");
		return cues;
	}

}
