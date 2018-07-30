package com.wechat.service.support;

import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;
import java.util.Map;

/**
 * @author： ygl
 * @date： 2018/07/28
 * @Description：
 */
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T>, IdsMapper<T> {

    /**
     * 分页查询的接口
     * @param params
     * @return
     */
    List<T> list(Map<String, Object> params);
}