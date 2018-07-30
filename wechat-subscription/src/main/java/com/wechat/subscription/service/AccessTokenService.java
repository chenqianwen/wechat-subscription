package com.wechat.subscription.service;

import com.wechat.subscription.model.AccessToken;

/**
 * @author： ygl
 * @date： 2018/07/23
 * @Description：
 * access_token的借口
 */
public interface AccessTokenService {

    /**
     * 保存token到本地
     * @return
     */
    void saveAccessToken(AccessToken accessToken);
    /**
     * 获取token
     * @return
     */
    String getAccessToken();
    /**
     * 从服务器获取token，错误返回null
     * @return
     */
    AccessToken getAccessTokenFromServer();
    /**
     * 从本地查询token，错误返回null
     * @return
     */
    String getAccessTokenFromLocal();

}
