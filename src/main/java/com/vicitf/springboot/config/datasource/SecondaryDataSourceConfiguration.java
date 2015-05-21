package com.vicitf.springboot.config.datasource;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @see com.vicitf.springboot.config.datasource.PrimaryDataSourceConfiguration
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		basePackages = {"com.vicitf.springboot.repository.secondary"},
		entityManagerFactoryRef = "secondaryEntityManagerFactory",
		transactionManagerRef = "secondaryTransactionManager")
public class SecondaryDataSourceConfiguration {
	
	@Autowired
    JpaVendorAdapter jpaVendorAdapter;
	
	@Bean
	@ConfigurationProperties(prefix = "datasource.secondary")
	public DataSource secondaryDataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean
	public EntityManagerFactory secondaryEntityManagerFactory() {
		LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
		entityManager.setDataSource(secondaryDataSource());
		entityManager.setPackagesToScan("com.vicitf.springboot.domain.secondary");
		entityManager.setPersistenceUnitName("secondaryPersistentUnit");
		entityManager.setJpaVendorAdapter(jpaVendorAdapter);
		entityManager.afterPropertiesSet();
		return entityManager.getObject();
	}
	
	@Bean
	public PlatformTransactionManager secondaryTransactionManager() {
		return new JpaTransactionManager(secondaryEntityManagerFactory());
	}
}