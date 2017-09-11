package com.chaycao.hibernatebbs.servlet;

import com.chaycao.hibernatebbs.bean.Article;
import com.chaycao.hibernatebbs.bean.Comment;
import com.chaycao.hibernatebbs.bean.User;
import com.chaycao.hibernatebbs.control.impl.ArticleControlImpl;
import com.chaycao.hibernatebbs.control.impl.CommentControlImpl;
import com.chaycao.hibernatebbs.control.inter.ArticleControlInter;
import com.chaycao.hibernatebbs.control.inter.CommentControlInter;
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
 * 发表评论
 * @Author Chaycao【chaycao@163.com】
 * @Date 2017/7/11 17:45
 */
@WebServlet(name="addComment"
        , urlPatterns = "/addComment")
public class AddCommentServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        BeanFactory factory = new ClassPathXmlApplicationContext("applicationContext-common.xml");
        CommentControlInter commentControl = (CommentControlInter) factory.getBean("commentControl");

        request.setCharacterEncoding("utf-8");
        String context = request.getParameter("context");
        int index  = Integer.parseInt(request.getParameter("index"));

        Article article = (Article) request.getSession().getAttribute("article");
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        Comment comment = new Comment(context, new Date(System.currentTimeMillis()), user, article);
        if (commentControl.save(comment)) {
            response.sendRedirect("toArticleContext?index=" + index);
        } else {
            response.sendRedirect("toArticleContext?index=" + index);
        }
    }
}
