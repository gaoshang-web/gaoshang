package com.gs.service;

import com.gs.util.ResponseServer;

public interface CartService {
    ResponseServer addCart(String productId, String userPhone);
}
