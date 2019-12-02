package com.gs.controller;

import com.gs.entity.TypeInfo;
import com.gs.service.type.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class TypeController {
    @Autowired
    private TypeService typeService;

    @RequestMapping("queryTypeList")
    public List<TypeInfo> queryTypeList(HttpServletResponse response, String id){
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "DNT,X-Mx-ReqToken,Keep-Alive,User-Agent,X-Requested-With,If-Modified-Since,Cache-Control,accept,Content-Type");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        List<TypeInfo> typeList = typeService.queryTypeList(id);
        return typeList;
    }
}
