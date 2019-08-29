<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
import="restaurant_cafe.bean.ItemBean"
import="restaurant_cafe.util.PropertyLoader"%>

<%	ItemBean item = (ItemBean) request.getAttribute("item"); %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>編集</title>
<link href="css/updateItem.css" rel="stylesheet" type="text/css">
</head>
<body>

<div id="title"><h1>編集</h1></div>
<form method="get" action="<%=PropertyLoader.getProperty("url.servlet.ItemUpdate2") %>">

<div id="waku">
<table>
<caption>変更する項目を上書きしてください。</caption>
<tr>
<th>ID</th>
<td><input type="text" name="id" value="<%=item.getId() %>"></td>

<tr>
<th>日付</th>
<td><input type="text" name="year" size="3" value="<%=item.getYear() %>">年
<input type="text" name="month" size="3" value="<%=item.getMonth() %>">月
<input type="text" name="day" size="3" value="<%=item.getDay() %>">日
</td>

<tr>
<th>時間</th>
<td>
<input type="text" name="time" size="3" value="<%=item.getTime() %>">時
<input type="text" name="minutes" size="3" value="<%=item.getMinutes() %>">分
</td>

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
<td><input type="text" name="name" value="<%=item.getName() %>"></td>
<tr>
<th>メールアドレス</th>
<td><input type="text" name="mail" value="<%=item.getMail() %>"></td>
<tr>
<th>電話番号（固定）</th>
<td><input type="text" name="phoneNumber" value="<%=item.getPhoneNumber() %>"></td>
<tr>
<th>電話番号（携帯）</th>
<td><input type="text" name="cellphoneNumber" value="<%=item.getCellphoneNumber() %>"></td>
<tr>
<th>性別</th>
<td><input type="text" name="gender" value="<%=item.getGender()%>"></td>
<tr>
</table>
</div>
<!--
<input type="radio" name="gender" value="男性"
         ${param.gender == "男性" ? "checked" : ""}>男性&nbsp;
<input type="radio" name="gender" value="女性"
         ${param.gender == "女性" ? "checked" : ""}>女性
 -->
<div id="btn_submit_btn_back">
<dl>
<dd><p><input type="submit" value="更新" id="btn_submit"></p></dd>
<dd><div id="btn_back"><a href="<%=PropertyLoader.getProperty("url.servlet.ItemManager") %>">戻る</a></div></dd>
</dl>
</div>

<input type="hidden" name="oldId" value="<%=item.getId() %>">

</form>
</body>
</html>