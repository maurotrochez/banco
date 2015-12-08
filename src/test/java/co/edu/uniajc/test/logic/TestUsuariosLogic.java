package co.edu.uniajc.test.logic;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.edu.uniajc.DAO.ITiposUsuariosDAO;
import co.edu.uniajc.logic.IUsuariosLogic;
import co.edu.uniajc.model.Clientes;
import co.edu.uniajc.model.TiposUsuarios;
import co.edu.uniajc.model.Usuarios;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class TestUsuariosLogic {

	@Autowired
	IUsuariosLogic usuarioController;
	
	@Autowired
	ITiposUsuariosDAO tipoUsuarioDAO;
	
	//@Test
	public void testSave() throws Exception {
		Usuarios usr = new Usuarios();
		usr.setUsuCedula(13L);
		usr.setUsuNombre("asdfa");
		usr.setUsuClave("asdf3");
		usr.setUsuLogin("asdfee");
		
		TiposUsuarios tpU = tipoUsuarioDAO.consultarPorId(10L);
		
		usr.setTiposUsuarios(tpU);
		
		usuarioController.save(usr);
	}
	
	//@Test
	public void testUpdate() throws Exception {
		Usuarios usr = usuarioController.consultarPorId(15L);
		usr.setUsuNombre("nombre modificado");
		usuarioController.update(usr);
	}
	
//	@Test
	public void testDelete() throws Exception{
		Usuarios usr = usuarioController.consultarPorId(13L);
		usuarioController.delete(usr);
	}
	
	@Test
	public void testSelectById() throws Exception{
		Usuarios usr = new Usuarios();
		usr = usuarioController.consultarPorId(20L);
		assertNotNull("Usuario no existe",usr);
	}
	
	@Test
	public void testSelectAll() throws Exception {
		usuarioController.consultarTodos();
	}

}
