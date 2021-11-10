package com.tws.springbootdemo;


import com.tws.springbootdemo.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


@SpringBootTest
class SpringbootdemoApplicationTests {
    @Resource
    UserService userService;
    @Resource
    RedisService redisService;

    @Test
    void contextLoads() {
//        List<Category> categoryList = categoryService.getAllCategory();
//        System.out.println(categoryList);
    }

}
