package com.wechat.service.service;

/**
 * @author： ygl
 * @date： 2018/07/28
 * @Description：
 * 审计的接口
 */
public interface AuditorService {

    /**
     * 获取当前用户
     * @return
     */
    String getCurrentAuditor();
}
