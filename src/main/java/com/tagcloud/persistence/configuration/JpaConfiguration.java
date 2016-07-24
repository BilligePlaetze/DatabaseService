package com.tagcloud.persistence.configuration;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Root Configuration for JPA.
 *
 * @author kkalmus
 */
@Configuration
@EnableJpaRepositories("com.tagcloud.persistence.repository")
@EnableTransactionManagement
public class JpaConfiguration {

    @Autowired DataSource dataSource;

    /**
     * @return Transaction manager for JPA.
     */
    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setDataSource(dataSource);
        return transactionManager;
    }

    /**
     * @return The LocalContainerEntityManagerFactoryBean.
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setPackagesToScan("com.tagcloud.persistence.repository");
        factoryBean.setJpaVendorAdapter(eclipseLinkJpaVendorAdapter());
        factoryBean.setJpaPropertyMap(jpaProperties());
        return factoryBean;
    }

    /**
     * @return The JPA properties as Map.
     */
    @Bean
    public Map<String, ?> jpaProperties() {
        Map<String, Object> properties = new HashMap<>();
        properties.put("eclipselink.weaving", "false");
        properties.put("eclipselink.ddl-generation", "create-or-extend-tables");
        return properties;
    }

    /**
     * @return The EclipseLinkJpaVendorAdapter.
     */
    @Bean
    public EclipseLinkJpaVendorAdapter eclipseLinkJpaVendorAdapter() {
        EclipseLinkJpaVendorAdapter jpaVendorAdapter = new EclipseLinkJpaVendorAdapter();
        jpaVendorAdapter.setDatabase(Database.MYSQL);
        return jpaVendorAdapter;
    }
}