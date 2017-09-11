<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

</head>

<body>
    用户名：${sessionScope.user.userName}<br>
    <a href="toArticleList">返回</a>
    <div>
        <table>
            <tr>
                <th>标题：</th>
                <th>${title}</th>
            </tr>
            <tr>
                <th>作者：</th>
                <th>${userName}</th>
            </tr>
            <tr>
                <th>发表时间：</th>
                <th>${time}</th>
            </tr>
        </table>
        ${context}
    </div>


    <div>
        评论区：<br>
        <c:forEach items="${commentList}" var="comment">
            <tr>
                <th>${comment.user.userName}:${comment.context}</th>
            </tr>
            <tr>
                <th>${comment.time}</th>
            </tr>
            <br>
        </c:forEach>
    </div>

    <div>
        <form name="addComment" action="addComment" method="post">
            <table>
                <tr>
                    <textarea name="context" rows="2" cols="30">请输入评论...</textarea>
                </tr>
                <!-- 文章的ID -->
                <input type="hidden" name="index"  value="${index}">
                <tr>
                    <input type="submit" name="submit" value="提交">
                </tr>
            </table>
        </form>

    </div>

</body>
</html>
