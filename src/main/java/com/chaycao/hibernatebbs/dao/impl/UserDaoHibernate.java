package com.chaycao.hibernatebbs.dao.impl;

import com.chaycao.hibernatebbs.bean.User;
import com.chaycao.hibernatebbs.dao.inter.UserDao;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by chayc on 2017/7/27.
 */
@Transactional
public class UserDaoHibernate extends BaseDaoHibernate<User> implements UserDao {

    public UserDaoHibernate() {
    }

    /**
     * 通过 name,password 查询用户
     * @param name
     * @param password
     * @return
     */
    public User getByNamePassword (String name, String password) {
        String hql = "FROM com.chaycao.hibernatebbs.bean.User u " +
                "where u.userName = ?0 and u.userPassword = ?1 ";
        List<User> list = find(hql, name, password);
        if (list != null && list.size() == 1)
        {
            return (User)list.get(0);
        }
        return null;
    }
}
