package com.gs.controller;

import com.gs.entity.BrandInfo;
import com.gs.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class BrandController {
    @Autowired
    private BrandService brandService;

    @RequestMapping("queryBrandList")
    public List<BrandInfo> queryBrandList(HttpServletResponse response){
        return brandService.queryBrandList();
    }

    @RequestMapping("queryBrandLists")
    public List<BrandInfo> queryBrandLists(HttpServletResponse response, String id){
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "DNT,X-Mx-ReqToken,Keep-Alive,User-Agent,X-Requested-With,If-Modified-Since,Cache-Control,accept,Content-Type");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        return brandService.queryBrandLists(id);
    }

}
