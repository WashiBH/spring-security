package com.blascode.springsecurity.controller.dtos;

import lombok.Data;
@Data
public class UploadFileDto {
  private String name;
  private String fileBase64;
}
