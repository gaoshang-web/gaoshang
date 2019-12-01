package com.gs.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gs.entity.CustomerInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface CustomerMapper extends BaseMapper<CustomerInfo> {
}
