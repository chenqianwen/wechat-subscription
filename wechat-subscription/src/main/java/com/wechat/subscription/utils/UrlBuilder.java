package com.wechat.subscription.utils;

import com.wechat.subscription.constants.WechatApiUrl;
import com.wechat.subscription.properties.AppProperties;

/**
 * @author： ygl
 * @date： 2018/07/23
 * @Description：
 * 将微信提供的url进行参数替换
 */
public class UrlBuilder {

    /**
     * 获取access_token的url
     * @param appProperties
     * @return
     */
    public static String buildAccessTokenUrl(AppProperties appProperties) {
        String url = WechatApiUrl.ACCESS_TOKEN_URL.replace(WechatApiUrl.APP_ID, appProperties.getId());
        return url.replace(WechatApiUrl.APP_SECRET, appProperties.getSecret());
    }
    /**
     * 创建菜单的url
     * @param accessToken
     * @return
     */
    public static String buildMenuCreateUrl(String accessToken) {
        return WechatApiUrl.MENU_CREATE_URL.replace(WechatApiUrl.ACCESS_TOKEN, accessToken);
    }
    /**
     * 发送文本消息的url
     * @param accessToken
     * @return
     */
    public static String buildMessageTextUrl(String accessToken) {
        return WechatApiUrl.MESSAGE_TEXT_URL.replace(WechatApiUrl.ACCESS_TOKEN, accessToken);
    }
    /**
     * 获取用户信息的url
     * @param accessToken
     * @return
     */
    public static String buildUserInfoUrl(String accessToken,String openId) {
        String url = WechatApiUrl.USER_INFO_URL.replace(WechatApiUrl.ACCESS_TOKEN, accessToken);
        return url.replace(WechatApiUrl.OPEN_ID, openId);
    }
}
