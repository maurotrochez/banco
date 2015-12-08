package co.edu.uniajc.test.DAO;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.edu.uniajc.DAO.IClientesDAO;
import co.edu.uniajc.DAO.ICuentasDAO;
import co.edu.uniajc.DAO.IUsuariosDAO;
import co.edu.uniajc.model.Clientes;
import co.edu.uniajc.model.Cuentas;
import co.edu.uniajc.model.Usuarios;
import co.edu.uniajc.model.Cuentas;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class TestCuentas {

	@Autowired
	ICuentasDAO Service;
	
	@Autowired
	IClientesDAO ServiceCli;
	
	@Test
	public void testListAll() throws Exception{
		List<Cuentas> listCuentas = new ArrayList<Cuentas>();
		listCuentas = Service.consultarTodos();
		Assert.assertNotNull(listCuentas);
	}
	
	@Test
	public void testSelectById() throws Exception{
		Cuentas cue;
		cue = Service.consultarPorId("4008-5305-0010");
		Assert.assertNotNull("Retorna id", cue);
	}
	
	@Before
	public void clean() throws Exception{
		Cuentas cue;
		cue = Service.consultarPorId("4008-5305-0090");
		if(cue != null){
			Service.delete(cue);
		}
	}
	
	@Test
	public void testInsert() throws Exception{
		Cuentas cue = new Cuentas();
		Clientes cli = ServiceCli.consultarPorId(251234L);
		
		cue.setCueNumero("4008-5305-0090");
		cue.setClientes(cli);
		cue.setCueActiva("S");
		cue.setCueSaldo(new BigDecimal(190000));
		cue.setCueClave("asdf");
		
		Service.save(cue);
		
		Cuentas cuesave;
		cuesave = Service.consultarPorId("4008-5305-0090");
		
		Assert.assertNotNull(cuesave);
	}
	
	@Test
	public void testDelete() throws Exception{
		Cuentas cue = new Cuentas();
		Clientes cli = ServiceCli.consultarPorId(251234L);
		
		cue.setCueNumero("4008-5305-0088");
		cue.setClientes(cli);
		cue.setCueActiva("S");
		cue.setCueSaldo(new BigDecimal(190000));
		cue.setCueClave("asdf");
		
		Service.save(cue);
		
		Cuentas cuedelete;
		cuedelete = Service.consultarPorId("4008-5305-0088");
		Service.delete(cuedelete);
		
		Cuentas cueConfirmdelete;
		cueConfirmdelete = Service.consultarPorId("4008-5305-0088");
		Assert.assertNull(cueConfirmdelete);
	}
	
	@Test
	public void testUpdate() throws Exception{
		Cuentas cueU = Service.consultarPorId("4008-5305-0060");
		cueU.setCueClave("clave");
		Service.update(cueU);
		
		Cuentas cueConfirm = Service.consultarPorId("4008-5305-0060");
		Assert.assertEquals("Nombre modificado", "clave", cueConfirm.getCueClave());
	}

}
