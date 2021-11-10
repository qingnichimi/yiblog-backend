package com.tws.springbootdemo.controller;

import com.tws.springbootdemo.common.CommonResult;
import com.tws.springbootdemo.dto.UserLoginParam;
import com.tws.springbootdemo.entity.User;
import com.tws.springbootdemo.service.UserService;
import org.apache.ibatis.parsing.TokenHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author taoweishu
 * @date 2021/10/18 - 18:37
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @RequestMapping("/select")
    @ResponseBody
    public void select(Long id) {
        User user = userService.getUserById(id);
        System.out.println(user);
    }

}
