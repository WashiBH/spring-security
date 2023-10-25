package com.blascode.springsecurity.controller;

import com.blascode.springsecurity.controller.dtos.UploadFileDto;
import com.blascode.springsecurity.service.UploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/blobstorage-azure")
public class UploadFileController {

  @Autowired
  private UploadFileService uploadFileService;

  @PostMapping("/upload-file")
  public ResponseEntity<String> uploadFileBlobStorage(@RequestBody UploadFileDto uploadFileDto){
    String resultService = uploadFileService.uploadFileAzure(uploadFileDto);
    return ResponseEntity.ok(resultService);
  }

  @PostMapping("/download-file")
  public ResponseEntity<String> downloadFileBlobStorage(@RequestBody UploadFileDto uploadFileDto){
    String resultService = uploadFileService.downloadFileAzure(uploadFileDto);
    return ResponseEntity.ok(resultService);
  }

  @PostMapping("/delete-file")
  public ResponseEntity<String> deleteFileBlobStorage(@RequestBody UploadFileDto uploadFileDto){
    String resultService = uploadFileService.deleteFileAzure(uploadFileDto);
    return ResponseEntity.ok(resultService);
  }
}
