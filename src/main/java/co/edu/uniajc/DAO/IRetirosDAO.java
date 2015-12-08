package co.edu.uniajc.DAO;

import java.util.List;

import co.edu.uniajc.model.Retiros;
import co.edu.uniajc.model.RetirosId;

public interface IRetirosDAO {
	
	public void save(Retiros retiro) throws Exception;
	public void update(Retiros retiro) throws Exception;
	public void delete(Retiros retiro) throws Exception;
	public Retiros consultarPorId(RetirosId retiroId) throws Exception;
	public List<Retiros> consultarTodos() throws Exception;

}
