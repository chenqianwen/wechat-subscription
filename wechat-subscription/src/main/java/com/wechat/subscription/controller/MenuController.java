package com.wechat.subscription.controller;

import com.alibaba.fastjson.JSONObject;
import com.wechat.subscription.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author： ygl
 * @date： 2018/07/27
 * @Description：
 * 菜单的操作
 */
@RequestMapping("/wechat/menu")
@RestController
public class MenuController {

    @Autowired
    private MenuService menuService;

    @PostMapping("/create")
    public JSONObject createMenu(@RequestBody JSONObject data){
        return menuService.createMenu(data);
    }
}
