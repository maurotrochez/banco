package co.edu.uniajc.test.logic;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.edu.uniajc.logic.ITiposDocumentosLogic;
import co.edu.uniajc.logic.ITiposUsuariosLogic;
import co.edu.uniajc.model.TiposDocumentos;
import co.edu.uniajc.model.TiposUsuarios;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class TestTiposUsuariosLogic {

	@Autowired
	ITiposUsuariosLogic tiposUsuariosController;
	
//	@Test
	public void testSave() throws Exception {
		TiposUsuarios tUsr = new TiposUsuarios();
		
		tUsr.setTusuCodigo(12L);
		tUsr.setTusuNombre("nuevo");
		tiposUsuariosController.save(tUsr);
		
	}
	
//	@Test
	public void selectById() throws Exception{
		TiposUsuarios tUsr = new TiposUsuarios();
		tUsr = tiposUsuariosController.consultarPorId(12L);
		assertNotNull("Tipo de usuario no existe",tUsr);
	}
	
	@Test
	public void updateCli() throws Exception{
		TiposUsuarios tUsr = tiposUsuariosController.consultarPorId(12L);
		//System.out.println(cliente);
		tUsr.setTusuNombre("dsdsd");
		
		tiposUsuariosController.update(tUsr);
	}
	
//	@Test
	public void delete() throws Exception{
		TiposUsuarios tUsr = tiposUsuariosController.consultarPorId(12L);
		tiposUsuariosController.delete(tUsr);
	}
	
//	@Test
	public void selectAll() throws Exception {
		tiposUsuariosController.consultarTodos();
	}

}
