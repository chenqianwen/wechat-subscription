package com.wechat.service.config;

import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author： ygl
 * @date： 2018/07/28
 * @Description：
 */
@Configuration
@MapperScan(basePackages = MybatisConfig.basePackages)
public class MybatisConfig {

    /**
     * mapper 包路径
     */
    public final static String basePackages = "com.wechat.service.mapper";
}