package com.tws.springbootdemo.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author taoweishu
 * @date 2021/10/18 - 17:58
 */
@Data
public class User {
    private Long id;
    private String username;
    private String password;
    private String nickname;
    private boolean enabled;
    private String email;
    private Date create_time;
}
