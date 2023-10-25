package com.blascode.springsecurity.service;

import com.blascode.springsecurity.controller.dtos.UploadFileDto;
public interface UploadFileService {
  public String uploadFileAzure(UploadFileDto uploadFileDto);
  public String downloadFileAzure(UploadFileDto uploadFileDto);

  public String deleteFileAzure(UploadFileDto uploadFileDto);

}
