package com.gs.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class LogInfo {
    //编号
    private Integer id;
    //操作人
    private String operationUser;
    //类路径
    private String classUrl;
    //方法名
    private String methodName;
    //ip地址
    private String ipAddr;
    //方法描述
    private String methodMessage;
    //耗时
    private Long consumeTime;
    //日志状态
    private Integer status;
    //当前时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date currentTime;

    public Date getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(Date currentTime) {
        this.currentTime = currentTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOperationUser() {
        return operationUser;
    }

    public void setOperationUser(String operationUser) {
        this.operationUser = operationUser;
    }

    public String getClassUrl() {
        return classUrl;
    }

    public void setClassUrl(String classUrl) {
        this.classUrl = classUrl;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }

    public String getMethodMessage() {
        return methodMessage;
    }

    public void setMethodMessage(String methodMessage) {
        this.methodMessage = methodMessage;
    }

    public Long getConsumeTime() {
        return consumeTime;
    }

    public void setConsumeTime(Long consumeTime) {
        this.consumeTime = consumeTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
