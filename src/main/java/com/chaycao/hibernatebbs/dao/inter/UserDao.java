package com.chaycao.hibernatebbs.dao.inter;

import com.chaycao.hibernatebbs.bean.User;

/**
 * Created by chayc on 2017/9/11.
 */
public interface UserDao extends BaseDao<User> {

    public User getByNamePassword (String name, String password);

}
