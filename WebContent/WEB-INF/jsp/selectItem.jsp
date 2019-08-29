<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
import="java.util.Iterator"
import="java.util.List"
import="restaurant_cafe.bean.ItemBean"
import="restaurant_cafe.util.Cast"
import="restaurant_cafe.util.NumberFormatUtility"
import="restaurant_cafe.util.PropertyLoader"
%>

<%
List<ItemBean> itemList = Cast.castList(request.getAttribute("itemList"));
Iterator<ItemBean> iterator = itemList.iterator();
int bookmark = Integer.parseInt((String) session.getAttribute("page"));
int maxPage = Integer.parseInt((String) session.getAttribute("maxPage"));
%>

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
<title>予約一覧</title>
<link href="css/selectItem.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="title">
<h1>予約一覧</h1>
</div>

<div id="sub_title">
<p>${id}様が、ログインしました。</p>
<p><div id="btn_back"><a href="/restaurant_cafe/Logout">ログアウト</a></div></p>
</div>

<div id="yoyau_waku">
<p><div id="btn_back"><a href="<%=PropertyLoader.getProperty("url.servlet.ItemInsertion") %>">予約追加</a></div></p>
</div>

<div id="all_title">
<table>
<!--  <caption>予約一覧</caption> -->
<tr>
<th id="id">ID</th>
<th id="year_month">日付</th>
<th id="time_minutes">時間</th>
<th id="course">コース</th>
<th id="name">名前</th>
<th id="mail">メールアドレス</th>
<th id="phoneNumber">電話番号（固定）</th>
<th id="cellphoneNumber">電話番号（携帯）</th>
<th id="gender">性別</th>
<th id=""></th>
</tr>
<%	while (iterator.hasNext()) {
ItemBean item = iterator.next();%>
<tr>
<td><%=item.getId()%></td>
<td><% out.println (item.getYear() + "年" + item.getMonth() + "月" +  item.getDay() + "日"); %></td>
<td><% out.println (item.getTime() + "時" + item.getMinutes() + "分"); %></td>
<td><%=item.getCourse()%></td>
<td><%=item.getName()%></td>
<td><%=item.getMail()%></td>
<td><%=item.getPhoneNumber()%></td>
<td><%=item.getCellphoneNumber()%></td>
<td><%=item.getGender()%></td>
<td><a href="<%=PropertyLoader.getProperty("url.servlet.ItemEditor")%>?id=<%=item.getId() %>">編集</a></td>
<%	}%>
<tr id="turnOver">
<td colspan="2">
<p id="next">
<%	if (bookmark < maxPage) { %>
<a href="<%=PropertyLoader.getProperty("url.servlet.ItemSelectorNext") %>">次へ</a>
<%	} else { %>
<span class="off">次へ</span>
<%	} %>
</p>
<p>
<%	if (bookmark > 1) { %>
<a href="<%=PropertyLoader.getProperty("url.servlet.ItemSelectorPrevious") %>">前へ</a>
</tr>
<%	} else { %>
<span class="off">前へ</span>
<%	} %>
</table>
</div>

<div id="search">
<form method="get" action="<%=PropertyLoader.getProperty("url.servlet.ItemSelector") %>">
<table>
	<tr>
	<td><u>検索</u></td>
	</tr>
	<tr>
	<th>名前で検索</th>
	</tr>
	<tr>
	<td><input type="text" name="name"></td>
	</tr>
	<tr>
	<th>電話番号（固定）</th>
	</tr>
	<tr>
	<td><input type="text" name="phoneNumber"></td>
	</tr>
	<tr>
	<th>電話番号（携帯）</th>
	</tr>
	<tr>
	<td><input type="text" name="cellphoneNumber"></td>
	</tr>
	<tr>
	<th>メールアドレス</th>
	</tr>
	<tr>
	<td><input type="text" name="mail"></td>
	</tr>
	<tr>
	<td><input type="submit" name="submit" value="検索"></td>
	</tr>
	<tr>
	<td><a href="<%=PropertyLoader.getProperty("url.servlet.ItemManager") %>">すべて表示</a></td>
	</tr>
</table>
</form>
</div>
</body>
</html>