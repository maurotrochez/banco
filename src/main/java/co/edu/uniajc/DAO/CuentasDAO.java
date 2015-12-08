package co.edu.uniajc.DAO;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniajc.model.Cuentas;

@Repository 
@Scope("singleton")
public class CuentasDAO implements ICuentasDAO{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public void save(Cuentas cuenta) throws Exception {
		sessionFactory.getCurrentSession().save(cuenta);
	}

	@Override
	@Transactional
	public void update(Cuentas cuenta) throws Exception {
		sessionFactory.getCurrentSession().update(cuenta);

	}

	@Override
	@Transactional
	public void delete(Cuentas cuenta) throws Exception {
		sessionFactory.getCurrentSession().delete(cuenta);

	}

	@Override
	@Transactional
	public Cuentas consultarPorId(String cuentaId) throws Exception {
		return (Cuentas)sessionFactory.getCurrentSession().get(Cuentas.class, cuentaId);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Cuentas> consultarTodos() throws Exception {
		return (List<Cuentas>)sessionFactory.getCurrentSession().createCriteria(Cuentas.class).list();
	}

}
