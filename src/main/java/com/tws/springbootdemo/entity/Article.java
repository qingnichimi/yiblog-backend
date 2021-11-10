package com.tws.springbootdemo.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author taoweishu
 * @date 2021/10/29 - 20:38
 */
@Data
public class Article implements Serializable {
    private Long id;
    private String title;
    private String mdContent;
    private String htmlContent;
    private String summary;
    private Long cid;
    private String catename;
    private  Long uid;
    private Integer state;
    private Date publish_time;
    private String[] dynamicTags;
    private String nickname;
    private String cateName;
    private List<Tags> tags;
    private String stateStr;
}
