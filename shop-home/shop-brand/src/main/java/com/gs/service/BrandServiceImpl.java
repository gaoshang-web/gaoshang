package com.gs.service;

import com.gs.dao.BrandMapper;
import com.gs.entity.BrandInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService{
    @Autowired
    private BrandMapper brandDao;

    @Override
    public List<BrandInfo> queryBrandList() {
        return brandDao.queryBrandList();
    }

    @Override
    public List<BrandInfo> queryBrandLists(String id) {
        return brandDao.queryBrandLists(id);
    }
}
