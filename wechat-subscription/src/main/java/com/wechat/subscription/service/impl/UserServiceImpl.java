package com.wechat.subscription.service.impl;

import com.wechat.subscription.service.AccessTokenService;
import com.wechat.subscription.service.UserService;
import com.wechat.subscription.utils.CodeConverter;
import com.wechat.subscription.utils.UrlBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author： ygl
 * @date： 2018/07/28
 * @Description：
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private AccessTokenService accessTokenService;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public String getUserInfo(String openId) {
        String url = UrlBuilder.buildUserInfoUrl(accessTokenService.getAccessToken(), openId);
        ResponseEntity<String> entity = restTemplate.getForEntity(url,String.class);
        String body = CodeConverter.iso2Utf8(entity.getBody());
        log.info("获取用户信息的结果:" + body);
        return body;
    }
}
