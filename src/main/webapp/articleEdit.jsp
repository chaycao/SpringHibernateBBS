<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

</head>

<body>


    用户名：${sessionScope.user.userName}<br>
    <a href="toArticleList">返回</a>
    <form action="addArticle" method="post">
        <table>
            <tr>
                <th>标题：</th>
                <input type="text" name="title">
            </tr>
            <tr>
                <th>内容：</th>
                <th><textarea name="comment" cols="30" rows="10">请在此输入内容...</textarea></th>
            </tr>
            <tr>
                <input type="submit" value="发表" name="submit">
            </tr>
        </table>
    </form>

</body>
</html>
