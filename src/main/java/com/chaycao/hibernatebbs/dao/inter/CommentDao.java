package com.chaycao.hibernatebbs.dao.inter;

import com.chaycao.hibernatebbs.bean.Article;
import com.chaycao.hibernatebbs.bean.Comment;

import java.util.List;

/**
 * Created by chayc on 2017/9/11.
 */
public interface CommentDao extends BaseDao<Comment> {

    public List<Comment> listByArticle(Article article);

}

