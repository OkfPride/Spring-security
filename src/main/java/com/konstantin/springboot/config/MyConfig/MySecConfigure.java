/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.konstantin.springboot.config.MyConfig;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

/**
 *
 * @author JavaDev
 */
@EnableWebSecurity
public class MySecConfigure extends WebSecurityConfigurerAdapter{

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        User.UserBuilder userBuilder = User.withDefaultPasswordEncoder();
        auth.inMemoryAuthentication().withUser(userBuilder.username("Vasia").password("Vasia").roles("Employee")).
                withUser(userBuilder.username("Lena").password("Lena").roles("HR")).
                withUser(userBuilder.username("Kiril").password("Kiril").roles("Manager", "HR"));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().
                antMatchers("/").hasAnyRole("Employee", "HR", "Manager"). 
                antMatchers("/manager_page").hasAnyRole("Manager").
                antMatchers("/hr_page").hasAnyRole("HR")
                .and().formLogin().permitAll();
    }
    
    
}
