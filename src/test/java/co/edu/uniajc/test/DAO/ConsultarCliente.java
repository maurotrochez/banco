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

import co.edu.uniajc.DAO.IClientesDAO;
import co.edu.uniajc.DAO.ITipoDocumentosDAO;
import co.edu.uniajc.model.Clientes;
import co.edu.uniajc.model.TiposDocumentos;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class ConsultarCliente {
		
	@Autowired
	IClientesDAO daoC1;

	@Autowired
	ITipoDocumentosDAO daoTD1;
	
	TiposDocumentos TDC;
	List<Clientes> list = new ArrayList<Clientes>();
	Clientes cli;
	
	@Test
	public void test() throws Exception {
				
		cli = daoC1.consultarPorId(201234L);
		
		try {
			System.out.println(cli.getCliNombre());
		
		} catch (Exception e) {
			System.out.println("ERROR "+e);
		}	    
	}
	
	@Test
	public void testList() throws Exception {
				
		list = daoC1.consultarTodos();
		try {
			for (Clientes clientes : list) {
				System.out.println(clientes.getCliNombre());
			}
		
		} catch (Exception e) {
			System.out.println("ERROR "+e);
		}	    
	}
	@Test
	public void testDelete() throws Exception   {
		Clientes cliente = new Clientes();
		TDC = daoTD1.consultarPorId(10L);
		cliente.setCliId(23L);
		cliente.setCliNombre("asdfg");
		cliente.setCliDireccion("Carrera 45B");
		cliente.setCliMail("prueba@example.com");
		cliente.setCliTelefono("00000000");
		cliente.setTiposDocumentos(TDC);
		
		daoC1.save(cliente);
		
		cli = daoC1.consultarPorId(23L);
		daoC1.delete(cli);
		
		cli = daoC1.consultarPorId(23L);
		Assert.assertNull(cli);
	}
	
	@Before
	public void clean() throws Exception{
		Clientes cli;
		cli = daoC1.consultarPorId(55L);
		if(cli != null){
			daoC1.delete(cli);
		}
	}
	
	@Test
	public void testInsert() throws Exception   {
		Clientes cliente = new Clientes();
		TDC = daoTD1.consultarPorId(10L);
		list = daoC1.consultarTodos();
		
		cliente.setCliId(55L);
	
		cliente.setCliNombre("trtrtr");
		cliente.setCliNombre("rtrtr");
		cliente.setCliDireccion("Carrera 45B");
		cliente.setCliMail("prueba@example.com");
		cliente.setCliTelefono("00000000");
		cliente.setTiposDocumentos(TDC);
		
		daoC1.save(cliente);	
	}
	
	@Test
	public void testUpdate() throws Exception   {
		Clientes cliente = new Clientes();
		cliente = daoC1.consultarPorId(101234L);
		cliente.setCliNombre("Nuevo");
		
		daoC1.update(cliente);
		
		Clientes cliente2 = daoC1.consultarPorId(101234L);
		System.out.println(cliente2.getCliNombre());
//		Assert.assertSame("Nombre modificado","Nuevo", cliente2.getCliNombre());
		Assert.assertEquals("Nombre modificado", "Nuevo", cliente2.getCliNombre());
		
	}
}
