package com.sira.uplancer.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableTransactionManagement
@ComponentScan({ "com.sira.model","com.sira.service","com.sira.controller" })
@PropertySource(value = { "classpath:application.properties" })
@EnableJpaRepositories("com.sira.api.repository")
public class UplancerDatastore {

	@Autowired
	private Environment env;

	@Bean
	public DataSource dataSource() {
		try {
			ComboPooledDataSource ds = new ComboPooledDataSource();
			ds.setDriverClass(env.getRequiredProperty("jdbc.driverClassName"));
			ds.setJdbcUrl(env.getRequiredProperty("jdbc.url"));
			ds.setUser(env.getRequiredProperty("jdbc.username"));
			ds.setPassword(env.getRequiredProperty("jdbc.password"));
			ds.setAcquireIncrement(5);
			ds.setIdleConnectionTestPeriod(60);
			ds.setMaxPoolSize(100);
			ds.setMaxStatements(50);
			ds.setMinPoolSize(10);
			return ds;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	// Declare a JPA entityManagerFactory
	@Bean 
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setPersistenceUnitName(env.getRequiredProperty("hibernatePersistenceUnit"));
		em.setDataSource(dataSource());
		
		HibernateJpaVendorAdapter vendor = new HibernateJpaVendorAdapter();
		vendor.setShowSql(false);
		em.setJpaVendorAdapter(vendor);
		
		return em;
	}
	
	// Declare a transaction manager
	@Bean 
	public JpaTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
//		transactionManager.setEntityManagerFactory(entityManagerFactory());
		return transactionManager;
}

}
