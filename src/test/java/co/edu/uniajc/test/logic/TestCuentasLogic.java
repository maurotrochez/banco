package co.edu.uniajc.test.logic;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import co.edu.uniajc.DAO.IClientesDAO;
import co.edu.uniajc.logic.ICuentasLogic;
import co.edu.uniajc.model.Clientes;
import co.edu.uniajc.model.Cuentas;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class TestCuentasLogic {

	@Autowired
	ICuentasLogic cuentasController;
	
	@Autowired
	IClientesDAO clientesDAO;
	
	@Test
	public void testSave() throws Exception {
		Cuentas cue = new Cuentas();
		Clientes cli = clientesDAO.consultarPorId(251234L);
		
		cue.setCueNumero("4008-5305-0090");
		cue.setClientes(cli);
		cue.setCueActiva("S");
		cue.setCueSaldo(new BigDecimal(190000));
		cue.setCueClave("asdf");
		
		cuentasController.save(cue);
		
		Cuentas cuesave;
		cuesave = cuentasController.consultarPorId("4008-5305-0090");
		
		Assert.assertNotNull(cuesave);
		
	}
	
	@Test
	public void selectById() throws Exception{
		Cuentas cue;
		cue = cuentasController.consultarPorId("4008-5305-0010");
		Assert.assertNotNull("Retorna id", cue);
	}
	
	@Test
	public void updateCli() throws Exception{
		Cuentas cueU = cuentasController.consultarPorId("4008-5305-0060");
		cueU.setCueClave("clave");
		cuentasController.update(cueU);
		
		Cuentas cueConfirm = cuentasController.consultarPorId("4008-5305-0060");
		Assert.assertEquals("Nombre modificado", "clave", cueConfirm.getCueClave());
	}
	
	@Test
	public void delete() throws Exception{
		Cuentas cue = new Cuentas();
		Clientes cli = clientesDAO.consultarPorId(251234L);
		
		cue.setCueNumero("4008-5305-0088");
		cue.setClientes(cli);
		cue.setCueActiva("S");
		cue.setCueSaldo(new BigDecimal(190000));
		cue.setCueClave("asdf");
		
		cuentasController.save(cue);
		
		Cuentas cuedelete;
		cuedelete = cuentasController.consultarPorId("4008-5305-0088");
		cuentasController.delete(cuedelete);
		
		Cuentas cueConfirmdelete;
		cueConfirmdelete = cuentasController.consultarPorId("4008-5305-0088");
		Assert.assertNull(cueConfirmdelete);
	}
	
	@Test
	public void selectAll() throws Exception {
		List<Cuentas> listCuentas = new ArrayList<Cuentas>();
		listCuentas = cuentasController.consultarTodos();
		Assert.assertNotNull(listCuentas);
	}

}
