package ru.gb.jSilver.SpringMarket.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain myFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeRequests()
                .antMatchers("/api/v1/products/").hasAnyRole("ADMIN", "MANAGER")
                .antMatchers("/api/v1/users/").hasRole("ADMIN")
                .antMatchers("/").authenticated()
                .and()
                .formLogin()
                .and()
                .build();
    }
}
