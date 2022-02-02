package com.tws.springbootdemo;


import com.tws.springbootdemo.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.MailMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import javax.annotation.Resource;


@SpringBootTest
class SpringbootdemoApplicationTests {
//    @Resource
//    UserService userService;
//    @Resource
//    RedisService redisService;
//    @Autowired
//    private JavaMailSender mailSender;
//    @Autowired
//    MailProperties mailProperties;
//    @Test
//    void contextLoads() {
////        List<Category> categoryList = categoryService.getAllCategory();
////        System.out.println(categoryList);
//    }
//    @Test
//    public void mailTest() {
//        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
//        simpleMailMessage.setFrom(mailProperties.getUsername());
//        simpleMailMessage.setTo("185608181@qq.com");
//        simpleMailMessage.setSubject("邮件测试");
//        simpleMailMessage.setText("邮件测试");
//        mailSender.send(simpleMailMessage);
//    }

}
