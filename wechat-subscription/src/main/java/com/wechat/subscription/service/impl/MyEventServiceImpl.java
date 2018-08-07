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

import java.util.HashMap;
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
        if (eventKey.equals("btn_points"+"sss")) {
            String result = messageService.sendTextMessage(openId, "杨国梁爱着贾春恒");
            ResponseModel responseModel = ModelUtil.buildResponseModel(result);
            return responseModel;
        } else if(eventKey.equals("btn_egg")){
            Map<String,String> params = new HashMap<>();
            params.put("title","砸金蛋活动开始了");
            params.put("description","请点击砸金蛋活动页面，祝您好运哦！");
            params.put("picurl","http://106.14.13.93:8888/group1/M00/00/00/rBMUlltmeN-AbvudAAO_SUhoG9c71.jpeg");
            String url1 = "http://132.232.32.251:8080/#/egg";
            String url = "http%3a%2f%2fws.58808706.com%2f%23%2fegg";
            String url2 = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx0eb40039d6835802&redirect_uri="+url+"&response_type=code&scope=snsapi_base#wechat_redirect";
            params.put("url",url2);
            String result = messageService.sendImageTextMessage(openId, params);
            ResponseModel responseModel = ModelUtil.buildResponseModel(result);
            return responseModel;
        } else  if (eventKey.equals("btn_points")) {
            openId = "oe3zj1Eh2UMgl6DUmDTrpbsfzriI";
            Map<String,Object> params = new HashMap<>();
            params.put("template_id","Lz5R78GH2Ep7dOjtyQjuRnhdzbhsUi7Qd2DQZxVs_V0");
            Map<String,Map<String,String>> dataMap = new HashMap<>();
            Map<String,String> value1 = new HashMap<>();
            value1.put("value","您的患者已到店");
            dataMap.put("first",value1);
            Map<String,String> value2 = new HashMap<>();
            value2.put("value","南京展超丽格");
            dataMap.put("keyword1",value2);
            Map<String,String> value3 = new HashMap<>();
            value3.put("value","2018-08-08 12：00");
            dataMap.put("keyword2",value3);
            Map<String,String> value4 = new HashMap<>();
            value4.put("value","预约项目---");
            dataMap.put("keyword3",value4);
            Map<String,String> value5 = new HashMap<>();
            value5.put("value","预约备注的内容显示在这里。。。");
            dataMap.put("remark",value5);
            params.put("data",dataMap);
            String result = messageService.sendTemplateMessage(openId, params);
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
