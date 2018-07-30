package com.wechat.subscription.service;

/**
 * @author： ygl
 * @date： 2018/07/28
 * @Description：
 * 用户管理接口
 */
public interface UserService {

    /**
     * 获取用户信息
     * @param openId
     * @return
     */
    String getUserInfo(String openId);
}
