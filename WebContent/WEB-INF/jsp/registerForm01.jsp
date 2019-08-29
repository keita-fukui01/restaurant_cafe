<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.List"
import="java.util.ListIterator"
import="restaurant_cafe.bean.ResBean"
import="restaurant_cafe.util.Cast"%>

<%
String name = (String)request.getAttribute("name");
String mail = (String)request.getAttribute("mail");
String course = (String)request.getAttribute("course");
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
<title>予約確認</title>
</head>
<link href=" css/registerForm01.css" rel=" stylesheet" type="text/css">
<body>
<div id="title">
<p>
<h2>
この内容で、よろしければ、
下記の「決定」ボタンを
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
session.setAttribute("mail", mail);
session.setAttribute("course", course);
session.setAttribute("phoneNumber", phoneNumber);
session.setAttribute("cellphoneNumber", cellphoneNumber);
session.setAttribute("gender", gender);
session.setAttribute("year", year);
session.setAttribute("month", month);
session.setAttribute("day", day);
session.setAttribute("time", time);
session.setAttribute("minutes", minutes);
%>
<!-- <form method="post" action="/restaurant_cafe/ItemInsertion2">
<input type="submit" value="予約決定"></form>
<br>
<hr>
<br>
<form method="get" action="registerForm.jsp">
<input type="submit" value="戻る"></form>
 -->

 <div id="title_waku">
<form method="post" action="/restaurant_cafe/ItemInsertion2">
<dl>
<dd><input type="submit" value="決定" id="btn_back"></dd>
<p>
<dd><div id="btn_submit"><a href="registerForm.jsp">戻る</a></div></dd>
</dl>
</form>
</div>
</body>
</html>