//package uk.ac.cf.nsa.web.phyt;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//@EnableWebSecurity
//
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception{
//        http
//                .cors().and().csrf().disable()
//                .authorizeRequests()
//                .mvcMatchers("/css/**").permitAll()
//                .mvcMatchers("/js/**").permitAll()
//                .mvcMatchers("/public/**").permitAll()
//                .antMatchers("/trainer/**").hasRole("Trainer")
//                .and()
//                .formLogin()
//                .and()
//                .logout();
//    }
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .inMemoryAuthentication()
//                .withUser("trainer").password("{noop}password").roles("Trainer")
//                .and()
//                .withUser("client").password("{noop}password1").roles("Client");
//       }
//}
