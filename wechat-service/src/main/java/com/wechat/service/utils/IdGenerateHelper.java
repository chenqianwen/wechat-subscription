package com.wechat.service.utils;

import java.security.SecureRandom;
import java.util.UUID;

/**
 * @author： ygl
 * @date： 2018/07/28
 * @Description：
 * ID生成工具
 */
public class IdGenerateHelper {
    private static SecureRandom random = new SecureRandom();
    private static SnowflakeIdWorker idWorker = new SnowflakeIdWorker(-1, -1);

    /**
     * 获取新唯一编号（18为数值）
     * 来自于twitter项目snowflake的id产生方案，全局唯一，时间有序。
     * 64位ID (42(毫秒)+5(机器ID)+5(业务编码)+12(重复累加))
     */
    public static String snowflakeId() {
        return String.valueOf(idWorker.nextId());
    }
    /**
     * 生成UUID, 中间无-分割.
     */
    public static String uuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 使用SecureRandom随机生成Long.
     */
    public static long randomLong() {
        return Math.abs(random.nextLong());
    }

    /**
     * 基于Base62编码的SecureRandom随机生成bytes.
     */
//    public static String randomBase62(int length) {
//        byte[] randomBytes = new byte[length];
//        random.nextBytes(randomBytes);
//        return EncodeUtils.encodeBase62(randomBytes);
//    }
}