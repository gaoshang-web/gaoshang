package com.gs.controller;

import com.gs.entity.ProductInfo;
import com.gs.service.ProductService;
import com.gs.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping("pagingQueryProduct")
    public PageBean<ProductInfo> pagingQueryProduct(HttpServletResponse response, PageBean<ProductInfo> pageBean, String id){
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "DNT,X-Mx-ReqToken,Keep-Alive,User-Agent,X-Requested-With,If-Modified-Since,Cache-Control,accept,Content-Type");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        productService.pagingQueryProduct(pageBean, id);
        return pageBean;
    }
}
