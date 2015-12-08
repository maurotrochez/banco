package co.edu.uniajc.test.DAO;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.edu.uniajc.DAO.ITipoDocumentosDAO;
import co.edu.uniajc.model.TiposDocumentos;

import org.junit.Assert;
import org.junit.Before;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class ConsultarTiposDocumentos {
	
	@Autowired
	ITipoDocumentosDAO TDocu;
	
	@Test
	public void testListAll() throws Exception{
		List<TiposDocumentos> listTipos = new ArrayList<TiposDocumentos>();
		listTipos = TDocu.consultarTodos();
		Assert.assertNotNull(listTipos);
	}
	
	@Test
	public void testSelectById() throws Exception{
		TiposDocumentos tdoc;
		tdoc = TDocu.consultarPorId(10L);
		Assert.assertNotNull("Retorna id", tdoc);
	}
	
	@Before
	public void clean() throws Exception{
		TiposDocumentos tdoc;
		tdoc = TDocu.consultarPorId(40L);
		if(tdoc != null){
			TDocu.delete(tdoc);
		}
	}
	
	@Test
	public void testInsert() throws Exception{
		TiposDocumentos tipo = new TiposDocumentos();
		tipo.setTdocCodigo(40L);
		tipo.setTdocNombre("Nuevo tipo de documento");
		TDocu.save(tipo);
		
		TiposDocumentos tiposave;
		tiposave = TDocu.consultarPorId(40L);
		
		Assert.assertNotNull(tiposave);
	}
	
	@Test
	public void testDelete() throws Exception{
		TiposDocumentos tipo = new TiposDocumentos();
		tipo.setTdocCodigo(42L);
		tipo.setTdocNombre("Nuevo tipo de documento para eliminar");
		TDocu.save(tipo);
		
		TiposDocumentos tipodelete;
		tipodelete = TDocu.consultarPorId(42L);
		TDocu.delete(tipodelete);
		
		TiposDocumentos tipoConfirmdelete;
		tipoConfirmdelete = TDocu.consultarPorId(42L);
		Assert.assertNull(tipoConfirmdelete);
	}
	
	@Test
	public void testUpdate() throws Exception{
		TiposDocumentos tipoU = TDocu.consultarPorId(10L);
		tipoU.setTdocNombre("CEDULA modificada");
		TDocu.update(tipoU);
		
		TiposDocumentos tipoConfirm = TDocu.consultarPorId(10L);
		Assert.assertEquals("Nombre modificado", "CEDULA modificada", tipoConfirm.getTdocNombre());
	}
}
