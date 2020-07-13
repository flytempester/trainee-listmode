package com.bosssoft.cart.controller;

import com.bosssoft.cart.dto.GoodDTO;
import com.bosssoft.cart.service.CartService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @author 张东海
 * @date 2020/7/9
 * @description 购物车controller，转发相关请求
 */
@RestController

public class CartController {

    @Resource
    private CartService cartService;

    @GetMapping("/getGoodList")
    public GoodDTO getGoodList(@RequestParam("page") Integer page,
                               @RequestParam("limit") Integer limit)
    {

        return cartService.getGoodList(page,limit);
    }

    @GetMapping("/addToCart")
    public void addToCart(@RequestParam(name = "id") Integer id,
                          @RequestParam(name = "num") Integer num,
                          HttpSession session)
    {
        cartService.addToCart(id,num,session);
    }

    @GetMapping("/getCart")
    public GoodDTO getGoodByCart(@RequestParam("page") Integer page,
                                 @RequestParam("limit") Integer limit,
                                 HttpSession session){
        return cartService.getCart(page,limit,session);
    }

    @DeleteMapping("/deleteGood")
    public void deleteGood(@RequestParam("id") Integer id,
                           HttpSession session)
    {
        cartService.deleteGood(id,session);
    }

    @GetMapping("/updateCart")
    public void updateCart(@RequestParam("id") Integer id,
                           @RequestParam("num") Integer num,
                           HttpSession session)
    {
        cartService.updateCart(id,num,session);
    }

    @PutMapping("/submitOrder")
    public void submitOrder(HttpSession session)
    {
        cartService.submitOrder(session);
    }

}
