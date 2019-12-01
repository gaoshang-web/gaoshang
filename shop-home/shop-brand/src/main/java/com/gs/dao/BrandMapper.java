package com.gs.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gs.entity.BrandInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BrandMapper extends BaseMapper<BrandInfo> {
    List<BrandInfo> queryBrandList();

    List<BrandInfo> queryBrandLists(String id);
}
