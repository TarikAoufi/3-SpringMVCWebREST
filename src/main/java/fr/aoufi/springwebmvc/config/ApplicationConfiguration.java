package fr.aoufi.springwebmvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import fr.aoufi.springwebmvc.dao.PersonneDAO;
import fr.aoufi.springwebmvc.service.PersonneService;
import fr.aoufi.springwebmvc.service.impl.PersonneServiceImpl;

@Configuration
@Import(value = { DataConfiguration.class })
@PropertySource(value = "classpath:/config.properties")
public class ApplicationConfiguration {

	@Bean
	public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	@Bean
	public PersonneService personneService(PersonneDAO personneDAO){
		PersonneServiceImpl personneServiceImpl = new PersonneServiceImpl();
		personneServiceImpl.setPersonneDAO(personneDAO);
		return personneServiceImpl;
	}

}
