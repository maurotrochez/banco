package co.edu.uniajc.DAO;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniajc.model.TiposUsuarios;

@Repository
@Scope("singleton")
public class TiposUsuariosDAO implements ITiposUsuariosDAO{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public void save(TiposUsuarios tUsuario) throws Exception {
		sessionFactory.getCurrentSession().save(tUsuario);
	}

	@Override
	@Transactional
	public void update(TiposUsuarios tUsuario) throws Exception {
		sessionFactory.getCurrentSession().update(tUsuario);

	}

	@Override
	@Transactional
	public void delete(TiposUsuarios tUsuario) throws Exception {
		sessionFactory.getCurrentSession().delete(tUsuario);

	}

	@Override
	@Transactional
	public TiposUsuarios consultarPorId(Long tUsuarioId) throws Exception {
		System.out.println(tUsuarioId);
		return (TiposUsuarios)sessionFactory.getCurrentSession().get(TiposUsuarios.class, tUsuarioId);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<TiposUsuarios> consultarTodos() throws Exception {
		return (List<TiposUsuarios>)sessionFactory.getCurrentSession().createCriteria(TiposUsuarios.class).list();
	}
}
