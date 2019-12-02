package com.gs.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gs.entity.CartInfo;
import com.gs.util.HttpConnection;
import com.gs.util.ResponseServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService{
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public ResponseServer addCart(String productId, String userPhone) {
        //获取购物车id
        String cartId = (String) redisTemplate.opsForValue().get("cartid_" + userPhone);
        //根据商品id查询商品信息
        String url = "http://localhost:9092/productSearch/" + productId;
        String result = HttpConnection.doGet(url);
        JSONObject jsonObject= JSON.parseObject(result);
        System.out.println(jsonObject.get("data"));
        JSONObject productData=JSON.parseObject(jsonObject.get("data").toString());
        //讲数据加入购物车实体bean中
        CartInfo cartInfo=new CartInfo();
        cartInfo.setId(productData.getInteger("id"));
        cartInfo.setProductName(productData.getString("name"));
        cartInfo.setMainImg(productData.getString("mainImg"));
        cartInfo.setPrice(productData.getBigDecimal("price"));
        //判断商品是否存在购物车
        if(redisTemplate.opsForHash().hasKey(cartId, productId)){
            CartInfo cart= (CartInfo) redisTemplate.opsForHash().get(cartId,productId);
            cartInfo.setCount(cart.getCount()+1);
        }else{
            cartInfo.setCount(1);
        }
        //加入到redis
        redisTemplate.opsForHash().put(cartId, productId, cartInfo);
        Long cartCount=redisTemplate.opsForHash().size(cartId);
        return ResponseServer.success(cartCount);
    }
}
