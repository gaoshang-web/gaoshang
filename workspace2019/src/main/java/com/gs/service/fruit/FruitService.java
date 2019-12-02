package com.gs.service.fruit;

import com.gs.entity.FruitInfo;
import com.gs.util.PageBean;

public interface FruitService {
    void pagingQueryFruit(PageBean<FruitInfo> pageBean, FruitInfo fruitInfo);

    void saveFruit(FruitInfo fruitInfo);

    FruitInfo queryFruitById(Integer id);

    void updateFruit(FruitInfo fruitInfo);
}
