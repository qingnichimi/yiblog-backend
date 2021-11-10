package com.tws.springbootdemo.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author taoweishu
 * @date 2021/10/29 - 20:43
 */
@Data
public class Category {
    private Long id;
    private String cateName;
    private Date create_time;
}
