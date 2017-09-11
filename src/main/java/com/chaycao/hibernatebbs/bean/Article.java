package com.chaycao.hibernatebbs.bean;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by chaycao on 2017/7/26.
 */
@Entity
@Table(name = "article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "context")
    private String context;

    @Column(name = "time")
    private Date time;

    @ManyToOne(cascade=CascadeType.MERGE,fetch=FetchType.EAGER,optional=true)
    @JoinColumn(name = "user_id")
    private User user;

    //-------------------Constructor-----------------------------//
    public Article() {
    }

    public Article(String title, String context, Date time, User user) {
        this.title = title;
        this.context = context;
        this.time = time;
        this.user = user;
    }

    //-------------------Get & Set-----------------------------//
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

}
