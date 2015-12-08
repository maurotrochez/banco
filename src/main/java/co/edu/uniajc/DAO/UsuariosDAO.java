package co.edu.uniajc.DAO;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniajc.model.Usuarios;

@Repository
@Scope("singleton")
public class UsuariosDAO implements IUsuariosDAO{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public void save(Usuarios usuario) throws Exception {
		sessionFactory.getCurrentSession().save(usuario);
	}

	@Override
	@Transactional
	public void update(Usuarios usuario) throws Exception {
		sessionFactory.getCurrentSession().update(usuario);

	}

	@Override
	@Transactional
	public void delete(Usuarios usuario) throws Exception {
		sessionFactory.getCurrentSession().delete(usuario);

	}

	@Override
	@Transactional
	public Usuarios consultarPorId(Long usuarioId) throws Exception {
		System.out.println(usuarioId);
		return (Usuarios)sessionFactory.getCurrentSession().get(Usuarios.class, usuarioId);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Usuarios> consultarTodos() throws Exception {
		return (List<Usuarios>)sessionFactory.getCurrentSession().createCriteria(Usuarios.class).list();
	}
}
