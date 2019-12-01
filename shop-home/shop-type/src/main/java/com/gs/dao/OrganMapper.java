package com.gs.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gs.entity.OrganInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface OrganMapper extends BaseMapper<OrganInfo> {
    List<OrganInfo> queryTypeBrandTreeMenu();
}
