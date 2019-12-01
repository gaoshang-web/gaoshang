package com.gs.service.type.impl;

import com.gs.dao.TypeMapper;
import com.gs.entity.TypeInfo;
import com.gs.service.type.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeMapper typeDao;

    @Override
    public List<TypeInfo> queryTypeList(String id) {
        return typeDao.queryTypeList(id);
    }
}
