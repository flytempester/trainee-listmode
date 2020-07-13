package com.bosssoft.cart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author 张东海
 * @date 2020/7/9
 * @description 页面controller，转发页面跳转
 */
@Controller
public class PageController {
    @GetMapping("/{page}")
    public String toPage(@PathVariable("page") String page)
    {
        return page;
    }

}
