package com.blascode.springsecurity.service;

import com.blascode.springsecurity.controller.dtos.UploadFileDto;
import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.blob.CloudBlob;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.CloudBlockBlob;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Base64;

@Service
public class UploadFileServiceImpl implements UploadFileService{
  @Override
  public String uploadFileAzure(UploadFileDto uploadFileDto) {
    String resultService = "";
    String azureStorageConnection = "DefaultEndpointsProtocol=https;AccountName=storagefilesazure;AccountKey=O4lStDg9JXZu9Ds4TMezFD42XuzkjjMiDWqfF9zjJDmD1tXpwMxB3uxBbnx7B2aebsBmEQ/3O/Pl+AStFUJHvA==;EndpointSuffix=core.windows.net";
    String containerName="files";
    try {
      CloudStorageAccount account = CloudStorageAccount.parse(azureStorageConnection);
      CloudBlobClient serviceClient = account.createCloudBlobClient();
      CloudBlobContainer container = serviceClient.getContainerReference(containerName);

      CloudBlob blob = container.getBlockBlobReference(uploadFileDto.getName());
      byte[] decodedBytes = Base64.getDecoder().decode(uploadFileDto.getFileBase64());
      blob.uploadFromByteArray(decodedBytes,0,decodedBytes.length);
      resultService = "Upload success";
    } catch (Exception e){
      resultService = e.getMessage();
    }
    return resultService;
  }

  @Override
  public String downloadFileAzure(UploadFileDto uploadFileDto) {
    String resultService = "";
    String azureStorageConnection = "DefaultEndpointsProtocol=https;AccountName=storagefilesazure;AccountKey=O4lStDg9JXZu9Ds4TMezFD42XuzkjjMiDWqfF9zjJDmD1tXpwMxB3uxBbnx7B2aebsBmEQ/3O/Pl+AStFUJHvA==;EndpointSuffix=core.windows.net";
    String containerName="files";
    try {
      CloudStorageAccount account = CloudStorageAccount.parse(azureStorageConnection);
      CloudBlobClient serviceClient = account.createCloudBlobClient();
      CloudBlobContainer container = serviceClient.getContainerReference(containerName);

      CloudBlockBlob blockBlob = container.getBlockBlobReference(uploadFileDto.getName());
      File file = new File("ruta donde se quiere guardar");
      blockBlob.downloadToFile(file.getAbsolutePath());
      resultService = "Download success";
    } catch (Exception e){
      resultService = e.getMessage();
    }
    return resultService;
  }

  @Override
  public String deleteFileAzure(UploadFileDto uploadFileDto) {
    String resultService = "";
    String azureStorageConnection = "DefaultEndpointsProtocol=https;AccountName=storagefilesazure;AccountKey=O4lStDg9JXZu9Ds4TMezFD42XuzkjjMiDWqfF9zjJDmD1tXpwMxB3uxBbnx7B2aebsBmEQ/3O/Pl+AStFUJHvA==;EndpointSuffix=core.windows.net";
    String containerName="files";
    try {
      CloudStorageAccount account = CloudStorageAccount.parse(azureStorageConnection);
      CloudBlobClient serviceClient = account.createCloudBlobClient();
      CloudBlobContainer container = serviceClient.getContainerReference(containerName);

      CloudBlockBlob blockBlob = container.getBlockBlobReference(uploadFileDto.getName());
      blockBlob.deleteIfExists();
      resultService = "Delete success";
    } catch (Exception e){
      resultService = e.getMessage();
    }
    return resultService;
  }
}
