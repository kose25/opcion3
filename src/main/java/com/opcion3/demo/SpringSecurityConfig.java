/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opcion3.demo;


import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 *
 * @author kose_
 */

@Configuration
public class SpringSecurityConfig  extends WebSecurityConfigurerAdapter {
    
    @Autowired
    DataSource dataSource;
    

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/","/login","/index").permitAll()
                .antMatchers("/guest").hasAnyRole("USER")
                .antMatchers("/admin").hasAnyRole("ADMIN")
                .anyRequest().authenticated()
                .and().formLogin().loginPage("/login").permitAll()
                .and().logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login?logout");
       
    }
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select usuario as username, password, enabled" + " from usuario" + " where usuario=?")
                .authoritiesByUsernameQuery("select username, authority " + "from authorities " + "where username = ? ");
                
    }
    
    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
  
}
