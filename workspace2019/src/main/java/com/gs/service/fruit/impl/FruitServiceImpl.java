package com.gs.service.fruit.impl;

import com.gs.dao.FruitMapper;
import com.gs.entity.FruitInfo;
import com.gs.service.fruit.FruitService;
import com.gs.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FruitServiceImpl implements FruitService {
    @Autowired
    private FruitMapper fruitDao;

    public void pagingQueryFruit(PageBean<FruitInfo> pageBean, FruitInfo fruitInfo) {
        Long totalCount = fruitDao.totalNumber(fruitInfo);
        pageBean.setRecordsTotal(totalCount);
        pageBean.setRecordsFiltered(totalCount);
        List<FruitInfo> fruitList = fruitDao.pagingQueryFruit(pageBean, fruitInfo);
        pageBean.setData(fruitList);
    }

    public void saveFruit(FruitInfo fruitInfo) {
        fruitInfo.setRackingDate(new Date());
        fruitDao.saveFruit(fruitInfo);
    }

    public FruitInfo queryFruitById(Integer id) {
        return fruitDao.queryFruitById(id);
    }

    public void updateFruit(FruitInfo fruitInfo) {
        fruitDao.updateFruit(fruitInfo);
    }
}
