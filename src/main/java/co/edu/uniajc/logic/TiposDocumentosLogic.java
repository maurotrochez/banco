package co.edu.uniajc.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import co.edu.uniajc.DAO.ITipoDocumentosDAO;
import co.edu.uniajc.model.TiposDocumentos;
import co.edu.uniajc.utils.IValidate;

@Service
@Scope("singleton")
public class TiposDocumentosLogic implements ITiposDocumentosLogic {

	@Autowired
	ITipoDocumentosDAO tipoDocumentoDAO;
	
	@Autowired
	IValidate validate;
	
	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void save(TiposDocumentos tipoDocumento) throws Exception {
		if(validate.validateObject(tipoDocumento))
			throw new Exception("El tipo de documento es nulo");
		
		if(validate.validateId(tipoDocumento.getTdocCodigo()))
			throw new Exception("La codigo es obligatorio");
		
		if(validate.validateObject(tipoDocumento.getTdocNombre()))
			throw new Exception("El nombre es obligatorio");
		
		tipoDocumentoDAO.save(tipoDocumento);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void update(TiposDocumentos tipoDocumento) throws Exception {
		if(validate.validateObject(tipoDocumento))
			throw new Exception("El tipo de documento es nulo");
		
		if(validate.validateId(tipoDocumento.getTdocCodigo()))
			throw new Exception("La codigo es obligatorio");
		
		if(validate.validateObject(tipoDocumento.getTdocNombre()))
			throw new Exception("El nombre es obligatorio");
		
		tipoDocumentoDAO.update(tipoDocumento);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void delete(TiposDocumentos tipoDocumento) throws Exception {
		if(validate.validateObject(tipoDocumento)){
			throw new Exception("No existe el tipo de documento");
		}
		
		tipoDocumentoDAO.delete(tipoDocumento);

	}

	@Override
	@Transactional(readOnly=true,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public TiposDocumentos consultarPorId(Long tipoDocumentoId) throws Exception {
		if(validate.validateId(tipoDocumentoId))
			throw new Exception("La id es obligatorio");
		
		TiposDocumentos tDoc = tipoDocumentoDAO.consultarPorId(tipoDocumentoId);
		
		if(validate.validateObject(tDoc))
			throw new Exception("El tipo de documento no existe");
		else 
			return tDoc;
	}

	@Override
	@Transactional(readOnly=true,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public List<TiposDocumentos> consultarTodos() throws Exception {
		List<TiposDocumentos> tDocs = tipoDocumentoDAO.consultarTodos();
		if(validate.validateObject(tDocs))
			throw new Exception("No hay creados tipos de docuementos");
		return tDocs;
	}

}
