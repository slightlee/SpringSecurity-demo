package com.morrow.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class BaseEntity implements Serializable {

    private Long id;

    private Long tenantId;


    private LocalDateTime createTime;

    private Long creator;

    private LocalDateTime updateTime;

    private Long operator;

    private Integer isDelete;

}
