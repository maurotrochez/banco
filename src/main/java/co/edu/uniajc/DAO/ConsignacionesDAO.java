package co.edu.uniajc.DAO;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniajc.model.Consignaciones;
import co.edu.uniajc.model.ConsignacionesId;

@Repository 
@Scope("singleton")
public class ConsignacionesDAO implements IConsignacionesDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public void save(Consignaciones consignacion) throws Exception {
		sessionFactory.getCurrentSession().save(consignacion);
		
	}

	@Override
	@Transactional
	public void update(Consignaciones consignacion) throws Exception {
		sessionFactory.getCurrentSession().update(consignacion);
		
	}

	@Override
	@Transactional
	public void delete(Consignaciones consignacion) throws Exception {
		sessionFactory.getCurrentSession().delete(consignacion);
		
	}

	@Override
	@Transactional
	public Consignaciones consultarPorId(ConsignacionesId consigacionId) throws Exception {
		return (Consignaciones)sessionFactory.getCurrentSession().get(Consignaciones.class, consigacionId);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Consignaciones> consultarTodos() throws Exception {
		return (List<Consignaciones>)sessionFactory.getCurrentSession().createCriteria(Consignaciones.class).list();
	}

}
