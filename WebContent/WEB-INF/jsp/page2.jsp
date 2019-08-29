<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//HTTP1.0用のキャッシュを無効にする
response.setHeader("pragma", "no-cache");
//HTTP1.1用のキャッシュを無効にする
response.setHeader("Cache-Control", "no-cache");
//プロキシサーバのキャッシュを無効にする
response.setDateHeader("Expires", 0);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ページ2</title>
</head>
<body>
<h1>ページ2</h1>
<p>${id}さんはログインしています。</p>
<p><a href="/restaurant_cafe/page1.jsp">エラー</a></p>
<p><a href="/restaurant_cafe/Logout">ログアウト</a></p>
</body>
</html>