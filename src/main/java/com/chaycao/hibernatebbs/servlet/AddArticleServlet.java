package com.chaycao.hibernatebbs.servlet;

import com.chaycao.hibernatebbs.bean.Article;
import com.chaycao.hibernatebbs.bean.User;
import com.chaycao.hibernatebbs.control.impl.ArticleControlImpl;
import com.chaycao.hibernatebbs.control.inter.ArticleControlInter;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

/**
 * Created by chaycao on 2017/7/9.
 *
 * 发表新文章
 */
@WebServlet(name="addArticle"
        , urlPatterns = "/addArticle")
public class AddArticleServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        BeanFactory factory = new ClassPathXmlApplicationContext("applicationContext-common.xml");
        ArticleControlInter articleControl = (ArticleControlInter)factory.getBean("articleControl");

        request.setCharacterEncoding("utf-8");
        String title = request.getParameter("title");
        String comment = request.getParameter("comment");
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        Article article = new Article(title, comment, new Date(System.currentTimeMillis()), user);
        if (articleControl.save(article)) {
            System.out.println("发表成功");
            response.sendRedirect("articleAddSuccess.jsp");
        } else {
            System.out.println("发表失败");
            response.sendRedirect("articleAddFail.jsp");
        }
    }
}
