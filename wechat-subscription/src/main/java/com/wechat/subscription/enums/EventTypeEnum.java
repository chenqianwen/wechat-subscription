package com.wechat.subscription.enums;

import lombok.Getter;
import lombok.Setter;

/**
 * @author： ygl
 * @date： 2018/07/28
 * @Description：
 * 事件类型
 */
public enum EventTypeEnum {

    CLICK("CLICK","点击菜单"),SUBSCRIBE("subscribe","订阅"),UNSUBSCRIBE("unsubscribe","取消订阅");

    @Getter
    @Setter
    private String value;

    @Getter
    @Setter
    private String text;

    EventTypeEnum(String value, String text) {
        this.value = value;
        this.text = text;
    }
}
