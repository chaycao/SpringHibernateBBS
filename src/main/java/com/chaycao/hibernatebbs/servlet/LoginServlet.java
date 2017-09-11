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
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by chaycao on 2017/7/9.
 *
 * 登录验证用户信息
 * 若成功，则把用户信息保存到session中，跳转到文章列表上
 * 若失败，则保留在登录页面
 */
@WebServlet(name="login"
        , urlPatterns = "/login")
public class LoginServlet extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        BeanFactory factory = new ClassPathXmlApplicationContext("applicationContext-common.xml");
        UserControlInter userControl = (UserControlInter) factory.getBean("userControl");

        request.setCharacterEncoding("utf-8");
        String userName = request.getParameter("username");
        String userPassword = request.getParameter("userpassword");
        User user = userControl.login(userName, userPassword);
        if (user != null){ //登录成功
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            session.setAttribute("userName", userName);
            request.getRequestDispatcher("/toArticleList").forward(request, response);
        } else {
            System.out.println("登录失败");
        }
    }
}
