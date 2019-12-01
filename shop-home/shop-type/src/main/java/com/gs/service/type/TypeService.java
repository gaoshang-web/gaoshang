package com.gs.service.type;

import com.gs.entity.TypeInfo;

import java.util.List;

public interface TypeService {
    List<TypeInfo> queryTypeList(String id);
}
