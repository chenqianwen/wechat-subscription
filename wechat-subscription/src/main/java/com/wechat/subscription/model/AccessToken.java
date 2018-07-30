package com.wechat.subscription.model;

import lombok.Data;

/**
 * @author： ygl
 * @date： 2018/07/23
 * @Description：
 * token的模型
 */
@Data
public class AccessToken {
    /**
     * 凭证
     */
    private String access_token;
    /**
     * 有效时间，单位：秒
     */
    private int expires_in;
}
