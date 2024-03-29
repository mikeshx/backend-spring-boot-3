package com.spring.boot.backend.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

//for Angular Client (withCredentials)
//@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600, allowCredentials="true")
//@CrossOrigin(origins = "*", maxAge = 3600)
//@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8080", "http://localhost:8081", "http://localhost:8100"}, allowCredentials = "true", allowedHeaders = "*")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8080", "http://localhost:8081", "http://localhost:8100", "http://10.0.2.16", "http://10.0.2.16:8000/", "http://10.0.2.2:8000/", "http://10.0.2.2:8080/", "http://localhost", "http://localhost/*", "http://localhost/register"}, allowCredentials = "true", allowedHeaders = "*")

@RestController
@RequestMapping("/api/test")
public class TestController {
  @GetMapping("/all")
  public String allAccess() {
    return "Public Content.";
  }

  @GetMapping("/addmarker")
  public String addMarker() {
    System.out.println("testController funziona");

    return "qualcosa";
  }

  @GetMapping("/user")
  @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
  public String userAccess() {
    return "User Content.";
  }

  @GetMapping("/mod")
  @PreAuthorize("hasRole('MODERATOR')")
  public String moderatorAccess() {
    return "Moderator Board.";
  }

  @GetMapping("/admin")
  @PreAuthorize("hasRole('ADMIN')")
  public String adminAccess() {
    return "Admin Board.";
  }
}
