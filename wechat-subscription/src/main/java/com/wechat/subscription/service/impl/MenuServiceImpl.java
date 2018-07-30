package com.wechat.subscription.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.wechat.subscription.service.AccessTokenService;
import com.wechat.subscription.service.MenuService;
import com.wechat.subscription.utils.UrlBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author： ygl
 * @date： 2018/07/27
 * @Description：
 */
@Slf4j
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private AccessTokenService accessTokenService;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public JSONObject createMenu(JSONObject json) {
        String url = UrlBuilder.buildMenuCreateUrl(accessTokenService.getAccessToken());
        ResponseEntity<String> entity = restTemplate.postForEntity(url,json,String.class);
        String body = entity.getBody();
        log.info("创建菜单:" + body);
        return JSONObject.parseObject(body);
    }
}
