package com.wechat.subscription.model;

import lombok.Data;

/**
 * @author： ygl
 * @date： 2018/07/28
 * @Description：
 */
@Data
public class EventClickModel extends EventModel {
    /**
     * 	事件KEY值，与自定义菜单接口中KEY值对应
     */
    private String EventKey;
}
