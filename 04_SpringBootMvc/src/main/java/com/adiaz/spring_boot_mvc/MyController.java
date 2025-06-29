package com.adiaz.spring_boot_mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

  @GetMapping("/albums")
  public String getAlbums() {
    return "albums";
  }
}
