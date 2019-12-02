package com.gs.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class FruitInfo {
    //编号
    private Integer id;
    //水果名称(模糊查询)
    private String fruitName ;
    //是否上架(条件查询)
    private Integer racking;
    //上架日期(条件查询区间)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date rackingDate;
    //水果图片
    private String imgUrl;
    //开始时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startTime;
    //结束时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endTime;
    //排序字段名
    private String orderName;
    //排序
    private String orderBy;

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public Integer getRacking() {
        return racking;
    }

    public void setRacking(Integer racking) {
        this.racking = racking;
    }

    public Date getRackingDate() {
        return rackingDate;
    }

    public void setRackingDate(Date rackingDate) {
        this.rackingDate = rackingDate;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
