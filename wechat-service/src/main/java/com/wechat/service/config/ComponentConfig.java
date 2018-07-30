package com.wechat.service.config;

import com.wechat.service.service.AuditorService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author： ygl
 * @date： 2018/07/28
 * @Description：
 */
@Component
public class ComponentConfig {

    @Bean
    @ConditionalOnMissingBean
    private AuditorService auditorService (){
        return new AuditorService() {
            @Override
            public String getCurrentAuditor() {
                return "wechat";
            }
        };
    }
}
