package com.blascode.springsecurity.controller;

import com.blascode.springsecurity.controller.dtos.AuthResponse;
import com.blascode.springsecurity.controller.dtos.AuthenticationRequest;
import com.blascode.springsecurity.controller.dtos.RegisterRequest;
import com.blascode.springsecurity.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

  @Autowired
  private AuthService authService;
  @PostMapping("/register")
  public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request){
    return ResponseEntity.ok(authService.register(request));
  }

  @PostMapping("/authenticate")
  public ResponseEntity<AuthResponse> authenticate(@RequestBody AuthenticationRequest request){
    return ResponseEntity.ok(authService.authenticate(request));
  }
}
