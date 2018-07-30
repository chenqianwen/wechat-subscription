package com.wechat.service.support;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wechat.service.service.AuditorService;
import com.wechat.service.utils.IdGenerateHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author： ygl
 * @date： 2018/07/28
 * @Description：
 */
public class BaseServiceImpl<T extends BaseEntity> implements BaseService<T> {

    @Autowired
    private AuditorService auditorService;

    @Autowired
    private BaseMapper<T> baseMapper;

    @Override
    public void pageable(PageModel pageModel) {
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

    @Override
    public  PageResultModel list(PageModel pageModel, Map<String,Object> params) {
        pageable(pageModel);
        List<T> dataList = baseMapper.list(params);
        PageInfo<T> pageInfo = new PageInfo<>(dataList);
        long total = pageInfo.getTotal();
        List<T> list = pageInfo.getList();
        return new PageResultModel(total,list);
    }

    @Override
    public int insert(T t) {
        if (StringUtils.isEmpty(t.getId())) {
            t.setId(IdGenerateHelper.snowflakeId());
        }
        t.setCreatedBy(auditorService.getCurrentAuditor());
        t.setCreatedDate(new Date());
        t.setUpdatedBy(auditorService.getCurrentAuditor());
        t.setUpdatedDate(new Date(System.currentTimeMillis()));
        return baseMapper.insertSelective(t);
    }

    @Override
    public int insertList(List<T> list) {
        for (T t : list) {
            if (StringUtils.isEmpty(t.getId())) {
                t.setId(IdGenerateHelper.snowflakeId());
            }
            t.setCreatedBy(auditorService.getCurrentAuditor());
            t.setCreatedDate(new Timestamp(System.currentTimeMillis()));
            t.setUpdatedBy(auditorService.getCurrentAuditor());
            t.setUpdatedDate(new Timestamp(System.currentTimeMillis()));
        }
        return baseMapper.insertList(list);
    }

    @Override
    public int delete(T t) {
        return baseMapper.delete(t);
    }

    @Override
    public int deleteById(String id) {
        return baseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteLogicById(String id) {
        T t = findById(id);
        if (t != null) {
            t.setDeleted(1);
            return update(t);
        }
        return 0;
    }

    @Override
    public int update(T t) {
        t.setUpdatedBy(auditorService.getCurrentAuditor());
        t.setUpdatedDate(new Timestamp(System.currentTimeMillis()));
        return baseMapper.updateByPrimaryKeySelective(t);
    }

    @Override
    public int updateList(List<T> list) {
        int rows = 0;
        for (T t : list) {
            t.setUpdatedBy(auditorService.getCurrentAuditor());
            t.setUpdatedDate(new Timestamp(System.currentTimeMillis()));
            rows += update(t);
        }
        return rows;
    }

    @Override
    public T findById(String id) {
        return baseMapper.selectByPrimaryKey(id);
    }


    @Override
    public List<T> findByIds(String ids) {
        return baseMapper.selectByIds(ids);
    }

    @Override
    public List<T> findByIdArray(String[] idArray) {
        String ids = StringUtils.arrayToDelimitedString(idArray, ",");
        return findByIds(ids);
    }

    @Override
    public List<T> findByIdList(List<String> idList) {
        String ids = StringUtils.collectionToDelimitedString(idList, ",");
        return findByIds(ids);
    }
}