package co.edu.uniajc.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import co.edu.uniajc.model.Retiros;
import co.edu.uniajc.model.RetirosId;

public class ConsultarRetiro {

	@Test
	public void test() {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistryBuilder.build());
		
		Session session = sessionFactory.openSession();
		
		RetirosId ret = new RetirosId(6L, "4008-5305-0035");
		
		Retiros retiros = (Retiros) session.get(Retiros.class, ret);
	    System.out.println(retiros.getRetValor());
	}

}
