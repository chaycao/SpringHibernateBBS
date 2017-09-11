package com.chaycao.hibernatebbs.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by chaycao on 2017/7/12.
 *
 * 跳转到articleEdit.jsp页面上
 */
@WebServlet(name="toArticleEdit"
        , urlPatterns = "/toArticleEdit")
public class ToArticleEditServlet extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("articleEdit.jsp").forward(request, response);
    }
}
