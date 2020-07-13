package com.bosssoft.cart.dao;

import com.bosssoft.cart.entity.Good;
import tk.mybatis.mapper.common.Mapper;


public interface GoodMapper extends Mapper<Good> {
//    @Select("select * from good limit #{start},#{limit}")
//    List<Good> getGoodListByPage(Integer start,Integer limit);

}
