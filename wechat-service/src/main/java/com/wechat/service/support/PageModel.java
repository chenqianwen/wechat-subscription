package com.wechat.service.support;

import lombok.Data;

/**
 * @author： ygl
 * @date： 2018/07/28
 * @Description：
 * 查询分页数据时需要传入的参数模型
 */
@Data
public class PageModel {
    /**
     * 每页显示条目个数
     * 默认每页展示10条
     */
    private Integer pageSize = 10;
    /**
     * 当前页数
     * 默认展示第一页
     */
    private Integer currentPage = 1;
    /**
     * 排序字段
     */
    private String sort;
    /**
     * 排序方向
     */
    private String order;
}
