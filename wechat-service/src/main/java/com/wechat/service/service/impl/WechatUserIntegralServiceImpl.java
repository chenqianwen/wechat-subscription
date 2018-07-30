package com.wechat.service.service.impl;

import com.wechat.service.entity.WechatUserIntegral;
import com.wechat.service.mapper.WechatUserIntegralMapper;
import com.wechat.service.service.WechatUserIntegralService;
import com.wechat.service.support.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author： ygl
 * @date： 2018/07/29
 * @Description：
 */
@Service
public class WechatUserIntegralServiceImpl extends BaseServiceImpl<WechatUserIntegral> implements WechatUserIntegralService {

    @Autowired
    private WechatUserIntegralMapper wechatUserIntegralMapper;
}
