package com.tws.springbootdemo.controller;

import cn.hutool.core.lang.UUID;
import com.tws.springbootdemo.common.CommonResult;
import com.tws.springbootdemo.common.Constants;
import com.tws.springbootdemo.service.RedisService;
import com.wf.captcha.ArithmeticCaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author taoweishu
 * @date 2021/11/15 - 14:52
 */
@RestController
public class CaptchaCodeController {
    @Autowired
    RedisService redisService;
    @RequestMapping("/getCode")
    public CommonResult getCode() {
        String uuid = UUID.randomUUID().toString();
        ArithmeticCaptcha captcha = new ArithmeticCaptcha(130, 48);
        String capStr = captcha.getArithmeticString();
        String code = captcha.text();
        String verifyKey = Constants.CAPTCHA_CODE_KEY + uuid;
        redisService.set(verifyKey,code,30, TimeUnit.MINUTES);
        HashMap<String,Object> data = new HashMap();
        data.put("uuid",uuid);
        data.put("image", captcha.toBase64());
        return CommonResult.success(data);
    }
}
