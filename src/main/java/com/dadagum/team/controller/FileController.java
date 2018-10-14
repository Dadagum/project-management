package com.dadagum.team.controller;

import com.dadagum.team.common.api.JsonResult;
import com.dadagum.team.common.constant.JsonCode;
import com.dadagum.team.common.validator.ImageValidator;
import com.dadagum.team.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping("/file")
    @ResponseBody
    public JsonResult<?> upload(@RequestParam("file") MultipartFile file){
        if (ImageValidator.getValidator(file).checkAll()){
            fileService.upload(file);
            return new JsonResult<>(null, "上传成功", JsonCode.SUCCESS);
        }
        return new JsonResult<>(null, "上传失败", JsonCode.FAIL);
    }

//    @GetMapping("/file")
//    public ResponseEntity<FileSystemResource> download(){
//        String path = "/var/www/picture";
//        return fileService.download(path);
//    }
}
