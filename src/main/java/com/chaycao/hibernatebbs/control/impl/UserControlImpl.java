package com.chaycao.hibernatebbs.control.impl;

import com.chaycao.hibernatebbs.bean.User;
import com.chaycao.hibernatebbs.control.inter.UserControlInter;
import com.chaycao.hibernatebbs.dao.inter.UserDao;

/**
 * Created by chaycao on 2017/7/26.
 */
public class UserControlImpl implements UserControlInter {

    public UserControlImpl() {}

    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * 注册
     * @param user
     * @return
     */
    public boolean register(final User user) {
        if (((Integer)userDao.save(user)).intValue() > 0)
            return true;
        else
            return false;
    }

    /**
     * 登录
     * @param userName
     * @param userPassword
     * @return
     */
    public User login(final String userName, final String userPassword) {
        return userDao.getByNamePassword(userName, userPassword);
    }

    public static void main(String[] args) {
        System.out.println(new UserControlImpl().login("cy", "cy").getUserName());
    }
}
