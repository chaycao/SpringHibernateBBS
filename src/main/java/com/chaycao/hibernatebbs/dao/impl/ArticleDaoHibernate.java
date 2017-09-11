package com.chaycao.hibernatebbs.dao.impl;

import com.chaycao.hibernatebbs.bean.Article;
import com.chaycao.hibernatebbs.dao.inter.ArticleDao;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by chayc on 2017/7/27.
 */
@Transactional
public class ArticleDaoHibernate extends BaseDaoHibernate<Article> implements ArticleDao {
    public ArticleDaoHibernate() {
    }
}
