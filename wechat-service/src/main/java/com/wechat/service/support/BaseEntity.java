package com.wechat.service.support;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * @author： ygl
 * @date： 2018/07/28
 * @Description：
 */
@Data
public class BaseEntity implements Serializable {

    @Id
    @Column(name = "id")
    private String id;

    private Date createdDate;

    private String createdBy;

    private Date updatedDate;

    private String updatedBy;

    private Integer deleted = 0;
}
