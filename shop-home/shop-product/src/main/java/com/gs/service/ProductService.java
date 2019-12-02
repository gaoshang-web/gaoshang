package com.gs.service;

import com.gs.entity.ProductInfo;
import com.gs.util.PageBean;

public interface ProductService {
    void pagingQueryProduct(PageBean<ProductInfo> pageBean, String id);

}
