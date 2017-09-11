package com.chaycao.hibernatebbs.bean;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by chaycao on 2017/7/26.
 */
@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "context")
    private String context;

    @Column(name = "time")
    private Date time;

    @ManyToOne(cascade=CascadeType.MERGE,fetch=FetchType.EAGER,optional=true)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade=CascadeType.MERGE,fetch=FetchType.EAGER,optional=true)
    @JoinColumn(name = "article_id")
    private Article article;

    //-------------------Constructor-----------------------------//
    public Comment() {
    }

    public Comment(String context, Date time, User user, Article article) {
        this.context = context;
        this.time = time;
        this.user = user;
        this.article = article;
    }

    //-------------------Get & Set-----------------------------//
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}
