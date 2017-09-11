package com.chaycao.hibernatebbs.servlet;

import com.chaycao.hibernatebbs.bean.User;
import com.chaycao.hibernatebbs.control.impl.UserControlImpl;
import com.chaycao.hibernatebbs.control.inter.UserControlInter;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by chaycao on 2017/7/9.
 */
@WebServlet(name="regster"
            , urlPatterns = "/register")
public class RegisterServlet extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        BeanFactory factory = new ClassPathXmlApplicationContext("applicationContext-common.xml");
        UserControlInter userControl = (UserControlInter) factory.getBean("userControl");

        request.setCharacterEncoding("utf-8");
        String userName = request.getParameter("username");
        String userPassword = request.getParameter("userpassword");
        User user = new User(userName, userPassword);
        if (userControl.register(user) == true){ //注册成功
            System.out.println("注册成功");
            request.getRequestDispatcher("/toLogin").forward(request, response);
        } else {
            System.out.println("注册失败");
        }
    }
}
