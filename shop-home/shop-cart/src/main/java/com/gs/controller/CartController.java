package com.gs.controller;

import com.gs.service.CartService;
import com.gs.util.ResponseServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin(maxAge = 3600,origins = "http://localhost:8080")
public class CartController {
    @Autowired
    private CartService cartService;
    @PostMapping
    public ResponseServer addCart(String productId, HttpServletRequest request){
        String userPhone= (String) request.getAttribute("phone");
        return cartService.addCart(productId,userPhone);
    }
}
