package com.wechat.service.entity;

import com.wechat.service.support.BaseEntity;
import lombok.Data;

/**
 * @author： ygl
 * @date： 2018/07/29
 * @Description：
 * 微信用的积分
 */
@Data
public class WechatUserIntegral extends BaseEntity {

    /**
     * 用户ID
     */
    private String userId;
    /**
     * 用户积分
     */
    private String integral;
}
