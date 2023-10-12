package com.blascode.springsecurity.service;

import com.blascode.springsecurity.controller.dtos.AuthResponse;
import com.blascode.springsecurity.controller.dtos.AuthenticationRequest;
import com.blascode.springsecurity.controller.dtos.RegisterRequest;
public interface AuthService {
  public AuthResponse register(RegisterRequest request);
  public AuthResponse authenticate(AuthenticationRequest request);
}
