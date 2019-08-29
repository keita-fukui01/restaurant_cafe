<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
import="restaurant_cafe.bean.ItemBean"
import="restaurant_cafe.util.NumberFormatUtility"
import="restaurant_cafe.util.PropertyLoader"%>

<%	ItemBean item = (ItemBean) request.getAttribute("item"); %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>編集</title>
<link href="css/editItem.css" rel="stylesheet" type="text/css">

<!--
<script>
function MoveCheck() {
    if( confirm("本当に削除してもよいですか?") ) {
        window.location.href = "https://www.nishishi.com/";
    }
    else {
        alert("キャンセルしました。");
    }
}
</script>
 -->

</head>
<body>
<div id="title">
<h1>編集</h1>
</div>

<div id="title_caption">
<caption>編集内容を選択してください。</caption>
</div>
<div id="waku">
<table>
<tr>
<th>日付</th>
<td><% out.println(item.getYear() + "年" + item.getMonth() + "月" + item.getDay() + "日"); %></td>
<tr>
<th>時間</th>
<td><% out.println(item.getTime() + "時" + item.getMinutes() + "分"); %></td>
<tr>
<th>コース</th>
<td><%=item.getCourse()%></td>
<tr>
<th>名前</th>
<td><%=item.getName()%></td>
<tr>
<th>メール</th>
<td><%=item.getMail() %></td>
<tr>
<th>電話番号（固定）</th>
<td><%=item.getPhoneNumber() %></td>
<tr>
<th>電話番号（携帯）</th>
<td><%=item.getCellphoneNumber() %></td>
<tr>
<th>性別</th>
<td><%=item.getGender() %></td>
</table>
</div>

<div id="title_waku">
<table>
<tr>
<td><a href="<%=PropertyLoader.getProperty("url.servlet.ItemUpdate") %>?id=<%=item.getId() %>">更新</a></td>
<!-- <td><a href="<%=PropertyLoader.getProperty("url.servlet.ItemDeletion") %>?id=<%=item.getId() %>">削除</a></td> -->
<td><a href="<%=PropertyLoader.getProperty("url.servlet.Validator02") %>?id=<%=item.getId() %>">削除</a></td>
</tr>
<tr>
<td><a href="<%=PropertyLoader.getProperty("url.servlet.ItemManager") %>">戻る</a></td>
</tr>
</table>
</div>
</body>

</html>