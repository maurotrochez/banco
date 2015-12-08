package co.edu.uniajc.test.DAO;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.edu.uniajc.DAO.ITiposUsuariosDAO;
import co.edu.uniajc.DAO.IUsuariosDAO;
import co.edu.uniajc.model.Usuarios;
import co.edu.uniajc.model.TiposUsuarios;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class TestUsuarios {
	
	@Autowired
	IUsuariosDAO Service;
	
	@Autowired
	ITiposUsuariosDAO ServiceTypes;

	@Test
	public void testListAll() throws Exception {
		List<Usuarios> listUsuarios = new ArrayList<Usuarios>();
		listUsuarios = Service.consultarTodos();
		Assert.assertNotNull(listUsuarios);
	}
	
	@Test
	public void testSelectById() throws Exception{
		Usuarios user;
		user = Service.consultarPorId(10L);
		Assert.assertNotNull("Retorna id", user);
	}
	
	@Before
	public void clean() throws Exception{
		Usuarios user;
		user = Service.consultarPorId(40L);
		if(user != null){
			Service.delete(user);
		}
	}
	
	@Test
	public void testInsert() throws Exception{
		Usuarios user = new Usuarios();
		TiposUsuarios type = ServiceTypes.consultarPorId(10L);
		
		user.setUsuCedula(40L);
		user.setUsuNombre("Nuevo usuario");
		user.setTiposUsuarios(type);
		user.setUsuClave("1234");
		user.setUsuLogin("login");

		Service.save(user);
		
		Usuarios usersave;
		usersave = Service.consultarPorId(40L);
		
		Assert.assertNotNull(usersave);
	}
	
	@Test
	public void testDelete() throws Exception{
		Usuarios user = new Usuarios();
		TiposUsuarios type = ServiceTypes.consultarPorId(10L);
		
		user.setUsuCedula(41L);
		user.setUsuNombre("Nuevo usuario a eliminar");
		user.setTiposUsuarios(type);
		user.setUsuClave("1234");
		user.setUsuLogin("login");

		Service.save(user);
		
		Usuarios userdelete;
		userdelete = Service.consultarPorId(41L);
		Service.delete(userdelete);
		
		Usuarios userConfirmdelete;
		userConfirmdelete = Service.consultarPorId(41L);
		Assert.assertNull(userConfirmdelete);
	}
	
	@Test
	public void testUpdate() throws Exception{
		Usuarios user = Service.consultarPorId(10L);
		user.setUsuNombre("LUIS FERNANDO TORRES modificado");
		Service.update(user);
		
		Usuarios userConfirm = Service.consultarPorId(10L);
		Assert.assertEquals("Nombre modificado", "LUIS FERNANDO TORRES modificado", userConfirm.getUsuNombre());
	}

}
