package com.chaycao.hibernatebbs.servlet;

import com.chaycao.hibernatebbs.bean.Article;
import com.chaycao.hibernatebbs.control.impl.ArticleControlImpl;
import com.chaycao.hibernatebbs.control.inter.ArticleControlInter;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by chaycao on 2017/7/9.
 *
 * 显示文章列表
 */
@WebServlet(name="toArticleList"
        , urlPatterns = "/toArticleList")
public class ToArticleListServlet extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        BeanFactory factory = new ClassPathXmlApplicationContext("applicationContext-common.xml");
        ArticleControlInter articleControl = (ArticleControlInter)factory.getBean("articleControl");

        request.setCharacterEncoding("utf-8");
        List<Article> articleList = articleControl.listAll();
        request.getSession().setAttribute("articleList", articleList);
        request.setAttribute("articleList", articleList);
        request.getRequestDispatcher("/articleList.jsp").forward(request, response);
    }
}
