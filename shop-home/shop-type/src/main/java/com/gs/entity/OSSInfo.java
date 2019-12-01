package com.gs.entity;

import lombok.Data;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Data
public class OSSInfo {
    private String endpoint;
    private String accessKeyId;
    private String accessKeySecret;
    private String bucketName;
    private String accessUrl;

    public OSSInfo() {

    }

    /**
     * 通过配置文件.properties文件获取，这几项内容。
     *
     * @param storageConfName
     * @throws IOException
     */
    public OSSInfo(String storageConfName) throws IOException {
        Properties prop = new Properties();
        InputStream is= super.getClass().getClassLoader().getResourceAsStream(storageConfName);
        prop.load(is);
        endpoint = prop.getProperty("Endpoint").trim();
        accessKeyId = prop.getProperty("AccessKey").trim();
        accessKeySecret = prop.getProperty("AccessKeySecret").trim();
        bucketName = prop.getProperty("BucketName").trim();
        accessUrl = prop.getProperty("accessUrl").trim();
    }
    public OSSInfo(String endpoint, String accessKeyId,String accessKeySecret, String bucketName, String accessUrl) {
        this.endpoint = endpoint;
        this.accessKeyId = accessKeyId;
        this.accessKeySecret = accessKeySecret;
        this.bucketName = bucketName;
        this.accessUrl = accessUrl;
    }
}
