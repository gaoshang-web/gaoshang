package com.gs.util;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

public class FileCopy {
    public static String copyFile(CommonsMultipartFile photo, String mkdirName){
        //获取老文件名对象
        String oldFileName = photo.getOriginalFilename();
        //创建一个时间戳
        long timestamp = System.currentTimeMillis();
        //给老的文件名重命名并和时间戳进行拼接
        String newFile = timestamp + oldFileName.substring(oldFileName.lastIndexOf("."));
        //获取HttpServletRequest
        HttpServletRequest request= ((ServletRequestAttributes)(RequestContextHolder.currentRequestAttributes())).getRequest();
        //拼接保存文件的绝对路径 getRealPath()是获取该项目在电脑硬盘中的绝对路径
        String realPath = request.getServletContext().getRealPath("/") + mkdirName;
        //判断文件夹是否存在 if !.exists():如果文件夹不存在  .mkdir()自动创建一个文件夹
        File file = new File(realPath);
        if(!file.exists()){
            file.mkdir();
        }
        try {
            photo.transferTo(new File(realPath + "/" + newFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "/" +mkdirName + "/" + newFile;
    }
}
