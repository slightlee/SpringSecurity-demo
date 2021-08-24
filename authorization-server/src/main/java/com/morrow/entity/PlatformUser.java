package com.morrow.entity;

import lombok.Data;

@Data
public class PlatformUser extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String account;

    private String password;

    private String nickname;

    private String realName;

    private String gender;

    private String email;

    private String mobile;

    private Integer status;

    private String avatar;

    private String comments;


}
