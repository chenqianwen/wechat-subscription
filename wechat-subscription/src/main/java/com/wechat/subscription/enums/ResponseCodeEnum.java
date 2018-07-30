package com.wechat.subscription.enums;

import lombok.Getter;
import lombok.Setter;

/**
 * @author： ygl
 * @date： 2018/07/28
 * @Description：
 */
public enum  ResponseCodeEnum {
    OK(0);

    @Setter
    @Getter
    private Integer errcode;

    ResponseCodeEnum(Integer errcode) {
        this.errcode = errcode;
    }
}
