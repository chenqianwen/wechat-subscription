package com.wechat.subscription.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.wechat.subscription.service.AccessTokenService;
import com.wechat.subscription.service.MessageService;
import com.wechat.subscription.utils.UrlBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author： ygl
 * @date： 2018/07/28
 * @Description：
 */
@Slf4j
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AccessTokenService accessTokenService;

    @Override
    public String sendTextMessage(String openId,String content) {
        String url = UrlBuilder.buildMessageTextUrl(accessTokenService.getAccessToken());
        Map<String,Object> map = new HashMap<>();
        map.put("touser",openId);
        map.put("msgtype","text");
        Map<String,Object> contentMap = new HashMap<>();
        contentMap.put("content",content);
        map.put("text",contentMap);
        log.info("发送的文本消息为："+JSONObject.toJSONString(map));
        ResponseEntity<String> entity = restTemplate.postForEntity(url,map,String.class);
        String body = entity.getBody();
        log.info("发送文本消息的结果:" + body);
        return body;
    }
}
