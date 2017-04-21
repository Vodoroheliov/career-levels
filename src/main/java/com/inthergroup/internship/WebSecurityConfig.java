package com.inthergroup.internship;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.inthergroup.internship.services.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
@ComponentScan("com.inthergroup.internship")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests().antMatchers("/css/**", "/js/**", "/images/**", "/fonts/**", // Enable css, js, images and fonts when logged out
                    "/", "/index", "/signup").permitAll()
                .and()
            .authorizeRequests()
                .antMatchers("/users/all-users", "/todos/all-tasks",
                        "/benefits/all-benefits", "/todos/todo-type",
                        "/benefits/benefit-type").hasAuthority("ADMIN")
                .and()
            .authorizeRequests()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/")
                .failureUrl("/login?error")
                .permitAll()
                .and()
            .logout()
                .permitAll()
                .and()
            .exceptionHandling()
                .accessDeniedPage("/unauthorized");
    }
     
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(
                new BCryptPasswordEncoder());
    }
}
