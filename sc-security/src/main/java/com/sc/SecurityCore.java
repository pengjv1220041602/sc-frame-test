package com.sc;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityCore extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure (HttpSecurity httpSecurity) throws Exception {
        httpSecurity
//                .authenticationProvider(new DefaultJaasAuthenticationProvider())
                .formLogin()
                .loginProcessingUrl("/validate/login")
                .loginPage("/login")
                .successForwardUrl("/index")
                .failureForwardUrl("/error1")
                .and()
                .authorizeRequests()
                .antMatchers("/login", "threelogin.html").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .csrf().disable();
    }
}
