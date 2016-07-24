package com.tagcloud.persistence.configuration;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.mysql.jdbc.Driver;

/**
 * Configuration for {@link BasicDataSource}.
 *
 * @author kkalmus
 */
@Configuration
@PropertySource({"classpath:/context.properties"})
public class BasicMySqlDataSourceConfiguration {

    @Autowired Environment env;

    /**
     * @return The data source.
     */
    @Bean(destroyMethod="close", initMethod="createDataSource")
    public BasicDataSource configurationDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(Driver.class.getName());
        dataSource.setUrl(env.getProperty("dataSource.url"));
        dataSource.setUsername(env.getProperty("dataSource.username"));
        dataSource.setPassword(env.getProperty("dataSource.password"));
        return dataSource;
    }
    
}