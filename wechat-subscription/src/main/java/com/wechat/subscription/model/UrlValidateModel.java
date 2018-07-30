package com.wechat.subscription.model;

import lombok.Data;

/**
 * @author： ygl
 * @date： 2018/07/27
 * @Description：
 * 配置服务器url，对token进行验证
 */
@Data
public class UrlValidateModel {
    /**
     * 微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
     */
    private String signature;
    /**
     * 时间戳
     */
    private String timestamp;
    /**
     * 随机数
     */
    private String nonce;
    /**
     * 随机字符串
     */
    private String echostr;
}
