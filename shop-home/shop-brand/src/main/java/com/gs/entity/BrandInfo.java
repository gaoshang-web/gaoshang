package com.gs.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@TableName("p_brand")
public class BrandInfo {
    //品牌表
    @TableId(value ="id",type = IdType.UUID)
    private String id;//	Integer
    @TableField("brandName")
    private String brandName;//	varchar 名称
    @TableField("brandPhone")
    private String brandPhone;//	varchar 电话
    @TableField("brandWebsite")
    private String brandWebsite;//	varchar0    网站
    @TableField("typeId")
    private String typeId;//	int 类型
    private String typeName;
    @TableField("brandLoGo")
    private String brandLoGo;//	varchar 图标
    @TableField("brandStatus")
    private Integer brandStatus;//	int 状态
    @TableField("updateTime")
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private Date updateTime;//	date    修改时间
}
