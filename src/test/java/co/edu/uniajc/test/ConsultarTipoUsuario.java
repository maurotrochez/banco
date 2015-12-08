package co.edu.uniajc.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import co.edu.uniajc.model.TiposUsuarios;

public class ConsultarTipoUsuario {

	@Test
	public void test() {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistryBuilder.build());
		
		Session session = sessionFactory.openSession();
		
		TiposUsuarios TipoUsuario = (TiposUsuarios) session.get(TiposUsuarios.class, 20L);
	    System.out.println(TipoUsuario.getTusuNombre());
		
	}
}
