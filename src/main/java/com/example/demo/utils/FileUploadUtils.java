package com.example.demo.utils;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class FileUploadUtils {

    public static String upLoadPicture(MultipartFile file, String savePath, HttpServletRequest request) throws IOException {
        //String serviceUrl = "http://139.199.64.249:8080/museum-0.0.1-SNAPSHOT";//服务器IP
        String serviceUrl = "http://192.168.50.98:8080";//服务器IP
        String dir = request.getServletContext().getRealPath(savePath);
        File fileDir = new File(dir);
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }
        String suffixName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        String fileName = UUID.randomUUID().toString() + suffixName;
        File newFile = new File(  fileDir+"/" + fileName);
        file.transferTo(newFile);
        return serviceUrl+"/"+savePath+"/"+fileName;
    }
}
