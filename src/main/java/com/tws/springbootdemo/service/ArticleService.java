package com.tws.springbootdemo.service;

import com.github.pagehelper.PageInfo;
import com.tws.springbootdemo.entity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author taoweishu
 * @date 2021/10/29 - 22:51
 */
public interface ArticleService {
    int addNewArticle(Article article);

    int updateArticle(Article article);

    Article getArticleById(Long aid);

    int deleteArticleById(@Param("aids") Long[] aids);

    List<Article> getAllArticles();

    PageInfo getArticlesByPage(int pageNum, int pageSize);

    int deleteArticle(Long aids);

    List<Article> getArticleByCid(Long cid);

    PageInfo getArticleByCidPage(Long cid,int pageNum, int pageSize);
}
