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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    /**
     * 发送文本信息
     * @param openId
     * @param content
     * @return
     */
    @Override
    public String sendTextMessage(String openId,String content) {
        String url = UrlBuilder.buildCustomMessageUrl(accessTokenService.getAccessToken());
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

    /**
     * 发送图文信息
     * @param openId
     * @param params
     * @return
     */
    @Override
    public String sendImageTextMessage(String openId, Map<String,String> params) {
        // 图文的title参数
        String title = params.get("title");
        // 图文的description参数
        String description = params.get("description");
        // 图文的picurl参数
        String picurl = params.get("picurl");
        // 图文的url参数
        String weburl = params.get("url");
        String url = UrlBuilder.buildCustomMessageUrl(accessTokenService.getAccessToken());
        Map<String,Object> map = new HashMap<>();
        map.put("touser",openId);
        map.put("msgtype","news");
        List<Map<String,Object>> contentList = new ArrayList<>();
        Map<String,Object> contentMap = new HashMap<>();
        contentMap.put("title",title);
        contentMap.put("description",description);
        contentMap.put("url",weburl);
        contentMap.put("picurl",picurl);
        contentList.add(contentMap);
        Map<String,Object> articlesMap = new HashMap<>();
        articlesMap.put("articles",contentList);
        map.put("news",articlesMap);
        log.info("发送的图文消息为："+JSONObject.toJSONString(map));
        ResponseEntity<String> entity = restTemplate.postForEntity(url,map,String.class);
        String body = entity.getBody();
        log.info("发送消息的结果:" + body);
        return body;
    }
}
