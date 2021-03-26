/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.konstantin.springboot.config.MyConfig;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.beans.PropertyVetoException;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 *
 * @author JavaDev
 */
@Configuration
@ComponentScan(basePackages = "com.konstantin.springboot")
@EnableWebMvc
public class MyConfig {

    @Bean
    public ViewResolver myViewResolver() {
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/WEB-INF/view");
        internalResourceViewResolver.setSuffix(".jsp");
        return internalResourceViewResolver;
    }

    @Bean
    public DataSource dataSource() {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        try {
            comboPooledDataSource.setDriverClass("org.postgresql.Driver");
            comboPooledDataSource.setJdbcUrl("jdbc:postgresql://localhost/my_db");
            comboPooledDataSource.setUser("postgres");
            comboPooledDataSource.setPassword("postgres");
        } catch (PropertyVetoException ex) {
            ex.printStackTrace();
        }
        return comboPooledDataSource;
    }
}
