<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	
</head>
<body>

	<form action="register" method="post">
		<table>
			<tr>
				<th>姓名：</th>
				<th scope="col"><input type="text" name="username"></th>
			</tr>
			<tr>
				<th scope="col">密码：</th>
				<th scope="col"><input type="password" name="userpassword">
				</th>
			</tr>
			<tr>
				<th><input type="submit" value="注册" name="submit"></th>
			</tr>
		</table>
	</form>

	<a href="toLogin">返回登录</a>
</body>
</html>
