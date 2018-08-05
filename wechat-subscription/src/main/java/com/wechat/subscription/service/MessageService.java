package com.wechat.subscription.service;

import java.util.Map;

/**
 * @author： ygl
 * @date： 2018/07/28
 * @Description：
 * 消息服务
 */
public interface MessageService {

    /**
     * 发送文本信息给用户
     * @param openId
     * @param content
     * @return
     */
    String sendTextMessage(String openId, String content);

    /**
     * 发送图文信息给用户
     * @param openId
     * @param params 参数集合
     * @return
     */
    String sendImageTextMessage(String openId, Map<String,String> params);
}
