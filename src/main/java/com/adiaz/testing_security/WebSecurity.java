package com.adiaz.testing_security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class WebSecurity {

  @Bean
  SecurityFilterChain configure(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests(oauthz -> oauthz.anyRequest().authenticated())
        .oauth2ResourceServer(oauth2 -> oauth2.jwt(jwtConfigurer -> {}));
    return http.build();
  }
}
