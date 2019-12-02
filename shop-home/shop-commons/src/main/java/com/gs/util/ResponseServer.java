package com.gs.util;

public class ResponseServer {

    private Integer code;
    private String message;
    private Object data;

    public ResponseServer(Integer code, String message){
        this.code=code;
        this.message=message;
    }

    private ResponseServer(Integer code, String message, Object data){
        this.code=code;
        this.message=message;
        this.data=data;
    }

    public static ResponseServer error(){
        return new ResponseServer(ResponseEnum.ERROR.getCode(), ResponseEnum.ERROR.getMessage());
    }

    public static ResponseServer error(ResponseEnum loginEnum){
        return new ResponseServer(loginEnum.getCode(), loginEnum.getMessage());
    }

    public static ResponseServer success(){
        return new ResponseServer(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getMessage());
    }

    public static ResponseServer success(Object data){
        return new ResponseServer(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getMessage(), data);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
