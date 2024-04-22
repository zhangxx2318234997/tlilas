package com.itzhangxx.controller;

import com.itzhangxx.pojo.Result;
import com.itzhangxx.utils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@RestController
public class UploadController {
    @Autowired
    private AliOSSUtils aliOSSUtils;

    @PostMapping("/upload")
    public Result upload(MultipartFile image) throws IOException {
        log.info("文件上传，文件名:{}",image.getOriginalFilename());

        //调用阿里云工具类进行文件上传
        String url = aliOSSUtils.upload(image);
        log.info("文件上传成功，文件访问的url:{}",url);

        return Result.success(url);
    }

}
