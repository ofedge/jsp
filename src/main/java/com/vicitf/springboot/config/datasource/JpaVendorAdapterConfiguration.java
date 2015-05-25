package com.vicitf.springboot.config.datasource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class JpaVendorAdapterConfiguration {
	/**
	 * 不要这个bean的话, 那两个japVendorAdapter要NullPointerException了
	 * 用HibernateJpaVendorAdapter来进行统一设置, 在具体的DataSource中再设置不同的数据库, 目前只好这样了
	 */
	@Bean
    public HibernateJpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setShowSql(true);
        jpaVendorAdapter.setGenerateDdl(false);
        return jpaVendorAdapter;
    }
}
