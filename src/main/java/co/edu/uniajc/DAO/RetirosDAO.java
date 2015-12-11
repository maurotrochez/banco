package co.edu.uniajc.DAO;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniajc.model.Retiros;
import co.edu.uniajc.model.RetirosId;

@Repository
@Scope("singleton")
public class RetirosDAO implements IRetirosDAO{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public void save(Retiros retiro) throws Exception {
		sessionFactory.getCurrentSession().save(retiro);
	}

	@Override
	@Transactional
	public void update(Retiros retiro) throws Exception {
		sessionFactory.getCurrentSession().update(retiro);

	}

	@Override
	@Transactional
	public void delete(Retiros retiro) throws Exception {
		sessionFactory.getCurrentSession().delete(retiro);

	}

	@Override
//	@Transactional
	public Retiros consultarPorId(RetirosId retiroId) throws Exception {
		Retiros ret = null;
		ret = (Retiros)sessionFactory.getCurrentSession().get(Retiros.class, retiroId);
		return ret;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Retiros> consultarTodos() throws Exception {
		return (List<Retiros>)sessionFactory.getCurrentSession().createCriteria(Retiros.class).list();
	}

}
