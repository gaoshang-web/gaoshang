package com.gs.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class CartInfo implements Serializable {

        private Integer id;

        private String productName;

        private String mainImg;

        private BigDecimal price;

        private Integer count;
}
