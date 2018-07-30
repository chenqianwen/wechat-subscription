package com.wechat.system.controller;

import com.wechat.service.entity.WechatUser;
import com.wechat.service.entity.WechatUserIntegral;
import com.wechat.service.model.WechatUserInfo;
import com.wechat.service.service.WechatUserIntegralService;
import com.wechat.service.service.WechatUserService;
import com.wechat.service.support.PageModel;
import com.wechat.service.support.PageResultModel;
import com.wechat.system.model.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author： ygl
 * @date： 2018/07/29
 * @Description：
 */
@RequestMapping("/wechat/user")
@RestController
public class WechatUserController {

    @Autowired
    private WechatUserService wechatUserService;

    @Autowired
    private WechatUserIntegralService wechatUserIntegralService;

    /**
     * 分页查询
     * @param pageModel
     * @param params
     * @return
     */
    @PostMapping("/list")
    public ResponseModel list(PageModel pageModel,@RequestBody Map<String,Object> params){
        PageResultModel list = wechatUserService.listComplex(pageModel, params);
        return ResponseModel.ok(list);
    }

    /**
     * 修改积分
     * @param wechatUserInfo 微信用户信息
     * @return
     */
    @PostMapping("/integral/update")
    public ResponseModel updateIntegral(@RequestBody WechatUserInfo wechatUserInfo){
        // 用户积分表的ID
        String user_integral_id = wechatUserInfo.getUserIntegralId();
        WechatUserIntegral userIntegral = wechatUserIntegralService.findById(user_integral_id);
        // 积分表为空就新增
        if (userIntegral == null) {
            userIntegral =  new WechatUserIntegral();
            userIntegral.setUserId(wechatUserInfo.getId());
            userIntegral.setIntegral(wechatUserInfo.getIntegral());
            wechatUserIntegralService.insert(userIntegral);
        } else {
            // 积分
            String integral = wechatUserInfo.getIntegral();
            userIntegral.setIntegral(integral);
            wechatUserIntegralService.update(userIntegral);
        }
        return ResponseModel.ok();
    }

    /**
     * 逻辑删除
     * @param id 微信用户Id
     * @return
     */
    @GetMapping("/delete/{id}")
    public ResponseModel updateIntegral(@PathVariable String id){
        int row = wechatUserService.deleteLogicById(id);
        if (row > 0) {
            return ResponseModel.ok();
        }
        return ResponseModel.error();
    }
}
