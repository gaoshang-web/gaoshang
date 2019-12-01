package com.gs.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gs.entity.ProductInfo;
import com.gs.util.PageBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ProductMapper extends BaseMapper<ProductInfo> {
    Long totalNumber(String id);

    List<ProductInfo> pagingQueryProduct(@Param("pageBean") PageBean<ProductInfo> pageBean, @Param("id") String id);
}
