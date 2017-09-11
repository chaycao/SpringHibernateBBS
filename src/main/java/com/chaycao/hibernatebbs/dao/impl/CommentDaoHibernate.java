package com.chaycao.hibernatebbs.dao.impl;

import com.chaycao.hibernatebbs.bean.Article;
import com.chaycao.hibernatebbs.bean.Comment;
import com.chaycao.hibernatebbs.dao.inter.CommentDao;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by chayc on 2017/7/27.
 */
@Transactional
public class CommentDaoHibernate extends BaseDaoHibernate<Comment> implements CommentDao {

    public CommentDaoHibernate() {
    }

    public List<Comment> listByArticle(Article article) {
        String hql = "From com.chaycao.hibernatebbs.bean.Comment c " +
                "where c.article = ?0";
        return find(hql, article);
    }

}
