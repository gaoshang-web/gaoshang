package com.gs.entity;

import lombok.Data;

@Data
public class OrganInfo {
    //编号
    private String id;
    //根节点
    private String pid;
    //名字
    private String name;
    //类型
    private Integer type;
    //被选中项
    private Boolean checked;
}
