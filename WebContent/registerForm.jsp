<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.List"
import="java.util.ListIterator"
import="restaurant_cafe.bean.ResBean"
import="restaurant_cafe.util.Cast"%>

<%
String year = (String)request.getAttribute("year");
String month = (String)request.getAttribute("month");
String day = (String)request.getAttribute("day");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>予約</title>
<link href=" css/registerForm.css" rel=" stylesheet" type="text/css">
</head>
<body>

<% String[] errorMessages = (String[])request.getAttribute("errorMessages");
if (errorMessages != null) { %>
<ul>
<% for (int i = 0; i < errorMessages.length; i++) {
if (errorMessages[i] != null) { %>
<li><%=errorMessages[i] %></li>
<% }
} %>
</ul>
<% } %>

<div id="title"><h1>予約</h1></div>

<form method="post" action="/restaurant_cafe/Validator">

<div id="waku">
<table>
<tr>

<th>日時</th>
<td>
<select name="year">
<option value="">選択</option>
<%
for(int i = 2019; i <= 2030; i++){
	out.println("<option value=" + i +">" + i +"</option>");
}
%>
</select> 年

<select name="month">
<option value="">選択</option>
<%
for(int i = 1; i <= 12; i++){
	out.println("<option value=" + i +">" + i +"</option>");
}
%>
</select> 月

<select name="day">
<option value="">選択</option>
<%
for(int i = 1; i <= 31; i++){
	out.println("<option value=" + i + ">" + i + "</option>");
}
%>
</select> 日
</td>
</tr>

<tr>
<th>時間</th>
<td>
<select name="time">
<option value="">選択</option>
<%
for(int i = 10; i <= 21; i++){
	out.println("<option value=" + i +">" + i +"</option>");
}
%>
</select> 時

<select name="minutes">
<option value="">選択</option>
<option value="00">00</option>
<option value="15">15</option>
<option value="30">30</option>
<option value="45">45</option>
</select> 分

<tr>
<th>コース</th>
<td>
<select name="course">
<option value="">選択</option>
<option value="スペシャルコース">スペシャルコース</option>
<option value="ランチコース">ランチコース</option>
<option value="席のみ">席のみ</option>
</select>

<tr>
<th>氏名</th>
<td><input type="text" name="name"
         value="${errorMessages[0] == null ? param.name : ""}"></td>
<tr>
<th>メールアドレス</th>
<td><input type="text" name="mail"
         value="${errorMessages[2] == null ? param.mail : ""}"></td>
</tr>

<!--
<tr>
<td>メールアドレス（確認用）</td>
<td><input type="text" name="mailForCheck"
         value="${errorMessages[3] == null ? param.mailForCheck : ""}"></td>
</tr>
-->

<tr>
<th>電話番号（固定）</th>
<td><input type="text" name="phoneNumber"
         value="${errorMessages[4] == null ? param.phoneNumber : ""}"></td>
</tr>
<tr>
<th>電話番号（携帯）</th>
<td><input type="text" name="cellphoneNumber"
         value="${errorMessages[5] == null ? param.cellphoneNumber : ""}"></td>
</tr>

<tr>
<th>性別</th>
<td>
<input type="radio" name="gender" value="男性"
         ${param.gender == "男性" ? "checked" : ""}>男性&nbsp;
<input type="radio" name="gender" value="女性"
         ${param.gender == "女性" ? "checked" : ""}>女性
</td>
</tr>
</table>
</div>

<div id="title_waku">
<dl>
<dd><input type="submit" value="決定" id="btn_back"></dd>
<p>
<dd><div id="btn_submit"><a href="restaurant_cafe.html">戻る</a></div></dd>
</dl>
</div>
</form>
</body>
</html>