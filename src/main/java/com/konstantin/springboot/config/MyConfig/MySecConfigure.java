/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.konstantin.springboot.config.MyConfig;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

/**
 *
 * @author JavaDev
 */
@EnableWebSecurity
public class MySecConfigure extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        UserBuilder withDefaultPasswordEncoder = User.withDefaultPasswordEncoder();
//        auth.inMemoryAuthentication().withUser(userBuilder.username("Vasia").password("Vasia").roles("Employee")).
//                withUser(userBuilder.username("Lena").password("Lena").roles("HR")).
//                withUser(userBuilder.username("Kiril").password("Kiril").roles("Manager", "HR"));

        auth.jdbcAuthentication().dataSource(dataSource); 
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().
                antMatchers("/").hasAnyRole("EMPLOYEE", "HR", "MANAGER").
                antMatchers("/manager_page").hasAnyRole("MANAGER").
                antMatchers("/hr_page").hasAnyRole("HR")
                .and().formLogin().permitAll();
    }

}
