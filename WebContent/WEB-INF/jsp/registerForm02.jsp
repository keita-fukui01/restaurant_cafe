<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.List"
import="java.util.ListIterator"
import="restaurant_cafe.bean.ResBean"
import="restaurant_cafe.util.PropertyLoader"
import="restaurant_cafe.util.Cast"%>

<%
String name = (String)request.getAttribute("name");
String course = (String)request.getAttribute("course");
String mail = (String)request.getAttribute("mail");
String phoneNumber = (String)request.getAttribute("phoneNumber");
String cellphoneNumber = (String)request.getAttribute("cellphoneNumber");
String gender = (String)request.getAttribute("gender");
String year = (String)request.getAttribute("year");
String month = (String)request.getAttribute("month");
String day = (String)request.getAttribute("day");
String time = (String)request.getAttribute("time");
String minutes = (String)request.getAttribute("minutes");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>追加確認</title>
</head>
<link href=" css/registerForm02.css" rel=" stylesheet" type="text/css">
<body>
<div id="title">
<p>
<h2>
この内容で、よろしければ、
下記の「追加」ボタンを
押して下さい。
</h2>
</div>
<div id="waku">
<table>
<caption>${message }</caption>
<tr>
<th>日付</th>
<td><% out.println(year + "年" + month + "月" + day + "日"); %></td>
</tr>
<tr>
<th>時間</th>
<td><% out.println(time + "時" + minutes + "分"); %></td>
</tr>
<tr>
<th>コース</th>
<td><%= course %></td>
</tr>
<tr>
<th>名前</th>
<td><%= name %></td>
</tr>
<tr>
<th>メールアドレス</th>
<td><%= mail %></td>
</tr>
<tr>
<th>電話番号（固定）</th>
<td><%= phoneNumber %></td>
</tr>
<tr>
<th>電話番号（携帯）</th>
<td><%= cellphoneNumber %></td>
</tr>
<tr>
<th>性別</th>
<td><%= gender %></td>
</tr>
</table>
</div>
<%
session.setAttribute("name", name);
session.setAttribute("course", course);
session.setAttribute("mail", mail);
session.setAttribute("phoneNumber", phoneNumber);
session.setAttribute("cellphoneNumber", cellphoneNumber);
session.setAttribute("gender", gender);
session.setAttribute("year", year);
session.setAttribute("month", month);
session.setAttribute("day", day);
session.setAttribute("time", time);
session.setAttribute("minutes", minutes);
%>

<div id="title_waku">
<form method="post" action="/restaurant_cafe/ItemInsertion3">
<dl>
<dd><input type="submit" value="追加" id="btn_back"></dd>
</form>
<p>
<form method="get" action="registerForm.jsp">
<dd><input type="submit" value="戻る" id="btn_submit"></dd>
</dl>
</form>
</div>
</html>