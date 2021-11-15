package com.tws.springbootdemo.service;

import com.tws.springbootdemo.common.CommonResult;
import com.tws.springbootdemo.entity.Permission;
import com.tws.springbootdemo.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author taoweishu
 * @date 2021/10/18 - 19:25
 */
public interface UserService {
    User getUserById(Long id);
    User loadUserByUsername(@Param("username") String username);
    List<Permission> getPermissionList(Long id);
    String login(String username, String password, String code, String uuid);
    CommonResult generateAuthCode(String telephone);

    CommonResult verifyAuthCode(String telephone, String authCode);

    int register(User user);

}
