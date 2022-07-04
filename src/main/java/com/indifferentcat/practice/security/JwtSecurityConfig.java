package com.indifferentcat.practice.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class JwtSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.oauth2ResourceServer()
                .jwt();
    }

    @Bean
    public JwtAuthenticationConverter jwtAuthenticationConverter() {
        JwtAuthenticationConverter converter = new JwtAuthenticationConverter();

        converter.setJwtGrantedAuthoritiesConverter(jwt ->
                Optional.ofNullable(jwt.getClaimAsStringList("custom_claims"))
                        .stream()
                        .flatMap(Collection::stream)
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList())
        );
        return converter;
    }

}
