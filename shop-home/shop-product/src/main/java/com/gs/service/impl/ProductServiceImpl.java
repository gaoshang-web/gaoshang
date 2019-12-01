package com.gs.service.impl;

import com.gs.dao.ProductMapper;
import com.gs.entity.ProductInfo;
import com.gs.service.ProductService;
import com.gs.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productDao;

    @Override
    public void pagingQueryProduct(PageBean<ProductInfo> pageBean, String id) {
        Long totalCount=productDao.totalNumber(id);
        pageBean.setRecordsTotal(totalCount);
        pageBean.setRecordsFiltered(totalCount);
        List<ProductInfo> productList=productDao.pagingQueryProduct(pageBean, id);
        pageBean.setData(productList);
    }
}
