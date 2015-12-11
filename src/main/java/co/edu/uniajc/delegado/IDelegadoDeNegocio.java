package co.edu.uniajc.delegado;

import java.util.List;

import co.edu.uniajc.model.Clientes;
import co.edu.uniajc.model.Consignaciones;
import co.edu.uniajc.model.ConsignacionesId;
import co.edu.uniajc.model.Cuentas;
import co.edu.uniajc.model.Retiros;
import co.edu.uniajc.model.RetirosId;
import co.edu.uniajc.model.TiposDocumentos;
import co.edu.uniajc.model.TiposUsuarios;
import co.edu.uniajc.model.Usuarios;

public interface IDelegadoDeNegocio {

	public void grabarClientes(Clientes clientes)throws Exception;
	public void modificarClientes(Clientes clientes)throws Exception;
	public void borrarClientes(Clientes clientes)throws Exception;
	public Clientes consultarClientesPorId(Long cliId)throws Exception;
	public List<Clientes> consultarTodosClientes()throws Exception;
	
	public void grabarTiposDocumentos(TiposDocumentos tiposDocumentos)throws Exception;
	public void modificarTiposDocumentos(TiposDocumentos tiposDocumentos)throws Exception;
	public void borrarTiposDocumentos(TiposDocumentos tiposDocumentos)throws Exception;
	public TiposDocumentos consultarTiposDocumentosPorId(Long tdocCodigo)throws Exception;
	public List<TiposDocumentos> consultarTodosTiposDocumentos()throws Exception;
	
	public void grabarUsuario(Usuarios usuario)throws Exception;
	public void modificarUsuario(Usuarios usuario)throws Exception;
	public void borrarUsuario(Usuarios usuario)throws Exception;
	public Usuarios consultarUsuarioPorId(Long usrId)throws Exception;
	public List<Usuarios> consultarTodosUsuario()throws Exception;
	
	public void grabarTipoUsuario(TiposUsuarios tUsuario)throws Exception;
	public void modificarTipoUsuario(TiposUsuarios tUsuario)throws Exception;
	public void borrarTipoUsuario(TiposUsuarios tUsuario)throws Exception;
	public TiposUsuarios consultarTipoUsuarioPorId(Long tUsrId)throws Exception;
	public List<TiposUsuarios> consultarTodosTipoUsuarios()throws Exception;
	
	public void grabarCuenta(Cuentas cuenta)throws Exception;
	public void modificarCuenta(Cuentas cuenta)throws Exception;
	public void borrarCuenta(Cuentas cuenta)throws Exception;
	public Cuentas consultarCuentaPorId(String cuentaId)throws Exception;
	public List<Cuentas> consultarTodosCuentas()throws Exception;
	
	public void grabarConsignacion(Consignaciones consignacion)throws Exception;
	public void modificarConsignacion(Consignaciones consignacion)throws Exception;
	public void borrarConsignacion(Consignaciones consignacion)throws Exception;
	public Consignaciones consultarConsignacionPorId(ConsignacionesId consId)throws Exception;
	public List<Consignaciones> consultarTodosConsignaciones()throws Exception;
	
	public void grabarRetiro(Retiros retiro)throws Exception;
	public void modificarRetiro(Retiros retiro)throws Exception;
	public void borrarRetiro(RetirosId retiro)throws Exception;
	public Retiros consultarRetiroPorId(RetirosId retId)throws Exception;
	public List<Retiros> consultarTodosRetiro()throws Exception;
}
