package com.gs.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("p_customer")
public class CustomerInfo {
    @TableId(value = "id", type = IdType.UUID)
    private String id;
    @TableField("userName")
    private String userName;
    @TableField("password")
    private String password;
    @TableField("phone")
    private String phone;
    @TableField("loginState")
    private Integer loginState;
    @TableField("updateTime")
    private Date updateTime;
    @TableField("cartId")
    private String cartId;
}
