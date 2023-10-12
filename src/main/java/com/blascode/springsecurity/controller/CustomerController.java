package com.blascode.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/customer")
public class CustomerController {
  @GetMapping("/index/public")
  public String index(){
      return "Hola mundo public";
  }

  @GetMapping("/index/protected")
  public String indexProtected(){
    return "Hello world is secured";
  }
}
