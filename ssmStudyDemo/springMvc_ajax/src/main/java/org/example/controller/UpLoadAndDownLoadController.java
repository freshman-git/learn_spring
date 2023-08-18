package org.example.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.UUID;

/**
 * @ResponseEntity:可以作为控制器方法的返回值，表示相应到浏览器的完整的响应报文
 *
 * 文件上传的要求：
 * 1）form表单的提交方式必须为post
 * 2）form表单必须设置属性enctype="multipart/form-data"
 */

@RestController
public class UpLoadAndDownLoadController {



    @RequestMapping("/test/downLoad")
    public ResponseEntity<byte[]> testDownLoad(HttpSession session) throws IOException {
        //获取ServletContext对象
        ServletContext servletContext = session.getServletContext();
        //获取服务器中文件的真实路径
        String realPath = servletContext.getRealPath("img");
        realPath += File.separator+"1.jpg";
        //创建输入流
        FileInputStream fileInputStream = new FileInputStream(realPath);
        //创建字节数组
        byte[] bytes = new byte[fileInputStream.available()];
        //将流读到字节数组中
        fileInputStream.read(bytes);
        //创建HttpHeaders对象设置响应头信息
        HttpHeaders httpHeaders = new HttpHeaders();
        //设置要下载方式以及下载文件的名字
        httpHeaders.add("Content-Disposition","attachment;filename=1.jpg");
        //设置响应状态码
        HttpStatus httpStatus = HttpStatus.OK;
        //创建ResponseEntity对象
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<byte[]>(bytes,httpHeaders,httpStatus);
        //关闭输入流
        fileInputStream.close();
        return responseEntity;

    }

    @RequestMapping("/test/upLoad")
    public String testUpLoad(MultipartFile photo, HttpSession session) throws IOException {

        String filename = photo.getOriginalFilename();

        ServletContext servletContext = session.getServletContext();
//        把上传的文件放到photo文件夹里
        String realPath = servletContext.getRealPath("photo");
        File file = new File(realPath);
        if (!file.exists()){
            file.mkdir();
        }

        String hzName = filename.substring(filename.lastIndexOf("."));

        String uuid = UUID.randomUUID().toString();
        filename = uuid+hzName;

        String finalPath = realPath + File.separator + filename;

        photo.transferTo(new File(finalPath));

        return "success";


    }
}
