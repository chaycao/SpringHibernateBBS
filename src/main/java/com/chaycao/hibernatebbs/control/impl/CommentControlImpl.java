package com.chaycao.hibernatebbs.control.impl;

import com.chaycao.hibernatebbs.bean.Article;
import com.chaycao.hibernatebbs.bean.Comment;
import com.chaycao.hibernatebbs.control.inter.CommentControlInter;
import com.chaycao.hibernatebbs.dao.inter.CommentDao;

import java.util.List;

/**
 * Created by chaycao on 2017/7/11.
 */
public class CommentControlImpl implements CommentControlInter {

    public CommentControlImpl() {}

    private CommentDao commentDao;

    public CommentDao getCommentDao() {
        return commentDao;
    }

    public void setCommentDao(CommentDao commentDao) {
        this.commentDao = commentDao;
    }

    /**
     * 添加评论
     * @param comment
     * @return
     */
    public boolean save(Comment comment) {
        if (((Integer)commentDao.save(comment)).intValue() > 0)
            return true;
        else
            return false;
    }

    /**
     * 根据文章查询所有的评论
     * @param article
     * @return
     */
    public List<Comment> listByArticle(Article article) {
        return commentDao.listByArticle(article);
    }
}
