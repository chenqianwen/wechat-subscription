package com.wechat.service.model;

import com.wechat.service.entity.WechatUser;
import lombok.Data;

/**
 * @author： ygl
 * @date： 2018/07/29
 * @Description：
 */
@Data
public class WechatUserInfo extends WechatUser {
    /**
     * 用户积分表ID
     */
    private String userIntegralId;
    /**
     * 用户积分
     */
    private String integral;
}
