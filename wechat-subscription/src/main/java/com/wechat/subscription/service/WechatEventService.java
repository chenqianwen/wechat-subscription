package com.wechat.subscription.service;

import com.wechat.subscription.model.ResponseModel;

import java.util.Map;

/**
 * @author： ygl
 * @date： 2018/07/28
 * @Description：
 * 公众号的所有事件接口
 */
public interface WechatEventService {

    /**
     * 点击事件
     */
    ResponseModel click(Map<String, String> map);

    /**
     * 订阅事件
     */
    ResponseModel subscribe(Map<String, String> map);

    /**
     * 取消订阅事件
     * @param map
     * @return
     */
    void unsubscribe(Map<String, String> map);
}
