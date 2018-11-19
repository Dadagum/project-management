package com.dadagum.team.service;

import com.dadagum.team.common.model.ProjectFile;
import com.dadagum.team.common.dto.JwtUserDTO;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {

    public boolean upload(MultipartFile file, JwtUserDTO userInfo, ProjectFile fileInfo);

    public ResponseEntity<FileSystemResource> download(JwtUserDTO userInfo, int fid);
}
