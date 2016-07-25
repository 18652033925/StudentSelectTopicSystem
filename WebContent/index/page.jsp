<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="org.ssts.entity.TopicInfo"%>
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul class="pagination">
		<%
			int p = (int) request.getAttribute("page");
			int num = 20; //一页显示20条
			int count = (int) request.getAttribute("num");
			int pageCount = count / num + 1; //计算有共有多少页
			if (p != 1) {
				out.print("<li><a href='index_all.action?page=" + (p - 1) + "'>上一页</a></li>");
			}
			for (int i = 1; i <= pageCount; i++) {
				if (i == p) {
					out.print("<li><a href='index_all.action?page=" + i + "' style='background-color: #ccc;'>" + i + "</a></li>");
					continue;
				}
				out.print("<li><a href='index_all.action?page=" + i + "'>" + i + "</a></li>");
			}
			if (p != pageCount) {
				out.print("<li><a href='index_all.action?page=" + (p + 1) + "'>下一页</a></li>");
			}
		%>
	</ul>
</body>
</html>