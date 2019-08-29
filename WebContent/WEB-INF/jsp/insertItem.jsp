<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
import="restaurant_cafe.util.PropertyLoader"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>追加</title>
<link href="css/insertItem.css" rel="stylesheet" type="text/css">
</head>

<body>
<div id="title"><h1>予約追加</h1>
</div>
<form method="get" action="<%=PropertyLoader.getProperty("url.servlet.Validator01") %>">
<div id="title_caption">
<caption>「名前」・「メールアドレス」・「電話番号」・「性別」を入力してください。</caption>
</div>
<div id="waku">
<table>
<tr>
<th>日付</th>
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
	out.println("<option value=" + i +">" + i +"</option>");
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
</td>
</tr>
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
<th>名前</th>
<td><input type="text" name="name"></td>
</tr>
<tr>
<th>メールアドレス</th>
<td><input type="text" name="mail"></td>
</tr>
<tr>
<th>電話番号（固定）</th>
<td><input type="text" name="phoneNumber"></td>
</tr>
<tr>
<th>電話番号（携帯）</th>
<td><input type="text" name="cellphoneNumber"></td>
</tr>
<tr>
<th>性別</th>
<td>
<input type="radio" name="gender" value="男性"${param.gender == "男性" ? "checked" : ""}>男性&nbsp;
<input type="radio" name="gender" value="女性"${param.gender == "女性" ? "checked" : ""}>女性
</tr>
</table>
</div>
<div id="title_waku">
<dl>
<dd><input type="submit" value="追加" id="btn_back"></dd>
<p>
<dd><div id="btn_submit"><a href="<%=PropertyLoader.getProperty("url.servlet.ItemManager") %>">戻る</a></div></dd>
</dl>
</div>

</form>
</body>
</html>