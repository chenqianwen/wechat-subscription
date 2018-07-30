package com.wechat.subscription.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.wechat.subscription.constants.RedisKey;
import com.wechat.subscription.model.AccessToken;
import com.wechat.subscription.properties.AppProperties;
import com.wechat.subscription.service.AccessTokenService;
import com.wechat.subscription.utils.UrlBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @author： ygl
 * @date： 2018/07/23
 * @Description：
 */
@Slf4j
@Service
public class AccessTokenServiceImpl implements AccessTokenService {

    @Autowired
    private AppProperties appProperties;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void saveAccessToken(AccessToken accessToken) {
        ValueOperations<String, Object> valueOperate = redisTemplate.opsForValue();
        // 保存token
        String token = accessToken.getAccess_token();
        // token过期时间
        long expiresIn = accessToken.getExpires_in();
        valueOperate.set("access_token", token, expiresIn, TimeUnit.SECONDS);
    }

    @Override
    public String getAccessToken() {
        // 1.从本地中获取token
        String accessToken = getAccessTokenFromLocal();
        // 2.如果本地没有，就直接获取
        if (StringUtils.isEmpty(accessToken)) {
            AccessToken accessTokenFromServer = getAccessTokenFromServer();
            if (accessTokenFromServer != null && !StringUtils.isEmpty(accessTokenFromServer.getAccess_token())) {
                // 保存到redis中
                saveAccessToken(accessTokenFromServer);
                return accessTokenFromServer.getAccess_token();
            }
        }
        return accessToken;
    }

    @Override
    public AccessToken getAccessTokenFromServer() {
        String url = UrlBuilder.buildAccessTokenUrl(appProperties);
        ResponseEntity<String> entity = restTemplate.getForEntity(url, String.class);
        String body = entity.getBody();
        log.info("获取accessToken:" + body);
        AccessToken accessToken = JSONObject.parseObject(body, AccessToken.class);
        return accessToken;
    }

    @Override
    public String getAccessTokenFromLocal() {
        ValueOperations<String, Object> valueOperate = redisTemplate.opsForValue();
        Object access_token = valueOperate.get(RedisKey.ACCESS_TOKEN);
        if (access_token != null) {
            return access_token.toString();
        }
        return null;
    }


}
