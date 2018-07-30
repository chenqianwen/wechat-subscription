package com.wechat.subscription.service;

/**
 * @author： ygl
 * @date： 2018/07/28
 * @Description：
 * 消息服务
 */
public interface MessageService {

    String sendTextMessage(String openId, String content);
}
