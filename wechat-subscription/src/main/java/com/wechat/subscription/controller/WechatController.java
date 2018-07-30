package com.wechat.subscription.controller;

import com.alibaba.fastjson.JSONObject;
import com.wechat.subscription.enums.EventTypeEnum;
import com.wechat.subscription.enums.ResponseCodeEnum;
import com.wechat.subscription.model.ResponseModel;
import com.wechat.subscription.model.UrlValidateModel;
import com.wechat.subscription.properties.AppProperties;
import com.wechat.subscription.service.WechatEventService;
import com.wechat.subscription.utils.CheckUtil;
import com.wechat.subscription.utils.XmlUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;

/**
 * @author： ygl
 * @date： 2018/07/27
 * @Description：
 * 微信接入
 */
@Slf4j
@RequestMapping("/wechat")
@RestController
public class WechatController {

    @Autowired
    private AppProperties appProperties;

    @Autowired
    private WechatEventService WechatEventService;

    /**
     * 验证
     * @param model
     * @param resp
     */
    @GetMapping
    public void wehcatAccess(UrlValidateModel model, HttpServletResponse resp){
        String token = appProperties.getToken();
		String signature =  model.getSignature();
		String timestamp = model.getTimestamp();
        String nonce = model.getNonce();
        String echostr = model.getEchostr();
		String[] arr = new String[]{token,timestamp,nonce};
		Arrays.sort(arr);
		String goals = "";
		for(int i =0 ;i <arr.length ;i++){
			goals += arr[i];
		}
        try {
            PrintWriter writer = resp.getWriter();
            if(signature.equals(CheckUtil.getBySha1(goals))){
                log.info("认证token成功－－－－－－－－－－－－－－");
                writer.print(echostr);
            }
        } catch (IOException e) {
            log.info("认证token失败－－－－－－－－－－－－－"+e.getMessage());
        }
    }

    /**
     * 用户事件：
     * @param req
     * @param resp
     */
    @PostMapping
    public void wechatEvent(HttpServletRequest req, HttpServletResponse resp){
        // 请求的数据转成map
        Map<String, String> dataMap = null;
        try {
            dataMap = XmlUtil.parseXml(req);
            log.info("解析用户事件得到的数据："+JSONObject.toJSONString(dataMap));
        } catch (Exception e) {
            log.info("解析用户事件出错："+e.getMessage());
        }
        // 返回数据：
        ResponseModel responseModel = null;
        // 事件类型
        String eventType = dataMap.get("Event");
        // 点击事件
        if (EventTypeEnum.CLICK.getValue().equals(eventType)) {
            responseModel = WechatEventService.click(dataMap);
        // 订阅事件
        } else if (EventTypeEnum.SUBSCRIBE.getValue().equals(eventType)) {
            responseModel = WechatEventService.subscribe(dataMap);
        // 订阅事件
        } else if (EventTypeEnum.UNSUBSCRIBE.getValue().equals(eventType)) {
             WechatEventService.unsubscribe(dataMap);
        }
        log.info("响应用户事件的返回数据："+JSONObject.toJSONString(responseModel));
        try {
            if (responseModel != null) {
                PrintWriter writer = resp.getWriter();
                Integer errcode = responseModel.getErrcode();
                if (ResponseCodeEnum.OK.getErrcode().equals(errcode)) {
                    writer.print("success");
                }
            }
        } catch (IOException e) {
            log.info("事件处理失败－－－－－－－－－－－－－"+e.getMessage());
        }
    }
}
