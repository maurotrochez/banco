package co.edu.uniajc.delegado;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import co.edu.uniajc.logic.IClientesLogic;
import co.edu.uniajc.logic.IConsignacionesLogic;
import co.edu.uniajc.logic.ICuentasLogic;
import co.edu.uniajc.logic.IRetirosLogic;
import co.edu.uniajc.logic.ITiposDocumentosLogic;
import co.edu.uniajc.logic.ITiposUsuariosLogic;
import co.edu.uniajc.logic.IUsuariosLogic;
import co.edu.uniajc.model.Clientes;
import co.edu.uniajc.model.Consignaciones;
import co.edu.uniajc.model.ConsignacionesId;
import co.edu.uniajc.model.Cuentas;
import co.edu.uniajc.model.Retiros;
import co.edu.uniajc.model.RetirosId;
import co.edu.uniajc.model.TiposDocumentos;
import co.edu.uniajc.model.TiposUsuarios;
import co.edu.uniajc.model.Usuarios;

@Component
@Scope("singleton")
public class DelegadoDeNegocio implements IDelegadoDeNegocio {
	
	@Autowired
	private IClientesLogic clientesLogic;
	
	@Autowired
	private ITiposDocumentosLogic tiposDocumentosLogic;
	
	@Autowired
	private IUsuariosLogic usuariosLogic;
	
	@Autowired
	private ITiposUsuariosLogic tiposUsuariosLogic;
	
	@Autowired
	private IConsignacionesLogic consignacionesLogic;
	
	@Autowired
	private ICuentasLogic cuentasLogic;
	
	@Autowired
	private IRetirosLogic retirosLogic;

	@Override
	public void grabarUsuario(Usuarios usuario) throws Exception {
		usuariosLogic.save(usuario);
		
	}

	@Override
	public void modificarUsuario(Usuarios usuario) throws Exception {
		usuariosLogic.update(usuario);
		
	}

	@Override
	public void borrarUsuario(Usuarios usuario) throws Exception {
		usuariosLogic.delete(usuario);
		
	}

	@Override
	public Usuarios consultarUsuarioPorId(Long usrId) throws Exception {
		// TODO Auto-generated method stub
		return usuariosLogic.consultarPorId(usrId);
	}

	@Override
	public List<Usuarios> consultarTodosUsuario() throws Exception {
		// TODO Auto-generated method stub
		return usuariosLogic.consultarTodos();
	}

	@Override
	public void grabarTipoUsuario(TiposUsuarios tUsuario) throws Exception {
		tiposUsuariosLogic.save(tUsuario);
		
	}

	@Override
	public void modificarTipoUsuario(TiposUsuarios tUsuario) throws Exception {
		tiposUsuariosLogic.update(tUsuario);
		
	}

	@Override
	public void borrarTipoUsuario(TiposUsuarios tUsuario) throws Exception {
		tiposUsuariosLogic.delete(tUsuario);
		
	}

	@Override
	public TiposUsuarios consultarTipoUsuarioPorId(Long tUsrId) throws Exception {
		return tiposUsuariosLogic.consultarPorId(tUsrId);
	}

	@Override
	public List<TiposUsuarios> consultarTodosTipoUsuarios() throws Exception {
		return tiposUsuariosLogic.consultarTodos();
	}

	@Override
	public void grabarCuenta(Cuentas cuenta) throws Exception {
		cuentasLogic.save(cuenta);
		
	}

	@Override
	public void modificarCuenta(Cuentas cuenta) throws Exception {
		cuentasLogic.update(cuenta);
		
	}

	@Override
	public void borrarCuenta(Cuentas cuenta) throws Exception {
		cuentasLogic.delete(cuenta);
		
	}

	@Override
	public Cuentas consultarCuentaPorId(String cuentaId) throws Exception {
		// TODO Auto-generated method stub
		return cuentasLogic.consultarPorId(cuentaId);
	}

	@Override
	public List<Cuentas> consultarTodosCuentas() throws Exception {
		// TODO Auto-generated method stub
		return cuentasLogic.consultarTodos();
	}

	@Override
	public void grabarConsignacion(Consignaciones consignacion) throws Exception {
		consignacionesLogic.save(consignacion);
		
	}

	@Override
	public void modificarConsignacion(Consignaciones consignacion) throws Exception {
		consignacionesLogic.update(consignacion);
		
	}

	@Override
	public void borrarConsignacion(Consignaciones consignacion) throws Exception {
		consignacionesLogic.delete(consignacion);
		
	}

	@Override
	public Consignaciones consultarConsignacionPorId(ConsignacionesId consId) throws Exception {
		// TODO Auto-generated method stub
		return consignacionesLogic.consultarPorId(consId);
	}

	@Override
	public List<Consignaciones> consultarTodosConsignaciones() throws Exception {
		// TODO Auto-generated method stub
		return consignacionesLogic.consultarTodos();
	}

	@Override
	public void grabarRetiro(Retiros retiro) throws Exception {
		retirosLogic.save(retiro);
		
	}

	@Override
	public void modificarRetiro(Retiros retiro) throws Exception {
		retirosLogic.update(retiro);
		
	}

	@Override
	public void borrarRetiro(RetirosId retiroId) throws Exception {
		retirosLogic.delete(retiroId);
		
	}

	@Override
	public Retiros consultarRetiroPorId(RetirosId retId) throws Exception {
		// TODO Auto-generated method stub
		return retirosLogic.consultarPorId(retId);
	}

	@Override
	public List<Retiros> consultarTodosRetiro() throws Exception {
		// TODO Auto-generated method stub
		return retirosLogic.consultarTodos();
	}

	@Override
	public void grabarClientes(Clientes clientes) throws Exception {
		clientesLogic.grabar(clientes);

	}

	@Override
	public void modificarClientes(Clientes clientes) throws Exception {
		clientesLogic.modificar(clientes);

	}

	@Override
	public void borrarClientes(Clientes clientes) throws Exception {
		clientesLogic.borrar(clientes);

	}

	@Override
	public Clientes consultarClientesPorId(Long cliId) throws Exception {
		// TODO Auto-generated method stub
		return clientesLogic.consultarPorId(cliId);
	}

	@Override
	public List<Clientes> consultarTodosClientes() throws Exception {
		// TODO Auto-generated method stub
		return clientesLogic.consultarTodos();
	}

	@Override
	public void grabarTiposDocumentos(TiposDocumentos tiposDocumentos) throws Exception {
		tiposDocumentosLogic.save(tiposDocumentos);

	}

	@Override
	public void modificarTiposDocumentos(TiposDocumentos tiposDocumentos) throws Exception {
		tiposDocumentosLogic.update(tiposDocumentos);

	}

	@Override
	public void borrarTiposDocumentos(TiposDocumentos tiposDocumentos) throws Exception {
		tiposDocumentosLogic.delete(tiposDocumentos);

	}

	@Override
	public TiposDocumentos consultarTiposDocumentosPorId(Long tdocCodigo) throws Exception {
		// TODO Auto-generated method stub
		return tiposDocumentosLogic.consultarPorId(tdocCodigo);
	}

	@Override
	public List<TiposDocumentos> consultarTodosTiposDocumentos() throws Exception {
		// TODO Auto-generated method stub
		return tiposDocumentosLogic.consultarTodos();
	}

}
