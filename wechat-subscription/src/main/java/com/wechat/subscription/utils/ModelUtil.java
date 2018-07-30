package com.wechat.subscription.utils;

import com.alibaba.fastjson.JSONObject;
import com.wechat.subscription.model.ResponseModel;

/**
 * @author： ygl
 * @date： 2018/07/28
 * @Description：
 * 返回对象
 */
public class ModelUtil {

    public static ResponseModel buildResponseModel(String text) {
        return JSONObject.parseObject(text, ResponseModel.class);
    }
}
