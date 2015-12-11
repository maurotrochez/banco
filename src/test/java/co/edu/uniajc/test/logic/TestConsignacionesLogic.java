package co.edu.uniajc.test.logic;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.edu.uniajc.logic.IConsignacionesLogic;
import co.edu.uniajc.logic.IUsuariosLogic;
import co.edu.uniajc.model.Consignaciones;
import co.edu.uniajc.model.ConsignacionesId;
import co.edu.uniajc.model.Usuarios;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class TestConsignacionesLogic {

	@Autowired
	IConsignacionesLogic consignacionesController;
	
	@Autowired
	IUsuariosLogic userDAO;
	
	@Test
	public void testListAll() throws Exception{
		List<Consignaciones> listConsignaciones = new ArrayList<Consignaciones>();
		listConsignaciones = consignacionesController.consultarTodos();
		Assert.assertNotNull(listConsignaciones);
	}
	
//	@Test
	public void testSelectById() throws Exception{
		Consignaciones cons;
		ConsignacionesId consId = new ConsignacionesId(4L, "4008-5305-0025");
		cons = consignacionesController.consultarPorId(consId);
		Assert.assertNotNull("Retorna id", cons);
	}
	
//	@Before
//	public void clean() throws Exception{
//		Consignaciones cons;
//		ConsignacionesId consId = new ConsignacionesId(20L, "4008-5305-0035");
//		cons = consignacionesController.consultarPorId(consId);
//		if(cons != null)
//			consignacionesController.delete(cons);
//	}
	
//	@Test
	public void testInsert() throws Exception{
		Consignaciones cons = new Consignaciones();
		ConsignacionesId consId = new ConsignacionesId(20L, "4008-5305-0035");
		Usuarios user = userDAO.consultarPorId(15L);
		
		cons.setId(consId);
		cons.setConDescripcion("Descripcion");
		
		cons.setConFecha(new Date());
		cons.setConValor(new BigDecimal(120000));
		cons.setUsuarios(user);
		
		consignacionesController.save(cons);
		
		Consignaciones conssave;
		conssave = consignacionesController.consultarPorId(consId);
		
		Assert.assertNotNull(conssave);
	}

//	@Test
	public void testDelete() throws Exception{
		Consignaciones cons = new Consignaciones();
		ConsignacionesId consId = new ConsignacionesId(21L, "4008-5305-0035");
		Usuarios user = userDAO.consultarPorId(15L);
		
		cons.setId(consId);
		cons.setConDescripcion("Description para eliminar");
		cons.setConFecha(new Date());
		cons.setConValor(new BigDecimal(120000));
		cons.setUsuarios(user);
		
		consignacionesController.save(cons);
		
		Consignaciones consirodelete;
		consirodelete = consignacionesController.consultarPorId(consId);
		consignacionesController.delete(consirodelete);
		
	}
	
//	@Test
	public void testUpdate() throws Exception{
		ConsignacionesId consId = new ConsignacionesId(13L, "4008-5305-0070");
		Consignaciones consU = consignacionesController.consultarPorId(consId);
		consU.setConDescripcion("Descripcion modificacda");
		consignacionesController.update(consU);
		
		Consignaciones tipoConfirm = consignacionesController.consultarPorId(consId);
		Assert.assertEquals("descripcion modificado", "Descripcion modificacda", tipoConfirm.getConDescripcion());
	}

}
