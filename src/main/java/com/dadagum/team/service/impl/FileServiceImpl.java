package com.dadagum.team.service.impl;

import com.dadagum.team.common.utils.FileUtil;
import com.dadagum.team.service.FileService;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileServiceImpl implements FileService {

    @Override
    public boolean upload(MultipartFile file) {
        String path = "/var/www/picture";
        return FileUtil.upload(file, path, file.getOriginalFilename());
    }

    @Override
    public ResponseEntity<FileSystemResource> download(String path) {
        return FileUtil.download(path);
    }

}
