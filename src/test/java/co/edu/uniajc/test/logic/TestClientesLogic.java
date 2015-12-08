package co.edu.uniajc.test.logic;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.edu.uniajc.DAO.ITipoDocumentosDAO;
import co.edu.uniajc.logic.IClientesLogic;
import co.edu.uniajc.model.Clientes;
import co.edu.uniajc.model.TiposDocumentos;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class TestClientesLogic {
	
	@Autowired
	IClientesLogic clienteController;
	
	@Autowired
	ITipoDocumentosDAO tDocumentsDAO;

	@Test
	public void testSave() throws Exception {
		Clientes cliente = new Clientes();
		TiposDocumentos tdoc;
		tdoc = tDocumentsDAO.consultarPorId(10L);
		
		cliente.setCliId(57L);
		cliente.setCliNombre("asdf");
		cliente.setCliDireccion("Carrera 45B");
		cliente.setCliMail("prueba@example.com");
		cliente.setCliTelefono("00000000");
		cliente.setTiposDocumentos(tdoc);
		
		clienteController.grabar(cliente);
		
	}
	
	//@Test
	public void selectById() throws Exception{
		Clientes cli = new Clientes();
		cli = clienteController.consultarPorId(11L);
		assertNotNull("Cliente no existe",cli);
	}
	
	//@Test
	public void updateCli() throws Exception{
		Clientes cliente = clienteController.consultarPorId(54L);
		//System.out.println(cliente);
		cliente.setCliNombre("dsdsd");
		
		clienteController.modificar(cliente);
	}
	
	//@Test
	public void delete() throws Exception{
		Clientes cliente = clienteController.consultarPorId(801234L);
		clienteController.borrar(cliente);
	}
	
	//@Test
	public void selectAll() throws Exception {
		clienteController.consultarTodos();
	}
	

}
