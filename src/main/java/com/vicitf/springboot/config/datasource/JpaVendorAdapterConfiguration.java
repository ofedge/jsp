package com.vicitf.springboot.config.datasource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;

@Configuration
public class JpaVendorAdapterConfiguration {
	/**
	 * 不要这个bean的话, 那两个japVendorAdapter要NullPointerException了
	 */
	@Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setShowSql(true);
        jpaVendorAdapter.setGenerateDdl(false);
//        jpaVendorAdapter.setDatabase(Database.ORACLE);
        jpaVendorAdapter.setDatabase(Database.SQL_SERVER);
        return jpaVendorAdapter;
    }
}
