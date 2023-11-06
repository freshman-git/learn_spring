package com.example.controller;


import org.apache.commons.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

@Controller
public class LoginController {


    @GetMapping(value = {"/","/login"})
    public String loginPage() throws IOException {
        File txt = new File("E:\\githubRepo\\learn_spring\\bootDemo\\a.txt");
        File path = new File("E:\\githubRepo\\learn_spring\\bootDemo\\aaaa");
        if (!path.exists()){
            path.mkdir();
        }
        File file = new File(path, "b.txt");
        FileInputStream fileInputStream = new FileInputStream(txt);
        System.out.println(fileInputStream.available());
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        byte[] bytes = new byte[8192];
        int len = 0;
        while ((len = fileInputStream.read(bytes)) != -1){
            fileOutputStream.write(bytes,0,len);
        }
        return "login";
    }


    @PostMapping("/login")
    public String login(String userName,String password){

        return "redirect:/success.html";
    }

    @GetMapping("/success.html")
    public String getSuccess(){
        return "success";
    }

    /**
     * MultipartFile 自动封装上传上来的文件
     * @param email
     * @param username
     * @param headerImg
     * @param photos
     * @return
     */
    @PostMapping("/upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("username") String username,
                         @RequestPart("headerImg")MultipartFile headerImg,
                         @RequestPart("photos") MultipartFile[] photos) throws IOException {

//        List<MultipartFile> res = new ArrayList<>();


        if (!headerImg.isEmpty()){
            String originalFilename = headerImg.getOriginalFilename();
            String path = "E:\\tempCache";
            File folder = new File(path);
            if (!folder.exists()){
                folder.mkdir();
            }
            headerImg.transferTo(new File(path,originalFilename));
        }


//        if (photos.length>0){
//            for (MultipartFile photo : photos) {
////                String currentPhotoName = photo.getOriginalFilename();
////                photo.transferTo(new File("E:\\tempCache\\"+currentPhotoName));
//                res.add(photo);
//            }
//        }
        MultipartFile photo = photos[0];
        String filename = photo.getOriginalFilename();
        String savepath = "E:\\githubRepo\\learn_spring\\bootDemo";
        File folder = new File(savepath);
        if (!folder.exists()){
            folder.mkdir();
        }
        File saveFile = new File(savepath, photo.getOriginalFilename());
        photo.transferTo(saveFile);
//        saveFile.deleteOnExit();
//        saveFile.delete();
//        InputStream inputStream = photo.getInputStream();
//        System.out.println(inputStream.available()+"==============");
        FileInputStream fileInputStream = new FileInputStream(saveFile);
//        System.out.println(fileInputStream.available()+"=============");
        ZipInputStream zipInputStream = new ZipInputStream(fileInputStream, Charset.forName("GBK"));
        System.out.println(zipInputStream.available()+"-------------");
        ZipEntry nextEntry = null;
        while((nextEntry = zipInputStream.getNextEntry())!=null) {
            System.out.println("nextEntry"+filename+":"+nextEntry.getSize());
            String path = "E:\\githubRepo\\learn_spring\\bootDemo";
            File file = new File(path + File.separator + nextEntry.getName());
            if (file.isDirectory()){
                file.mkdir();
                nextEntry.clone();
                continue;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            byte[] bytes = new byte[8192];
            int len = 0;
            while ((len = zipInputStream.read(bytes)) != -1){
                bufferedOutputStream.write(bytes,0,len);
            }
        }
//        List<MultipartFile> res = unZip(inputStream);
//        for (int i = 0; i < res.size(); i++) {
//            System.out.println(res.get(i).toString());
//            System.out.println(res.get(i).getOriginalFilename());
//        }
        return "success";
    }

    public List<MultipartFile> unZip(InputStream inputStream){
        List<MultipartFile> res= null;
        ZipInputStream zipInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            zipInputStream = new ZipInputStream(inputStream, Charset.forName("GBK"));
            ZipEntry nextEntry = null;
            while((nextEntry = zipInputStream.getNextEntry())!=null){
                String path = getClass().getClassLoader().getResource("").getPath();
                File file = new File(path+File.separator+nextEntry.getName());
                System.out.println(file.getAbsolutePath());
                if (file.isDirectory()){
                    file.mkdir();
                    nextEntry.clone();
                    continue;
                }
                fileOutputStream = new FileOutputStream(file);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                byte[] bytes = new byte[8192];
                int len = 0;
                while ((len = zipInputStream.read(bytes)) != -1){
                    bufferedOutputStream.write(bytes,0,len);
                }
                MultipartFile multipartFile = fileToMultipartFile(file);
                res.add(multipartFile);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    public  MultipartFile fileToMultipartFile(File oneFile) throws IOException {
        FileItem fileItem = new DiskFileItem(oneFile.getName(), Files.probeContentType(oneFile.toPath()), false, oneFile.getName(), (int) oneFile.length(), oneFile.getParentFile());
        InputStream input = null;
        OutputStream os = null;
        MultipartFile multipartFile = null;
        try {
            input = new FileInputStream(oneFile);
            os = fileItem.getOutputStream();
            IOUtils.copy(input, os);
            multipartFile = new CommonsMultipartFile(fileItem);
            input.close();
            os.close();
            return multipartFile;
        } catch (IOException ex) {
            throw new RuntimeException();
        } finally {
            if(input != null){
                try {input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(os != null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
