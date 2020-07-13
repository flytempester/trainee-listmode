package com.bosssoft.cart.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * @author 张东海
 * @date 2020/7/9
 * @description 商品实体类
 */
@Data
public class Good {
    @Id
    private Integer id;
    @Column
    private String name;
    @Column
    private Double price;
    @Transient
    private Integer num;
}
