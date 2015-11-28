/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revze.crudspring.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

/**
 *
 * @author revze
 */
@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    @Autowired
    private DataSource dataSource;
    
    private static final String SQL_LOGIN = "select username, password, active as enabled " + "from c_security_user where username = ?";
    private static final String SQL_ROLE = "select u.username, p.permission_value as authority " + "from c_security_user u " + "inner join c_security_role r on u.id_role = r.id " + "inner join c_security_role_permission rp on rp.id_role = r.id " + "inner join c_security_permission p on rp.id_permission = p.id " + "where u.username = ?";
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)
        throws Exception{
            auth
                    .jdbcAuthentication()
                    .dataSource(dataSource)
                    .usersByUsernameQuery(SQL_LOGIN)
                    .authoritiesByUsernameQuery(SQL_ROLE);
    }
        
            @Override
            protected void configure(HttpSecurity http) throws Exception {
                http
                        .authorizeRequests()
                            .antMatchers(HttpMethod.GET,"/api/catatan/**").hasRole("CATATAN_VIEW")
                            .antMatchers(HttpMethod.POST,"/api/catatan/**").hasRole("CATATAN_CREATE")
                            .antMatchers(HttpMethod.DELETE,"/api/catatan/**").hasRole("CATATAN_DELETE")
                            .antMatchers(HttpMethod.PUT,"/api/catatan/**").hasRole("CATATAN_UPDATE")
                            .antMatchers("/lib/**").permitAll()
                            .antMatchers("/scripts/**").permitAll()
                            .anyRequest().authenticated()
                            .and()
                        .formLogin()
                            .loginPage("/login.html")
                            .defaultSuccessUrl("/")
                            .loginProcessingUrl("/login")
                            .permitAll()
                            .and()
                        .logout()
                            .permitAll()
                            .and()
                        .csrf().disable();
            }
}
