package co.edu.uniajc.logic;

import java.util.List;

import co.edu.uniajc.model.TiposDocumentos;

public interface ITiposDocumentosLogic {
	public void save(TiposDocumentos TDocu) throws Exception;
	public void update(TiposDocumentos TDocu) throws Exception;
	public void delete(TiposDocumentos TDocu) throws Exception;
	public TiposDocumentos consultarPorId(Long TDocu) throws Exception;
	public List<TiposDocumentos> consultarTodos() throws Exception;

}
