package com.wechat.subscription.constants;

/**
 * @author： ygl
 * @date： 2018/07/23
 * @Description：
 * 微信接口的URL地址
 */
public class WechatApiUrl {
    /**
     * 所有的URL用到appid的，都需要将appid对应的参数值替换为APPID
     */
    public final static String APP_ID = "APPID";
    /**
     * 所有的URL用到appsecret的，都需要将appid对应的参数值替换为APPSECRET
     */
    public final static String APP_SECRET = "APPSECRET";
    /**
     * 所有的URL用到ACCESS_TOKEN的，都需要将ACCESS_TOKEN对应的参数值替换为ACCESS_TOKEN
     */
    public final static String ACCESS_TOKEN = "ACCESS_TOKEN";
    /**
     * 所有的URL用到OPENID的，都需要将OPENID对应的参数值替换为OPENID
     */
    public final static String OPEN_ID = "OPENID";
    /**
     * 获取access_token
     */
    public final static String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
    /**
     * 创建菜单
     */
    public final static String MENU_CREATE_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
    /**
     *  发送文本消息
     */
    public final static String MESSAGE_TEXT_URL = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=ACCESS_TOKEN";
    /**
     *  获得用户信息
     */
    public final static String USER_INFO_URL = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";

}
