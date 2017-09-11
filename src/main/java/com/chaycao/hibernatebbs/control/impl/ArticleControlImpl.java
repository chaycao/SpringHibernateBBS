package com.chaycao.hibernatebbs.control.impl;

import com.chaycao.hibernatebbs.bean.Article;
import com.chaycao.hibernatebbs.control.inter.ArticleControlInter;
import com.chaycao.hibernatebbs.dao.inter.ArticleDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chaycao on 2017/7/27.
 */
public class ArticleControlImpl implements ArticleControlInter {

    public ArticleControlImpl() {}

    private ArticleDao articleDao;

    public ArticleDao getArticleDao() {
        return articleDao;
    }

    public void setArticleDao(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }


    /**
     * 查询所有文章
     * @return
     */
    public List<Article> listAll() {
        return articleDao.findAll(Article.class);
    }

    /**
     * 添加文章
     * @param article
     * @return
     */
    public boolean save(Article article) {
        if (((Integer)articleDao.save(article)).intValue() > 0)
            return true;
        else
            return false;
    }

}
