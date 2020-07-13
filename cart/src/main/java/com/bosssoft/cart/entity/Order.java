package com.bosssoft.cart.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author 张东海
 * @date 2020/7/13
 * @description 订单类order，用于商品订单的最终提交
 */
@Data
@Table(name = "my_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private Integer cartId;
    @Column
    private Integer goodId;
    @Column
    private Integer num;
}
