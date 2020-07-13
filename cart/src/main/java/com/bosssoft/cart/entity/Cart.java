package com.bosssoft.cart.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

/**
 * @author 张东海
 * @date 2020/7/9
 * @description 购物车实体类
 */
@Getter
@Setter
public class Cart {
    private Integer id;
    private HashMap<Integer,Good> goods;

    public Cart() {
        this.goods = new HashMap<>();
    }
}
