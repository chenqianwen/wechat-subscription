package com.example.system.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

/**
 * @author： ygl
 * @date： 2018/07/29
 * @Description：
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "system")
public class SystemProperties {

    /**
     * 可以访跨域问的域名列表
     * 默认所有都可以访问
     */
    private List<String> allowedOrigin = Arrays.asList("*");
}
