package com.tws.springbootdemo.controller;

import com.tws.springbootdemo.common.CommonResult;
import com.tws.springbootdemo.dto.UserLoginParam;
import com.tws.springbootdemo.entity.User;
import com.tws.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author taoweishu
 * @date 2021/10/29 - 22:07
 */
@RestController
public class LoginRegController {
    @Resource
    UserService userService;
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @RequestMapping("/doLogin")
    public CommonResult login(@RequestBody UserLoginParam userLoginParam) {
        String token = userService.login(userLoginParam.getUsername(),userLoginParam.getPassword());
        if(token == null) {
            return CommonResult.validateFailed("用户名或密码错误");
        }
        Map<String,String> tokenMap = new HashMap<>();
        tokenMap.put("token",token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }
    @RequestMapping("/register")
    public CommonResult register(User user) {
        int result = userService.register(user);
        if(result == 1) {
            return CommonResult.success(null,"注册成功");
        } else {
            return CommonResult.failed("用户名重复");
        }
    }

}
