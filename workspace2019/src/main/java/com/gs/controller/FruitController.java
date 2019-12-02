package com.gs.controller;

import com.gs.aopLog.LogAnnotation;
import com.gs.entity.FruitInfo;
import com.gs.service.fruit.FruitService;
import com.gs.util.FileCopy;
import com.gs.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class FruitController {
    @Autowired
    private FruitService fruitService;

    @RequestMapping("fruitJsp")
    @LogAnnotation("跳转水果查询页面的方法")
    public String fruitJsp(){
        return "fruit/fruit-list";
    }
    @RequestMapping("pagingQueryFruit")
    @ResponseBody
    public PageBean<FruitInfo> pagingQueryFruit(PageBean<FruitInfo> pageBean, FruitInfo fruitInfo){
        fruitService.pagingQueryFruit(pageBean, fruitInfo);
        return pageBean;
    }
    @RequestMapping("saveFruit")
    public String saveFruit(FruitInfo fruitInfo){
        fruitService.saveFruit(fruitInfo);
        return "fruit/fruit-list";
    }
    @RequestMapping("uploadFile")
    @ResponseBody
    public Map<String, Object> uploadFile(@RequestParam("photo") CommonsMultipartFile photo){
        Map<String, Object> map = new HashMap<String, Object>();
        String upload = FileCopy.copyFile(photo, "upload");
        map.put("data", upload);
        return map;
    }
    @RequestMapping("updateFruitRacking")
    @ResponseBody
    public Map<String, Object> updateFruitRacking(Integer id){
        FruitInfo fruitInfo = fruitService.queryFruitById(id);
        Map<String, Object> map = new HashMap<String, Object>();
        if(fruitInfo.getRacking() == 1){
            fruitInfo.setRacking(2);
            map.put("racking",1);
        }else {
            fruitInfo.setRacking(1);
            map.put("racking",2);
        }
        fruitService.updateFruit(fruitInfo);
        return map;
    }
    @RequestMapping("queryFruitById")
    public ModelAndView queryFruitById(Integer id){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("fruit/fruit-update");
        FruitInfo fruitInfo = fruitService.queryFruitById(id);
        mav.addObject("fruitInfo", fruitInfo);
        return mav;
    }
    @RequestMapping("updateFruit")
    public String updateFruit(FruitInfo fruitInfo) {
        fruitService.updateFruit(fruitInfo);
        return "fruit/fruit-list";
    }
}
