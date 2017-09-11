package com.chaycao.hibernatebbs.control.inter;


import com.chaycao.hibernatebbs.bean.Article;
import com.chaycao.hibernatebbs.bean.User;

import java.util.Date;
import java.util.List;

/**
 * Created by chaycao on 2017/7/26.
 */
public interface ArticleControlInter {

    /**
     * 查询所有文章
     * @return
     */
    public List<Article> listAll();

    /**
     * 添加文章
     * @param article
     * @return
     */
    public boolean save(Article article);

}
