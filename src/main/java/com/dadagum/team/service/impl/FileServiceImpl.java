package com.dadagum.team.service.impl;

import com.dadagum.team.common.model.ProjectFile;
import com.dadagum.team.common.dto.JwtUserDTO;
import com.dadagum.team.common.exception.def.NotAnImageException;
import com.dadagum.team.common.utils.FileUtil;
import com.dadagum.team.common.validator.ImageValidator;
import com.dadagum.team.mapper.FileMapper;
import com.dadagum.team.service.AuthService;
import com.dadagum.team.service.FileService;
import com.dadagum.team.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileServiceImpl implements FileService {

    private final FileMapper fileMapper;

    private final AuthService authService;

    private final GroupService groupService;

    @Autowired
    public FileServiceImpl(FileMapper fileMapper, AuthService authService, GroupService groupService) {
        this.fileMapper = fileMapper;
        this.authService = authService;
        this.groupService = groupService;
    }

    @Override
    public boolean upload(MultipartFile file, JwtUserDTO userInfo, ProjectFile fileInfo) {
        int gid = groupService.getGidByPid(fileInfo.getPid());
        authService.checkIfGroupMember(userInfo.getId(), gid);
        // 根据所在团队生成路径，暂时先模拟为如下
        String path = "/var/www/picture";
        return FileUtil.upload(file, path, file.getOriginalFilename());
    }

    @Override
    public ResponseEntity<FileSystemResource> download(JwtUserDTO userInfo, int fid, int pid) {
        int gid = groupService.getGidByPid(pid);
        authService.checkIfGroupMember(userInfo.getId(), gid);
        String path = fileMapper.getFilePathById(fid);
        return FileUtil.download(path);
    }

}
