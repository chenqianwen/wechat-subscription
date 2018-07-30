package com.wechat.service.service;

import com.wechat.service.entity.WechatUser;
import com.wechat.service.support.BaseService;
import com.wechat.service.support.PageModel;
import com.wechat.service.support.PageResultModel;

import java.util.Map;

/**
 * @author： ygl
 * @date： 2018/07/28
 * @Description：
 */
public interface WechatUserService extends BaseService<WechatUser> {

    /**
     * 通过openid查询微信用户
     * @param openid
     * @return
     */
    WechatUser findByOpenid(String openid);

    /**
     * 复杂的分页查询
     * @param pageModel
     * @param params 查询参数
     * @return
     */
    PageResultModel listComplex(PageModel pageModel, Map<String, Object> params);

}
