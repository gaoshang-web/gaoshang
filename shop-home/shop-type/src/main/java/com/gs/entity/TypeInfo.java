package com.gs.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("p_type")
public class TypeInfo {
    @TableId(value = "id",type = IdType.UUID)
    private String id;//	int
    @TableField("typeName")
    private String typeName;//	varchar
    @TableField("typeStatus")
    private Integer typeStatus;//	int
    @TableField("typeSort")
    private String typeSort;//	varchar
    @TableField("pid")
    private String pid;//	varchar
    private boolean checked;
}
