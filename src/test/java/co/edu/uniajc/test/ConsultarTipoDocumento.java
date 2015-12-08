package co.edu.uniajc.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import co.edu.uniajc.model.TiposDocumentos;

public class ConsultarTipoDocumento {

	@Test
	public void test() {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistryBuilder.build());
		
		Session session = sessionFactory.openSession();
		
		TiposDocumentos TipoDocumento = (TiposDocumentos) session.get(TiposDocumentos.class, 10L);
	    System.out.println(TipoDocumento.getTdocNombre());
		
	}
}