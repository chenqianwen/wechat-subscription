package com.example.system.config;

import com.wechat.system.properties.SystemProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.util.CollectionUtils;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.List;

/**
 * @author： ygl
 * @date： 2018/07/29
 * @Description：
 * 跨域请求配置
 */
@Configuration
public class CorsConfig {


    @Autowired
    private SystemProperties systemProperties;

    @Order(0)
    @Bean
    public FilterRegistrationBean corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        // 设置你要允许的网站域名，如果全允许则设为 *
        List<String> allowedOrigin = systemProperties.getAllowedOrigin();
        if (!CollectionUtils.isEmpty(allowedOrigin)) {
            for (String url : allowedOrigin) {
                config.addAllowedOrigin(url);
            }
        }
        // 如果要限制 HEADER 或 METHOD 请自行更改
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
        return bean;
    }
}
