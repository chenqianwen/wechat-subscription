package com.wechat.subscription.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.wechat.service.entity.WechatUser;
import com.wechat.service.service.WechatUserService;
import com.wechat.subscription.model.ResponseModel;
import com.wechat.subscription.service.MessageService;
import com.wechat.subscription.service.UserService;
import com.wechat.subscription.service.WechatEventService;
import com.wechat.subscription.utils.ModelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * @author： ygl
 * @date： 2018/07/28
 * @Description：
 * 我的点击事件，自己的事件逻辑
 */
@Service
public class MyEventServiceImpl implements WechatEventService {

    @Autowired
    private MessageService messageService;

    @Autowired
    private UserService userService;

    @Autowired
    private WechatUserService wechatUserService;

    /**
     * 用户点击菜单
     * @param map
     * @return
     */
    @Override
    public ResponseModel click(Map<String, String> map) {
        String openId = map.get("FromUserName");
        String eventKey = map.get("EventKey");
        if (eventKey.equals("btn_points")) {
            String result = messageService.sendTextMessage(openId, "杨国梁爱着贾春恒");
            ResponseModel responseModel = ModelUtil.buildResponseModel(result);
            return responseModel;
        }
        return null;
    }

    /**
     * 用户订阅
     * @param map
     * @return
     */
    @Override
    public ResponseModel subscribe(Map<String, String> map) {
        String openId = map.get("FromUserName");
        String result = userService.getUserInfo(openId);
        // 获得的结果转成实体:
        if (!StringUtils.isEmpty(result)) {
            WechatUser wechatUser = JSONObject.parseObject(result, WechatUser.class);
            WechatUser user = wechatUserService.findByOpenid(openId);
            if (user == null) {
                wechatUserService.insert(wechatUser);
                // 初始化用户的积分表
            } else {
                Integer subscribe = user.getSubscribe();
                // 如果没有订阅的话，变成订阅
                if (subscribe.equals(0)) {
                    user.setSubscribe(1);
                    wechatUserService.update(user);
                }
            }
        }
        ResponseModel responseModel = ModelUtil.buildResponseModel(result);
        return responseModel;
    }

    /**
     * 取消订阅
     * @param map
     * @return
     */
    @Override
    public void unsubscribe(Map<String, String> map) {
        String openId = map.get("FromUserName");
        if (!StringUtils.isEmpty(openId)) {
            WechatUser user = wechatUserService.findByOpenid(openId);
            if (user != null) {
                user.setSubscribe(0);
                wechatUserService.update(user);
            }
        }
    }
}
