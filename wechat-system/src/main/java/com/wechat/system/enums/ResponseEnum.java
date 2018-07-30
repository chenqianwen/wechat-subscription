package com.wechat.system.enums;

import lombok.Getter;
import lombok.Setter;

/**
 * @author： ygl
 * @date： 2018/07/29
 * @Description：
 * 返回值
 */
public enum  ResponseEnum {

    OK(0,"ok"),ERROR(-1,"操作失败");

    @Getter
    @Setter
    private Integer code;
    @Getter
    @Setter
    private String msg;

    ResponseEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
