package co.edu.uniajc.DAO;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniajc.model.Clientes;


@Repository 
@Scope("singleton")

/*Singleton: es el valor default e implica una única instancia.
prototype: se instancia todas las veces que sea necesario.
request: válido en Spring MVC, donde es instanciado por cada petición HTTP.
session: válido en Spring MVC, donde es instanciado por cada usuario.
global-session: válido en Spring MVC, donde es instanciado en una session global HTTP.*/

public class ClientesDAO implements IClientesDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public void save(Clientes clientes) throws Exception {
		sessionFactory.getCurrentSession().save(clientes);
	}

	@Override
	@Transactional
	public void update(Clientes clientes) throws Exception {
		sessionFactory.getCurrentSession().update(clientes);

	}

	@Override
	@Transactional
	public void delete(Clientes clientes) throws Exception {
		sessionFactory.getCurrentSession().delete(clientes);

	}

	@Override
	@Transactional
	public Clientes consultarPorId(Long cliId) throws Exception {
		return (Clientes)sessionFactory.getCurrentSession().get(Clientes.class, cliId);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Clientes> consultarTodos() throws Exception {
		return (List<Clientes>)sessionFactory.getCurrentSession().createCriteria(Clientes.class).list();
	}
}
