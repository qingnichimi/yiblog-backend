package com.tws.springbootdemo.mapper;

import com.tws.springbootdemo.common.Page;
import com.tws.springbootdemo.entity.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author taoweishu
 * @date 2021/10/29 - 22:21
 */
@Mapper
public interface ArticleMapper {
    int addNewArticle(Article article);

    int updateArticle(Article article);

    Article getArticleById(Long aid);

    int deleteArticleById(@Param("aids") Long[] aids);

    List<Article> getAllArticles();

    int deleteArticle(Long aids);

    List<Article> getArticleByCid(Long cid);
}
