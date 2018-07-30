package com.wechat.subscription.model;

/**
 * @author： ygl
 * @date： 2018/07/28
 * @Description：
 * 消息父类
 */
public class BaseMessage {
    private String ToUserName;//	开发者微信号
    private String FromUserName;//	发送方帐号（一个OpenID）
    private Long CreateTime;//	消息创建时间 （整型）
    private String MsgType;		//	消息类型

}
