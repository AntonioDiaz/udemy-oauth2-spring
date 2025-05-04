package com.adiaz.testing_security;

import com.adiaz.testing_security.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/users")
@Slf4j
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

  @Secured("ROLE_admin")
  @GetMapping("/delete")
  public String delete() {
    return "DELETE";
  }

  @GetMapping(path = "/delete/{id}")
  @PreAuthorize("hasAuthority('ROLE_admin') and #id == #jwt.subject")
  public String deletePre(@PathVariable String id, @AuthenticationPrincipal Jwt jwt) {
    return String.format("will delete %s  for user %s", id, jwt.getSubject());
  }

  @GetMapping(path = "/{id}")
  @PostAuthorize("returnObject.id == '1234'")
  public User getUser(@PathVariable String id) {
    log.info("Getting user {}", id);
    return new User(id, "Antoine");
  }

}
