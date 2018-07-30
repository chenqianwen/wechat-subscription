package com.wechat.subscription.model;

import lombok.Data;

/**
 * @author： ygl
 * @date： 2018/07/28
 * @Description：
 * 微信返回的数据模型
 */
@Data
public class ResponseModel {
    /**
     * 返回码：正确：0
     */
    private Integer errcode;
    /**
     * 返回值：正确：ok
     */
    private String errmsg;
}
