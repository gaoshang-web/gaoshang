package com.gs.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("p_product")
public class ProductInfo {
    //编号(主键)
    @TableId(value = "id", type = IdType.UUID)
    private String id;
    //品牌ID
    @TableField("brandId")
    private String brandId;
    private String brandName;
    //商品名称
    @TableField("productName")
    private String productName;
    //品牌ID
    @TableField("typeId")
    private String typeId;
    private String typeName;
    //宣传标题
    @TableField("title")
    private String title;
    //主图片
    @TableField("mainImg")
    private String mainImg;
    //副图片
    @TableField("img")
    private String img;
    //商品描述
    @TableField("detail")
    private String detail;
    //价格
    @TableField("price")
    private double price;
    //库存
    @TableField("stock")
    private Integer stock;
    //状态
    @TableField("status")
    private Integer status;
    //创建时间
    @TableField("createTime")
    private Date createTime;
    //修改时间
    @TableField("updateTime")
    private Date updateTime;
}
