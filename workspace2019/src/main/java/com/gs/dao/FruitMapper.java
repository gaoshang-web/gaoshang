package com.gs.dao;

import com.gs.entity.FruitInfo;
import com.gs.util.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FruitMapper {
    Long totalNumber(@Param("fruitInfo") FruitInfo fruitInfo);

    List<FruitInfo> pagingQueryFruit(@Param("pageBean") PageBean<FruitInfo> pageBean, @Param("fruitInfo") FruitInfo fruitInfo);

    void saveFruit(FruitInfo fruitInfo);

    FruitInfo queryFruitById(Integer id);

    void updateFruit(FruitInfo fruitInfo);
}
