package com.tws.springbootdemo.dto;

import lombok.Data;

/**
 * @author taoweishu
 * @date 2021/10/25 - 17:28
 */
@Data
public class UserLoginParam {
    private String username;
    private String password;
    private String code;
    private String uuid = "";
}
