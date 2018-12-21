package com.trustaml.dataservice.config.datasource;

import java.util.Properties;

import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaAuditing
@PropertySource({ "classpath:application.properties" })
@ComponentScan({ "com.trustaml.dataservice" })@EnableJpaRepositories(basePackages = {"com.trustaml.dataservice.repository"})
public class PersistenceConfig {

	@Autowired
	private Environment env;

	public PersistenceConfig() {
		super();
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws NamingException {
		final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPackagesToScan(new String[] { "com.trustaml.dataservice" });
		em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		em.setJpaProperties(additionalProperties());
		return em;
	}

	

	@Bean(name = "dataSource")
	public DataSource dataSource() {
		return new JndiDataSourceLookup().getDataSource("java:/TamlDs");
	}

	
/*	@Bean(name = "dataSources")
	public DataSource dataSources() {
		return new JndiDataSourceLookup().getDataSource("java:/taml_anil");
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		
		return new JdbcTemplate(dataSources());
	}*/

	

	@Bean
	public PlatformTransactionManager transactionManager(final EntityManagerFactory emf) {
		final JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);
		return transactionManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	final Properties additionalProperties() {
		final Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("spring.jpa.hibernate.ddl-auto"));
		hibernateProperties.setProperty("hibernate.dialect", env.getProperty("spring.jpa.hibernate.dialect"));
		hibernateProperties.setProperty("hibernate.show_sql", env.getProperty("spring.jpa.show-sql"));
		hibernateProperties.setProperty("hibernate.cache.use_second_level_cache", "false");
		hibernateProperties.setProperty("org.hibernate.envers.audit_table_suffix", "_LOG"); 
		return hibernateProperties;
	}
}
