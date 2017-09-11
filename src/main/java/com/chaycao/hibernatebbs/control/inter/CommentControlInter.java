package com.chaycao.hibernatebbs.control.inter;


import com.chaycao.hibernatebbs.bean.Article;
import com.chaycao.hibernatebbs.bean.Comment;

import java.util.List;

/**
 * Created by chaycao on 2017/7/26.
 */
public interface CommentControlInter {

    /**
     * 添加评论
     * @param
     * @return
     */
    public boolean save(Comment comment);

    /**
     * 根据文章查询所有的评论
     * @param article
     * @return
     */
    public List<Comment> listByArticle(Article article);
}
