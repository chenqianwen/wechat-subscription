package com.wechat.service.service.impl;

import com.wechat.service.entity.WechatUser;
import com.wechat.service.mapper.WechatUserMapper;
import com.wechat.service.model.WechatUserInfo;
import com.wechat.service.service.WechatUserService;
import com.wechat.service.support.BaseServiceImpl;
import com.wechat.service.support.PageModel;
import com.wechat.service.support.PageResultModel;
import com.wechat.service.support.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author： ygl
 * @date： 2018/07/28
 * @Description：
 */
@Service
public class WechatUserServiceImpl extends BaseServiceImpl<WechatUser> implements WechatUserService {

    @Autowired
    private WechatUserMapper wechatUserMapper;

    @Override
    public PageResultModel listComplex(PageModel pageModel, Map<String, Object> params) {
        PageUtil<WechatUserInfo> pageUtil = new PageUtil<>(pageModel);
        List<WechatUserInfo> dataList = wechatUserMapper.listComplex(params);
        return pageUtil.listPage(dataList);
    }


    @Override
    public WechatUser findByOpenid(String openid) {
        return wechatUserMapper.findByOpenid(openid);
    }
}
