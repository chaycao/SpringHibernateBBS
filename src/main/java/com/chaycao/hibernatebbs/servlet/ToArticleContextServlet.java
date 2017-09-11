package com.chaycao.hibernatebbs.servlet;

import com.chaycao.hibernatebbs.bean.Article;
import com.chaycao.hibernatebbs.bean.Comment;
import com.chaycao.hibernatebbs.control.impl.ArticleControlImpl;
import com.chaycao.hibernatebbs.control.impl.CommentControlImpl;
import com.chaycao.hibernatebbs.control.inter.ArticleControlInter;
import com.chaycao.hibernatebbs.control.inter.CommentControlInter;
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
 * 显示文章内容
 */
@WebServlet(name="toArticleContext"
        , urlPatterns = "/toArticleContext")
public class ToArticleContextServlet extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        BeanFactory factory = new ClassPathXmlApplicationContext("applicationContext-common.xml");
        CommentControlInter commentControl = (CommentControlInter) factory.getBean("commentControl");

        List<Article> list = (List<Article>) request.getSession().getAttribute("articleList");

        request.setCharacterEncoding("utf-8");
        String query = request.getQueryString();
        String[] reslut = query.split("=");
        int index = Integer.parseInt(reslut[1]);
        request.setAttribute("index", index);
        Article article = list.get(index);
        request.getSession().setAttribute("article", article);
        request.setAttribute("title", article.getTitle());
        request.setAttribute("userName", article.getUser().getUserName());
        request.setAttribute("time", article.getTime());
        request.setAttribute("context", article.getContext());
        List<Comment> commentList = commentControl.listByArticle(article);
        request.setAttribute("commentList", commentList);
        // 转发
        request.getRequestDispatcher("/articleContext.jsp").forward(request, response);
    }
}
