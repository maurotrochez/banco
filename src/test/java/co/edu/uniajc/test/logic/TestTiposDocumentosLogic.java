package co.edu.uniajc.test.logic;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.edu.uniajc.DAO.ITipoDocumentosDAO;
import co.edu.uniajc.logic.IClientesLogic;
import co.edu.uniajc.logic.ITiposDocumentosLogic;
import co.edu.uniajc.model.Clientes;
import co.edu.uniajc.model.TiposDocumentos;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class TestTiposDocumentosLogic {

	@Autowired
	ITiposDocumentosLogic tipoDocumentoController;
	
	@Test
	public void testSave() throws Exception {
		TiposDocumentos tDoc = new TiposDocumentos();
		
		tDoc.setTdocCodigo(12L);
		tDoc.setTdocNombre("nuevo");
		tipoDocumentoController.save(tDoc);
		
	}
	
	@Test
	public void selectById() throws Exception{
		TiposDocumentos tDoc = new TiposDocumentos();
		tDoc = tipoDocumentoController.consultarPorId(12L);
		assertNotNull("Tipo de documento no existe",tDoc);
	}
	
	@Test
	public void updateCli() throws Exception{
		TiposDocumentos tDoc = tipoDocumentoController.consultarPorId(12L);
		//System.out.println(cliente);
		tDoc.setTdocNombre("dsdsd");
		
		tipoDocumentoController.update(tDoc);
	}
	
	@Test
	public void delete() throws Exception{
		TiposDocumentos tDoc = tipoDocumentoController.consultarPorId(12L);
		tipoDocumentoController.delete(tDoc);
	}
	
	@Test
	public void selectAll() throws Exception {
		tipoDocumentoController.consultarTodos();
	}

}
