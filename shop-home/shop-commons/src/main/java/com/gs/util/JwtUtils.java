package com.gs.util;

import com.alibaba.fastjson.JSON;
import io.jsonwebtoken.*;
import sun.misc.BASE64Encoder;

import java.util.HashMap;
import java.util.Map;

public class JwtUtils {
    //jwt生成字符串
    public static  String createToken(Map<String,Object> map){
        //声明头部信息
        Map<String,Object> headerMap=new HashMap<String,Object>();
        headerMap.put("alg","HS256");
        headerMap.put("typ","JWT");
        //设置负载:不要存放涉密的东西比如:银行账号密码，余额，身份证号
        Map<String,Object> payload=new HashMap<String,Object>();
        payload.putAll(map);
        Long iat=System.currentTimeMillis();
        //设置jwt失效时间(30分钟)
        payload.put("exp",iat+1800000l);
        payload.put("iat",iat);
        //签名值就是我们的安全密钥
        String token=Jwts.builder()
                .setHeader(headerMap)
                .setPayload(JSON.toJSONString(payload))
                .signWith(SignatureAlgorithm.HS256,getSecretKey("gaoShang"))
                .compact();
        return token;
    }

    public static ResponseServer resolverToken(String token ){
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(getSecretKey("gaoShang"))
                    .parseClaimsJws(token)
                    .getBody();
        }catch (ExpiredJwtException exp){
            System.out.println("token超时失效");
            return ResponseServer.error(ResponseEnum.TOKEN_TIMEOUT);
        }catch (SignatureException sing){
            System.out.println("token解析失败");
            return ResponseServer.error(ResponseEnum.SAFETY_ERROR);
        }
        return ResponseServer.success();
    }
    private  static String getSecretKey(String key){
        return new BASE64Encoder().encode(key.getBytes());
    }

}
