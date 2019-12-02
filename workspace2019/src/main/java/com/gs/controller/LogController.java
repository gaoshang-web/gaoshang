package com.gs.controller;

import com.gs.entity.LogInfo;
import com.gs.service.log.LogService;
import com.gs.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LogController {
    @Autowired
    private LogService logService;

    @RequestMapping("logJsp")
    public String logJsp(){
        return "/log/log-list";
    }

    @RequestMapping("pagingQueryLog")
    @ResponseBody
    public PageBean<LogInfo> pagingQueryLog(PageBean<LogInfo> pageBean){
        logService.pagingQueryLog(pageBean);
        return pageBean;
    }
}
