package co.edu.uniajc.logic;

import java.util.List;

import co.edu.uniajc.model.Consignaciones;
import co.edu.uniajc.model.ConsignacionesId;

public interface IConsignacionesLogic {

	public void save(Consignaciones consignacion) throws Exception;
	public void update(Consignaciones consignacion) throws Exception;
	public void delete(Consignaciones consignacion) throws Exception;
	public Consignaciones consultarPorId(ConsignacionesId consigacionId) throws Exception;
	public List<Consignaciones> consultarTodos() throws Exception;
}
