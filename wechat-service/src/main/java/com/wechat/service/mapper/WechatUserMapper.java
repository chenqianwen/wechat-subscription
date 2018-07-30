package com.wechat.service.mapper;

import com.wechat.service.entity.WechatUser;
import com.wechat.service.model.WechatUserInfo;
import com.wechat.service.support.BaseMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @author： ygl
 * @date： 2018/07/28
 * @Description：
 */
public interface WechatUserMapper extends BaseMapper<WechatUser>{

    /**
     * 列表查询数据
     * @return
     */
    @Select("select * from wechat_user")
    @Results({
            @Result(property = "subscribe_time", column = "subscribe_time"),
            @Result(property = "tagid_list", column = "tagid_list"),
            @Result(property = "subscribe_scene", column = "subscribe_scene"),
    })
    List<WechatUser> list(Map<String, Object> params);

    /**
     * 复杂的分页查询
     * @param params
     * @return
     */
    @Select("<script>select u.*,i.integral,i.id as user_integral_id from wechat_user u left join wechat_user_integral i " +
            "on u.id = i.user_id and i.deleted = 0 where u.deleted=0 "+
            "<when test='nickname!=null'> and nickname = #{nickname} </when>" +
            "</script>")
    @Results({
            @Result(property = "subscribe_time", column = "subscribe_time"),
            @Result(property = "tagid_list", column = "tagid_list"),
            @Result(property = "subscribe_scene", column = "subscribe_scene"),
    })
    List<WechatUserInfo> listComplex(Map<String, Object> params);

    /**
     * 通过openid查询微信用户
     * @param openid
     * @return
     */
    @Select("<script>select * from wechat_user where deleted=0 " +
            "<when test='openid!=null'> and openid = #{openid} </when>" +
            "</script>")
    WechatUser findByOpenid(@Param("openid") String openid);


}
