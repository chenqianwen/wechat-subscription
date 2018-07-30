package com.wechat.subscription.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;

/**
 * @author： ygl
 * @date： 2018/07/28
 * @Description：
 * 编码转换
 */
@Slf4j
public class CodeConverter {

    public static String iso2Utf8(String text){
        try {
            return new String(text.getBytes("ISO-8859-1"),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            log.info("编码转换出错："+e.getMessage());
            return null;
        }
    }
}
