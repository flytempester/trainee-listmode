package com.bosssoft.cart.service;

import com.bosssoft.cart.dao.GoodMapper;
import com.bosssoft.cart.dto.GoodDTO;
import com.bosssoft.cart.entity.Cart;
import com.bosssoft.cart.entity.Good;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * @author 张东海
 * @date 2020/7/9
 * @description 购物车相关功能服务
 */
@Service
public class CartService {
    @Resource
    private GoodMapper goodMapper;

    public GoodDTO getGoodList(Integer page,Integer limit){
        List<Good> allGoods = goodMapper.selectAll();
        Integer start = (page-1) * limit;
        Integer end = start + limit;
        if(end > allGoods.size()){
            end = allGoods.size();
        }
        List<Good> currentPageGoods = allGoods.subList(start, end);
        return new GoodDTO(currentPageGoods,allGoods.size());
    }

    public void addToCart(Integer gid, Integer num, HttpSession session) {
        Cart cart = (Cart)session.getAttribute("cart");
        if(cart == null)
        {
            cart = new Cart();
        }
        HashMap<Integer, Good> goods = cart.getGoods();
        Good good = goodMapper.selectByPrimaryKey(gid);
        if(goods.get(gid) != null) {
            Good oldGood = goods.get(gid);
            good.setNum(num + oldGood.getNum());
            goods.put(gid,good);
        }
        good.setNum(num);
        goods.putIfAbsent(gid,good);
        session.setAttribute("cart",cart);
    }

    public GoodDTO getCart(Integer page,Integer limit,HttpSession session) {
        Integer start = (page-1) * limit;
        Integer end = start + limit;
        Cart cart = (Cart)session.getAttribute("cart");
        HashMap<Integer, Good> goods = cart.getGoods();
        List<Good> goodList = new ArrayList<>(goods.values());
        if(end > goodList.size()){
            end = goodList.size();
        }
        return new GoodDTO(goodList.subList(start,end),goodList.size());
    }

    public void deleteGood(Integer id,HttpSession session) {
        Cart cart = (Cart)session.getAttribute("cart");
        HashMap<Integer, Good> goods = cart.getGoods();
        Good good = goods.get(id);
        good.setNum(null);
        goods.remove(id);
    }

    public void updateCart(Integer id, Integer num, HttpSession session) {
        Cart cart = (Cart)session.getAttribute("cart");
        HashMap<Integer, Good> goods = cart.getGoods();
        Good good = goods.get(id);
        good.setNum(num);
    }
}
