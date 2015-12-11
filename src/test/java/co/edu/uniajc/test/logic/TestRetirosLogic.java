package co.edu.uniajc.test.logic;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.edu.uniajc.DAO.IRetirosDAO;
import co.edu.uniajc.DAO.IUsuariosDAO;
import co.edu.uniajc.logic.IRetirosLogic;
import co.edu.uniajc.logic.IUsuariosLogic;
import co.edu.uniajc.model.Retiros;
import co.edu.uniajc.model.RetirosId;
import co.edu.uniajc.model.Usuarios;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class TestRetirosLogic {

	@Autowired
	IRetirosLogic retirosController;
	
	@Autowired
	IUsuariosLogic userDAO;
	
//	@Test
	public void testListAll() throws Exception{
		List<Retiros> listRetiros = new ArrayList<Retiros>();
		listRetiros = retirosController.consultarTodos();
		Assert.assertNotNull(listRetiros);
	}
	
//	@Test
	public void testSelectById() throws Exception{
		Retiros ret;
		RetirosId retId = new RetirosId(6L, "4008-5305-0035");
		ret = retirosController.consultarPorId(retId);
		Assert.assertNotNull("Retorna id", ret);
	}
	
//	@Before
//	public void clean() throws Exception{
//		Retiros tdoc;
//		RetirosId retId = new RetirosId(21L, "4008-5305-0035");
//		tdoc = retirosController.consultarPorId(retId);
//		if(tdoc != null)
//			retirosController.delete(tdoc);
//	}
	
//	@Test
	public void testInsert() throws Exception{
		Retiros ret = new Retiros();
		RetirosId retId = new RetirosId(21L, "4008-5305-0035");
		Usuarios user = userDAO.consultarPorId(15L);
		
		ret.setId(retId);
		ret.setRetDescripcion("Description");
		ret.setRetFecha(new Date());
		ret.setRetValor(new BigDecimal(120000));
		ret.setUsuarios(user);
		
		retirosController.save(ret);
		
		Retiros retsave;
		retsave = retirosController.consultarPorId(retId);
		
		Assert.assertNotNull(retsave);
	}
	
	@Test
	public void testDelete() throws Exception{
		//Retiros ret = new Retiros();
		RetirosId retId = new RetirosId(21L, "4008-5305-0035");
		//ret.setId(retId);
		retirosController.delete(retId);
		
	}
	
//	@Test
	public void testUpdate() throws Exception{
		RetirosId retId = new RetirosId(13L, "4008-5305-0070");
		Retiros retU = retirosController.consultarPorId(retId);
		retU.setRetDescripcion("Descripcion modificacda");
		retirosController.update(retU);
		
		Retiros tipoConfirm = retirosController.consultarPorId(retId);
		Assert.assertEquals("descripcion modificado", "Descripcion modificacda", tipoConfirm.getRetDescripcion());
	}

}
