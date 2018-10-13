package com.dadagum.team.service;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {

    public boolean upload(MultipartFile file);

    public ResponseEntity<FileSystemResource> download(String path);
}
