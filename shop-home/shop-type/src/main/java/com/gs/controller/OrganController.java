package com.gs.controller;

import com.gs.service.organ.OrganService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@RestController
public class OrganController {
    @Autowired
    private OrganService organService;

    @RequestMapping("queryTypeBrandTreeMenu")
    public List<Map<String, Object>> queryTypeBrandTreeMenu(HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "DNT,X-Mx-ReqToken,Keep-Alive,User-Agent,X-Requested-With,If-Modified-Since,Cache-Control,accept,Content-Type");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        return organService.queryTypeBrandTreeMenu();
    }

}
