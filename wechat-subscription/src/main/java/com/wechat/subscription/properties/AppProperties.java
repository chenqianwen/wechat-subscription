package com.wechat.subscription.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author： ygl
 * @date： 2018/07/23
 * @Description：
 */
@Data
@Component
@ConfigurationProperties(prefix = "app")
public class AppProperties {
    /**
     * 公众号的ID
     */
    private String id;
    /**
     * 公众号的密钥
     */
    private String secret;
    /**
     * 开发配置的token
     */
    private String token;
}
