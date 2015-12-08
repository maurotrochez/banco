package co.edu.uniajc.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import co.edu.uniajc.model.Cuentas;

public class ConsultarCuenta {

	@Test
	public void test() {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistryBuilder.build());
		
		Session session = sessionFactory.openSession();
		
		Cuentas cuentas = (Cuentas) session.get(Cuentas.class, "4008-5305-0010");
	    System.out.println(cuentas.getCueNumero());
		
	}
}
