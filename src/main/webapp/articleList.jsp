<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>

</head>

<body>
    用户名：${sessionScope.user.userName}<br/>
    <a href="toArticleEdit">写文章</a>
    <table border="1" >
        <tr>
            <td>标题</td>
            <td>发表时间</td>
            <td>作者</td>
        </tr>

        <c:set var="i" value="-1"/>
        <c:forEach items="${articleList}" var="article">
            <tr>
                <c:set var="i" value="${i+1}"/>
                <td><a href="toArticleContext?index=${i}"/> ${article.title} </td>
                <td>${article.time}</td>
                <td>${article.user.userName}</td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
