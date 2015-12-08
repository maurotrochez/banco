package co.edu.uniajc.DAO;

import java.util.List;

import co.edu.uniajc.model.TiposDocumentos;

public interface ITipoDocumentosDAO {
	public void save(TiposDocumentos TDocu) throws Exception;
	public void update(TiposDocumentos TDocu) throws Exception;
	public void delete(TiposDocumentos TDocu) throws Exception;
	public TiposDocumentos consultarPorId(Long TDocu) throws Exception;
	public List<TiposDocumentos> consultarTodos() throws Exception;
}
