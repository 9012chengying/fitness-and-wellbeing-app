//package uk.ac.cf.nsa.web.phyt;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
//import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import uk.ac.cf.nsa.web.phyt.users.service.PhytUserDetailsService;
//
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    // Code to configure web security
//    // adapted from linkedin Learning video Spring:Security by Frank P Moley III 30-5-2018
//    // accessed 20/01/20
//    // https://www.linkedin.com/learning/spring-spring-security/authorization?u=76816418
//
//    @Autowired
//    PhytUserDetailsService phytUserDetailsService;
//
//    //Only used for purposes of demo/prototype - should use a password encryption for security
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return NoOpPasswordEncoder.getInstance();
//    }
//
//    //Sets up an authentication provider for Spring security
//    @Bean
//    public DaoAuthenticationProvider authenticationProvider(){
//        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//        provider.setUserDetailsService(phytUserDetailsService);
//        provider.setPasswordEncoder(passwordEncoder());
//        provider.setAuthoritiesMapper(authoritiesMapper());
//        return provider;
//    }
//
//    @Bean
//    public GrantedAuthoritiesMapper authoritiesMapper(){
//        SimpleAuthorityMapper authorityMapper = new SimpleAuthorityMapper();
//        authorityMapper.setConvertToUpperCase(true);
//        return authorityMapper;
//    }
//
//    //Inserts the authentication provider into the Authentication Manager Builder
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(authenticationProvider());
//    }
// // end of referenced code.
//
//// Code to configure HttpSecurity
//// adapted from TakeawayMSC Project on Gitlab by Dr Ian Cooper 9 July 2018
//// accessed 14/01/20
//// https://gitlab.cs.cf.ac.uk/scmimc/TakeawayMSc/-/network/master
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable();
//
//        // Public pages that do not require authorisation
//        http.authorizeRequests().antMatchers("/","/public/**", "/login", "/logout", "/register").permitAll();
//        http.authorizeRequests().antMatchers(HttpMethod.POST,"/register/**").permitAll();
//
//        //userInfo page requires login as ROLE_USER or ROLE_TRAINER.
//        http.authorizeRequests().antMatchers("/home").access("hasAnyRole('ROLE_CLIENT', 'ROLE_TRAINER')");
//
//        // Access to routes starting /trainer  - For TRAINERS only.
//        http.authorizeRequests().antMatchers("/trainer/**").access("hasRole('ROLE_TRAINER')");
//
//        //Access to routes starting /client - For CLIENT only
//        http.authorizeRequests().antMatchers("/client/**").access("hasRole('ROLE_CLIENT')");
//
//        //Access to routes starting /admin - For ADMIN only
//        http.authorizeRequests().antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')");
//
//        // Config for Login Form - Code reuse & Altered from https://gitlab.cs.cf.ac.uk/scmimc/TakeawayMSc
//        http.authorizeRequests().and().formLogin()
//                //Submit URL of login page.
//                .loginProcessingUrl("/phyt_security_check")
//                .loginPage("/login")
//                .defaultSuccessUrl("/home")
//                //if login fails - login page displays error message
//                .failureUrl("/login?error=true")
//                .usernameParameter("username")
//                .passwordParameter("password")
//
//                //Configuration for Logout Page - goes back to login with logout message displayed
//                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/login?logout=true");
//    }
////End of referenced Code
//}
