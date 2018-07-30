package com.wechat.subscription.model;

import lombok.Data;

/**
 * @author： ygl
 * @date： 2018/07/28
 * @Description：
 * 事件
 */
@Data
public class EventModel {
    /**
     * 开发者微信号
     */
    private String ToUserName;
    /**
     * 发送方帐号（一个OpenID）
     */
    private String FromUserName;
    /**
     * 消息创建时间 （整型）
     */
    private Integer CreateTime;
    /**
     * 消息类型，event
     */
    private String MsgType;
    /**
     * 事件类型
     */
    private String Event;
}
