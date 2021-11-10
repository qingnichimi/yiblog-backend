package com.tws.springbootdemo.service;

import com.tws.springbootdemo.common.CommonResult;
import com.tws.springbootdemo.common.utils.JwtTokenUtil;
import com.tws.springbootdemo.entity.Permission;
import com.tws.springbootdemo.entity.User;
import com.tws.springbootdemo.mapper.UserMapper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.expression.spel.ast.NullLiteral;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author taoweishu
 * @date 2021/10/18 - 19:25
 */
@Service
public class UserServiceImpl implements UserService{
    @Resource
    private UserMapper userMapper;
    @Resource
    private RedisService redisService;
    @Resource
    private UserDetailsService userDetailsService;
    @Resource
    private PasswordEncoder passwordEncoder;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Resource
    private JwtTokenUtil jwtTokenUtil;
    @Override
    public User getUserById(Long id) {
        String userKey = "userKey:"+id;
        if(redisService.hasKey(userKey)) {
            System.out.println("redis存在");
            return (User)redisService.get(userKey);
        };
        User user = userMapper.getUserById(id);

        redisService.set(userKey,user);
        return user;
    }

    @Override
    public User loadUserByUsername(String username) {
        return userMapper.loadUserByUsername(username);
    }


    @Override
    public List<Permission> getPermissionList(Long id) {
        return new ArrayList<Permission>();
    }

    @Override
    public String login(String username, String password) {
        String token = null;
        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            if(!passwordEncoder.matches(password,userDetails.getPassword())) {
                throw new BadCredentialsException("密码不正确");
            }
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            token = jwtTokenUtil.generateToken(userDetails);
        }catch (AuthenticationException e) {
            e.printStackTrace();
        }
        return token;
    }

    @Override
    public CommonResult generateAuthCode(String telephone) {
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for(int i = 0; i < 6; i++) {
            sb.append(random.nextInt(10));
        }
        redisService.set("authCode:"+telephone, sb.toString());
        redisService.expire("authCode:"+telephone,120);
        return CommonResult.success(sb.toString(), "获取验证码成功");
    }

    @Override
    public CommonResult verifyAuthCode(String telephone, String authCode) {
        if (StringUtils.isEmpty(authCode)) {
            return CommonResult.failed("请输入验证码");
        }
        String realAuthCode = (String) redisService.get("authCode:"+telephone);
        boolean result = authCode.equals(realAuthCode);
        if (result) {
            return CommonResult.success(null, "验证码校验成功");
        } else {
            return CommonResult.failed("验证码不正确");
        }
    }

    @Override
    public int register(User user) {
        User loadUserByUsername = userMapper.loadUserByUsername(user.getUsername());
        if(loadUserByUsername != null) {
            return 0;
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(true);
        return userMapper.register(user);
    }
}
