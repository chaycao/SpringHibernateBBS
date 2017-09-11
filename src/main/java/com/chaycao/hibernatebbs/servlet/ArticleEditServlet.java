package com.chaycao.hibernatebbs.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by chaycao on 2017/7/9.
 *
 * 登录验证用户信息
 * 若成功，则把用户信息保存到session中，跳转到文章列表上
 * 若失败，则保留在登录页面
 */
@WebServlet(name="articleEdit"
        , urlPatterns = "/articleEdit")
public class ArticleEditServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        request.getRequestDispatcher("toArticleEdit").forward(request, response);
    }
}
