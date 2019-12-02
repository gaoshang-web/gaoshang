package com.gs.controller;

import com.gs.entity.UserInfo;
import com.gs.service.user.UserService;
import com.gs.util.FileCopy;
import com.gs.util.FileUtil;
import com.gs.util.PageBean;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("userJsp")
    public String userJsp(){
        return "user/user-list";
    }

    @RequestMapping(value = "login", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String login(UserInfo userInfo, HttpServletRequest request){
        UserInfo user = userService.queryUserByUserName(userInfo.getUserName());
        if(user != null){
            if(userInfo.getPassword().equals(user.getPassword())){
                request.getSession().getServletContext().setAttribute("userInfo",user);
                if(user.getLoginCount() != null && user.getStatus() == 1){
                    user.setLoginCount(user.getLoginCount()+1);
                }
                user.setLastLoginTime(new Date());
                userService.updateUser(user);
                if(user.getStatus() == 1){
                    return "{\"success\":\"登录成功!\"}";
                }else {
                    return "{\"success\":\"无效用户!\"}";
                }
            }else {
                return "{\"error\":\"用户名或密码错误!\"}";
            }
        }else {
            return "{\"error\":\"用户名或密码错误!\"}";
        }
    }
    @RequestMapping("pagingQueryUser")
    @ResponseBody
    public PageBean<UserInfo> pagingQueryUser(PageBean<UserInfo> pageBean, UserInfo userInfo){
        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        userService.pagingQueryUser(pageBean, userInfo);
        return pageBean;
    }
    @RequestMapping("saveUser")
    public String saveUser(UserInfo userInfo){
        userService.saveUser(userInfo);
        return "user/user-list";
    }
    @RequestMapping("updateUserStatus")
    @ResponseBody
    public Map<String, Object> updateUserStatus(Integer id, boolean confirm){
        UserInfo userInfo = userService.queryUserById(id);
        Map<String, Object> map = new HashMap<String, Object>();
        if(confirm==true){
            if(userInfo.getStatus() == 1){
                userInfo.setStatus(2);
                map.put("wudi",false);
            }else {
                userInfo.setStatus(1);
                map.put("wudi",true);
            }
            userService.updateUser(userInfo);
        }
        return map;
    }
    @RequestMapping("queryUserById")
    public ModelAndView queryUserById(Integer id){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("user/user-update");
        UserInfo userInfo = userService.queryUserById(id);
        mav.addObject("userInfo", userInfo);
        return mav;
    }
    @RequestMapping("updateUser")
    public String updateUser(UserInfo userInfo) {
        userService.updateUser(userInfo);
        return "user/user-list";
    }
    @RequestMapping("uploadFile")
    @ResponseBody
    public Map<String, Object> uploadFile(@RequestParam("photo") CommonsMultipartFile photo){
        Map<String, Object> map = new HashMap<String, Object>();
        String upload = FileCopy.copyFile(photo, "upload");
        map.put("upload", upload);
        return map;
    }
    @RequestMapping("importExcel")
    public void importExcel(HttpServletResponse response){
        List<UserInfo> userList = userService.queryUser();
        //创建XSSFWorkbook
        XSSFWorkbook workbook = new XSSFWorkbook();
        //创建sheet
        XSSFSheet sheet = workbook.createSheet();
        //创建行
        XSSFRow row = sheet.createRow(0);
        //创建第一个单元格
        XSSFCell cell2 = row.createCell(1);
        cell2.setCellValue("用户名");
        //创建第二个单元格
        XSSFCell cell3 = row.createCell(2);
        cell3.setCellValue("真实姓名");
        //创建第三个单元格
        XSSFCell cell4 = row.createCell(3);
        cell4.setCellValue("邮箱");
        //创建第四个单元格
        XSSFCell cell5 = row.createCell(4);
        cell5.setCellValue("性别");
        //创建第五个单元格
        XSSFCell cell6 = row.createCell(5);
        cell6.setCellValue("用户状态");
        //创建第六个单元格
        XSSFCell cell7 = row.createCell(6);
        cell7.setCellValue("登录次数");
        //创建第七个单元格
        XSSFCell cell8 = row.createCell(7);
        cell8.setCellValue("上次登陆时间");

        for(int i = 0 ; i < userList.size(); i++){
            //创建第2行
            XSSFRow row2=sheet.createRow(i+1);
            //创建第一个单元格
            XSSFCell cell9 = row2.createCell(1);
            cell9.setCellValue(userList.get(i).getUserName());
            //创建第二个单元格
            XSSFCell cell10 = row2.createCell(2);
            cell10.setCellValue(userList.get(i).getRealName());
            //创建第三个单元格
            XSSFCell cell11 = row2.createCell(3);
            cell11.setCellValue(userList.get(i).getMailbox());
            //创建第四个单元格
            XSSFCell cell12 = row2.createCell(4);
            cell12.setCellValue(userList.get(i).getSex()==1 ?"男" :"女");
            //创建第五个单元格
            XSSFCell cell13= row2.createCell(5);
            cell13.setCellValue(userList.get(i).getStatus()==1 ?"正常使用" :"用户无效");
            //创建第六个单元格
            XSSFCell cell14 = row2.createCell(6);
            cell14.setCellValue(userList.get(i).getLoginCount());
            //创建第七个单元格
            XSSFCell cell15 = row2.createCell(7);
            SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            if(userList.get(i).getLastLoginTime() != null){
                cell15.setCellValue(sim.format(userList.get(i).getLastLoginTime()));
            }
        }
        FileUtil.excelDownload(workbook, response);
    }
}
