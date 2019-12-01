package com.gs.controller;

import com.gs.entity.CustomerInfo;
import com.gs.service.CustomerService;
import com.gs.util.JwtUtils;
import com.gs.util.ResponseEnum;
import com.gs.util.ResponseServer;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@CrossOrigin(maxAge = 3600, origins = "http://localhost:8080")
public class LoginController {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private CustomerService customerService;

    @RequestMapping("sendCode")
    public ResponseServer sendCode(String phone) throws IOException {
        //判断手机号是否为空
        if (StringUtils.isBlank(phone)) {
            return ResponseServer.error(ResponseEnum.PHONE_ISNULL);
        }
        //发送验证码
        /*JSONObject jsonObject = SendMessage.sendMessage(phone);
        String code = jsonObject.getString("code");
        if (code.equals("200")) {
            String checkCode = jsonObject.getString("obj");
            redisTemplate.opsForValue().set("code_" + phone, checkCode, 300, TimeUnit.SECONDS);
        }*/
        redisTemplate.opsForValue().set("code_" + phone, "123456", 300, TimeUnit.SECONDS);
        return ResponseServer.success();
    }

    @RequestMapping("login")
    public ResponseServer login(String phone, String code){
        //判断手机号或者验证码不能为空
        if (StringUtils.isBlank(phone) && StringUtils.isBlank(code)){
            return ResponseServer.error(ResponseEnum.PHONE_OR_CODE_ISNULL);
        }
        //验证验证码是否正确
        String codes = (String) redisTemplate.opsForValue().get("code_" + phone);
        if (!code.equals(codes)){
            return ResponseServer.error(ResponseEnum.LOGIN_CODE_ERROR);
        }
        //删除该手机号之前的验证码
        redisTemplate.delete("code_" + phone);
        //判断该手机号是否存在,不存在注册
        CustomerInfo customerInfo = customerService.phoneRegister(phone);
        //生成token
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("user_" + phone, customerInfo);
        String token = JwtUtils.createToken(map);
        return ResponseServer.success(token);
    }
}
