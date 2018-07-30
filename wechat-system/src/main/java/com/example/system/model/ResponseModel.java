package com.example.system.model;

import com.wechat.system.enums.ResponseEnum;
import lombok.Data;

/**
 * @author： ygl
 * @date： 2018/07/29
 * @Description：
 * 返回数据
 */
@Data
public class ResponseModel {

    private Integer errcode;

    private String errmsg;

    private Object data;

    public ResponseModel() {
    }

    public ResponseModel(Integer errcode, String errmsg) {
        this.errcode = errcode;
        this.errmsg = errmsg;
    }

    public ResponseModel(Integer errcode, String errmsg, Object data) {
        this.errcode = errcode;
        this.errmsg = errmsg;
        this.data = data;
    }

    public static ResponseModel ok(){
        return new ResponseModel(ResponseEnum.OK.getCode(),ResponseEnum.OK.getMsg());
    }

    public static ResponseModel ok(Object data){
        return new ResponseModel(ResponseEnum.OK.getCode(),ResponseEnum.OK.getMsg(),data);
    }

    public static ResponseModel error() {
        return new ResponseModel(ResponseEnum.ERROR.getCode(),ResponseEnum.ERROR.getMsg());
    }
}
