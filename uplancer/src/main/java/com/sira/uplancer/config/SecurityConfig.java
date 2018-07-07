package com.sira.uplancer.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.data.repository.query.SecurityEvaluationContextExtension;

@EnableWebSecurity
@Import(value = UplancerDatastore.class)

public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
            
                .withUser("user").password("password").roles("USER");
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
        	.antMatchers("/", "/list")
                .access("hasRole('USER') or hasRole('ADMIN') or hasRole('DBA')")
                .antMatchers("/newuser/**", "/delete-user-*")
                	.access("hasRole('ADMIN')")
                		.antMatchers("/edit-user-*")
                .access("hasRole('ADMIN') or hasRole('DBA')")
                 .and().formLogin().loginPage("/login")
                .loginProcessingUrl("/login")
                	.usernameParameter("ssoId")
                	.passwordParameter("password")
                 .and()
//                .rememberMe().rememberMeParameter("remember-me").tokenRepository(tokenRepository)
//                .tokenValiditySeconds(86400)
//                .and()
                	.csrf()
                .and()
                	.exceptionHandling()
                	.accessDeniedPage("/Access_Denied")
                .and().httpBasic()
                .and().formLogin();
    }
    
    @Bean
    public SecurityEvaluationContextExtension securityEvaluationContextExtension() {
        return new SecurityEvaluationContextExtension();
    }

}
