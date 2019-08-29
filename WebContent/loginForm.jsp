<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//HTTP1.0用のキャッシュを無効にする
response.setHeader("pragma", "no-cache");
//HTTP1.1用のキャッシュを無効にする
response.setHeader("Cache-Control", "no-cache");
response.setDateHeader("Expires", 0);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ログイン</title>
<link href=" css/loginForm.css" rel=" stylesheet" type="text/css">
</head>
<body>
<div id="waku">
<div id="title">
<h1>管理者</h1>
</div>
<ul>
<% if (session.getAttribute("status") == "logout") { %>
<li>ログインに失敗しました。</li>
<% }
session.invalidate(); %>
<li>IDを入力してください。</li>
<li>パスワードを入力してください。</li>
</ul>
<form method="post" action="/restaurant_cafe/PasswordAuthenticaiton">
<table>
<tr>
<td>ID</td>
<td><input type="text" name="id"></td>
</tr>
<tr>
<td>パスワード</td>
<td><input type="password" name="password"></td>
</tr>
<tr>
<td>&nbsp;</td>
<td><input type="submit" value="ログイン"></td>
</tr>
</table>
</form>
</div>
</body>
</html>