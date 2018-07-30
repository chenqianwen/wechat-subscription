package com.wechat.subscription.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author： ygl
 * @date： 2018/07/23
 * @Description：
 */
@Component
public class BeanConfig {

    @Bean
    private RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
