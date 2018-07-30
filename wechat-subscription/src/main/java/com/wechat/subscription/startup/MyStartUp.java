package com.wechat.subscription.startup;

import com.wechat.subscription.service.AccessTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author： ygl
 * @date： 2018/07/23
 * @Description：
 * 项目启动后执行
 */
@Component
public class MyStartUp implements ApplicationRunner {

    @Autowired
    private AccessTokenService accessTokenService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        accessTokenService.getAccessToken();
    }
}
