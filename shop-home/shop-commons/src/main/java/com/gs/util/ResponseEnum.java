package com.gs.util;

public enum ResponseEnum {
    USERNAME_OR_PASSWORD_ISNULL(1001, "账号或密码不存在"),
    USERNAME_NOT_EXIST(1002, "账号不存在"),
    USERNAME_INVALID(1003, "用户名无效,请联系客服"),
    PASSWORD_ERROR(1004, "密码错误,请重新输入"),
    USER_NOT_RIGHT(1005, "该用户没有权限,请联系客服"),
    PHONE_ISNULL(2001,"手机号不能为空"),
    USERNAME_EXCEPTION(3001, "账号异常,请联系客服"),
    TOKEN_TIMEOUT(3002,"登录失效，请重新登录"),
    TOKEN_ISNULL(3003,"token值为空"),
    PHONE_OR_CODE_ISNULL(3004,"手机号或者验证码不能为空"),
    LOGIN_CODE_ERROR(3005,"验证码不正确"),
    SERVER_CONNECT_ERROR(4001,"服务器连接失败"),
    SERVER_TIMEOUT(4002,"服务连接请求超时"),
    EXCEL_ISNULL(6001, "导出的数据是空的"),
    LEAVE_DAY_ISNULL(7001, "计算出的天数是一个0"),
    NO_RIGHT_RATIFY(8001, "没有权限审批"),
    SAFETY_ERROR(9001,"接口验签失败"),
    SUCCESS(200, "成功"),
    ERROR(500, "异常");

    private Integer code;
    private String message;

    private ResponseEnum(Integer code, String message) {
        this.code=code;
        this.message=message;
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
}
