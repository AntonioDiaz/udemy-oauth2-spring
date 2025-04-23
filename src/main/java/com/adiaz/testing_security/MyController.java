package com.adiaz.testing_security;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class MyController {

  @GetMapping("/status")
  public String checkStatus() {
    return "OK";
  }

  @GetMapping("/token")
  public String showToken(@AuthenticationPrincipal Jwt jwt){
    System.out.println("JWT -> " + jwt.getClaims());
    final StringBuilder response = new StringBuilder();
    jwt.getClaims().forEach((k, v)-> { response.append(k + "->" + v + "\n");} );
    return response.toString();
  }

}
