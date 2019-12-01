package com.gs.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gs.entity.TypeInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface TypeMapper extends BaseMapper<TypeInfo> {
    List<TypeInfo> queryTypeList(String id);
}
