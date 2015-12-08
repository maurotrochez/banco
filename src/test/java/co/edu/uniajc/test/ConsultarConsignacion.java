package co.edu.uniajc.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import co.edu.uniajc.model.Consignaciones;
import co.edu.uniajc.model.ConsignacionesId;

public class ConsultarConsignacion {
	
	@Test
	public void test() {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistryBuilder.build());
		
		Session session = sessionFactory.openSession();
		
		ConsignacionesId cons = new ConsignacionesId(1L, "4008-5305-0010");
		
		Consignaciones consignacion = (Consignaciones) session.get(Consignaciones.class, cons);
	    System.out.println(consignacion.getConDescripcion());
		
	}
}
