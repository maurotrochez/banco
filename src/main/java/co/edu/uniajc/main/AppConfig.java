package co.edu.uniajc.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.edu.uniajc.DAO.ClientesDAO;
import co.edu.uniajc.DAO.IClientesDAO;

@Configuration
public class AppConfig {

	@Bean
	public IClientesDAO getClientesDao(){
		return new ClientesDAO();
	}
}
