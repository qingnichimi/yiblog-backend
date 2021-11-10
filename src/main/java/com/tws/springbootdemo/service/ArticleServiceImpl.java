package com.tws.springbootdemo.service;

import cn.hutool.core.date.DateTime;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tws.springbootdemo.entity.Article;
import com.tws.springbootdemo.mapper.ArticleMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author taoweishu
 * @date 2021/10/29 - 22:52
 */
@Service
public class ArticleServiceImpl implements ArticleService{
    @Resource
    ArticleMapper articleMapper;
    @Override
    public int addNewArticle(Article article) {
        if(article.getSummary() == null || "".equals(article.getSummary())) {
            String strHtml = stripHtml(article.getHtmlContent());
            article.setSummary(strHtml.substring(0,strHtml.length() > 50 ? 50 : strHtml.length()));
        }
        if(article.getId() == -1) {
            if(article.getState() == 1) {
                article.setPublish_time(new DateTime());
            }
        }
        return articleMapper.addNewArticle(article);

    }
    public String stripHtml(String content) {
        content = content.replaceAll("<p .*?>", "");
        content = content.replaceAll("<br\\s*/?>", "");
        content = content.replaceAll("\\<.*?>", "");
        return content;
    }

    @Override
    public int updateArticle(Article article) {
        return 0;
    }

    @Override
    public Article getArticleById(Long aid) {
        return articleMapper.getArticleById(aid);
    }

    @Override
    public int deleteArticleById(Long[] aids) {
        return 0;
    }

    @Override
    public List<Article> getAllArticles() {
        return articleMapper.getAllArticles();
    }

    @Override
    public PageInfo getArticlesByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Article> allArticles = articleMapper.getAllArticles();
        PageInfo pageInfo = new PageInfo(allArticles);
        return pageInfo;
    }

    @Override
    public int deleteArticle(Long aids) {
        int result = 0;
        result = articleMapper.deleteArticle(aids);
        return result;
    }

    @Override
    public List<Article> getArticleByCid(Long cid) {
        List<Article> articles = articleMapper.getArticleByCid(cid);
        return articles;
    }

    @Override
    public PageInfo getArticleByCidPage(Long cid,int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Article> articles = articleMapper.getArticleByCid(cid);
        PageInfo pageInfo = new PageInfo(articles);
        return pageInfo;
    }
}

