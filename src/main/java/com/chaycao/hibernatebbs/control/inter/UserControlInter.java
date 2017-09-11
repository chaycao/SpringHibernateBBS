package com.chaycao.hibernatebbs.control.inter;


import com.chaycao.hibernatebbs.bean.User;

/**
 * Created by chaycao on 2017/7/9.
 */
public interface UserControlInter {
    /**
     * 注册
     * @param user
     * @return
     */
    public boolean register(final User user);

    /**
     * 登录
     * @param userName
     * @param userPassword
     * @return
     */
    public User login(final String userName, final String userPassword);

}
