package com.bosssoft.cart.dto;

import com.bosssoft.cart.entity.Good;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author 张东海
 * @date 2020/7/9
 * @description 商品信息传输类，用于传输给前端表格进行数据呈现
 */
@Getter
public class GoodDTO {
    private List<Good> data;
    private Integer code;
    private String msg;
    private Integer count;

    public GoodDTO(List<Good> data,Integer count) {
        this.data = data;
        this.count = count;
        this.code = 0;
        this.msg = "";
    }
}
