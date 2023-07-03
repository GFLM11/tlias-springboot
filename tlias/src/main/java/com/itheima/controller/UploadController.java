package com.itheima.controller;

import com.itheima.pojo.Result;
import com.itheima.utils.AliOSSUtils;
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

    /*
    *
    * 版本：本地存储
    * 作用：接受带图片的表单请求
    *   缺点：1.网络上无法获取    2.扩容不方便
    * */
    /*@PostMapping("/upload")
    public Result upload(String username, Integer age, MultipartFile image) throws IOException {
        log.info("文件上传：{}，{}，{}",username,age,image);
        String originalFilename = image.getOriginalFilename();
        if (originalFilename != null) {
            //上传文件到File服务器
            int index =originalFilename.lastIndexOf(".");
            String sn = originalFilename.substring(index);
            String fileName = UUID.randomUUID() + sn;
            image.transferTo(new File("D:\\IDEA\\Project\\file_server\\" + fileName));
        }
        return Result.success();
    }*/
    /*
    * 作用：获取前端发送的图片，把图片上传到
    *
    * */
    @PostMapping("/upload")
    public Result upload(MultipartFile image) throws IOException {
        log.info("文件上传操作：{}",image.getOriginalFilename());
        String imgUrl = aliOSSUtils.upload(image);
        log.info("图片的URL：{}",imgUrl);
        return Result.success(imgUrl);
    }

}
