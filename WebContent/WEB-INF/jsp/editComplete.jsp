<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
import="restaurant_cafe.bean.ItemBean"
import="restaurant_cafe.util.NumberFormatUtility"
import="restaurant_cafe.util.PropertyLoader"
import="restaurant_cafe02.ItemManager"%>
<%	ItemBean item = (ItemBean) request.getAttribute("item"); %>

<%
String id = (String)request.getAttribute("id");
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
<title>更新</title>
<link href="css/editComplete.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="title">
<h1>更新</h1>
<div id="waku">
<table>
<caption>${message }</caption>
<tr>
<th id="year_month">日付</th>
<td><% out.println(item.getYear() + "年" + item.getMonth() + "月" + item.getDay() + "日"); %></td>
<tr>
<th id="time_minutes">時間</th>
<td><% out.println(item.getTime() + "時" + item.getMinutes() + "分"); %></td>
<tr>
<th id="course">コース</th>
<td><%=item.getCourse()%></td>
<tr>
<th id="name">名前</th>
<td><%=item.getName()%></td>
<tr>
<tr>
<th id="mail">メール</th>
<td><%=item.getMail() %></td>
<tr>
<th id="phoneNumber">電話番号（固定）</th>
<td><%=item.getPhoneNumber() %></td>
<tr>
<th id="cellphoneNumber">電話番号（携帯）</th>
<td><%=item.getCellphoneNumber() %></td>
<tr>
<th id="gender">性別</th>
<td><%=item.getGender() %></td>
</tr>
</div>
<%
session.setAttribute("id", id);
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
</table>
</div>
<dl>
<dd><div id="btn_back"><a href="<%=PropertyLoader.getProperty("url.servlet.ItemManager") %>">予約一覧</a></div></dd>
</dl>
</body>
</html>