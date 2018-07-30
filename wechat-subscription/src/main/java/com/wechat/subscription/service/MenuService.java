package com.wechat.subscription.service;

import com.alibaba.fastjson.JSONObject;

/**
 * @author： ygl
 * @date： 2018/07/27
 * @Description：
 * 公众号菜单的操作
 */
public interface MenuService {

    /**
     * 创建菜单
     * @param json 菜单的数据
     * @return
     */
    JSONObject createMenu(JSONObject json);
}
