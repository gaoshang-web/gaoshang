package com.gs.service;

import com.gs.entity.BrandInfo;

import java.util.List;

public interface BrandService {
    List<BrandInfo> queryBrandList();

    List<BrandInfo> queryBrandLists(String id);
}
