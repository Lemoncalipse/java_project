package com.example.sportsbetting.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // Tell that we want to authorize some requests
                .authorizeRequests()
                // We want to authorize every requests except resources
                .antMatchers("/css/**", "/js/**", "/images/**", "/register").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                // We want to use login form
                .formLogin()
                // Define the layout of the login form
                .loginPage("/login")
                // If the user successfully logged in, redirect to the home page.
                .successForwardUrl("/")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login")
                .permitAll();
    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        /*
         * Create a database based authentication system instead of a memory based.
         */
        auth.jdbcAuthentication()
                /*
                * The dataSource is a wire to application.properties (spring.datasource.*)
                 */
                .dataSource(dataSource)
                // By default we do not store the enabled column. Because of this the enabled set default by 1.
                .usersByUsernameQuery("select email,password, 1 as enabled "
                        + "from user "
                        + "where email = ?")
                // Since we do not have authorities table, I use a dummy sql to have authorities
                .authoritiesByUsernameQuery("select email, 'USER' from user where email = ?");
                /*.authoritiesByUsernameQuery("select email,authority "
                        + "from authorities "
                        + "where email = ?");*/

    }

    // Solve 'There is no PasswordEncoder mapped for the id "null"' error
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    /*
    LOGIN WITHOUT DATABASE, MEMORY BASED.
    @Bean
    public UserDetailsService userDetailsService() {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        UserDetails user = User.withUsername("david")
                .password(encoder.encode("david"))
                .roles("USER").build();

        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(user);
        return manager;

    } */
}