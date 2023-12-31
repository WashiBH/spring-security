package com.blascode.springsecurity.service;

import com.blascode.springsecurity.config.JwtService;
import com.blascode.springsecurity.controller.dtos.AuthResponse;
import com.blascode.springsecurity.controller.dtos.AuthenticationRequest;
import com.blascode.springsecurity.controller.dtos.RegisterRequest;
import com.blascode.springsecurity.entity.Role;
import com.blascode.springsecurity.entity.User;
import com.blascode.springsecurity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;

  @Override
  public AuthResponse register(RegisterRequest request) {
    var user = User.builder()
      .firstName(request.getFirstName())
      .lastName(request.getLastName())
      .email(request.getEmail())
      .password(passwordEncoder.encode(request.getPassword()))
      .role(Role.USER)
      .build();
    userRepository.save(user);
    var jwtToken = jwtService.generateToken(user);
    return AuthResponse.builder().token(jwtToken).build();
  }

  @Override
  public AuthResponse authenticate(AuthenticationRequest request) {
    authenticationManager.authenticate(
      new UsernamePasswordAuthenticationToken(
        request.getEmail(),
        request.getPassword()
      )
    );
    var user = userRepository.findByEmail(request.getEmail()).orElseThrow();
    var jwtToken = jwtService.generateToken(user);
    return AuthResponse.builder().token(jwtToken).build();
  }
}
