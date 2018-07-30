package com.wechat.service.support;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author： ygl
 * @date： 2018/07/29
 * @Description：
 */
public class PageUtil<T> {

    public PageUtil(PageModel pageModel) {
        String order = pageModel.getOrder();
        Integer currentPage = pageModel.getCurrentPage();
        Integer pageSize = pageModel.getPageSize();
        String sort = pageModel.getSort();
        if (StringUtils.isEmpty(order)) {
            PageHelper.startPage(currentPage,pageSize);
        } else {
            PageHelper.startPage(currentPage,pageSize,order+" "+sort);
        }
    }

    public PageResultModel listPage(List<T> dataList) {
        PageInfo<T> pageInfo = new PageInfo<>(dataList);
        long total = pageInfo.getTotal();
        List<T> list = pageInfo.getList();
        return new PageResultModel(total,list);
    }
}
