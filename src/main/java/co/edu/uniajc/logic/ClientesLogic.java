package co.edu.uniajc.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniajc.DAO.IClientesDAO;
import co.edu.uniajc.DAO.ITipoDocumentosDAO;
import co.edu.uniajc.model.Clientes;
import co.edu.uniajc.model.TiposDocumentos;
import co.edu.uniajc.utils.IValidate;

@Service
@Scope("singleton")
public class ClientesLogic implements IClientesLogic {

	@Autowired
	private IClientesDAO clientesDAO;
	
	@Autowired
	private ITipoDocumentosDAO tiposDocumentosDAO;
	
	@Autowired
	private IValidate validate;
	
	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void grabar(Clientes clientes) throws Exception {
		if(validate.validateObject(clientes)){
			throw new Exception("El clientes es nulo");
		}
		
		if(validate.validateString(clientes.getCliDireccion())){
			throw new Exception("La direccion es obligatoria");
		}
		
		if(validate.validateId(clientes.getCliId())){
			throw new Exception("La identificacion es obligatoria");
		}
		
		if(validate.validateString(clientes.getCliMail())){
			throw new Exception("El mail es obligatorio");
		}
		
		if(validate.validateString(clientes.getCliNombre())){
			throw new Exception("El nombre es obligatorio");
		}
		if(validate.validateString(clientes.getCliTelefono())){
			throw new Exception("EL telefono es obligatorio");
		}
		
		if(validate.validateObject(clientes.getTiposDocumentos())){
			throw new Exception("EL tipo de documento es obligatorio");
		}
		
		TiposDocumentos tiposDocumentos=tiposDocumentosDAO.consultarPorId(clientes.getTiposDocumentos().getTdocCodigo());
		
		if(tiposDocumentos==null){
			throw new Exception("El tipo de documento no existe");
		}
		
		Clientes entity=clientesDAO.consultarPorId(clientes.getCliId());
		
		if(entity!=null){
			throw new Exception("El cliente ya existe");
		}
		
		clientesDAO.save(clientes);

	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void modificar(Clientes clientes) throws Exception {
		if(validate.validateObject(clientes)){
			throw new Exception("El clientes es nulo");
		}
		
		if(validate.validateString(clientes.getCliDireccion())){
			throw new Exception("La direccion es obligatoria");
		}
		
		if(validate.validateId(clientes.getCliId())){
			throw new Exception("La identificacion es obligatoria");
		}
		
		if(validate.validateString(clientes.getCliMail())){
			throw new Exception("El mail es obligatorio");
		}
		
		if(validate.validateString(clientes.getCliNombre())){
			throw new Exception("El nombre es obligatorio");
		}
		if(validate.validateString(clientes.getCliTelefono())){
			throw new Exception("EL telefono es obligatorio");
		}
		
		if(validate.validateObject(clientes.getTiposDocumentos())){
			throw new Exception("EL tipo de documento es obligatorio");
		}
		
		TiposDocumentos tiposDocumentos=tiposDocumentosDAO.consultarPorId(clientes.getTiposDocumentos().getTdocCodigo());
		
		if(tiposDocumentos==null){
			throw new Exception("El tipo de documento no existe");
		}
		
		clientesDAO.update(clientes);
		
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void borrar(Clientes clientes) throws Exception {
		if(validate.validateObject(clientes)){
			throw new Exception("No existe cliente");
		}
		
		clientesDAO.delete(clientes);

	}

	@Override
	@Transactional(readOnly=true,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public Clientes consultarPorId(Long cliId) throws Exception {
		if(validate.validateId(cliId))
			throw new Exception("La identificacion es obligatoria");
		
		Clientes cli = clientesDAO.consultarPorId(cliId);
		
		if(validate.validateObject(cli))
			throw new Exception("Cliente no existe");
		else 
			return cli;
	}

	@Override
	@Transactional(readOnly=true,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public List<Clientes> consultarTodos() throws Exception {
		List<Clientes> clientes = clientesDAO.consultarTodos();
		if(validate.validateObject(clientes))
			throw new Exception("No hay creados clientes");
		return clientes;
	}

}
