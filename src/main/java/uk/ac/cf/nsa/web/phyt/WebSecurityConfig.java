package uk.ac.cf.nsa.web.phyt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import uk.ac.cf.nsa.web.phyt.users.service.UserService;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    //sets in memory authentication for trainer & user roles - temporary logins for demo purposes
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                  .jdbcAuthentication()
                  .dataSource(dataSource);
    //                .inMemoryAuthentication()
//                .withUser("trainer2").password("{noop}password2").roles("TRAINER")
//                .and()
//                .withUser("client").password("{noop}password1").roles("USER");
    }

    //Only used for purposes of demo/prototype - should use a password encryption for security
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    //configure security on pages, login and logout
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        // Public pages that do not require authorisation
        http.authorizeRequests().antMatchers("/","/public/**", "/login", "/logout", "/register").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.POST,"/register").permitAll();

        //userInfo page requires login as ROLE_USER or ROLE_TRAINER.
        http.authorizeRequests().antMatchers("/home").access("hasAnyRole('ROLE_USER', 'ROLE_TRAINER')");

        // Access to routes starting /trainer  - For TRAINERS only.
        http.authorizeRequests().antMatchers("/trainer/**").access("hasRole('ROLE_TRAINER')");

        //Access to routes starting /client - For USER only
        http.authorizeRequests().antMatchers("/client/**").access("hasRole('ROLE_USER')");

        // Config for Login Form
        http.authorizeRequests().and().formLogin()
                //Submit URL of login page.
                .loginProcessingUrl("/phyt_security_check")
                .loginPage("/login")
                .defaultSuccessUrl("/home")
                //if login fails - login page displays error message
                .failureUrl("/login?error=true")
                .usernameParameter("username")
                .passwordParameter("password")

                //Configuration for Logout Page - goes back to login with logout message displayed
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/login?logout=true");

    }




}
