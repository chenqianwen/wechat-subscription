package com.wechat.service.support;

import lombok.Data;

import java.util.List;

/**
 * @author： ygl
 * @date： 2018/07/28
 * @Description：
 * 分页结果的模型
 */
@Data
public class PageResultModel{

    /**
     * 总条目数
     */
    private long total;
    /**
     * 数据集合
     */
    private List list;

    public PageResultModel(long total, List list) {
        this.total = total;
        this.list = list;
    }
}
