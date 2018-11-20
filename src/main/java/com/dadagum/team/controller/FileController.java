package com.dadagum.team.controller;

import com.dadagum.team.common.api.JsonResult;
import com.dadagum.team.common.model.ProjectFile;
import com.dadagum.team.common.dto.JwtUserDTO;
import com.dadagum.team.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileController {

    private final FileService fileService;

    @Autowired
    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping("/file")
    @ResponseBody
    public ResponseEntity<JsonResult<?>> upload(@RequestParam("file") MultipartFile file, @RequestAttribute JwtUserDTO userInfo, ProjectFile fileInfo){
        fileService.upload(file, userInfo, fileInfo);
        return ResponseEntity.ok(new JsonResult<>(null, "上传成功"));
    }

    @GetMapping("/file/{pid}/{fid}")
    public ResponseEntity<FileSystemResource> download(@RequestAttribute JwtUserDTO userInfo, @PathVariable int pid, @PathVariable int fid){
        return fileService.download(userInfo,fid, pid);
    }
}
