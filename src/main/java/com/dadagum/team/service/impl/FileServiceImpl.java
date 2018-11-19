package com.dadagum.team.service.impl;

import com.dadagum.team.common.model.ProjectFile;
import com.dadagum.team.common.dto.JwtUserDTO;
import com.dadagum.team.common.exception.def.NotAnImageException;
import com.dadagum.team.common.utils.FileUtil;
import com.dadagum.team.common.validator.ImageValidator;
import com.dadagum.team.mapper.FileMapper;
import com.dadagum.team.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileServiceImpl implements FileService {

    private final FileMapper fileMapper;

    @Autowired
    public FileServiceImpl(FileMapper fileMapper) {
        this.fileMapper = fileMapper;
    }

    @Override
    public boolean upload(MultipartFile file, JwtUserDTO userInfo, ProjectFile fileInfo) {
        // 根据所在团队生成路径，暂时先模拟为如下
        String path = "/var/www/picture";
        return FileUtil.upload(file, path, file.getOriginalFilename());
    }

    @Override
    public ResponseEntity<FileSystemResource> download(JwtUserDTO userInfo, int fid) {
        String path = fileMapper.getFilePathById(fid);
        return FileUtil.download(path);
    }

}
