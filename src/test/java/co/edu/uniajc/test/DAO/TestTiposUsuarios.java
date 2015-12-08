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
import co.edu.uniajc.model.TiposUsuarios;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class TestTiposUsuarios {
	
	@Autowired
	ITiposUsuariosDAO Service;
	
	@Test
	public void testListAll() throws Exception{
		List<TiposUsuarios> listTipos = new ArrayList<TiposUsuarios>();
		listTipos = Service.consultarTodos();
		Assert.assertNotNull(listTipos);
	}
	
	@Test
	public void testSelectById() throws Exception{
		TiposUsuarios tusr;
		tusr = Service.consultarPorId(10L);
		Assert.assertNotNull("Retorna id", tusr);
	}
	
	@Before
	public void clean() throws Exception{
		TiposUsuarios tusr;
		tusr = Service.consultarPorId(40L);
		if(tusr != null){
			Service.delete(tusr);
		}
	}
	
	@Test
	public void testInsert() throws Exception{
		TiposUsuarios tipo = new TiposUsuarios();
		tipo.setTusuCodigo(40L);
		tipo.setTusuNombre("Nombre de nuevo tipo de usr");
		Service.save(tipo);
		
		TiposUsuarios tiposave;
		tiposave = Service.consultarPorId(40L);
		
		Assert.assertNotNull(tiposave);
	}
	
	@Test
	public void testDelete() throws Exception{
		TiposUsuarios tipo = new TiposUsuarios();
		tipo.setTusuCodigo(42L);
		tipo.setTusuNombre("Nuevo tipo de documento para eliminar");
		Service.save(tipo);
		
		TiposUsuarios tipodelete;
		tipodelete = Service.consultarPorId(42L);
		Service.delete(tipodelete);
		
		TiposUsuarios tipoConfirmdelete;
		tipoConfirmdelete = Service.consultarPorId(42L);
		Assert.assertNull(tipoConfirmdelete);
	}
	
	@Test
	public void testUpdate() throws Exception{
		TiposUsuarios tipoU = Service.consultarPorId(10L);
		tipoU.setTusuNombre("CAJERO modificado");
		Service.update(tipoU);
		
		TiposUsuarios tipoConfirm = Service.consultarPorId(10L);
		Assert.assertEquals("Nombre modificado", "CAJERO modificado", tipoConfirm.getTusuNombre());
	}

}
