package co.edu.uniajc.DAO;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniajc.model.TiposDocumentos;

@Repository 
@Scope("singleton")
public class TipoDocumentosDAO implements ITipoDocumentosDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public void save(TiposDocumentos TDocu) throws Exception {
		sessionFactory.getCurrentSession().save(TDocu);
	}

	@Override
	@Transactional
	public void update(TiposDocumentos TDocu) throws Exception {
		sessionFactory.getCurrentSession().update(TDocu);

	}

	@Override
	@Transactional
	public void delete(TiposDocumentos TDocu) throws Exception {
		sessionFactory.getCurrentSession().delete(TDocu);

	}

	@Override
	@Transactional
	public TiposDocumentos consultarPorId(Long TDocuId) throws Exception {
		System.out.println(TDocuId);
		return (TiposDocumentos)sessionFactory.getCurrentSession().get(TiposDocumentos.class, TDocuId);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<TiposDocumentos> consultarTodos() throws Exception {
		return (List<TiposDocumentos>)sessionFactory.getCurrentSession().createCriteria(TiposDocumentos.class).list();
	}
}
